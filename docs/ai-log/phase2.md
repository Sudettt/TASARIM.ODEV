(Faz 2'de Structural örüntüler olan Adapter ve Decorator uygulandı)
# Faz 2: Mimari Karar ve AI Etkileşim Raporu
 
 AI ‘a Sorulan Soru : Neden Adapter , Facade kullanmaktan daha uygun?

Adapter: İki farklı arayüz (Interface) arasındaki "uyumsuzluğu" gidermek için kullanılır. Mevcut bir sınıfın metodlarını, sistemin beklediği metod isimlerine dönüştürür. (Örneğin: tahsilatGerceklestir() metodunu ode() metoduna bağlamak)

Facade: Bir sistemin "karmaşıklığını" gizlemek için kullanılır. Arkada çalışan onlarca sınıfı ve karmaşık işlem sırasını (Örn: Stok kontrolü -> Ödeme -> Kargo oluşturma -> SMS atma) tek bir basit metod arkasında toplar.

 TERCİH ETTİĞİM: Benim projemde DisBankaServisi tek bir sınıftı ve asıl sorun karmaşıklık değil, metod isimlerinin sistemle uyuşmamasıydı. Eğer banka servisi birden fazla farklı sınıftan oluşsaydı ve her biriyle ayrı ayrı uğraşmamız gerekseydi Facade tercih edilirdi.Fakatsadece var olan bir yapıyı kendi sistemimize tercüme etmek istediğim için “Adapter”tercih ettim.


AI'ın Önerisi: "Product sınıfını interface yap, Decorator'ı öyle kurgula."

# Neden Reddettim? 

Eğer AI'ın önerisine göre yapsaydım:
Faz 1'deki UrunFabrikası (Factory) bozulacaktı çünkü artık somut bir sınıftan nesne üretemeyecekti.Product sınıfındaki mevcut değişkenler (fiyat,isim) interface içinde duramazdı. Bunları her bir alt sınıfa tekrar yazmam gerekecekti.Proje ilerledikçe interface kullanımı mantıklı olabilir ama belirtilen"mevcut kodu kırmadan özellik ekle" kuralına göre, sınıf kalıtımı (Class Inheritance) kullanmak çok daha güvenli ve hızlı bir çözümdür.
SONUC OLARAK AI'ın önerisini düzelterek, UrunDekorator sınıfını Product sınıfından extends alacak şekilde kurguladım. Bu sayede projenin sürdürülebilirliğini koruyarak Faz 2 hedeflerine ulaştım.
