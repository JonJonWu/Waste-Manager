package waste_manager;

public class Queue extends BSTNode
{
    
    private BSTNode[] Queue;
    private int queueSize;
    private int numberOfItems;
    private int front;
    private int back;
    
    /* Front will always be set to 0, 
       This marks the first element in the array. 
       The first element is only altered by a call to the shift() method 
       Found in the remove() method  */
                                    
    
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
   
    public void shift()                                                        
    {                                                                          
            for (int i = 0 ; i < numberOfItems; i++) 
            {    
                Queue[ i ] = Queue[i + 1];
            }       
    }
   
    public void display_Node(Queue queue)
    {
        while(!queue.isEmpty())
        {
            System.out.println(queue.getFood()
                             + "\n"
                             + queue.getPrice());
            front--;
        }
    }
    
    public boolean isEmpty()
    {
        return numberOfItems == 0;
    }
    
    
    
}//END OF CLASS QUEUE