import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;


public class Driver extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BufferedReader reader = null;
        ListView<Student> listView = new ListView<>();

        try
        {
            reader = new BufferedReader(new FileReader("student_data.csv"));

        }
        catch (FileNotFoundException e)
        {
            System.out.println("Please add student_data.csv to the working directory");
        }
        String line;

        try
        {
            if (reader != null)
            {
                while ((line = reader.readLine()) != null)
                {
                    Student student = new Student(line);
                    listView.getItems().add(student);
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        // use setCellFactory(...) to set font to size 14 and apply text color of your choosing to the rows of the ListView.
        listView.setCellFactory(e -> new ListCell<Student>() {
            @Override
            protected void updateItem(Student student, boolean empty) {
                super.updateItem(student, empty);
            
                if (empty || student == null) {
                    setText(null);
                } else {
                    setText(student.toString());
                    setFont(new Font("Menlo", 14));
                    setTextFill(Color.LAVENDER);
                    // set cells to orange/yellow
                    // change color when selected to red
                    setStyle("-fx-background-color: MEDIUMPURPLE; -fx-border-color: LAVENDER; -fx-border-width: 1px;");
                }
            }
        });
        listView.setMinWidth(500);

        // ListView must handle single and multiple selection.
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // When user clicks on a row of the ListView, the name of the student (first and last name) should appear on the Label
        // should list all students if multiple are selected
        Label selectedLbl = new Label();
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Selected: ");
                ObservableList<Student>selected = listView.getSelectionModel().getSelectedItems();
                int last = selected.size();
                for (Student student : selected) {
                    sb.append(student.getFirstName());
                    sb.append(" ");
                    sb.append(student.getLastName());
                    sb.append((last > 1) ? ", " : "");      // add commans for all but the last student
                    last --;
                }
                selectedLbl.setText(sb.toString());
            } else {
                selectedLbl.setText("");
            }
        });
        selectedLbl.setFont(new Font("Menlo", 14));
        selectedLbl.setTextFill(Color.CORAL);

        // create button with action listener to delete all selected entries in the ListView
        Button deleteBtn = new Button("Delete Selected");
        deleteBtn.setFont(new Font("Menlo", 14));
        deleteBtn.setTextFill(Color.WHITE);
        deleteBtn.setStyle("-fx-background-color: RED;");

        deleteBtn.setOnAction(e -> {
            ObservableList<Student> selected = listView.getSelectionModel().getSelectedItems();
            listView.getItems().removeAll(selected);
            selectedLbl.setText("");
        });

        // put everything in a flowpane
        FlowPane pane = new FlowPane();
        pane.getChildren().addAll(listView, deleteBtn, selectedLbl);
        pane.setHgap(400);
        pane.setVgap(20);
        pane.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: LAVENDER;");

        Scene scene = new Scene(pane, 500, 600);

        primaryStage.setTitle("Grandma's Student List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
