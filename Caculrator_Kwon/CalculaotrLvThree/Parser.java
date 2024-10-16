package Caculrator_Kwon.CalculaotrLvThree;

import Caculrator_Kwon.CalculaotrLvThree.Calculator.ArithmeticCalculator;
import Caculrator_Kwon.CalculaotrLvThree.Calculator.Calculator;
import Caculrator_Kwon.CalculaotrLvThree.Exception.BadInputException;
import Caculrator_Kwon.CalculaotrLvThree.Operation.AddOperation;
import Caculrator_Kwon.CalculaotrLvThree.Operation.DivideOperation;
import Caculrator_Kwon.CalculaotrLvThree.Operation.MultiplyOperation;
import Caculrator_Kwon.CalculaotrLvThree.Operation.SubstractOperation;
import Caculrator_Kwon.CalculaotrLvThree.Operator.OperatorType;

import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";
    private static final String RATIONAL_NUMBER_REG = "^[-+]?(0|[1-9][0-9]*)(\\.[0-9]+)?([eE][-+]?[0-9]+)?$";

    private final Calculator calculator = new Calculator();
    private final ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
    private static OperatorType op;

    public Parser parseFirstNum(String firstInput) throws Exception{
        Number result = 0;
        if(Pattern.matches(NUMBER_REG,firstInput)){
            result = Integer.parseInt(firstInput);
            this.arithmeticCalculator.setFirstNumber(Integer.parseInt(firstInput));
        }else if(Pattern.matches(RATIONAL_NUMBER_REG,firstInput)){
            result = Double.parseDouble(firstInput);
            this.arithmeticCalculator.setFirstNumber(Double.parseDouble(firstInput));
        }else{
            throw new BadInputException("숫자");
        }
        return this;
    }
    
    public Parser parseSecondNum(String secondInput) throws Exception{
        Number result = 0;
        if(Pattern.matches(NUMBER_REG,secondInput)){
            result = Integer.parseInt(secondInput);
            this.arithmeticCalculator.setSecondNumber(Integer.parseInt(secondInput));
        }else if(Pattern.matches(RATIONAL_NUMBER_REG,secondInput)){
            result = Double.parseDouble(secondInput);
            this.arithmeticCalculator.setSecondNumber(Double.parseDouble(secondInput));
        }else{
            throw new BadInputException("숫자");
        }
        return this;
    }

    public Parser parseOperator(String operationInput) throws Exception{
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

    public Number executeCalculator_Generic() throws Exception {
        return ArithmeticCalculator.calculate(this.arithmeticCalculator.getFirstNumber(), this.arithmeticCalculator.getSecondNumber());
    }

    public Number executeCalculator_Stack(String firstInput) throws Exception {
        return ArithmeticCalculator.lineCalculate(firstInput);

    }
}