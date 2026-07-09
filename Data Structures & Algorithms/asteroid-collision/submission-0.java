class Solution {
    public int[] asteroidCollision(int[] asteroids) {
       
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            int curr = asteroids[i];
            boolean alive = true;

            while (!stack.isEmpty() && curr < 0 && stack.peek() > 0) {

                // Case 1 : Top is bigger
                if (stack.peek() > Math.abs(curr)) {

                    alive = false;
                    break;
                }

                // Case 2 : Current is bigger
                else if (Math.abs(curr) > stack.peek()) {

                    stack.pop();
                }

                // Case 3 : Equal size
                else {

                    stack.pop();
                    alive = false;
                    break;
                }
            }

            if (alive) {
                stack.push(curr);
            }
        }
               
        // Return part remaining
         int [] asteroid_result=new int[stack.size()];
         for(int i=stack.size()-1;i>=0;i--)
         {
            asteroid_result[i]=stack.pop();
         }
   return asteroid_result;
    }
}