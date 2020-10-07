import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Button buttonAlert, buttonConfirm;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args); // inside the application class - set up program as javafx application
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Title of the Window");

        buttonAlert = new Button("Click Me");
        buttonAlert.setOnAction(e -> AlertBox.display("Alert Title", "This is the message of the alert box."));

        buttonConfirm = new Button("Confirmation");
        buttonConfirm.setOnAction(e -> {
            boolean result = ConfirmBox.display("Confirmation", "Are you sure?");
            System.out.println(result);
        });

        VBox layout = new VBox(20);
        layout.getChildren().addAll(buttonAlert, buttonConfirm);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
