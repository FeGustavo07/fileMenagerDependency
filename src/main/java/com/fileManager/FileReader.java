package com.fileManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader {

    public ArrayList<String[]> handleFile(String file) {

        BufferedReader reader = null;

        String initialRow = "";

        String separator = ";";

        ArrayList<String[]> matches = new ArrayList<>();

        try {
            reader = new BufferedReader(new java.io.FileReader(file));

            while ((initialRow = reader.readLine()) != null) {
                String[] definitiveRow = initialRow.split(separator);
                matches.add(definitiveRow);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return matches;
    }

}

