package SummerText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private String csvFile;
    private static final int MAX_WIDTH = 20;

    public CsvReader(String csvFile) {this.csvFile = csvFile;}

    public void readCsv() {
        String line = "";
        String csvSplitBy = ",";
        List<Integer> columnWides = new ArrayList<>();
        List<String[]> allRows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "UTF-8"))){
            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSplitBy);

                if (values[2].equals("P")) {
                    values[2] = "Prime";
                } else if (values[2].equals("S")) {
                    values[2] = "Standard";
                } else if (values[2].equals("G")) {
                    values[2] = "Growth";
                }

                try {
                    long shareIssued = Long.parseLong(values[3]);
                    values[3] = formatNumber(shareIssued);
                }catch (NumberFormatException e) {
                    System.out.println();
                }

                allRows.add(values);

                for (int i = 0; i < values.length; i++) {
                    int width = Math.min(values[i].length(), MAX_WIDTH);
                    if (columnWides.size() <= i){
                        columnWides.add(width);
                    } else {
                        columnWides.set(i, Math.max(columnWides.get(i), width));
                    }
                }
            }
            if (!allRows.isEmpty()) {
                printSpecialSeparator(columnWides);

                for (int row = 0; row < allRows.size(); row++) {
                    String[] values = allRows.get(row);

                    System.out.print("|");
                    for (int i = 0; i < values.length; i++) {
                        String value = truncate(values[i], columnWides.get(i));

                        if (i == 3 && isNumeric(values[i])) {
                            System.out.printf(" %" + columnWides.get(i) + "s |", value);
                        }else {
                            System.out.printf(" %-" + columnWides.get(i) + "s |", value);
                        }
                    }
                    System.out.println();

                    if (row == 0) {
                        printSpecialSeparator(columnWides);
                    }
                }
                printSpecialSeparator(columnWides);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void printSpecialSeparator(List<Integer> columnWidths) {
        String separator = "|";
        for (int width : columnWidths) {
            separator += "=".repeat(width + 2) + "|";
        }
        System.out.println(separator);
    }

    private String truncate(String value, int widths) {
        if (value.length() > widths) {
            return value.substring(0, widths - 3) + "...";
        }else {
            return value;
        }
    }

    private String formatNumber(long number) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(number);
    }


    private boolean isNumeric(String value) {
        try {
            Long.parseLong(value.replace("," , ""));
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }
}
