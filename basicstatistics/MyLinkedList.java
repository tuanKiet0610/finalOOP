package basicstatistics;

public class MyLinkedList extends MyAbstractList {
    private MyLinkedListNode head;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        //Default value for head = 0
        this.head = new MyLinkedListNode(0);
        this.size = 0;
    }
    public MyLinkedList(Object[] data) {
        for (Object object: data) {
            append(object);
        }
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
        return getNodeByIndex(index).getPayload();
    }

    /**
     * Xóa phần tử của list ở vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        //If removing the element at index 0, make the next element of the old head the new head
        if (index == 0) {
            head = head.getNext();
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
        MyLinkedListNode newNode = new MyLinkedListNode(payload);
        if (size == 0) {
            //If the linked list is empty, init the new element as the head
            this.head = newNode;
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
        //If the index is the size of the LL or the list is empty, then call the append function which will handle the
        //case of init the head element
        if (index == size || size == 0) {
            append(payload);
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
        return new MyLinkedListIterator(head);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyLinkedListNode getNodeByIndex(int index) {
        //This function does not have to worry about the index out of bounds
        MyLinkedListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    private class MyLinkedListIterator implements MyIterator {
        /*
         * MyLinkedListIterator cần phải tham chiếu đến node hiện tại của MyLinkedList để có thể duyệt qua
           các phần tử còn lại trong MyLinkedList.
        */
        private MyLinkedListNode currentNode;
        private MyLinkedListNode head;

        /**
         * Khởi tạo dữ liệu cho Iterator là node hiện tại trong MyLinkedList.
         * @param node
         */
        public MyLinkedListIterator(MyLinkedListNode node) {
            this.currentNode = node;
            this.head = node;
        }

        /**
         * Kiểm tra trong MyLinkedList có còn phần tử tiếp theo không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         * @return
         */
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyLinkedList và trả ra dữ liệu (payload) của phần tử hiện tại của MyLinkedList.
         * @return payload của phần tử hiện tại.
         */
        @Override
        public Object next() {
            Object currObj = currentNode.getPayload();
            currentNode = currentNode.getNext();
            return currObj;
        }

        @Override
        public void remove() {
            MyLinkedListNode temp = head;
            while (temp.getNext() != currentNode) {
                temp = temp.getNext();
            }
            temp.setNext(currentNode.getNext());
            currentNode.setNext(null);
            size--;
            currentNode = temp;
        }

        @Override
        public void reset() {
            //Reset the current pointer back to the head of the LL
            this.currentNode = head;
        }
    }
}
