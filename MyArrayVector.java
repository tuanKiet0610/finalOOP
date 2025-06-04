package hus.oop.vector;

import java.util.Arrays;

public class MyArrayVector extends MyAbstractVector {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyArrayVector() {
        /* TODO */
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    @Override
    public double coordinate(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    @Override
    public double[] coordinates() {
        /* TODO */
        return Arrays.copyOf(data, size);
    }

    @Override
    public MyArrayVector insert(double value) {
        /* TODO */
        if (size == data.length) {
            allocateMore();
        }
        data[size++] = value;
        return this;
    }

    @Override
    public MyArrayVector insert(double value, int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == data.length) {
            allocateMore();
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
        return this;
    }

    @Override
    public MyArrayVector remove(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return this;
    }

    @Override
    public MyArrayVector extract(int[] indices) {
        /* TODO */
        MyArrayVector results = new MyArrayVector();
        for (int index : indices){
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            results.insert(data[index]);
        }
        return results;
    }

    @Override
    public void set(double value, int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = value;
    }

    @Override
    public MyArrayVector add(double value) {
        /* TODO */
        MyArrayVector results = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            results.insert(data[i] + value);
        }
        return results;
    }

    @Override
    public MyArrayVector add(MyVector another) {
        /* TODO */
        if(another.size() != size){
            throw new IllegalArgumentException();
        }
        MyArrayVector results = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            results.insert(data[i] + another.coordinate(i));
        }
        return results;
    }

    @Override
    public MyArrayVector addTo(double value) {
        /* TODO */
        for (int i = 0; i < size; i++) {
            data[i] += value;
        }
        return this;
    }

    @Override
    public MyArrayVector addTo(MyVector another) {
        /* TODO */
        if(another.size() != size){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < size; i++) {
            data[i] += another.coordinate(i);
        }
        return this;
    }

    @Override
    public MyArrayVector minus(double value) {
        /* TODO */
        return add(-value);
    }

    @Override
    public MyArrayVector minus(MyVector another) {
        /* TODO */
        if(another.size() != size){
            throw new IllegalArgumentException();
        }
        MyArrayVector results = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            results.insert(data[i] - another.coordinate(i));
        }
        return results;
    }

    @Override
    public MyArrayVector minusFrom(double value) {
        /* TODO */
        return add(-value);
    }

    @Override
    public MyArrayVector minusFrom(MyVector another) {
        /* TODO */
        if(another.size() != size){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < size; i++) {
            data[i] -= another.coordinate(i);
        }
        return this;
    }

    @Override
    public double dot(MyVector another) {
        /* TODO */
        if(another.size() != size){
            throw new IllegalArgumentException();
        }
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += data[i] * another.coordinate(i);
        }
        return result;
    }

    @Override
    public MyArrayVector pow(double power) {
        /* TODO */
        for (int i = 0; i < size; i++) {
            data[i] = Math.pow(data[i], power);
        }
        return this;
    }

    @Override
    public MyArrayVector scale(double value) {
        /* TODO */
        for (int i = 0; i < size; i++) {
            data[i] *= value;
        }
        return this;
    }

    @Override
    public double norm() {
        /* TODO */
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += data[i] * data[i];
        }
        return Math.sqrt(sum);
    }

    /**
     * Mở rộng kích thước vector lên gấp đôi khi cần thiết.
     */
    private void allocateMore() {
        /* TODO */
        data = Arrays.copyOf(data, data.length * 2);
    }
}
