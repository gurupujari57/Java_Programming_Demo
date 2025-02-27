package org.recursion;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CalculateSum{

        public static void main(String[] args) {
            // Path to your JSON file
            String filePath = "src/main/resources/data.json";

            try {
                // Read the content of the file
                String jsonResponse = new String(Files.readAllBytes(Paths.get(filePath)));

              /*  // Parse the JSON response
                JSONObject jsonObject = new JSONObject(jsonResponse);
                JSONArray dataArray = jsonObject.getJSONArray("content");

                // Use stream to calculate the total amount
                double totalAmount = IntStream.range(0, dataArray.length())
                        .mapToDouble(i -> dataArray.getJSONObject(i).getDouble("totalAmount"))
                        .sum();

                // Print the total amount
                System.out.println("Total Amount: " + totalAmount);*/
            } catch (IOException e) {
                System.out.println("Error reading the JSON file: " + e.getMessage());
            }
        }
}
