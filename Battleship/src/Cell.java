public class Cell {
    private int row;
    private int col;
    private char status;

    //Cell constructor
    public Cell(int row, int col, char status){
        this.row = row;
        this.col = col;
        this.status = status;
    }

    //Gets the status of the cell
    public char get_status(){
        return status;
    }

    // changes the status of the cell
    public void set_status(char c){
        this.status = c;
    }

    //returns the x value
    public int get_xcord(){
        return row;
    }
    //returns the y value
    public int get_ycord(){
        return col;
    }
}
