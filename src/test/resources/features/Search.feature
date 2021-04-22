Feature: product search
  customer should be able to use product search

  Scenario Outline: Direct Hit Search
    Given Customer is on page with url 'home.page.url'
    When Customer performs search for '<direct hit term>'
    Then Page title contains '<direct product name>'
    And Product page contains '<direct product name>'

    Examples:
    |     direct hit term       |direct product name|
    |default.product.short.name|default.product.name|
    |complex.product.sku        |complex.product.name|
