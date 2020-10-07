import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Login {

    public static void display() {
        Stage window = new Stage();

        // block user interaction with other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Login");
        window.setMinWidth(250);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label lblName = new Label("Username");
        GridPane.setConstraints(lblName, 0, 0);

        // Name input
        TextField txtName = new TextField("Bucky");
        GridPane.setConstraints(txtName, 1, 0);

        // Password Label
        Label lblPassword = new Label("Password:");
        GridPane.setConstraints(lblPassword, 0, 1);

        // Password input
//        TextField txtPassword = new TextField();
        PasswordField txtPassword = new PasswordField();
//        txtPassword.setPromptText("Prompt Text");
        GridPane.setConstraints(txtPassword, 1 ,1);

        // Login button
        Button btnLogin = new Button("Log In");
        GridPane.setConstraints(btnLogin, 1, 2);

        grid.getChildren().addAll(lblName, txtName, lblPassword, txtPassword, btnLogin);

        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);
        window.show();
    }
}
