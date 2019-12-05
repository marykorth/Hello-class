package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Scrabble {
 char[][] board = new char[15][15];
 ArrayList<Tile> rack1 = new ArrayList<>();
 ArrayList<Tile> rack2 = new ArrayList<>();
 ArrayList<Tile> letterBag = new ArrayList<>();

 class Tile {
     char letter;
     int value;
     boolean played;
     int x;
     int y;


     public Tile() {
     }

     public Tile(char letter, int value, boolean played, int x, int y) {
         this.letter = letter;
         this.value = value;
         this.played = played;
         this.x = x;
         this.y = y;
     }

     public Tile(char letter, int value, boolean played) {
         this();
         this.letter = letter;
         this.value = value;
         this.played = played;
     }

     public String toString() {
         return String.valueOf(letter);
     }
 }
    public Scrabble() {
    }

        public boolean isDone() {
            // bag is empty
            // either: someone runs out of tiles OR
            // no more moves can be made
            return false;


        }

        public void fillletterBag() {
            int i = 0;
            for (int j = 0; j < 12; j++) {
                letterBag.add (new Tile('E', 1, false));
                i++;
            }
            for (int j = 0; j < 9; j++) {
                letterBag.add (new Tile('A', 1, false));
                i++;
                letterBag.add (new Tile('I', 1, false));
                i++;
            }
            for (int j = 0; j < 8; j++) {
                letterBag.add (new Tile('O', 1, false));
                i++;
            }
            for (int j = 0; j < 6; j++) {
                letterBag.add (new Tile('N', 1, false));
                i++;
                letterBag.add (new Tile('R', 1, false));
                i++;
                letterBag.add (new Tile('T', 1, false));
                i++;
            }
            for (int j = 0; j < 4; j++) {
                letterBag.add (new Tile('D', 2, false));
                i++;
                letterBag.add (new Tile('L', 1, false));
                i++;
                letterBag.add (new Tile('S', 1, false));
                i++;
                letterBag.add (new Tile('U', 1, false));
                i++;
            }
            for (int j = 0; j < 3; j++) {
                letterBag.add (new Tile('G', 2, false));
                i++;
            }
            letterBag.add (new Tile('B', 3, false));
            i++;
            letterBag.add (new Tile('B', 3, false));
            i++;
            letterBag.add (new Tile('C', 3, false));
            i++;
            letterBag.add (new Tile('C', 3, false));
            i++;
            letterBag.add (new Tile('F', 4, false));
            i++;
            letterBag.add (new Tile('F', 4, false));
            i++;
            letterBag.add (new Tile('H', 4, false));
            i++;
            letterBag.add (new Tile('H', 4, false));
            i++;
            letterBag.add (new Tile('J', 8, false));
            i++;
            letterBag.add (new Tile('K', 5, false));
            i++;
            letterBag.add (new Tile('M', 3, false));
            i++;
            letterBag.add (new Tile('M', 3, false));
            i++;
            letterBag.add (new Tile('P', 3, false));
            i++;
            letterBag.add (new Tile('P', 3, false));
            i++;
            letterBag.add (new Tile('Q', 10, false));
            i++;
            letterBag.add (new Tile('V', 4, false));
            i++;
            letterBag.add (new Tile('V', 4, false));
            i++;
            letterBag.add (new Tile('W', 4, false));
            i++;
            letterBag.add (new Tile('W', 4, false));
            i++;
            letterBag.add (new Tile('X', 8, false));
            i++;
            letterBag.add (new Tile('Y', 4, false));
            i++;
            letterBag.add (new Tile('Y', 4, false));
            i++;
            letterBag.add (new Tile('Z', 10, false));
            i++;
          //  letterBag[i] = new Tile('-', 0, false);
         //   i++;
         //   letterBag[i] = new Tile('-', 0, false);
        //    i++;
        }

        public void getTile(ArrayList<Tile> rack) {
        //rack.add(letterBag[ind]);
            int randIndex = new Random().nextInt(letterBag.size());
            rack.add (letterBag.get(randIndex));
            letterBag.remove(randIndex);
        }

        public void moveTile(Tile piece, int x, int y){
            board[x][y] = piece.letter;

        }



        public String toString() {
            String rv = "";
            rv += board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "|" + board[0][3] + "|" + board[0][4] + "|" + board[0][5] + "|" + board[0][6] + "|" + board[0][7] + "|" + board[0][8] + "|" + board[0][9] + "|" + board[0][10] + "|" + board[0][11] + "|" + board[0][12] + "|" + board[0][13] + "|" + board[0][14] + "|" + "\n";
           //  rv += "-----\n";
            rv += board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "|" + board[1][3] + "|" + board[1][4] + "|" + board[1][5] + "|" + board[1][6] + "|" + board[1][7] + "|" + board[1][8] + "|" + board[1][9] + "|" + board[1][10] + "|" + board[1][11] + "|" + board[1][12] + "|" + board[1][13] + "|" + board[1][14] + "|" +  "\n";
          //  rv += "-----\n";
            rv += board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "|" + board[2][3] + "|" + board[2][4] + "|" + board[2][5] + "|" + board[2][6] + "|" + board[2][7] + "|" + board[2][8] + "|" + board[2][9] + "|" + board[2][10] + "|" + board[2][11] + "|" + board[2][12] + "|" + board[2][13] + "|" + board[2][14] + "|" +  "\n";
         //   rv += "-----\n";
            rv += board[3][0] + "|" + board[3][1] + "|" + board[3][2] + "|" + board[3][3] + "|" + board[3][4] + "|" + board[3][5] + "|" + board[3][6] + "|" + board[3][7] + "|" + board[3][8] + "|" + board[3][9] + "|" + board[3][10] + "|" + board[3][11] + "|" + board[3][12] + "|" + board[3][13] + "|" + board[3][14] + "|" +  "\n";
         //   rv += "-----\n";
            rv += board[4][0] + "|" + board[4][1] + "|" + board[4][2] + "|" + board[4][3] + "|" + board[4][4] + "|" + board[4][5] + "|" + board[4][6] + "|" + board[4][7] + "|" + board[4][8] + "|" + board[4][9] + "|" + board[4][10] + "|" + board[4][11] + "|" + board[4][12] + "|" + board[4][13] + "|" + board[4][14] + "|" +  "\n";
         //   rv += "-----\n";
            rv += board[5][0] + "|" + board[5][1] + "|" + board[5][2] + "|" + board[5][3] + "|" + board[5][4] + "|" + board[5][5] + "|" + board[5][6] + "|" + board[5][7] + "|" + board[5][8] + "|" + board[5][9] + "|" + board[5][10] + "|" + board[5][11] + "|" + board[5][12] + "|" + board[5][13] + "|" + board[5][14] + "|" +  "\n";
          //  rv += "-----\n";
            rv += board[6][0] + "|" + board[6][1] + "|" + board[6][2] + "|" + board[6][3] + "|" + board[6][4] + "|" + board[6][5] + "|" + board[6][6] + "|" + board[6][7] + "|" + board[6][8] + "|" + board[6][9] + "|" + board[6][10] + "|" + board[6][11] + "|" + board[6][12] + "|" + board[6][13] + "|" + board[6][14] + "|" +  "\n";
          //  rv += "-----\n";
            rv += board[7][0] + "|" + board[7][1] + "|" + board[7][2] + "|" + board[7][3] + "|" + board[7][4] + "|" + board[7][5] + "|" + board[7][6] + "|" + board[7][7] + "|" + board[7][8] + "|" + board[7][9] + "|" + board[7][10] + "|" + board[7][11] + "|" + board[7][12] + "|" + board[7][13] + "|" + board[7][14] + "|" +  "\n";
         //   rv += "-----\n";
            rv += board[8][0] + "|" + board[8][1] + "|" + board[8][2] + "|" + board[8][3] + "|" + board[8][4] + "|" + board[8][5] + "|" + board[8][6] + "|" + board[8][7] + "|" + board[8][8] + "|" + board[8][9] + "|" + board[8][10] + "|" + board[8][11] + "|" + board[8][12] + "|" + board[8][13] + "|" + board[8][14] + "|" + "\n";
          //  rv += "-----\n";
            rv += board[9][0] + "|" + board[9][1] + "|" + board[9][2] + "|" + board[9][3] + "|" + board[9][4] + "|" + board[9][5] + "|" + board[9][6] + "|" + board[9][7] + "|" + board[9][8] + "|" + board[9][9] + "|" + board[9][10] + "|" + board[9][11] + "|" + board[9][12] + "|" + board[9][13] + "|" + board[9][14] + "|"  + "\n";
          //  rv += "-----\n";
            rv += board[10][0] + "|" + board[10][1] + "|" + board[10][2] + "|" + board[10][3] + "|" + board[10][4] + "|" + board[10][5] + "|" + board[10][6] + "|" + board[10][7] + "|" + board[10][8] + "|" + board[10][9] + "|" + board[10][10] + "|" + board[10][11] + "|" + board[10][12] + "|" + board[10][13] + "|" + board[10][14] + "|" + "\n";
         //   rv += "-----\n";
            rv += board[11][0] + "|" + board[11][1] + "|" + board[11][2] + "|" + board[11][3] + "|" + board[11][4] + "|" + board[11][5] + "|" + board[11][6] + "|" + board[11][7] + "|" + board[11][8] + "|" + board[11][9] + "|" + board[11][10] + "|" + board[11][11] + "|" + board[11][12] + "|" + board[11][13] + "|" + board[11][14] + "|" +  "\n";
         //   rv += "-----\n";
            rv += board[12][0] + "|" + board[12][1] + "|" + board[12][2] + "|" + board[12][3] + "|" + board[12][4] + "|" + board[12][5] + "|" + board[12][6] + "|" + board[12][7] + "|" + board[12][8] + "|" + board[12][9] + "|" + board[12][10] + "|" + board[12][11] + "|" + board[12][12] + "|" + board[12][13] + "|" + board[12][14] + "|" +  "\n";
          //  rv += "-----\n";
            rv += board[13][0] + "|" + board[13][1] + "|" + board[13][2] + "|" + board[13][3] + "|" + board[13][4] + "|" + board[13][5] + "|" + board[13][6] + "|" + board[13][7] + "|" + board[13][8] + "|" + board[13][9] + "|" + board[13][10] + "|" + board[13][11] + "|" + board[13][12] + "|" + board[13][13] + "|" + board[13][14] + "|" +  "\n";
         //   rv += "-----\n";
            rv += board[14][0] + "|" + board[14][1] + "|" + board[14][2] + "|" + board[14][3] + "|" + board[14][4] + "|" + board[14][5] + "|" + board[14][6] + "|" + board[14][7] + "|" + board[14][8] + "|" + board[14][9] + "|" + board[14][10] + "|" + board[14][11] + "|" + board[14][12] + "|" + board[14][13] + "|" + board[14][14] + "|" + "\n";
          //  rv += "-----\n";
            //rv += board[15][0] + "|" + board[15][1] + "|" + board[15][2] + "|" + board[15][3] + "|" + board[15][4] + "|" + board[15][5] + "|" + board[15][6] + "|" + board[15][7] + "|" + board[15][8] + board[15][9] + "|" + board[15][10] + "|" + board[15][11] + "|" + board[15][12] + "|" + board[15][13] + "|" + board[15][14] + "|" +  "\n";
            return rv;

        }

        public void play() throws Exception {
            Scanner scanner = new Scanner(System.in);
        while(!letterBag.isEmpty()) {
            while (rack1.size() < 7) {
                getTile(rack1);
            }
            while (rack2.size() < 7) {
                getTile(rack2);
            }


            System.out.print(this);
            System.out.println("---");
            System.out.println(rack1.toString());
            while(true) {

                System.out.print("Letter: ");
                String letter = scanner.nextLine();
                if (letter.equals("Done")) break;

                System.out.print("x-coordinate: ");
                String x = scanner.nextLine();
                System.out.print("y-coordinate: ");
                String y = scanner.nextLine();

                Tile piece = findTile(letter.charAt(0));

                moveTile(piece, Integer.parseInt(x), Integer.parseInt(y));
            }

        }

    }

    public Tile findTile (char c) throws Exception {
     for (Tile tile: rack1) {
         if (tile.letter == c) {
             rack1.remove(tile);
             return tile;
         }
     }

     System.out.println("Select a different tile");
     throw new Exception("Tile does not exist");
    }

    public static int computeScore(String word) {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] values = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 3, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += values[alphabet.indexOf(word.charAt(i))];
        }
        return sum;
    }
}