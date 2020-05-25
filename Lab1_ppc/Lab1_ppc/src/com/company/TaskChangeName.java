package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class TaskChangeName {
    public static Group getGroup(){

        TextField textField = new TextField();
        MyButton addNameBut = new MyButton("назвать  вторую кнопку");
        MyButton  changeNameBut= new MyButton("поменять текст");
        changeNameBut.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String buff= addNameBut.getText();
                addNameBut.setText(changeNameBut.getText());
                changeNameBut.setText(buff);
            }
        });
        addNameBut.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                changeNameBut.setText(textField.getText());
            }
        });
        FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
        pane.getChildren().addAll(textField,addNameBut,changeNameBut );
        Group group = new Group(pane);
        return group;
    }

}
