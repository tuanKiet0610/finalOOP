package candidatemanager;

import java.util.Arrays;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 2;
    private Object[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        /* TODO */
        this.data = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Lấy kích thước của list.
     * @return
     */
    @Override
    public int size() {
        /* TODO */
        return this.size;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        /* TODO */
        if (index >= size || index < 0) {
            return null;
        }
        return data[index];
    }

    /**
     * Sửa phần tử ở vị trí index là payload.
     * @param payload
     * @param index
     */
    @Override
    public void set(Object payload, int index) {
        /* TODO */
        if (index >= size|| index < 0){
            return;
        }
        data[index] = payload;
    }

    /**
     * Xóa phần tử ở vị trí index trong list.
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (index >= size|| index < 0){
            return;
        }
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    /**
     * Thêm phần tử có dữ liệu payload vào cuối list.
     * Nếu danh sách hết chỗ, cấp phát thêm gấp đôi chỗ cho list.
     * @param payload
     */
    @Override
    public void append(Object payload) {
        /* TODO */
        if (size == data.length) {
            enlarge();
        }
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
        /* TODO */
        if (index < 0 || index > size) {
            return;
        }
        if (data.length == size) {
            enlarge();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
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
        /* TODO */
        return new MyArrayListIterator();
    }

    /**
     * Cấp phát gấp đôi chỗ cho list khi cần thiết.
     */
    private void enlarge() {
        /* TODO */
        this.data = Arrays.copyOf(data, data.length * 2);
    }

    /*
     * Inner class implements the Iterator pattern
     */
    private class MyArrayListIterator implements MyIterator {
        /*
         * MyArrayListIterator cần phải biết vị trí hiện tại khi nó đang duyệt qua dữ liệu của MyArrayList.
         */
        private int currentPosition;

        /**
         * Khởi tạo dữ liệu cho Iterator bằng dữ liệu của MyArrayList để nó có thể duyệt qua các phần tử dữ liệu
         * của MyArrayList.
         */
        public MyArrayListIterator() {
            /* TODO */
            this.currentPosition = 0;
        }

        /**
         * Kiểm tra trong MyArrayList có còn phần tử tiếp theo không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         * @return
         */
        @Override
        public boolean hasNext() {
            /* TODO */
            return currentPosition < data.length && data[currentPosition] != null ;
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyArrayList và trả ra phần tử hiện tại của MyArrayList.
         * @return phần tử hiện tại.
         */
        @Override
        public Object next() {
            /* TODO */
            if (!hasNext()) {
                return null;
            }
            return data[currentPosition++];
        }

        /**
         * iterator xóa phần tử hiện tại của MyArrayList
         */
        @Override
        public void remove() {
            /* TODO */
            if (hasNext()) {
                for (int i = currentPosition; i < size; i++) {
                    data[i] = data[i + 1];
                }
                size--;
            }
        }
    }
}
