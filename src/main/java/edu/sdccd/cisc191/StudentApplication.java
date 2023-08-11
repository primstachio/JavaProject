package edu.sdccd.cisc191;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
/**
 * (MODULE 2) JavaFX GUI
 * A JavaFX GUI version of the interactive console menu demonstrated in StudentMenu.
 */
public class StudentApplication extends Application {
    private StudentMenu studentMenu = new StudentMenu();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("STUDENT DATABASE");
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: #ddbea9");
        ListView<String> studentListView = new ListView<>();
        Button addButton = new Button("ADD STUDENT");
        addButton.setStyle("-fx-padding: 12px; -fx-border-color: #9c6644; -fx-border-width: 3px;-fx-background-color: #ffe8d6;" +
                "-fx-font: 15px Constantia;");
        Button removeButton = new Button("REMOVE STUDENT");
        removeButton.setStyle("-fx-padding: 12px; -fx-border-color: #9c6644; -fx-border-width: 3px;-fx-background-color: #ffe8d6;" +
                "-fx-font: 15px Constantia;");
        Button printALlButton = new Button("DISPLAY ALL STUDENTS WITH GPA");
        printALlButton.setStyle("-fx-padding: 12px; -fx-border-color: #9c6644; -fx-border-width: 3px;-fx-background-color: #ffe8d6;" +
                "-fx-font: 15px Constantia;");
        Button ssidButton = new Button("SEARCH STUDENT BY SSID");
        ssidButton.setStyle("-fx-padding: 12px; -fx-border-color: #9c6644; -fx-border-width: 3px;-fx-background-color: #ffe8d6;" +
                "-fx-font: 15px Constantia;");
        Button gpaButton = new Button("SEARCH STUDENT(S) BY GPA");
        gpaButton.setStyle("-fx-padding: 12px; -fx-border-color: #9c6644; -fx-border-width: 3px;-fx-background-color: #ffe8d6;" +
                "-fx-font: 15px Constantia;");
        Button exitButton = new Button("EXIT");
        exitButton.setStyle("-fx-padding: 12px; -fx-border-color: #9c6644; -fx-border-width: 3px;-fx-background-color: #ffe8d6;" +
                "-fx-font: 15px Constantia;");
        addButton.setOnAction(event -> studentMenu.addStudent());
        removeButton.setOnAction(event -> studentMenu.removeStudent());
        printALlButton.setOnAction(event -> studentMenu.printAll());
        ssidButton.setOnAction(event -> studentMenu.searchBySSID());
        gpaButton.setOnAction(event -> studentMenu.searchByGPA());
        exitButton.setOnAction(event -> primaryStage.close());
        vbox.getChildren().addAll(studentListView, addButton, removeButton, printALlButton,
                                                        ssidButton, gpaButton, exitButton);
        Scene scene = new Scene(vbox, 1600, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
