package Caculrator_Kwon.CalculatorLvOne;

import Caculrator_Kwon.Calculator.ArithmeticCalculator;
import Caculrator_Kwon.Calculator.CalStatus;
import Caculrator_Kwon.Calculator.CalculatorApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_Calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String status = "";

        while(true){
            if(status.equals("exit")){
                break;
            }
            System.out.print("첫번재 숫자를 입력하세요: ");
            int firstNumber = sc.nextInt();

            String skipoperation = sc.nextLine();

            System.out.print("사칙연산 기호를 입력하세요: ");
            String operation = sc.nextLine();

            System.out.print("두번재 숫자를 입력하세요: ");
            int secondNumber = sc.nextInt();

            int result = 0;

            switch (operation) {
                case "+" -> { result = firstNumber + secondNumber; }
                case "-" -> { result = firstNumber - secondNumber; }
                case "*" -> { result = firstNumber * secondNumber; }
                case "/" -> { result = firstNumber / secondNumber; }
            }

            System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String skipstatus = sc.nextLine();
            status = sc.nextLine();
        }
    }
}