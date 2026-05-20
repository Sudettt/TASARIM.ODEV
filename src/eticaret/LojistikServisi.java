package eticaret;

public class LojistikServisi implements SepetGozlemci {
    @Override
    public void guncelle(String urunIsmi, double yeniToplam) {
        System.out.println("[LOJİSTİK] Haber alındı: " + urunIsmi + 
            " sepete eklendi.Güncel Sepet: " + yeniToplam + " TL");
    }
}