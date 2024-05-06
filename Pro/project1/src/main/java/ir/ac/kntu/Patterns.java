package ir.ac.kntu;

public class Patterns {
    private String intP = "(([0-9])+\\s*)+";
    private String floatP = "([+-]?(\\d+|\\d+\\.\\d+|\\.\\d+|\\d+\\.)([eE]\\d+)?\\s*)+";
    private String charP = "(\\'\\w{1}\\'\\s*)+";
    private String stringP = "(\\\"\\w{1,}\\\"\\s*)+";

    public String getIntP() {
        return intP;
    }

    public String getFloatP() {
        return floatP;
    }

    public String getCharP() {
        return charP;
    }

    public String getStringP() {
        return stringP;
    }
}
