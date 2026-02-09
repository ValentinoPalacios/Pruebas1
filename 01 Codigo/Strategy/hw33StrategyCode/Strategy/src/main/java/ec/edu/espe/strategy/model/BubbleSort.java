package ec.edu.espe.strategy.model;

import java.util.Arrays;

/**
 *
 * @author Paulo Ramos
 */
public class BubbleSort implements SortingStrategy {
    
    public int [] sort (int data[]){
        System.out.println("Selected strategy BubbleSort");
        int[] arr = data.clone();
        Arrays.sort(arr);
        return arr;   
    }
}
