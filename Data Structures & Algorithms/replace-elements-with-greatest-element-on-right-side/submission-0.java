class Solution {
    public int[] replaceElements(int[] arr) {
       int maxSoFar=-1,current;
        for(int i=arr.length-1;i>=0;i--)
        {   
            current=arr[i];
             arr[i]=maxSoFar;
        maxSoFar=Math.max(current,maxSoFar);
       
           
        }
    return arr;
    }
   
}
/*Pattern:
Traverse from right while carrying maxSoFar

Time:
O(n)

Space:
O(1)

Mistake:
Updated maxSoFar before replacing arr[i]*/
