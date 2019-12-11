package com.company;
//extends com.company.Scrabble;
public class Main {
    public static void main(String[] args) throws Exception {
        Scrabble game = new Scrabble();
        //System.out.println(game);
        game.fillletterBag();
        game.play();


    }
}