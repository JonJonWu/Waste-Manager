package waste_manager;

import javax.swing.JOptionPane;

/**
 * @Author Jonathan Wu
 * @Author Rajendra Bhagroo
 * @Class  CSCI 260 - W01
 * @Date   5/16/17
 */

class Stack
{
    private int maxSize = 16;
    private BSTNode[] stackArray;
    private int top;
	 
    /* Stack is used to populate Queue.
       Stack is instantiated in Waste_Manager class as rec_Stack.
       rec_Stack = Reccomendation_Stack
       Stack can be found in BST : custom_Search() and inorder() methods.*/
    
    
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
            JOptionPane.showMessageDialog(null,
                    stackArray.toString());
            
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

