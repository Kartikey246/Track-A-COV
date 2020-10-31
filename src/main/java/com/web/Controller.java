package com.web;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
@FXML
public Label Cases;
@FXML
public Label Deaths;
@FXML
public Label Recovered;
public Label Lb1;
public Button GlobalBT;
public Button StatewBT;
public Button DistwBT;
public Button WebGuiBT;
public Button SympBT;
com.web.StateData std= new com.web.StateData();
    ObservableList<Globalstatus> listD;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            listD=GlobalData.getData();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
       Globalstatus globalstatus=listD.get(0);
        Cases.setText(String.valueOf(globalstatus.getCases()));
        Deaths.setText(String.valueOf(globalstatus.getDeaths()));
        Recovered.setText(String.valueOf(globalstatus.getRecovered()));
    }
public void refreshListener(ActionEvent actionEvent){

    //GlobalTextArea.setText(std.StateStats());
}
public void StateListener(ActionEvent actionEvent){
    Stage stage= (Stage) StatewBT.getScene().getWindow();
    AnchorPane root =null;
    try {
        root = FXMLLoader.load(getClass().getResource("Statewise.fxml"));
    } catch (IOException e) {
        e.printStackTrace();
    }
    stage.setScene(new Scene(root, 300, 275));

}
public void SympListener(ActionEvent actionEvent){
    Stage stage= (Stage) SympBT.getScene().getWindow();
    GridPane root =null;
    try {
         root = FXMLLoader.load(getClass().getResource("SymptomAnalyser.fxml"));
    } catch (IOException e) {
        e.printStackTrace();
    }
    stage.setScene(new Scene(root, 300, 275));
}
    public void WebGUIListener(ActionEvent actionEvent){
        Stage stage= (Stage) SympBT.getScene().getWindow();
        AnchorPane root =null;
        try {
            root = FXMLLoader.load(getClass().getResource("webgui.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 300, 275));
    }
    public void DistrictListener(ActionEvent actionEvent){
        Stage stage= (Stage) SympBT.getScene().getWindow();
        AnchorPane root =null;
        try {
            root = FXMLLoader.load(getClass().getResource("Diststatus.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 300, 275));
    }


}
