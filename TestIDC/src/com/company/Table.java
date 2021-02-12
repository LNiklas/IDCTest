package com.company;

import com.opencsv.bean.CsvBindByName;

public class Table {

    @CsvBindByName
    private String vendor;
    @CsvBindByName
    private double units;
    @CsvBindByName
    private String timescale;
    @CsvBindByName
    private String country;
    private double share;

    public String getCountry() { return country;}

    public String getTimescale() {
        return timescale;
    }

    public String getVendor() {
        return vendor;
    }

    public double getUnits() {
        return units;
    }

    public double getShare() {
        return share;
    }

    public void setShare(double share) {
        this.share = share;
    }
}
