package ua.nure.poliakov.Practice6.Task7;

import java.util.*;

public class Range implements Iterable<Integer> {

    private int n;
    private int m;
    private List<Integer> list = new ArrayList<>();
    private boolean reverse;

    public Range(int n, int m, List<Integer> list, boolean reverse) {
        this.n = n;
        this.m = m;
        this.list = list;
        this.reverse = reverse;

        while (iterator().hasNext()) {
            int i = iterator().next();
            System.out.print(list.get(i) + ", ");
        }
    }

    public List<Integer> getList() {
        return list;
    }

    @Override
    public Iterator<Integer> iterator() {
        if (!reverse) {
            return new RangeIterator();
        } else {
            return new ReverseIterator();
        }
    }

    private class RangeIterator implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return n < m;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                int current = n;
                n++;
                return current;
            }
            return null;
        }

        @Override
        public void remove() {
        }
    }

    private class ReverseIterator implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return n < m;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                int current = m;
                m--;
                return current;
            }
            return null;
        }

        @Override
        public void remove() {
        }
    }
}