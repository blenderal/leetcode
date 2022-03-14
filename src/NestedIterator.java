import java.util.*;

/**
 * @description:
 * @author: zww
 * @date: 2021/3/23
 * @version: V1.0
 */
public class NestedIterator implements Iterator<Integer> {
    public List<Integer> list;
    public Iterator<Integer> cur;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>();
        addInteger(nestedList);
        cur = list.iterator();
    }
    public void addInteger(List<NestedInteger> nestedList){
        for (NestedInteger nestedInteger : nestedList) {
            if(nestedInteger.isInteger()){
                list.add(nestedInteger.getInteger());
            }else {
                addInteger(nestedInteger.getList());
            }
        }
    }


    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }
}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


