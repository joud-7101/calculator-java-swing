/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calc;

/**
 *
 * @author Asus
 */
public class ClearCommand implements Command {

  
    private final Calculator calc;


    public ClearCommand(Calculator calc) {
        this.calc = calc;
    }


    @Override
    public void execute() {
        CalculatorCaretaker.save(calc.saveState());

        calc.clear();
    }
}
