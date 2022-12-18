package behavior.iterator;

import java.util.ArrayList;

public class ApplicationMain {
    public static void main(String[] args) {

    }
}
interface OIterator {
    Object next();
    boolean hasNext();
}
interface IterableCollection {
    OIterator createIterator();
}
class ConcreteIterator implements OIterator{
    private final ArrayList<Object> objectArrayList;
    private int iterationState;
    public ConcreteIterator (){
       this.objectArrayList = new ArrayList<>();
    }
    @Override
    public Object next() {
        return objectArrayList.get(iterationState);
    }

    @Override
    public boolean hasNext() {
        return iterationState < objectArrayList.size();
    }
}
class ConcreteCollection implements IterableCollection{

    @Override
    public OIterator createIterator() {
        return new ConcreteIterator();
    }
}



