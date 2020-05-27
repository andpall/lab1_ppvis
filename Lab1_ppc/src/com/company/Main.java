package com.company;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main extends Application {

    volatile private List<Stage> stages = new ArrayList<>();
    volatile int[] beginCounter = {0};
    volatile AtomicBoolean aliveThread = new AtomicBoolean(true);

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        createAllStages(stage);
        stage.show();
        animationProcess(stage, stage.getScene());
    }

    public void createAllStages(Stage stage) {
        createMainStage(stage);
        stages.add(createOneStage(TaskWithCombobox.getGroup(), "1", 200, 200));
        stages.get(0).setX(100);
        stages.add(createOneStage(TaskChangeName.getGroup(), "2", 200, 200));
        stages.get(1).setX(310);
        stages.add(createOneStage(TaskWithRadiobutton.getGroup(), "3", 200, 200));
        stages.get(2).setX(520);
        stages.add(createOneStage(TaskWithCheckBox.getGroup(), "4", 200, 200));
        stages.get(3).setX(730);
        stages.add(createOneStage(TaskWithTable.getGroup(), "5", 430, 430));
        stages.get(4).setX(940);
    }

    public Stage createMainStage(Stage stage) {
        FlowPane pane = new FlowPane(Orientation.VERTICAL, 10, 10);
        pane.getChildren().addAll(TaskWithCombobox.getGroup(), TaskChangeName.getGroup(), TaskWithRadiobutton.getGroup(),
                TaskWithCheckBox.getGroup(), TaskWithTable.getGroup());
        pane.setPadding(new Insets(10));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Лабораторная работа №1");
        return stage;
    }

    public Stage createOneStage(Group group, String name, int x, int y) {
        FlowPane pane = new FlowPane(Orientation.VERTICAL);
        pane.getChildren().addAll(group);
        pane.setPadding(new Insets(10));
        Scene scene = new Scene(pane, y, x);
        Stage firstStage = new Stage();
        firstStage.setScene(scene);
        firstStage.setTitle(name);
        return firstStage;
    }

    public void bindKeyOnStage() {
//        stages.get(beginCounter[0]).getScene().getAccelerators().put(
//                KeyCombination.keyCombination("CTRL+S"),
//                () -> {
//                    {
//                        aliveThread.set(false);
//                    }
//                }
//        );
        stages.get(beginCounter[0]).getScene().setOnKeyPressed(ke -> {
            if (ke.getCode().getName().equals("S") && ke.isControlDown()) {
                aliveThread.set(false);
            }
        });
    }

    public void animationProcess(Stage stage, Scene scene) {
        scene.setOnKeyPressed(ke -> {
            if (ke.getCode().getName().equals("R") && ke.isControlDown()) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (aliveThread.get()) {
                            Platform.runLater(() -> {
                                stage.hide();
                            });
                            if (beginCounter[0] == 4)
                                beginCounter[0] = 0;
                            for (int i = beginCounter[0]; i < 5; i++) {
                                if (aliveThread.get()) {
                                    beginCounter[0] = i;
                                    Platform.runLater(() -> {
                                        stages.get(beginCounter[0]).show();
                                        bindKeyOnStage();
                                    });
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    Platform.runLater(() -> {
                                        for (int j = 0; j < 5; j++) {
                                            stages.get(j).hide();
                                        }
                                    });
                                    Platform.runLater(() -> {
                                        stage.show();
                                    });
                                    return;
                                }
                            }
                            Platform.runLater(() -> {
                                for (int i = 0; i < 5; i++) {
                                    stages.get(i).hide();
                                }
                            });
                            Platform.runLater(() -> {
                                stage.show();
                            });
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (!aliveThread.get()) return;
                        }
                    }
                });
                aliveThread.set(true);
                thread.start();
            }
            if (ke.getCode().getName().equals("S") && ke.isControlDown()) {
                aliveThread.set(false);
                stage.show();
            }
        });
    }
}
    
    


