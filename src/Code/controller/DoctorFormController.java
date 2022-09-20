package Code.controller;

import Code.dao.DatabaseAccess;
import Code.entity.Doctor;
import Code.view.table.DoctorTable;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class DoctorFormController {
    public TextField txtid;
    public TextField txtname;
    public TextField txtaddress;
    public TextField txtContact;
    public TableView tableDoctor;
    public TableColumn Colid;
    public TableColumn ColName;
    public TableColumn ColAddress;
    public TableColumn ColContact;
    public TableColumn ColOption;
    public JFXButton btnSaveDoctor;
    public TextField txtsearch;

    public void initialize(){
        Colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        ColContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        ColOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        searchData(searchtext);
        tableDoctor.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                 if(newValue!=null){
                     setData((DoctorTable) newValue);
                 }
                });
        txtsearch.textProperty().addListener((observable, oldValue, newValue) -> {
            searchtext=newValue;
            searchData(searchtext);
        });
    }

    private String searchtext="";
    private void setData(DoctorTable table){
      btnSaveDoctor.setText("Update Doctor");
      txtid.setText(table.getId());
      txtname.setText(table.getName());
      txtaddress.setText(table.getAddress());
      txtContact.setText(table.getContact());
    }
    private void searchData(String text) {
        try {
            ArrayList<Doctor> list = DatabaseAccess.searchDoctor(text);
            ObservableList<DoctorTable> tableList = FXCollections.observableArrayList();

            for (Doctor d : list
            ) {
                Button btn = new Button("Delete");
                tableList.add(new DoctorTable(d.getDid(), d.getName(), d.getAddress(), d.getContact(), btn));
                btn.setOnAction(event -> {
                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are you sure",
                             ButtonType.YES,ButtonType.NO);
                    Optional<ButtonType> buttonType =alert.showAndWait();
                    if(buttonType.get()==ButtonType.YES){
                        try {
                            if( new DatabaseAccess().deleteDoctor(d.getDid())){
                                searchData(searchtext);
                                new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
                            }
                            else{
                                new Alert(Alert.AlertType.WARNING,"Try Againg").show();
                            }
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
            tableDoctor.setItems(tableList);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);

        }
    }


    public void saveDoctorOnAction(ActionEvent actionEvent) {
        Doctor d1=new Doctor(
                txtid.getText(), txtname.getText(), txtaddress.getText(), txtContact.getText()
        );
        if(btnSaveDoctor.getText().equals("Save Doctor")){
            try {
                boolean rslt= DatabaseAccess.saveDoctor(d1);
                if(rslt){
                    searchData(searchtext);
                    new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();
                }
                else{
                    new Alert(Alert.AlertType.WARNING,"Try Againg").show();
                }
            } catch (ClassNotFoundException | SQLException e){
                new Alert(Alert.AlertType.ERROR,"Try Againg").show();
                e.printStackTrace();
            }
        }
        else{
            try {
                boolean rslt= DatabaseAccess.updateDoctor(d1);
                if(rslt){
                    searchData(searchtext);
                    new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
                }
                else{
                    new Alert(Alert.AlertType.WARNING,"Try Againg").show();
                }
            } catch (ClassNotFoundException | SQLException e){
                new Alert(Alert.AlertType.ERROR,"Try Againg").show();
                e.printStackTrace();
            }
        }


    }


    public void btnNewDoctorOnAction(ActionEvent actionEvent) {
        btnSaveDoctor.setText("Save Doctor");
    }
}


