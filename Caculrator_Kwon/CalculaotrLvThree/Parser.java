package Caculrator_Kwon.CalculaotrLvThree;

import Caculrator_Kwon.CalculaotrLvThree.Calculator.ArithmeticCalculator;
import Caculrator_Kwon.CalculaotrLvThree.Calculator.Calculator;
import Caculrator_Kwon.CalculaotrLvThree.Exception.BadInputException;
import Caculrator_Kwon.CalculaotrLvThree.Exception.CantDevideException;
import Caculrator_Kwon.CalculaotrLvThree.Operation.*;
import Caculrator_Kwon.CalculaotrLvThree.Operator.OperatorType;

import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/%]";
    private static final String NUMBER_REG = "^[0-9]*$";
    private static final String RATIONAL_NUMBER_REG = "^[-+]?(0|[1-9][0-9]*)(\\.[0-9]+)?([eE][-+]?[0-9]+)?$";

    private final Calculator calculator = new Calculator();
    private final ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
    private static OperatorType op;

    
    //문자열 변수를 받고 숫자형으로 변환하여 첫번째 숫자에 삽입
    public Parser parseFirstNum(String firstInput) throws Exception{
        if(Pattern.matches(NUMBER_REG,firstInput)){
            this.arithmeticCalculator.setFirstNumber(Integer.parseInt(firstInput));
        }else if(Pattern.matches(RATIONAL_NUMBER_REG,firstInput)){
            this.arithmeticCalculator.setFirstNumber(Double.parseDouble(firstInput));
        }else{
            throw new BadInputException("숫자");
        }
        return this;
    }

    //문자열 변수를 받고 숫자형으로 변환하여 두번째 숫자에 삽입
    public Parser parseSecondNum(String secondInput) throws Exception{
        if(Pattern.matches(NUMBER_REG,secondInput)){
            this.arithmeticCalculator.setSecondNumber(Integer.parseInt(secondInput));
            if(secondInput.equals("0") && op.getOperation().equals("/")){
                throw new CantDevideException();
            }
        }else if(Pattern.matches(RATIONAL_NUMBER_REG,secondInput)){
            this.arithmeticCalculator.setSecondNumber(Double.parseDouble(secondInput));
        }else{
            throw new BadInputException("숫자");
        }
        return this;
    }

    //연산자 타입 변경 및 연산 타입 세티
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
            case "%" -> this.arithmeticCalculator.setOperation(new PercentOperation());
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