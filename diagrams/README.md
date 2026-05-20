### Mimari Tasarım Tasarımı (UML Sınıf Diyagramı)

```mermaid
classDiagram
    class shoppingCart {
        -List~Product~ urunler
        -List~SepetGozlemci~ gozlemciler
        +gozlemciEkle(SepetGozlemci gozlemci)
        -haberVer(String urunIsmi)
        +urunEkle(Product p)
        +sepetiGoster()
        +toplamHesapla(String indirimTipi) double
        +odemeYap(OdemeStratejisi strateji, String indirimTipi)
    }

    class Product {
        +String isim
        +double fiyat
        +getPrice() double
        +getName() String
        +setPrice(double fiyat)
    }

    class UrunDekorator {
        <<abstract>>
        #Product dekoreEdilenUrun
        +getPrice() double
        +getName() String
    }

    class HediyePaketi {
        +getPrice() double
        +getName() String
    }

    class Discount {
        <<interface>>
        +IndirimUygula(double miktar) double
    }

    class KuponIndirimi {
        +IndirimUygula(double miktar) double
    }
    class OgrenciIndirimi {
        +IndirimUygula(double miktar) double
    }
    class YeniUyeIndirimi {
        +IndirimUygula(double miktar) double
    }
    class TopluAlimIndirimi {
        +IndirimUygula(double miktar) double
    }

    class IndirimFabrika {
        +indirimGetir(String tip) Discount
    }

    class OdemeStratejisi {
        <<interface>>
        +ode(double miktar)
    }
    class BankaOdemeStratejisi {
        -OdemeAdaptoru adaptor
        +ode(double miktar)
    }
    class NakitOdemeStratejisi {
        +ode(double miktar)
    }

    class OdemeAdaptoru {
        -DisBankaServisi bankaServisi
        +ode(double miktar)
    }
    class DisBankaServisi {
        +tahsilatGerceklestir(double miktar)
    }

    class SepetGozlemci {
        <<interface>>
        +guncelle(String urunIsmi, double yeniToplam)
    }
    class LojistikServisi {
        +guncelle(String urunIsmi, double yeniToplam)
    }

    %% İlişkiler ve Bağlantılar
    shoppingCart --> Product : "tutur"
    shoppingCart --> SepetGozlemci : "gözlemler"
    shoppingCart ..> IndirimFabrika : "kullanır"
    shoppingCart ..> OdemeStratejisi : "kullanır"

    UrunDekorator --|> Product : "miras alır"
    UrunDekorator --> Product : "sarmalar"
    HediyePaketi --|> UrunDekorator : "türer"

    KuponIndirimi ..|> Discount : "uygular"
    OgrenciIndirimi ..|> Discount : "uygular"
    YeniUyeIndirimi ..|> Discount : "uygular"
    TopluAlimIndirimi ..|> Discount : "uygular"
    IndirimFabrika ..> Discount : "üretir"

    BankaOdemeStratejisi ..|> OdemeStratejisi : "uygular"
    NakitOdemeStratejisi ..|> OdemeStratejisi : "uygular"
    BankaOdemeStratejisi --> OdemeAdaptoru : "kullanır"
    OdemeAdaptoru --> DisBankaServisi : "adapte eder"

    LojistikServisi ..|> SepetGozlemci : "uygular"
