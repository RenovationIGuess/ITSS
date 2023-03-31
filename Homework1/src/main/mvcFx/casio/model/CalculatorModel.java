package mvcFx.casio.model;

public class CalculatorModel {
    private int calculationValue;

    public void addTwoNumbers(int firstNumber, int secondNumber){
        calculationValue = firstNumber + secondNumber;
    }

    public void subtractTwoNumbers(int firstNumber, int secondNumber) {
        calculationValue = firstNumber - secondNumber;
    }

    public void divideTwoNumbers(int firstNumber, int secondNumber) {
//        calculationValue = (double)firstNumber / secondNumber;
    }

    public void multiplyTwoNumbers(int firstNumber, int secondNumber) {
        calculationValue = firstNumber * secondNumber;
    }

    public int getCalculationValue(){

        return calculationValue;

    }
}
