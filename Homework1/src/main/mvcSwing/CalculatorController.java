package mvcSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The Controller coordinates interactions
// between the View and Model

public class CalculatorController {
	
	private CalculatorView theView;
	private CalculatorModel theModel;
	
	public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		
		// Tell the View that when ever the calculate button
		// is clicked to execute the actionPerformed method
		// in the CalculateListener inner class
		
		this.theView.addCalculateListener(new CalculateListener());
	}
	
	class CalculateListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			String operation = e.getActionCommand();
			int firstNumber, secondNumber = 0;
			
			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered
			if (operation.equals("CLEAR")) {
				theView.clearAll();
			} else {
				try{
					firstNumber = theView.getFirstNumber();
					secondNumber = theView.getSecondNumber();

					switch (operation.charAt(0)) {
						case '+' -> theModel.addTwoNumbers(firstNumber, secondNumber);
						case '-' -> theModel.substractTwoNumbers(firstNumber, secondNumber);
						case '*' -> theModel.multiplyTwoNumbers(firstNumber, secondNumber);
						case '/' -> theModel.divideTwoNumbers(firstNumber, secondNumber);
						case '%' -> theModel.divideReTwoNumbers(firstNumber, secondNumber);
					}

					theView.setCalcSolution(theModel.getCalculationValue());

				}

				catch(NumberFormatException ex){

					System.out.println(ex);

					theView.displayErrorMessage("You Need to Enter 2 Integers");

				}
			}
		}
		
	}
	
}