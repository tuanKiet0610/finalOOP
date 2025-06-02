package basicstatistics;

import java.util.Arrays;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 8;
    private Object[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
    }
    //New constructor for initializing the data using an array
    public MyArrayList(Object[] data) {
        this.data = data;
        this.size = data.length;
    }

    /**
     * Lấy kích thước của list.
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * Xóa phần tử ở vị trí index trong list.
     * @param index
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        //Shift element from the end of the lift to the left
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        //The element at index size - 1 will be removed since the element has shifted to the left
        data[size-1] = null;
        size--;
    }

    /**
     * Thêm phần tử có dữ liệu payload vào cuối list.
     * Nếu danh sách hết chỗ, cấp phát thêm gấp đôi chỗ cho list.
     * @param payload
     */
    @Override
    public void append(Object payload) {
        if (size == data.length) {
            enlarge();
        }
        //The element at index size will be the new value since array is indexed from 0 to size - 1
        data[size] = payload;
        size++;
    }

    /**
     * Thêm phần tử có dữ liệu payload vào list ở vị trí index.
     * Nếu list hết chỗ, cấp phát thêm gấp đôi chỗ cho list.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Object payload, int index) {
        if (index == size) {
            append(payload);
            return;
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = payload;
        size++;
    }

    /**
     * Tạo iterator để có thể duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator() {
        return new MyArrayListIterator();
    }

    /**
     * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
     */
    private void enlarge() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    private class MyArrayListIterator implements MyIterator {
        /*
         * MyArrayListIterator cần phải biết vị trí hiện tại khi nó đang duyệt qua dữ liệu của MyArrayList.
         */
        private int currentPosition;

        /**
         * Khởi tạo dữ liệu cho Iterator vị trí đầu tiên của danh sách.
         * @param
         */
        public MyArrayListIterator() {
            currentPosition = 0;
        }

        /**
         * Kiểm tra trong MyArrayList có còn phần tử tiếp theo không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         * @return
         */
        @Override
        public boolean hasNext() {
            return data[currentPosition] != null;
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyArrayList và trả ra phần tử hiện tại của MyArrayList.
         * @return phần tử hiện tại.
         */
        @Override
        public Object next() {
            Object currentObj = data[currentPosition];
            currentPosition++;
            return currentObj;
        }

        /**
         * Iterator xóa phần tử hiện tại của MyArrayList.
         */
        @Override
        public void remove() {
            MyArrayList.this.remove(currentPosition);
            currentPosition = currentPosition - 1;
        }

        @Override
        public void reset() {
            currentPosition = 0;
        }
    }
}
