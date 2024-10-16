package Caculrator_Kwon.CalculaotrLvThree.Calculator;

import java.util.List;
import java.util.stream.DoubleStream;

public class CalStatus {

    private Number resultValue;
    private String statusName;
    private Number checkValue;

    public Number getResultValue() {
        return resultValue;
    }

    public void setResultValue(Number resultValue) {
        this.resultValue = resultValue;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Number getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(Number checkValue) {
        this.checkValue = checkValue;
    }

    public void printResultValueList(Double chkValue, List<CalStatus> calculatorStateResultList){
        DoubleStream resultStreamList = calculatorStateResultList.stream()
                .mapToDouble(a -> a.getResultValue().doubleValue());
        resultStreamList.filter(a -> a > chkValue).forEach(System.out::println);
    }

}
