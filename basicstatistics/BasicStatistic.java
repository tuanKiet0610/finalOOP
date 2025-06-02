package basicstatistics;

public class BasicStatistic {
    private MyList data;
    private MyIterator iterator;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public BasicStatistic(MyList data) {
        this.data = data;
        this.iterator = data.iterator();
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     * @return giá trị lớn nhất.
     */
    public double max() {
        if (data.size() == 0) {
            throw new RuntimeException("empty array");
        }
        double max = Double.parseDouble(data.get(0).toString());
        while (iterator.hasNext()) {
            double curr = Double.parseDouble(iterator.next().toString());
            if (curr > max) {
                max = curr;
            }
        }
        iterator.reset();
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        if (data.size() == 0) {
            throw new RuntimeException("empty array");
        }
        double min = Double.parseDouble(data.get(0).toString());
        while (iterator.hasNext()) {
            double curr = Double.parseDouble(iterator.next().toString());
            if (curr < min) {
                min = curr;
            }
        }
        iterator.reset();
        return min;
    }

    /**
     * Tính kỳ vọng của mẫu lưu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        if (data.size() == 0) {
            throw new RuntimeException("empty array");
        }
        double mean = 0.0;
        while (iterator.hasNext()) {
            double curr = Double.parseDouble(iterator.next().toString());
            mean += curr;
        }
        iterator.reset();
        return mean / data.size();
    }

    /**
     * Tính phương sai của mẫu lưu trong list.
     * @return phương sai.
     */
    public double variance() {
        if (data.size() == 0) {
            throw new RuntimeException("empty array");
        }
        double mean = this.mean();
        double result = 0.0;
        while (iterator.hasNext()) {
            double curr = Double.parseDouble(iterator.next().toString());
            result += Math.pow(mean - curr, 2);
        }
        iterator.reset();
        return result / (data.size() - 1);
    }
}
