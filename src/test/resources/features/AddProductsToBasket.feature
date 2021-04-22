Feature: Adding products to basket
  As a: Customer
  I want: to add products to basket
  So that: I can fill my order with products
  
  Scenario: Adding few products
    Given Customer is on page with url 'home.page.url'
    When Customer adds multiple products from search
    |direct hit search term    |shipping method              |
    |default.product.short.name|shipping.method.home.delivery|
    |complex.product.sku       |shipping.method.home.delivery|
    Then Products should be present on basket page
    |product name        |
    |default.product.name|
    |complex.product.name|