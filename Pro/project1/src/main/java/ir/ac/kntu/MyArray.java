package ir.ac.kntu;

import java.util.regex.Pattern;

public class MyArray {
    private String name;
    private String array;
    private String kind;
    private int dimension;
    private int[] size;

    /**
     * make a new constructor
     * It gets "name" and "array" and "kind of Declaration" and set them
     */
    public MyArray(String name, String array) {
        this.name = name;
        this.array = array;
        this.kind = kindOfArray(array);
        this.calculateDimension();
        this.settingSize(0);
    }

    public String getKind() {
        return kind;
    }

    public String getName() {
        return name;
    }

    public String getArray() {
        return array;
    }

    private void setArray(String array) {
        this.array = array;
    }

    /**
     * set dimension of input array by counting '['
     */
    private void calculateDimension() {
        String array = this.array;
        int d = 0;
        for (d = 0; array.charAt(d) == '['; d++) {
        }
        this.dimension = d;
    }

    /**
     * Calculate size of array
     */
    private int i = dimension;
    private String input = deleteElements("");

    private int settingSize(int j) {
        if (j == dimension - 1) {
            for (; input.charAt(i) != ']'; i++) {
                if (input.charAt(i) == ',') {
                    size[j]++;
                }
            }
            return (size[j] + 2);
        }
        int n = settingSize(j + 1);
        i++;
        for (; input.charAt(i) != ']'; i += n) {
            if (input.charAt(i) == ',') {
                size[j]++;
            }
        }
        return 0;
    }

    /**
     * @return String which all elements of array replace with replacement
     */
    private String deleteElements(String replacement) {
        String kind = this.kind;
        Patterns p = new Patterns();
        switch (kind) {
            case "intKind": {
                return (array.replaceAll(p.getIntP(), replacement));
            }
            case "floatKind": {
                return (array.replaceAll(p.getFloatP(), replacement));
            }
            case "charKind": {
                return (array.replaceAll(p.getCharP(), replacement));
            }
            case "stringKind": {
                return (array.replaceAll(p.getStringP(), replacement));
            }
        }
        return "error";
    }

    /**
     * @return array part of a MyArray which is the result of two MyArray plus
     */
    public String plus(MyArray second) {
        String[] firstNums = extractElements(this.getArray(), "");
        String[] secondNums = extractElements(second.getArray(), "");
        String[] numOfResult = {};
        if (this.getKind().equals("floatKind")) {
            for (int i = 0; i < firstNums.length; i++) {
                numOfResult[i] = Float.toString(Float.parseFloat(firstNums[i]) + Float.parseFloat(secondNums[i]));
            }
        }
        if (this.getKind().equals("intKind")) {
            for (int i = 0; i < firstNums.length; i++) {
                numOfResult[i] = Integer.toString(Integer.parseInt(firstNums[i]) + Integer.parseInt(secondNums[i]));
            }
        }
        String result = this.deleteElements(" ");
        int j = 0;
        for (int i = 0; i < result.length(); i++) {
            if (Character.compare(result.charAt(i), ' ') == 0) {
                result = result.substring(0, i) + numOfResult[j] + result.substring(i + 1);
                j++;
            }
        }
        return result;
    }

    /**
     * @return array part of a MyArray which is the result of two MyArray minus
     */
    public String minus(MyArray second) {
        String[] firstNums = extractElements(this.getArray(), "");
        String[] secondNums = extractElements(second.getArray(), "");
        String[] numOfResult = {};
        if (this.getKind().equals("floatKind")) {
            for (int i = 0; i < firstNums.length; i++) {
                numOfResult[i] = Float.toString(Float.parseFloat(firstNums[i]) - Float.parseFloat(secondNums[i]));
            }
        }
        if (this.getKind().equals("intKind")) {
            for (int i = 0; i < firstNums.length; i++) {
                numOfResult[i] = Integer.toString(Integer.parseInt(firstNums[i]) - Integer.parseInt(secondNums[i]));
            }
        }
        String result = this.deleteElements(" ");
        int j = 0;
        for (int i = 0; i < result.length(); i++) {
            if (Character.compare(result.charAt(i), ' ') == 0) {
                result = result.substring(0, i) + numOfResult[j] + result.substring(i + 1);
                j++;
            }
        }
        return result;
    }

    /**
     * @return array part of a MyArray which is the result of two MyArray times
     */
    public String times(MyArray second) {
        String[] firstNums = extractElements(this.getArray(), "");
        String[] secondNums = extractElements(second.getArray(), "");
        String[] numOfResult = {};
        if (this.getKind().equals("floatKind")) {
            for (int i = 0; i < firstNums.length; i++) {
                numOfResult[i] = Float.toString(Float.parseFloat(firstNums[i]) * Float.parseFloat(secondNums[i]));
            }
        }
        if (this.getKind().equals("intKind")) {
            for (int i = 0; i < firstNums.length; i++) {
                numOfResult[i] = Integer.toString(Integer.parseInt(firstNums[i]) * Integer.parseInt(secondNums[i]));
            }
        }
        String result = this.deleteElements(" ");
        int j = 0;
        for (int i = 0; i < result.length(); i++) {
            if (Character.compare(result.charAt(i), ' ') == 0) {
                result = result.substring(0, i) + numOfResult[j] + result.substring(i + 1);
                j++;
            }
        }
        return result;
    }

    /**
     * @return array part of a MyArray which is the result of two MyArray divide
     */
    public String divide(MyArray second) {
        String[] firstNums = extractElements(this.getArray(), "");
        String[] secondNums = extractElements(second.getArray(), "");
        String[] numOfResult = {};
        if (this.getKind().equals("floatKind")) {
            for (int i = 0; i < firstNums.length; i++) {
                numOfResult[i] = Float.toString(Float.parseFloat(firstNums[i]) / Float.parseFloat(secondNums[i]));
            }
        }
        if (this.getKind().equals("intKind")) {
            for (int i = 0; i < firstNums.length; i++) {
                numOfResult[i] = Integer.toString(Integer.parseInt(firstNums[i]) / Integer.parseInt(secondNums[i]));
            }
        }
        String result = this.deleteElements(" ");
        int j = 0;
        for (int i = 0; i < result.length(); i++) {
            if (Character.compare(result.charAt(i), ' ') == 0) {
                result = result.substring(0, i) + numOfResult[j] + result.substring(i + 1);
                j++;
            }
        }
        return result;
    }

    /**
     * @return array part of a MyArray which is the result of two MyArray linking
     */
    public String link(MyArray second) {
        String[] firstArr = extractElements(this.getArray(), this.getKind());
        String[] secondArr = extractElements(second.getArray(), second.getKind());
        String[] stringOfResult = {};
        for (int i = 0; i < firstArr.length; i++) {
            stringOfResult[i] = firstArr[i] + secondArr[i];
        }
        String result = this.deleteElements(" ");
        int j = 0;
        for (int i = 0; i < result.length(); i++) {
            if (Character.compare(result.charAt(i), ' ') == 0) {
                result = result.substring(0, i) + stringOfResult[j] + result.substring(i + 1);
                j++;
            }
        }
        return result;
    }

    /**
     * @return elements of array, which is the array part of a MyArray
     */
    private String[] extractElements(String array, String kind) {
        String[] regexes = {"\\[", "]", ","};
        String[] replaces = {"", "", " "};
        array = multiReplace(array, regexes, replaces);
        if (kind.equals("charKind")) {
            array.replaceAll("\'", "");
        }
        if (kind.equals("stringKind")) {
            array.replaceAll("\"", "");
        }
        String[] elements = array.split(" ");
        return elements;
    }

    /**
     * This method update MyArray
     *
     * @param index   This is the index of the element wanted to change
     * @param replace The element which replace old element of index
     */
    public void changingPro(String index, String replace) {
        String[] newElements = extractElements(this.getArray(), this.getKind());
        String newArray = this.deleteElements(" ");
        index = index.replaceAll("\\[", "");
        index = index.replaceAll("]", " ");
        String[] indexNum = index.split(" ");
        int[] numOfIndex = {};
        for (int i = 0; i < indexNum.length; i++) {
            numOfIndex[i] = Integer.parseInt(indexNum[i]);
        }
        int changeIndex = 0;
        int save = 0;
        for (int i = 0; i < numOfIndex.length; i++) {
            for (int j = i + 1; j < this.size.length; j++) {
                save *= size[i];
            }
            changeIndex += numOfIndex[i] * save;
        }
        for (int i = 0; i < newElements.length; i++) {
            if (i == changeIndex) {
                newElements[i] = replace;
                break;
            }
        }
        int j = 0;
        for (int i = 0; i < newArray.length(); i++) {
            if (Character.compare(newArray.charAt(i), ' ') == 0) {
                newArray = newArray.substring(0, i) + newElements[j] + newArray.substring(i + 1);
                j++;
            }
        }
        this.setArray(newArray);
    }

    /*
     * This function find the kind of Array: integer, float, character,
     * or String
     * there is an error if it doesn't match any kind
     */
    private static String kindOfArray(String input) {
        String[] regexes = {"\\[", "]", ","};
        String[] replaces = {"", "", " "};
        input = multiReplace(input, regexes, replaces);

        Patterns p = new Patterns();

        if (Pattern.matches(p.getIntP(), input)) {
            return "intKind";
        }
        if (Pattern.matches(p.getFloatP(), input)) {
            return "floatKind";
        }
        if (Pattern.matches(p.getCharP(), input)) {
            return "charKind";
        }
        if (Pattern.matches(p.getStringP(), input)) {
            return "stringKind";
        }
        return "error";
    }

    /**
     * multiReplace This method replace multi regex pattern
     *
     * @param string
     * @param regex
     * @param replacement
     * @return string which changed
     */
    private static String multiReplace(String string, String[] regex, String[] replacement) {
        for (int i = 0; i < regex.length; i++) {
            string = string.replaceAll(regex[i], replacement[i]);
        }
        return string;
    }

    /**
     * This method print MyArray
     */
    public void printMyArray() {
        if (this.getKind().equals("error")) {
            System.out.println("unknown type");
            return;
        }
        String printArray = this.getArray().replaceAll("],\\[", "][");
        printArray = printArray.replaceAll(",", " ");
        System.out.println(printArray);
    }
}
