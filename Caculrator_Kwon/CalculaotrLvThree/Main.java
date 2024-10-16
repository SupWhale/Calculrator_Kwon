package Caculrator_Kwon.CalculaotrLvThree;

import Caculrator_Kwon.CalculaotrLvThree.Calculator.ArithmeticCalculator;
import Caculrator_Kwon.CalculaotrLvThree.Calculator.CalculateStatus;
import Caculrator_Kwon.CalculaotrLvThree.Calculator.CalculatorApp;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static ArithmeticCalculator<Number> arithmeticCalculator = new ArithmeticCalculator<Number>();

    public static void main(String[] args) {
        List<CalculateStatus> calculatorStateResultList = new ArrayList<CalculateStatus>(); //계산 결과를 받을 Array List
        CalculateStatus calculatorState = new CalculateStatus(); //현재 계산기 모드 체크
        calculatorState.setStatusName("start");  //초기 계산기 모드 값
        while (!calculatorState.getStatusName().equals("5")) {
            try {
                calculatorState = CalculatorApp.start();
                if(calculatorState.getStatusName().equals("3")){
                    //비교값 가져오기
                    double result = (Double) calculatorState.getCheckValue();
                    //비교리스트 출력
                    calculatorState.printResultValueList(result, calculatorStateResultList);
                }else if(calculatorState.getStatusName().equals("4")){
                    System.out.println("계산결과 " + calculatorStateResultList.getFirst().getResultValue() +"가 삭제되었습니다!");
                    calculatorStateResultList.removeFirst();
                }
                //계산이라면 계산 결과 저장하기
                calculatorStateResultList.add(calculatorState);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}