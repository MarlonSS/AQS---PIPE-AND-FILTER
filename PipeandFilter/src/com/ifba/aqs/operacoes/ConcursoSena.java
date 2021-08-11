/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifba.aqs.operacoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Questor206
 */
public class ConcursoSena extends Concurso {

    private List<Double> list = new ArrayList<>();
    private HashMap<String, Double> map = new HashMap<>();
    private Double[] doub = new Double[1851];

    @Override
    public void setList(String[][] array) {
        String var = null;
        for (int i = 0; i < 1851; i++) {
            var = array[i][12].replace(",", ".");
            var = var.replace(".", "");
            list.add(Double.parseDouble(var));
            doub[i] = Double.parseDouble(var);

        }

    }

    @Override
    public List<Double> order() {

        Collections.sort(list);
        return list;
    }

    @Override
    public String valueTop() {
        String resultado;
        double soma = 0.00;
        for (Double d : list) {
            soma = soma + d;
        }
        return resultado = String.format("%.2f", soma);
    }

    @Override
    public int valueTop40mi() {
        int cont = 0;
        for (Double d : list) {
            if (d > 40000000.00	) {
                cont++;
            }
        }
        return cont;
    }

    @Override
    public int returnDF(String[][] array) {
        int cont = 0, cont2 = 0;
        

        for (int i = 0; i < 1851; i++) {
            if (list.get(i) > 40000000.00 && array[i][11].equals("DF")) {

                System.out.print(" "+array[i][11]+"  "+(Double.valueOf(list.get(i)).longValue()));
                cont++;

            }
        }
        return cont;
    }
}
