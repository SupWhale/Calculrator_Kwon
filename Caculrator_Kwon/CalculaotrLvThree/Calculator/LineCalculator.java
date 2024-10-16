package Caculrator_Kwon.CalculaotrLvThree.Calculator;

import Caculrator_Kwon.CalculaotrLvThree.Operator.OperatorType;

import java.util.Stack;

public class LineCalculator {
    public static Number Calculate(String line){
        return (postfixCalculate(convPostfix(line)));
    }

    public static double postfixCalculate(String postfix){
        Stack stack = new Stack();
        char c = ' ';
        double op1 = 0;
        double op2 = 0;

        for(int i=0; i<postfix.length(); i++){
            c = postfix.charAt(i);

            // 숫자인 경우 스택에 저장
            if (Character.isDigit(c)){
                stack.push(c);
            }
            // 연산자인 경우 계산 후 스택에 저장
            else {
                op2 = Double.parseDouble(stack.pop().toString());
                op1 = Double.parseDouble(stack.pop().toString());
                OperatorType opType = OperatorType.FindOperatorType(Character.toString(c));
                switch (opType.getOperation()){
                    // op2에 먼저 pop한 이유는 후위 표기법으로 변환할 때 순서가 바뀌기 때문
                    // ex) 3+2 => 스택에 저장 시 3, 2 순으로 저장되는데 스택은 마지막에 push한
                    // 데이터가 가장 위에 있으므로
                    case "+":
                        stack.push(op1 + op2);
                        break;

                    case "-":
                        stack.push(op1 - op2);
                        break;

                    case "*":
                        stack.push(op1 * op2);
                        break;

                    case "/":
                        stack.push(op1 / op2);
                        break;

                    case "%":
                        stack.push(op1 % op2);
                        break;
                }
            }
        }

        return Double.parseDouble(stack.pop().toString());
    }

    public static String convPostfix(String infix){
        char c = ' ';
        Stack opStack = new Stack(); //수식 스택
        StringBuilder sb = new StringBuilder(); //변환된 후위식(리턴값)

        for(int i=0; i<infix.length(); i++){
            c = infix.charAt(i);

            // 숫자이면 StringBuilder sb에 추가한다.
            if (Character.isDigit(c)){
                sb.append(c);
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
                        check = (char) opStack.pop();
                        if (check == '(') {
                            break;
                        }
                        else {
                            sb.append(check);
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
                            sb.append(opStack.pop());
                        }
                        else {
                            break;
                        }
                    }
                    opStack.push(c);
                }
            }
        }

        char check = ' ';
        while(!opStack.isEmpty()) {
            check = (char) opStack.pop();
            if (check != '(') {
                sb.append(check);
            }
        }

        return sb.toString();
    }

    // 연산자 우선순위 반환
    public static int getOpPriority(char c){
        switch (c) {
            case '*' -> { return 3; }
            case '/' -> { return 3; }
            case '+'-> { return 2; }
            case '-' -> { return 2; }
            case '(' -> {return 1;}
            default -> {return -1;}
        }
    }

    // 연산자 우선순위 비교
    public static int compareOp(char stackOp, char curOp){
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
