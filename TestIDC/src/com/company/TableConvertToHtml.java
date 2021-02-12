package com.company;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import org.apache.commons.io.FileUtils;

public class TableConvertToHtml {
    private Tables table;
    private StringBuilder style = new StringBuilder();
    private StringBuilder body = new StringBuilder();
    private File htmlTemplateFile = new File("C:/Studium/TestIDC/src/com/template.html");

    public TableConvertToHtml(Tables table) {
        this.table = table;
    }

    public void convertToHtml(){
        DecimalFormat df = new DecimalFormat("#0.000");
        style.append("<style>  table, th ,td {\n");
        style.append("border: 1px solid black;\n");
        style.append("border-collapse: collapse;\n");
        style.append("width: 500px;\n");
        style.append("text-align: center;}\n");
        style.append("#firstRow {background-color: gray;}\n");
        style.append("#lastRow {background-color: yellow;}\n");
        style.append("</style>");


        body.append("\n<table>\n");
        body.append("<tr id=\"firstRow\">\n");
        body.append("<th>Vendor</th>\n");
        body.append("<th>Units</th>\n");
        body.append("<th>Share</th>\n");
        body.append("</tr>\n");

        for (Table table1 : table.getTable()) {
            body.append("<tr>\n");
            body.append("<td>"+table1.getVendor()+"</td>\n");
            body.append("<td>"+table1.getUnits()+"</td>\n");
            body.append("<td>"+df.format(table1.getShare())+"%"+"</td>\n");
            body.append("</tr>\n");
        }

        df = new DecimalFormat("#0");
        body.append("<tr id=\"lastRow\">\n");
        body.append("<th>Total</th>\n");
        body.append("<th>"+table.getSumOfUnits()+"</th>\n");
        body.append("<th>"+df.format(table.getSumOfShares())+"%"+"</th>\n");
        body.append("</tr>\n");
        body.append("</table>");

    createNewHtmlFile();
    }

    private void createNewHtmlFile(){
        String title = "Table";
        String htmlString;
        try {
            htmlString = FileUtils.readFileToString(htmlTemplateFile,"UTF-8");
            htmlString = htmlString.replace("$title", title);
            htmlString = htmlString.replace("$body", body);
            htmlString = htmlString.replace("$style", style);
            File newHtmlFile = new File("C:/Studium/TestIDC/src/com/new.html");
            FileUtils.writeStringToFile(newHtmlFile,htmlString,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
