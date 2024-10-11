package Caculrator_Kwon;

import java.util.Scanner;

public class CalculatorApp {


    public static CalStatus start() throws Exception{
        CalStatus cal = new CalStatus();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);

        System.out.println("첫번째 숫자를 입력해주세요");
        String firstInput = scanner.nextLine();
        if(firstInput.equals("exit")){
            cal.setStatusName("exit");
            return cal;
        }else{
            parser.parseReturnFirstNum(firstInput);
        }

        System.out.println("연산자를 입력해주세요");
        String operator = scanner.nextLine();
        parser.parseOperator2(operator);

        System.out.println("두번째 숫자를 입력해주세요");
        String secondInput = scanner.nextLine();
        if(secondInput.equals("big")){
            cal.setStatusName("big");
            parser.parseReturnSecondNum(firstInput);
            cal.setCheckValue(Double.parseDouble(firstInput));
            return cal;
        }else{
            parser.parseReturnSecondNum(secondInput);
        }
        parser.parseReturnSecondNum(secondInput);

        System.out.println("연산 결과 : " + parser.executeCalculator2());

        cal.setResultValue(parser.executeCalculator2());
        cal.setStatusName("");
        return cal;
    }

}