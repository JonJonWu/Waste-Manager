package waste_manager;

public class Queue 
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
            System.out.println("\n" + Queue [ front ] + " : Has Been Deleted\n");
            
            /*Changes the value of the first element to "DELETED" for ensurance
              After shift() is called the user will never see "DELETED". */
               
            shift();                                                            
            numberOfItems --;
        }
        else
        {   
            System.out.println("\nCannot Remove Value");
            System.out.println("Queue is Empty");    
        }
    }
        
    public void peek()                                                          
    {
        System.out.print("Front of Queue: " + Queue[ front ] + "\n");     
    }
    
    //If there is no value to display, method displays "null"
    public void display()         
    {    
        System.out.println();
        
        for ( int i = 0 ; i < Queue.length ; i++ )
        {
            System.out.println("\tINDEX " + i + " : " + Queue[ i ].food_Name
            + "\n" + Queue[ i ].food_Price );
        }   
    }
    
    public void shift()                                                        
    {                                                                          
            for (int i = 0 ; i < numberOfItems; i++) 
            {    
                Queue[ i ] = Queue[i + 1];
            }       
    }
   
}//END OF CLASS QUEUE