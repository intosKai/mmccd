package me.podder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static final String VERSION = "0.0.1 beta";
    private Stage stage;
    private Scene scene;
    private AnchorPane pane;

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        try {
            pane = FXMLLoader.load(Main.class.getResource("MainWindow.fxml"));
            scene = new Scene(pane, pane.getPrefWidth(), pane.getPrefHeight());
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("CCD MultiMonitor " + VERSION);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
