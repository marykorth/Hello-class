package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Dictionary {
    HashSet<String> words = new HashSet<>();

    public Dictionary(String fileName) throws IOException {
        FileReader reader = new FileReader( new File(fileName));
        BufferedReader breader = new BufferedReader(reader);
        String input = null;
        while ((input = breader.readLine()) != null) {
            input = input.trim().toUpperCase();
            words.add(input);
        }
    }
    public boolean isWord(String word) {
        if (words.contains(word)) return true;
        else return false;
    }
}
