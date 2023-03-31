package pages;

import gherkin.lexer.Fi;

import java.lang.invoke.SwitchPoint;

public class CalculatorPage extends BasePage{

    private String numberButton= "//button[contains(text(),'NUM')]";
    private String sum= "//button[@id='add']";
    private String minus= "//button[@name='minus']";
    private String multiply= "//button[@class='Button Multiply']";
    private String division= "//button[contains(text(),'/')] ";
    private String equals = "//button[@name='equal']";
    private String display= "//input[@class='DisplayText']";
    private String delete = "//input[@id='delete']";


    public CalculatorPage(){
        super(driver);
    }

    public void navigateToCalculator() {
        navigateTo("http://localhost");
    }

    public void numberOption(String number){
        int length = number.length();
        if(length > 1){
            for (int i = 0; i < length; i++) {
                clickElement(replaceValue(numberButton, String.valueOf(number.charAt(i))));
            }

        }else{
            clickElement(replaceValue(numberButton,number));
        }

    }

    public void operatorOption(String operator){
        switch(operator) {
            case "+":
                clickElement(sum);
                break;
            case "-":
                clickElement(minus);
                break;
            case "*":
                clickElement(multiply);
                break;
            case "/":
                clickElement(division);
                break;
        }

    }

    public void getResult(String result){
        clickElement(equals);
        String resultCalculator = getText(display);
        if (resultCalculator.equals(result)) {
            System.out.println("Paso - El resultado de la calculadora es: "+resultCalculator+ " y el resultado esperado es: "+result+" ");
        }else{
            System.out.println("Fallo - El resultado de la calculadora es: "+resultCalculator+ " y el resultado esperado es: "+result+" ");
        }
        String lengthResult = getText(display);
        int length = lengthResult.length();
        if(length > 1){
            for (int i = 0; i < length; i++) {
                clickElement(delete);
            }
        }else{
            clickElement(delete);
        }

    }



}
