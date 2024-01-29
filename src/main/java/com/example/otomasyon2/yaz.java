package com.example.otomasyon2;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;

public class yaz extends app {

private String mesaj;
    @Override
    public void ekle() {

        System.out.println("Kitap istek listesine eklendi.");;
    }

    @Override
    public void ekle(String mesaj) {
        System.out.println("Kitap istek listesine eklendi.");
    }


}


