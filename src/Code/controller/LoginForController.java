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
      setUI("SignUpForm");
    }

    public void dashboardbtnOnAction(ActionEvent actionEvent) throws IOException {
        setUI("DashBoard");
    }

    public void setUI(String location) throws IOException {
        Stage stage= (Stage) loginPaneContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(
                "../view/"+location+".fxml"
        ))));
    }
}
