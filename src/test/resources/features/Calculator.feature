Feature: Calculator Operations

  Scenario Outline: Operating numbers in the calculator
    Given I am in the calculator page
    When I want to <operator> the numbers <number1> and <number2>
    Then I get the <result>

    Examples:
      |operator|number1|number2|result|
      |"+"|"14"|"15"|"29"|
      |"-"|"0.2"|"0.5"|"-0.3"|
      |"/"|"1"|"1"|"1"|
      |"*"|"12345678901234500000"|"12345678901234500000"|"0"|
      |"+"|"1.4"|"15"|"209"|
      |"-"|"0.2"|"0.5"|"0.3"|
      |"/"|"1"|"1"|"0"|
      |"*"|"12345678901234500000"|"12345678901234500000"|"987654"|


