package com.example.otomasyon2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class main extends Application {

    @Override
    public void start(Stage stage)  {

        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("LoggedIn.fxml"));
        Scene scene = null;
        try {
            //scene = new Scene(fxmlLoader.load(), 360, 270);
            scene = new Scene(fxmlLoader.load(),810,500);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Book References Tracking Automation");
        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.show();
    }


}
