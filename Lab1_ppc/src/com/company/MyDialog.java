package com.company;

import com.company.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyDialog extends Stage {
    private Stage stage = new Stage();

 public MyDialog (Group group){
    FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
    pane.getChildren().addAll(group);
    pane.setPadding(new Insets(10));
    Scene scene = new Scene(pane);

    stage.setScene(scene);
}

    public Stage getStage() {
        return stage;
    }

    public void start(final Stage primaryStage) {

        StackPane root = new StackPane();

        Scene scene = new Scene(root, 450, 250);

        scene.setOnKeyPressed(ke -> {
            if (ke.getCode().getName().equals("R") && ke.isControlDown()) {


                Label secondLabel = new Label("I'm");

                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);

                Scene secondScene = new Scene(secondaryLayout, 230, 100);

                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Second Stage");
                newWindow.setScene(secondScene);

                // Set position of second window, related to primary window.
                newWindow.setX(primaryStage.getX() + 200);
                newWindow.setY(primaryStage.getY() + 100);

                newWindow.show();
            }
        });



        primaryStage.setTitle("JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
