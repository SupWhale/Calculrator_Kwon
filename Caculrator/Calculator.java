package Caculrator;

import Caculrator.Operation.AbstractOperation;

public class Calculator {
    private int firstNumber;
    private int secondNumber;

    private AbstractOperation operation;

    public Calculator(AbstractOperation operation){
        this.operation = operation;
    }

    public Calculator(){

    }

    public void setOperation(AbstractOperation operation){
        this.operation = operation;
    }

    public double calculate(){
        double result = 0.0;
        result = operation.operate(this.firstNumber, this.secondNumber);
        return result;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }
}
