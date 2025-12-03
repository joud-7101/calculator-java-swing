/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calc;

/**
 *
 * @author Asus
 */
public class ChooseOperationCommand implements Command {

    private final Calculator calc;
    private final String operation;

    public ChooseOperationCommand(Calculator calc, String operation) {
        this.calc = calc;
        this.operation = operation;
    }

    @Override
    public void execute() {
        CalculatorCaretaker.save(calc.saveState());

        calc.clearCurrentIfError();
        calc.chooseOperation(operation);
    }
}
