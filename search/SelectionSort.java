package search;

public class SelectionSort implements Sorter {
    /**
     * Phương thức sắp xếp dữ liệu sử dụng thuật toán Selection sort.
     * @param data
     * @param order: true sắp xếp theo thứ tự tăng dần, false sắp xếp theo thứ tự giảm dần.
     */
    @Override
    public void sort(double[] data, boolean order) {
        if (order) {
            sortAscending(data);
        }
        else {
            sortDescending(data);
        }
    }


    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự tăng dần,
     * sử dụng thuật toán Selection sort.
     * @param data
     */
    private void sortAscending(double[] data) {
        int n = data.length;
        //This is from Geeks for Geeks, none of the code is copied from other students.
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i+1; j < n; j++)
                if (data[j] < data[minIndex])
                    minIndex = j;

            // Swap the found minimum element with the first
            // element
            double temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự giảm dần,
     * sử dụng thuật toán Selection sort.
     * @param data
     */
    private void sortDescending(double[] data) {
        int n = data.length;
        //This is from Geeks for Geeks, none of the code is copied from other students.
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the maximum element in unsorted array
            int maxIndex = i;
            for (int j = i+1; j < n; j++)
                if (data[j] > data[maxIndex])
                    maxIndex = j;

            // Swap the found minimum element with the first
            // element
            double temp = data[maxIndex];
            data[maxIndex] = data[i];
            data[i] = temp;
        }
    }
}
