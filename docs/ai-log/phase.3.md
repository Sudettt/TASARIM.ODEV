# FAZ-3: DAVRANIŞSAL ÖRÜNTÜLER VE AI ETKİLEŞİMİ
 Faz-3 aşamasına geçtiğimde öncelikle faz-2'de eksik olan kısımları (eklediğim bazı metotlar main kısmında çağrılmıyor, yani dekoratörler ve adaptör tam olarak işlevsel çalışmıyordu) fark ettim. AI desteğiyle bu metotları polimorfik yapıya uygun hale getirerek düzelttim.

1.soru : Strateji Örüntüsü Süreci: Soru: Mevcut shoppingCart sınıfındaki toplamHesapla metodunda indirimleri Factory ile çözüyoruz. Ancak ödeme işlemini (banka servisi, nakit vb.) nasıl yapacağımız hala belirsiz. Sence OdemeAdaptoru'nü doğrudan main içinde mi çağırmalıyım, yoksa yeni bir sınıf ile mi yönetmeliyim?

Çözüm: AI’ın önerisi ile OdemeAdaptoru’nü bir stratejiye (Strategy) dönüştürdük. Böylece hem Faz-2'deki adaptör boşa gitmedi hem de Faz-3’ün ilk kuralını yerine getirmiş oldum. Ancak AI, strateji seçimini toplamHesapla metodunun içine gömmeyi (hard-coded) önerdi. Bu noktada AI'nın beni yanılttığını fark ettim; çünkü bu durum Open-Closed prensibine aykırıydı. Eğer stratejiyi metodun içine yazsaydım, her yeni ödeme yönteminde sınıfa gidip kodu değiştirmem gerekecekti. Bu yüzden AI'nın önerisini esneterek, ödeme nesnesini shoppingCart'a dışarıdan (Dependency Injection ile) gönderen daha esnek bir odemeYap metodu kurguladım.

2. Strateji örüntüsünden sonra koduma uygun ikinci bir behavioral örüntü oluşturmasını istedim. AI şu öneriyi sundu: “SepetGozlemci adında bir interface yapalım. shoppingCart sınıfı bu gözlemcileri listesinde tutsun. Ürün eklendiğinde listedeki herkese haber uçursun.”
AI başta sadece basit bir mesaj loglamayı önerdi, fakat ben bunu geliştirerek ürün eklendiğinde hem lojistik birimine mesaj gitmesini hem de o anki güncel sepet tutarının gözlemciye iletilmesini sağlayan bir yapı tasarladım.

 3. AI Refleksiyonu :

AI'nın En Büyük Katkısı: GitHub Actions (CI) dosyasını oluştururken ve Java'daki ArrayList yönetimi gibi  tekrar eden kodlarda hız kazandırdı.

AI'nın Yanıltması: Kapsülleme kurallarını bazen unutması ve strateji seçimini sınıfın içine gömmeye çalışması oldu. Bu noktada "Open-Closed" prensibini hatırlayarak kodu manuel olarak revize ettim.

Zaman Kazancı: AI ile bu faz yaklaşık 2 saat sürdü. Kendi başıma 4+ saat süreceğini düşünüyorum.

