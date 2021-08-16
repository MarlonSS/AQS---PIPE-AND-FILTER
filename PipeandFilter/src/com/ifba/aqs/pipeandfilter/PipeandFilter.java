/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifba.aqs.pipeandfilter;

import com.ifba.aqs.operacoes.Concurso;
import com.ifba.aqs.operacoes.ConcursoSena;
import com.ifba.aqs.tabela.TableBuild;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Questor206
 */
public class PipeandFilter {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        File file = new File("C:\\Users\\Black_Hammer\\Documents\\NetBeansProjects\\AQSPipeandFilter\\PipeandFilter\\src\\com\\ifba\\aqs\\pipeandfilter\\Resultados Mega Sena.HTM");
        Document doc = Jsoup.parse(file, null);
        Element table = doc.select("table").first();
        Iterator<Element> ite = table.select("td").iterator();
        TableBuild tabbuild = new TableBuild();
        Concurso sena = new ConcursoSena();
        List<BigDecimal> list = new ArrayList<>();
        List<String> listUF = new ArrayList<>();

        tabbuild.buildTable(ite);
        // tabbuild.build();

        // String[][] array = new String[1851][21];
        //sena.setList(tabbuild.getArr());
        tabbuild.convert();
        tabbuild.convertUF();

        System.out.println(tabbuild.getList());
        System.out.println("Soma das premiações: " + sena.valueTop(tabbuild.getList()));
        System.out.println("Vezes que o prêmio foi maior que 40 mi:" + sena.valueTop40mi(tabbuild.getList()));
        System.out.println("Vezes que o prêmio foi maior que 40 mi e para Distrito Federal:" + sena.returnDF(tabbuild.getListUF(), tabbuild.getList()));
    }
}
