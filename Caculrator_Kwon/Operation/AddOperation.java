package Caculrator_Kwon.Operation;

public class AddOperation extends AbstractOperation {

    @Override
    public int operateInteger(Integer firstNumber, Integer secondNumber){
        return firstNumber + secondNumber;
    }
    @Override
    public double operateDouble(Double firstNumber, Double secondNumber) {
        return (Double) firstNumber + secondNumber;
    }
}
