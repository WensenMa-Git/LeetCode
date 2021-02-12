package dependency;

import java.util.ArrayList;
import java.util.List;


public class NestedInteger {

    public Integer value;
    public List<NestedInteger> list;

    public NestedInteger() {
        value = new Integer(0);
        list = new ArrayList<>();
    }

    public NestedInteger(int value) {
        this.value = value;
    }

    public NestedInteger(int value, List<NestedInteger> list) {
        this.value = value;
        this.list = list;
    }

    public void add(NestedInteger nestedInteger) {
    }

    // @return true if this NestedInteger holds a single integer,
    // rather than a nested list.
    public boolean isInteger() {
        return value != null;
    }

    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return value;
    }

    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return list;
    }

    public Integer next() {
        return value;
    }

    public boolean hasNext() {
        return true;
    }


}