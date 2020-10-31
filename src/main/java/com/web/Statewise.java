package com.web;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Statewise extends com.web.StateData implements Initializable {
    public Button BackBT;
    @FXML
    private Label Label;
    @FXML
    private TextField SearchTF;
    @FXML
    private TableView<StateTable> Table;
    @FXML
    private TableColumn<StateTable,String>State;
    @FXML
    private TableColumn<StateTable,String>Cnft;
    @FXML
    private TableColumn<StateTable,String>Cnfnw;
    @FXML
    private TableColumn<StateTable,String>Rcvt;
    @FXML
    private TableColumn<StateTable,String>Rcvnw;
    @FXML
    private TableColumn<StateTable,String>Dect;
    @FXML
    private TableColumn<StateTable,String>Decnw;
    ObservableList<StateTable>listS;
    public void BackListener(ActionEvent actionEvent){
        Stage stage= (Stage) BackBT.getScene().getWindow();
        Pane root =null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 300, 275));
    }

        /*ObservableList<StateTable> list = FXCollections.observableArrayList(
                new StateTable("uttarpradesh", "52000", "21400", "5200", "635", "632", "2130"),
                new StateTable("haryana", "25600", "45400", "3400", "521", "531", "963"),
                new StateTable("bihar", "45300", "9600", "5200", "52011", "96321", "10423")

        );*/





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listS= com.web.StateData.getData();
        State.setCellValueFactory(new PropertyValueFactory<StateTable,String>("State"));
        Cnft.setCellValueFactory(new PropertyValueFactory<StateTable,String>("Cnft"));
        Cnfnw.setCellValueFactory(new PropertyValueFactory<StateTable,String>("Cnfnw"));
        Rcvt.setCellValueFactory(new PropertyValueFactory<StateTable,String>("Rcvnw"));
        Rcvnw.setCellValueFactory(new PropertyValueFactory<StateTable,String>("Rcvnw"));
        Dect.setCellValueFactory(new PropertyValueFactory<StateTable,String>("Dect"));
        Decnw.setCellValueFactory(new PropertyValueFactory<StateTable,String>("Decnw"));
        //Table.setItems(listS);
        FilteredList<StateTable> filteredData=new FilteredList<>(listS,p->true);//wrap the observableList in a filteredList(initially display the all data).
        SearchTF.textProperty().addListener((observable,oldVValue,newValue)->{
            filteredData.setPredicate(StateTable->{
                if(newValue==null){
                    return true;
                }
                //compare the state name with searchtext
                String searchtext=newValue.toLowerCase();
                if(String.valueOf(StateTable.getState()).toLowerCase().contains(searchtext)){
                    return true;
                }
                else
                    return false;

            });
        });
        //wrap the FilteredList in a SortedList
        SortedList<StateTable> sortedData=new SortedList<>(filteredData);
        //bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(Table.comparatorProperty());
        Table.setItems(sortedData);
    }
}
