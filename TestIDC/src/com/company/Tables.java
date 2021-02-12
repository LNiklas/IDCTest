package com.company;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;

public class Tables {
    private List<Table> table;
    private double sumOfUnits=0;
    private double sumOfShares=0;

    public Tables(List<Table> table) {
        this.table = table;
        setSums();
    }

    public List<Table> getTable() {
        return table;
    }

    public double getSumOfShares() {
        return sumOfShares;
    }
    public double getSumOfUnits() {
        return sumOfUnits;
    }

    public void setSums(){

        for (Table t1 : table) {
            sumOfUnits+= t1.getUnits();
        }
        for (Table t1 : table) {
            t1.setShare((t1.getUnits()/sumOfUnits)*100);
        }

        for (Table t1 : table) {
            sumOfShares+= t1.getShare();
        }
    }

    public void printTable(){
        DecimalFormat df = new DecimalFormat("#0.000");
        System.out.format("%20s%20s%20s", "Vendor", "Units", "Share");
        System.out.println();
        for (Table t1 : table) {
            System.out.format("%20s%20f%20s", t1.getVendor(), t1.getUnits(), df.format(t1.getShare())+"%");
            System.out.println();
                   }
        System.out.format("%20s%20f%20s", "Total", sumOfUnits, df.format(sumOfShares)+"%");
    }

    public void searchingByVendor(String vendor, String quarter){
        for (Table t1 : table) {
            if(t1.getVendor().equals(vendor) && t1.getTimescale().equals(quarter)){
                System.out.println(vendor +" sold "+t1.getUnits()+" units with share of "+t1.getShare());
            }
        }
    }

    public void findVendor(String vendor){
        for (Table t1 : table) {
            if(t1.getVendor().equals(vendor)){
                System.out.println("On the "+ (table.indexOf(t1)+1)+ " row");
            }
        }
    }

    public void sortRowsAlphabet(){
        table.sort(Comparator.comparing(Table::getVendor));
    }

    public void sortRowsByUnit(){
        table.sort(Comparator.comparing(Table::getUnits));
    }




    }

