package Code.controller;

import com.sun.deploy.util.FXLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBoardController {

    public AnchorPane dashboardContext;

    public void initialize() throws IOException {
        loadDefaultData();
    }

    private void loadDefaultData() throws IOException {
        setUI("DefaultForm");
    }

    public void openDoctorManageOnAction(ActionEvent actionEvent) throws IOException {
        setUI("DoctorForm");
    }

    private void setUI(String location) throws IOException {
        dashboardContext.getChildren().clear();
        dashboardContext.getChildren().add(
                FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))
        );
    }
}
