package com.example.java_ekaterine_mashchenko;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        PieChart pieChart = new PieChart();
        pieChart.setTranslateX(100);
        pieChart.setTranslateY(200);
        pieChart.setData(getData());
        Group root = new Group();

        root.getChildren().add(pieChart);

        Scene scene = new Scene(root,600,800, Color.YELLOW);

        stage.setScene(scene);
        stage.setTitle("My App");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
//        FlightsUtil.insert(new Flights("Paris","02-09-2023",150,230));

    }

    private ObservableList<PieChart.Data> getData(){
        ArrayList<String> destinations = new ArrayList<String>();
        ArrayList<Integer> seats = new ArrayList<Integer>();


        FlightUtils.getAllFlights().forEach(data -> destinations.add(data.getDestination()));
        FlightUtils.getAllFlights().forEach(data -> seats.add(data.getSeats()));
        System.out.println(destinations);
        String dest1 = destinations.get(0);
        String dest2 = destinations.get(1);
        String dest3 = destinations.get(2);
        int seats1 = seats.get(0);
        int seats2 = seats.get(1);
        int seats3 = seats.get(2);


        ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList(
                new PieChart.Data(dest1, seats1),
                new PieChart.Data(dest2,seats2),
                new PieChart.Data(dest3, seats3)

        );
        return observableList;
    }

}