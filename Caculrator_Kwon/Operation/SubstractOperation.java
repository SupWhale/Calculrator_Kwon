package Caculrator_Kwon.Operation;

public class SubstractOperation extends AbstractOperation {

    @Override
    public int operateInteger(Integer firstNumber, Integer secondNumber) {
        return (Integer) firstNumber - secondNumber;
    }

    @Override
    public double operateDouble(Double firstNumber, Double secondNumber) {
        return (Double) firstNumber - secondNumber;
    }

}
