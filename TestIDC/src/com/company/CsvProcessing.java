package com.company;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvProcessing {
    private String nameOfTheFile;
    private List<Table> beans= new ArrayList<>();


    public List<Table> getBeans() {
        return beans;
    }

    public CsvProcessing(String nameOfTheFile) {
        this.nameOfTheFile = nameOfTheFile;
        createTable();
    }

    public void createTable(){
        try {
            beans = new CsvToBeanBuilder<Table>(new FileReader(nameOfTheFile+".csv")).withType(Table.class).build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }






}
