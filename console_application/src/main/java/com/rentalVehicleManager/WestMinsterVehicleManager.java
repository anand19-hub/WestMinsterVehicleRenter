package com.rentalVehicleManager;

import com.google.gson.JsonObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import com.mongodb.client.*;
import org.bson.Document;

public class WestMinsterVehicleManager implements RentalVehicleManager {
    private int parkSlotAvailable;

    public WestMinsterVehicleManager(int listLength) {
        MongoClient mongoVehicleClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoVehicleClient.getDatabase("VehicleManager");
        MongoCollection<Document> collection = database.getCollection("Vehicle");
        long noOfVehicles = collection.countDocuments();

        // getting the length of the documents and subtracting from the fixed number of parking will give the available parking slots.
        this.parkSlotAvailable = (int) (listLength - noOfVehicles);
    }

    private String getAllVehicles() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/getAllVehicles").openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            int responseCode = connection.getResponseCode();
            if(responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return response.toString();
            } else {
                System.out.println("Request Rejected with code: " + responseCode + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printAllVehicles() {
        String allVehicles = getAllVehicles();
        System.out.println(allVehicles);

    }

    public void addVehicle(Vehicle vehicle)  {
        if ( parkSlotAvailable > 0) {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/addVehicle").openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                JsonObject postData = new JsonObject();
                postData.addProperty("plateNumber", vehicle.getPlateNumber());
                postData.addProperty("type", vehicle.getType());
                postData.addProperty("make", vehicle.getMake());
                postData.addProperty("available", vehicle.isAvailable());
                postData.addProperty("rentPerDay", vehicle.getRentPerDay());
                postData.addProperty("description", vehicle.getDescription());
                postData.addProperty("image", Base64.getEncoder().encodeToString(vehicle.getImage()));
                postData.addProperty("seats", vehicle.getSeats());
                postData.addProperty("aeroDynamic", vehicle.isAeroDynamic());
                postData.addProperty("typeOfHelmet", vehicle.getTypeOfHelmet());
                postData.addProperty("airBagMakers", vehicle.getAirbagMakers());
                postData.addProperty("gasTankSize", vehicle.getGasTankSize());

                OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
                wr.write(postData.toString());
                wr.flush();
                wr.close();

                int responseCode = connection.getResponseCode();

                if(responseCode == 200){
                    System.out.println("New Vehicle Added Successfully. \n");
                    parkSlotAvailable--;
                    System.out.println("Available number of parking: " + parkSlotAvailable + "\n");
                    writeToCSV();
                } else {
                    System.out.println("Request Rejected with code: " + responseCode + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("No more parking slot available \n");
        }
    }

    public void deleteVehicle(String plateNumber) {
        try {
            System.out.println(plateNumber);
            HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/delete/" + plateNumber).openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", "utf-8");
            connection.setUseCaches(false);

            if (connection.getResponseCode() == 200) {
                System.out.println("Vehicle deleted: "+ plateNumber + "\n");
                writeToCSV();
            } else {
                System.out.println("Error: "+ connection.getResponseCode());
            }
            connection.disconnect();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void filterVehicles(String filter, String option) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/filterVehicles/" + filter + "/" + option).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            int responseCode = connection.getResponseCode();
            if(responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));

                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("");
                System.out.println(response.toString());

            } else {
                System.out.println("Request Rejected with code: " + responseCode + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToCSV() {
        String vehicleList = getAllVehicles();
        try {
            FileWriter fileWriter = new FileWriter("./vehicleList.csv");
            fileWriter.write(vehicleList);
            fileWriter.close();
            System.out.println("File Created at path \"./vehicleList.csv\".\n");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openUserApplication() {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe","/c", "start chrome http://localhost:3000");

        try {
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) { break; }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
