package TeamWorkProjects2.Project_10;

import java.util.*;

import static TeamWorkProjects2.Project_10.AnaMenu.BOLD;
import static TeamWorkProjects2.Project_10.AnaMenu.G;

public class Islemler implements IslemlerInterface {

    static Scanner scan = new Scanner(System.in);


    @Override
    public void urunTanimlama() {
        UrunTanimlama urun = new UrunTanimlama();
        System.out.println("Urun ismini giriniz: ");
        urun.setUrunIsmi(TryCatch.stringGirisi());
        System.out.println("Urun ureticisi giriniz: ");
        urun.setUretici(TryCatch.stringGirisi());
        System.out.println("Urun birimini giriniz: ");
        urun.setBirim(TryCatch.stringGirisi());
        int id = UrunTanimlama.id++;
        UrunTanimlama.urunListesiMap.put(id,urun);
        System.out.println("Urun basariyla tanimlandi");
    }
    @Override
    public void urunListele() {
        System.out.println(BOLD+G+"                  *** URUN LISTELEME SAYFASI ***                     ");
        System.out.printf(G+"%-15s %-15s %-15s %-15s %-15s\n", "ID", "Ürün", "Üretici", "Miktar", "Birim", "Raf");
        System.out.println("====================================================================================");
        Set<Integer> keySets = UrunTanimlama.urunListesiMap.keySet();
        Collection<UrunTanimlama> valueSet = UrunTanimlama.urunListesiMap.values();
        for (Integer each : keySets) {
            List<UrunTanimlama> valuesList = new ArrayList<>();
            valuesList = Collections.singletonList(UrunTanimlama.urunListesiMap.get(each));
            int index = 0;
            while (index < valuesList.size()) {
                System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", each, valuesList.get(index).getUrunIsmi(), valuesList.get(index).getUretici(),
                        valuesList.get(index).getMiktar(), valuesList.get(index).getBirim(), valuesList.get(index).getRaf());
                index++;
            }
        }
    }
    @Override
    public void urunGirisi() throws InterruptedException {
        System.out.println("Giris yapmak isteginiz urun Id'sini girin: ");
        int id = TryCatch.intGirisi();
        if (UrunTanimlama.urunListesiMap.containsKey(id)){
            urunGuncelDurum(id);
            Thread.sleep(2000);
            System.out.println("Urun miktarini giriniz: ");
            int miktar = TryCatch.intGirisi();
            int oldMiktar = UrunTanimlama.urunListesiMap.get(id).getMiktar();
            UrunTanimlama.urunListesiMap.get(id).setMiktar(oldMiktar+miktar);
            System.out.println("Id : "+id+" urun girisi : "+miktar+" toplam miktar: "+(oldMiktar+miktar));
            urunGuncelDurum(id);
        }else{
            System.out.println(id+ " id'ye sahip urun bulunamadi!\n"+
                               "Ana menuye yonlendiriliyorsunuz...");
            Thread.sleep(2000);
        }
    }
    @Override
    public void urunuRafaKoy() throws InterruptedException {
        System.out.println("Rafa koymak isteginiz urun Id'sini girin: ");
        int id = TryCatch.intGirisi();
        if (UrunTanimlama.urunListesiMap.containsKey(id)){
            urunGuncelDurum(id);
            Thread.sleep(2000);
            System.out.println("Raf bilgisini giriniz: ");
            UrunTanimlama.urunListesiMap.get(id).setRaf(TryCatch.stringGirisi());
            urunGuncelDurum(id);
        }else{
            System.out.println(id+ " id'ye sahip urun bulunamadi!\n"+
                    "Ana menuye yonlendiriliyorsunuz...");
            Thread.sleep(2000);
        }
    }
    @Override
    public void urunCikisi() throws InterruptedException {
        System.out.println("Cikis yapmak isteginiz urun Id'sini girin: ");
        int id = TryCatch.intGirisi();
        if (UrunTanimlama.urunListesiMap.containsKey(id)){
            urunGuncelDurum(id);
            Thread.sleep(2000);
            int oldMiktar = UrunTanimlama.urunListesiMap.get(id).getMiktar();
            System.out.println("Cikis yapilacak  urun miktarini giriniz: ");
            int miktar = TryCatch.intGirisi();
            if ( oldMiktar >= miktar){
                UrunTanimlama.urunListesiMap.get(id).setMiktar(oldMiktar-miktar);
                System.out.println("Id : "+id+" urun cikisi : "+miktar+" kalan miktar: "+(oldMiktar-miktar));
                urunGuncelDurum(id);
            }else{
                System.out.println("Depo da "+ miktar+" 'dan daha az urun bulunmaktadir");
                urunCikisi();
            }
        }else{
            System.out.println(id+ " id'ye sahip urun bulunamadi!\n"+
                               "Ana menuye yonlendiriliyorsunuz...");
            Thread.sleep(2000);
        }
    }

    @Override
    public void cikis() {

    }
    public void urunGuncelDurum(int id){
        //System.out.println(UrunTanimlama.urunListesiMap.get(id));
        UrunTanimlama obj = UrunTanimlama.urunListesiMap.get(id);
        System.out.println("** URUN GUNCEL DURUM **");
        System.out.printf("%15s %15s %15s %15s %15s\n", "ID", " Ürün", " Üretici", "Miktar", "Cuval", "Raf");
        System.out.println("====================================================================================");
        System.out.printf("%15s %15s %15s %15s %15s\n", id, obj.getUrunIsmi(), obj.getUretici(),
                        obj.getMiktar(), obj.getBirim(), obj.getRaf());
    }
}
