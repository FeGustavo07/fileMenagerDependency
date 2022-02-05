package com.fileManager;

import java.io.*;
import java.util.ArrayList;


public class FileWriter {

    public void writeChampionshipStandings(String data, String fileName, String dirPath){
            new File(dirPath).mkdir();
            try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true))) {
                printWriter.print(data + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void writeSeparateTeams(ArrayList<String> message, String fileName, String dirPath){
        new File(dirPath).mkdir();
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true))) {
            for ( String row : message) {
                printWriter.print(row + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




