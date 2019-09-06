package DoublyLinkedList_Pack;

public class DoublyLinkedList<T>{
    private int length;
    private Node first;
    private Node last;

    public DoublyLinkedList(){
        this.length = 0;
        this.first = null;
        this.last = null;
    }

    public int getLength(){
        return this.length;
    }

    public T getData(int index){
        if (index > this.length-1 | this.first == null | index < 0){
            System.out.println("Index out of range");
            return null;
        }
        else{
            int counter = 0;
            Node current = this.first;
            while(counter < index){
                current = current.next;
                counter ++;
            }
            System.out.println(current.getData());
            return (T) current.getData();
        }
    }

    public void setData(int index, T data){
        if (index > this.length-1 | this.first == null | index < 0){
            System.out.println("Index out of range");
        }
        else{
            int counter = 0;
            Node current = this.first;
            while(counter < index){
                current = current.next;
                counter ++;
            }
            current.setData(data);
        }
    }


    public void printList(){
        if (this.first == null){
            System.out.println("[]");
        }
        else {
            Node current = this.first;
            System.out.print("[");
            while (current.next != null) {
                System.out.print(current.getData());
                System.out.print(", ");
                current = current.next;
            }
            System.out.print(current.getData());
            System.out.println("]");
        }
    }

    public void reversePrintList(){
        if (this.last == null){
            System.out.print("[]");
        }
        else{
            Node current = this.last;
            System.out.print("[");
            while(current.prev != null){
                System.out.print(current.getData());
                System.out.print(", ");
                current = current.prev;
            }
            System.out.print(current.getData());
            System.out.print("]");
        }
    }

    public void addLast(T data){
        this.length ++;
        if (this.first == null){
            this.first = new Node(data);
            this.last = this.first;
        }
        else {
            Node newNode = new Node(data);
            this.last.next = newNode;
            newNode.prev = this.last;
            this.last = newNode;
        }
    }

    public void addFirst(T data){
        this.length ++;
        if (this.first == null){
            this.first = new Node(data);
            this.last = this.first;
        }
        else {
            Node newNode = new Node(data);
            this.first.prev = newNode;
            newNode.next = this.first;
            this.first = newNode;
        }
    }

    public void deleteLast(){
        if (this.first == null){
            this.length --;
            return;
        }
        else if(this.first.next == null){
            this.length --;
            this.first = null;
        }
        else {
            this.length --;
            Node before = this.last.prev;
            this.last.prev.next = null;
            this.last = before;
        }
    }

    public void deleteFirst(){
        if (this.first == null){
            this.length --;
            return;
        }
        else if(this.first.next == null){
            this.length --;
            this.first = null;
            this.last = null;
        }
        else {
            this.length --;
            Node after = this.first.next;
            this.first.next.prev = null;
            this.first = after;
        }
    }

}
