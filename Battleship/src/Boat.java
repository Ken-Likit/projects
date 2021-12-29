public class Boat {
    private int size;
    private boolean orientation;
    private Cell[] cord;
    private int remove;
    //Boat constructor
    public Boat(int bsize, Cell[] cord){
        size = bsize;
        this.cord = cord;
        remove = 1;
    }
    // Returns true if the boat is sunk
    public boolean getStatus(){
        boolean x = true;
        for(int i = 0; i < cord.length; i++){
            if(cord[i].get_status() != 'H'){
                x = false;
            }
        }
        return x;
    }

    public boolean removeBoat(){
        if(remove == 1){
            remove -= 1;
            return true;
        }
        else{return false;}
    }
    //Checks if hit by submarine
    public boolean check(int x, int y){
        for(int i = 0; i < cord.length; i++){
            int x1 = cord[i].get_xcord();
            int y1 = cord[i].get_ycord();
            if(x == x1 && y == y1){
                return true;
            }
        }
        return false;
    }

    //Hit by submarine and sets all to hit
    public void setHit(){
        for(int i = 0; i < cord.length; i++){
            cord[i].set_status('H');
        }
    }

}
