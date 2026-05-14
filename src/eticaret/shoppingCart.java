package eticaret;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class shoppingCart {

    private List<Product> urunler = new ArrayList<>();
    private List<SepetGozlemci> gozlemciler = new ArrayList<>();

    public void gozlemciEkle(SepetGozlemci gozlemci) {
        gozlemciler.add(gozlemci);
    }

    private void haberVer(String urunIsmi) {
        double toplam = 0;
        for (Product p : urunler) {
            toplam += p.getPrice();
        }

        for (SepetGozlemci g : gozlemciler) {
            g.guncelle(urunIsmi, toplam);
        }
    }

    public void urunEkle(String isim, double fiyat) {
        
        urunler.add(new Product(isim, fiyat));
        haberVer(isim);
    }
    
    public void urunEkle(Product p) {
        urunler.add(p);
        haberVer(p.getName());
    }

    public void sepetiGoster() {
        System.out.println("\n--- SEPETTEKİ ÜRÜNLER ---");
        if (urunler.isEmpty()) {
            System.out.println("Sepetiniz boş!");
        } else {
            for (Product p : urunler) {
                
                System.out.println("- " + p.getName() + ": " + p.getPrice() + " TL");
            }
        }
    }

    public double toplamHesapla(String indirimTipi) {
        double toplam = 0;
        for (Product p : urunler) {
            toplam += p.getPrice();
        }

        Discount indirim = IndirimFabrika.indirimGetir(indirimTipi);
        if (indirim != null) {
            return indirim.IndirimUygula(toplam);
        }
        return toplam;
    }

    public void odemeYap(OdemeStratejisi strateji, String indirimTipi) {
        double finalTutar = toplamHesapla(indirimTipi);
        System.out.println("Ödeme işlemi başlatılıyor...");
        strateji.ode(finalTutar);
    }

    public static void main(String[] args) {
        shoppingCart sepet = new shoppingCart();
        Scanner scanner = new Scanner(System.in);

        sepet.gozlemciEkle(new LojistikServisi());

        while (true) {
            System.out.println("\n--- E-TICARET SISTEMI ---");
            System.out.println("1. Ürün Ekle");
            System.out.println("2. Sepeti Listele");
            System.out.println("3. Ödeme Yap (İndirim Uygula)");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();

            if (secim == 1) {
                System.out.print("Ürün Adı: ");
                String ad = scanner.next();
                System.out.print("Fiyat: ");
                double fiyat = scanner.nextDouble();

                Product p = new Product(ad, fiyat);

                System.out.print("Hediye paketi (20 TL) ister misiniz? (E/H): ");
                String cevap = scanner.next();
                if (cevap.equalsIgnoreCase("E")) {
                    p = new HediyePaketi(p); 
                }

                sepet.urunEkle(p); 
                System.out.println(p.getName() + " sepete eklendi.");
            } 
            
            else if (secim == 2) {
                sepet.sepetiGoster();
            } else if (secim == 3) {
                System.out.print("İndirim Tipi (YENI_UYE, KUPON, TOPLU_ALIM, OGRENCI): ");
                String tip = scanner.next();

                System.out.println("Ödeme Yöntemi Seçin: 1- Banka (Adapter), 2- Nakit");
                int odemeSecimi = scanner.nextInt();

                OdemeStratejisi strateji;
                if (odemeSecimi == 1) {
                    strateji = new BankaOdemeStratejisi();
                } else {
                    strateji = new NakitOdemeStratejisi();
                }

                sepet.odemeYap(strateji, tip);
            } else if (secim == 4) {
                System.out.println("Sistemden çıkılıyor...");
                break;
            } else {
                System.out.println("Hatalı seçim!");
            }
        }
        scanner.close();
    }
}