import java.util.Scanner;
public class TicTacToeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Welcome to TicTacToe
                Would you like to play a friend or play the AI
                1) Play a friend
                2) Play the AI 
                """);
        boolean createGame = false;
        int userInput = 0;
        while (!createGame) {
            userInput = sc.nextInt();
            if (userInput == 1 || userInput == 2) {
                createGame = true;
            } else {
                System.out.println("Please enter a valid number");
            }
        }
        if (userInput == 1) {
            TicTacToe2Player();
        } else {
            PlayAgainstAI();
        }

    }

    private static void TicTacToe2Player() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Welcome to TicTacToe
                Would you like to be X's or O's
                Enter X or O""");
        boolean createGame = false;
        String userInput = "";
        while (!createGame) {
            userInput = sc.next();
            if(userInput.equals("X") || userInput.equals("O")){
                createGame = true;
            }
            else{
                System.out.println("Please enter a valid charecter");
            }
        }
        TTTBoard mainBoard = new TTTBoard(userInput);
        System.out.println(mainBoard.playerTurn + " please choose a space");
        System.out.print(mainBoard.toString());
        boolean endGame = false;
        int turnCount = 0;
        while(!endGame && turnCount < 9) {
            try {
                mainBoard.makeMove(sc.nextInt());
                String isThereWinner = mainBoard.checkIfWin();
                if(isThereWinner!=null){
                    System.out.println(isThereWinner);
                    endGame = true;
                    System.out.print(mainBoard.toString());
                    System.exit(0);
                }
                turnCount++;
            } catch (TTTExceptions e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println(mainBoard.playerTurn + " please choose a space");
                System.out.print(mainBoard.toString());
            }
        }
        System.out.println("It's a Tie!");
    }

    public static void PlayAgainstAI(){
        Scanner sc = new Scanner(System.in);
        TTTAI AI = new TTTAI();
        TTTBoard mainBoard = new TTTBoard("X");
        System.out.println(mainBoard.playerTurn + " please choose a space");
        System.out.print(mainBoard.toString());
        boolean endGame = false;
        int turnCount = 0;
        while (!endGame && turnCount < 9) {
            try {
                mainBoard.makeMove(sc.nextInt());
                String isThereWinner = mainBoard.checkIfWin();
                if (isThereWinner != null) {
                    System.out.println(isThereWinner);
                    endGame = true;
                    System.out.print(mainBoard.toString());
                    System.exit(0);
                }
                turnCount++;
            }
            catch (TTTExceptions e) {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println("AI is making move");
                try {
                    mainBoard.makeMove(AI.makeMove(mainBoard));
                    mainBoard.toString();
                }
                catch (TTTExceptions e) {
                    System.out.println(e.getMessage());
                }
                finally{
                    System.out.println(mainBoard.playerTurn + " please choose a space");
                    System.out.print(mainBoard.toString());
                }

            }
        }
    }
}
