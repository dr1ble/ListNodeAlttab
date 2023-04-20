public class L1List<T> {
    private Node<T> first, last; //Первый элемент списка и последний.
    private int size;

    public L1List() {
        first = last = null;
        size = 0;
    }

    //Добавить элемент в конец списка.
    public void append(Node<T> node) {
        node.next = null;
        if (first == null) //Первый элемент. Выделяем ему память.
            first = node;
        if (last != null)
            last.next = node;
        last = node;
        size++; //Увеличиваем размер списка.
    }

    //Получить номер элемента.
    public int find(Node node) {
        int index = 0;
        Node temp = first.next;
        while (temp != node) {
            temp = temp.next;
            index++;
        }
        return index;
    }

    //Вставка элемента.
    public void insert(Node<T> node, int location) {
        if (location == 0) {
            node.next = first;
            first = node;
        } else {
            Node<T> temp = first;
            for (int i = 1; i < location; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }
    public Node get(int location){
        Node<T> node = first;
        for(int i = 0; i < location; i++){
            node = node.next;
        }
        return node;
    }
    public T removeFirst(){
        Node<T> temp = first;
         first = first.next;
         if(first == null)
             last = null;
         size--;
         return temp.value;
    }
    public T removeLast(){
        Node <T> temp = last;
        if(size <= 1){
            return removeFirst();
        }
        Node newLast = get(size - 2);
        last = newLast;
        last.next = null;
        return temp.value;
    }
    //Удаление элемента.
    public void remove(int location) {
        if(location < 0 || location >= size)
            throw new IndexOutOfBoundsException();
        if(location == 0){
            removeFirst();
        }
        if(location == size - 1){
            removeLast();
        }
        Node<T> prev = get(location-1);
        T value = prev.next.value;
        prev.next = prev.next.next;
        size--;
    }

    public void toPrint() {
        Node<T> temp = first;
        while (temp != null) {
            System.out.println(first.value);
            first = first.next;
            return;
        }
    }
    public int size(){
        return size;
    }
    public Node<T> getLast(){
        return last;
    }
}