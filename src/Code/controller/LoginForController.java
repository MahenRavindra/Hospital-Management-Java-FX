package Code.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginForController {
    public AnchorPane loginPaneContext;

    public void OpenSignupOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) loginPaneContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(
                "../view/SignUpForm.fxml"
        ))));
    }

    public void dashboardbtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) loginPaneContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(
                "../view/DashBoard.fxml"
        ))));
    }
}
