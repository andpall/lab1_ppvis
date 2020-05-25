package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class TaskWithCheckBox {
    public static Group getGroup(){
        TextField textField = new TextField();
        MyButton marker = new MyButton("отметить");
        CheckBox markOneBut = new CheckBox("флажок1");
        CheckBox markTwoBut = new CheckBox("флажок2");
        CheckBox markThreeBut = new CheckBox("флажок3");
        marker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                switch (textField.getText()) {
                    case "флажок1":
                        if(markOneBut.isSelected())
                            markOneBut.setSelected(false);
                        else
                            markOneBut.fire();
                        break;
                    case "флажок2":
                        if(markTwoBut.isSelected())
                            markTwoBut.setSelected(false);
                        else
                            markTwoBut.fire();
                        break;
                    case "флажок3":
                        if(markThreeBut.isSelected())
                            markThreeBut.setSelected(false);
                        else
                            markThreeBut.fire();
                        break;
                    default:
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("флажок не найден");
                        alert.showAndWait();
                }
            }
        });

        FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
        pane.getChildren().addAll(textField,markOneBut,markTwoBut ,markThreeBut,marker );
        Group group = new Group(pane);
        return  group;
    }
}
