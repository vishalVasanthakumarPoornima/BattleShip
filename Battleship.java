import java.util.Scanner;
public class Battleship {
        static char[][] playerOneGrid = new char[5][5];
        static char[][] playerTwoGrid = new char[5][5];
        static int playerOneHits=0;
        static int playerTwoHits=0;
        public static void main (String args[]) {
            // var declaration
            Scanner scan = new Scanner(System.in);
            String str;
            String[] shipVal;
            Integer xVal, yVal;
            System.out.println("Welcome to Battleship!");
            // collect ship coordinates for both the players
            // and print the respective grid
            for (int players = 1; players<=2; players++) {
                if (players == 1) {
                    populateGrid(scan, players, playerOneGrid);
                    printGrid(playerOneGrid);
                } else {
                    populateGrid(scan, players, playerTwoGrid);
                    printGrid(playerTwoGrid);
                }
            }
            // Game play
            int turn=0;
            Boolean playerOne=true;
            while(turn<5){
                if(playerOne){
                    playerTurn(scan, 1, 2, playerTwoGrid, playerTwoHits);
                    playerOne=false;
                }
                else{
                    playerTurn(scan, 2, 1, playerOneGrid, playerOneHits);
                    playerOne=true;
                }
                turn++;
            }
            // main ends here
        }

        private static void playerTurn(Scanner scan, int playernum, int opponentnum, char[][] playerGrid, int playerHitCount){
            String str;
            Integer xVal;
            String[] shipVal;
            Integer yVal;
            // ask for coordinates and update grid
            System.out.println("Player "+ playernum +", enter hit row/column:");
            str = scan.nextLine();
            shipVal = str.split(" ");
            xVal = Integer.parseInt(shipVal[0]);
            yVal = Integer.parseInt(shipVal[1]);
            // print a 2D array
            for (int xAxis = 0; xAxis < 5; xAxis++) {
                // xAxis loops
                for (int yAxis = 0; yAxis < 5; yAxis++) {
                    // yAxis loops
                    if (xVal == xAxis) {
                        if (yVal == yAxis) {
                            // hit spot
                            if (playerGrid[xAxis][yAxis]=='@') {
                                // it's a hit on the ship
                                playerGrid[xAxis][yAxis]='X';
                                playerHitCount++;
                                System.out.println("PLAYER "+playernum+" HIT PLAYER "+opponentnum+"'s SHIP!");
                                if(playerHitCount == 5){
                                    System.out.println("We have a winner!");
                                }
                            }else
                            {
                                // it's a miss
                                playerGrid[xAxis][yAxis]='O';
                                System.out.println("PLAYER "+playernum+" MISSED!");
                            }
                        }
                    }
                }
            }



        }

        private static void populateGrid(Scanner scan, int players, char[][] playerGrid) {
            String str;
            Integer xVal;
            String[] shipVal;
            Integer yVal;
            for (int shipCoordinates = 0; shipCoordinates < 5; shipCoordinates++) {
                // loop for 3 iterations
                // to input ship coordinates
                System.out.println("PLAYER "+ players +", ENTER YOUR SHIPS' COORDINATES.");
                System.out.println("Enter ship "+(shipCoordinates+1)+" location:");
                str = scan.nextLine();
                shipVal = str.split(" ");
                xVal = Integer.parseInt(shipVal[0]);
                yVal = Integer.parseInt(shipVal[1]);
                // print a 2D array 3x3
                if (xVal<5 && xVal>0) {
                    if (yVal < 5 && xVal > 0) {
                        for (int xAxis = 0; xAxis < 5; xAxis++) {
                            // xAxis loops from 0 ~ 2
                            for (int yAxis = 0; yAxis < 5; yAxis++) {
                                if (xVal == xAxis) {
                                    if (yVal == yAxis) {
                                        // set occupied i.e. 1
                                        setOccupied(xAxis, yAxis, playerGrid);
                                    } else {
                                        // set unoccupied i.e. 0
                                        setUnoccupied(xAxis, yAxis, playerGrid);
                                    }
                                } else {
                                    // set unoccupied i.e. 0
                                    setUnoccupied(xAxis, yAxis, playerGrid);
                                }
                            }
                        }

                    } else {
                        System.out.println("Invalid Coordinates. Choose different coordinates.");
                    }
                }else{
                    System.out.println("Invalid Coordinates. Choose different coordinates.");
                }
            }

        }

        private static void printGrid(char[][] playerGrid) {
            // print the array
            // print a 2D array 3x3
            for (int xAxis = 0; xAxis < 5; xAxis++) {
                // xAxis loops from 0 ~ 2
                for (int yAxis = 0; yAxis < 5; yAxis++) {
                    System.out.printf("%s  ",playerGrid[xAxis][yAxis]);
                }
                System.out.println("");
            }
        }

        public static void setUnoccupied(int x, int y, char[][] playerGrid) {
            if (!(playerGrid[x][y] == '-' || playerGrid[x][y] == '@')) {
                playerGrid[x][y] = '-';
            }
        }
        public static void setOccupied(int x, int y, char[][] playerGrid){
            playerGrid[x][y]='@';
        }
// class ends here
    }

