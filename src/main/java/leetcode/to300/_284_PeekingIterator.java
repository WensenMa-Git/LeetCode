package leetcode.to300;

import java.util.Iterator;

/**
 * https://leetcode.com/problems/peeking-iterator/
 * Subject: Design
 * #Medium
 */
public class _284_PeekingIterator {


    private final Iterator<Integer> iter;
    private Integer next = null;

    public _284_PeekingIterator(Iterator<Integer> iterator) {
        iter = iterator;
        if (iter.hasNext()) {
            next = iter.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    //@Override
    public Integer next() {
        Integer res = next;
        next = iter.hasNext() ? iter.next() : null;
        return res;
    }

    //@Override
    public boolean hasNext() {
        return next != null;
    }
}
