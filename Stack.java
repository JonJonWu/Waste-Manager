package waste_manager;

class Stack
{
    private int maxSize = 16;
    private BSTNode[] stackArray;
    private int top;
	 
    public Stack()
    {
	stackArray = new BSTNode[maxSize];
	top = -1;
    }
    
    public void push(BSTNode node) 
    {
	stackArray[++top] = node;
    }
	   
    public BSTNode pop() 
    {
        return stackArray[top--];
    }
    
    public void popall() 
    {
        while( top > -1 )
        {
            System.out.println(stackArray.toString()); //FIX
            //System.out.println();
            stackArray[top--] = null;
        }
    }
	 
    public BSTNode peek() 
    {
        return stackArray[top];
    }
	  
    public boolean isEmpty() 
    {
	return (top == -1);
    }
	  
    public boolean isFull()
    {
	return (top == maxSize - 1);
    }   
    
     public String display_Node(BSTNode node)
     {
         return "\n" + node.food_Name 
       + "\n" + node.food_Price;
     }
}

