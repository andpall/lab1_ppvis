package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import java.util.ArrayList;
import java.util.List;

public class TaskWithTable {
    public static Group getGroup(){
        TextField textField = new TextField();
        MyButton moveToOne = new MyButton("переместить в 1 ");
        MyButton moveFromOneToTwo = new MyButton("переместить из 1 в 2");
        MyButton backToOne = new MyButton("вернуть из 2 в 1 ");
        moveToOne.setWrapText(true);
        moveFromOneToTwo.setWrapText(true);
        backToOne.setWrapText(true);

        TableView<Table> table= new TableView<Table>();
        TableColumn<Table,String> firstCol = new TableColumn<Table,String>("First Column");
        firstCol.setCellValueFactory(new PropertyValueFactory<Table,String>("first_column"));
        TableColumn<Table,String> secCol = new TableColumn<Table,String>("Second Column");
        secCol.setCellValueFactory(new PropertyValueFactory<Table,String>("second_column"));

        table.getSelectionModel().setCellSelectionEnabled(true);//возможно выделять ячейку
        table.getColumns().add(firstCol);
        table.getColumns().add(secCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        List<Table> newString = new ArrayList<Table>();

        moveToOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(textField.getText().equals("")){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("введите текст" );
                    alert.showAndWait();
                }
                else{
                    newString.add(new Table(textField.getText(), ""));
                    textField.clear();
                    table.getItems().clear();
                    table.getItems().addAll(newString);
                }
            }
        });
        moveFromOneToTwo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for(int i=0;i<newString.size();i++) {
                    if( table.getSelectionModel().isSelected(i,firstCol))
                    {
                        String buff= newString.get(i).getFirst_column();
                        newString.get(i).setFirst_column("");
                        newString.get(i).setSecond_column(buff);
                        table.getItems().clear();
                        table.getItems().addAll(newString);
                    }
                }
            }
        });
        backToOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for(int i=0;i<newString.size();i++) {
                    if( table.getSelectionModel().isSelected(i,secCol))
                    {
                        String buff= newString.get(i).getSecond_column();
                        newString.get(i).setSecond_column("");
                        newString.get(i).setFirst_column(buff);
                        table.getItems().clear();
                        table.getItems().addAll(newString);
                    }
                }
            }
        });
        FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
        pane.getChildren().addAll(textField,moveToOne,moveFromOneToTwo ,backToOne,table );
        Group group= new Group(pane);
        return group;
    }
}
