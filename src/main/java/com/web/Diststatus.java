package com.web;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Diststatus implements Initializable {

    public Button BackBT;
    public TextField SearchDTF;
    @FXML
    private TableView<DistTable>Table;
    @FXML
    private TableColumn<DistTable,String>Dist;
    @FXML
    private TableColumn<DistTable,String>State;
    @FXML
    private TableColumn<DistTable,String>ConfW;
    @FXML
    private TableColumn<DistTable,String>ConfT;
    @FXML
    private TableColumn<DistTable,String>Info;
    ObservableList<DistTable>listD;
    public void BackListener(ActionEvent actionEvent){
        Stage secondarystage= (Stage) BackBT.getScene().getWindow();
        Pane root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        secondarystage.setScene(new Scene(root, 911, 583));
    }
    /*ObservableList<DistTable>List= FXCollections.observableArrayList(
            new DistTable("Bareilly","Uttarpradesh","25000","2500","hushu"),
            new DistTable("Varanasi","Uttarpradesh","2800","1020","kili"),
            new DistTable("Mirzapur","Uttarpradesh","2100","1300","junk"),
            new DistTable("Amritsar","punjab","2462","2100","thik")
    );*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            listD=DistrictData.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Dist.setCellValueFactory(new PropertyValueFactory<DistTable,String>("Dist"));
        State.setCellValueFactory(new PropertyValueFactory<DistTable,String>("State"));
        ConfW.setCellValueFactory(new PropertyValueFactory<DistTable,String>("ConfW"));
        ConfT.setCellValueFactory(new PropertyValueFactory<DistTable,String>("ConfT"));
        Info.setCellValueFactory(new PropertyValueFactory<DistTable,String>("Info"));

        //Table.setItems(List);
        FilteredList<DistTable> filteredData=new FilteredList<>(listD,b->true);//wrap the observableList in a filteredList(initially display the all data).
        SearchDTF.textProperty().addListener((observable,oldVValue,newValue)->{
            filteredData.setPredicate(DistTable->{
                if(newValue==null){
                    return true;
                }
                //compare the state name with searchtext
                String searchText=newValue.toLowerCase();
                if(String.valueOf(DistTable.getDist()).toLowerCase().contains(searchText)){
                    return true;
                }
                else if(String.valueOf(DistTable.getState()).toLowerCase().contains(searchText)){
                    return true;
                }
                else
                    return false;

            });
        });
        //wrap the FilteredList in a SortedList
        SortedList<DistTable> sortedData=new SortedList<>(filteredData);
        //bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(Table.comparatorProperty());
        Table.setItems(sortedData);
    }
}
