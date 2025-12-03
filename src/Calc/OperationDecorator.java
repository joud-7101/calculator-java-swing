/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calc;




public abstract class OperationDecorator implements Operation {
    protected final Operation wrappee;

    protected OperationDecorator(Operation wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public float applyOperation(float a, float b) {
        return wrappee.applyOperation(a, b);
    }
}

