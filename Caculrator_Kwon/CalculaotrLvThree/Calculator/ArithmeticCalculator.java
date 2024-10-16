package Caculrator_Kwon.CalculaotrLvThree.Calculator;

import Caculrator_Kwon.CalculaotrLvThree.Operation.AbstractOperation;
import Caculrator_Kwon.CalculaotrLvThree.Operator.OperatorType;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator <T extends Number>{

    private Number FirstNumber;
    private Number SecondNumber;
    private static OperatorType op;

    private static AbstractOperation operation;

    ArithmeticCalculator(Number FirstNumber, Number SecondNumber, String op){
        this.FirstNumber = FirstNumber;
        this.SecondNumber = SecondNumber;
        setInputOperType(op);
    }

    public ArithmeticCalculator(){
    }

    public static Number lineCalculate(String numberLine){
        Number result = 0.0;
        result = LineCalculator.Calculate(numberLine);
        return result;
    }

    public static <T extends Number, R extends Number> Number calculate(T t, R r) throws Exception{
        Number result = 0;
        if(t instanceof Integer && r instanceof Integer){
            result = operation.operateInteger((Integer) t, (Integer) r);
        }else if(t instanceof Double && r instanceof Double){
            result = operation.operateDouble((Double) t, (Double) r);
        }
        return result;
    }

    public Number getFirstNumber() {
        return FirstNumber;
    }

    public void setFirstNumber(Number firstNumber) {
        FirstNumber = firstNumber;
    }

    public static String getInputOperType() {
        return op.getOperation();
    }

    public void setInputOperType(String inputOperType) {
        op = OperatorType.FindOperatorType(inputOperType);
    }

    public Number getSecondNumber() {
        return SecondNumber;
    }

    public void setOperation(AbstractOperation operation){
        this.operation = operation;
    }

    public void setSecondNumber(Number secondNumber) {
        SecondNumber = secondNumber;
    }
}
