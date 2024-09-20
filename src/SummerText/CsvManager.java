package SummerText;

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
