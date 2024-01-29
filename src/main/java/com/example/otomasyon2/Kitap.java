package com.example.otomasyon2;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Objects;

public class Kitap
{
    public String ad;
    public String yazar;
    public String kapakresmi;
    public String tur;
    public String sayfasayisi;
    public String barkod;
    public String cevirmen;
    public static ArrayList<Kitap> kitaplistesi = new ArrayList<>();

    public Kitap(String ad, String yazar,String cevirmen, String kapakresmi, String sayfasayisi, String tur,String barkod)
    {
        this.ad = ad;
        this.yazar = yazar;
        this.cevirmen=cevirmen;
        this.kapakresmi = kapakresmi;
        this.sayfasayisi = sayfasayisi;
        this.tur = tur;
        this.barkod=barkod;
    }

    public static ArrayList<Kitap> kitapadara(String ad)
    {
        list.clear();
        for (Kitap kitap : kitaplistesi)
        {
            if (kitap.ad.equals(ad)) list.add(kitap);
        }
        return list;
    }

    static ArrayList<Kitap> list = new ArrayList<>();

    public static ArrayList<Kitap> kitapturara(String tur)
    {
        list.clear();
        for (Kitap kitap : kitaplistesi)
        {
            if (kitap.tur.equals(tur)) list.add(kitap);
        }
        return list;
    }

    public static ArrayList<Kitap> kitapyazarara(String yazar)
    {
        list.clear();
        for (Kitap kitap : kitaplistesi)
        {
            if (kitap.yazar.equals(yazar)) list.add(kitap);
        }
        return list;
    }

    public static ArrayList<Kitap> listedeSayfaAra(ArrayList<Kitap> liste, String sayfa)
    {
        list.clear();
        for (Kitap kitap : liste)
        {
            if (Objects.equals(kitap.sayfasayisi, sayfa)) list.add(kitap);
        }
        return list;
    }

    public static void KitaplariYukle()
    {
        kitaplistesi.clear();
        kitaplistesi.add(new Kitap("Öğrenci Kız", "Osamu Dazai","İrem Akçayır", "com/example/otomasyon2/Görseller_java otomasyon/ÖğrenciKız.jpg", "0-100", "Fantastik","9786258401462"));
        kitaplistesi.add(new Kitap("Batan Güneş", "Agatha Christie","M. Sinan Dündar", "com/example/otomasyon2/Görseller_java otomasyon/BatanGüneş.jpg", "100-200", "Fantastik","9786052652008"));
        kitaplistesi.add(new Kitap("İnsanlığımı Yitirirken","Osamu Dazai", "Peren Ercan", "com/example/otomasyon2/Görseller_java otomasyon/İnsanlığımıYitirirken.jpg", "100-200", "Fantastik","9786258401479"));
        kitaplistesi.add(new Kitap("Pandoranın Kutusu", "Osamu Dazai", "Burhan Reyhani","com/example/otomasyon2/Görseller_java otomasyon/PandoranınKutusu.jpg", "100-200", "Fantastik","9789752126111"));
        kitaplistesi.add(new Kitap("On Kişiydiler", "Agatha Christie", "Çiğdem Öztekin","com/example/otomasyon2/Görseller_java otomasyon/OnKişiydiler.jpg", "200-300", "Suç ve Gizem","9789752126169"));
        kitaplistesi.add(new Kitap("Örümcek Ağı", "Agatha Christie", "Çiğdem Öztekin","com/example/otomasyon2/Görseller_java otomasyon/ÖrümcekAğı.jpg", "100-200", "Suç ve Gizem","9789752124165"));
        kitaplistesi.add(new Kitap("Fahrenheit 451", "Ray Bradbury", "Dost Körpe","com/example/otomasyon2/Görseller_java otomasyon/Fahrenheit451.jpg", "200-300", "Bilim Kurgu","9786053757818"));
        kitaplistesi.add(new Kitap("Doğu Ekspresinde Cinayet", "Agatha Christie", "Çiğdem Öztekin","com/example/otomasyon2/Görseller_java otomasyon/DoğuEkspresindeCinayet.jpg", "200-300", "Suç ve Gizem","9789754050943"));
        kitaplistesi.add(new Kitap("Güneşin Altın Elmaları", "Ray Bradbury", "Mehmet Moralı","com/example/otomasyon2/Görseller_java otomasyon/GüneşinAltınElmaları.jpg", "300-400", "Bilim Kurgu","9786052650950"));
        kitaplistesi.add(new Kitap("Mars Yıllıkları", "Ray Bradbury", "Barış E. Alkım","com/example/otomasyon2/Görseller_java otomasyon/MarsYıllıkları.jpg", "300-400", "Bilim Kurgu","9786053758433"));}
}
