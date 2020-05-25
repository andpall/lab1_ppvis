package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class TaskWithRadiobutton {
    public static Group getGroup(){
        TextField textField = new TextField();
        MyButton marker = new MyButton("отметить");
        RadioButton markOneBut = new RadioButton("кнопка1");
        RadioButton markTwoBut = new RadioButton("кнопка2");
        RadioButton markThreeBut = new RadioButton("кнопка3");

        marker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                switch (textField.getText()) {
                    case "кнопка1":
                        if(!markOneBut.isSelected())
                            markOneBut.fire();
                        if(markTwoBut.isSelected()|| markThreeBut.isSelected())
                        {   markTwoBut.setSelected(false);
                            markThreeBut.setSelected(false);
                        }
                        break;
                    case "кнопка2":
                        if(!markTwoBut.isSelected())
                            markTwoBut.fire();
                        if(markOneBut.isSelected()|| markThreeBut.isSelected())
                        {   markOneBut.setSelected(false);
                            markThreeBut.setSelected(false);
                        }
                        break;
                    case "кнопка3" :
                        if(!markThreeBut.isSelected())
                            markThreeBut.fire();
                        if(markOneBut.isSelected()|| markThreeBut.isSelected())
                        {   markTwoBut.setSelected(false);
                            markTwoBut.setSelected(false);
                        }
                        break;
                    default:
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("кнопка не найдена");
                        alert.showAndWait();
                }

            }
        });
        FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
        pane.getChildren().addAll(textField,markOneBut,markTwoBut ,markThreeBut,marker );
        Group group = new Group(pane);
        return group;
    }

}
