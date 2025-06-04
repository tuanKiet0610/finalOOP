package hus.oop.vector;

import java.util.ArrayList;
import java.util.List;

public class MyListVector extends MyAbstractVector {
    private List<Double> data;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyListVector() {
        /* TODO */
        data = new ArrayList<Double>();
    }

    @Override
    public int size() {
        /* TODO */
        return data.size();
    }

    @Override
    public double coordinate(int index) {
        /* TODO */
        if(index < 0 || index >= data.size()){
            throw new IndexOutOfBoundsException();
        }
        return data.get(index);
    }

    @Override
    public double[] coordinates() {
        /* TODO */
        double[] result = new double[size()];
        for(int i = 0; i < data.size(); i++){
            result[i] = data.get(i);
        }
        return result;
    }

    @Override
    public MyListVector insert(double value) {
        /* TODO */data.add(value);
        return this;
    }

    @Override
    public MyListVector insert(double value, int index) {
        /* TODO */
        if(index < 0 || index >= data.size()){
            throw new IndexOutOfBoundsException();
        }
        data.add(index, value);
        return this;
    }

    @Override
    public MyListVector remove(int index) {
        /* TODO */
        if(index < 0 || index >= data.size()){
            throw new IndexOutOfBoundsException();
        }
        data.remove(index);
        return this;
    }

    @Override
    public MyListVector extract(int[] indices) {
        /* TODO */
        MyListVector result = new MyListVector();
        for(int index : indices){
            if(index < 0 || index >= data.size()){
                throw new IndexOutOfBoundsException();
            }
            result.insert(data.get(index));
        }
        return result;
    }

    @Override
    public void set(double value, int index) {
        /* TODO */
        if(index < 0 || index >= data.size()){
            throw new IndexOutOfBoundsException();
        }
        data.set(index, value);
    }

    @Override
    public MyListVector add(double value) {
        /* TODO */
        MyListVector result = new MyListVector();
        for(double element : data){
            result.insert(element + value);
        }
        return result;
    }

    @Override
    public MyListVector add(MyVector another) {
        /* TODO */
        if(another.size() != size()){
            throw new IllegalArgumentException();
        }
        MyListVector result = new MyListVector();
        for (int i = 0; i < size(); i++) {
            result.insert(data.get(i) + another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyListVector addTo(double value) {
        /* TODO */
        for(int i = 0; i < size(); i++){
            data.set(i, data.get(i) + value);
        }
        return this;
    }

    @Override
    public MyListVector addTo(MyVector another) {
        /* TODO */
        if(another.size() != size()){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < size(); i++){
            data.set(i, data.get(i) + another.coordinate(i));
        }
        return this;
    }

    @Override
    public MyListVector minus(double value) {
        /* TODO */
        return add(-value);
    }

    @Override
    public MyListVector minus(MyVector another) {
        /* TODO */
        if(another.size() != size()){
            throw new IllegalArgumentException();
        }
        MyListVector result = new MyListVector();
        for(int i = 0; i < size(); i++){
            result.insert(data.get(i) - another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyListVector minusFrom(double value) {
        /* TODO */
        return addTo(-value);
    }

    @Override
    public MyListVector minusFrom(MyVector another) {
        /* TODO */
        if(another.size() != size()){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < size(); i++){
            data.set(i, data.get(i) - another.coordinate(i));
        }
        return this;
    }

    @Override
    public double dot(MyVector another) {
        /* TODO */
        if(another.size() != size()){
            throw new IllegalArgumentException();
        }
        double result = 0;
        for(int i = 0; i < size(); i++){
            result += data.get(i) * another.coordinate(i);
        }
        return result;
    }

    @Override
    public MyListVector pow(double power) {
        /* TODO */
        for(int i = 0; i < size(); i++){
            data.set(i, Math.pow(data.get(i), power));
        }
        return this;
    }

    @Override
    public MyListVector scale(double value) {
        /* TODO */
        for(int i = 0; i < size(); i++){
            data.set(i, data.get(i) * value);
        }
        return this;
    }

    @Override
    public double norm() {
        /* TODO */
        double result = 0;
        for (double element : data) {
            result += element * element;
        }
        return Math.sqrt(result);
    }
}
