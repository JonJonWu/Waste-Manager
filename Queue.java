package waste_manager;

/**
 * @Author Jonathan Wu
 * @Author Rajendra Bhagroo
 * @Class  CSCI 260 - W01
 * @Date   5/16/17
 */

public class Queue extends BSTNode
{
    
    private BSTNode[] Queue;
    private int queueSize;
    private int numberOfItems;
    private int front;
    private int back;
    
    /* Queue is used to display BST menu reccomendations.
       Queue is instantiated in Waste_Manager class as rec_Queue.
       rec_Queue = Reccomendation_Queue
       Queue can be found in BST : custom_Search() and inorder() methods.*/
                                    
    
    // Constructor
    Queue()
    {
        queueSize = 16;
        Queue = new BSTNode[ queueSize ];
        
        numberOfItems = 0;                                      
        front = 0;
        back = 0;   
    }
     
    Queue(int size)
    {
        queueSize = size;
        Queue = new BSTNode[ queueSize ];
        
        numberOfItems = 0;                                      
        front = 0;
        back = 0;   
    }
    
    public void insert(BSTNode node)
    {
        // Tests to see if adding another item will not exceed array length
        if( numberOfItems + 1 <= queueSize )                                    
        {
            Queue[ back ] = node;                                            
           
            numberOfItems++;                                                    
            back++;           
        }
        else
        {   
            System.out.println("\nCannot Insert: " + node);
            System.out.println("Queue is Full");   
        }
    }
        
    public void remove()
    {
        if ( numberOfItems > 0 )
        {   
            numberOfItems --;
            shift();
            
        }
    }
        
    public void peek()                                                          
    {
        System.out.print("Front of Queue: " + Queue[ front ] + "\n");     
    }
   
    //Maintains order of array if an item is to be deleted
    public void shift()                                                        
    {                                                                          
            for (int i = 0 ; i < numberOfItems; i++) 
            {    
                Queue[ i ] = Queue[i + 1];
            }       
    }
   
    public String display_Node(BSTNode node)
    {
        return node.food_Name + "\n" + node.food_Price;
    }
    
    public boolean isEmpty()
    {
        return numberOfItems == 0;
    }
  
}//END OF CLASS QUEUE