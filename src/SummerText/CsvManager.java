package SummerText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CsvManager {
    private String csvFile;

    public CsvManager(String csvFile) {
        this.csvFile = csvFile;
    }

    public void displayCsv() {
        CsvReader csvReader = new CsvReader(csvFile);
        csvReader.readCsv();
    }
}