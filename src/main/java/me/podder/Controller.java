package me.podder;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private Button btnSetFolder;
    @FXML
    private CheckBox cbTripleHead, cbMultiMonitors;
    @FXML
    private ChoiceBox cboxPreset;
    @FXML
    private Label lbPath, lbStatus, lbVersion;

    private FileChooser fileChooser;
    private ConfigEditor cfg;
    private ResourceBundle resourceBundle;

    private String directory;
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        resourceBundle = resources;
        try {
            lbVersion.setText(Main.VERSION);
            directory = System.getProperty("user.home") + "\\Documents\\Forward Development\\City Car Driving Steam\\config\\";
            System.out.println(directory);
            lbPath.setText(directory);
            cfg = new ConfigEditor(directory);
            lbStatus.setText("STATUS: OK!");
            lbStatus.setTextFill(Paint.valueOf("Green"));
            cboxPreset.setItems(cfg.PRESETS);
            cboxPreset.setValue(cfg.getCurrentPreset());
            cbTripleHead.setSelected(cfg.getTripleHead());
            cbMultiMonitors.setSelected(cfg.getMultiMonitors());

        } catch (SecurityException e) {
            System.out.println("Doesn't allow access to the specified property.");
        } catch (IOException e) {
            lbStatus.setTextFill(Paint.valueOf("Red"));
            lbStatus.setText("STATUS: CAN'T FIND OR OPEN FILES");
            System.out.println("Can't find config files.");
        }
    }


    public void onSetFolderAction() {
        try {
            fileChooser.setTitle("Choose ccd config directory");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onSaveAction() {
        try {
            cfg.setMultiMonitor(cbMultiMonitors.isSelected());
            cfg.setTripleHead(cbTripleHead.isSelected());
            cfg.setCurrentPreset((String)cboxPreset.getValue());


            cfg.saveAll();
            lbStatus.setTextFill(Paint.valueOf("Green"));
            lbStatus.setText("STATUS: SAVED!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            lbStatus.setTextFill(Paint.valueOf("Red"));
            lbStatus.setText(resourceBundle.getString("status.error"));
        }
    }

}
