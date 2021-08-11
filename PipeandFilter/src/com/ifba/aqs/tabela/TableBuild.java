/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifba.aqs.tabela;

import java.util.Iterator;
import org.jsoup.nodes.Element;

/**
 *
 * @author Questor206
 */
public class TableBuild {

    private String[][] arr = new String[1851][21];
    int aux1;

    public TableBuild() {
        aux1 = 0;

    }

    public String[][] getArr() {
        return arr;
    }

    public void setArr(String[][] arr) {
        this.arr = arr;
    }

    public void insertInto(String str, int i, int j) {
        arr[i][j] = str;
    }

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

    public void build() {
        for (int i = 0; i < 1851; i++) {
            for (int j = 0; j < 21; j++) {

            }

        }

    }

    private void convert() {
        for (int i = 0; i < 1851; i++) {
            //   arr[i][12];
        }

    }

}
