package com.jeco.ui.view;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
 
 
public class GeradorDeGrafico {
  
 public static void main(String[] args) throws IOException {
  //criar um conjunto de dados...
  DefaultCategoryDataset ds = new DefaultCategoryDataset();
  ds.addValue(40.5, "maximo", "dia 1");
  ds.addValue(38.2, "maximo", "dia 2");
  ds.addValue(31.5, "maximo", "dia 3");
  ds.addValue(42.5, "maximo", "dia 4");
  ds.addValue(10.2, "maximo", "dia 5");
   
  //cria o grafico..
  JFreeChart grafico = ChartFactory.createLineChart("GraficoJFreeChart" ,"Dia", "Valor",ds, 
                PlotOrientation.VERTICAL, true, true, false);
   
  FileOutputStream arquivo = new FileOutputStream ("grafico.png");
  ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
   
 } 
}