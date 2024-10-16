package Caculrator_Kwon.CalculaotrLvThree;

import Caculrator_Kwon.CalculaotrLvThree.Calculator.ArithmeticCalculator;
import Caculrator_Kwon.CalculaotrLvThree.Calculator.CalStatus;
import Caculrator_Kwon.CalculaotrLvThree.Calculator.CalculatorApp;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static ArithmeticCalculator<Number> arithmeticCalculator = new ArithmeticCalculator<Number>();

    public static void main(String[] args) {
        List<CalStatus> calculatorStateResultList = new ArrayList<CalStatus>(); //계산 결과를 받을 Array List
        CalStatus calculatorState = new CalStatus(); //현재 계산기 모드 체크
        calculatorState.setStatusName("start");  //초기 계산기 모드 값
        while (!calculatorState.getStatusName().equals("4")) {
            try {
                calculatorState = CalculatorApp.start();
                if(calculatorState.getStatusName().equals("3")){
                    //비교값 가져오기
                    double result = (Double) calculatorState.getCheckValue();
                    //비교리스트 출력
                    calculatorState.printResultValueList(result, calculatorStateResultList);
                }
                //그냥 계산이면 계산 결과 저장하기
                calculatorStateResultList.add(calculatorState);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}