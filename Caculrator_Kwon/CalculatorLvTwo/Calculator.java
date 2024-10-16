package Caculrator_Kwon.CalculatorLvTwo;

public class Calculator {

    private int resultValue;

    Calculator(){}

    public int calculate(int firstNumber, int secondNumber, char operator){
        int result = 0;
        switch (operator) {
            case '+' -> { result = firstNumber + secondNumber; }
            case '-' -> { result = firstNumber - secondNumber; }
            case '*' -> { result = firstNumber * secondNumber; }
            case '/' -> { result = firstNumber / secondNumber; }
        }
        return result;
    }

    public int getResultValue() {
        return resultValue;
    }

    public void setResultValue(int resultValue) {
        this.resultValue = resultValue;
    }
}
