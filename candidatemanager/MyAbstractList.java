package candidatemanager;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1] [a2] [a3] ... [an]
     */
    @Override
    public String toString() {
        /* TODO */
        MyIterator iterator = iterator();
        StringBuilder result = new StringBuilder();
        while (iterator.hasNext()) {
            result.append(String.format("[%s] ",iterator.next()));
        }
        result.delete(result.length()-1,result.length());
        return result.toString();
    }
}
