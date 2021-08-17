/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifba.aqs.pipeandfilter;

/* Import Jsoup para biblioteca Jsoup / Import Jsoup for library*/
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

        
        /* Instacias abaixo para tratar o arquivo / instances below to handle the file*/ 
        File file = new File("C:\\Users\\Questor206\\Documents\\NetBeansProjects\\AQS---PIPE-AND-FILTER\\PipeandFilter\\src\\com\\ifba\\aqs\\pipeandfilter\\Resultados Mega Sena.HTM");
        Document doc = Jsoup.parse(file, null);
        Element table = doc.select("table").first();
        Iterator<Element> ite = table.select("td").iterator();
        TableBuild tabbuild = new TableBuild();
        Concurso sena = new ConcursoSena();
        List<BigDecimal> list = new ArrayList<>();
        List<String> listUF = new ArrayList<>();
        String[][] array = new String[1851][21];

        tabbuild.buildTable(ite); //Passa o Iterador para construir a tabela no array / Pass iterator to build array table
               
        tabbuild.convert(); //Extrai os valores da mega para um list /Extracts values from array to a list
        tabbuild.convertUF(); //Extrai os valores da uf para um list /Extracts values from array to a list
        sena.order(tabbuild.getList()); //ordena uma lista / order a list
        array = sena.orderBy(tabbuild.getArr());
        
        System.out.println("Ordenação por prêmio: \n");
        for (int i = 0; i < 1851; i++) {
            for (int j = 0; j < 21; j++) {
               System.out.print(array[i][j]+"  ");
            }
            System.out.println();
        }

         System.out.println("Soma das premiações: " + sena.valueTop(tabbuild.getList()));
         System.out.println("Vezes que o prêmio foi maior que 40 mi:" + sena.valueTop40mi(tabbuild.getList()));
        System.out.println("Vezes que o prêmio foi maior que 40 mi e para Distrito Federal:" + sena.returnDF(tabbuild.getListUF(), tabbuild.getList()));
    }
}
