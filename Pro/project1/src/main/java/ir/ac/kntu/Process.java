package ir.ac.kntu;

import java.util.regex.Pattern;

public class Process {
    /**
     * Process This class give the String user entered and set them as a process
     *
     * @param inputPro is what user entered
     * @param kindOfPro is kind of process which set using kindOfProcess methode
     */
    private String inputPro;
    private String kindOfPro;

    public Process(String inputPro) {
        this.inputPro = inputPro;
        kindOfPro = kindOfProcess();
    }

    public String getInputPro() {
        return inputPro;
    }

    public String getKindOfPro() {
        return kindOfPro;
    }

    /**
     * Find the kind of work which user enter
     * if user enter a String(name) and '=', so it is a declaration
     * if user enter a String(name) followed by pattern "[an int][and int] ...", and '=',
     * then a value, so user wants to change an element
     * For int and float : '+' for plus process, '-' for minus process, '*' for times process,
     * '/' for divide process
     * For char and String : '#' for concat(link) process
     * Otherwise it will return error
     */

    private String kindOfProcess() {
        if (Pattern.matches("([a-z])+\\d*\\-*\\={1}.+", this.getInputPro())) {
            return "declaration";
        }
        if (Pattern.matches("([a-z])+\\d*\\-*(\\[\\d+\\])+\\=.+", this.getInputPro())) {
            return "changing";
        }
        if (this.getInputPro().contains("+")) {
            return "plus";
        }
        if (this.getInputPro().contains("-")) {
            return "minus";
        }
        if (this.getInputPro().contains("*")) {
            return "times";
        }
        if (this.getInputPro().contains("/")) {
            return "divide";
        }
        if (this.getInputPro().contains("#")) {
            return "link";
        }
        return "process error";
    }
}
