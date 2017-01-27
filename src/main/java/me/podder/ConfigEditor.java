package me.podder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import org.ini4j.*;

/**
 * <p>Wrapper class to work with configuration files</p>
 * <p>Using ini4j</p>
 * <p>Last compatible: 0.5.4 (Available in Maven)</p>
 * @since 0.0.1
 * @version 0.0.1
 * @author intosKai
 */
public class ConfigEditor {
    private Wini game_ini;
    private Wini mangalore_ini;
    private String folderPath;
    static final ObservableList<String> PRESETS = FXCollections.observableArrayList("default", "PanoramaPanel3");

    public ConfigEditor(String folderPath) throws IOException {
        this.folderPath = folderPath;
        game_ini = new Wini(new File(folderPath + "game.ini"));
        mangalore_ini = new Wini(new File(folderPath + "mangalore.ini"));

    }

    /**
     * <p>Gets TripleHead property in graphics section</p>
     * @return TripleHead property
     */
    public boolean getTripleHead() {
        //TODO: nullpointer checker
        return Boolean.valueOf(game_ini.get("Graphics", "TripleHead"));
    }

    /**
     * <p>Gets CurrentPreset property</p>
     * @return CurrentPreset property
     */
    public String getCurrentPreset() {
        //TODO: nullpointer checker
        String buf = mangalore_ini.get("Graphics", "CurrentPreset");
        return buf.substring(1, buf.length() - 1);
    }

    /**
     * <p>Gets EnableMultiMonitor property</p>
     * @return EnableMultiMonitor property
     */
    public boolean getMultiMonitors() {
        //TODO: nullpointer checker
        return Boolean.valueOf(mangalore_ini.get("Graphics", "EnableMultiMonitor"));
    }


    /**
     *<p>Sets EnableMiltiMonitor property</p>
     * @param bl    EnableMultiMonitor property
     * @since 0.0.1
     */
    public void setMultiMonitor(boolean bl) {
        mangalore_ini.put("Graphics", "EnableMultiMonitor", bl);
    }

    public void setTripleHead(boolean bl) {
        game_ini.put("Graphics", "TripleHead", bl);
    }
    public void setCurrentPreset(String value) {
        String prop = String.format("\"%s\"", value); //in case
        mangalore_ini.put("Graphics", "CurrentPreset", prop);
    }

    /**
     * <p>Save all properties in ini files</p>
     * @since 0.0.1
     * @throws IOException
     */
    public void saveAll() throws IOException {
        game_ini.store();
        mangalore_ini.store();
    }


    /**
     * <p>Clear all properties without saving</p>
     * <p>To save use saveAll()</p>
     * @since 0.0.1
     */
    public void dispose() {
        game_ini.clear();
        mangalore_ini.clear();
    }

}
