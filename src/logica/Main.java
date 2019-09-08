package logica;

//import javafx.application.Application;
import DoublyLinkedList_Pack.DoublyLinkedList;
import javafx.stage.Stage;
/**
 * Metodo principal de la aplicacion
 * @author Jose Julian Camacho
 * @date 4.9.19
 * */
public class Main {//extends Application {
/*
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Circuit Designer");
    }
}
*/
    public static void main(String[] args) {
        DoublyLinkedList milista = new DoublyLinkedList();
        System.out.println(milista.getLength());
        milista.getData(4);
        milista.addLast(3);
        milista.addLast(5);
        milista.addLast(10);
        milista.addFirst(8);
        milista.addFirst(1);
        System.out.println(milista.getLength());
        milista.getData(3);
        milista.setData(3, 60);
        System.out.println(milista.getLength());
        milista.printList();
        milista.reversePrintList();
    }
}