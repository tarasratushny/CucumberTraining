Feature: product search
  customer should be able to use product search

  Scenario Outline: Direct Hit Search
    Given Customer is on page with url 'home.page.url'
    When Customer performs search for '<direct hit term>'
    Then Page title contains '<direct hit product name>'
    And Product name on product page contains '<direct hit product name>'
    And Sku on product page is '<direct hit product sku>'

    Examples:
    |     direct hit term       |direct hit product name|direct hit product sku|
    |default.product.short.name |default.product.name   |default.product.sku   |
    |complex.product.sku        |complex.product.name   |complex.product.sku   |
