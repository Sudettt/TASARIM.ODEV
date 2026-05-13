package eticaret;

 class HediyePaketi extends UrunDekorator {
    public HediyePaketi(Product urun) {
        super(urun);
    }

    @Override
    public double fiyatHesapla() {
        return dekoreEdilenUrun.fiyat+20.0;//20 tl paket ücreti
    }

    @Override
    public String adGetir() {
        return dekoreEdilenUrun.isim + " (Hediye Paketli)";
    }
}