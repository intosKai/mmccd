package me.podder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {
    public static final String VERSION = "0.2";
    private Stage stage;
    private Scene scene;
    private AnchorPane pane;

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getClassLoader().getResource("MainWindow.fxml"));
            fxmlLoader.setResources(ResourceBundle.getBundle("Locale", new Locale("ru")));
            pane = fxmlLoader.load();
            scene = new Scene(pane, pane.getPrefWidth(), pane.getPrefHeight());
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(fxmlLoader.getResources().getString("window.title")+ " " + VERSION);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
