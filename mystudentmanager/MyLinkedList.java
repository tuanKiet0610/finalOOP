package mystudentmanager;

import java.util.NoSuchElementException;

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
            return currentPosition < size;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node node = getNodeByIndex(currentPosition);
            currentPosition++;
            return node.data;
        }
    }

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(Object data, int index) {
        Node node = getNodeByIndex(index);
        node.data = data;
    }

    public Object get(int index) {
        Node node = getNodeByIndex(index);
        return node.data;
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(Object value) {
        Node oldHead = head;
        head = new Node(value);
        head.next = oldHead;
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(Object value) {
        if (head == null) {
            head = new Node(value);
            size++;
            return;
        }
        Node current = head;;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
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
        if (head == null) {
            head = new Node(value);
            size++;
            return;
        } else {
            if (index == 0) {
                insertAtStart(value);
                return;
            }
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                if (current.next == null) {
                    return;
                }
                current = current.next;
            }
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current.next == null) {
                return;
            }
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public void remove(Object object) {
        if (head == null) {
            return;
        }
        if (head.data.equals(object)) {
            head = head.next;
            return;
        }
        Node current = head;
        Node previous = null;
        while (current != null && !current.data.equals(object)) {
            previous = current;
            current = current.next;
        }
        if (current != null) {
            previous = current.next;
        }
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        if (!checkBoundaries(index, size)) {
            throw  new IndexOutOfBoundsException();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public MyIterator iterator() {
        return new MyLinkedListIterator(0);
    }
}
