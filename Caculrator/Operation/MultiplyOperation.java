package Caculrator.Operation;

public class MultiplyOperation extends AbstractOperation{

    @Override
    public double operate(int firstNumber, int secondNumber){
        return (double) firstNumber * secondNumber;
    }

}
