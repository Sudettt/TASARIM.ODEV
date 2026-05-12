
package eticaret;

public class IndirimFabrika {
public static Discount indirimGetir(String tip) {
    if (tip == null) return null;

    if (tip.equalsIgnoreCase("OGRENCI")) {
        return new OgrenciIndirimi();
    } else if (tip.equalsIgnoreCase("YENI_UYE")) {
        return new YeniUyeIndirimi();
    } else if (tip.equalsIgnoreCase("KUPON")) {
        return new KuponIndirimi();
    } else if (tip.equalsIgnoreCase("TOPLU_ALIM")) {
        return new TopluAlimIndirimi();
    }
    
    return null;
}
}