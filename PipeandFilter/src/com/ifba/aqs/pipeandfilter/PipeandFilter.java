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
import java.util.Iterator;
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

        File file = new File("C:\\Users\\Questor206\\Documents\\NetBeansProjects\\PipeandFilter\\src\\com\\ifba\\aqs\\pipeandfilter\\Resultados Mega Sena.HTM");
        Document doc = Jsoup.parse(file, null);
        Element table = doc.select("table").first();
        Iterator<Element> ite = table.select("td").iterator();
        TableBuild tabbuild = new TableBuild();
        Concurso sena = new ConcursoSena();

        tabbuild.buildTable(ite);
        tabbuild.build();

        // String[][] array = new String[1851][21];
        sena.setList(tabbuild.getArr());

        sena.order();

        System.out.println("Soma das premiações: " + sena.valueTop());
        System.out.println("Vezes que o prêmio foi maior que 40 mi:" + sena.valueTop40mi());
        System.out.println("Vezes que o prêmio foi maior que 40 mi e para Distrito Federal:" + sena.returnDF(tabbuild.getArr()));
    }
}
