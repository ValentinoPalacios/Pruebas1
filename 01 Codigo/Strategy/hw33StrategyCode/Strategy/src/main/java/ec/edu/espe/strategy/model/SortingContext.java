package ec.edu.espe.strategy.model;

/**
 *
 * @author Paulo Ramos
 */
public class SortingContext {

    private SortingStrategy ss;

    public int[] sort(int data[]) {
        int size = data.length;
        ss = setSortStrategy(size);
        return ss.sort(data);
    }

    public SortingStrategy setSortStrategy(int n) {
        if (n > 0 && n < 30) {
            ss = new BubbleSort();
        }
        if (n >= 30 && n < 100) {
            ss = new InsertionSort();
        }
        if (n >= 100) {
            ss = new QuickSort();
        }
        return ss;
    }

    public String getStrategyName() {
        if (ss instanceof BubbleSort) {
            return "BubbleSort";
        }
        if (ss instanceof InsertionSort) {
            return "InsertionSort";
        }
        if (ss instanceof QuickSort) {
            return "QuickSort";
        }
        return "Unknown";
    }
}
