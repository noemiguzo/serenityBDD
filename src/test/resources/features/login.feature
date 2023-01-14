Feature: Funcionalidad login
  Rule: Yo como usuario quiero login Healthcare  web page

    Background: Ingresar a Healthcare login
      Given el usuario ingresar a make appointment page

    @regression-negative
    Scenario Outline: Validar login page
      When ingresar login datos <user>, <password>
      Then validate login failed
      Examples:
        | user         | password |
        | John Doe    | failPassword      |
        | Johnfail    | ThisIsNotAPassword   |

