package TeamWorkProjects2.Project_10;

import java.util.HashMap;
import java.util.Map;

public class UrunTanimlama {
    static int id=1000;
    private String urunIsmi;
    private String uretici;
    private int miktar;
    private String birim;
    private String raf;

    static Map<Integer,UrunTanimlama> urunListesiMap=new HashMap<>();

    public UrunTanimlama() {
    }

//    public UrunTanimlama(String urunIsmi, String uretici, int miktar, String birim, String raf) {
//        this.urunIsmi = urunIsmi;
//        this.uretici = uretici;
//        this.miktar = miktar;
//        this.birim = birim;
//        this.raf = raf;
//    }

//    public static int getId() {
//        return id;
//    }

//    public static void setId(int id) {
//        UrunTanimlama.id = id;
//    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public String getUretici() {
        return uretici;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    @Override
    public String toString() {
        return
               "\t\t" + urunIsmi +
               "\t\t" + uretici +
               "\t\t" + miktar +
               "\t\t" + birim +
               "\t\t" + raf+"\n";
    }
}
