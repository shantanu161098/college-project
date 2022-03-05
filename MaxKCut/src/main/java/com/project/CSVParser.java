package com.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    public static List<Edge> parseCSV(String fileName) {
        List<Edge> listOfEdges = new ArrayList<Edge>();
        try {
            FileReader file = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(file);
            reader.readLine();
            String line = "";
            while ((line = reader.readLine()) != null) {

                String[] graphList = line.split(",");
                listOfEdges.add(new Edge(Integer.parseInt(graphList[0]), Integer.parseInt(graphList[1]), Integer.parseInt(graphList[2])));
            }
        } catch (Exception e) {
            System.out.println();
        }


        return listOfEdges;
    }

    public static void main(String[] args) {
        parseCSV("/home/shantanu/backend/kdu-backend-examples/temp/Resource/soc-sign-bitcoinotc.csv");
    }
}
