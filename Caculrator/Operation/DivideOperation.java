package Caculrator.Operation;

public class DivideOperation extends AbstractOperation{

    @Override
    public double operate(int firstNumber, int secondNumber){
        return (double) firstNumber / secondNumber;
    }

}
