# Spring Santander Bootcamp
Java 17 | Spring Boot 3 | RESTful API

RESTful API simulating e-commerce

## Diagrame class

``` mermaid
classDiagram
  class Products {
    +id: integer
    +name: string
    +description: string
    +price: float
    +stock: integer
    +category: string
    +manufacturer: string
    +images: array
  }

  class CartItem {
    +productId: integer
    +quantity: integer
  }

  class Cart {
    +items: array(CartItem)
    +total: float
  }

  class Order {
    +id: integer
    +orderDate: string
    +status: string
    +items: array(CartItem)
    +total: float
  }

  Products -- CartItem : "Contains"
  Cart -- CartItem : "Consists of"
  CartItem -- Products : "References"
  Cart -- Products : "References"
  Order -- CartItem : "Contains"
  Order -- Cart : "References"
```
