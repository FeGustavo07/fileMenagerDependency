package com.fileManager;

import java.io.*;
import java.util.ArrayList;


public class FileWriter {

    public void writeLine(ArrayList<String[]> table, String fileName){
        for (String[] matches : table) {
            for (String match : matches) {
                try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true))) {
                    printWriter.print(match + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
