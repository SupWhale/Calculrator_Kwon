package Caculrator_Kwon.CalculaotrLvThree.Operator;

import java.util.Arrays;

public enum OperatorType {
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIVIDE("/"),
    PERCENT("%");

    private String operation;

    OperatorType(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static OperatorType FindOperatorType(String type){
        return Arrays.stream(values())
                        .filter(x -> x.getOperation().equals(type))
                        .findAny().orElse(null);
    }

}
