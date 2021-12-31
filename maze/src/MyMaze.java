// Names: Kenneth Likit; Jackson Brandt
// x500s:likit004; bran1281

import java.util.Random;
import java.util.Scanner;

public class MyMaze {
    Cell[][] maze;
    int startRow;
    int endRow;
    int row;
    int col;

    public MyMaze(int rows, int cols, int startRow, int endRow) {
        maze = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = new Cell();
            }
        }
        this.startRow = startRow;
        this.endRow = endRow;
        this.row = rows;
        this.col = cols;
        maze[endRow][cols - 1].setRight(false);
    }

    /* TODO: Create a new maze using the algorithm found in the writeup. */
    public static MyMaze makeMaze(int level) {
        Random rand = new Random();
        if (level == 1) {
            int start = rand.nextInt(5);
            int end = rand.nextInt(5);
            MyMaze maze = new MyMaze(5, 5, start, end);
            Stack1Gen stack = new Stack1Gen<>();
            int rTemp = start;//temporary row pointer
            int cTemp = 0;// temporary col pointer
            stack.push(rTemp);
            stack.push(cTemp);
            while (!stack.isEmpty()) { //Checks for surrounding non visited cells
                int[][] neighbors = new int[4][2];//temp holder for non visited cells
                int count = 0;
                if (cTemp - 1 > -1) {
                    if (!maze.maze[rTemp][cTemp - 1].getVisited()) {
                        neighbors[count][0] = rTemp;
                        neighbors[count][1] = cTemp - 1;
                        count++;
                    }
                }
                if (rTemp - 1 > -1) {
                    if (!maze.maze[rTemp - 1][cTemp].getVisited()) {
                        neighbors[count][0] = rTemp - 1;
                        neighbors[count][1] = cTemp;
                        count++;
                    }
                }
                if (cTemp + 1 < 5) {
                    if (!maze.maze[rTemp][cTemp + 1].getVisited()) {
                        neighbors[count][0] = rTemp;
                        neighbors[count][1] = cTemp + 1;
                        count++;
                    }
                }
                if (rTemp + 1 < 5) {
                    if (!maze.maze[rTemp+1][cTemp].getVisited()) {
                        neighbors[count][0] = rTemp + 1;
                        neighbors[count][1] = cTemp;
                        count++;
                    }
                }
                if (count == 0) { //checks for dead end
                    cTemp = (int) stack.pop();
                    rTemp = (int) stack.pop();;
                } else { //randomly chooses next directions
                    int dir = rand.nextInt(count);
                    int rTemp3 = neighbors[dir][0];
                    int cTemp3 = neighbors[dir][1];
                    stack.push(rTemp3);
                    stack.push(cTemp3);
                    int rTemp1 = neighbors[dir][0];
                    int cTemp1 = neighbors[dir][1];
                    if (rTemp - rTemp1 == 1) {
                        rTemp = rTemp1;
                        maze.maze[rTemp][cTemp].setBottom(false);
                        maze.maze[rTemp][cTemp].setVisited(true);
                    } else if (rTemp - rTemp1 == -1) {
                        maze.maze[rTemp][cTemp].setBottom(false);
                        rTemp = rTemp1;
                        maze.maze[rTemp][cTemp].setVisited(true);
                    } else if (cTemp - cTemp1 == -1) {
                        maze.maze[rTemp][cTemp].setRight(false);
                        cTemp = cTemp1;
                        maze.maze[rTemp][cTemp].setVisited(true);
                    } else if (cTemp - cTemp1 == 1) {
                        cTemp = cTemp1;
                        maze.maze[rTemp][cTemp].setRight(false);
                        maze.maze[rTemp][cTemp].setVisited(true);
                    }
                }
            }
            for (int i = 0; i < 5; i++) { //sets cells to not visited
                for (int j = 0; j < 5; j++) {
                    maze.maze[i][j].setVisited(false);
                }
            }
            maze.solveMaze(start);
        }
        if (level == 2) {
            int start = rand.nextInt(5);
            int end = rand.nextInt(5);
            MyMaze maze = new MyMaze(5, 20, start, end);
            Stack1Gen stack = new Stack1Gen<>();

            int rTemp = start; //temporary row pointer
            int cTemp = 0; // temporary col pointer
            stack.push(rTemp);
            stack.push(cTemp);

            while (!stack.isEmpty()) { //Checks for surrounding non visited cells
                int[][] neighbors = new int[4][2];//temp holder for non visited cells
                int count = 0;
                if (cTemp - 1 > -1) {
                    if (!maze.maze[rTemp][cTemp - 1].getVisited()) {
                        neighbors[count][0] = rTemp;
                        neighbors[count][1] = cTemp - 1;
                        count++;
                    }
                }
                if (rTemp - 1 > -1 ) {
                    if (!maze.maze[rTemp - 1][cTemp].getVisited()) {
                        neighbors[count][0] = rTemp - 1;
                        neighbors[count][1] = cTemp;
                        count++;
                    }
                }
                if (cTemp + 1 < 20) {
                    if (!maze.maze[rTemp][cTemp + 1].getVisited()) {
                        neighbors[count][0] = rTemp;
                        neighbors[count][1] = cTemp + 1;
                        count++;
                    }
                }
                if (rTemp + 1 < 5 ) {
                    if (!maze.maze[rTemp+1][cTemp].getVisited()) {
                        neighbors[count][0] = rTemp + 1;
                        neighbors[count][1] = cTemp;
                        count++;
                    }
                }
                if (count == 0) { //checks for dead end
                    cTemp = (int) stack.pop();
                    rTemp = (int) stack.pop();;
                } else { //randomly chooses next directions
                    int dir = rand.nextInt(count);
                    int rTemp3 = neighbors[dir][0];
                    int cTemp3 = neighbors[dir][1];
                    stack.push(rTemp3);
                    stack.push(cTemp3);
                    int rTemp1 = neighbors[dir][0];
                    int cTemp1 = neighbors[dir][1];
                    if (rTemp - rTemp1 == 1) {
                        rTemp = rTemp1;
                        maze.maze[rTemp][cTemp].setBottom(false);
                        maze.maze[rTemp][cTemp].setVisited(true);
                    } else if (rTemp - rTemp1 == -1) {
                        maze.maze[rTemp][cTemp].setBottom(false);
                        rTemp = rTemp1;
                        maze.maze[rTemp][cTemp].setVisited(true);
                    } else if (cTemp - cTemp1 == -1) {
                        maze.maze[rTemp][cTemp].setRight(false);
                        cTemp = cTemp1;
                        maze.maze[rTemp][cTemp].setVisited(true);
                    } else if (cTemp - cTemp1 == 1) {
                        cTemp = cTemp1;
                        maze.maze[rTemp][cTemp].setRight(false);
                        maze.maze[rTemp][cTemp].setVisited(true);
                    }
                }
            }

            for (int i = 0; i < 5; i++) { //sets cells to not visited
                for (int j = 0; j < 20; j++) {
                    maze.maze[i][j].setVisited(false);
                }
            }
            maze.solveMaze(start);
        }

        if (level == 3) {
            int start = rand.nextInt(20);
            int end = rand.nextInt(20);
            MyMaze maze = new MyMaze(20, 20, start, end);
            Stack1Gen stack = new Stack1Gen<>();
            int rTemp = start; //temporary row pointer
            int cTemp = 0; // temporary col pointer
            stack.push(rTemp);
            stack.push(cTemp);

            while (!stack.isEmpty()) { //Checks for surrounding non visited cells
                int[][] neighbors = new int[4][2]; //temp holder for non visited cells
                int count = 0;
                if (cTemp - 1 > -1) {
                    if (!maze.maze[rTemp][cTemp - 1].getVisited()) {
                        neighbors[count][0] = rTemp;
                        neighbors[count][1] = cTemp - 1;
                        count++;
                    }
                }
                if (rTemp - 1 > -1 ) {
                    if (!maze.maze[rTemp - 1][cTemp].getVisited()) {
                        neighbors[count][0] = rTemp - 1;
                        neighbors[count][1] = cTemp;
                        count++;
                    }
                }
                if (cTemp + 1 < 20) {
                    if (!maze.maze[rTemp][cTemp + 1].getVisited()) {
                        neighbors[count][0] = rTemp;
                        neighbors[count][1] = cTemp + 1;
                        count++;
                    }
                }
                if (rTemp + 1 < 20 ) {
                    if (!maze.maze[rTemp+1][cTemp].getVisited()) {
                        neighbors[count][0] = rTemp + 1;
                        neighbors[count][1] = cTemp;
                        count++;
                    }
                }
                if (count == 0) { //checks for dead end
                    cTemp = (int) stack.pop();
                    rTemp = (int) stack.pop();
                } else { //randomly chooses next directions
                    int dir = rand.nextInt(count);
                    int rTemp3 = neighbors[dir][0];
                    int cTemp3 = neighbors[dir][1];
                    stack.push(rTemp3);
                    stack.push(cTemp3);
                    int rTemp1 = neighbors[dir][0];
                    int cTemp1 = neighbors[dir][1];
                    if (rTemp - rTemp1 == 1) {
                        rTemp = rTemp1;
                        maze.maze[rTemp][cTemp].setBottom(false);
                        maze.maze[rTemp][cTemp].setVisited(true);
                    } else if (rTemp - rTemp1 == -1) {
                        maze.maze[rTemp][cTemp].setBottom(false);
                        rTemp = rTemp1;
                        maze.maze[rTemp][cTemp].setVisited(true);
                    } else if (cTemp - cTemp1 == -1) {
                        maze.maze[rTemp][cTemp].setRight(false);
                        cTemp = cTemp1;
                        maze.maze[rTemp][cTemp].setVisited(true);
                    } else if (cTemp - cTemp1 == 1) {
                        cTemp = cTemp1;
                        maze.maze[rTemp][cTemp].setRight(false);
                        maze.maze[rTemp][cTemp].setVisited(true);
                    }
                }
            }

            for (int i = 0; i < 20; i++) { //sets cells to not visited
                for (int j = 0; j < 20; j++) {
                    maze.maze[i][j].setVisited(false);
                }
            }
            maze.solveMaze(start);
        }
        return null;
    }

    /* TODO: Print a representation of the maze to the terminal */
    public void printMaze() {
        String format = "";
        String wall = "|";
        String dash = "---";

       int x = maze.length * 2 - 1;
       for (int i = 0; i < maze[startRow].length; i++) {
           format += wall;
           format += dash;
       }
       format += "|\n";

       for (int i = 0; i < x; i++) {
           if (startRow == 0 && i == 0) {
               format += " ";
           } else if (i / 2 == startRow && i % 2 == 0) {
               format += " ";
           } else {
               format += wall;
           }
           if (i % 2 == 0) {
               if (i == 0) {
                   for (int j = 0; j < maze[0].length; j++) {
                       if (maze[i][j].getVisited()) {
                           format += " * ";
                       } else {
                           format += "   ";
                       }
                       if (maze[i][j].getRight()) {
                           format += wall;
                       } else {
                           format += " ";
                       }
                   } if (endRow == 1 && i == 0) {
                       format += " \n";
                   } else if (i / 2 + 1  == startRow && i % 2 == 0) {
                       format += " \n";
                   } else {
                       format +=  "\n";
                   }
               } else {
                   for (int j = 0; j < maze[0].length; j++) {
                       if (maze[i / 2][j].getVisited()) {
                           format +=" * ";
                       } else {
                           format += "   ";
                       }
                       if (maze[i / 2][j].getRight()) {
                           format += wall;
                       } else {
                           format += " ";
                       }
                   } if (endRow == 0 && i == 0) {
                       format += " \n";
                   } else if (i / 2 + 1 == endRow && i % 2 == 0) {
                       format += " \n";
                   } else {
                       format += "\n";
                   }
               }
           } else {
               for (int j = 0; j < maze[0].length; j++) {
                   if (maze[i / 2][j].getBottom()) {
                       format += dash;
                       format += wall;
                   } else {
                       format +="   ";
                       format += wall;
                   }
               }
               format += "\n";
           }
       }

       for (int i = 0; i < maze[startRow].length; i++) {
           format += wall;
           format += dash;
       }
       format += wall;
       System.out.println(format);
    }

    /* TODO: Solve the maze using the algorithm found in the writeup. */
    public void solveMaze(int startRow) {
        int[][] queue = new int[500][2];
        queue[0][0] = startRow;
        queue[0][1] = 0;
        int beginning = 0;
        int end = 1;
        int rTemp = queue[beginning][0];
        int cTemp = queue[beginning][1];
        maze[startRow][0].setVisited(true);
        while (end > beginning) {
            if (cTemp - 1 > -1) {
                if (!maze[rTemp][cTemp - 1].getVisited() && !maze[rTemp][cTemp - 1].getRight()) {
                    queue[end][0] = rTemp;
                    queue[end][1] = (cTemp-1);
                    end++;
                }
            }
            if (rTemp - 1 > -1 ) {
                if (!maze[rTemp - 1][cTemp].getVisited() && !maze[rTemp - 1][cTemp].getBottom()) {
                    queue[end][0] = (rTemp - 1);
                    queue[end][1] = cTemp;
                    end++;
                }
            }
            if (cTemp + 1 < col) {
                if (!maze[rTemp][cTemp + 1].getVisited() && !maze[rTemp][cTemp].getRight()) {
                    queue[end][0] = rTemp;
                    queue[end][1] = (cTemp + 1);
                    end++;
                }
            }
            if (rTemp + 1 < row ) {
                if (!maze[rTemp+1][cTemp].getVisited() && !maze[rTemp][cTemp].getBottom()) {
                    queue[end][0] = (rTemp + 1);
                    queue[end][1] = cTemp;
                    end++;
                }
            }
            maze[rTemp][cTemp].setVisited(true);
            beginning++;
            rTemp = queue[beginning][0];
            cTemp = queue[beginning][1];
            if (rTemp == endRow && cTemp == col-1) {
                maze[rTemp][cTemp].setVisited(true);
                break;
            }
        }
        printMaze();
    }

    public static void main(String[] args) {
        /* Use scanner to get user input for maze level, then make and solve maze */
        System.out.println("Enter maze level (1, 2, or 3): ");
        Scanner i = new Scanner(System.in);
        String level = i.nextLine();
        int j = Integer.parseInt(level);
        makeMaze(j);
    }
}
