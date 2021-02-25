/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package favoritesongs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javax.swing.JOptionPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author waelh
 */
public class SceneController implements Initializable {

    @FXML
    private ListView<String> songList;
    @FXML
    private Button loadList;
    @FXML
    private Button saveList;
    @FXML
    private Button removeSong;
    @FXML
    private Button addSong;
    @FXML
    private TextField textField;
    @FXML
    private Button addSong1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        songList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    private void onClick(MouseEvent event) {
    }

    @FXML
    private void onLoad(ActionEvent event) {
        try {
            File file = new File("songs.txt");
            Scanner inputFile = new Scanner(file);
            while (inputFile.hasNext()) {
                songList.getItems().add(inputFile.nextLine());
            }

            inputFile.close();
        } catch (FileNotFoundException ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Favorite Songs");
            alert.setHeaderText("File Not Found");
            alert.setContentText("File \"songs.txt\" isn't available, please press SAVE\n to create a new one.");
            alert.showAndWait();
        }
    }

    @FXML
    private void onSave(ActionEvent event) throws Exception {
        /**
         * Regarding the "throws Exception" part...
         * Not being lazy, but since we don't care if the file exists or no and
         * we either create it or override it, that's why I don't need to handle
         * any of the exceptions by code.
         */

        PrintWriter file = new PrintWriter("songs.txt");
        for (int y = 0; y < songList.getItems().size(); y++) {
            file.print(songList.getItems().get(y) + "\n");
        }

        file.close();
    }

    @FXML
    private void onRemove(ActionEvent event) {
        if (!(songList.getSelectionModel().getSelectedItems().isEmpty())) {
            songList.getItems().removeAll(songList.getSelectionModel().getSelectedItems());
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Favorite Songs");
            alert.setHeaderText("Nothing selected.");
            alert.setContentText("Please choose what to remove\nfrom the list.");
            alert.showAndWait();
        }
    }

    @FXML
    private void onAdd(ActionEvent event) {
        if (!(textField.getText().isBlank() || textField.getText().isEmpty())) {
            songList.getItems().add(textField.getText().trim().toLowerCase());
            textField.setText("");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Favorite Songs");
            alert.setHeaderText("Text field is blank");
            alert.setContentText("Please type a song name to add to\nsongs list.");
            alert.showAndWait();
        }
    }

    /**
     * keyPress: uses the enter key to add an item to the list
     */
    @FXML
    private void keyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            ActionEvent e = new ActionEvent();
            onAdd(e);
        }
    }

    /**
     * delPress: uses the delete key to remove an item from the list
     */
    @FXML
    private void delPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.DELETE)) {
            ActionEvent e = new ActionEvent();
            onRemove(e);
        }
    }

    @FXML
    private void onExit(ActionEvent event) {
        System.exit(0);
    }

}
