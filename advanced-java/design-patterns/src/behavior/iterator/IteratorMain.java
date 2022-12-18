package behavior.iterator;

import java.util.ArrayList;
import java.util.Collection;

public class IteratorMain {
    public static void main(String[] args) {
        ObjectIterator objectIterator = new ObjectIterator();
        objectIterator.add(1);
        objectIterator.add(2);
        objectIterator.add(3);
        while (objectIterator.hasNext()){
            System.out.println(objectIterator.next());
        }
        ObjectIterator iterator = new ObjectIterator();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(3);
        integerArrayList.add(4);
        integerArrayList.add(5);
        iterator.addAll(integerArrayList);
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
interface Iterator {
    Object next();
    boolean hasNext();
    void reset();
}
class ObjectIterator implements Iterator {
    ArrayList<Object> objectArrayList;
    private int index;
    public ObjectIterator() {
        this.objectArrayList = new ArrayList<>();
        this.index = 0;
    }
    public void add(Object object) {
        objectArrayList.add(object);
    }
    public void addAll(Collection collection) {
        objectArrayList.addAll(collection);
    }
    @Override
    public Object next() {
        Object object = objectArrayList.get(index);
        index++;
        return object;
    }
    @Override
    public boolean hasNext() {
        return index < objectArrayList.size();
    }

    @Override
    public void reset() {
        this.index = 0;
    }
}
