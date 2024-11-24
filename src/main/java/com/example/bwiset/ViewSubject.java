package com.example.bwiset;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewSubject {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button itButton;
    @FXML
    private Button hmButton;
    @FXML
    private Button baButton;
    @FXML
    private Button criminologyButton;
    @FXML
    private Button educationButton;

    @FXML
    private Button viewGradeButton;
    @FXML
    private Button viewSubjectButton;


    private Button activeButton;

    // Set the active button's style
    private void setActiveButton(Button button) {
        if (activeButton != null) {
            activeButton.getStyleClass().remove("active");
            activeButton.applyCss(); // Force style update
        }
        button.getStyleClass().add("active");
        button.applyCss(); // Force style update
        activeButton = button;

        // Debugging
        System.out.println("Active button: " + button.getText());
        System.out.println("Style classes: " + button.getStyleClass());
    }

    // Switch to a new scene and update active button
    private void switchScene(String fxmlFile, Button button, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        root = loader.load();

        // Get the current stage
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        // Update the active button
        setActiveButton(button);
    }

    @FXML
    public void switchToInfoTech(ActionEvent event) throws IOException {
        switchScene("hello-view.fxml", itButton, event);
    }

    @FXML
    public void switchToHM(ActionEvent event) throws IOException {
        switchScene("hm-view.fxml", hmButton, event);
    }

    @FXML
    public void switchToInfoBA(ActionEvent event) throws IOException {
        switchScene("ba-view.fxml", baButton, event);
    }

    @FXML
    public void switchToInfoCrim(ActionEvent event) throws IOException {
        switchScene("crim-view.fxml", criminologyButton, event);
    }

    @FXML
    public void switchToInfoEduc(ActionEvent event) throws IOException {
        switchScene("educ-view.fxml", educationButton, event);
    }



}
