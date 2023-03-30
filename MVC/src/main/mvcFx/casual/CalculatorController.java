package mvcFx.casual;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculatorController {
    private CalculatorModel theModel;

    @FXML
    private TextField firstField;

    @FXML
    private TextField resultField;

    @FXML
    private TextField secondField;

    public void setModel(CalculatorModel calculator) {
        this.theModel = calculator;
    }

    @FXML
    void clearBtnClicked(ActionEvent event) {
        firstField.setText("");
        secondField.setText("");
        resultField.setText("");
    }

    @FXML
    void divBtnClicked(ActionEvent event) {
        int firstNumber = Integer.parseInt(firstField.getText());
        int secondNumber = Integer.parseInt(secondField.getText());
        theModel.divideTwoNumbers(firstNumber, secondNumber);
        resultField.setText(theModel.getCalculationValue());
    }

    @FXML
    void divReBtnClicked(ActionEvent event) {
        int firstNumber = Integer.parseInt(firstField.getText());
        int secondNumber = Integer.parseInt(secondField.getText());
        theModel.divideReTwoNumbers(firstNumber, secondNumber);
        resultField.setText(theModel.getCalculationValue());
    }

    @FXML
    void multiplyBtnClicked(ActionEvent event) {
        int firstNumber = Integer.parseInt(firstField.getText());
        int secondNumber = Integer.parseInt(secondField.getText());
        theModel.multiplyTwoNumbers(firstNumber, secondNumber);
        resultField.setText(theModel.getCalculationValue());
    }

    @FXML
    void plusBtnClicked(ActionEvent event) {
        int firstNumber = Integer.parseInt(firstField.getText());
        int secondNumber = Integer.parseInt(secondField.getText());
        theModel.addTwoNumbers(firstNumber, secondNumber);
        resultField.setText(theModel.getCalculationValue());
    }

    @FXML
    void subBtnClicked(ActionEvent event) {
        int firstNumber = Integer.parseInt(firstField.getText());
        int secondNumber = Integer.parseInt(secondField.getText());
        theModel.substractTwoNumbers(firstNumber, secondNumber);
        resultField.setText(theModel.getCalculationValue());
    }

}
