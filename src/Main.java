import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    // TODO: rename variables
    Stage window;
    Button btnAlert, btnConfirm, btnClose;
    Button button;

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

        TextField txt_name = new TextField();
        button = new Button("Click Me");
        button.setOnAction(e -> isInt(txt_name));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(txt_name, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("Confirmation", "Are you sure you want to exit?");
        if (answer) {
            window.close();
        }
    }

    private void setButtonEvents() {
        btnAlert = new Button("Alert");
        btnAlert.setOnAction(e -> AlertBox.display("Alert", "This is an alert"));
        btnConfirm = new Button("Confirmation");
        btnConfirm.setOnAction(e -> ConfirmBox.display("Confirmation", "This is not really doing anything... Why did you press this?"));
        btnClose = new Button("Close");
        btnClose.setOnAction(e -> closeProgram());
    }

    private void isInt(TextField input) {
        try {
            int age = Integer.parseInt(input.getText());
            AlertBox.display("Age", "Age is: " + age);
        } catch (NumberFormatException e) {
            AlertBox.display("Input Error", "You must input an integer");
        }
    }
}
