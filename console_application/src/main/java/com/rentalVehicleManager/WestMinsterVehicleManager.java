package com.rentalVehicleManager;


import com.google.gson.JsonObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class WestMinsterVehicleManager implements RentalVehicleManager {
    private ArrayList<Vehicle> vehicleList;
    private int numVehicles;

    public WestMinsterVehicleManager(int listLength) {
        this.numVehicles = listLength;
        vehicleList = new ArrayList<Vehicle>();
    }

    public void printAllVehicles() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/getAllVehicles").openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        int responseCode = connection.getResponseCode();
        if(responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // TODO
            // print result - need to format
            System.out.println(response.toString());
        } else {
            System.out.println("Request Rejected with code: " + responseCode );
        }
    }

    public void addVehicle(Vehicle vehicle) throws IOException {
        if (vehicleList.size() < numVehicles) {
            HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/addVehicle").openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            JsonObject postData = new JsonObject();  ;
            postData.addProperty("plateNumber", vehicle.plateNumber);
            postData.addProperty("type", vehicle.type);
            postData.addProperty("make", vehicle.make);

            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
            wr.write(postData.toString());
            wr.flush();
            wr.close();

            int responseCode = connection.getResponseCode();
            if(responseCode == 200){
                System.out.println("New Vehicle Added Successfully.");
                System.out.println("");
            } else {
                System.out.println("Request Rejected with code: " + responseCode );
            }
        }
        else {
            System.out.println("No more parking slot available");
        }
    }

    public void deleteVehicle(String plateNumber) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/delete/{plateNumber}").openConnection();
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
    }
}
