package com.journaldev.readfileslinebyline;

import java.io.*;
import java.util.*;

public class ExcerciseNo1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("txtfile.txt");
        Scanner scan = new Scanner(file);
        String data;
        ArrayList<String> words = new ArrayList<String>();
        while (scan.hasNextLine()) {
            data = scan.nextLine();
            words.add(data);
        }
        Collections.sort(words);
        List<String> csvData = createCsvDataSpecial(words);
        for(String element : csvData) {
            System.out.println(element);
        }
    }
    private static List<String> createCsvDataSpecial(ArrayList<String> words){
        String header = "ID,Word";
        List<String> list = new ArrayList<>();
        int id = 1;
        for(String element : words) {
            String lineWithId = id++ + "," + element;
            list.add(lineWithId);
        }
        System.out.println(header);
        return list;
    }
}