package Code.controller;

import com.sun.deploy.util.FXLoader;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBoardController {

    public AnchorPane dashboardContext;

    public void initialize() throws IOException {
        loadDefaultData();
    }

    private void loadDefaultData() throws IOException {
        dashboardContext.getChildren().clear();
        dashboardContext.getChildren().add(
                FXMLLoader.load(getClass().getResource("../view/DefaultForm.fxml"))
        );
    }
}
