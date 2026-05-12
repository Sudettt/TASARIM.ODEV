  KODDAKİ HATA VE SORUNLAR :
  Kod içerisinde syntax (sözdizimi) hataları bulunmaktadır. 
  Tüm işlemlerin tek bir class altında yazılması kod okunabilirliğini zorlaştırmaktadır. 
  Kod yapısı karmaşık olduğu için anlaşılabilirlik azalmaktadır. 
  Koşulların if-else kullanılarak yazılması geliştirme sürecini zorlaştırmaktadır. 
  Yeni özellik eklemek mevcut yapıda zor hale gelmektedir. 
  Kod modüler bir yapıda yazılmamıştır. 
  Kullanıcıdan alınan veriler yeterince kontrollü işlenmemektedir. 
  Çok fazla işlemin aynı yerde yapılması kod düzenini olumsuz etkilemektedir.

  
  YAPAY ZEKA CEVABI : 
 

1. Single Responsibility Principle (SRP) İhlali
`shoppingCart` sınıfı çok fazla sorumluluğa sahiptir. Ürün verilerini tutma, indirim hesaplama ve kullanıcı ile etkileşime girme (System.out/Scanner) görevlerinin tamamı tek sınıftadır.

2. Open/Closed Principle (OCP) İhlali
Yeni bir indirim türü (örneğin: Mevsimlik İndirim) eklenmek istendiğinde, `toplamHesapla` metodunun içindeki `if-else` bloklarına müdahale edilmesi gerekmektedir. Kod gelişime kapalı, değişime açıktır (istenmeyen durum).

 3. Tight Coupling (Sıkı Bağlılık)
`Product` sınıfı, sepet sınıfının içinde `static inner class` olarak tanımlanmıştır. Bu durum ürünün bağımsız bir nesne olarak yönetimini zorlaştırmaktadır.

 4. Tip Güvenliği (Type Safety) Sorunu
İndirim türleri metin (String) karşılaştırması ile yapılmaktadır. Yazım hataları (YENI_UYE yerine YENI_UYEE) mantıksal hatalara yol açmaktadır.

 5. Esneklik Eksikliği
Sepetteki ürünleri listeleme veya farklı formatlarda faturalandırma gibi özellikler eklendiğinde, sınıfa sürekli yeni metodlar eklenerek "God Object" (Tanrı Nesne) oluşmasına neden olunmaktadır.