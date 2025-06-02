package search;


public class BinarySearch implements Search {
    private static volatile BinarySearch instance;
    private Sorter sorter;

    private BinarySearch() {
        this.sorter = new SelectionSort();
    }

    /**
     * Tạo đối tượng BinarySearch.
     * @return
     */
    public static BinarySearch getInstance() {
        if (instance == null) {
            synchronized (BinarySearch.class) {
                if (instance == null) {
                    instance = new BinarySearch();
                }
            }
        }
        return instance;
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    @Override
    public int search(double[] data, double value) {
        sort(data);
        return binarySearch(data, value);
    }

    private int binarySearch(double[] data, double value) {
        /*
        We initialize low to be the first value(smallest value), high to be the last value(highest value)
         */
        int low = 0;
        int high = data.length - 1;
        while (low <= high){
            //Getting the middle index of the array and the middle element
            int middleIndex = (low + high) / 2;
            double middleIndexNumber = data[middleIndex];
            //If we already found the value we need at the middle element => early return
            if (value == middleIndexNumber){
                return middleIndex;
            }
            //If the value < middle element, we should only search for the left side of the array(0 to middleIndex - 1)
            if (value < middleIndexNumber){
                high = middleIndex - 1;
            }
            //If the value > middle element, we should only search for the right side of the array(middleIndex + 1 to length - 1)
            if (value > middleIndexNumber){
                low = middleIndex + 1;
            }
        }
        //If we cannot find the value we need, return -1: that element is not in the list
        return -1;
    }

    /*
    the order must be true - the data must be sorted in ascending order. Because we are initializing low to be the first
    element(smallest value(, high to be the last element(highest value)
     */
    private void sort(double[] data) {
        sorter.sort(data, true);
    }
}
