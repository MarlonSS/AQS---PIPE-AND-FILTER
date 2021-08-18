/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifba.aqs.operacoes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * ESTA CLASSE MANIPULA OS DADOS DA LISTA /THIS CLASS MANIPULATES THE LIST DATA
 *
 * @author Questor206
 */
public class ConcursoSena extends Concurso {

    private List<BigDecimal> list = new ArrayList<>();
    private BigDecimal money = new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_UP);
    private int cont = 0;
    private String[][] arr = new String[1851][21];

    @Override
    public void setList(String[][] array) {
        String var = null;
        for (int i = 0; i < 1851; i++) {
            var = array[i][12].replace(",", "");
            var = var.replace(".", "");
            money = new BigDecimal(var);
            list.add(money);
        }
    }

    public List<BigDecimal> getList() {
        return list;
    }

    @Override
    public List<BigDecimal> order(List<BigDecimal> list) {
        for (BigDecimal d : list) {
            this.list.add(d);
        }
        Collections.sort(this.list);
        return this.list;
    }

    public String[][] orderBy(String[][] array) {
        String var = null;
        int var2 = 0;
        try {
            while (var2 < 1851) {
                for (int m = 0; m < 1851; m++) {
                    var = array[m][12].replace(".", "");
                    var = var.replace(",", ".");
                    if (this.list.get(var2).toString().equals(var)) {
                        for (int j = 0; j < 21; j++) {
                            this.arr[var2][j] = array[m][j];
                        }
                        var2++;
                    }
                }
            }
        } catch (Exception e) {

        }
        return this.arr;
    }

    @Override
    public BigDecimal valueTop(List<BigDecimal> list) {
        String resultado;
        BigDecimal soma = BigDecimal.ZERO;
        for (BigDecimal d : list) {
            soma = soma.add(d);
        }

        return soma;
    }

    @Override
    public int valueTop40mi(List<BigDecimal> list) {
        cont = 0;
        for (BigDecimal d : list) {
            if (d.compareTo(new BigDecimal(40000000.00)) == 1) {
                cont++;
            }
        }
        return cont;
    }

    @Override
    public int returnDF(List<String> listuf, List<BigDecimal> list) {
        cont = 0;

        for (int i = 0; i < 1851; i++) {
            if (list.get(i).compareTo(new BigDecimal(40000000.00)) == 1 && listuf.get(i).equals("DF")) {
                cont++;
            }
        }
        return cont;
    }
}
