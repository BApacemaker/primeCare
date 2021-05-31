package controller;
 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
 
@ManagedBean
public class ChartView implements Serializable {
 
    private LineChartModel areaModel;
 
    @PostConstruct
    public void init() {
        createAreaModel();
    }
 
    public LineChartModel getAreaModel() {
        return areaModel;
    }
     
    private void createAreaModel() {
        areaModel = new LineChartModel();
 
        LineChartSeries boys = new LineChartSeries();
        boys.setFill(true);
        boys.setLabel("Inpatients");
        boys.set("2017", 120);
        boys.set("2018", 100);
        boys.set("2019", 22);
        boys.set("2020", 150);
        boys.set("2021", 25);
 
        LineChartSeries girls = new LineChartSeries();
        girls.setFill(true);
        girls.setLabel("Outpatients");
        girls.set("2017", 52);
        girls.set("2018", 60);
        girls.set("2019", 44);
        girls.set("2020", 90);
        girls.set("2021", 120);
 
        areaModel.addSeries(boys);
        areaModel.addSeries(girls);
         
        areaModel.setTitle("Area Chart");
        areaModel.setLegendPosition("ne");
        areaModel.setStacked(true);
        areaModel.setShowPointLabels(true);
         
        Axis xAxis = new CategoryAxis("Time/Year");
        areaModel.getAxes().put(AxisType.X, xAxis);
        Axis yAxis = areaModel.getAxis(AxisType.Y);
        yAxis.setLabel("Medical Care");
        yAxis.setMin(0);
        yAxis.setMax(300);
    }
     
}