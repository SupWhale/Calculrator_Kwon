package Caculrator_Kwon;

import Caculrator_Kwon.Exception.BadInputException;
import Caculrator_Kwon.Operation.AddOperation;
import Caculrator_Kwon.Operation.DivideOperation;
import Caculrator_Kwon.Operation.MultiplyOperation;
import Caculrator_Kwon.Operation.SubstractOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";
    private static final String NUMBER_REG2 = "^[-+]?(0|[1-9][0-9]*)(\\.[0-9]+)?([eE][-+]?[0-9]+)?$";

    private final Calculator calculator = new Calculator();
    private final ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
    private static OperatorType op;
    private List<Number> resultList = new ArrayList<Number>();

    public Parser parseFirstNum(String firstInput) throws Exception{
        if(!Pattern.matches(NUMBER_REG,firstInput)){
            throw new BadInputException("정수값");
        }
        this.calculator.setFirstNumber(Integer.parseInt(firstInput));

        return this;
    }

    public Parser parseReturnFirstNum(String firstInput) throws Exception{
        Number result = 0;
        if(Pattern.matches(NUMBER_REG,firstInput)){
            result = Integer.parseInt(firstInput);
            this.arithmeticCalculator.setFirstNumber(Integer.parseInt(firstInput));
        }else if(Pattern.matches(NUMBER_REG2,firstInput)){
            result = Double.parseDouble(firstInput);
            this.arithmeticCalculator.setFirstNumber(Double.parseDouble(firstInput));
        }else{
            throw new BadInputException("숫자");
        }
        return this;
    }

    public Parser parseSecondNum(String secondInput) throws Exception{
        if(!Pattern.matches(NUMBER_REG,secondInput)){
            throw new BadInputException("정수값");
        }
        this.calculator.setSecondNumber(Integer.parseInt(secondInput));

        return this;
    }

    public Parser parseReturnSecondNum(String secondInput) throws Exception{
        Number result = 0;
        if(Pattern.matches(NUMBER_REG,secondInput)){
            result = Integer.parseInt(secondInput);
            this.arithmeticCalculator.setSecondNumber(Integer.parseInt(secondInput));
        }else if(Pattern.matches(NUMBER_REG2,secondInput)){
            result = Double.parseDouble(secondInput);
            this.arithmeticCalculator.setSecondNumber(Double.parseDouble(secondInput));
        }
        return this;
    }

    public Parser parseOperator(String operationInput) throws Exception{
        if(!Pattern.matches(OPERATION_REG,operationInput)){
            throw new BadInputException("연산자(를)");
        }
        op = OperatorType.FindOperatorType(operationInput);

       switch(op.getOperation()){
           case "+" -> this.calculator.setOperation(new AddOperation());
           case "-" -> this.calculator.setOperation(new SubstractOperation());
           case "*" -> this.calculator.setOperation(new MultiplyOperation());
           case "/" -> this.calculator.setOperation(new DivideOperation());
       }
        return this;
    }

    public Parser parseOperator2(String operationInput) throws Exception{
        if(!Pattern.matches(OPERATION_REG,operationInput)){
            throw new BadInputException("연산자(를)");
        }
        op = OperatorType.FindOperatorType(operationInput);

        switch(op.getOperation()){
            case "+" -> this.arithmeticCalculator.setOperation(new AddOperation());
            case "-" -> this.arithmeticCalculator.setOperation(new SubstractOperation());
            case "*" -> this.arithmeticCalculator.setOperation(new MultiplyOperation());
            case "/" -> this.arithmeticCalculator.setOperation(new DivideOperation());
        }
        return this;
    }

    public Number executeCalculator() {
        return calculator.calculate();
    }

    public Number executeCalculator2() throws Exception {
        Number result =ArithmeticCalculator.calculate(this.arithmeticCalculator.getFirstNumber(), this.arithmeticCalculator.getSecondNumber());
        //List<Number> newResult = this.arithmeticCalculator.getResultList();
        resultList.add(result);
        //this.arithmeticCalculator.setResultList(newResult);
        return result;

    }
}