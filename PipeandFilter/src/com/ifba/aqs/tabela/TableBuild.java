/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifba.aqs.tabela;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.nodes.Element;

/**
 * ESTA TABELA PREENCHE UM ARRAY COM OS DADOS / THIS TABLE FILL IN AN ARRAY WITH THE DATA

 * @author Questor206
 */
public class TableBuild {

    private String[][] arr = new String[1851][21];
    private List<BigDecimal> list = new ArrayList<>();
    private List<String> listUF = new ArrayList<>();
    private int aux1;
    private BigDecimal big = new BigDecimal("0.0");
    private String var = "";

    public TableBuild() {
        aux1 = 0;

    }

    public void insertInto(String str, int i, int j) {
        arr[i][j] = str;
    }

    //METODO CONTROI O ARRAY / METHOD BUILD THE ARRAY
    public void buildTable(Iterator<Element> list) { 
        try {
            while (list.hasNext()) {
                for (int i = 0; i < 21; i++) {
                    arr[aux1][i] = list.next().text();
                }
                aux1++;
            }
        } catch (Exception e) {

        }
    }

    public List<BigDecimal> getList() {
        return list;
    }

    public void convert() {
        for (int i = 0; i < 1851; i++) {
            var = arr[i][12].replace(".", "");
            var = var.replace(",", ".");
            big = new BigDecimal(var);
            big.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            list.add(big);
        }

    }

    public void convertUF() {
        for (int i = 0; i < 1851; i++) {
            if (arr[i][11].equals("") || arr[i][11] == null) {
                listUF.add(" ");
            } else {
                listUF.add(arr[i][11]);
            }

        }
    }

    public List<String> getListUF() {
        return listUF;
    }

    public String[][] getArr() {
        return arr;
    }

}
