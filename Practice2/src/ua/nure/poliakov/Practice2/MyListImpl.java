package ua.nure.poliakov.Practice2;

import java.util.Iterator;

public class MyListImpl implements MyList, ListIterable {

    private int index = 0;

    private Object[] arr = new Object[0];

    public void add(Object e) {
        if (e != null) {
            Object[] localArr = new Object[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                localArr[i] = arr[i];
                index = i;
            }
            localArr[arr.length] = e;
            arr = localArr;
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            stringBuffer.append(arr[i] + System.lineSeparator());
        }
        return String.valueOf(stringBuffer);
    }

    @Override
    public void clear() {
        arr = new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        boolean flag = false;
        Object[] localArr = new Object[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            if (o.equals(arr[i])) {
                arr[i] = null;
                flag = true;
                replace(i);
            }
            localArr[i] = arr[i];
        }
        arr = localArr;
        return flag;
    }

    private void replace(int index) {
        for (int i = index; i < arr.length - 1; i++) {
            Object temp = arr[i + 1];
            arr[i + 1] = arr[i];
            arr[i] = temp;
        }
    }

    @Override
    public Object[] toArray() {
        return arr;
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < arr.length; i++) {
            if (o.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(MyList c) {
        for (int i = 0; i < arr.length; i++) {
            if (!c.contains(arr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        @Override
        public boolean hasNext() {
            return index < arr.length;
        }

        @Override
        public Object next() {
            return arr[index++];
        }

        @Override
        public void remove() {
            Object[] obj = new Object[arr.length - 1];
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].equals(index)) {
                    arr[i] = null;
                    replace(index);
                }
                obj[i] = arr[i];
            }
            arr = obj;
        }
    }

    @Override
    public ListIterator listIterator() {
        return new ListIteratorImpl();

    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator {

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public Object previous() {
            if (index < 0) {
                throw new IllegalArgumentException();
            }
            return arr[--index];
        }

        @Override
        public void set(Object e) {
            arr[index] = e;
        }
    }
}