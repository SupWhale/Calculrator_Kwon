package Caculrator.Operation;

public class AddOperation extends AbstractOperation{

    @Override
    public double operate(int firstNumber, int secondNumber){
        return (double) firstNumber + secondNumber;
    }

}
