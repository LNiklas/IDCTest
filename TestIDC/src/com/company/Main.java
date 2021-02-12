package com.company;

public class Main {

    public static void main(String[] args) {
        Tables tables = new Tables(new CsvProcessing("data").getBeans());
        tables.sortRowsAlphabet();
        TableConvertToHtml tc = new TableConvertToHtml(tables);
        tc.convertToHtml();

    }
}
