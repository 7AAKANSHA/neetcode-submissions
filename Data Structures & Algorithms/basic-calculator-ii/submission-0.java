class Solution {

    public int calculate(String s) {

        s = s.trim();

        int waiting = 0;
        int current = 0;
        int leftOperand = 0;

        char pendingAddSub = '+';
        char pendingMulDiv = ' ';

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == ' ')
                continue;

            if (Character.isDigit(ch)) {
                current = current * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {

                if (ch == '*' || ch == '/') {

                    if (pendingMulDiv == ' ') {
                        leftOperand = current;
                    } else if (pendingMulDiv == '*') {
                        leftOperand = leftOperand * current;
                    } else {
                        leftOperand = leftOperand / current;
                    }

                    pendingMulDiv = ch;
                    current = 0;
                } else {

                    // Finish any pending * or /
                    if (pendingMulDiv == '*') {
                        leftOperand = leftOperand * current;
                    } else if (pendingMulDiv == '/') {
                        leftOperand = leftOperand / current;
                    } else {
                        leftOperand = current;
                    }

                    // Apply + or -
                    if (pendingAddSub == '+') {
                        waiting += leftOperand;
                    } else {
                        waiting -= leftOperand;
                    }

                    // Prepare for next term
                    if (ch == '+' || ch == '-') {
                        pendingAddSub = ch;
                    }

                    pendingMulDiv = ' ';
                    current = 0;
                    leftOperand = 0;
                }
            }
        }

        return waiting;
    }
}