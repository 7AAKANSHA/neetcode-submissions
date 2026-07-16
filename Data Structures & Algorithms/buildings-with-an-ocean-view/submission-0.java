class Solution {
    public int[] findBuildings(int[] heights) {
     Stack<Integer>stack=new Stack<>();
         stack.push(heights.length-1);
        int max_height=heights[heights.length-1];
     for(int i =heights.length-2;i>=0;i--)
     {  int curr=heights[i];
       
        if(curr>max_height)
        {
            max_height=curr;
            stack.push(i);
           
        }
       
        
     }
     int []ans=new int[stack.size()];
     for(int i=0;i<ans.length;i++)
     {
        ans[i]=stack.pop();
     }
     return ans;
    }
}