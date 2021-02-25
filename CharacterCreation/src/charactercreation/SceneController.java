/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charactercreation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import static java.util.Collections.list;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author waelh
 */
public class SceneController implements Initializable {

    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private RadioButton other;
    @FXML
    private TextField nameField;
    @FXML
    private Slider slider1;
    @FXML
    private Text justice;
    @FXML
    private Slider slider2;
    @FXML
    private Text wisdom;
    @FXML
    private Slider slider3;
    @FXML
    private Text honor;
    @FXML
    private Text compassion;
    @FXML
    private Text strength;
    @FXML
    private Text humility;
    @FXML
    private ComboBox<String> className;
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem open;
    @FXML
    private MenuItem save;
    @FXML
    private MenuItem reset;
    @FXML
    private MenuItem exit;
    @FXML
    private ToggleGroup gender;
    @FXML
    private Button randomCharacter;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Startup Code
        //Creates and adds classes to drop-down menu.
        className.getItems().addAll(null, "Warrior", "Barbarian", "Monk", "Mage", "Thief");
        /**
         * These lines of code are repeated here from below to start taking
         * effect at startup. Codes are repeated for all three sliders.
         */
        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            justice.setText(String.format("%d", 100 - newValue.intValue()));
            compassion.setText(String.format("%d", newValue.intValue()));
        });
        slider2.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldVlaue, Number newValue) -> {
            strength.setText(String.format("%d", 100 - newValue.intValue()));
            wisdom.setText(String.format("%d", newValue.intValue()));
        });
        slider3.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            humility.setText(String.format("%d", 100 - newValue.intValue()));
            honor.setText(String.format("%d", newValue.intValue()));
        });
        onRandom(new ActionEvent());    //I added this methos to randomize characters' attributes.
        onReset(new ActionEvent());     //I used the same method that is called when pressing the reset button.

        //This is to limit the nameField (Text Field) to 10 characters only.
//        try{
        nameField.lengthProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            if (newValue.intValue() > oldValue.intValue()) {
                if (nameField.getText().length() >= 10) {
                    nameField.setText(nameField.getText().substring(0, 10));
                }
                //This is to limit nameField (Text Field) to letters only
                if (!nameField.getText().matches("^[a-zA-Z]*$")) {
                    nameField.setText(nameField.getText().substring(0, nameField.getLength() - 1));
                }
            }
        });
//        }
//        catch (IllegalArgumentException event) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Character Creation");
        alert.setHeaderText("General Error");
        alert.setContentText("Wrong character keyed");
//        }
    }//end of Initialize.

    @FXML
    private void onSlide1(MouseEvent event) {
        slider1.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            justice.setText(String.format("%d", 100 - newValue.intValue()));
            compassion.setText(String.format("%d", newValue.intValue()));
        });
    }//end onSlide1

    @FXML
    private void onSlide2(MouseEvent event) {
        slider2.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            strength.setText(String.format("%d", 100 - newValue.intValue()));
            wisdom.setText(String.format("%d", newValue.intValue()));
        });
    }//end onSlide2

    @FXML
    private void onSlide3(MouseEvent event) {
        slider3.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            humility.setText(String.format("%d", 100 - newValue.intValue()));
            honor.setText(String.format("%d", newValue.intValue()));
        });
    }//end onSlide3

    @FXML
    private void onOpen(ActionEvent event) {
        try {
            /**
             * The below code is to create a file chooser window to select
             * character files.
             */
            File directory = new File("C:\\Users\\waelh\\JavaClass\\CIS-2151\\Project4\\CharacterCreation");
            Stage stage = new Stage();
            FileChooser file = new FileChooser();
            file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Player Files", "*.player"));
            file.setInitialDirectory(directory);
            file.setTitle("Open Character File");
            File person = file.showOpenDialog(stage);
            Scanner scan = new Scanner(person);
            String values; //This refrence is used to capture data from file
            //Capturing Name (Text Field)
            values = scan.nextLine().substring(16).trim();
            nameField.setText(values);
            scan.nextLine();
            scan.nextLine();
            //Capturing Gender (Radio Button Group)
            values = scan.nextLine().substring(7).trim();
            int x;
            switch (values) {
                case "Male":
                    x = 0;
                    break;
                case "female":
                    x = 1;
                    break;
                default:
                    x = 2;
            }
            gender.selectToggle(gender.getToggles().get(x));
            //Capturing Class (Drop-Down menu)
            values = scan.nextLine().substring(7).trim();
            className.getSelectionModel().select(values);
            for (x = 0; x < 5; x++) {
                scan.nextLine();
            }
            /**
             * Capturing Attributes (Int for Sliders) Skipping every other value
             * because attributes are set as opposites. If one is at x, the
             * other is 100-x.
             */
            int attributes;
            attributes = scan.nextInt();
            slider1.setValue(100 - attributes);
            scan.nextInt();
            attributes = scan.nextInt();
            slider2.setValue(100 - attributes);
            scan.nextInt();
            attributes = scan.nextInt();
            slider3.setValue(100 - attributes);

        } catch (FileNotFoundException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Character Creation");
            alert.setHeaderText("File Not Found or wrong file selected.");
            alert.setContentText("This is not a Character file, Please choose another");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Character Creation");
            alert.setHeaderText("General Error");
            alert.setContentText("Something went wrong or wrong file selected");
            alert.showAndWait();
        }

    }//end onOpen

    @FXML
    private void onSave(ActionEvent event) throws Exception {
        Alert confirm = new Alert(AlertType.CONFIRMATION);
        confirm.setTitle("Character Creation");
        confirm.setHeaderText("Save Confirmation");
        confirm.setContentText("Are you sure you want to save character?");
        confirm.showAndWait();
        if (confirm.getResult() == ButtonType.OK){
        
        PrintWriter file;
        RadioButton selectedButton = (RadioButton) gender.getSelectedToggle();
        if (!(gender.getSelectedToggle() == null)) {

            if (!(className.getSelectionModel().isSelected(0))) {

                if (!(nameField.toString().equals(""))) {

                    if (!(nameField.getText() == null)) {

                        if (!(nameField).getText().isBlank()) {
                            file = new PrintWriter(className.getSelectionModel().getSelectedItem() + "_" + nameField.getText() + ".player");
                            file.print("Character Name: " + nameField.getText() + "\n------------------------------------------\n\n");
                            file.print("Gender: " + selectedButton.getText() + "\n");
                            file.print("Class:  " + className.getSelectionModel().getSelectedItem() + "\n\n");
                            file.print("STATS:\n---------\n");
                            file.print("Justice\t\tCompassion\tStrength\tWisdom\t\tHumility\tHonor\n-----------------------------------------------------------------------------------------\n");
                            file.print(String.format("%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d", ((int) (100 - slider1.getValue())), (int) slider1.getValue(), (int) (100 - slider2.getValue()), (int) slider2.getValue(),
                                    (int) (100 - slider3.getValue()), (int) slider3.getValue()));
                            file.close();
                        } else {
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.setTitle("Character Creation");
                            alert.setHeaderText("Name Field is Blank");
                            alert.setContentText("Please write a Character Name");
                            alert.showAndWait();
                        }
                    } else {
                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Character Creation");
                        alert.setHeaderText("Name Field is Empty");
                        alert.setContentText("Please write a Character Name");
                        alert.showAndWait();

                    }
                } else {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Character Creation");
                    alert.setHeaderText("Name Field is Empty");
                    alert.setContentText("Please write a Character Name");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Character Creation");
                alert.setHeaderText("Class is not selected");
                alert.setContentText("Please choose a character Class");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Character Creation");
            alert.setHeaderText("Gender is not selected");
            alert.setContentText("Please choose a character Gender");
            alert.showAndWait();
        }
        Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Character Creation");
            alert.setHeaderText("Save Confirmation");
            alert.setContentText("Character saved Successfully");
            alert.showAndWait();
        } else {
        confirm = new Alert(AlertType.INFORMATION);
        confirm.setTitle("Character Creation");
        confirm.setHeaderText("Save Confirmation");
        confirm.setContentText("Character not saved.");
        confirm.showAndWait();
        }

    }//end onSave

    @FXML
    private void onReset(ActionEvent event) {
        slider1.setValue((int) 50);
        slider2.setValue((int) 50);
        slider3.setValue((int) 50);
        className.getSelectionModel().select(0);
        nameField.setText(null);
        gender.selectToggle(male);
    }//end onReset

    @FXML
    private void onExit(ActionEvent event) {
        System.exit(0);
    }//end onExit

    @FXML
    private void onRandom(ActionEvent event) {
        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0:
                gender.selectToggle(male);
                break;
            case 1:
                gender.selectToggle(female);
                break;
            default:
                gender.selectToggle(other);
                break;
        }
        slider1.setValue(rand.nextInt(101));
        slider2.setValue(rand.nextInt(101));
        slider3.setValue(rand.nextInt(101));
        className.getSelectionModel().select(rand.nextInt(4) + 1);

    }// end onRandom

}
