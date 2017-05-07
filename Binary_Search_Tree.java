package waste_manager;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author Jonathan Wu
 * @Author Rajendra Bhagroo
 * @Class  CSCI 260 - W01
 * @Date   4/15/17
 */

public class Binary_Search_Tree 
{   
}

 /* Class BSTNode */
 class BSTNode
 {
     BSTNode left;
     BSTNode right;
     String food_Name;
     int food_Price;
 
     /* Constructor */
     public BSTNode()
     {
         left = null;
         right = null;
         food_Name = "null";
         food_Price = -1;
     }
    
     /* Constructor */
     public BSTNode(String food)
     {
         left = null;
         right = null;
         food_Name = food;
         food_Price = -1;
     }
     
     /* Constructor */
     public BSTNode(int price)
     {
         left = null;
         right = null;
         food_Name = "null";
         food_Price = price;
     }
   
     /* Constructor */
     public BSTNode(String food, int price)
     {
         left = null;
         right = null;
         food_Name = food;
         food_Price = price;
     }
    
     /* Function to set left node */
     public void setLeft(BSTNode node)
     {
         left = node;
     }
    
     /* Function to set right node */
     public void setRight(BSTNode node)
     {
         right = node;
     }
     
     /* Function to get left node */
     public BSTNode getLeft()
     {
         return left;
     }
    
     /* Function to get right node */
     public BSTNode getRight()
     {
         return right;
     }
    
     /* Function to set food_Name to node */
     public void setFood(String food)
     {
         food_Name = food;
     }
    
     /* Function to get food_Name from node */
     public String getFood()
     {
         return food_Name;
     }    
    
     /* Function to set food_Price to node */
     public void setPrice(int price)
     {
         food_Price = price;
     }
    
     /* Function to get food_Price from node */
     public int getPrice()
     {
         return food_Price;
     } 
 }
 
                                                            
/* Class BST */
 class BST
 {
     private BSTNode root;
     
     /* Constructor */
     public BST()
     {
         root = null;
     }
     
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return root == null;
     }
     
     /* Functions to insert data */
     public void insert(String food, int price)
     {
         root = insert(root, food, price);
     }
     
     /* Function to insert data recursively */
     private BSTNode insert(BSTNode node,String food, int price)
     {
         if (node == null)
             node = new BSTNode(food,price);
         else
         {
             if (price <= node.getPrice())
             {
                 node.left = insert(node.left, food, price);
             }
             else
             {
                 node.right = insert(node.right, food, price);
             }
         }
         return node;
     }
     
     /* Functions to delete data */
     public void delete(int key)
     {
         if (isEmpty())
             System.out.println("Tree is Empty");
         else if (search(key) == false)
             System.out.println("Sorry "+ key +" is not present");
         else
         {
             root = delete(root, key);
             System.out.println(key + " deleted from the tree");
         }
     }
     
     private BSTNode delete(BSTNode root, int key)
     {
         BSTNode pointer, pointer2, node;
         if (root.getPrice() == key)
         {
             BSTNode left, right;
             left = root.getLeft();
             right = root.getRight();
             if (left == null && right == null)
                 return null;
             else if (left == null)
             {
                 pointer = right;
                 return pointer;
             }
             else if (right == null)
             {
                 pointer = left;
                 return pointer;
             }
             else
             {
                 pointer2 = right;
                 pointer = right;
                 while (pointer.getLeft() != null)
                     pointer = pointer.getLeft();
                 pointer.setLeft(left);
                 return pointer2;
             }
         }
         if (key < root.getPrice())
         {
             node = delete(root.getLeft(), key);
             root.setLeft(node);
         }
         else
         {
             node = delete(root.getRight(), key);
             root.setRight(node);            
         }
         return root;
     }
     
     /* Functions to count number of nodes */
     public int countNodes()
     {
         return countNodes(root);
     }
     
     /* Function to count number of nodes recursively */
     private int countNodes(BSTNode r)
     {
         if (r == null)
             return 0;
         else
         {
             int L = 1;
             L += countNodes(r.getLeft());
             L += countNodes(r.getRight());
             return L;
         }
     }
     
     /* Functions to search for an element */
     public boolean search(int value)
     {
         return search(root, value);
     }
     
     /* Function to search for an element recursively */
     private boolean search(BSTNode r, int value)
     {
         BSTNode found_Node = null;
         boolean found = false;
         while ((r != null) && !found)
         {
             int rval = r.getPrice();
             if (value < rval)
                 r = r.getLeft();
             else if (value > rval)
                 r = r.getRight();
             else
             {
                 found = true;
                 found_Node = r;
                 System.out.println("Name: " + found_Node.food_Name 
                                  + "\nPrice: $" + found_Node.food_Price);
                 break;
             }
             found = search(r, value);
         }
         return found;
     }
     
    //edit to push recommendations based off customer criteria, push onto stack 
    public boolean custom_Search(BSTNode r
                               , int val
                               , String crit
                               , Stack stack
                               , Queue queue
                               , LinkedList rec_Llist)
    {
         BSTNode found_Node = null;
         boolean found = false;
                  
         while ((r != null) && !found)
         {
             int rval = r.getPrice();
             
             //System.out.println("ROOT PRICE\n" + rval);
             if (val < rval)
             {
                 r = r.left;                
             }
             else if (val > rval)
             {
                 r = r.right;                 
             }
             //Value is found or takes too many traversals (Never existed)
             else 
             {                 
                 //JIM  WORKING
                 if(crit.equalsIgnoreCase("Wasteful"))
                 {
                     //Reccomendations will be less than the value entered
                     System.out.println("\nHere are our recommendations: Wasteful ");
                     
                     found = true;
                     found_Node = r;
     
                     inorder(root, val, stack, queue);    
                     
                 }              
                 //Lucy WORKING
                 else
                 {
                     //Reccomendations will be greater than the value entered
                     System.out.println("\nHere are our recommendations: Not Wasteful ");
                     
                     found = true;
                     found_Node = r;
                     
                     while (found_Node != null)
                     {                       
                         stack.push(found_Node);
                         queue.insert(stack.pop());
                         
                         System.out.println(queue.display_Node(found_Node));
                         found_Node = found_Node.getRight(); //FIX (64 is last node it does not have a left!)
                     }
                 
                 }
                 
                 break;
             }
             found = custom_Search(r, val, crit, stack, queue, rec_Llist);
             
         }//END WHILE LOOP
         
         return found;
    }
      
    
     /* Function for inorder traversal */
     public void inorder()
     {
         inorder(root);
     }
     
     public void inorder(BSTNode r)
     {
         if (r != null)
         {
             inorder(r.getLeft());
             
             inorder(r.getRight());
         }
     }
     
     public void inorder(BSTNode r, int val, Stack stack, Queue queue)
     {
         if ((r != null) && (r.getPrice () <= val))
         {
             inorder(r.getLeft(), val, stack, queue);
             stack.push(r);
             queue.insert(stack.pop());
             System.out.println("node = " + r.getFood() + "\n" + r.getPrice());
             inorder(r.getRight(), val, stack, queue);
         }
         
     }
      
     /* Function for preorder traversal */
     public void preorder()
     {
         preorder(root);
     }
     
     private void preorder(BSTNode r)
     {
         if (r != null)
         {
             System.out.print(r.getPrice() +" ");
             preorder(r.getLeft());            
             preorder(r.getRight());
         }
     }
     
     /* Function for postorder traversal */
     public void postorder()
     {
         postorder(root);
     }
     
     private void postorder(BSTNode r)
     {
         if (r != null)
         {
             postorder(r.getLeft());            
             postorder(r.getRight());
             System.out.print(r.getPrice() +" ");            
         }
     }
     
     //Function to display lowest priced food item
     public int display_First(BSTNode r)
     {
         while (r.getLeft() != null) //Traverses to left-most node
         {
              r = r.getLeft();
         }
         return r.getPrice();
     }
     
     //Function to display highest priced food item
     public int display_Last(BSTNode r)
     {
         while (r.getRight() != null) //Traverses to right-most node
         {
              r = r.getRight();
         }
         return r.getPrice();
     }
     
     public BSTNode get_Root()
     {
         return root;
     }
     
 }