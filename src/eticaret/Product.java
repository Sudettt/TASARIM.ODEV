package eticaret;

public class Product {
       public String isim;
       public double fiyat;
       public Product(String isim, double fiyat){
            this.isim=isim;
            this.fiyat=fiyat;
        }
       public double getPrice() { return fiyat; }
       public String getName() { return isim; }
    }

