package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        /**
         * toDo This is an arraylist of MyArray object to save users work
         */
        ArrayList<MyArray> toDo = new ArrayList<>(1);

        while (true) {
            /**
             * Scan what user wants to do, saved in "input"
             * then delete all spaces using String replace method, save
             * it as a Process
             */
            String input = new Scanner(System.in).nextLine();
            Process process = new Process(input.replaceAll("//s+", ""));
            String kind = process.getKindOfPro();

            /**
             * By its kind, program will continue
             */
            switch (kind) {
                /*
                 * declaration When the user want to declare a new array(MyArray)
                 * declare a MyArray
                 * find its kind using "kind of declaration" function
                 * split entered string to name and array part
                 * check if name fallows standard pattern or not
                 * if there is no problem, a new MyArray will add to toDo
                 * and print
                 */
                case "declaration": {
                    String[] nameAndArray = process.getInputPro().split("=");
                    if (Pattern.matches("([a-zA-Z]){1,}[\\w\\_]*", nameAndArray[0]) == false) {
                        System.out.println("invalid name");
                        return;
                    }
                    toDo.add(new MyArray(nameAndArray[0], nameAndArray[1]));
                    toDo.get(toDo.size() - 1).printMyArray();
                }

                /**
                 * changing When the user want to change an element of array(MyArray)
                 * split the process to name of the array wanted to change,
                 * index of the element wanted to change,
                 * new element,
                 * find the array in toDo
                 * use changingPro in MyArray class to change the element,
                 * then print changed array
                 */
                case "changing": {
                    String[] s = process.getInputPro().split("=");
                    String wantChangeName = s[0].substring(0, s[0].indexOf('['));
                    String wantChangeIndex = s[0].substring(s[0].indexOf('['));
                    MyArray changeArray = findArray(wantChangeName, toDo);
                    changeArray.changingPro(wantChangeIndex, s[1]);
                    changeArray.printMyArray();
                }

                /**
                 * find arrays which are plused by MyArray "name"
                 * check their kind, if it is not int or float, print an error
                 * if there is no error, make a MyArray,
                 * for its "array" use plus function in MyArray class
                 */
                case "plus": {
                    String[] twoArrPlus = process.getInputPro().split("\\+");
                    MyArray firstArr = findArray(twoArrPlus[0], toDo);
                    MyArray secondArr = findArray(twoArrPlus[1], toDo);
                    if (intOrFloat(firstArr.getKind()) == 0) {
                        System.out.println("wrong type");
                        return;
                    }
                    if (intOrFloat(secondArr.getKind()) == 0) {
                        System.out.println("wrong type");
                        return;
                    }
                    toDo.add(new MyArray(process.getInputPro(), firstArr.plus(secondArr)));
                    toDo.get(toDo.size() - 1).printMyArray();
                }
                case "minus": {
                    String[] twoArrMinus = process.getInputPro().split("\\-");
                    MyArray firstArr = findArray(twoArrMinus[0], toDo);
                    MyArray secondArr = findArray(twoArrMinus[1], toDo);
                    if (intOrFloat(firstArr.getKind()) == 0) {
                        System.out.println("wrong type");
                        return;
                    }
                    if (intOrFloat(secondArr.getKind()) == 0) {
                        System.out.println("wrong type");
                        return;
                    }
                    toDo.add(new MyArray(process.getInputPro(), firstArr.minus(secondArr)));
                    toDo.get(toDo.size() - 1).printMyArray();
                }
                case "times": {
                    String[] twoArrTimes = process.getInputPro().split("\\*");
                    MyArray firstArr = findArray(twoArrTimes[0], toDo);
                    MyArray secondArr = findArray(twoArrTimes[1], toDo);
                    if (intOrFloat(firstArr.getKind()) == 0) {
                        System.out.println("wrong type");
                        return;
                    }
                    if (intOrFloat(secondArr.getKind()) == 0) {
                        System.out.println("wrong type");
                        return;
                    }
                    toDo.add(new MyArray(process.getInputPro(), firstArr.times(secondArr)));
                    toDo.get(toDo.size() - 1).printMyArray();
                }
                case "divide": {
                    String[] twoArrDivide = process.getInputPro().split("/");
                    MyArray firstArr = findArray(twoArrDivide[0], toDo);
                    MyArray secondArr = findArray(twoArrDivide[1], toDo);
                    if (intOrFloat(firstArr.getKind()) == 0) {
                        System.out.println("wrong type");
                        return;
                    }
                    if (intOrFloat(secondArr.getKind()) == 0) {
                        System.out.println("wrong type");
                        return;
                    }
                    toDo.add(new MyArray(process.getInputPro(), firstArr.divide(secondArr)));
                    toDo.get(toDo.size() - 1).printMyArray();
                }
                case "link": {
                    String[] twoArrLinking = process.getInputPro().split("\\#");
                    MyArray firstArr = findArray(twoArrLinking[0], toDo);
                    MyArray secondArr = findArray(twoArrLinking[1], toDo);
                    if (charOrString(firstArr.getKind()) == 0) {
                        System.out.println("wrong type");
                        return;
                    }
                    if (charOrString(secondArr.getKind()) == 0) {
                        System.out.println("wrong type");
                        return;
                    }
                    toDo.add(new MyArray(process.getInputPro(), firstArr.link(secondArr)));
                    toDo.get(toDo.size() - 1).printMyArray();
                }
            }
        }
    }

    /**
     * This method find wanted MyArray
     *
     * @param wanted name of an array which wanted to find
     * @param list   arraylist of MyArray which search in
     * @return wanted array in list which is an arraylist
     */
    public static MyArray findArray(String wanted, ArrayList<MyArray> list) {
        for (MyArray arr : list) {
            if (arr.getName().equals(wanted)) {
                return arr;
            }
        }
        return null;
    }

    /**
     * This method check kind of Array to be int or float
     * If it is int or float return 1, else return 0 for wrong type
     */
    public static int intOrFloat(String kind) {
        if (kind != "intKind" && kind != "floatKind") {
            return 0;
        }
        return 1;
    }

    /**
     * This method check kind of Array to be char or String
     * If it is char or String return 1, else return 0 for wrong type
     */
    public static int charOrString(String kind) {
        if (kind != "charKind" && kind != "stringKind") {
            return 0;
        }
        return 1;
    }
}
