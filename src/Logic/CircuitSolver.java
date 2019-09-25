package Logic;

import DoublyLinkedList_Pack.DoublyLinkedList;
import Interface.AlertBox;

import java.net.MalformedURLException;

import static Interface.DrawLineFeature.joinSource_Input1;
import static Interface.DrawLineFeature.joinSource_Input2;

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
                resultsFinalList.printList();
                int contOuts = 0;
                while(contOuts < finalList.getLength()) {
                    int i = 0;
                    while (i < finalList.getLength()){
                        Gate currentGate = finalList.getGate(i);
                        if (currentGate.getName() == "NOT") {
                            if (currentGate.getInput1State() == null) {
                                i++;
                            } else if (currentGate.getInput1State() != null && currentGate.isCalculated() == false) {
                                boolean calculatedOutput = currentGate.logic();
                                currentGate.setOutput(calculatedOutput);
                                i++;
                                contOuts++;
                            }
                        }
                        else if (currentGate.getName() != "NOT") {
                            if (currentGate.getInput1State() == null && currentGate.getInput2State() == null) {
                                i++;
                            }
                            else if ((currentGate.getInput1State() != null || currentGate.getInput2State() != null) && currentGate.isCalculated() == false) {
                                currentGate.logic();
                                if (currentGate.getOutputState() == "input1") {
                                    joinSource_Input1(currentGate, currentGate.realNext);
                                    currentGate.realNext.setInput1State("true");
                                    i++;
                                    contOuts++;
                                }
                                else if (currentGate.getOutputState() == "input2") {
                                    joinSource_Input2(currentGate, currentGate.realNext);
                                    currentGate.realNext.setInput2State("true");
                                    i++;
                                    contOuts++;
                                } else if (currentGate.getOutputState() == null){
                                    i++;
                                }
                            }
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
            if (finalList.getGate(j).getName() != "NOT"){
                if (finalList.getGate(j).isIn1Connected() == false || finalList.getGate(j).isIn2Connected() == false){
                    return false;
                }
            }
            else if (finalList.getGate(j).getName() == "NOT"){
                if (finalList.getGate(j).isIn1Connected() == false){
                    return false;
                }
            }
            j++;
        }
        return true;
    }

    public static DoublyLinkedList results(DoublyLinkedList finalList) throws MalformedURLException {
        int j = 0;
        DoublyLinkedList resultList = new DoublyLinkedList();
        while (j < finalList.getLength()){
            if (finalList.getGate(j).isOutConnected() == false){
                resultList.addLast(finalList.getGate(j));
            }
            j++;
        }
        return resultList;
    }

    public static void showResults(DoublyLinkedList resultList){
        int h = 0;
        String finalMessage = "The results are: " + "\n";
        while(h < resultList.getLength()){
            finalMessage += ("For: " + resultList.getGate(h).getMyID() + ": " + resultList.getGate(h).getGateOut().getId() + ": " + resultList.getGate(h).getOutput() + "\n");
            h++;
        }
        AlertBox.displayResultAlertBox("Circuit results", finalMessage);
    }
}
