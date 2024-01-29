package com.example.otomasyon2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static com.example.otomasyon2.Kitap.kitaplistesi;

public class page2 extends yaz implements Initializable  {

    @FXML
    private ChoiceBox<String> SayfaSayisi;

    @FXML
    private ChoiceBox<String> Yazar;

    @FXML
    private ChoiceBox<String> KitapTuru;
    @FXML
    private Button yenikitapla;
    @FXML
    private TextArea txtfieldreferans;

    @FXML
    private Text txtkitapreferanslari;

    @FXML
    private Text txtkitapturu;

    @FXML
    private Text txtsayfasayisi;

    @FXML
    private Text txtyazar;

    @FXML
    TilePane Bookshelf;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Kitap.KitaplariYukle();

        for (Kitap kitap : kitaplistesi)
        {
            Bookshelf.getChildren().add(kitapkapagigetir(kitap));

        }

        comboboxyukle();

    }

    @FXML
    void gir(MouseEvent event) throws IOException {
        Stage stage= (Stage)yenikitapla.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("hello-view3.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),810,500);
        stage.setTitle("Book References Tracking Automation");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }


    @FXML
    void btnkitapturu(MouseEvent event) {
        String tur = getKitapTuru().getSelectionModel().getSelectedItem();
        Bookshelf.getChildren().clear();
        for (Kitap kitap : kitaplistesi)
        {
            if (kitap.tur.equals(tur))
            {
                Bookshelf.getChildren().add(kitapkapagigetir(kitap));
            }
        }


    }


    @FXML
    void btnsayfasayisi(MouseEvent event){
        String sayfa = getSayfaSayisi().getSelectionModel().getSelectedItem();

        Bookshelf.getChildren().clear();
        for (Kitap kitap : kitaplistesi)
        {
            if (kitap.sayfasayisi.equals(sayfa))
            {
                Bookshelf.getChildren().add(kitapkapagigetir(kitap));
            }
        }

    }

    @FXML
    void btnyazar(MouseEvent event) {
        String yaz = getYazar().getSelectionModel().getSelectedItem();

        Bookshelf.getChildren().clear();
        for (Kitap kitap : kitaplistesi)
        {
            if (kitap.yazar.equals(yaz))
            {
                Bookshelf.getChildren().add(kitapkapagigetir(kitap));
            }
        }
    }


    @FXML
    void sec(MouseEvent event) {

        String tur = getKitapTuru().getSelectionModel().getSelectedItem();
        String sayfa = getSayfaSayisi().getSelectionModel().getSelectedItem();
        String yaz = getYazar().getSelectionModel().getSelectedItem();

        ArrayList<Kitap> filtrelenmisKitaplar = kitaplistesi;

        if (tur != null && !tur.equals("---Tümü---"))
        {
            filtrelenmisKitaplar = (ArrayList<Kitap>) filtrelenmisKitaplar.stream()
                    .filter(k-> k.tur.equals(tur))
                    .collect(Collectors.toList());
        }


        if (sayfa != null && !sayfa.equals("---Tümü---"))
        {
            filtrelenmisKitaplar = (ArrayList<Kitap>) filtrelenmisKitaplar.stream()
                    .filter(k-> k.sayfasayisi.equals(sayfa))
                    .collect(Collectors.toList());
        }

        if (yaz != null && !yaz.equals("---Tümü---"))
        {
            filtrelenmisKitaplar = (ArrayList<Kitap>) filtrelenmisKitaplar.stream()
                    .filter(k-> k.yazar.equals(yaz))
                    .collect(Collectors.toList());
        }


        Bookshelf.getChildren().clear();
        for (Kitap kitap : filtrelenmisKitaplar)
        {
            Bookshelf.getChildren().add(kitapkapagigetir(kitap));
        }
        StringBuilder kitapBilgileri = new StringBuilder();

// kitap referanslarını yazdırma kısmı:

        txtfieldreferans.clear();
        for (Kitap kitap : filtrelenmisKitaplar) {
            kitapBilgileri.append("Kitap Adı: ").append(kitap.ad).append("\n");
            kitapBilgileri.append("Yazar: ").append(kitap.yazar).append("\n");
            kitapBilgileri.append("Çevirmen: ").append(kitap.cevirmen).append("\n");
            kitapBilgileri.append("Tür: ").append(kitap.tur).append("\n");
            kitapBilgileri.append("Sayfa Sayısı: ").append(kitap.sayfasayisi).append("\n");
            kitapBilgileri.append("Barkod: ").append(kitap.barkod).append("\n\n");
        }

        txtfieldreferans.setText(kitapBilgileri.toString());
    }




    public void comboboxyukle()
    {
        getYazar().getItems().add("---Tümü---");
        getKitapTuru().getItems().add("---Tümü---");
        getSayfaSayisi().getItems().add("---Tümü---");

        for (Kitap kitap : kitaplistesi)
        {
            if (getYazar().getItems().stream().noneMatch(y->y.equals(kitap.yazar)))
            {
                getYazar().getItems().add(kitap.yazar);
            }
            if (getKitapTuru().getItems().stream().noneMatch(y->y.equals(kitap.tur)))
            {
                getKitapTuru().getItems().add(kitap.tur);
            }
            if (getSayfaSayisi().getItems().stream().noneMatch(y->y.equals(kitap.sayfasayisi)))
            {
                getSayfaSayisi().getItems().add(kitap.sayfasayisi);
            }
        }


    }

    public ImageView kitapkapagigetir(Kitap kitap)
    {
        ImageView imageView = new ImageView(kitap.kapakresmi);
        imageView.setFitWidth(110);
        imageView.setFitHeight(180);
        return imageView;
    }

    //encapsulation (getter-setter)
    public ChoiceBox<String> getSayfaSayisi() {
        return SayfaSayisi;
    }

    public void setSayfaSayisi(ChoiceBox<String> sayfaSayisi) {
        SayfaSayisi = sayfaSayisi;
    }

    public ChoiceBox<String> getYazar() {
        return Yazar;
    }

    public void setYazar(ChoiceBox<String> yazar) {
        Yazar = yazar;
    }

    public ChoiceBox<String> getKitapTuru() {
        return KitapTuru;
    }

    public void setKitapTuru(ChoiceBox<String> kitapTuru) {
        KitapTuru = kitapTuru;
    }
}


