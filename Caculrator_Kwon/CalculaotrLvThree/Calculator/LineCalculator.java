package Caculrator_Kwon.CalculaotrLvThree.Calculator;

import Caculrator_Kwon.CalculaotrLvThree.Exception.BadInputException;
import Caculrator_Kwon.CalculaotrLvThree.Operator.OperatorType;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Pattern;

public class LineCalculator {
    private static final String NUMBER_REG = "^[0-9]*$";
    private static final String RATIONAL_NUMBER_REG = "^[-+]?(0|[1-9][0-9]*)(\\.[0-9]+)?([eE][-+]?[0-9]+)?$";

    public static Number Calculate(String line) throws Exception {
        return (postfixCalculate(convPostfix(line)));
    }

    public static double postfixCalculate(ArrayList<String> postfix) throws Exception {
        Stack stack = new Stack();
        char c = ' ';
        double firstNumber = 0;
        double secondNumber = 0;

        for(int i=0; i<postfix.size(); i++){
            //연산자 구분을 위해 선언
            c = postfix.get(i).charAt(0);

            // 숫자인 경우 스택에 저장
            if (Pattern.matches(NUMBER_REG,postfix.get(i)) || Pattern.matches(RATIONAL_NUMBER_REG,postfix.get(i))){
                stack.push(postfix.get(i));
            }
            // 연산자인 경우 계산 후 스택에 저장
            else {
                secondNumber = Double.parseDouble(stack.pop().toString());
                firstNumber = Double.parseDouble(stack.pop().toString());
                //열거형에서 알맞은 연산자 찾기
                OperatorType opType = OperatorType.FindOperatorType(Character.toString(c));
                if(opType != null){
                    switch (opType.getOperation()){
                        // op2에 먼저 pop한 이유는 후위 표기법으로 변환할 때 순서가 바뀌기 때문
                        // ex) 3+2 => 스택에 저장 시 3, 2 순으로 저장되는데 스택은 마지막에 push한
                        // 데이터가 가장 위에 있으므로
                        case "+":
                            stack.push(firstNumber + secondNumber);
                            break;

                        case "-":
                            stack.push(firstNumber - secondNumber);
                            break;

                        case "*":
                            stack.push(firstNumber * secondNumber);
                            break;

                        case "/":
                            stack.push(firstNumber / secondNumber);
                            break;

                        case "%":
                            stack.push(firstNumber % secondNumber);
                            break;
                        //숫자, 연산자를 제외한 문자가 발견되었을 경우 연산을 즉시 종료한다.
                        default: throw new BadInputException("숫자나 연산자");
                    }
                }else{
                    throw new BadInputException("숫자나 연산자");
                }
            }
        }
        return Double.parseDouble(stack.pop().toString());
    }

    public static ArrayList<String> convPostfix(String infix) throws Exception{
        char c = ' ';
        Stack opStack = new Stack(); //수식 스택
        ArrayList<String> sb = new ArrayList<String>(); //변환된 후위식(리턴값)

        for(int i=0; i<infix.length(); i++){
            c = infix.charAt(i);

            // 숫자이면 StringBuilder sb에 추가한다.
            if (Character.isDigit(c)){
                String result = "";
                result += c;
                //피연산자가 2자리이상일 경우라면
                if(i+1 < infix.length()) {
                    if (Character.isDigit(infix.charAt(i + 1))) {
                        for (int j = i + 1; j < infix.length(); j++) {
                            //피연산자가 유리수일수도 있는 경우
                            if (Character.isDigit(infix.charAt(j)) || infix.charAt(j) == '.') {
                                result += infix.charAt(j);
                            } else {
                                //그 뒤로 숫자가 없다면 j는 무조건 i+1의 숫자이므로
                                //j-1로 포인터를 재조정하여 빠지는 배열이 없도록한다.
                                i = j - 1;
                                break;
                            }
                        }
                    }
                }
                //연산요소 추가
                sb.add(result);
            }
            // 연산자 스택이 비어있을 경우 opStack에 값 push
            else if (opStack.isEmpty()){
                opStack.push(c);
            }
            // 숫자가 아니고 연산자 스택이 비어있지 않은 경우 (연산자가 하나라도 스택에 추가된 경우)
            else {
                // 여는 괄호가 나오면 스택에 저장 후 다음 문자로
                if (c == '('){
                    opStack.push(c);
                    continue;
                }
                // 닫는 괄호가 나올 경우
                // 스택에 저장된 모든 연산자를 반환
                else if (c == ')'){
                    char check = ' ';
                    while(true) {
                        if(!opStack.isEmpty()){ //opstack 공백 체크
                            check = (char) opStack.pop();
                            if (check == '(') {
                                break;
                            }
                            else {
                                //공백 문자를 제외한 나머지를 입력합니다.
                                if(check != 0){
                                    String result = "";
                                    result += check;
                                    sb.add(result);
                                }
                            }
                        }
                    }
                    continue;
                }

                // 현재 연산자의 우선순위가 더 높은 경우
                // 스택에 연산자 저장
                if (compareOp((char)opStack.peek(), c) > 0){
                    opStack.push(c);
                }
                // 현재 연산자의 우선순위가 더 낮거나 같은 경우
                // 스택에 있는 우선순위가 높은 연산자를 빼서 표현
                else {
                    while(!opStack.isEmpty()){
                        if (compareOp((char)opStack.peek(), c) <= 0){
                            String result = "";
                            result += opStack.pop();
                            sb.add(result);
                        }
                    }
                    opStack.push(c);
                }
            }
        }

        char check = ' ';
        while(!opStack.isEmpty()) {
            //정확한 구분을 위해 char 타입으로 pop한다.
            check = (char) opStack.pop();
            //여는 괄호이거나 공백이나 문자가 아닌 경우에만 수식에 추가한다.
            if (check != '(' && check != ' ') {
                //char to String 변환
                String result = "";
                result += check;
                sb.add(result);
            }
        }
        return sb;

    }

    // 연산자 우선순위 반환
    public static int getOpPriority(char c) throws BadInputException {
        switch (c) {
            //곱셈, 나눗셈, 그리고 나머지 구하기는 제일 높은 순위
            case '*', '/', '%' -> { return 3;}
            //더하기, 빼기는 2번제 높은 순위
            case '+', '-' -> { return 2; }
            //제일 낮은 순위
            case '(' -> {return 1;}
            default -> {throw new BadInputException("제대로된 수식");}
        }
    }

    // 연산자 우선순위 비교
    public static int compareOp(char stackOp, char curOp) throws BadInputException {
        int stackOpPriority = getOpPriority(stackOp);
        int curOpPriority = getOpPriority(curOp);

        // 현재 우선순위가 더 높은 경우
        if (stackOpPriority < curOpPriority){
            return 1;
        }
        // 우선순위가 같은 경우
        else if (stackOpPriority == curOpPriority){
            return 0;
        }
        // 스택의 우선순위가 더 높은 경우
        else {
            return -1;
        }
    }

}
