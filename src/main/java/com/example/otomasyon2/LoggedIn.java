package com.example.otomasyon2;

import javafx.event.ActionEvent;
import javafx.event.WeakEventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoggedIn  {

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_sign_up;

    @FXML
    private PasswordField txtfpassword;

    @FXML
    private TextField txtfusername;

    @FXML
    private Text txtpassword;

    @FXML
    private Text txtuser;

    @FXML
    private Text txtusername;

    @FXML
    void loginact(ActionEvent event) {

        if(txtfusername.getText().isBlank()==false && txtfpassword.getText().isBlank()==false){
            txtuser.setText("You try to login!");
            validateLogin();
        }else{
            txtuser.setText("Please enter username and password");
        }
    }
    public void validateLogin(){
        Methods connectNow = new Methods();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin ="SELECT count(1) FROM UserAccounts WHERE username = '"+txtfusername.getText()+"'AND password ='"+txtfpassword.getText()+"'";

    try{
        Statement statement = connectDB.createStatement();
        ResultSet queryResult = statement.executeQuery(verifyLogin);

        while(queryResult.next()){
            if(queryResult.getInt(1)==1){
                txtuser.setText("Welcome!");

                try {
                    Stage stage = (Stage) btn_login.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view2.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 810, 500);
                    stage.setTitle("Book References Tracking Automation");
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.setFullScreen(false);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                txtuser.setText("Invalid Login. Please try again.");
            }
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    }
    @FXML
    void signupact(ActionEvent event) {

        try {
            Stage stage = (Stage) btn_sign_up.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 810, 500);
            stage.setTitle("Book References Tracking Automation");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setFullScreen(false);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
