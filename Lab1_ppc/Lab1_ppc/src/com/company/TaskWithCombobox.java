package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;
import java.util.List;

public class TaskWithCombobox {

    public static Group getGroup(){
        TextField textField = new TextField();
        MyButton addButton = new MyButton("добавить");
        ComboBox box = new ComboBox();
        FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
        pane.getChildren().addAll(addButton ,textField,box );
        List<String> array = new ArrayList<String>();
        addButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                boolean flag =false;
                if(textField.getText().equals("")) flag=true;
                for (int i=0;i<array.size();i++) {
                    if(textField.getText().equals(array.get(i)))
                        flag=true;
                }
                if(!flag)
                {
                    array.add(textField.getText());
                    box.getItems().addAll(textField.getText());
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("неверный ввод");
                    alert.showAndWait();
                }

                textField.clear();
            }

        });
        Group group = new Group(pane);
        return  group;
    }

}
