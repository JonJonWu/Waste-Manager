package waste_manager;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author Jonathan Wu
 * @Author Rajendra Bhagroo
 * @Class  CSCI 260 - W01
 * @Date   4/15/17
 */

public class Waste_Manager 
{
        
    public static void main(String[] args) 
    {
        
       //Creating Binary Search Tree (BST)
       BST menu = new BST();
       create_Menu(menu);
       
       //Creating Stack (Length = 16 BSTNodes)
       Stack rec_Stack = new Stack();
      
       //Create Queue
       Queue rec_Queue = new Queue();
       
       //Create Linked List From Java API
       LinkedList<BSTNode> rec_Llist = new LinkedList<BSTNode>();
       
       //Initialize array options
       String[][] customer = new String[2][2];      
       fill_Array(customer);
       
       
       System.out.println("Welcome!, who will be ordering dinner today?");
       
       //Display array row1 (Names)
       System.out.println("1 : " + customer[0][0]
                                 + "\n2 : " + customer[0][1]);
       
       Scanner keyboard = new Scanner(System.in);
       
       int key = 0;
       boolean loop = false;
       
       int last = menu.display_Last(menu.get_Root());
       int first = menu.display_First(menu.get_Root());
       
       switch(keyboard.nextInt())
        {
            //Jim
            case 1:
                System.out.println("\nHello " + customer[0][0] 
                        + "!" +
                        " How much money are you willing to spend"
                        + " today?\n"
                        + "Value can range from: $" 
                        + first
                        + " - $" 
                        + last);

                
                while(!loop)
                {
                    //Input Must Be Integer
                    if(!keyboard.hasNextInt())
                     {
                         keyboard.next();
                         System.out.println("Please Enter A Valid Integer");
                     }
                    
                    //Input Must Be Integer Within Range
                    else if (key > last || key < first)
                    {
                        System.out.println("\nPlease Confirm Integer is"
                                         + " Within Valid Range"
                                         + "\nBy Entering Number Again"); 

                        key = keyboard.nextInt();  
                    }
                    else
                    {
                        loop =true;
                    }
                }

                menu.custom_Search(menu.get_Root()
                                    , key
                                    , customer[1][0]
                                    , rec_Stack
                                    , rec_Queue
                                    , rec_Llist);

                 break;

            //Lucy    
            case 2:
               System.out.println("\nHello " + customer[0][1] 
                        + "!" +
                        " How much money are you willing to spend"
                        + " today?\n"
                        + "Value can range from: $" 
                        + menu.display_First(menu.get_Root())
                        + " - $" 
                        + menu.display_Last(menu.get_Root()));

               
                while(!loop)
                {
                    //Input Must Be Integer
                    if(!keyboard.hasNextInt())
                     {
                         keyboard.next();
                         System.out.println("Please Enter A Valid Integer");
                     }
                    
                    //Input Must Be Integer Within Range
                    else if (key > last || key < first)
                    {
                        System.out.println("\nPlease Confirm Integer is"
                                         + " Within Valid Range"
                                         + "\nBy Entering Number Again"); 

                        key = keyboard.nextInt();  
                    }
                    else
                    {
                        loop =true;
                    }
                }

                menu.custom_Search(menu.get_Root()
                                    , key
                                    , customer[1][1]
                                    , rec_Stack
                                    , rec_Queue
                                    , rec_Llist);
                break;

            default: 
                System.out.println("Please enter a numeric value of "
                                 + "1 or 2" 
                                 + " \nRe-run Program");
                break;

        }


    }
    

     public static void fill_Array(String[][] customer)
    {
       //Names are in row 1
       customer[0][0] = "Jim";  //Wasteful
       customer[0][1] = "Lucy";  //Not Wasteful
       
       //Criteria of Wastefulness in row 2
       customer[1][0] = "Wasteful";
       customer[1][1] = "Not Wasteful";
    }
     
    //FOOD NAMES + PRICES
    public static void create_Menu(BST menu)
    {   
        /*
        //STEAKS
        menu.insert("Ribeye 8 oz", 12);
        menu.insert("T-bone 10 oz", 14);
        menu.insert("Strip 12 oz", 16);
        menu.insert("Beef Tenderloin 14 oz", 18);
       
        //LOBSTERS
        menu.insert("Maine 16 oz", 20);
        menu.insert("Langostino 20 oz", 24);
        menu.insert("Wood-Grilled 24 oz", 28);
        menu.insert("Seaport 32 oz", 36);
        
        //FISH
        menu.insert("Bass 32 oz", 36);
        menu.insert("Cod  40 oz", 44);
        menu.insert("Trout 48 oz", 52);
        menu.insert("Salmon 56 oz", 60);
        */
        
        //SIDES
        menu.insert("Rice 3 oz", 3);
        menu.insert("Fresh Vegetables 5 oz", 5);
        menu.insert("Fresh Fruits 6 oz", 6);
        menu.insert("Swallow's Nest 8 oz", 8);  
        
                //FISH
        menu.insert("Bass 10 oz", 10);
        menu.insert("Cod  12 oz", 12);
        menu.insert("Trout 14 oz", 14);
        menu.insert("Salmon 16 oz", 16);
        
                //LOBSTERS
        menu.insert("Maine 18 oz", 18);
        menu.insert("Langostino 20 oz", 20);
        menu.insert("Wood-Grilled 22 oz", 22);
        menu.insert("Seaport 24 oz", 24);
        
                //STEAKS
        menu.insert("Ribeye 25 oz", 25);
        menu.insert("T-bone 26 oz", 26);
        menu.insert("Strip 27 oz", 27);
        menu.insert("Beef Tenderloin 28 oz", 28);

        //MID value is 18  
    }
    
    
    //FIX custom_Search method

    /*
    Need to implement linked list.
    Need to implement bubble sort.

    Linked List will contain beverages and beverage prices.
    Implement Linked_List class from scratch
    
    custom_Search method needs work...
        1. What if value does not exist in tree?
        2. JIM not working in method
        
    I also changed our menu for testing purposes.
    
    I believe get_Left() does work, however we are traversing tree incorrectly.
    We do not need to go left, we need to go backwards (up) the tree.
    
    EXAMPLE. We are traversing tree to right and anyone of those right nodes
             could have a left node. Therfore the method works, becuase nothing
             is there.
      */  
       
    }