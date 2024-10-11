package Caculrator;

import Caculrator.Operation.AddOperation;
import Caculrator.Operation.DivideOperation;
import Caculrator.Operation.MultiplyOperation;
import Caculrator.Operation.SubstractOperation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";
    private static final String NUMBER_REG2 = "^[-+]?(0|[1-9][0-9]*)(\\.[0-9]+)?([eE][-+]?[0-9]+)?$";

    public static void main(String[] args) {
        boolean calculateEnded = false;

        while (!calculateEnded) {
            try {
                calculateEnded = CalculatorApp.start();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}