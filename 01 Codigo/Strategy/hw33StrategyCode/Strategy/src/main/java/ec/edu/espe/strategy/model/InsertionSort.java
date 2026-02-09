package ec.edu.espe.strategy.model;

import java.util.Arrays;

/**
 *
 * @author Paulo Ramos
 */
public class InsertionSort implements SortingStrategy {
    
    public int[] sort(int data[]){
        System.out.println("Selected strategy InsertionSort");
        int[] arr = data.clone();
        Arrays.sort(arr);
        return arr; 
    }
    
}
