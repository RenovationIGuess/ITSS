package mvcFx.casual;
// The Model performs all the calculations needed
// and that is it. It doesn't know the View
// exists

public class CalculatorModel {

    // Holds the value of the sum of the numbers
    // entered in the view

    private String calculationValue;

    public void addTwoNumbers(int firstNumber, int secondNumber){

        calculationValue = "" + (firstNumber + secondNumber);

    }

    public void substractTwoNumbers(int firstNumber, int secondNumber){

        calculationValue = "" + (firstNumber - secondNumber);

    }

    public void multiplyTwoNumbers(int firstNumber, int secondNumber){

        calculationValue = "" + (firstNumber * secondNumber);

    }

    public void divideTwoNumbers(int firstNumber, int secondNumber){

        calculationValue = "" + ((double)firstNumber / secondNumber);

    }

    public void divideReTwoNumbers(int firstNumber, int secondNumber){

        calculationValue = "" + (firstNumber % secondNumber);

    }

    public String getCalculationValue(){

        return calculationValue;

    }

}