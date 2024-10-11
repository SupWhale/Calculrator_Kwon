package Caculrator.Parser;

import Caculrator.Calculator;
import Caculrator.Exception.BadInputException;
import Caculrator.Operation.AddOperation;
import Caculrator.Operation.DivideOperation;
import Caculrator.Operation.MultiplyOperation;
import Caculrator.Operation.SubstractOperation;

import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    private final Calculator calculator = new Calculator();


    /*실행이나 다른 클래스에서 exception을 실행할시 처리가 복잡해지지만 Parser클래스에서 처리시 비교적
    깔끔하게 처리할 수 있어 Parser 클래스에서 체크하는것이 가장 효율적이라 생각됩니다.*/
    public Parser parseFirstNum(String firstInput) throws Exception{
        if(!Pattern.matches(NUMBER_REG,firstInput)){
            throw new BadInputException("정수값");
        }
        this.calculator.setFirstNumber(Integer.parseInt(firstInput));

        return this;
    }

    public Parser parseSecondNum(String secondInput) throws Exception{
        if(!Pattern.matches(NUMBER_REG,secondInput)){
            throw new BadInputException("정수값");
        }
        this.calculator.setSecondNumber(Integer.parseInt(secondInput));

        return this;
    }

    public Parser parseOperator(String operationInput) throws Exception{
        if(!Pattern.matches(OPERATION_REG,operationInput)){
            throw new BadInputException("연산자(를)");
        }
       switch(operationInput){
           case "+" -> this.calculator.setOperation(new AddOperation());
           case "-" -> this.calculator.setOperation(new SubstractOperation());
           case "*" -> this.calculator.setOperation(new MultiplyOperation());
           case "/" -> this.calculator.setOperation(new DivideOperation());
       }
        return this;
    }

    public double executeCalculator() {
        return calculator.calculate();
    }
}