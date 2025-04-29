
Feature: Verificar tipo de triángulo
  Como analista QA
  Quiero ejecutar una web
  Para validar el correcto funcionamiento de acuerdo a los criterios de aceptación

  @successful
  Scenario Outline: Triángulo equilátero

    Given que ingreso a la web del programa
    When coloco tres valores positivos en los campos "<sideA>", "<sideB>", "<sideC>" y un nombre "<username>"
    And doy clic en "Check"
    Then me indica que es "<desiredMessage>"

    Examples:
      | username | sideA | sideB | sideC | desiredMessage |
      | User     | 7     | 7     | 7     | equilateral    |

  @fail
  Scenario: No es un triángulo

    Given que ingreso a la web del programa
    When coloco tres valores positivos en los campos "12", "1", "15" y un nombre "User"
    And doy clic en "Check"
    Then me indica que es "Not a triangle"