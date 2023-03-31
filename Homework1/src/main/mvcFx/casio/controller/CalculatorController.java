package mvcFx.casio.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    private String previousNumber = "";

    private String currentNumber = "";

    private String currentResult = "";

    private String previousResult = "";

    private String calculationType = "";

    private String previousCalType = "";

    private String fullEquation = "";

//    @FXML
//    private Button acBtn;

    @FXML
    private Button addBtn;

    @FXML
    private Button delBtn;

    @FXML
    private TextField dispField;

    @FXML
    private Button divBtn;

    @FXML
    private Button eightBtn;

    @FXML
    private Button equalBtn;

    @FXML
    private Button fiveBtn;

    @FXML
    private Button fourBtn;

    @FXML
    private Button multBtn;

    @FXML
    private Button nineBtn;

    @FXML
    private Button oneBtn;

    @FXML
    private TextField resultField;

    @FXML
    private Button sevenBtn;

    @FXML
    private Button sixBtn;

    @FXML
    private Button subBtn;

    @FXML
    private Button threeBtn;

    @FXML
    private Button twoBtn;

    @FXML
    private Button zeroBtn;

    @FXML
    private Button closeParamBtn;

    @FXML
    private Button dotBtn;

    @FXML
    private Button openParamBtn;

    @FXML
    void onAcBtnClicked(ActionEvent event) {
        currentNumber = "";
        previousNumber = "";
        fullEquation = "";
        currentResult = "";
        previousResult = "";
        calculationType = "";
        previousCalType = "";
        dispField.setText("");
        resultField.setText("");
        enableAllBtn();
    }

    @FXML
    void onDotBtnClicked(ActionEvent event) {
        addNumber(".");
    }

    @FXML
    void onAddBtnClicked(ActionEvent event) {
        calculationSetup("+");
    }

    @FXML
    void onDelBtnClicked(ActionEvent event) {
        int equationLength = fullEquation.length();
        if (equationLength > 0) {
            char lastChar = fullEquation.charAt(equationLength - 1);
            if (checkCalType(lastChar)) {
                calculationType = previousCalType;
                currentNumber = previousNumber;
                currentResult = previousResult;
            } else {
                currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
            }
            fullEquation = fullEquation.substring(0, equationLength - 1);
            updateTextField();
        }
    }

    @FXML
    void onDivBtnClicked(ActionEvent event) {
        calculationSetup("/");
    }

    @FXML
    void onEightBtnClicked(ActionEvent event) {
        addNumber("8");
    }

    @FXML
    void onEqualBtnClicked(ActionEvent event) {
//        if (currentNumber == "" || currentResult == "") {
//            resultField.setText("Syntax Error!");
//            disabledALlBtn();
//            return;
//        }
        try {
            int secondNumberInt = Integer.parseInt(currentNumber);

            switch (calculationType) {
                case "" -> resultField.setText(String.valueOf(currentNumber));
                case "+" -> {
                    if (currentResult.contains(".")) {
                        double firstNumberDouble = Double.parseDouble(currentResult);
                        double calculatedNumber = firstNumberDouble + secondNumberInt;
                        resultField.setText(String.valueOf(calculatedNumber));
                    } else {
                        int firstNumberInt = Integer.parseInt(currentResult);
                        int calculatedNumber = firstNumberInt + secondNumberInt;
                        resultField.setText(String.valueOf(calculatedNumber));
                    }
                }
                case "-" -> {
                    if (currentResult.contains(".")) {
                        double firstNumberDouble = Double.parseDouble(currentResult);
                        double calculatedNumber = firstNumberDouble - secondNumberInt;
                        resultField.setText(String.valueOf(calculatedNumber));
                    } else {
                        int firstNumberInt = Integer.parseInt(currentResult);
                        int calculatedNumber = firstNumberInt - secondNumberInt;
                        resultField.setText(String.valueOf(calculatedNumber));
                    }
                }
                case "/" -> {
//                    if (secondNumberInt == 0) {
//                        resultField.setText("Calculate Error! Can't divide 0!");
//                        disabledALlBtn();
//                        return;
//                    }
                    try {
                        if (currentResult.contains(".")) {
                            double firstNumberDouble = Double.parseDouble(currentResult);
                            double calculatedNumber = firstNumberDouble / (double)secondNumberInt;
                            resultField.setText(String.valueOf(calculatedNumber));
                        } else {
                            int firstNumberInt = Integer.parseInt(currentResult);
                            double calculatedNumber = firstNumberInt / (double)secondNumberInt;
                            resultField.setText(String.valueOf(calculatedNumber));
                        }
                    } catch (Exception err) {
                        resultField.setText("Syntax Error! " + err.getMessage());
                        disabledALlBtn();
                        err.printStackTrace();
                    }
                }
                case "*" -> {
                    if (currentResult.contains(".")) {
                        double firstNumberDouble = Double.parseDouble(currentResult);
                        double calculatedNumber = firstNumberDouble * secondNumberInt;
                        resultField.setText(String.valueOf(calculatedNumber));
                    } else {
                        int firstNumberInt = Integer.parseInt(currentResult);
                        int calculatedNumber = firstNumberInt * secondNumberInt;
                        resultField.setText(String.valueOf(calculatedNumber));
                    }
                }
            }

            fullEquation = fullEquation + "=";
            updateTextField();
            disabledALlBtn();
        } catch (Exception err) {
            resultField.setText("Syntax Error! " + err.getMessage());
            disabledALlBtn();
            err.printStackTrace();
        }
    }

    @FXML
    void onFiveBtnClicked(ActionEvent event) {
        addNumber("5");
    }

    @FXML
    void onFourBtnClicked(ActionEvent event) {
        addNumber("4");
    }

    @FXML
    void onMultBtnClicked(ActionEvent event) {
        calculationSetup("*");
    }

    @FXML
    void onNineBtnClicked(ActionEvent event) {
        addNumber("9");
    }

    @FXML
    void onOneBtnClicked(ActionEvent event) {
        addNumber("1");
    }

    @FXML
    void onSevenBtnClicked(ActionEvent event) {
        addNumber("7");
    }

    @FXML
    void onSixBtnClicked(ActionEvent event) {
        addNumber("6");
    }

    @FXML
    void onSubBtnClicked(ActionEvent event) {
        calculationSetup("-");
    }

    @FXML
    void onThreeBtnClicked(ActionEvent event) {
        addNumber("3");
    }

    @FXML
    void onTwoBtnClicked(ActionEvent event) {
        addNumber("2");
    }

    @FXML
    void onZeroBtnClicked(ActionEvent event) {
        addNumber("0");
    }

    public void calculationSetup(String calculationType) {
        fullEquation = fullEquation + calculationType;
        updateTextField();

//        if (currentNumber == "") {
//            resultField.setText("Syntax Error! NaN!");
//            disabledALlBtn();
//            return;
//        } else if (!currentNumber.contains(".") && currentNumber.charAt(0) == '0') {
//            resultField.setText("Syntax Error! Number can't start with 0!");
//            disabledALlBtn();
//            return;
//        }

        try {
            previousResult = currentResult;
            int firstNumberInt = Integer.parseInt(currentNumber);

            switch (this.calculationType) {
                case "" -> currentResult = currentNumber;
                case "+" -> {
                    if (currentResult.contains(".")) {
                        double secondNumberDouble = Double.parseDouble(currentResult);
                        double calculatedNumber = firstNumberInt + secondNumberDouble;
                        currentResult = "" + calculatedNumber;
                    } else {
                        int secondNumberInt = Integer.parseInt(currentResult);
                        int calculatedNumber = firstNumberInt + secondNumberInt;
                        currentResult = "" + calculatedNumber;
                    }
                }
                case "-" -> {
                    if (currentResult.contains(".")) {
                        double secondNumberDouble = Double.parseDouble(currentResult);
                        double calculatedNumber = secondNumberDouble - firstNumberInt;
                        currentResult = "" + calculatedNumber;
                    } else {
                        int secondNumberInt = Integer.parseInt(currentResult);
                        int calculatedNumber =  secondNumberInt - firstNumberInt;
                        currentResult = "" + calculatedNumber;
                    }
                }
                case "/" -> {
//                    if (firstNumberInt == 0) {
//                        resultField.setText("Calculate Error! Can't divide 0!");
//                        disabledALlBtn();
//                        return;
//                    }
                    try {
                        if (currentResult.contains(".")) {
                            double secondNumberDouble = Double.parseDouble(currentResult);
                            double calculatedNumber = secondNumberDouble / firstNumberInt;
                            currentResult = "" + calculatedNumber;
                        } else {
                            int secondNumberInt = Integer.parseInt(currentResult);
                            double calculatedNumber =  (double)secondNumberInt / firstNumberInt;
                            currentResult = "" + calculatedNumber;
                        }
                    } catch (Exception err) {
                        resultField.setText("Syntax Error! " + err.getMessage());
                        disabledALlBtn();
                        err.printStackTrace();
                    }
                }
                case "*" -> {
                    if (currentResult.contains(".")) {
                        double secondNumberDouble = Double.parseDouble(currentResult);
                        double calculatedNumber = secondNumberDouble * firstNumberInt;
                        currentResult = "" + calculatedNumber;
                    } else {
                        int secondNumberInt = Integer.parseInt(currentResult);
                        int calculatedNumber =  secondNumberInt * firstNumberInt;
                        currentResult = "" + calculatedNumber;
                    }
                }
            }

            previousNumber = currentNumber;
            currentNumber = "";
            previousCalType = this.calculationType;
            this.calculationType = calculationType;
        } catch (Exception err) {
            resultField.setText("Syntax Error! " + err.getMessage());
            disabledALlBtn();
            err.printStackTrace();
        }
    }

    public void updateTextField(){
        dispField.setText(fullEquation);
    }

    public void addNumber(String number) {
        currentNumber += number;
        fullEquation += number;
        updateTextField();
    }

    private boolean checkCalType(char x) {
        return x == '+' || x == '-' || x == '/' || x == '*';
    }
    
    private void disabledALlBtn() {
        oneBtn.setDisable(true);
        twoBtn.setDisable(true);
        threeBtn.setDisable(true);
        fourBtn.setDisable(true);
        fiveBtn.setDisable(true);
        sixBtn.setDisable(true);
        sevenBtn.setDisable(true);
        eightBtn.setDisable(true);
        nineBtn.setDisable(true);
        zeroBtn.setDisable(true);
        openParamBtn.setDisable(true);
        closeParamBtn.setDisable(true);
        dotBtn.setDisable(true);
        addBtn.setDisable(true);
        subBtn.setDisable(true);
        divBtn.setDisable(true);
        multBtn.setDisable(true);
        delBtn.setDisable(true);
        equalBtn.setDisable(true);
    }
    
    private void enableAllBtn() {
        oneBtn.setDisable(false);
        twoBtn.setDisable(false);
        threeBtn.setDisable(false);
        fourBtn.setDisable(false);
        fiveBtn.setDisable(false);
        sixBtn.setDisable(false);
        sevenBtn.setDisable(false);
        eightBtn.setDisable(false);
        nineBtn.setDisable(false);
        zeroBtn.setDisable(false);
        openParamBtn.setDisable(false);
        closeParamBtn.setDisable(false);
        dotBtn.setDisable(false);
        addBtn.setDisable(false);
        subBtn.setDisable(false);
        divBtn.setDisable(false);
        multBtn.setDisable(false);
        delBtn.setDisable(false);
        equalBtn.setDisable(false);
    }
}
