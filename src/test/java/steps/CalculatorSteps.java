package steps;

import io.cucumber.java.en.*;
import pages.CalculatorPage;

public class CalculatorSteps {

    CalculatorPage calculator =  new CalculatorPage();
    @Given("I am in the calculator page")
    public void navigateToCalculatorPage() {
        calculator.navigateToCalculator();
    }
    @When("I want to {string} the numbers {string} and {string}")
    public void sendNumbers(String operator, String number1, String number2) {
        calculator.numberOption(number1);
        calculator.operatorOption(operator);
        calculator.numberOption(number2);
    }
    @Then("I get the {string}")
    public void finalResult(String result) {
        calculator.getResult(result);
    }


}
