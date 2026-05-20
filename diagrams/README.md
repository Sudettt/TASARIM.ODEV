###  Mimari Tasarım Diyagramı (UML)

```mermaid
classDiagram
    class shoppingCart {
        -List~Product~ items
        -Discount discountStrategy
        +calculateTotal()
    }
    class Product {
        -String name
        -double price
        +getPrice()
    }
    class UrunDekorator {
        <<abstract>>
        -Product decoratedProduct
        +getPrice()
    }
    class HediyePaketi {
        +getPrice()
    }
    class Discount {
        <<interface>>
        +applyDiscount()
    }
    class KuponIndirimi {
        +applyDiscount()
    }
    class OdemeAdaptoru {
        -DisBankaServisi bankaServisi
        +odemeYap()
    }

    shoppingCart --> Product
    shoppingCart --> Discount
    UrunDekorator --|> Product
    HediyePaketi --|> UrunDekorator
    KuponIndirimi ..|> Discount
    OdemeAdaptoru --> DisBankaServisi
