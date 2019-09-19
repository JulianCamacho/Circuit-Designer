package DoublyLinkedList_Pack;

import Logic.Gate;

import java.net.MalformedURLException;

public class DoublyLinkedList<T>{
    private int length;
    private Gate first;
    private Gate last;

    public DoublyLinkedList(){
        this.length = 0;
        this.first = null;
        this.last = null;
    }

    public int getLength(){
        return this.length;
    }

    public void getData(int index){
        if (index > this.length-1 || this.first == null || index < 0){
            System.out.println("Index out of range");
            //return null;
        }
        else{
            int counter = 0;
            Gate current = this.first;
            while(counter < index){
                current = current.next;
                counter ++;
            }
            System.out.println(current);
        }
    }

    public void setData(int index, String name){
        if (index > this.length-1 | this.first == null | index < 0){
            System.out.println("Index out of range");
        }
        else{
            int counter = 0;
            Gate current = this.first;
            while(counter < index){
                current = current.next;
                counter ++;
            }
            current.setName(name);
        }
    }


    public void printList(){
        if (this.first == null){
            System.out.println("[]");
        }
        else {
            Gate current = this.first;
            System.out.print("[");
            while (current.next != null) {
                System.out.print(current.getName());
                System.out.print(", ");
                current = current.next;
            }
            System.out.print(current.getName());
            System.out.println("]");
        }
    }

    public void reversePrintList(){
        if (this.last == null){
            System.out.print("[]");
        }
        else{
            Gate current = this.last;
            System.out.print("[");
            while(current.prev != null){
                System.out.print(current.getName());
                System.out.print(", ");
                current = current.prev;
            }
            System.out.print(current.getName());
            System.out.print("]");
        }
    }

    public void addLast(Gate addedGate) throws MalformedURLException {
        this.length ++;
        if (this.first == null){
            this.first = addedGate;
            this.last = this.first;
            System.out.println("Done");
        }
        else {
            Gate newGate = addedGate;
            this.last.next = newGate;
            newGate.prev = this.last;
            this.last = newGate;
        }
    }

    public void addFirst(Gate addedGate) throws MalformedURLException {
        this.length ++;
        if (this.first == null){
            this.first = addedGate;
            this.last = this.first;
        }
        else {
            Gate newGate = addedGate;
            this.first.prev = newGate;
            newGate.next = this.first;
            this.first = newGate;
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
            Gate before = this.last.prev;
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
            Gate after = this.first.next;
            this.first.next.prev = null;
            this.first = after;
        }
    }

}
