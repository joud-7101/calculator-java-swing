/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calc;

import java.util.Stack;

/**
 *
 * @author Asus
 */
public class CalculatorCaretaker {

    private static Stack<CalculatorMemento> history = new Stack<>();

    public static void save(CalculatorMemento memento) {
        history.push(memento);
    }

    public static CalculatorMemento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
