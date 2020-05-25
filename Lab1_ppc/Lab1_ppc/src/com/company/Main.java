package com.company;

import com.company.Table;
import com.company.TaskWithCombobox;
import com.company.TaskChangeName;
import com.company.TaskWithRadiobutton;
import com.company.TaskWithCheckBox;
import com.company.TaskWithTable;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {


        FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
        pane.getChildren().addAll(TaskWithCombobox.getGroup(),TaskChangeName.getGroup(),TaskWithRadiobutton.getGroup(),
                TaskWithCheckBox.getGroup(),TaskWithTable.getGroup());
        pane.setPadding(new Insets(10));
        Scene scene = new Scene(pane);
        
        stage.setScene(scene);
        stage.setTitle("Лабораторная работа №1");
        stage.setMaximized(true);
        stage.show();

    }



}