package Caculrator_Kwon;

import java.util.ArrayList;
import java.util.List;

public class Main {

    OperatorType op;
    static ArithmeticCalculator<Number> arithmeticCalculator = new ArithmeticCalculator<Number>();

    public static void main(String[] args) {
        boolean calculateEnded = false;
        List<CalStatus> cal = new ArrayList<CalStatus>();
        CalStatus cal2 = new CalStatus();
        cal2.setStatusName("start");
        CalculResultMem mem = new CalculResultMem();
        while (!cal2.getStatusName().equals("exit")) {
            try {
                cal2 = CalculatorApp.start();
                if(cal2.getStatusName().equals("big")){
                    Double chk = (Double) cal2.getCheckValue();
                    List<CalStatus> resultList = cal.stream()
                            .filter(a -> (Integer) a.getResultValue() > chk)
                            .toList();
                    for(int i=0; i<resultList.size(); i++){
                        System.out.println(resultList.get(i).getResultValue());
                    }
                }
                cal.add(cal2);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}