package mybookmanager;

import java.util.ArrayList;
import java.util.List;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1] [a2] [a3] ... [an]
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append("[").append(get(i)).append("]").append(" ");
        }
        return sb.toString().trim();
    }
    protected boolean checkBoundaries(int index) {
        return index < 0 || index >= size();
    }
    public List<Object> getList() {
        List<Object> newList = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            newList.add(get(i));
        }
        return newList;
    }

}
