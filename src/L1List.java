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
        Node ne = first.next;
        while (ne != node) {
            ne = ne.next;
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
            Node<T> current = first;
            for (int i = 0; i < location - 1; i++) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }
    }

    //Удаление элемента.
    public void remove(int location) {
        if(location < 0 || location >= size)
            throw new IndexOutOfBoundsException();
        if(location == 0){
            first = first.next;
            size--;
            if(size == 0)
                last = null;
            return;
        }
        Node<T> current = first;
        for(int i = 1; i < location; i++){
            current = current.next;
        }
        current.next = current.next.next;
        if(location == size - 1){
            last = current;
        }
        size--;
    }

    public void toPrint() {
        Node<T> current = first;
        while (current != null) {
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