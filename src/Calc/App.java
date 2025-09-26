package Calc;

/**
 *
 * @author youcefhmd
 */

public class App {

    public static void main(String[] args) {
    	// Using Singleton: We call getInstance() instead of new Calculator()
    	Calculator.getInstance().setVisible(true);

    }

}
