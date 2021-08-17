/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifba.aqs.operacoes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Questor206
 */
public abstract class Concurso {

    protected List<BigDecimal> list = new ArrayList<>();

    abstract public void setList(String[][] array);

    abstract public List<BigDecimal> order(List<BigDecimal> list);

    abstract public BigDecimal valueTop(List<BigDecimal> list);

    abstract public int valueTop40mi(List<BigDecimal> list);

    abstract public int returnDF(List<String> listuf, List<BigDecimal> list);
    abstract public String[][] orderBy(String[][] array);

}
