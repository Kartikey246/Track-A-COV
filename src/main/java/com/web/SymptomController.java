package com.web;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SymptomController implements Initializable {

    @FXML
    public ComboBox<String> AgeGroup;

    @FXML
    public ComboBox<String> dryCough;

    @FXML
    public ComboBox<String> headache;

    @FXML
    public ComboBox<String> soreThroat;

    @FXML
    public ComboBox<String> conCovid;

    @FXML
    public ComboBox<String> lostSmT;

    @FXML
    public ComboBox<String> fever;
    public Button btn;
    public GridPane rootPane;
    @FXML
    private Label label;

    @FXML
    public ComboBox<String> runningNose;
    String a1="20-40";
    String a2="No";
    String a3="No";
    String a4="No";
    String a5="No";
    String a6="No";
    String a7="No";
    String a8="No";
    int sum=0;
    double percentage;


    public void changeCombo(javafx.event.ActionEvent event){
        a1=AgeGroup.getValue();
    }
    public void changeCombo2(javafx.event.ActionEvent event){
        a2=dryCough.getValue();
    }
    public void changeCombo3(javafx.event.ActionEvent event){
        a3= fever.getValue();
    }
    public void changeCombo4(javafx.event.ActionEvent event){
        a4= soreThroat.getValue();
    }
    public void changeCombo5(javafx.event.ActionEvent event){
        a5= headache.getValue();
    }
    public void changeCombo6(javafx.event.ActionEvent event){
        a6= runningNose.getValue();
    }
    public void changeCombo7(javafx.event.ActionEvent event){
        a7= lostSmT.getValue();
    }
    public void changeCombo8(javafx.event.ActionEvent event){
        a8= dryCough.getValue();
    }

    public void onAction(javafx.event.ActionEvent actionEvent) throws Exception{
          if (a1.equals("0-10")){
              sum++;
          }
          else if (a1.equals("60+")){
              sum++;
          }

        if (a2.equals("Yes")){
            sum++;
        }
        if (a3.equals("Yes")){
            sum++;
        }
        if (a4.equals("Yes")){
            sum++;
        }
        if (a5.equals("Yes")){
            sum++;
        }
        if (a6.equals("Yes")){
            sum++;
        }
        if (a7.equals("Yes")){
            sum++;
        }
        if (a8.equals("Yes")){
            sum++;
        }
        percentage=(double)sum*100/8;
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try{

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            label.setText("Percentage:"+percentage);
                        }
                    });



                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(task).start();
    }
    @FXML
    private WebView w;
    private WebEngine e;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        e= w.getEngine();
    }
    public void show(javafx.event.ActionEvent event){
         e.load("https://www.google.com/search?q=corona+news+india&oq=corona+news&aqs=chrome.1.69i57j0i433j0l2j0i433j69i65j69i60l2.4642j0j7&sourceid=chrome&ie=UTF-8");
    }
    public void show1(javafx.event.ActionEvent event){
        e.load("https://www.worldometers.info/coronavirus/");
    }
    public void show2(javafx.event.ActionEvent event){
        e.load("https://www.indiatoday.in/coronavirus");
    }
    @FXML
    public Button BackBT;
    public void BackListener(javafx.event.ActionEvent actionEvent){
        Stage secondarystage= (Stage) BackBT.getScene().getWindow();
        Pane root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        secondarystage.setScene(new Scene(root, 911, 583));
    }
}

