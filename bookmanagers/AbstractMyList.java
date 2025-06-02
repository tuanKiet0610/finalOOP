package bookmanagers;

public abstract class AbstractMyList implements MyList {
    /**
     * Phương thức kiểm tra xem index có nằm ngoai đoạn [0, limit - 1] không.
     * @param index
     * @param limit
     * @return
     */
    public boolean checkBoundaries(int index, int limit) {
        return index < 0 || index >= limit;
    }
}
