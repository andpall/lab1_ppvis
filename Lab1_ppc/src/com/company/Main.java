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

public class Main extends Application {

    volatile private List<Stage> stages = new ArrayList<>();

    private AnimationTimer animationTimer;

    private List<AnimationTimer> timers = new ArrayList<>();

    volatile int[] counter = {0};

    volatile int[] beginCounter = {0};

    volatile boolean aliveThread = true;

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        createAllStages(stage);
        //stages.get(4).show();
        stage.show();
        process(stage, stage.getScene());
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
        //stage.setMaximized(true);
        //stage.show();
        return stage;
    }

    public Stage createOneStage(Group group, String name, int x, int y) {
        FlowPane pane = new FlowPane(Orientation.VERTICAL);
        pane.getChildren().addAll(group);
        pane.setPadding(new Insets(10));
        Scene scene = new Scene(pane, y, x);
        //stages.add(new Stage());
        Stage firstStage = new Stage();
        firstStage.setScene(scene);
        firstStage.setTitle(name);
        //firstStage.setMaximized(true);
        //firstStage.show();
        return firstStage;
    }

    public void process(Stage stage, Scene scene) {
//        stage.getScene().getAccelerators().put(
//                KeyCombination.keyCombination("CTRL+R"),
//                () -> {
//                    KeyCombination s = KeyCombination.keyCombination("CTRL+R");
//                    System.out.println("Keycombination Detected");
//                   longProcess(stage, scene, counter, s);
//                }
//        );


        scene.setOnKeyPressed(ke -> {
            if (ke.getCode().getName().equals("R") && ke.isControlDown()) {

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        animationTimer = new AnimationTimer() {
                            @Override
                            public void handle(long l) {
                                Platform.runLater(() -> {

                                    stage.hide();
                                });
                                int[] anyCounter = {0};
                                for (int i = 0; i < 5; i++) {
                                    anyCounter[0]=i;
                                    Platform.runLater(() -> {
                                        stages.get(anyCounter[0]).show();
                                    });
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                Platform.runLater(() -> {
                                stages.get(0).show();
                                });

                                for (int i = 0; i < 5; i++) {
                                    anyCounter[0]=i;
                                    Platform.runLater(() -> {
                                    stages.get(anyCounter[0]).hide();
                                    });
                                }
                                stage.show();

                                try {
                                    Thread.sleep(1000);

                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }

                        };
                        animationTimer.start();


                    }
                });

                thread.start();


            }
            if (ke.getCode().getName().equals("S") && ke.isControlDown()) {
                animationTimer.stop();
            }
        });

        stage.show();
    }

    public void process2(Stage stage, Scene scene) {
        Service service = new Service() {
            @Override
            protected Task createTask() {
                return new Task() {
                    @Override
                    protected Object call() throws Exception {
                        Platform.runLater(() -> {
                            //longProcess(stage, scene, counter);
                        });
                        return null;
                    }
                };
            }
        };
        //service.start();
        //new MyThread("myThread").start();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //longProcess(stage, scene, counter);
            }
        });
        //shittiestMethod(stage, scene, counter);
        //longProcess(stage, scene, counter);

//        scene.setOnKeyPressed(ke -> {
//            if (ke.getCode().getName().equals("R") && ke.isControlDown())
//            {
//                aliveThread = true;
//                //thread.start();
//                //service.start();
//                //new MyThread("myThread").start();
//            }
//            if (ke.getCode().getName().equals("S") && ke.isControlDown()) {
//                aliveThread = false;
//            }
//        });
    }

    public void longProcess(Stage stage, Scene scene, int[] counter, KeyCombination keySet) {
        if (keySet.equals(KeyCombination.keyCombination("CTRL+S"))) animationTimer.stop();
        {

            animationTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    stage.hide();
                    for (int i = 0; i < 5; i++) {
                        stages.get(i).show();


                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    for (int i = 0; i < 5; i++) {
                        stages.get(i).hide();
                    }
                    stage.show();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            };
            animationTimer.start();
        }
        stage.show();

    }

}
    
    


