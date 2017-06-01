/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.dao.ObraDAO;
import edu.co.sergio.mundo.vo.Obra;
import java.awt.BasicStroke;
import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ChartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        JFreeChart[] chart = getChart();
        
        int width = 500;
        int height = 350;
        for (int i = 0; i < chart.length; i++) {
            ChartUtilities.writeChartAsPNG(outputStream, chart[i], width, height);
        }
        

    }

    public JFreeChart[] getChart() {

        DefaultPieDataset dataset = new DefaultPieDataset();
        ObraDAO dAO = new ObraDAO();
        //Crear la capa de servicios que se enlace con el DAO
        ArrayList<Obra> arrayList = (ArrayList<Obra>) dAO.findAll();
        double sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            sum = arrayList.get(i).getValor() + sum;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getValor() != 0) {
                double porcentaje = (arrayList.get(i).getValor() / sum) * 100;
                dataset.setValue(arrayList.get(i).getNombreAutor(), porcentaje);
            } else {
                double porcentaje = 0;
                dataset.setValue(arrayList.get(i).getNombreAutor(), porcentaje);
            }
        }

        boolean legend = true;
        boolean tooltips = false;
        boolean urls = false;

        JFreeChart chart = ChartFactory.createPieChart("Obras", dataset, legend, tooltips, urls);

        chart.setBorderPaint(Color.GREEN);
        chart.setBorderStroke(new BasicStroke(5.0f));
        chart.setBorderVisible(true);

        
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        dataset2.addValue(25.0, "Series 1", "Category 1");   
        dataset2.addValue(34.0, "Series 1", "Category 2");   
        dataset2.addValue(19.0, "Series 2", "Category 1");   
        dataset2.addValue(29.0, "Series 2", "Category 2");   
        dataset2.addValue(41.0, "Series 3", "Category 1");   
        dataset2.addValue(33.0, "Series 3", "Category 2");   

		
        JFreeChart chart2 = ChartFactory.createBarChart3D(
            "3D Bar Chart Demo",      // chart title
            "Category",               // domain axis label
            "Value",                  // range axis label
            dataset2,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        CategoryPlot plot = chart2.getCategoryPlot();
        CategoryAxis axis2 = plot.getDomainAxis();
        axis2.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
        );
        
        CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setItemLabelsVisible(true);
        BarRenderer r = (BarRenderer) renderer;
        r.setMaximumBarWidth(0.05);
        JFreeChart[] chartfinal= new JFreeChart[2];
        chartfinal[0]=chart;
        chartfinal[1]=chart2;
        return chartfinal;

		
	}
    }