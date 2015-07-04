package HomeWork.HomeWork8.Task1;

import java.util.LinkedList;

public class PolishNotation {

    private LinkedList<Unit> stack = new LinkedList<>();
    private String input;
    private String output;

    public PolishNotation() {
    }

    private Unit getUnit(int pos) {
        label:
        for (int i = pos; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '+':
                    return new Unit(2, String.valueOf(ch), UnitType.PLUS);
                case '-':
                    return new Unit(2, String.valueOf(ch), UnitType.MINUS);
                case '*':
                    return new Unit(3, String.valueOf(ch), UnitType.MULTIPLY);
                case '/':
                    return new Unit(3, String.valueOf(ch), UnitType.DIVIDE);
                case '(':
                    return new Unit(1, String.valueOf(ch), UnitType.O_BRACKET);
                case ')':
                    return new Unit(1, String.valueOf(ch), UnitType.C_BRACKET);
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    StringBuilder sb = new StringBuilder(String.valueOf(ch));
                    while (true) {
                        if (++i >= input.length()) break;
                        ch = input.charAt(i);
                        if (isDigit(ch)) {
                            sb.append(ch);
                        } else return new Unit(0, sb.toString(), UnitType.DIGIT);
                    }
                    return new Unit(0, sb.toString(), UnitType.DIGIT);
                case ',':
                    continue label;
                default:
                    throw new IllegalArgumentException("Illegal character: " + ch);

            }
        }
        return null;
    }

    private boolean isDigit(char ch) {
        return (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4'
                || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9');
    }

    public String transform(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '+':
                case '-':
                case '*':
                case '/':
                case '(':
                case ')':
                    break;
                default:
                    throw new IllegalArgumentException("Illegal character: " + c);
            }

        }
        this.input = input;
        UnitIterator it = getIterator();
        StringBuffer sb = new StringBuffer("");
        while (it.hasNext()) {
            Unit currentUnit = it.next();
            switch (currentUnit.type) {
                case DIGIT:
                    sb.append(currentUnit.unit + ',');
                    break;
                case PLUS:
                case MINUS:
                case MULTIPLY:
                case DIVIDE:
                    caseA:
                    while (true) {
                        int highestPriority = 0;
                        for (Unit temp : stack) {
                            if (temp.priority >= highestPriority) {
                                highestPriority = temp.priority;
                            }
                        }
                        if (highestPriority < currentUnit.priority) {
                            stack.addLast(currentUnit);
                            break;
                        } else {
                            caseB:
                            if (!(stack.getLast().priority >= currentUnit.priority)) {
                                stack.addLast(currentUnit);
                                break;
                            }
                            ;
                            while (stack.getLast().priority >= currentUnit.priority) {
                                sb.append(stack.removeLast().unit + ',');
                            }

                            continue caseA;
                        }
                    }
                    break;
                case O_BRACKET:
                    stack.add(currentUnit);
                    break;
                case C_BRACKET:
                    while (!stack.isEmpty() && stack.getLast().type != UnitType.O_BRACKET) {
                        sb.append(stack.removeLast().unit + ',');
                    }
                    stack.removeLast();
                    break;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast().unit + ',');
        }

        return output = sb.toString();
    }

    private UnitIterator getIterator() {
        return new UnitIterator();
    }

    public LinkedList<Unit> getListOfUnits() {
        LinkedList<Unit> list = new LinkedList<>();
        UnitIterator it = getIterator();
        input = output;
        while (it.hasNext()) {
            list.add(it.next());
        }
        return list;
    }

    public enum UnitType {
        PLUS, MINUS, MULTIPLY, DIVIDE, DIGIT, O_BRACKET, C_BRACKET
    }

    public static class Unit {
        int priority;
        UnitType type;
        String unit;

        public Unit(int priority, String unit, UnitType type) {
            this.priority = priority;
            this.type = type;
            this.unit = unit;
        }

        @Override
        public String toString() {
            return "unit=" + unit;
        }
    }

    private class UnitIterator {
        int currentPos = 0;
        int lastSize = 0;


        public Unit next() {
            Unit unit = null;
            unit = getUnit(currentPos);
            lastSize = unit.unit.length();
            currentPos += unit.unit.length();
            currentPos = (input.equals(output)) ? ++currentPos : currentPos;
            return unit;
        }

        public boolean hasNext() {
            return getUnit(currentPos) != null;
        }

    }
}
