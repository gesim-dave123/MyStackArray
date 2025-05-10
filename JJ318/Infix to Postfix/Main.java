import javax.swing.*;

class Main {
    public static void main(String[] args) {
        boolean Continue = true;

        while (Continue) {
            String input = JOptionPane.showInputDialog(null, "Infix To PostFix\nMenu:\n1. Create\n0. Exit\nInput");

            if (input == null) {
                JOptionPane.showMessageDialog(null, "You cancelled the operation. Exiting program.");
                break;
            }

            switch (input) {
                case "1":
                    Create();
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Closing the program");
                    Continue = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Input");
            }
        }
    }

    public static void Create() {
        String infixExpression = JOptionPane.showInputDialog(null, "Input infix Expression (only single-digit numbers and + - * /):");
        if (infixExpression == null || infixExpression.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No expression entered.");
            return;
        }

        String postfix = convertToPostfix(infixExpression);
        String answer = ComputePostfix(postfix);
        JOptionPane.showMessageDialog(null, "The Postfix of the given Infix Expression is: " + postfix + "\nAnswer: " + answer);
    }

    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return 0;
    }

    public static String convertToPostfix(String exp) {
        StackNode operators = new StackNode();
        String result = "";

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                operators.push(ch);
            } else if (ch >= '0' && ch <= '9') {
                result = result + ch;             } else if (ch == ')') {
                while (!operators.isEmpty() && (char) operators.peek() != '(') {
                    result = result + operators.pop();
                }
                if (!operators.isEmpty() && (char) operators.peek() == '(') {
                    operators.pop();                 }
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                while (!operators.isEmpty() && precedence(ch) <= precedence((char) operators.peek())) {
                    result = result + operators.pop();
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            result = result + operators.pop();
        }

        return result;
    }

    public static String ComputePostfix(String postfix) {
        StackNode stack = new StackNode();
        int first, second, answer = 0;

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            if (ch >= '0' && ch <= '9') { 
                stack.push("" + ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                if (!stack.isEmpty()) {
                    second = Integer.parseInt(stack.pop().toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid postfix expression: Missing operand.");
                    return "Error";
                }
                if (!stack.isEmpty()) {
                    first = Integer.parseInt(stack.pop().toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid postfix expression: Missing operand.");
                    return "Error";
                }

                switch (ch) {
                    case '+':
                        answer = first + second;
                        break;
                    case '-':
                        answer = first - second;
                        break;
                    case '*':
                        answer = first * second;
                        break;
                    case '/':
                        if (second == 0) {
                            JOptionPane.showMessageDialog(null, "Division by zero is not allowed.");
                            return "Error";
                        }
                        answer = first / second;
                        break;
                    case '^':
                        answer = 1;
                        for (int j = 0; j < second; j++) {
                            answer *= first;
                        }
                        break;
                }

                stack.push("" + answer);
            }
        }

        if (!stack.isEmpty()) {
            return stack.pop().toString();
        } else {
            return "Error";
        }
    }
}

class MyNode {
    Object item;
    MyNode next;
}

class StackNode {
    MyNode top;

    public StackNode() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean push(Object o) {
        MyNode newNode = new MyNode();
        newNode.item = o;
        newNode.next = top;
        top = newNode;
        return true;
    }

    public Object pop() {
        if (isEmpty()) return null;
        Object item = top.item;
        top = top.next;
        return item;
    }

    public Object peek() {
        if (isEmpty()) return null;
        return top.item;
    }

    public String Display() {
        String result = "";
        MyNode temp = top;
        while (temp != null) {
            result = result + "[" + temp.item + "]\n";
            temp = temp.next;
        }
        return result;
    }
}
