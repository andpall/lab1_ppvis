//package com.company;
//import javafx.animation.AnimationTimer;
//import javafx.collections.ObservableList;
//import javafx.event.EventHandler;
//import javafx.geometry.Orientation;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.input.KeyCode;
//import javafx.scene.input.KeyCodeCombination;
//import javafx.scene.input.KeyCombination;
//import javafx.scene.layout.*;
//import javafx.stage.Stage;
//import javafx.scene.input.KeyEvent;
//
//import java.awt.event.InputEvent;
//import java.awt.Robot;
//import java.util.ArrayList;
//import java.util.List;
//
//import javafx.animation.AnimationTimer;
//import javafx.stage.Stage;
//
//public class MyTask {
//
//    MyTask() {
//        stages.add(new MyDialog(new TaskChangeName().getGroup()).getStage());
//        stages.add(new MyDialog(new TaskWithCheckBox().getGroup()).getStage());
//        stages.add(new MyDialog(new TaskWithCombobox().getGroup()).getStage());
//        stages.add(new MyDialog(new TaskWithRadiobutton().getGroup()).getStage());
//        stages.add(new MyDialog(new TaskWithTable().getGroup()).getStage());
//    }
//    private List<Stage> stages = new ArrayList<>();
//
//    public void myTask(Stage stage){
//
//        double x1 = stage.getX(), y1 = stage.getY() - 15, x2 = stage.getX() + 22, y2 = stage.getY() + 2;
//        double x3 = stage.getX() + 150, y3 = stage.getY() + 250, x4 = stage.getX() - 150, y4 = stage.getY() + 250;
//        double x5 = stage.getX() - 220, y5 = stage.getY() + 20;
//
//
////			firstWindow.setX(x1);
////			firstWindow.setY(y1);
////			secondWindow.setX(x2);
////			secondWindow.setY(y2);
////			thirdWindow.setX(x3);
////			thirdWindow.setY(y3);
////			fourthWindow.setX(x4);
////			fourthWindow.setY(y4);
////			fifthWindow.setX(x5);
////			fifthWindow.setY(y5);
//        //copyFirstPane();
////		stages.get(0).setX(x1);
////		stages.get(0).setY(y1);
////		stages.get(1).setX(x2);
////		stages.get(2).setX(x3);
////		stages.get(3).setX(x1);
////		stages.get(4).setX(x1);
//
//
//
//
//        scene.setOnKeyPressed(ke -> {
//            AnimationTimer animationTimer;
//            if (ke.getCode().getName().equals("R") && ke.isControlDown())
//            {
//                animationTimer = new AnimationTimer() {
//                    @Override
//                    public void handle(long l) {
//
//                        stage.hide();
//                        for (int i = 0; i < 1; i++) {
//                            copyFirstPane();
//                            stages.get(0).setX(x1);
//                            stages.get(0).setY(y1);
//                            stages.get(i).setTitle(String.valueOf(i + 1));
//                            //stages.get(i).setScene(scenes.get(i));
//
//
//                            stages.get(i).show();
//                            try {
//                                Thread.sleep(1000);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//
//                        for (int i = 0; i < 1; i++) {
//                            stages.get(i).hide();
//                        }
//                        stage.show();
//
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//
//                };
//                animationTimer.start();
//            }
//            if (ke.getCode().getName().equals("S") && ke.isControlDown()) {
//                animationTimer.stop();
//            }
//        });
//
//        stage.show();
//    }
//}
//
//}
