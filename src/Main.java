import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Button btnAlert, btnConfirm, btnClose;

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

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10)); // works more like a margin
        grid.setVgap(8);
        grid.setHgap(10);

        // Name Label
        Label lblName = new Label("Username:");
        GridPane.setConstraints(lblName, 0, 0);

        // Name input
        TextField txtName = new TextField("Bucky");
        GridPane.setConstraints(txtName, 1, 0);

        // Password Label
        Label lblPassword = new Label("Password:");
        GridPane.setConstraints(lblPassword, 0, 1);

        // Password input
        TextField txtPassword = new TextField();
        txtPassword.setPromptText("Prompt Text");
        GridPane.setConstraints(txtPassword, 1 ,1);

        // Login button
        Button btnLogin = new Button("Log In");
        GridPane.setConstraints(btnLogin, 1, 2);

        grid.getChildren().addAll(lblName, txtName, lblPassword, txtPassword, btnLogin);

        btnAlert = new Button("Alert");
        btnAlert.setOnAction(e -> AlertBox.display("Alert", "This is an alert"));
        btnConfirm = new Button("Confirmation");
        btnConfirm.setOnAction(e -> ConfirmBox.display("Confirmation", "This is not really doing anything... Why did you press this?"));
        btnClose = new Button("Close");
        btnClose.setOnAction(e -> closeProgram());

        Scene scene = new Scene(grid, 300, 200);
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
