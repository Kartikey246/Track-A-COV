package com.web;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class DistrictData {
    public static void main(String [] args)
    {
        //inline will store the JSON data streamed in string format
        String inline = "";

        try
        {
            URL url = new URL("https://api.covid19india.org/state_district_wise.json");
            //Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            //Set the request to GET or POST as per the requirements
            conn.setRequestMethod("GET");
            //Use the connect method to create the connection bridge
            conn.connect();
            //Get the response status of the Rest API
            int responsecode = conn.getResponseCode();
            System.out.println("Response code is: " +responsecode);

            //Iterating condition to if response code is not 200 then throw a runtime exception
            //else continue the actual process of getting the JSON data
            if(responsecode != 200)
                throw new RuntimeException("HttpResponseCode: " +responsecode);
            else
            {
                //Scanner functionality will read the JSON data from the stream
                Scanner sc = new Scanner(url.openStream());
                while(sc.hasNext())
                {
                    inline+=sc.nextLine();
                }
                System.out.println("\nJSON Response in String format");
                System.out.println(inline);
                //Close the stream when reading the data has been finished
                sc.close();
            }

            //JSONParser reads the data from string object and break each data into key value pairs
            JSONParser parse = new JSONParser();
            //Type caste the parsed json data in json object
            JSONObject jobj = (JSONObject)parse.parse(inline);
            //Store the JSON object in JSON array as objects (For level 1 array element i.e Results)
            // JSONArray jsonarr_1 = (JSONArray) jobj.get("statecode");
            //  System.out.println(jsonarr_1);
            //Get data for Results array
            for(int i=0;i<400;i++)
            {
                //Store the JSON objects in an array
                //Get the index of the JSON object and print the values as per the index
                //JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
                System.out.println("\nState name: " +jobj.get("region"));
                System.out.println("total cases: " +jobj.get("totalInfected"));
                System.out.println("new cases of today : " +jobj.get("newInfected"));
                System.out.println("recovered till now :" +jobj.get("recovered"));
                System.out.println("new recovered today: " +jobj.get("newRecovered"));
                System.out.println("total deaths : " +jobj.get("deceased"));
                System.out.println("new  deaths today : " +jobj.get("newDeceased"));

            }
            //Disconnect the HttpURLConnection stream
            conn.disconnect();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}