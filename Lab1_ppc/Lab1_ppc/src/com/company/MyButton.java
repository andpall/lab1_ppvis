package com.company;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;


public  class MyButton extends Button {
    public   MyButton (String name){
        this.setText(name);
        update(this);
    }
private  void update(MyButton mybut){

    this.setWrapText(true);
    this.setShape(new Circle(40));
    this.setMinSize(70,50);
    this.setMaxSize(70,80);
    this.setBackground(new Background(new BackgroundFill( Color.YELLOW,
            CornerRadii.EMPTY,   javafx.geometry.Insets.EMPTY)));
    this.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            mybut.setBackground(new Background(new BackgroundFill( Color.RED,
                    CornerRadii.EMPTY,   javafx.geometry.Insets.EMPTY)));

        }

    });
    this.setOnMouseExited(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            mybut.setBackground(new Background(new BackgroundFill( Color.YELLOW,  CornerRadii.EMPTY,   Insets.EMPTY)));

        }
    });
}


}
