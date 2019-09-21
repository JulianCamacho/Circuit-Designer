package Logic;

import DoublyLinkedList_Pack.DoublyLinkedList;
import Interface.AlertBox;

import java.net.MalformedURLException;

public class CircuitSolver {

    public static void evaluateFinalList(DoublyLinkedList finalList) throws MalformedURLException {
        if (finalList.isEmpty() == true){
            AlertBox.displayAlertBox("Exception", "Empty circuit");
        }
        else {
            if (readyFinalList(finalList) == false){
                AlertBox.displayAlertBox("INCOMPLETE CIRCUIT", "Please connect all your circuit by giving every input its value");
            } else if (readyFinalList( finalList) == true){
                DoublyLinkedList resultsFinalList = results(finalList);
                int contOuts = 0;
                while(finalList.getLength() < contOuts) {
                    int i = 0;
                    if (finalList.getGate(i).getName() == "NOT") {
                        if (finalList.getGate(i).getInput1State() == null) {
                            i++;
                        } else if (finalList.getGate(i).getInput1State() != null) {
                            boolean calculatedOutput = finalList.getGate(i).logic();
                            finalList.getGate(i).setOutput(calculatedOutput);
                            i++;
                            contOuts++;
                        }
                    }
                    else if (finalList.getGate(i).getName() != "NOT") {
                        if (finalList.getGate(i).getInput1State() == null || finalList.getGate(i).getInput2State() == null) {
                            i++;
                        } else if (finalList.getGate(i).getInput1State() != null && finalList.getGate(i).getInput2State() != null) {
                            boolean calculatedOutput = finalList.getGate(i).logic();
                            finalList.getGate(i).setOutput(calculatedOutput);
                            i++;
                            contOuts++;
                        }
                    }
                }
                showResults(resultsFinalList);
            }
        }
    }

    public static boolean readyFinalList(DoublyLinkedList finalList){
        int j = 0;
        while (j < finalList.getLength()){
            if (finalList.getGate(j).getInput1State() == null || finalList.getGate(j).getInput2State() == null){
                return false;
            }
        }
        return true;
    }

    public static DoublyLinkedList results(DoublyLinkedList finalList) throws MalformedURLException {
        int j = 0;
        DoublyLinkedList resultList = new DoublyLinkedList();
        while (j < finalList.getLength()){
            if (finalList.getGate(j).getOutputState() == null){
                resultList.addLast(finalList.getGate(j));
            }
        }
        return resultList;
    }

    public static void showResults(DoublyLinkedList resultList){
        int h = 0;
        String finalMessage = null;
        while(h < resultList.getLength()){
            finalMessage += resultList.getGate(h).getOutput();
        }
        AlertBox.displayResultAlertBox("Circuit results", finalMessage);
    }
}
