import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class System extends Application {

    private TableView<Resource> resourceTable;
    private ObservableList<Resource> resourceList;

    private TextField titleField;
    private TextField authorField;
    private TextField typeField;

    private File dataFile;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library Management System");

        // Create the main layout
        VBox mainLayout = new VBox();
        mainLayout.setSpacing(10);
        mainLayout.setPadding(new Insets(10));

        // Create the table to display the resources
        resourceTable = new TableView<>();
        resourceList = FXCollections.observableArrayList();
        resourceTable.setItems(resourceList);

        TableColumn<Resource, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());

        TableColumn<Resource, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());

        TableColumn<Resource, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());

        //resourceTable.getColumns().addAll(titleColumn, authorColumn, typeColumn);
        resourceTable.getColumns().addAll(titleColumn, authorColumn, typeColumn);
        // Create the form to add new resources
        GridPane formPane = new GridPane();
        formPane.setHgap(10);
        formPane.setVgap(5);

        titleField = new TextField();
        titleField.setPromptText("Title");

        authorField = new TextField();
        authorField.setPromptText("Author");

        typeField = new TextField();
        typeField.setPromptText("Type");

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addResource());

        formPane.add(new Label("Title:"), 0, 0);
        formPane.add(titleField, 1, 0);
        formPane.add(new Label("Author:"), 0, 1);
        formPane.add(authorField, 1, 1);
        formPane.add(new Label("Type:"), 0, 2);
        formPane.add(typeField, 1, 2);
        formPane.add(addButton, 1, 3);

        // Create the main scene
        mainLayout.getChildren().addAll(resourceTable, formPane);
        Scene scene = new Scene(mainLayout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Load the data file
        dataFile = new File("library_data.txt");
        loadData();
    }

    private void loadData() {
        resourceList.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    String title = fields[0].trim();
                    String author = fields[1].trim();
                    String type = fields[2].trim();
                    Resource resource = new Resource(title, author, type);
                    resourceList.add(resource);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addResource() {
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        String type = typeField.getText().trim();

        if (!title.isEmpty() && !author.isEmpty() && !type.isEmpty()) {
            Resource resource = new Resource(title, author, type);
            resourceList.add(resource);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile, true))) {
                writer.write(title + "," + author + "," + type);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Clear the form fields
            titleField.clear();
            authorField.clear();
            typeField.clear();
        }
    }

    // Resource class to represent a library resource
    private static class Resource {
        private final String title;
        private final String author;
        private final String type;

        public Resource(String title, String author, String type) {
            this.title = title;
            this.author = author;
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getType() {
            return type;
        }

        public StringProperty titleProperty() {
            return new SimpleStringProperty(title);
        }

        public StringProperty authorProperty() {
            return new SimpleStringProperty(author);
        }

        public StringProperty typeProperty() {
            return new SimpleStringProperty(type);
        }
    }
}