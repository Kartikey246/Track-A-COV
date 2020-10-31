package com.web.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Webgui implements Initializable {
    @FXML
    private WebView w;
    @FXML
    private WebEngine engine;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        engine = w.getEngine();
      engine.load("https://www.thehindu.com/news/resources/coronavirus-state-helpline-numbers-for-covid-19/article31052031.ece");
    }
}
