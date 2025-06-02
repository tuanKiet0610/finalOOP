package mybookmanager;

public class MyLinkedList extends MyAbstractList {
    private MyLinkedListNode head;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        this.head = new MyLinkedListNode(0);
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
        if (checkBoundaries(index)) {
            return null;
        }
        return getNodeByIndex(index).getPayload();
    }

    /**
     * Sửa phần tử ở vị trí index là payload.
     * @param payload
     * @param index
     */
    @Override
    public void set(Object payload, int index) {
        if (checkBoundaries(index) || payload == null) {
            return;
        }
        MyLinkedListNode currNode = getNodeByIndex(index);
        currNode.setPayload(payload);
    }

    /**
     * Xóa phần tử của list ở vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        if (checkBoundaries(index)) {
            return;
        }
        if (index == 0 || size == 1) {
            head = head.getNext();
        }
        else if (index == size - 1) {
            MyLinkedListNode prevNode = getNodeByIndex(size - 2);
            prevNode.setNext(null);
        }
        else {
            MyLinkedListNode prevNode = getNodeByIndex(index - 1);
            MyLinkedListNode currNode = getNodeByIndex(index);
            prevNode.setNext(currNode.getNext());
            currNode.setNext(null);
        }
        size--;
    }

    /**
     * Thêm vào cuối list phần tử có dữ liệu payload.
     * @param payload
     */
    @Override
    public void append(Object payload) {
        if (payload == null) {
            return;
        }
        MyLinkedListNode newNode = new MyLinkedListNode(payload);
        if (size == 0) {
            head = newNode;
        }
        else {
            MyLinkedListNode lastNode = getNodeByIndex(size - 1);
            lastNode.setNext(newNode);
        }
        size++;
    }

    /**
     * Thêm vào list phần tử có dữ liệu payload ở vị trí index.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Object payload, int index) {
        if (index == size) {
            append(payload);
            return;
        }
        if (checkBoundaries(index) || payload == null) {
            return;
        }
        MyLinkedListNode newNode = new MyLinkedListNode(payload);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        }
        else {
            MyLinkedListNode prevNode = getNodeByIndex(index - 1);
            MyLinkedListNode currNode = getNodeByIndex(index);
            prevNode.setNext(newNode);
            newNode.setNext(currNode);
        }
        size++;
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator() {
        return new MyLinkedListIterator();
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyLinkedListNode getNodeByIndex(int index) {
        MyLinkedListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    /*
     * Inner class implements the Iterator pattern
     */
    private class MyLinkedListIterator implements MyIterator {
        /*
         * MyLinkedListIterator cần phải biết vị trí hiện tại khi nó đang duyệt qua dữ liệu của MyLinkedList.
         */
        private int currentPosition;

        /**
         * Khởi tạo dữ liệu cho Iterator là vị trí node đầu tiên trong MyLinkedList.
         */
        public MyLinkedListIterator() {
            currentPosition = 0;
        }

        /**
         * Kiểm tra trong MyLinkedList có còn phần tử tiếp theo không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         * @return
         */
        @Override
        public boolean hasNext() {
            return getNodeByIndex(currentPosition) != null;
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyLinkedList và trả ra dữ liệu (payload) của phần tử hiện tại của MyLinkedList.
         * @return payload của phần tử hiện tại.
         */
        @Override
        public Object next() {
            Object currentObj = getNodeByIndex(currentPosition).getPayload();
            currentPosition++;
            return currentObj;
        }

        /**
         * iterator xóa phần tử hiện tại của MyLinkedList.
         */
        @Override
        public void remove() {
            MyLinkedList.this.remove(currentPosition);
        }
    }
}
