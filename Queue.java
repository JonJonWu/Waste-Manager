package waste_manager;

public class Queue 
{
    
    private String[] Queue;
    private int queueSize;
    private int numberOfItems;
    private int front;                                                          // Front will always be set to 0, This marks the first element in the array. The first element is only altered by a call to the shift() method found in the remove() method
    private int back;
    
    
    public static void main(String[] args)
    {
        
        Queue queue1 = new Queue(10);
        queue1.insert("Raj");                                                   // First in Queue "Raj" , Index 0
        queue1.insert("Dan");                                       
        queue1.insert("James");
       
        queue1.peek();                                                          // Displays "Raj"
        queue1.display();
        queue1.remove();                                                        // Removes "Raj", Shifts "Dan" into Index 0 and "James" into Index 1
        
        queue1.peek();                                                          // Displays "Dan", Index 0
        queue1.display();
        queue1.remove();                                                        // Removes "Dan", Shifts "James" into Index 0 and "null" into Index 1
        
        queue1.peek();                                                          // Displays "James" at Index 0, Index 1-9 are null. queueSize is still 10. 
        queue1.display();
        
    }//END OF MAIN
    
    
    
    Queue(int size)                                                           // Constructor creates array
    {
        
        queueSize = size;
        Queue = new String[ queueSize ];
        
        numberOfItems = 0;                                                      // All values are set to 0, indicating the beggining of the queue
        front = 0;
        back = 0;
        
    }
    
    
    
    public void insert(String value)
    {
        
        if( numberOfItems + 1 <= queueSize )                                    // Tests to see if adding another item will not exceed array length
        {
            
            Queue[ back ] = value;                                              // Since back = 0,  value = front of array
           
            numberOfItems++;                                                    
            back++;        
            
        }
        
        else
        {
            
            System.out.println("\nCannot Insert: " + value);
            System.out.println("Queue is Full");
            
        }
        
    }
    
    
    
    public void priorityInsert()
    {
        
    }
    
    
    
    public void remove()
    {
        
        if ( numberOfItems > 0 )
        {
            
            System.out.println("\n" + Queue [ front ] + " : Has Been Deleted\n");   // FRONT ALWAYS = 0, which is the first index in the array. This code lets user know that the value at index 0 ( Front of Queue)  will be removed from the queue.
            
            Queue [ front ] = "DELETED";                                        // This code changes the value of the first element to "DELETED" for ensurance, after shift() is called the user will never see "DELETED".
                 
            shift();                                                            // Shifts all elements in array. Since first value ( Index 0 ) is deleted , the second value ( Index 1 ) becomes the first value ( Index 0 ), ect. 
            
            numberOfItems --;
            
        }
        
        else
        {
            
            System.out.println("\nCannot Remove Value");
            System.out.println("Queue is Empty"); 
            
        }
        
    }
    
    
    
    public void peek()                                                          // Displays Value that is first in the Queue ( Index 0 )
    {
        
        System.out.print("Front of Queue: " + Queue[ front ] + "\n");  
        
    }
    
    
    
    public void display()                                                       // This method visually displays the contents of the ENTIRE ARRAY ( Queue[] ), Listing each index and the value at each index, If there is no value the index will display "null"
    {
        
        System.out.println();
        
        for ( int i = 0 ; i < Queue.length ; i++ )
        {
            System.out.println("\tINDEX " + i + " : " + Queue[ i ]);
        }
        
    }
    
    
    
    public void shift()                                                         // Shifts all elements in array. Since first value ( Index 0 ) is deleted , the second value ( Index 1 ) becomes the first value ( Index 0 ), ect. 
    {                                                                           // This method is exclusively called within the remove() method. Logically, I isolated the function of array shifting into its own method for debugging purposes. 
            
            for (int i = 0 ; i < numberOfItems; i++) 
            {    
                
             Queue[ i ] = Queue[i + 1];
             
            }
            
    }
    
    
}//END OF CLASS MyQueue