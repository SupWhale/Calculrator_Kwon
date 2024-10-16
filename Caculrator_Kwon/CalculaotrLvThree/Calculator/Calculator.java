package Caculrator_Kwon.CalculaotrLvThree.Calculator;

import Caculrator_Kwon.CalculaotrLvThree.Operation.AbstractOperation;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private Number firstNumber;
    private Number secondNumber;

    private AbstractOperation operation;
    private String calculateType;
    private List<Number> resultList = new ArrayList<Number>();


    public Calculator(AbstractOperation operation){
        this.operation = operation;
    }
    public Calculator(){

    }

    public void setOperation(AbstractOperation operation){
        this.operation = operation;
    }

    public Number calculate(){
        Number result = 0.0;
        if(calculateType.equals("I")){
            result = operation.operateInteger((Integer)this.firstNumber, (Integer)this.secondNumber);
        }else if(calculateType.equals("D")){
            result = operation.operateDouble((Double)this.firstNumber, (Double)this.secondNumber);
        }
        resultList.add(result);
        return result;
    }



    public Number getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Number getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }
}
