/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calc;

public class BackspaceCommand implements Command {

    private final Calculator calc;

    public BackspaceCommand(Calculator calc) {
        this.calc = calc;
    }

    @Override
    public void execute() {
        CalculatorCaretaker.save(calc.saveState());
        if ("Error".equals(calc.getCurrent())) {
            calc.clearCurrentIfError();
        } 
        else {
            calc.backspace();
        }
    }
}
