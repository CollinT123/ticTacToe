public class Cell {
    private String contents;
    Cell(String cellNum){
        contents = cellNum;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
