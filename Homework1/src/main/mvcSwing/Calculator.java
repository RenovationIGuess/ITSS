package mvcSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Calculator extends JFrame{

    private JTextField firstField;
    private JTextField secondField;
    private JTextField result;
    private JButton[] signButtons = new JButton[6];
    private JButton clearButton;
    private String sign = "+";

    public Calculator() {

        Container cp = getContentPane();
        GridLayout myLayout = new GridLayout(6, 2);
        myLayout.setVgap(3);
        myLayout.setHgap(2);
        cp.setLayout(myLayout);

        cp.add(new JLabel("FIRST NUMBER: ", SwingConstants.CENTER));
        firstField = new JTextField(10);
        firstField.setBorder(new LineBorder(Color.GRAY,2));
        firstField.addActionListener(new TextFieldListener());
        cp.add(firstField, BorderLayout.NORTH);

        cp.add(new JLabel("SECOND NUMBER: ", SwingConstants.CENTER));
        secondField = new JTextField(10);
        secondField.setBorder(new LineBorder(Color.GRAY,2));
        secondField.addActionListener(new TextFieldListener());
        cp.add(secondField, BorderLayout.NORTH);

        cp.add(new JLabel("RESULT: ", SwingConstants.CENTER));
        result = new JTextField(10);
        result.setBorder(new LineBorder(Color.GRAY,2));
        result.setEditable(false);
        cp.add(result, BorderLayout.NORTH);

        addButtons(cp);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Swing calculator");
        setSize(350, 300);
        cp.setBackground(new java.awt.Color(174, 241, 242));
        setVisible(true);

    }

    void addButtons(Container cp) {

        ButtonListener btnListener = new ButtonListener();

        for (int i = 1; i <= 5; i++) {

            switch(i) {
                case 1:
                    signButtons[i] = new JButton("+");
                    break;
                case 2:
                    signButtons[i] = new JButton("-");
                    break;
                case 3:
                    signButtons[i] = new JButton("*");
                    break;
                case 4:
                    signButtons[i] = new JButton("/");
                    break;
                case 5:
                    signButtons[i] = new JButton("%");
                    break;
            }
            signButtons[i].setBackground(Color.CYAN);
            cp.add(signButtons[i]);
            signButtons[i].addActionListener(btnListener);
        }

        clearButton = new JButton("CLEAR");
        cp.add(clearButton);
        clearButton.addActionListener(btnListener);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            double resultNum = 0;
            String operation = e.getActionCommand();

            if (secondField.getText().equals("") || firstField.getText().equals("")) {

                result.setText("");
                if (operation.equals("CLEAR")) {
                    clearAll();
                    return;
                }

            } else {

                double firstNumberInt = Double.valueOf(firstField.getText());
                double secondNumberInt = Double.valueOf(secondField.getText());

                if (operation.charAt(0) == '+') {
                    resultNum = firstNumberInt + secondNumberInt;
                    sign = "+";
                } else if (operation.charAt(0) == '-') {
                    resultNum = firstNumberInt - secondNumberInt;
                    sign = "-";
                } else if (operation.charAt(0) == '*') {
                    resultNum = firstNumberInt* secondNumberInt;
                    sign = "*";
                } else if (operation.charAt(0) == '/') {
                    resultNum = (double)(firstNumberInt / secondNumberInt);
                    sign = "/";
                } else if (operation.charAt(0) == '%'){
                    resultNum = firstNumberInt % secondNumberInt;
                    sign = "%";
                } else {
                    clearAll();
                    return;
                }
                result.setText("" + resultNum);
            }

        }
    }

    private class TextFieldListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double resultNum = 0;

            if (secondField.getText().equals("") || firstField.getText().equals("")) {
                result.setText("");
            } else {

                double firstNum = Double.valueOf(firstField.getText());
                double secondNum = Double.valueOf(secondField.getText());

                result.setText("" + resultNum);
                if (sign.equals("+")) {
                    resultNum = firstNum + secondNum;
                } else if (sign.equals("-")) {
                    resultNum = firstNum - secondNum;
                } else if (sign.equals("*")) {
                    resultNum = firstNum * secondNum;
                } else if (sign.equals("/")) {
                    resultNum = firstNum / secondNum;
                } else if (sign.equals("%")){
                    resultNum = firstNum % secondNum;
                } else {
                    resultNum = 0;
                }

                result.setText("" + resultNum);
            }
        }

    }

    private void clearAll() {
        firstField.setText("");
        secondField.setText("");
        result.setText("");
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
