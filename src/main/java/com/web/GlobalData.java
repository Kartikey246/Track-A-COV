package com.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GlobalData {
    private static final String GET_URL="https://coronavirus-19-api.herokuapp.com/all";


    public static ObservableList<Globalstatus> getData() throws IOException, ParseException {
        ObservableList<Globalstatus> List = null;
        //inline will store the JSON data streamed in string format
        String inline = "";


            URL obj = new URL(GET_URL);
            //Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // con.setRequestMethod("GET");
        // con.setRequestProperty("User-Agent", USER_AGENT);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine="";
        StringBuffer response = new StringBuffer();
        int responseCode = con.getResponseCode();
        // System.out.println("GET Response Code :: " + responseCode);
        if (responseCode ==200) {
            // success

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }


            // print result
            // System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }



        List=null;
        try{
            List = FXCollections.observableArrayList();
            JSONParser parse = new JSONParser();
            //Type caste the parsed json data in json object
            JSONObject jobj = (JSONObject)parse.parse(response.toString());
            //Store the JSON object in JSON array as objects (For level 1 array element i.e Results)
            Object cases=jobj.get("cases");
            Object Deaths=jobj.get("deaths");
            Object Recovered=jobj.get("recovered");
            List.add(new Globalstatus(cases, Deaths, Recovered));

            //  }
            //Disconnect the HttpURLConnection stream
            in.close();
            con.disconnect();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return List;
    }


}

