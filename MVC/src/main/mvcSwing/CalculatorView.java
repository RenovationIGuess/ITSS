// This is the View
// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it.
package mvcSwing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class CalculatorView extends JFrame{

	private JTextField firstField;
	private JTextField secondField;
	private JTextField result;
	private JButton[] operandButtons = new JButton[6];
	private JButton clearButton;

	CalculatorView(){

		// Sets up the view and adds the components

		Container cp = getContentPane();
		GridLayout myLayout = new GridLayout(6, 2);
		myLayout.setVgap(3);
		myLayout.setHgap(2);
		cp.setLayout(myLayout);

		cp.add(new JLabel("FIRST NUMBER: ", SwingConstants.CENTER));
		firstField = new JTextField(10);
		firstField.setBorder(new LineBorder(Color.GRAY,2));
		cp.add(firstField, BorderLayout.NORTH);

		cp.add(new JLabel("SECOND NUMBER: ", SwingConstants.CENTER));
		secondField = new JTextField(10);
		secondField.setBorder(new LineBorder(Color.GRAY,2));
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

		// End of setting up the components --------

	}

	void addButtons(Container cp) {
		for (int i = 1; i <= 5; i++) {
			switch(i) {
				case 1:
					operandButtons[i] = new JButton("+");
					break;
				case 2:
					operandButtons[i] = new JButton("-");
					break;
				case 3:
					operandButtons[i] = new JButton("*");
					break;
				case 4:
					operandButtons[i] = new JButton("/");
					break;
				case 5:
					operandButtons[i] = new JButton("%");
					break;
			}
			operandButtons[i].setBackground(Color.lightGray);
			cp.add(operandButtons[i]);
		}

		clearButton = new JButton("CLEAR");
		clearButton.setBackground(Color.lightGray);
		cp.add(clearButton);
	}

	public void clearAll() {
		firstField.setText("");
		secondField.setText("");
		result.setText("");
	}

	public int getFirstNumber(){

		return Integer.parseInt(firstField.getText());

	}

	public int getSecondNumber(){

		return Integer.parseInt(secondField.getText());

	}

	public int getCalcSolution(){

		return Integer.parseInt(result.getText());

	}

	public void setCalcSolution(String solution){

		result.setText(solution);

	}

	// If the calculateButton is clicked execute a method
	// in the Controller named actionPerformed

	void addCalculateListener(ActionListener listenForCalcButton){
		for (int i = 1; i <= 5; ++i) {
			operandButtons[i].addActionListener(listenForCalcButton);
		}
		clearButton.addActionListener(listenForCalcButton);
	}

	// Open a popup that contains the error message passed

	void displayErrorMessage(String errorMessage){

		JOptionPane.showMessageDialog(this, errorMessage);

	}

}