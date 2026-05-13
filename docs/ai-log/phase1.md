PROMPT:
Java ile geliştirdiğim bir alışveriş sepeti projesinde, farklı indirim türlerini hesaplamak için shoppingCart sınıfı içinde çok sayıda if-else bloğu kullanıyorum. Bu yapı Open-Closed prensibine aykırı. Bu karmaşıklığı Factory Method tasarım deseni ile nasıl çözebilirim? Kodumu nasıl daha modüler hale getirebileceğime dair bir kod incelemesi (code review) ve mimari öneri yapar mısın?



AI CEVABI: 
 shoppingCart sınıfının hem sepet yönetimi yapıp hem de indirim nesnesi üretmesinin Sorumlulukların Ayrılması (SRP) ilkesini ihlal ettiğini vurguladı.
Nesne yaratma mantığını IndirimFabrika adlı bir sınıfa taşımamı, tüm indirimleri ortak bir Discount arayüzü (interface) altında toplamamı önerdi.
 Polimorfizm kullanarak, ana kodun somut sınıflara değil, soyut bir arayüze bağımlı olması gerektiğini (Dependency Inversion) gösteren bir şablon sundu.
AI İngilizce isimlendirmeler (ApplyDiscount, DiscountFactory) önerdi; ancak ben projenin geri kalanındaki terminolojiyle uyumlu kalmak için IndirimUygula ve IndirimFabrika gibi Türkçe isimlendirmeler kullanarak kodu manuel olarak yazdım.
