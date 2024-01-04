package main.com.example.testjavafx;


import DAO.thienTaiDAO;
import Database.JDBC_Util;
import Model.thienTai;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class themThienTaiController implements Initializable {
    @FXML
    private TextField id;
    @FXML
    private TextField loaithientai;
    @FXML
    private TextField tenrieng;
    @FXML
    private TextField khuvuc;
    @FXML
    private TextField thoigian;
    @FXML
    private TextField mucdo;
    @FXML
    private Label kiemtra;
    static Connection c = JDBC_Util.getConnection();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void them(ActionEvent event) {
        if (id.getText().isEmpty()) {
            kiemtra.setText("ban chua nhap id");
        }
        if (loaithientai.getText().isEmpty()) {
            kiemtra.setText("ban chua nhap loai thien tai");
        }
        if (tenrieng.getText().isEmpty()) {
            kiemtra.setText("ban chua nhap ten rieng");
        }
        if (khuvuc.getText().isEmpty()) {
            kiemtra.setText("ban chua nhap khu vuc");
        }
        if (thoigian.getText().isEmpty()) {
            kiemtra.setText("ban chua nhap thoi gian");
        }
        if (mucdo.getText().isEmpty()) {
            kiemtra.setText("ban chua nhap muc do");
        } else {
            thienTai test = new thienTai();
            thienTai thienTai2 = new thienTai(id.getText(), loaithientai.getText(), tenrieng.getText(), khuvuc.getText(), thoigian.getText(), Integer.parseInt(mucdo.getText()));
            thienTaiDAO.getInstance().insert(thienTai2);
        }
    }
}