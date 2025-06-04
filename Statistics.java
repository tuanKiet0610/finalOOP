package hus.oop.statistics;

public class Statistics {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public Statistics(MyList data) {
        /* TODO */
        this.data = data;
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     * @return giá trị lớn nhất.
     */
    public double max() {
        /* TODO */
        MyIterator it = data.iterator(0);
        double max = Double.NEGATIVE_INFINITY;
        while (it.hasNext()) {
            max = Math.max(max, it.next().doubleValue());
        }
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        /* TODO */
        MyIterator it = data.iterator(0);
        double min = Double.POSITIVE_INFINITY;
        while (it.hasNext()) {
            min = Math.min(min, it.next().doubleValue());
        }
        return min;

    }

    /**
     * Tính kỳ vọng của mẫu theo dữ liệu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        /* TODO */
        MyIterator it = data.iterator(0);
        double sum = 0;
        int count = 0;
        while (it.hasNext()) {
            sum += it.next().doubleValue();
            count++;
        }
        return sum / count;
    }

    /**
     * Tính phương sai của mẫu theo dữ liệu trong list.
     * @return phương sai.
     */
    public double variance() {
        /* TODO */
        double mean = mean();
        MyIterator it = data.iterator(0);
        double sum = 0;
        int count = 0;
        while (it.hasNext()) {
            double val = it.next().doubleValue();
            sum += (val - mean) * (val - mean);
            count++;
        }
        return sum / (count - 1);

    }

    /**
     * Tìm kiếm trong list có phẩn tử nào có giá trị bằng data không, sử dụng binarySearch trong list.
     * Trả về index một phần tử có giá trị bằng data, nếu không tìm thấy thì trả về -1.
     * @return
     */
    public int search(double value) {
        /* TODO */
        return data.binarySearch(value);
    }

    /**
     * Tính rank của các phần tử trong list.
     * @return rank của các phần tử trong list
     */
    public double[] rank() {
        /* TODO */
        MyList sorted = data.sortIncreasing();
        double[] ranks = new double[data.size()];
        MyIterator it = data.iterator(0);
        for (int i = 0; it.hasNext(); i++) {
            double val = it.next().doubleValue();
            MyIterator sit = sorted.iterator(0);
            int rank = 1;
            while (sit.hasNext()) {
                if (sit.next().doubleValue() == val) {
                    break;
                }
                rank++;
            }
            ranks[i] = rank;
        }
        return ranks;
    }
}
