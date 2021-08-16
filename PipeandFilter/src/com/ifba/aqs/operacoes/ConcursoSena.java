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
 *
 * @author Questor206
 */
public class ConcursoSena extends Concurso {

    private List<BigDecimal> list = new ArrayList<>();
    private HashMap<String, Double> map = new HashMap<>();
    private Double[] doub = new Double[1851];
    private BigDecimal money = new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_UP);
    private int cont = 0;

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
        for(BigDecimal d : list){
            this.list.add(d);
        }
        Collections.sort(this.list);
        return this.list;
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
            System.out.println(listuf.get(i) + "   " + list.get(i));
            if (list.get(i).compareTo(new BigDecimal(40000000.00)) == 1 && listuf.get(i).equals("DF")) {
                cont++;
            }
        }
        return cont;
    }
}
