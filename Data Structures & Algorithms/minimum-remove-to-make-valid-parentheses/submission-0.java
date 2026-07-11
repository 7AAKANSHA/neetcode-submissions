class Solution {
    public String minRemoveToMakeValid(String s) {

        // Stores the indices of unmatched '('
        Stack<Integer> stack = new Stack<>();

        // remove[i] = true means remove character at index i
        boolean[] remove = new boolean[s.length()];

        // -----------------------
        // First Pass
        // -----------------------
        // Find all invalid parentheses
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Ignore letters
            if (Character.isLetter(ch)) {
                continue;
            }

            // Opening parenthesis
            if (ch == '(') {

                // Store its index because it may need removal later
                stack.push(i);
            }

            // Closing parenthesis
            else if (ch == ')') {

                // No matching '(' exists
                if (stack.isEmpty()) {

                    // Mark this ')' for removal
                    remove[i] = true;
                }

                // Matching '(' exists
                else {

                    // Match it by removing the opening index
                    stack.pop();
                }
            }
        }

        // -----------------------
        // Any '(' left in stack are unmatched
        // -----------------------
        while (!stack.isEmpty()) {

            int index = stack.pop();

            remove[index] = true;
        }

        // -----------------------
        // Second Pass
        // -----------------------
        // Build answer by skipping removed indices
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (remove[i]) {
                continue;
            }

            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}