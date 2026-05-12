package eticaret;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class shoppingCart {

    static class Product {
        Product(String isim, double fiyat){
        String isim;
        double fiyat;
        this.isim=isim;
        this.fiyat=fiyat;
        }
    }

    private List<Product> urunler=new ArrayList<>();

    public void urunEkle(String isim,double fiyat) {
        urunler.add(new Product(isim,fiyat));
    }

    public void sepetiGoster() {
        System.out.println("\n--- SEPETTEKİ ÜRÜNLER ---");
        if (urunler.isEmpty()) {
            System.out.println("Sepetiniz boş!");
        } else {
            for (Product p : urunler) {
                System.out.println("- " + p.isim + ": " + p.fiyat + " TL");
            }
        }
    }

    public double toplamHesapla(String indirimTipi) {
        double toplam=0;
        for (Product p:urunler) {
            toplam+=p.fiyat;
        }

        if (indirimTipi.equalsIgnoreCase("YENI_UYE")) {
            return toplam * 0.90; // %10 indirim
        } else if (indirimTipi.equalsIgnoreCase("KUPON")) {
            return toplam - 50;   // Sabit indirim
        } else if (indirimTipi.equalsIgnoreCase("TOPLU_ALIM")) {
            if (toplam > 1000) {
                return toplam * 0.80; // %20 indirim
            }
        } else if (indirimTipi.equalsIgnoreCase("OGRENCI")) {
            return toplam * 0.85; // %15 indirim
        }
        
        return toplam;
    }

    public static void main(String[] args){
        shoppingCart sepet=new shoppingCart();
        Scanner scanner=new Scanner(System.in);
        
      
        while (true){
            System.out.println("\n--- E-TICARET SISTEMI ---");
            System.out.println("1. Ürün Ekle");
            System.out.println("2. Sepeti Listele");
            System.out.println("3. Ödeme Yap (İndirim Uygula)");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminiz: ");
            
            int secim=scanner.nextInt();
            
            if (secim==1) {
                System.out.print("Ürün Adı: ");
                String ad = scanner.next();
                System.out.print("Fiyat: ");
                double fiyat = scanner.nextDouble();
                sepet.urunEkle(ad, fiyat);
            } else if (secim==2) {
                sepet.sepetiGoster();
            } else if (secim==3) {
                System.out.print("İndirim Tipi (YENI_UYE, KUPON_50, TOPLU_ALIM, OGRENCI): ");
                String tip=scanner.next();
                double sonuc=sepet.toplamHesapla(tip);
                System.out.println("Ödenecek Toplam: "+sonuc+" TL");
            } else if (secim==4) {
                System.out.println("Sistemden çıkılıyor...");
                break;
            } else {
                System.out.println("Hatalı seçim!");
            }
        }
        scanner.close();
    }
}
