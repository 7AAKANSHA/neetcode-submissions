class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack=new Stack<>();
        String s;
        for(int i=0;i<logs.length;i++)
        {
            switch(logs[i])
            {
                case "../" -> {
                    if (!stack.isEmpty())
                {
                    stack.pop();
                }
                }
                case "./" -> { }
                
                
                default->{stack.push(logs[i]);}

                
        }
    }
            return stack.size();
            }
            }
        
      

