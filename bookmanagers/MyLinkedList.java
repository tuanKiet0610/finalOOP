package bookmanagers;

public class MyLinkedList extends AbstractMyList {
    private Node head;
    private int size;

    private class MyLinkedListIterator implements MyIterator {
        private int currentPosition;

        public MyLinkedListIterator(int start) {
            this.currentPosition = start;
        }

        @Override
        public boolean hasNext() {
            return getNodeByIndex(currentPosition) != null;
        }

        @Override
        public Object next() {
            Object currentObj = getNodeByIndex(currentPosition).data;
            currentPosition++;
            return currentObj;
        }
    }

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public MyLinkedList() {
        //Default value is 0
        this.head = new Node(0);
    }

    @Override
    public int size() {
        return this.size;
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(Object data, int index) {
        if (checkBoundaries(index,size) || data == null) {
            return;
        }
        Node currNode = getNodeByIndex(index);
        currNode.data = data;
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(Object value) {
        Node newNode = new Node(value);
        if (size != 0) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(Object value) {
        if (value == null) {
            return;
        }
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
        }
        else {
            //Get the last node, set the next node of the last node to be the new node
            Node lastNode = getNodeByIndex(size - 1);
            lastNode.next = newNode;
        }
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * Chỉ thêm được nếu index nằm trong đoạn [0 - size()].
     * @param value
     * @param index
     */
    @Override
    public void insertAtPosition(Object value, int index) {
        if (index == size) {
            insertAtEnd(value);
            return;
        }
        if (checkBoundaries(index, size) || value == null) {
            return;
        }
        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        }
        else {
            /*
            Supposed we have this list ... ... 3 4 6... and we want to add 5 between 4 and 6
            We set the next node of node 4 to be node 5, and we set the next node of node 5 to be node 6
             */
            Node prevNode = getNodeByIndex(index - 1);
            Node currNode = getNodeByIndex(index);
            prevNode.next = newNode;
            newNode.next = currNode;
        }
        size++;
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        if (checkBoundaries(index,size)) {
            return;
        }
        if (index == 0 || size == 1) {
            head = head.next;
        }
        else if (index == size - 1) {
            Node prevNode = getNodeByIndex(size - 2);
            prevNode.next = null;
        }
        else {
            /*
            Supposed we have this list ... ... 3 4 5 ... and we want to remove 4 from the list
            We set the next node of node 3 to be node 5, and we remove the linking from node 4 to 5(optional)
             */
            Node prevNode = getNodeByIndex(index - 1);
            Node currNode = getNodeByIndex(index);
            prevNode.next = currNode.next;
            currNode.next = null;
        }
        size--;
    }

    @Override
    public Object get(int index) {
        if (checkBoundaries(index,size)) {
            return null;
        }
        return getNodeByIndex(index).data;
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        //Does not have to check the index because other functions checks beforehand in order to run this function
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    @Override
    public MyIterator iterator() {
        return new MyLinkedListIterator(0);
    }
}
