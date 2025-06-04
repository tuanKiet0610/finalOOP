package hus.oop.statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyLinkedList extends MyAbstractList {
    private MyNode top;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
        top = null;
    }

    @Override
    public int size() {
        /* TODO */
        int count = 0;
        MyNode current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public void add(double data) {
        /* TODO */
        if (top == null) {
            top = new MyNode(data);
        }else {
            MyNode current = top;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new MyNode(data);
            current.next.previous = current;
        }
    }

    @Override
    public void insert(double data, int index) {
        /* TODO */
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            MyNode newNode = new MyNode(data, top, null);
            if(top != null) top.previous = newNode;
            top = newNode;
            return;
        }
        MyNode prev = getNodeByIndex(index - 1);
        MyNode newNode = new MyNode(data, prev.next, top);
        if(prev != null){
            prev.next.previous = newNode;
        }
        prev.next = newNode;
    }

    @Override
    public void remove(int index) {
        /* TODO */
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0 && top != null){
            top = top.next;
            if(top != null) top.previous = null;
            return;
        }
        MyNode node = getNodeByIndex(index);
        if(node.previous != null){
            node.previous.next = node.next;
        }
        if(node.next != null){
            node.next.previous = node.previous;
        }
    }

    @Override
    public MyLinkedList sortIncreasing() {
        /* TODO */
        List<Double> values = new ArrayList<>();
        MyNode current = top;
        while (current != null) {
            values.add(current.data);
            current = current.next;
        }
        Collections.sort(values);
        MyLinkedList sortedList = new MyLinkedList();
        for(Double val : values){
            sortedList.add(val);
        }
        return sortedList;
    }

    @Override
    public int binarySearch(double value) {
        /* TODO */
        MyList sortedList = this.sortIncreasing();
        MyIterator it = sortedList.iterator(0);
        int index = 0;
        while (it.hasNext()) {
            if (it.next().doubleValue() == value) {
                return index;
            }
            index++;
        }
        return -1;
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        /* TODO */
        return new MyLinkedListIterator(start);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyNode getNodeByIndex(int index) {
        /* TODO */
        MyNode current = top;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        if (current == null) throw new IndexOutOfBoundsException();
        return current;
    }

    private class MyLinkedListIterator implements MyIterator {
        /*
         * Vị trí hiện tại của iterator trong list.
         */
        private MyNode current;
        private int currentPosition;

        /**
         * Khởi tạo cho iterator ở vị trí position trong MyLinkedList.
         * @param position
         */
        public MyLinkedListIterator(int position) {
            /* TODO */
            current = top;
            for (int i = 0; i < position && current != null; i++) {
                current = current.next;
            }
        }

        @Override
        public boolean hasNext()
        {
            /* TODO */
            return current != null;
        }

        @Override
        public Number next() {
            /* TODO */
            double val = current.data;
            current = current.next;
            return val;
        }

        @Override
        public void remove() {
            /* TODO */
            throw new UnsupportedOperationException();
        }
    }
}
