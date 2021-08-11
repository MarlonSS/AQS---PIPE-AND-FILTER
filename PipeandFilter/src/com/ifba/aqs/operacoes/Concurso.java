/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifba.aqs.operacoes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Questor206
 */
public abstract class Concurso {

    protected List<Double> list = new ArrayList<>();

    abstract public void setList(String[][] array);

    abstract public List<Double> order();

    abstract public String valueTop();

    abstract public int valueTop40mi();

    abstract public int returnDF(String[][] array);

}
