public class TTTBoard {
    Cell[] board = new Cell[10];
     public String playerTurn;

    TTTBoard(String userWhoGoFirst){
        playerTurn = userWhoGoFirst;
        for(Integer i = 1; i < 10; i++) {
            board[i] = new Cell(Integer.toString(i));
        }
    }

    public void makeMove(int cellNum) throws TTTExceptions{
        if(board[cellNum].getContents().equals("X") || board[cellNum].getContents().equals("O")){
            throw new TTTExceptions("Please enter a valid space");
        }
        else{
            board[cellNum].setContents(playerTurn);
            if(playerTurn.equals("X")){
                playerTurn = "O";
            }
            else{
                playerTurn = "X";
            }
        }
    }

    @Override
    public String toString(){
        int cellNum = 1;
        String stringToReturn = "";
        for(int i = 0; i < 3; i++){
            for(int k = 0; k <2; k++){
                stringToReturn+=board[cellNum].getContents() + "|";
                cellNum++;
            }
            stringToReturn+=board[cellNum].getContents() + "\n";
            cellNum++;

        }
        return stringToReturn;
    }

    public String checkIfWin(){
        for(int i = 1; i < 9; i+=3){
            String rowWin = check3CellForWin(board[i], board[i+1], board[i+2]);
            if(rowWin!= null){
                return rowWin;
            }
        }
        for(int i=1; i < 4; i++){
            String collumWin = check3CellForWin(board[i], board[i+3], board[i+6]);
            if(collumWin!= null){
                return collumWin;
            }
        }
        String diagnolWin = check3CellForWin(board[1],board[5],board[9]);
        if(diagnolWin!=null){
            return diagnolWin;
        }
        diagnolWin = check3CellForWin(board[3],board[5],board[7]);
        if(diagnolWin!=null){
            return diagnolWin;
        }
        return null;
    }

    public String check3CellForWin(Cell cell1, Cell cell2, Cell cell3){
        if(cell1.getContents().equals("X") && cell2.getContents().equals("X") && cell3.getContents().equals("X")){
            return "X Wins!";
        }
        if(cell1.getContents().equals("O")&&cell2.getContents().equals("O")&&cell3.getContents().equals("O")){
            return "O Wins!";
        }
        return null;
    }

}
