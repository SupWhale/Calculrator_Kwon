package Caculrator_Kwon.CalculaotrLvThree.Calculator;

import java.util.List;

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
        List<CalStatus> resultStreamList = calculatorStateResultList.stream()
                .filter(a -> (Double) a.getResultValue() > chkValue)
                .toList();
        for (CalStatus calStatus : resultStreamList) {
            System.out.println(calStatus.getResultValue());
        }
    }

}
