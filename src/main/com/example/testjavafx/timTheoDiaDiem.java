package main.com.example.testjavafx;

import DAO.thienTaiDAO;
import Model.thienTai;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class timTheoDiaDiem implements Initializable {
    @FXML
    private TextField khuvuc;
    @FXML
    private Label kiemtra;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void timTheoDiaDiem(ActionEvent event) {
        if (khuvuc.getText().isEmpty()) {
            kiemtra.setText("ban chua nhap khu vuc");
        } else {
            thienTai test1 = new thienTai();
            test1.setKhuVuc(khuvuc.getText());
            thienTaiDAO.getInstance().selectByKhuVuc(test1, khuvuc.getText());
        }
    }
}
