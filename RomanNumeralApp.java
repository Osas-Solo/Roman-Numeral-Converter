import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class RomanNumeralApp extends Application {

    Stage window;
    Scene scene;
    VBox windowContent;
    Label message;
    ChoiceBox<String> option;
    TextField input;
    Button convertButton;
    Label result;
    Button resetButton;
    Alert error;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //  initialise window
        window = primaryStage;
        windowContent = new VBox(10);
        windowContent.setAlignment(Pos.CENTER);

        // initialise widgets
        message = new Label("Select numerals to convert to:");
        String[] options = {"Roman Numerals", "Arabic Numerals"};
        option = new ChoiceBox<>();
        option.getItems().addAll(options);
        option.setValue("Roman Numerals");
        input = new TextField();
        input.setPromptText("Enter numeral:");
        convertButton = new Button("Convert");
        result = new Label("");
        resetButton = new Button("Reset");

        //  add widgets to window
        windowContent.getChildren().addAll(message, option, input, convertButton, result, resetButton);
        scene = new Scene(windowContent, 400, 300);
        window.setScene(scene);
        window.setTitle("Roman Numeral Converter");
        window.setResizable(true);
        window.setMaximized(true);
        window.show();

        //  error message
        error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Numeral Error");
        error.setHeaderText("");

        //  set action
        convertButton.setOnAction(e -> {
            result.setText("");
            String inputValue = input.getText();
            int number;
            String roman;
            RomanNumeral numeral;

            //  convert to Roman numeral
            if (option.getValue().equals("Roman Numerals")) {
                try {
                    number = Integer.parseInt(inputValue);
                    numeral = new RomanNumeral(number);

                    if (numeral.isValid) {
                        result.setText(inputValue + " = " + numeral.romanNumeral);
                    }

                    else {
                        error.setContentText("Please enter a number (1 - 3999)");
                        error.showAndWait();
                    }
                } catch (NumberFormatException e1) {
                    error.setContentText("Please enter a number (1 - 3999)");
                    error.showAndWait();
                }
            }  // end of if to convert to Roman numeral

            //  convert to Arabic numeral
            else if (option.getValue().equals("Arabic Numerals")) {
                    roman = inputValue;
                    numeral = new RomanNumeral(roman);

                    if (numeral.isValid) {
                        result.setText(inputValue.toUpperCase() + " = " + numeral.arabicNumeral);
                    }

                    else {
                        error.setContentText("Please enter a valid Roman numeral");
                        error.showAndWait();
                    }
            }  // end of if to convert to Arabic numeral

        });  //  end of convertButton action

        resetButton.setOnAction(e -> {
            input.setText("");
        });

        //  set style
        scene.getStylesheets().add("style.css");

    }  //  end of start()

}  // end of class
