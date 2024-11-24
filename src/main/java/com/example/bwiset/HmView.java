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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HmView {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<StudentList> HMTableView;

    @FXML
    private TableColumn<StudentList, Integer> IDTableColumn;

    @FXML
    private TableColumn<StudentList, Integer> SchoolIDNumberTableColumn;

    @FXML
    private TableColumn<StudentList, String> StudentNameTableColumn;

    @FXML
    private TableColumn<StudentList, String> CourseTableColumn;

    @FXML
    private TableColumn<StudentList, String> YearLevelTableColumn;

    // BUTTONS
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
    private TextField SearchTextfield;  // The TextField for searching

    // List to hold the full data
    private ObservableList<StudentList> allStudents;

    // The filtered list that is shown in the TableView
    private ObservableList<StudentList> filteredStudents;

    // Set up the TableView and its columns
    @FXML
    public void initialize() {
        // Set cell value factories for each column
        IDTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        SchoolIDNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("school_id_number"));
        StudentNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("student_name"));
        CourseTableColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
        YearLevelTableColumn.setCellValueFactory(new PropertyValueFactory<>("year_level"));

        // Initialize the lists
        allStudents = FXCollections.observableArrayList();
        filteredStudents = FXCollections.observableArrayList();

        // Load data into the allStudents list
        loadDataFromDatabase();

        // Bind the TableView to the filtered list
        HMTableView.setItems(filteredStudents);

        // Add a listener to the SearchTextfield to update the filter dynamically
        SearchTextfield.textProperty().addListener((observable, oldValue, newValue) -> {
            filterTable(newValue);
        });
    }

    private void loadDataFromDatabase() {
        // Query to fetch data from MySQL database
        String query = "SELECT id, school_id_number, student_name, course, year_level FROM criminology_student_list";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Clear the list before loading new data
            allStudents.clear();

            // Add data to the allStudents list
            while (resultSet.next()) {
                allStudents.add(new StudentList(
                        resultSet.getInt("id"),
                        resultSet.getInt("school_id_number"),
                        resultSet.getString("student_name"),
                        resultSet.getString("course"),
                        resultSet.getString("year_level")
                ));
            }

            // Initially, display all students
            filteredStudents.setAll(allStudents);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Filter the table based on the search query
    private void filterTable(String query) {
        if (query == null || query.isEmpty()) {
            filteredStudents.setAll(allStudents); // Show all if query is empty
        } else {
            // Filter the list based on the query
            ObservableList<StudentList> filtered = FXCollections.observableArrayList();

            for (StudentList student : allStudents) {
                if (student.getStudent_name().toLowerCase().contains(query.toLowerCase()) ||
                        student.getCourse().toLowerCase().contains(query.toLowerCase()) ||
                        student.getYear_level().toLowerCase().contains(query.toLowerCase())) {
                    filtered.add(student);
                }
            }

            // Update the table with the filtered list
            filteredStudents.setAll(filtered);
        }
    }

    // Switch scenes methods
    private void switchScene(String fxmlFile, Button button, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToInfoTech(ActionEvent event) throws IOException {
        switchScene("hello-view.fxml", itButton, event);
        loadDataFromDatabase();  // Reload data when switching scene
    }

    @FXML
    public void switchToHM(ActionEvent event) throws IOException {
        switchScene("hm-view.fxml", hmButton, event);
        loadDataFromDatabase();  // Reload data when switching scene
    }

    @FXML
    public void switchToInfoBA(ActionEvent event) throws IOException {
        switchScene("ba-view.fxml", baButton, event);
        loadDataFromDatabase();  // Reload data when switching scene
    }

    @FXML
    public void switchToInfoCrim(ActionEvent event) throws IOException {
        switchScene("crim-view.fxml", criminologyButton, event);
        loadDataFromDatabase();  // Reload data when switching scene
    }

    @FXML
    public void switchToInfoEduc(ActionEvent event) throws IOException {
        switchScene("educ-view.fxml", educationButton, event);
        loadDataFromDatabase();  // Reload data when switching scene
    }
}
