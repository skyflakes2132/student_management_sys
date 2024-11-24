package com.example.bwiset;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class HelloController {

        private Stage stage;
        private Scene scene;
        private Parent root;


        //BUTTONS
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

        private Button activeButton;









        // Set the active button's style

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

//    private void loadCourseData(String courseName) {
//        ObservableList<Student> students = FXCollections.observableArrayList();
//        String url = "jdbc:mysql://localhost:3306/studentdb"; // Update the database name if needed
//        String user = "root"; // Update if your XAMPP user is different
//        String password = ""; // Update if you have a password for MySQL
//
//        String query = "SELECT * FROM Students WHERE course = ?"; // Use parameterized query to prevent SQL injection
//
//        try (Connection connection = DriverManager.getConnection(url, user, password);
//             java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//
//            preparedStatement.setString(1, courseName); // Set course name parameter
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                students.add(new Student(
//                        resultSet.getInt("id"),
//                        resultSet.getInt("schoolIdNo"),
//                        resultSet.getString("name"),
//                        resultSet.getString("course"),
//                        resultSet.getString("year_level"),
//                        resultSet.getDouble("gwa")
//
//                ));
//            }
//
//            System.out.println("Fetched students: " + students.size()); // Debug print
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Set items to TableView
//        studentTable.setItems(students);
//    }
    }
