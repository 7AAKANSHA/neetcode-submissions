class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int result []=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++)
        {
            int curr=temperatures[i];
            
            while(!stack.isEmpty() && curr>temperatures[stack.peek()])
            {
                int index =stack.pop();
                result[index]=i-index;
            }
            stack.push(i);
        }
    
    return result ;}

}
