/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calc;




import Calc.AddOperation;
import java.util.ArrayList;
import java.util.List;

public class HistoryDecorator extends OperationDecorator {

    private static List<String> history =new ArrayList<>();

    public HistoryDecorator(Operation op) {
        super(op);
    }

    @Override
    public float applyOperation(float a, float b) {
        float result = super.applyOperation(a, b);
        history.add(format(a, b, wrappee, result));
        return result;
    }

    private  String format(float a, float b, Operation op, float r) {
        return printable(a) + " " + symbol(op) + " " + printable(b) + " = " + printable(r);
    }
    
    private  String printable(float x) {
        return (x == (int) x) ? Integer.toString((int) x) : Float.toString(x);}

    private static String symbol(Operation op) {
        if (op instanceof AddOperation)      return "+";
        if (op instanceof SubtractOperation) return "-";
        if (op instanceof MultiplyOperation) return "×";
        if (op instanceof DivideOperation)   return "÷";
        return "?";
    }

    public static List<String> getHistory() {
        synchronized (history) {
            return new ArrayList<>(history);
        }
    }

}
