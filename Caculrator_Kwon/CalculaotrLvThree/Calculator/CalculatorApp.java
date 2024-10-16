package Caculrator_Kwon.CalculaotrLvThree.Calculator;

import Caculrator_Kwon.CalculaotrLvThree.Parser;

import java.util.Scanner;

public class CalculatorApp {
    public static CalStatus start() throws Exception{
        CalStatus calStatus = new CalStatus();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        String firstInput = "";
        String secondInput = "";
        String operator = "";

        System.out.println("실행할 작업을 선택해주세요");
        System.out.println("1. 단순 계산 2. 수식 계산 3. 결과값 비교 4. 최근 계산값 삭제 5. 나가기");

        String modeInput = scanner.nextLine();
        switch (modeInput){
            case "1" -> {
                System.out.println("첫번째 숫자를 입력해주세요");
                firstInput = scanner.nextLine();
                parser.parseFirstNum(firstInput);

                System.out.println("연산자를 입력해주세요");
                operator = scanner.nextLine();
                parser.parseOperator(operator);

                System.out.println("두번째 숫자를 입력해주세요");
                secondInput = scanner.nextLine();
                parser.parseSecondNum(secondInput);

                Number result = parser.executeCalculator_Generic();
                System.out.println("연산 결과 : " + result);

                calStatus.setResultValue(result);
                calStatus.setStatusName("");

                return calStatus;
            }
            case "2" -> {
                System.out.println("수식을 입력해주세요");
                firstInput = scanner.nextLine();

                Number result = parser.executeCalculator_Stack(firstInput);

                System.out.println("연산 결과 : " + result);
                calStatus.setResultValue(result);

                calStatus.setStatusName("");
                return calStatus;
            }
            case "3" -> {
                System.out.println("비교할 숫자를 입력해주세요");
                firstInput = scanner.nextLine();
                calStatus.setStatusName("3");
                parser.parseFirstNum(firstInput);
                calStatus.setCheckValue(Double.parseDouble(firstInput));
                return calStatus;
            }
            case "4" -> {
                calStatus.setStatusName("4");
                return calStatus;
            }
            case "5" -> {
                calStatus.setStatusName("5");
                return calStatus;
            }

            default -> {
                calStatus.setStatusName("");
            }
        }
        return calStatus;
    }

}