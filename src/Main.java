import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args); // inside the application class - set up program as javafx application
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Asa's Console");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        HBox topMenu = new HBox();
        Button buttonFile = new Button("File");
        Button buttonEdit = new Button("Edit");
        Button buttonView = new Button("View");
        topMenu.getChildren().addAll(buttonFile, buttonEdit, buttonView);

        VBox leftMenu = new VBox();
        Button buttonD = new Button("D");
        Button buttonE = new Button("E");
        Button buttonF = new Button("F");
        leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);

        HBox bottomMenu = new HBox();
        Button buttonAlert = new Button("Alert");
        buttonAlert.setOnAction(e -> AlertBox.display("Alert", "This is an alert"));
        Button buttonConfirm = new Button("Confirmation");
        buttonConfirm.setOnAction(e -> ConfirmBox.display("Confirmation", "This is not really doing anything... Why did you press this?"));
        Button buttonClose = new Button("Close");
        buttonClose.setOnAction(e -> closeProgram());
        bottomMenu.getChildren().addAll(buttonAlert, buttonConfirm, buttonClose);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);
        borderPane.setBottom(bottomMenu);

        Scene scene = new Scene(borderPane, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("Confirmation", "Are you sure you want to exit?");
        if (answer) {
            window.close();
        }
    }
}
