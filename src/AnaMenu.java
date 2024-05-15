package TeamWorkProjects2.Project_10;

import java.util.Scanner;

public class AnaMenu {
    static Scanner scan = new Scanner(System.in);
    public static final String BOLD = "\033[0;1m";
    public static final String W = "\u001B[37m";
    public static final String R = "\u001B[31m";
    public static final String G = "\u001B[32m";
    public static final String Y = "\u001B[33m";
    public static final String B = "\u001B[34m";

    public void giris() throws InterruptedException {
        System.out.println(BOLD +G + "***  İŞLEMLER  ***\r\n"
                           + "1- URUN TANIMLAMA\n"
                           + "2- URUN LİSTELE\n"
                           + "3- URUN GIRISI\n"
                           + "4- URUN RAFA KOY\n"
                           + "5- URUN CIKISI\n"
                           + "6- CIKIS");
        System.out.print(R+"Seciminizi giriniz : ");
        int secim = TryCatch.intGirisi();
        Islemler obj = new Islemler();
        switch (secim) {
            case 1:
                obj.urunTanimlama();
                giris();
                break;
            case 3:
                obj.urunGirisi();
                giris();
                break;
            case 4:
                obj.urunuRafaKoy();
                giris();
                break;
            case 5:
                obj.urunCikisi();
                giris();
                break;
            case 2:
                obj.urunListele();
                giris();
                break;
            case 6:
                obj.cikis();
                break;
            default:
                System.out.println("Lütfen geçerli bir değer giriniz!"+B);
                break;
        }

    }

}