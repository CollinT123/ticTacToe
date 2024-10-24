import java.util.ArrayList;
import java.util.Random;
public class TTTAI {

    public int makeMove(TTTBoard mainBoard){
        boolean[] openSpace = new boolean[10];
        for(int i = 1; i < 10; i++){
            if(mainBoard.board[i].getContents() != "X" && mainBoard.board[i].getContents()!= "O"){
                openSpace[i] = true;
            }
        }
        int[] probabilityOfMoveWinning = new int[10];
        for(int i = 1; i < 10; i++){
            probabilityOfMoveWinning[i] = -99999;
        }
        for(int i = 1; i < 10; i++){
            if(openSpace[i]) {
                probabilityOfMoveWinning[i] = 0;
                try {
                    simulateBoard(mainBoard, i, probabilityOfMoveWinning, i);
                } catch (TTTExceptions e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        int moveIndex = 0;
        int chanceOfWinningToBeat = -99999;
        for(int i = 1; i < 10; i++){
            if(probabilityOfMoveWinning[i]>chanceOfWinningToBeat){
                moveIndex = i;
                chanceOfWinningToBeat = probabilityOfMoveWinning[i];
            }
        }
        return moveIndex;
    }

    public int simulateBoard(TTTBoard simBoard, int moveToMake, int[] probabilityOfMoveWinning, int indexOfProbabilityOfMoveWinning) throws TTTExceptions{
        TTTBoard simBoard2 = new TTTBoard(simBoard.playerTurn);
        for(int i = 1; i < 10; i++){
            simBoard2.board[i].setContents(simBoard.board[i].getContents());
        }
        simBoard2.makeMove(moveToMake);
        String whoWon = simBoard2.checkIfWin();
        if(whoWon!=null) {
            if (whoWon.equals("X Wins!")) {
                probabilityOfMoveWinning[indexOfProbabilityOfMoveWinning]--;
                return 1;
            }
            if (whoWon.equals("O Wins!")) {
                probabilityOfMoveWinning[indexOfProbabilityOfMoveWinning]++;
                return 1;
            }
        }
        int numOpenSpaces = 0;
        boolean[] openSpaces = new boolean[10];
        for(int i = 1; i < 10; i++){
            if(simBoard2.board[i].getContents().equals("X")||simBoard2.board[i].getContents().equals("O")){
                openSpaces[i] = false;
            }
            else{
                numOpenSpaces++;
                openSpaces[i] = true;
            }
        }
        if(numOpenSpaces == 0){
            return 1;
        }
        for(int i = 1; i < 10; i++){
            if(openSpaces[i]){
                if(simulateBoard(simBoard2, i, probabilityOfMoveWinning, indexOfProbabilityOfMoveWinning) == 1){
                    continue;
                }
            }
        }
        return 0;
    }
}
