package Caculrator_Kwon.CalculatorLvTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_Calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String status = "";

        List<Calculator> resultList = new ArrayList<Calculator>();

        while(true){
            if(status.equals("exit")){
                break;
            }else if(status.equals("remove")){
                resultList.removeFirst();
            }
            Calculator calculator = new Calculator();

            System.out.print("첫번재 숫자를 입력하세요: ");
            int firstNumber = sc.nextInt();

            String skipoperation = sc.nextLine();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            System.out.print("두번재 숫자를 입력하세요: ");
            int secondNumber = sc.nextInt();

            calculator.setResultValue(calculator.calculate(firstNumber, secondNumber, operator));

            System.out.println("결과: " + calculator.getResultValue());

            resultList.addFirst(calculator);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            System.out.println("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String skipstatus = sc.nextLine();
            status = sc.nextLine();
        }
    }
}