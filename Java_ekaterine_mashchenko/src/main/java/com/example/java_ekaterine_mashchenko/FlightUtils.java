package com.example.java_ekaterine_mashchenko;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightUtils {
    private FlightUtils() {
    }

    public static void createTable() throws SQLException, RuntimeException {
        String createSql = "CREATE TABLE IF NOT EXISTS FLIGHTS_TB" +
                "(ID INTEGER NOT NULL AUTO_INCREMENT, " +
                " DESTINATION VARCHAR(255), " +
                " TIME VARCHAR(255), " +
                " SEATS INTEGER NOT NULL, " +
                " PRICE INTEGER NOT NULL, " +
                " PRIMARY KEY (ID))";

        try {
            JDBCUtil.getStatement().executeUpdate(createSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Created table");

    }

    public static void insertFlight(Flight flight) throws SQLException, RuntimeException {
        String insertSql = "INSERT INTO FLIGHTS_TB(DESTINATION, TIME, SEATS, PRICE) VALUES( "
                + "'" + flight.getDestination() + "', "
                + "'" + flight.getTime() + "', "
                + "'" + flight.getSeats() + "', "
                + "'" + flight.getPrice() + "')";

        try {
            JDBCUtil.getStatement().executeUpdate(insertSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("data added");


    }


    public static List<Flight> getAllFlights() {

        String selectSql = "SELECT * FROM FLIGHTS_SCHEDULES";

        List<Flight> flights = new ArrayList<>();

        try {

            ResultSet resultSet = JDBCUtil.getStatement().executeQuery(selectSql);

            while (resultSet.next()) {

                flights.add(new Flight(
                        resultSet.getString("DESTINATION"),
                        resultSet.getString("TIME"),
                        resultSet.getInt("SEATS"),
                        resultSet.getInt("PRICE")
                ));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flights;

    }
    public static int totalFlightPrice(Flight flight){
        return flight.getPrice()*flight.getSeats();
    }

}