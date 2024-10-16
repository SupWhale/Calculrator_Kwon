package Caculrator_Kwon.CalculaotrLvThree.Operation;

public class PercentOperation extends AbstractOperation {

    @Override
    public int operateInteger(Integer firstNumber, Integer secondNumber){
        return firstNumber % secondNumber;
    }

    @Override
    public double operateDouble(Double firstNumber, Double secondNumber) {
        return firstNumber % secondNumber;
    }
}
