/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thecalculatorsystem;

import java.util.List;


public final class CalculatorFacade {

    private static Calculator calc = Calculator.getInstance();


  
    public static void appendNumber(String token) {
        calc.appendNumber(token);
    }

    public static void chooseOperation(String symbol) {
        calc.chooseOperation(symbol);
    }

    public static void compute() {
        calc.compute();
    }

    public static void clear() {
        calc.clear();
    }

    public static void backspace() {
        calc.backspace();
    }

    public static void toggleSign() {
        calc.toggleSign();
    }

    public static void clearCurrentIfError() {
        calc.clearCurrentIfError();
    }


    public static String getCurrent() {
        return calc.getCurrent();
    }

    public static String getPrevious() {
        return calc.getPrevious();
    }

    public static String getOperation() {
        return calc.getOperation();
    }
    public static List<String> getHistory() {
        return HistoryDecorator.getHistory();
    }
}
