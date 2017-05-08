package waste_manager;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author Jonathan Wu
 * @Author Rajendra Bhagroo
 * @Class  CSCI 260 - W01
 * @Date   5/16/17
 */

/*
    Program uses two additional EXTRA CREDIT ADT's 

    1. Binary Search Tree (BST)
    2. Binary Search ( see BST : custom_Search() method )
*/


public class Waste_Manager 
{
        
    public static void main(String[] args) 
    {
        
       /* Initialize and Fill Data Structures */
        
       //menu is Binary Search Tree (Uses Binary Search)
       BST menu = new BST();
       fill_Menu(menu);
       
       //Reccomendation Stack, and Queue
       Stack rec_Stack = new Stack();
       Queue rec_Queue = new Queue();
       
       LinkedList<BSTNode> linked_Drinks = new LinkedList<BSTNode>();
       fill_Drinks(linked_Drinks);
       
       //Bubble Sorts Linked List (Drinks)
       Bubble_Sort bSort = new Bubble_Sort();
       bSort.bubbleSort(linked_Drinks);      
       
       //Initialize array options
       String[][] customer = new String[2][2];      
       fill_Array(customer);
       
       
       /*
            Software is implemented in a tableside interface at restaurant. 
            Program begins when all members of table (Who are ordering)
            swips credit/debit cards.
       */
       
       
       System.out.println("Welcome!, who will be ordering first?");
       
       //Display array row1 (Names)
       System.out.println("1 : " + customer[0][0]
                                 + "\n"
                                 + "2 : " + customer[0][1]);
       
       Scanner keyboard = new Scanner(System.in);
       
       //Search Key
       int key = 0;
       boolean loop = false;
       
       //First and Last nodes of BST
       int last = menu.display_Last(menu.get_Root());
       int first = menu.display_First(menu.get_Root());
       
       
       switch(keyboard.nextInt())
        {
            //Jim WASTEFUL
            case 1:
                System.out.println("\nHello " + customer[0][0] + "!" 
                        + " How much money are you willing to spend"
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

                        //Search Key : used to find specific node in BST
                        key = keyboard.nextInt();  
                    }
                    
                    //Continue Looping
                    else
                    {
                        loop = true;
                    }
                }

                //Searches for node using key, returns recommendations
                menu.custom_Search(menu.get_Root()
                                    , key
                                    , customer[1][0]
                                    , rec_Stack
                                    , rec_Queue);
                
                
                System.out.println("\n\nHere is our selection of beverages");
                
                //Displays entire selection of beverages
                while(!linked_Drinks.isEmpty())
                {
                   System.out.println(linked_Drinks.peek().getFood()
                   + "\n"
                   + linked_Drinks.peek().getPrice());
                   
                   linked_Drinks.remove();        
                }

                 break;

                 
            //Lucy NOT WASTEFUL    
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

                        //Search Key : used to find specific node in BST
                        key = keyboard.nextInt();  
                    }
                    
                    //Continue Looping
                    else
                    {
                        loop =true;
                    }
                }
                
                
                //Searches for node using key, returns recommendations
                menu.custom_Search(menu.get_Root()
                                    , key
                                    , customer[1][1]
                                    , rec_Stack
                                    , rec_Queue);
                
                
                 System.out.println("\n\nHere is our selection of beverages");
                
                //Displays entire selection of beverages
                while(!linked_Drinks.isEmpty())
                {
                   System.out.println(linked_Drinks.peek().getFood()
                   + "\n"
                   + linked_Drinks.peek().getPrice());
                   
                   linked_Drinks.remove();        
                }

                break;

            default: 
                System.out.println("\nPlease enter a numeric value of "
                                 + "1 or 2" 
                                 + " \nRe-run Program");
                break;

        }//END SWITCH
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
     

    public static void fill_Menu(BST menu)
    {   
        //STEAKS
        menu.insert("Ribeye 8 oz", 12);
        menu.insert("T-bone 10 oz", 14);
        menu.insert("Strip 12 oz", 16);
        menu.insert("Beef Tenderloin 14 oz", 18);
       
        //LOBSTERS
        menu.insert("Maine 16 oz", 20);
        menu.insert("Langostino 20 oz", 24);
        menu.insert("Wood-Grilled 24 oz", 28);
        menu.insert("Seaport 32 oz", 32);
        
        //FISH
        menu.insert("Bass 32 oz", 36);
        menu.insert("Cod  40 oz", 44);
        menu.insert("Trout 48 oz", 52);
        menu.insert("Salmon 56 oz", 60);
           
        //SIDES
        menu.insert("Rice 3 oz", 3);
        menu.insert("Fresh Vegetables 5 oz", 5);
        menu.insert("Fresh Fruits 6 oz", 6);
        menu.insert("Swallow's Nest 8 oz", 8);  
    }
    
    public static void fill_Drinks(LinkedList linked_Drinks)
    {
        linked_Drinks.offer(new BSTNode("Sprite", 3));
        linked_Drinks.offer(new BSTNode("Coca Cola", 2));
        linked_Drinks.offer(new BSTNode("Pepsi", 4));
        linked_Drinks.offer(new BSTNode("Tea", 1));
        linked_Drinks.offer(new BSTNode("Water", 0));
        linked_Drinks.offer(new BSTNode("Coffee", 3));
        linked_Drinks.offer(new BSTNode("House Cocktail", 7));
        linked_Drinks.offer(new BSTNode("Mojito", 8));
    }
    
}//END OF CLASS
