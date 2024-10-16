package Caculrator_Kwon.CalculaotrLvThree.Operation;

public abstract class AbstractOperation {
    //정수 계산 처리
    public abstract int operateInteger(Integer firstNumber, Integer secondNumber);
    //유리수 계산 처리
    public abstract double operateDouble(Double firstNumber, Double secondNumber);
}
