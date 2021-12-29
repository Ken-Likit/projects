import java.util.Scanner;

public class Game {

    //Contains the process to run a game, including the different difficulties
    public void runGame(String level){
        if (level.equals("Beginner")) {
            System.out.println("There is 1 boat.");
            Board b1 = new Board(3);
            b1.setPP(1);
            b1.setCells();
            Boat B1 = b1.placeBoats(2);
            while (b1.getBoats() > 0) {
                int p1 = b1.getPP();
                if(p1 > 0){System.out.println("Turn " + b1.getTurns() + " " + p1 + " power point(s) left");}
                else{System.out.println("Turn " + b1.getTurns());}
                b1.addTurn();
                b1.display();
                int cord[] = new int[2];
                Scanner myScanner = new Scanner(System.in);
                if(p1 > 0){System.out.println("Turn " + b1.getTurns() + " " + p1 + " power point(s) left");}
                else{System.out.println("Turn " + b1.getTurns());}
                String coordin = myScanner.nextLine();
                if((coordin.equals("missile") || coordin.equals("drone") || coordin.equals("submarine")) && p1 > 0){
                    b1.usePP();
                    if(coordin.equals("missile")){
                        System.out.println("Choose coordinates to fire :");
                        String coordi = myScanner.nextLine();
                        String coord[] = coordi.split(" ");
                        for(int i = 0; i < coord.length; i++){
                            cord[i] = Integer.parseInt((coord[i]));
                        }
                        b1.missile(cord[0], cord[1]);
                    }

                    else if(coordin.equals("drone")){
                        b1.drone();
                    }

                    else if(coordin.equals("submarine")){
                        System.out.println("Choose coordinates to fire :");
                        String coordi = myScanner.nextLine();
                        String coord[] = coordi.split(" ");
                        for(int i = 0; i < coord.length; i++){
                            cord[i] = Integer.parseInt((coord[i]));
                        }
                        boolean y = b1.submarine(cord[0], cord[1]);
                        if(y == true){
                            if(B1.check(cord[0], cord[1]) == true){
                                B1.setHit();
                            }
                        }
                        else{
                            b1.setMiss(cord[0], cord[1]);
                        }
                    }

                }
                else {
                    String coord[] = coordin.split(" ");
                    for (int i = 0; i < coord.length; i++) {
                        cord[i] = Integer.parseInt((coord[i]));
                    }
                    b1.fire(cord[0], cord[1]);
                }
                if (B1.getStatus() == true) {
                    b1.removeBoat();
                    System.out.println("Boat sunk");
                }

            }
            System.out.println("All boats sunk in "+ (b1.getTurns() - 1));
        }

        else if (level.equals("Beginner debug")) {
            System.out.println("There is 1 boat.");
            Board b1 = new Board(3);
            b1.setPP(1);
            b1.setCells();
            Boat B1 = b1.placeBoats(2);
            while (b1.getBoats() > 0) {
                int p1 = b1.getPP();
                if(p1 > 0){System.out.println("Turn " + b1.getTurns() + " " + p1 + " power point(s) left");}
                else{System.out.println("Turn " + b1.getTurns());}
                b1.addTurn();
                b1.print();
                int cord[] = new int[2];
                Scanner myScanner = new Scanner(System.in);
                if(p1 > 0){System.out.println("Turn " + b1.getTurns() + " " + p1 + " power point(s) left");}
                else{System.out.println("Turn " + b1.getTurns());}
                String coordin = myScanner.nextLine();
                if((coordin.equals("missile") || coordin.equals("drone") || coordin.equals("submarine")) && p1 > 0){
                    b1.usePP();
                    if(coordin.equals("missile")){
                        System.out.println("Choose coordinates to fire :");
                        String coordi = myScanner.nextLine();
                        String coord[] = coordi.split(" ");
                        for(int i = 0; i < coord.length; i++){
                            cord[i] = Integer.parseInt((coord[i]));
                        }
                        b1.missile(cord[0], cord[1]);
                    }

                    else if(coordin.equals("drone")){
                        b1.drone();
                    }

                    else if(coordin.equals("submarine")){
                        System.out.println("Choose coordinates to fire :");
                        String coordi = myScanner.nextLine();
                        String coord[] = coordi.split(" ");
                        for(int i = 0; i < coord.length; i++){
                            cord[i] = Integer.parseInt((coord[i]));
                        }
                        boolean y = b1.submarine(cord[0], cord[1]);
                        if(y == true){
                            if(B1.check(cord[0], cord[1]) == true){
                                B1.setHit();
                            }
                        }
                        else{
                            b1.setMiss(cord[0], cord[1]);
                        }
                    }

                }
                else {
                    String coord[] = coordin.split(" ");
                    for (int i = 0; i < coord.length; i++) {
                        cord[i] = Integer.parseInt((coord[i]));
                    }
                    b1.fire(cord[0], cord[1]);
                }
                if (B1.getStatus() == true) {
                    b1.removeBoat();
                    System.out.println("Boat sunk");
                }

            }
            System.out.println("All boats sunk in "+ (b1.getTurns() - 1));
        }

        else if (level.equals("Intermediate")){
            System.out.println("There are 3 boats.");
            Board b1 = new Board(6);
            b1.setPP(3);
            b1.setCells();
            Boat B1 =b1.placeBoats(2);
            Boat B2 =b1.placeBoats(3);
            Boat B3 =b1.placeBoats(4);
            while(b1.getBoats() > 0){
                int p1 = b1.getPP();
                if(p1 > 0){System.out.println("Turn " + b1.getTurns() + " " + p1 + " power point(s) left");}
                else{System.out.println("Turn " + b1.getTurns());}
                b1.addTurn();
                b1.display();
                int cord[] = new int[2];
                Scanner myScanner = new Scanner(System.in);
                if(p1 > 0){System.out.println("Turn " + b1.getTurns() + " " + p1 + " power point(s) left");}
                else{System.out.println("Turn " + b1.getTurns());}
                String coordin = myScanner.nextLine();
                if((coordin.equals("missile") || coordin.equals("drone") || coordin.equals("submarine")) && p1 > 0){
                    b1.usePP();
                    if(coordin.equals("missile")){
                        System.out.println("Choose coordinates to fire :");
                        String coordi = myScanner.nextLine();
                        String coord[] = coordi.split(" ");
                        for(int i = 0; i < coord.length; i++){
                            cord[i] = Integer.parseInt((coord[i]));
                        }
                        b1.missile(cord[0], cord[1]);
                    }

                    else if(coordin.equals("drone")){
                        b1.drone();
                    }

                    else if(coordin.equals("submarine")){
                        System.out.println("Choose coordinates to fire :");
                        String coordi = myScanner.nextLine();
                        String coord[] = coordi.split(" ");
                        for(int i = 0; i < coord.length; i++){
                            cord[i] = Integer.parseInt((coord[i]));
                        }
                        boolean y = b1.submarine(cord[0], cord[1]);
                        if(y == true){
                            if(B1.check(cord[0], cord[1]) == true){
                                B1.setHit();
                            }
                            else if(B2.check(cord[0], cord[1]) == true){
                                B2.setHit();
                            }
                            if(B3.check(cord[0], cord[1]) == true){
                                B3.setHit();
                            }
                        }
                        else{
                            b1.setMiss(cord[0], cord[1]);
                        }
                    }

                }
                else {
                    //
                    String coord[] = coordin.split(" ");
                    for (int i = 0; i < coord.length; i++) {
                        cord[i] = Integer.parseInt((coord[i]));
                    }
                    b1.fire(cord[0], cord[1]);
                }
                if (B1.getStatus() == true) {
                    if(B1.removeBoat() == true) {
                        b1.removeBoat();
                        System.out.println("Boat sunk");
                    }
                }
                if (B2.getStatus() == true) {
                    if(B2.removeBoat() == true) {
                        b1.removeBoat();
                        System.out.println("Boat sunk");
                    }
                }
                if (B3.getStatus() == true) {
                    if(B3.removeBoat() == true) {
                        b1.removeBoat();
                        System.out.println("Boat sunk");
                    }
                }
            }
            System.out.println("All boats sunk in "+ (b1.getTurns() - 1));
        }

        else if (level.equals("Intermediate debug")){
            System.out.println("There are 3 boats.");
            Board b1 = new Board(6);
            b1.setPP(3);
            b1.setCells();
            Boat B1 =b1.placeBoats(2);
            Boat B2 =b1.placeBoats(3);
            Boat B3 =b1.placeBoats(4);
            while(b1.getBoats() > 0){
                int p1 = b1.getPP();
                if(p1 > 0){System.out.println("Turn " + b1.getTurns() + " " + p1 + " power point(s) left");}
                else{System.out.println("Turn " + b1.getTurns());}
                b1.addTurn();
                b1.print();
                int cord[] = new int[2];
                Scanner myScanner = new Scanner(System.in);
                if(p1 > 0){System.out.println("Turn " + b1.getTurns() + " " + p1 + " power point(s) left");}
                else{System.out.println("Turn " + b1.getTurns());}
                String coordin = myScanner.nextLine();
                if((coordin.equals("missile") || coordin.equals("drone") || coordin.equals("submarine")) && p1 > 0){
                    b1.usePP();
                    if(coordin.equals("missile")){
                        System.out.println("Choose coordinates to fire :");
                        String coordi = myScanner.nextLine();
                        String coord[] = coordi.split(" ");
                        for(int i = 0; i < coord.length; i++){
                            cord[i] = Integer.parseInt((coord[i]));
                        }
                        b1.missile(cord[0], cord[1]);
                    }

                    else if(coordin.equals("drone")){
                        b1.drone();
                    }

                    else if(coordin.equals("submarine")){
                        System.out.println("Choose coordinates to fire :");
                        String coordi = myScanner.nextLine();
                        String coord[] = coordi.split(" ");
                        for(int i = 0; i < coord.length; i++){
                            cord[i] = Integer.parseInt((coord[i]));
                        }
                        boolean y = b1.submarine(cord[0], cord[1]);
                        if(y == true){
                            if(B1.check(cord[0], cord[1]) == true){
                                B1.setHit();
                            }
                            else if(B2.check(cord[0], cord[1]) == true){
                                B2.setHit();
                            }
                            if(B3.check(cord[0], cord[1]) == true){
                                B3.setHit();
                            }
                        }
                        else{
                            b1.setMiss(cord[0], cord[1]);
                        }
                    }

                }
                else {
                    //
                    String coord[] = coordin.split(" ");
                    for (int i = 0; i < coord.length; i++) {
                        cord[i] = Integer.parseInt((coord[i]));
                    }
                    b1.fire(cord[0], cord[1]);
                }
                if (B1.getStatus() == true) {
                    if(B1.removeBoat() == true) {
                        b1.removeBoat();
                        System.out.println("Boat sunk");
                    }
                }
                if (B2.getStatus() == true) {
                    if(B2.removeBoat() == true) {
                        b1.removeBoat();
                        System.out.println("Boat sunk");
                    }
                }
                if (B3.getStatus() == true) {
                    if(B3.removeBoat() == true) {
                        b1.removeBoat();
                        System.out.println("Boat sunk");
                    }
                }
            }
            System.out.println("All boats sunk in "+ (b1.getTurns() - 1));
        }

        else if (level.equals("Expert debug")) {
            System.out.println("There are 5 boats.");
            Board b1 = new Board(9);
            b1.setPP(5);
            b1.setCells();
            Boat B1 =b1.placeBoats(2);
            Boat B2 = b1.placeBoats(3);
            Boat B3 =b1.placeBoats(3);
            Boat B4 =b1.placeBoats(4);
            Boat B5 =b1.placeBoats(5);
            while (b1.getBoats() > 0) {
                int p1 = b1.getPP();
                if(p1 > 0){System.out.println("Turn " + b1.getTurns() + " " + p1 + " power point(s) left");}
                else{System.out.println("Turn " + b1.getTurns());}
                b1.addTurn();
                b1.print();
                int cord[] = new int[2];
                Scanner myScanner = new Scanner(System.in);
                if(p1 > 0){System.out.println("Turn " + b1.getTurns() + " " + p1 + " power point(s) left");}
                else{System.out.println("Turn " + b1.getTurns());}
                String coordin = myScanner.nextLine();
                if((coordin.equals("missile") || coordin.equals("drone") || coordin.equals("submarine")) && p1 > 0){
                    b1.usePP();
                    if(coordin.equals("missile")){
                        System.out.println("Choose coordinates to fire :");
                        String coordi = myScanner.nextLine();
                        String coord[] = coordi.split(" ");
                        for(int i = 0; i < coord.length; i++){
                            cord[i] = Integer.parseInt((coord[i]));
                        }
                        b1.missile(cord[0], cord[1]);
                    }

                    else if(coordin.equals("drone")){
                        b1.drone();
                    }

                    else if(coordin.equals("submarine")){
                        System.out.println("Choose coordinates to fire :");
                        String coordi = myScanner.nextLine();
                        String coord[] = coordi.split(" ");
                        for(int i = 0; i < coord.length; i++){
                            cord[i] = Integer.parseInt((coord[i]));
                        }
                        boolean y = b1.submarine(cord[0], cord[1]);
                        if(y == true){
                            if(B1.check(cord[0], cord[1]) == true){
                                B1.setHit();
                            }
                            if(B2.check(cord[0], cord[1]) == true){
                                B2.setHit();
                            }
                            if(B3.check(cord[0], cord[1]) == true){
                                B3.setHit();
                            }
                            if(B4.check(cord[0], cord[1]) == true){
                                B4.setHit();
                            }
                            if(B5.check(cord[0], cord[1]) == true){
                                B5.setHit();
                            }
                        }
                        else{
                            b1.setMiss(cord[0], cord[1]);
                        }
                    }

                }
                //
                else {
                    String coord[] = coordin.split(" ");
                    for (int i = 0; i < coord.length; i++) {
                        cord[i] = Integer.parseInt((coord[i]));
                    }
                    b1.fire(cord[0], cord[1]);
                }
                if (B1.getStatus() == true) {
                    if (B1.removeBoat() == true) {
                        b1.removeBoat();
                        System.out.println("Boat sunk");
                    }
                }
                if (B2.getStatus() == true) {
                    if (B2.removeBoat() == true) {
                        b1.removeBoat();
                        System.out.println("Boat sunk");
                    }
                }
                if (B3.getStatus() == true){
                    if (B3.removeBoat() == true) {
                        b1.removeBoat();
                        System.out.println("Boat sunk");
                    }
                }
                if (B4.getStatus() == true) {
                    if (B4.removeBoat() == true) {
                        b1.removeBoat();
                        System.out.println("Boat sunk");
                    }
                }
                if (B5.getStatus() == true) {
                    if (B5.removeBoat() == true) {
                        b1.removeBoat();
                        System.out.println("Boat sunk");
                    }
                }
            }
            System.out.println("All boats sunk in "+ (b1.getTurns() - 1));
        }

        else if (level.equals("Expert")) {
            System.out.println("There are 5 boats.");
            Board b1 = new Board(9);
            b1.setPP(5);
            b1.setCells();
            Boat B1 =b1.placeBoats(2);
            Boat B2 = b1.placeBoats(3);
            Boat B3 =b1.placeBoats(3);
            Boat B4 =b1.placeBoats(4);
            Boat B5 =b1.placeBoats(5);
            while (b1.getBoats() > 0) {
                int p1 = b1.getPP();
                if(p1 > 0){System.out.println("Turn " + b1.getTurns() + " " + p1 + " power point(s) left");}
                else{System.out.println("Turn " + b1.getTurns());}
                b1.addTurn();
                b1.display();
                int cord[] = new int[2];
                Scanner myScanner = new Scanner(System.in);
                if(p1 > 0){System.out.println("Turn " + b1.getTurns() + " " + p1 + " power point(s) left");}
                else{System.out.println("Turn " + b1.getTurns());}
                String coordin = myScanner.nextLine();
                if((coordin.equals("missile") || coordin.equals("drone") || coordin.equals("submarine")) && p1 > 0){
                    b1.usePP();
                    if(coordin.equals("missile")){
                        System.out.println("Choose coordinates to fire :");
                        String coordi = myScanner.nextLine();
                        String coord[] = coordi.split(" ");
                        for(int i = 0; i < coord.length; i++){
                            cord[i] = Integer.parseInt((coord[i]));
                        }
                        b1.missile(cord[0], cord[1]);
                    }

                    else if(coordin.equals("drone")){
                        b1.drone();
                    }

                    else if(coordin.equals("submarine")){
                        System.out.println("Choose coordinates to fire :");
                        String coordi = myScanner.nextLine();
                        String coord[] = coordi.split(" ");
                        for(int i = 0; i < coord.length; i++){
                            cord[i] = Integer.parseInt((coord[i]));
                        }
                        boolean y = b1.submarine(cord[0], cord[1]);
                        if(y == true){
                            if(B1.check(cord[0], cord[1]) == true){
                                B1.setHit();
                            }
                            if(B2.check(cord[0], cord[1]) == true){
                                B2.setHit();
                            }
                            if(B3.check(cord[0], cord[1]) == true){
                                B3.setHit();
                            }
                            if(B4.check(cord[0], cord[1]) == true){
                                B4.setHit();
                            }
                            if(B5.check(cord[0], cord[1]) == true){
                                B5.setHit();
                            }
                        }
                        else{
                            b1.setMiss(cord[0], cord[1]);
                        }
                    }

                }
                //
                else {
                    String coord[] = coordin.split(" ");
                    for (int i = 0; i < coord.length; i++) {
                        cord[i] = Integer.parseInt((coord[i]));
                    }
                    b1.fire(cord[0], cord[1]);
                }
                if (B1.getStatus() == true) {
                    if (B1.removeBoat() == true) {
                        b1.removeBoat();
                        System.out.println("Boat sunk");
                    }
                }
                if (B2.getStatus() == true) {
                    if (B2.removeBoat() == true) {
                        b1.removeBoat();
                        System.out.println("Boat sunk");
                    }
                }
                if (B3.getStatus() == true){
                    if (B3.removeBoat() == true) {
                        b1.removeBoat();
                        System.out.println("Boat sunk");
                    }
                }
                if (B4.getStatus() == true) {
                    if (B4.removeBoat() == true) {
                        b1.removeBoat();
                        System.out.println("Boat sunk");
                    }
                }
                if (B5.getStatus() == true) {
                    if (B5.removeBoat() == true) {
                        b1.removeBoat();
                        System.out.println("Boat sunk");
                    }
                }
            }
            System.out.println("All boats sunk in "+ (b1.getTurns() - 1));
        }
    }

    // Where the code is started, allows the difficulty to be selected
    public static void main(String[] args) {
        System.out.println("Choose difficulty: Beginner, Intermediate, or Expert");
        System.out.println("Add debug to get into debug mode e.g. Beginner debug");
        System.out.println("Powers are missile, drone, and submarine");
        System.out.println("Type coordinates as e.g. 1 1");
        Scanner myScanner = new Scanner(System.in);
        String type = myScanner.nextLine();
        Game y = new Game();
        y.runGame(type);
    }
}
