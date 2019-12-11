/* SCRABBLE

Basic instructions: The user (you) takes your turn first. Look at the tiles in your rack and input them letter by letter based on coordinates. If
the word you input is not a word, you can try again. Type "Done" after you input your last letter. Do not use a word that has already
been used or a coordinate that has already been used.

*/



package com.company;

import java.io.IOException;
import java.util.*;

public class Scrabble {
    char[][] board;
    ArrayList<Tile> rack1;
    ArrayList<Tile> rack2;
    ArrayList<Tile> letterBag;
    Dictionary wordsDictionary;
    int userScore;
    HashSet<String> WordsPlayed = new HashSet<>();

    public Scrabble() throws IOException {
        board = new char[15][15];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ' ';

            }
        }
        rack1 = new ArrayList<>();
        rack2 = new ArrayList<>();
        letterBag = new ArrayList<>();
        wordsDictionary = new Dictionary
                ("/Users/marykorth/IdeaProjects/Scrabble/src/com/company/words.txt");
        //for(String s : wordsDictionary.words)
        //    System.out.println("XXX" + s);
        userScore = 0;
    }


    //Here we create the Tile object
    class Tile {
        char letter;
        int value;
        boolean played;
        int x;
        int y;

        public Tile() {
        }

        /*This tile constructor gives every tile a letter, value of points you get when playing the letter, and a boolean which returns false if the tile
        has not been played on the board and true if the tile has been played */
        public Tile(char letter, int value, boolean played) {
            this();
            this.letter = letter;
            this.value = value;
            this.played = played;
        }

        //This constructor does what the one above does but includes x and y coordinates representing where the tile lies on the board
        public Tile(char letter, int value, boolean played, int x, int y) {
            this.letter = letter;
            this.value = value;
            this.played = played;
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return String.valueOf(letter);
        }
    }

    /*The getTile function grabs random tiles from the bag of letters (letterBag) and places them on either the user (rack1) or
      the computer's (rack2) rack */
    public void getTile(ArrayList<Tile> rack) {
        //rack.add(letterBag[ind]);
        int randIndex = new Random().nextInt(letterBag.size());
        rack.add(letterBag.get(randIndex));
        letterBag.remove(randIndex);
    }

    /* This method, fillletterBag, adds 98 tile objects into a bag we later choose tiles out of. It fills the bag with 12 E's (valued at 1 point), 9 A's
       (valued at 1 point, 9 I's (valued at one point), and so on */
    public void fillletterBag() {
        int i = 0;
        for (int j = 0; j < 12; j++) {
            letterBag.add(new Tile('E', 1, false));
            i++;
        }
        for (int j = 0; j < 9; j++) {
            letterBag.add(new Tile('A', 1, false));
            i++;
            letterBag.add(new Tile('I', 1, false));
            i++;
        }
        for (int j = 0; j < 8; j++) {
            letterBag.add(new Tile('O', 1, false));
            i++;
        }
        for (int j = 0; j < 6; j++) {
            letterBag.add(new Tile('N', 1, false));
            i++;
            letterBag.add(new Tile('R', 1, false));
            i++;
            letterBag.add(new Tile('T', 1, false));
            i++;
        }
        for (int j = 0; j < 4; j++) {
            letterBag.add(new Tile('D', 2, false));
            i++;
            letterBag.add(new Tile('L', 1, false));
            i++;
            letterBag.add(new Tile('S', 1, false));
            i++;
            letterBag.add(new Tile('U', 1, false));
            i++;
        }
        for (int j = 0; j < 3; j++) {
            letterBag.add(new Tile('G', 2, false));
            i++;
        }
        letterBag.add(new Tile('B', 3, false));
        i++;
        letterBag.add(new Tile('B', 3, false));
        i++;
        letterBag.add(new Tile('C', 3, false));
        i++;
        letterBag.add(new Tile('C', 3, false));
        i++;
        letterBag.add(new Tile('F', 4, false));
        i++;
        letterBag.add(new Tile('F', 4, false));
        i++;
        letterBag.add(new Tile('H', 4, false));
        i++;
        letterBag.add(new Tile('H', 4, false));
        i++;
        letterBag.add(new Tile('J', 8, false));
        i++;
        letterBag.add(new Tile('K', 5, false));
        i++;
        letterBag.add(new Tile('M', 3, false));
        i++;
        letterBag.add(new Tile('M', 3, false));
        i++;
        letterBag.add(new Tile('P', 3, false));
        i++;
        letterBag.add(new Tile('P', 3, false));
        i++;
        letterBag.add(new Tile('Q', 10, false));
        i++;
        letterBag.add(new Tile('V', 4, false));
        i++;
        letterBag.add(new Tile('V', 4, false));
        i++;
        letterBag.add(new Tile('W', 4, false));
        i++;
        letterBag.add(new Tile('W', 4, false));
        i++;
        letterBag.add(new Tile('X', 8, false));
        i++;
        letterBag.add(new Tile('Y', 4, false));
        i++;
        letterBag.add(new Tile('Y', 4, false));
        i++;
        letterBag.add(new Tile('Z', 10, false));
        i++;
    }

    //The moveTile method takes "pieces" (Tiles) from your rack and moves it onto the board
    public void moveTile(Tile piece, int x, int y) {
        board[x][y] = piece.letter;
    }

    //toString is how the physical board is constructed
    public String toString() {
            String rv = "";
            rv += board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "|" + board[0][3] + "|" + board[0][4] + "|" + board[0][5] + "|" + board[0][6] + "|" + board[0][7] + "|" + board[0][8] + "|" + board[0][9] + "|" + board[0][10] + "|" + board[0][11] + "|" + board[0][12] + "|" + board[0][13] + "|" + board[0][14] + "|" + "\n";
            //  rv += "-----\n";
            rv += board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "|" + board[1][3] + "|" + board[1][4] + "|" + board[1][5] + "|" + board[1][6] + "|" + board[1][7] + "|" + board[1][8] + "|" + board[1][9] + "|" + board[1][10] + "|" + board[1][11] + "|" + board[1][12] + "|" + board[1][13] + "|" + board[1][14] + "|" + "\n";
            //  rv += "-----\n";
            rv += board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "|" + board[2][3] + "|" + board[2][4] + "|" + board[2][5] + "|" + board[2][6] + "|" + board[2][7] + "|" + board[2][8] + "|" + board[2][9] + "|" + board[2][10] + "|" + board[2][11] + "|" + board[2][12] + "|" + board[2][13] + "|" + board[2][14] + "|" + "\n";
            //   rv += "-----\n";
            rv += board[3][0] + "|" + board[3][1] + "|" + board[3][2] + "|" + board[3][3] + "|" + board[3][4] + "|" + board[3][5] + "|" + board[3][6] + "|" + board[3][7] + "|" + board[3][8] + "|" + board[3][9] + "|" + board[3][10] + "|" + board[3][11] + "|" + board[3][12] + "|" + board[3][13] + "|" + board[3][14] + "|" + "\n";
            //   rv += "-----\n";
            rv += board[4][0] + "|" + board[4][1] + "|" + board[4][2] + "|" + board[4][3] + "|" + board[4][4] + "|" + board[4][5] + "|" + board[4][6] + "|" + board[4][7] + "|" + board[4][8] + "|" + board[4][9] + "|" + board[4][10] + "|" + board[4][11] + "|" + board[4][12] + "|" + board[4][13] + "|" + board[4][14] + "|" + "\n";
            //   rv += "-----\n";
            rv += board[5][0] + "|" + board[5][1] + "|" + board[5][2] + "|" + board[5][3] + "|" + board[5][4] + "|" + board[5][5] + "|" + board[5][6] + "|" + board[5][7] + "|" + board[5][8] + "|" + board[5][9] + "|" + board[5][10] + "|" + board[5][11] + "|" + board[5][12] + "|" + board[5][13] + "|" + board[5][14] + "|" + "\n";
            //  rv += "-----\n";
            rv += board[6][0] + "|" + board[6][1] + "|" + board[6][2] + "|" + board[6][3] + "|" + board[6][4] + "|" + board[6][5] + "|" + board[6][6] + "|" + board[6][7] + "|" + board[6][8] + "|" + board[6][9] + "|" + board[6][10] + "|" + board[6][11] + "|" + board[6][12] + "|" + board[6][13] + "|" + board[6][14] + "|" + "\n";
            //  rv += "-----\n";
            rv += board[7][0] + "|" + board[7][1] + "|" + board[7][2] + "|" + board[7][3] + "|" + board[7][4] + "|" + board[7][5] + "|" + board[7][6] + "|" + board[7][7] + "|" + board[7][8] + "|" + board[7][9] + "|" + board[7][10] + "|" + board[7][11] + "|" + board[7][12] + "|" + board[7][13] + "|" + board[7][14] + "|" + "\n";
            //   rv += "-----\n";
            rv += board[8][0] + "|" + board[8][1] + "|" + board[8][2] + "|" + board[8][3] + "|" + board[8][4] + "|" + board[8][5] + "|" + board[8][6] + "|" + board[8][7] + "|" + board[8][8] + "|" + board[8][9] + "|" + board[8][10] + "|" + board[8][11] + "|" + board[8][12] + "|" + board[8][13] + "|" + board[8][14] + "|" + "\n";
            //  rv += "-----\n";
            rv += board[9][0] + "|" + board[9][1] + "|" + board[9][2] + "|" + board[9][3] + "|" + board[9][4] + "|" + board[9][5] + "|" + board[9][6] + "|" + board[9][7] + "|" + board[9][8] + "|" + board[9][9] + "|" + board[9][10] + "|" + board[9][11] + "|" + board[9][12] + "|" + board[9][13] + "|" + board[9][14] + "|" + "\n";
            //  rv += "-----\n";
            rv += board[10][0] + "|" + board[10][1] + "|" + board[10][2] + "|" + board[10][3] + "|" + board[10][4] + "|" + board[10][5] + "|" + board[10][6] + "|" + board[10][7] + "|" + board[10][8] + "|" + board[10][9] + "|" + board[10][10] + "|" + board[10][11] + "|" + board[10][12] + "|" + board[10][13] + "|" + board[10][14] + "|" + "\n";
            //   rv += "-----\n";
            rv += board[11][0] + "|" + board[11][1] + "|" + board[11][2] + "|" + board[11][3] + "|" + board[11][4] + "|" + board[11][5] + "|" + board[11][6] + "|" + board[11][7] + "|" + board[11][8] + "|" + board[11][9] + "|" + board[11][10] + "|" + board[11][11] + "|" + board[11][12] + "|" + board[11][13] + "|" + board[11][14] + "|" + "\n";
            //   rv += "-----\n";
            rv += board[12][0] + "|" + board[12][1] + "|" + board[12][2] + "|" + board[12][3] + "|" + board[12][4] + "|" + board[12][5] + "|" + board[12][6] + "|" + board[12][7] + "|" + board[12][8] + "|" + board[12][9] + "|" + board[12][10] + "|" + board[12][11] + "|" + board[12][12] + "|" + board[12][13] + "|" + board[12][14] + "|" + "\n";
            //  rv += "-----\n";
            rv += board[13][0] + "|" + board[13][1] + "|" + board[13][2] + "|" + board[13][3] + "|" + board[13][4] + "|" + board[13][5] + "|" + board[13][6] + "|" + board[13][7] + "|" + board[13][8] + "|" + board[13][9] + "|" + board[13][10] + "|" + board[13][11] + "|" + board[13][12] + "|" + board[13][13] + "|" + board[13][14] + "|" + "\n";
            //   rv += "-----\n";
            rv += board[14][0] + "|" + board[14][1] + "|" + board[14][2] + "|" + board[14][3] + "|" + board[14][4] + "|" + board[14][5] + "|" + board[14][6] + "|" + board[14][7] + "|" + board[14][8] + "|" + board[14][9] + "|" + board[14][10] + "|" + board[14][11] + "|" + board[14][12] + "|" + board[14][13] + "|" + board[14][14] + "|" + "\n";
            //  rv += "-----\n";
            //rv += board[15][0] + "|" + board[15][1] + "|" + board[15][2] + "|" + board[15][3] + "|" + board[15][4] + "|" + board[15][5] + "|" + board[15][6] + "|" + board[15][7] + "|" + board[15][8] + board[15][9] + "|" + board[15][10] + "|" + board[15][11] + "|" + board[15][12] + "|" + board[15][13] + "|" + board[15][14] + "|" +  "\n";
            return rv;

    }
        /* This is the play method. It uses all the other methods as helper functions and essentially plays the game.
        */
        public void play() throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (!letterBag.isEmpty()) {
            while (size(rack1) < 7) {
                getTile(rack1);
            }
            while (size(rack2) < 7) {
                getTile(rack2);
            }


            System.out.print(this);
            System.out.println("---");
            // System.out.println("User Score:" + userScore);

            // temp score
            int tempScore = 0;

            // Set to keep track of indices of tiles in rack that are currently being played
            HashSet<Tile> playedTiles = new HashSet<>();

            while (true) {
                // only print tiles in rack that are not being played (ie tile.played = false)
                printRack(rack1);
                System.out.print("Letter: ");
                String letter = scanner.nextLine();
                if (letter.equals("Done")) {
                    if (isValid()) {
                        userScore += computeScore(getAllWordsOnBoard());
                        System.out.println("User Score:" + userScore);
                        //    System.out.println(computerMove());


                    } else {
                        System.out.println("Try again!");
                        resetRack(playedTiles);
                        System.out.println(WordsPlayed);
                    }
                    break;


                System.out.print("x-coordinate: ");
                int x = scanner.nextInt();
                scanner.nextLine();
                System.out.print("y-coordinate: ");
                int y = scanner.nextInt();
                scanner.nextLine();

                if (x < 0 || y < 0 ||
                        x >= 15 || y >= 15) {
                    System.out.println("Out of bounds, try again!");
                    continue;
                }

                try {
                    Tile piece = findTile(letter.charAt(0), x, y, playedTiles);
                    moveTile(piece, x, y);


                    System.out.println(this);
                } catch (Exception e) {
                    System.out.println("Select a different tile");
                }
            }

        }

        }
    
    //In theory this should have been used to eventually end the Play method
    public boolean isDone() {
        // bag is empty
        // either: someone runs out of tiles OR
        // no more moves can be made
        return false;
    }
            
    //The getScoreForLetter returns the value of a Tile
    public static int getScoreForLetter(char c) {
        //  String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] scores = new int[]{1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

        return scores[c - 'A'];
        // return scores[];
    }

    // return tile that corresponds to user input and adds it to playedTiles
    public Tile findTile(char c, int x, int y, HashSet<Tile> playedTiles) throws Exception {
        for (Tile tile : rack1) {
            if (tile.letter == c && !tile.played) {
                tile.played = true;
                tile.x = x;
                tile.y = y;

                playedTiles.add(tile);
                return tile;
            }
        }

        throw new Exception("Tile does not exist");
    }

    //The printRack method allows the user to see what tiles he/she can use
    public void printRack(ArrayList<Tile> rack) {
        for (Tile tile : rack) {
            if (tile.played) continue;
            System.out.print(tile + " ");
        }

        System.out.println();
    }

    public int size(ArrayList<Tile> rack) {
        int count = 0;
        for (Tile tile : rack) {
            if (!tile.played) count++;
        }

        return count;
    }

    //When a word is invalid, the resetRack method returns the tiles back to the user's rack
    public void resetRack(HashSet<Tile> playedTiles) {
        for (Tile tile : playedTiles) {
            tile.played = false;
            this.board[tile.x][tile.y] = ' ';

        }
    }

    /*getAllWordsOnBoard returns a list of all the words on the board. The ones that are not in the HashSet called WordsPlayed
      are the words whose values are going to be calculated in computeScore */     
    public List<String> getAllWordsOnBoard() {
        // Get Words in Rows
        List<String> words = new ArrayList<>();
        for (char[] row : board) {
            StringBuilder b = new StringBuilder();
            for (char c : row) {
                b.append(c);
            }
            String[] wordsInRow = b.toString().split(" ");
            for (String word : wordsInRow) {
                if (word.length() > 1)
                    words.add(word);
            }
        }

        for (int col = 0; col < 15; col++) {
            StringBuilder b = new StringBuilder();
            for (int row = 0; row < 15; row++) {
                b.append(board[row][col]);
            }
            String[] wordsInRow = b.toString().split(" ");
            for (String word : wordsInRow) {
                if (word.length() > 1)
                    words.add(word);
            }
        }

        return words;
    }

    // isValid checks each row and column to see if board is valid
    public boolean isValid() {

        List<String> words = getAllWordsOnBoard();
        System.out.println(words);
        for (String word : words) {
            if (!checkValidity(word)) return false;
        }

        return true;
    }

    //computeScore calculates the score of words played
    public int computeScore(List<String> words) {
        int totalScore = 0;
        for (String word : words) {
            if (!WordsPlayed.contains(word))
                totalScore += computeScore(word);
            WordsPlayed.add(word);

        }
        return totalScore;
    }

    public int computeScore(String word) {
        int score = 0;
        for (Character c : word.toCharArray()) {
            score += getScoreForLetter(c);
        }

        return score;
    }

    //checkValidity is a helper function for isValid. The combination of the two makes sure a word can be played
    public boolean checkValidity(String str) {
        String[] words = str.split("\\s+");
        //  for(String s : words) System.out.println("Testing: " + s);
        for (String word : words) {
            if (word.equals("")) {
                continue;
            }
            if (!wordsDictionary.isWord(word)) {
                return false;
            }
        }

        return true;
    }

    /*AI: Unfortunately, I was not able to get my AI to work. The following is a sketch of what the AI code would have looked
    like. It begins by finding some group of letters on the board and then checks to see what words in the dictionary contain
    these letters as a substring. It makes a list of the ones that do. That list then is filtered to become only words that can
    made with the letters in rack2 (the computer's rack). Finally, the words are filtered through the idValid method, and from 
    those that make it through, the one with the highest score is put on the board*/
    /*

    public List<String> getSubstring() {
        List<String> substrings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int col = 0; col < 15; col++) {
            for (int row = 0; row < 15; row++) {
                if (board[col - 1][row] == ' ') {
                    for (int y = col; y > 0; y--) {
                        sb.insert(0, y);
                    }
                }
            }
        }
        substrings.add(substrings);
    }

    public String[] potentialWords(List<String> substrings) {
        List<String> potentialWords = new ArrayList<>();
        for (String substring: substrings) {
            if(wordsDictionary.contains(substring.startsWith(substring))){
                potentialWords.add(substring);
            }
        }

    }

    public String[] containsNeededLetters(List<String> potentialWords){
        List<String> validWords = new ArrayList<>();
        for (String potentialWord: potentialWords) {
            if(potentialWord.contains(lettersinRack2){
                validWords.add(potentialWord);
            }
        }
    }

    public void computerMove() {
        for(w : potentialWords){
            newBoard = board.put(w, spot - w.indexof(substring));
            if isValid(newBoard){
                board = newBoard;
                computeScore(potentialWord);
                return;
            }
        }
    }

     */


}

