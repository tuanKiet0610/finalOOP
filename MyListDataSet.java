package hus.oop.fraction;

import java.util.ArrayList;
import java.util.List;

public class MyListDataSet implements MyDataSet {
    private List<MyFraction> fractions;

    /**
     * Hàm dựng khởi tạo list chứa các phân số.
     */
    public MyListDataSet() {
        /* TODO */
        fractions = new ArrayList<>();
    }

    /**
     * Hàm dựng khởi tạo list chứa các phân số theo truyền vào.
     * @param fractions
     */
    public MyListDataSet(List<MyFraction> fractions) {
        /* TODO */
        this.fractions = new ArrayList<>();
        for (MyFraction fraction : fractions) {
            this.fractions.add(new MyFraction(fraction));
        }
    }

    @Override
    public boolean insert(MyFraction fraction, int index) {
        /* TODO */
        if(index < 0 || index >= fractions.size()){
            return false;
        }
        fractions.add(index, new MyFraction(fraction));
        return true;
    }

    @Override
    public boolean append(MyFraction fraction) {
        /* TODO */
        return fractions.add(new MyFraction(fraction));
    }

    @Override
    public MyListDataSet toSimplify() {
        /* TODO */
        List<MyFraction> simplified = new ArrayList<>();
        for (MyFraction fraction : fractions) {
            MyFraction copy = new MyFraction(fraction);
            copy.simplify();
            simplified.add(copy);
        }
        return new MyListDataSet(simplified);
    }

    public MyListDataSet sortIncreasing() {
        /* TODO */
        List<MyFraction> sorted = new ArrayList<>(fractions);
        sorted.sort((f1, f2) -> {
            int cmp = Double.compare(f1.doubleValue(), f2.doubleValue());
            if (cmp == 0) {
                return Integer.compare(f1.getDenominator(), f2.getDenominator());
            }
            return cmp;
        });
        return new MyListDataSet(sorted);
    }

    public MyListDataSet sortDecreasing() {
        /* TODO */
        List<MyFraction> sorted = new ArrayList<>(fractions);
        sorted.sort((f1, f2) -> {
            int cmp = Double.compare(f2.doubleValue(), f1.doubleValue());
            if (cmp == 0) {
                return Integer.compare(f2.getDenominator(), f1.getDenominator());
            }
            return cmp;
        });
        return new MyListDataSet(sorted);
    }

    @Override
    public String myDataSetToString() {
        /* TODO */
        return fractions.toString();
    }

    @Override
    public void print() {
        /* TODO */
        System.out.println(myDataSetToString());
    }
}
