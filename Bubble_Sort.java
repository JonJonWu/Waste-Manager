package waste_manager;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @Author Jonathan Wu
 * @Author Rajendra Bhagroo
 * @Class  CSCI 260 - W01
 * @Date   5/16/17
 */

    /* Bubble_Sort is used to sort linked_Drinks data structure.
       Bubble_Sort is instantiated in Waste_Manager class as bSort.
       bSort can be found in Waste_Manager : Uses bubbleSort() method.*/

public class Bubble_Sort extends BSTNode
{    
            
    public void bubbleSort(LinkedList<BSTNode> node_List) 
    {

    /*
     * In bubble sort, we basically traverse the array from first
     * to array_length - 1 position and compare the element with the next one.
     * Element is swapped with the next element if the next element is greater.
     * Bubble sort steps are as follows.
     * 1. Compare array[0] & array[1]
     * 2. If array[0] > array [1] swap it.
     * 3. Compare array[1] & array[2]
     * 4. If array[1] > array[2] swap it.
     * 5. Compare array[n-1] & array[n]
     * 6. if [n-1] > array[n] then swap it.
     * After this step we will have largest element at the last index.
     * Repeat the same steps for array[1] to array[n-1]
     */

        int length = node_List.size();
        int temp = 0;

        for(int i=0; i < length; i++)
        {
            for(int j=1; j < (length-i); j++)
            {
                if( node_List.get(j-1).getPrice() > node_List.get(j).getPrice())
                {
                        //swap the elements!
                        Collections.swap(node_List, j-1, j);
                }
            }
        }//END FOR LOOP
    }   
}
