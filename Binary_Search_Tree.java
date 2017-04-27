package waste_manager;
import java.util.Scanner;

/**
 * @Author Jonathan Wu
 * @Author Rajendra Bhagroo
 * @Class  CSCI 260 - W01
 * @Date   4/15/17
 */

/*  Presents user with ($ low food - High food $). [Asks how much they want 
    to spend, Adjusts menu accordingly] This will contain Food Names/Prices */

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
                 node.left = insert(node.left, food, price);
             else
                 node.right = insert(node.right, food, price);
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
     
     
     /* Function for inorder traversal */
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(BSTNode r)
     {
         if (r != null)
         {
             inorder(r.getLeft());
             System.out.print(r.getPrice() +" ");
             inorder(r.getRight());
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
     
     public int display_First(BSTNode r)
     {
         if (r != null)
         {
            r.getLeft();
         }
         return r.getPrice();
     }
     
     public int display_Last(BSTNode r)
     {
         if (r != null)
         {
            r.getRight();
         }
         return r.getPrice();
     }
     
     public BSTNode get_Root()
     {
         return root;
     }
 }