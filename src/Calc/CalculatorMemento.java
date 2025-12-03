/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calc;

public class CalculatorMemento {

    private final String current;

    private final String previous;

    private final String operation;


    public CalculatorMemento(String current, String previous, String operation) {
        this.current = current;
        this.previous = previous;
        this.operation = operation;
    }


    public String getCurrent() {
        return current;
    }

  
    public String getPrevious() {
        return previous;
    }


    public String getOperation() {
        return operation;
    }
}
