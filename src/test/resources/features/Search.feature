Feature: product search
  customer should be able to use product search

  Scenario Outline: Direct Hit Search
    Given Customer is on page with url 'home.page.url'
    When Customer performs search for '<direct hit term>'
    Then Customer is redirected to 'pdp page'
    And Page title contains '<direct hit term>'

    Examples:
    |direct hit term|
    |DeWalt DCD776D2T|
    |Evolution R210SMS 210mm|
