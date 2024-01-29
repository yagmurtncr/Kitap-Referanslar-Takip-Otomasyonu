package com.example.otomasyon2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class page3 extends yaz {
    @FXML
    private ImageView Korluk;

    @FXML
    private ImageView bindokuzyuzseksendort;

    @FXML
    private ImageView hayvanciftligi;

    @FXML
    private ListView<String> ihtiyaclistesi;

    @FXML
    private ImageView momo;

    @FXML
    private ImageView muhtesemfatsby;
    @FXML
    private Button btnback;


    @FXML
    private ImageView otoport;

    @FXML
    private ImageView sekerport;

    @FXML
    private ImageView simyaci;
    @FXML
    private TextField isim;
    ArrayList<String> isteklist = new ArrayList<String>();
    @FXML
    void ekle(MouseEvent event) {
        //exception-handling
        try{
        ihtiyaclistesi.getItems().add( isim.getText());
        }catch(Exception e){
            System.out.println("String değer giriniz!");
        }
        finally {
            yaz yz= new yaz();
            yz.ekle();
            //arraylist örneği!

            for(int i=0; i<8; i++);
            isteklist.add(isim.getText());
            System.out.println("Eklenen kitaplar:"+isteklist);
        }
    }
    @FXML
    void cikar(MouseEvent event) {
        int selectId = ihtiyaclistesi.getSelectionModel().getSelectedIndex();
        ihtiyaclistesi.getItems().remove(selectId);
    }

    @FXML
    void backbtn(ActionEvent event) {
        try {
            Stage stage = (Stage) btnback.getScene().getWindow();
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
}


