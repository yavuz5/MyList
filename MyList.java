import java.util.Objects;

public class MyList<T> {
    private int capacity;
    private T[] arr;

    public MyList() {
        this(10);
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[getCapacity()];
    }

    public int getCapacity() {
        return capacity;
    }

    public T[] setCapacity(int numb) {
        capacity *= numb;
        T[] tempArr = (T[]) new Object[getCapacity()];
        int i =0;
        if(capacity != 0){
            for (T data : arr) {
                tempArr[i++] = data;
            }
        }
        return tempArr;
    }

    public int size() {
        int count = 0;
        for (T value : arr) {
            if (!Objects.isNull(value)) {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }

    public void add(T data) {
        if (size() >= getCapacity()) {
            arr = setCapacity(2);
        }

        arr[size()] = data;
    }

    public T get(int index) {
        if (indexControl(index)) {
            return null;
        }
        return arr[index];
    }

    public boolean set(int index, T data) {
        if (indexControl(index)) {
            return false;
        }
        arr[index] = data;
        return true;

    }

    public boolean remove(int index) {
        if (indexControl(index)) {
            return false;
        }
        T deleteMember = arr[index];
        int i = 0;
        for( T data: arr) {
            if( data == deleteMember)
                continue;
            else{
                arr[i++] = data;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (T data : arr) {
            if (!Objects.isNull(data)) {
                sb.append(data).append(",");
            }
            else {
                break;
            }
        }
        if (sb.length() != 1) {
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean indexControl(int index) {
        return index >= getCapacity();
    }

    public int indexOf(T data) {
        int index = 0;
        for(T a : arr) {
            if( data == a){
                return index;
            }
            index++;
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        int returnIndex = -1;
        int index = 0;
        for(T a : arr) {
            if( data == a){
                returnIndex = index;
            }
            index++;
        }
        return returnIndex;
    }

    public boolean isEmpty() {
        if( size() == 0)
            return true;
        return false;
    }

    public T[] toArray() {
        return arr;
    }

    public void clear() {
        arr = setCapacity(0);
    }

    public MyList<T> subList(int start, int finish) {
        MyList<T> myList = new MyList<>();
        for(int i = start; i <= finish; i++) {
            myList.add(arr[i]);
        }
        return myList;
    }

    boolean contains(T data) {
        return indexOf(data) != -1 ;
    }
}
