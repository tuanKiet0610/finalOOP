package basicstatistics;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1] [a2] [a3] ... [an]
     */
    @Override
    public String toString() {
        int size = this.size();
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("[").append(get(i)).append("] ");
        }
        return sb.toString().trim();
    }
    public void checkIndex(int index) {
        //Checking if index belongs to interval [0, size-1] which will cover the edge case of removing an element of an
        //empty array
        if (index < 0 && index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
    }
}
