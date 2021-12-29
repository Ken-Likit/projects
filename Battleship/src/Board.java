import java.util.Random;
import java.util.Scanner;

public class Board {
    Cell [][] board;
    Cell [][] bprivate;

    private int row;
    private int col;
    private int turns = 0;
    private Random random;
    private int boats;
    private int pp;

    //Board constructor
    public Board(int size){
        this.row = size;
        this.col = size;
        this.board = new Cell[size][size];
        this.bprivate = new Cell[size][size];
    }

    //Sets all the cells of the board to - status
    public void setCells(){
        for(int i = 0; i < row; i++){
            for(int j= 0; j < col; j++){
                board[i][j] = new Cell(i, j, '-');
                bprivate[i][j] = new Cell(i, j, '-');
            }
        }
    }
    //returns the number of turns so far
    public int getTurns(){
        return turns;
    }

    //adds a turn
    public void addTurn(){turns+=1;}

    //prints out the player board so far
    public void display(){
        String fin = "";
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char sta = board[i][j].get_status();
                String s = String.valueOf(sta);
                fin += s + " ";
            }
            fin += "\n";
        }
        System.out.println(fin);
    }
    //prints out the fully reveled board
    public void print(){
        String fin = "";
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char sta = bprivate[i][j].get_status();
                String s = String.valueOf(sta);
                fin += s + " ";
            }
            fin += "\n";
        }
        System.out.println(fin);
    }

    //handles the different cases while 'firing'
    public void fire(int x, int y){
        if(x < 0 || x > row-1 || y < 0 || y > row-1){
            addTurn();
            System.out.println("Out of bounds penalty");
            return;
        }
        char st = bprivate[x][y].get_status();

        if(st == 'B'){
            bprivate[x][y].set_status('H');
            board[x][y].set_status('H');
            System.out.println("Hit");
        }

        else if(st == '-'){
            bprivate[x][y].set_status('M');
            board[x][y].set_status('M');
            System.out.println("Miss");
        }

        else if (st == 'M' || st == 'H'){
            addTurn();
            System.out.println("Already guessed penalty");
        }

        }


    //places boats  in random spots with random orientations and makes sure the boats don't overlap
    //Also create a boat object
    public Boat placeBoats(int bsize){

        boolean check = false;
        Cell[] boat = new Cell[bsize];
        int x = 0;
        int y = 0;
        random = new Random();
        while(check == false) {
            boolean check1 = false;
            boolean ori = (Math.random() < 0.5);
            x = random.nextInt((row - bsize) + 1);
            y = random.nextInt((col - bsize) + 1);
            if(ori == true){
                for(int i = 0; i < bsize; i++){
                    boat[i] = bprivate[x+i][y];
                }
                for(int i = 0; i < boat.length; i++){
                    if(boat[i].get_status() == 'B'){
                        check1 = true;
                    }
                }
            }
            else{
                for(int i = 0; i < bsize; i++){
                    boat[i] = bprivate[x][y+i];
                }
                for(int i = 0; i < boat.length; i++){
                    if(boat[i].get_status() == 'B'){
                        check1 = true;
                    }
                }
            }
            if(check1 == false){
                check = true;
            }
        }
        for(int i = 0; i < bsize; i++){
            int xcor = boat[i].get_xcord();
            int ycor = boat[i].get_ycord();
            bprivate[xcor][ycor].set_status('B');
        }
        boats += 1;
        Boat b = new Boat(bsize, boat);
        return b;
    }
    //gets number of boats
    public int getBoats(){return boats;}
    //removes boat when sunk
    public void removeBoat(){boats -= 1;}

    //sets number of power points
    public void setPP(int x){pp = x;}
    //gets number of power points
    public int getPP(){return pp;}
    //removes one power point
    public void usePP(){pp -= 1;}

    //Missile power
    public void missile(int x, int y){
        if(x < 0 || x > row-1 || y < 0 || y > row-1){
            int cord[] = new int[2];
            System.out.println("Please enter a valid coordinate:");
            Scanner myScanner = new Scanner(System.in);
            String coordin = myScanner.nextLine();
            String coord[] = coordin.split(" ");
            for(int i = 0; i < coord.length; i++){
                cord[i] = Integer.parseInt((coord[i]));
            }
            missile(cord[0], cord[1]);
        }
        else {
            for (int i = -1; i < 2; i++) {
                for (int f = -1; f < 2; f++) {
                    int x1 = x  + i;
                    int y1 = y  + f;
                    if (x1 < 0 || x1 > row - 1 || y1 < 0 || y1 > row - 1) {
                        continue;
                    }
                    else{
                        char s = bprivate[x1][y1].get_status();
                        if(s == 'B' || s == 'H'){
                            board[x1][y1].set_status('H');
                            bprivate[x1][y1].set_status('H');
                        }
                        else{
                            board[x1][y1].set_status('M');
                            bprivate[x1][y1].set_status('M');
                        }
                    }
                }
            }
        }
    }

    //Drone power
    public void drone(){
        boolean ori = (Math.random() < 0.5);
        int ships = 0;
        if(ori == true){
            int ran = (int) (Math.random() * row);
            for(int i = 0; i < col; i++){
                char st = bprivate[ran][i].get_status();
                if(st == 'H' || st == 'B'){ships += 1;}
            }
            String fin = "Row " + ran + " has " + ships + " target(s).";
            System.out.print(fin);
        }
        else{
            int ran = (int) (Math.random() * row);
            for(int i = 0; i < col; i++){
                char st = bprivate[i][ran].get_status();
                if(st == 'H' || st == 'B'){ships += 1;}
            }
            String fin = "Col " + ran + " has " + ships + " target(s).";
            System.out.print(fin);
        }
    }

    //submarine power
    public boolean submarine(int x, int y){
        if(x < 0 || x > row-1 || y < 0 || y > row-1){
            int cord[] = new int[2];
            System.out.println("Please enter a valid coordinate:");
            Scanner myScanner = new Scanner(System.in);
            String coordin = myScanner.nextLine();
            String coord[] = coordin.split(" ");
            for(int i = 0; i < coord.length; i++){
                cord[i] = Integer.parseInt((coord[i]));
            }
            submarine(cord[0], cord[1]);
        }
        else{
            char st = bprivate[x][y].get_status();
            if(st == 'B' || st == 'H'){return true;}

        }
        return false;
    }

    public void setMiss(int x, int y){
        bprivate[x][y].set_status('M');
        board[x][y].set_status('M');
    }


}
