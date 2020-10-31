package com.web;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class DistrictData{
    // private static final String USER_AGENT = "Mozilla/5.0";

    private static final String GET_URL = "https://api.covid19india.org/raw_data17.json";

    //private static final String POST_URL = "https://api.covid19india.org/raw_data17.json";

    // private static final String POST_PARAMS = "userName=Pankaj";

    /*public static ObservableList<DistTable> getData() throws IOException {

        sendGET();
        System.out.println("GET DONE");
        //sendPOST();
        // System.out.println("POST DONE");
    }*/

    //private static void sendGET() throws IOException
    public static ObservableList<DistTable>getData()throws IOException{
        ObservableList<DistTable> List = null;
        URL obj = new URL(GET_URL);
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
            JSONArray jsonarr_1 = (JSONArray) jobj.get("raw_data");

            //Get data for Results array
            for(int i=1;i<jsonarr_1.size();i++)
            {
                //Store the JSON objects in an array
                //Get the index of the JSON object and print the values as per the index
                JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
                List.add(new DistTable(jsonobj_1.get("detecteddistrict"),jsonobj_1.get("detectedstate"),jsonobj_1.get("entryid"),jsonobj_1.get("numcases"),jsonobj_1.get("source1")));
                /*System.out.println("\nState name : " +jsonobj_1.get("detectedstate"));
                System.out.println("district name: " +jsonobj_1.get("detecteddistrict"));
                System.out.println("total cases: " +jsonobj_1.get("entryid"));
                // System.out.println("new cases of today : " +jsonobj_1.get("newInfected"));
                System.out.println("new cases :" +jsonobj_1.get("numcases"));
                System.out.println("for further information : " +jsonobj_1.get("source1"));
                // System.out.println("total deaths : " +jsonobj_1.get("id"));
                // System.out.println("new  deaths today : " +jsonobj_1.get("newDeceased"));
                // System.out.println("hospitalized yet: " +jsonobj_1.get("count-prev_count"));*/
            }
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