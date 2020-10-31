package com.web;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Webgui implements Initializable {
    @FXML
    private Button btb;
    @FXML
    private WebView w;
    @FXML
    private WebEngine engine;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        engine = w.getEngine();
      engine.load("https://www.thehindu.com/news/resources/coronavirus-state-helpline-numbers-for-covid-19/article31052031.ece");
    }
    public void BackListener(ActionEvent actionEvent){
        Stage secondaries= (Stage) btb.getScene().getWindow();
        AnchorPane root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        secondaries.setScene(new Scene(root, 300, 275));
    }
}
