package candidatemanager;

public class MyLinkedList extends MyAbstractList {
    private MyLinkedListNode head;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
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
        MyLinkedListNode result = getNodeByIndex(index);
        if (result == null) {
            return null;
        }
        return result.getPayload();
    }

    /**
     * Sửa phần tử ở vị trí index là payload.
     * @param payload
     * @param index
     */
    @Override
    public void set(Object payload, int index) {
        /* TODO */
        MyLinkedListNode result = getNodeByIndex(index);
        if (result == null) {
            return;
        }
        result.setPayload(payload);
    }

    /**
     * Xóa phần tử của list ở vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        this.checkBoundaries(index,size);
        if (index == 0) {
            if (size > 1) {
                this.head = head.getNext();
            }
            else {
                this.head = null;
            }
            size--;
            return;
        }
        if (index == size -1) {
            MyLinkedListNode prevNode = this.getNodeByIndex(index - 1);
            prevNode.setNext(null);
            size--;
            return;
        }
        MyLinkedListNode prevNode = this.getNodeByIndex(index - 1);
        MyLinkedListNode nextNode = this.getNodeByIndex(index + 1);
        prevNode.setNext(nextNode);
        size--;
    }

    /**
     * Thêm vào cuối list phần tử có dữ liệu payload.
     * @param payload
     */
    @Override
    public void append(Object payload) {
        /* TODO */
        if (size == 0) {
            this.head = new MyLinkedListNode(payload);
            size++;
        }
        else {
            MyLinkedListNode lastNode = this.getNodeByIndex(size -1);
            MyLinkedListNode newNode = new MyLinkedListNode(payload);
            lastNode.setNext(newNode);
            size++;
        }
    }

    /**
     * Thêm vào list phần tử có dữ liệu payload ở vị trí index.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Object payload, int index) {
        /* TODO */
        try {
            checkBoundaries(index, this.size);
            if (index == 0) {
                head = new MyLinkedListNode(payload, head);
            } else {
                MyLinkedListNode current = getNodeByIndex(index - 1);
                current.setNext(new MyLinkedListNode(payload, current.getNext()));
            }
            this.size++;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Unable to add " + payload + " at index " + index);
        }
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator() {
        /* TODO */
        return new MyLinkedListIterator();
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyLinkedListNode getNodeByIndex(int index) {
        /* TODO */
        MyLinkedListNode current = null;
        try {
            checkBoundaries(index, size);
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Unable to get node at index " + index);
        }
        return current;
    }
    private void checkBoundaries(int index, int limit) {
        if (index < 0 || index > limit) {
            throw new IndexOutOfBoundsException();
        }
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
            /* TODO */
            this.currentPosition = 0;
        }

        /**
         * Kiểm tra trong MyLinkedList có còn phần tử tiếp theo không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         * @return
         */
        @Override
        public boolean hasNext() {
            /* TODO */
            return getNodeByIndex(currentPosition) != null;
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyLinkedList và trả ra dữ liệu (payload) của phần tử hiện tại của MyLinkedList.
         * @return payload của phần tử hiện tại.
         */
        @Override
        public Object next() {
            /* TODO */
            if (hasNext()) {
                Object payload = getNodeByIndex(currentPosition).getPayload();
                currentPosition++;
                return payload;
            }
            return null;
        }

        /**
         * iterator xóa phần tử hiện tại của MyLinkedList.
         */
        @Override
        public void remove() {
            /* TODO */
            if (hasNext()) {
                if (size == 1) {
                    MyLinkedListNode currentNode =getNodeByIndex(0);
                    currentNode.setNext(null);
                    currentNode.setPayload(null);
                }
                else {
                    MyLinkedListNode previousNode = getNodeByIndex(currentPosition-1);
                    MyLinkedListNode currentNode = getNodeByIndex(currentPosition);
                    previousNode.setNext(currentNode.getNext());
                    currentNode.setNext(null);
                }
            }
        }
    }
}
