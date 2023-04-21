public class L1List<T> {
    protected Node<T> first, last; //Первый элемент списка и последний.
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
//    public void swapNodes(int index1, int index2) {
//        if (index1 == index2) {
//            return;
//        }
//        Node node1 = get(index1);
//        Node node2 = get(index2);
//        if (node1 == null || node2 == null) {
//            return;
//        }
//        Node prevNode1 = getPrevNode(node1);
//        Node prevNode2 = getPrevNode(node2);
//        Node nextNode1 = node1.next;
//        Node nextNode2 = node2.next;
//
//        if (prevNode1 != null) {
//            prevNode1.next = node2;
//        } else {
//            first = node2;
//        }
//        if (prevNode2 != null) {
//            prevNode2.next = node1;
//        } else {
//            first = node1;
//        }
//        node1.next = nextNode2;
//        node2.next = nextNode1;
//        Object temp = node1.value;
//        node1.value = node2.value;
//        node2.value = temp;
//    }
//    private Node getPrevNode(Node node) {
//        if (node == first) {
//            return null;
//        }
//        Node current = first;
//        while (current != null && current.next != node) {
//            current = current.next;
//        }
//        return current;
//    }
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
    public void removeFirst(){
        Node<T> temp = first;
         first = first.next;
         if(first == null)
             last = null;
         size--;
    }
    public void removeLast(){
        Node <T> temp = last;
        if(size <= 1){
            removeFirst();
        }
        Node newLast = get(size - 2);
        last = newLast;
        last.next = null;
        size--;
    }
    //Удаление элемента.
    public void remove(int location) throws Exception{
        try {
            if (location == 0) { //Удаление первого элемента.
                first = first.next;
                if (first == null) //Если список пустой.
                    last = null;
                size--;
                return;
            }
            Node<T> current = first;
            for (int i = 0; i < location - 1; i++)
                current = current.next;
            current.next = current.next.next;
            if (current.next == null) //Удаление последнего элемента.
                last = current;
            size--;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
    public void forward(){
        first = first.next;
    }
    public Node<T> getLast(){
        return last;
    }
}