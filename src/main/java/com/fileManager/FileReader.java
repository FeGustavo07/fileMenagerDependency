package com.fileManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class FileReader {

    public ArrayList<String[]> handleFile(String file) {
        String initialRow = "";
        String separator = ";";

        ArrayList<String[]> row = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            while ((initialRow = reader.readLine()) != null) {
                String[] definitiveRow = initialRow.split(separator);
                row.add(definitiveRow);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return row;
    }


    public <T> ArrayList<T> readFileWithTemplate(T template, String uri){
        Class<?> templateClass = template.getClass();
        Field[] fields = templateClass.getFields();
        Object newObject;

        ArrayList<T> objectsOfLines = new ArrayList<>();
        ArrayList<String[]> lines = this.handleFile(uri);


        try {
            Constructor<?> construct = templateClass.getConstructor();

            for (String[] line : lines) {
                newObject =  construct.newInstance();
                for (int index = 0; index < line.length && index < fields.length; index++) {
                        fields[index].setAccessible(true);
                        fields[index].set(newObject , line[index]);
                        objectsOfLines.add((T) newObject);
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException |
                InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return objectsOfLines;
    }

}

