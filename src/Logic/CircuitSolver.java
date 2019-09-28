package Logic;

import DoublyLinkedList_Pack.DoublyLinkedList;
import Interface.AlertBox;

import java.net.MalformedURLException;

import static Interface.DrawLineFeature.joinSource_Input1;
import static Interface.DrawLineFeature.joinSource_Input2;

/**
 * Clase CircuitSolver: clase para calcular el circuito.
 */
public class CircuitSolver {

    /**
     * Método que revisa y calcula el circuito.
     * @param finalList - lista de compuertas a resolver.
     * @throws MalformedURLException
     */

    public static void evaluateFinalList(DoublyLinkedList finalList) throws MalformedURLException {
        //Verifica que la lista no esté vacía
        if (finalList.isEmpty() == true){
            AlertBox.displayAlertBox("Exception", "Empty circuit");
        }

        //Verifica que no solo exista una compuerta y una salida
        if (finalList.getLength() == results(finalList).getLength()){
            AlertBox.displayAlertBox("Exception", "Your circuit is so simple");
        }
        else {

            // Verifica que todas las entradas tengan un valor
            if (readyFinalList(finalList) == false){
                AlertBox.displayAlertBox("INCOMPLETE CIRCUIT", "Please connect all your circuit by giving every input its value");
            } else if (readyFinalList( finalList) == true){

                //Almacena la lista de las compuertas que necesitan calcular su salida
                DoublyLinkedList resultsFinalList = results(finalList);
                int contOuts = 0;

                //Ciclo para ir revisando la lista, contOuts son la cantidad de resultados que se tienen que ir obteniendo de todas las compuertas
                while(contOuts < finalList.getLength()) {
                    int i = 0;

                    //Ciclo que va revisando la lista
                    while (i < finalList.getLength()){

                        //Compuerta con la que se está trabajando actualmente
                        Gate currentGate = finalList.getGate(i);

                        //Verifica si es un NOT, caso especial
                        if (currentGate.getName() == "NOT") {

                            //Verifica si su única entrada está en nulo, si es así no se calcula y sigue con el ciclo
                            if (currentGate.getInput1State() == null) {
                                i++;
                            }
                            //Si ya se conoce el valor de la entrada, se aplica la lógica de la compuerta para obtener el resultado
                            else if (currentGate.getInput1State() != null && currentGate.isCalculated() == false) {
                                boolean calculatedOutput = currentGate.logic();
                                currentGate.setOutput(calculatedOutput);
                                i++;

                                //Se aumenta el 1 el contOut porque ya se sabe
                                contOuts++;
                            }
                        }

                        //Si es cualquier compuerta excepto un NOT
                        else if (currentGate.getName() != "NOT") {

                            // Si son entradas no son conocidas(nulas), se continúa con el ciclo
                            if (currentGate.getInput1State() == null && currentGate.getInput2State() == null) {
                                i++;
                            }

                            // Si se conocen, se aplica la lógica, se conectan y se agregan las referencias reales del circuito, no de la lista
                            else if ((currentGate.getInput1State() != null || currentGate.getInput2State() != null) && currentGate.isCalculated() == false) {
                                currentGate.logic();

                                //Si la conexión siguiente de la compuerta actual es hacia un input1
                                if (currentGate.getOutputState() == "input1") {
                                    joinSource_Input1(currentGate, currentGate.realNext);
                                    currentGate.realNext.setInput1State("true");
                                    i++;
                                    contOuts++;
                                }
                                //Si la conexión siguiente de la compuerta actual es hacia un input2
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

    /**
     * Método que revisa la lista y verifica que todas las entradas tengan un valor
     * @param finalList
     * @return True si la lista está conectada, false si le hace falta algún valor de entrada
     */

    public static boolean readyFinalList(DoublyLinkedList finalList){
        int j = 0;
        while (j < finalList.getLength()){

            //Casos para NOT y las demás compuertas
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

    /**
     * Método que revisa la lista de compuertas y en otra lista devuelve las compuertas que son de salida
     * @param finalList
     * @return Una lista con las compuertas finales del circuito, a las que hay que calcular su valor de salida y mostrarlo
     * @throws MalformedURLException
     */
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

    /**
     * Método que crea una ventana emergente con los resultados del circuito
     * @param resultList
     */

    public static void showResults(DoublyLinkedList resultList){
        int h = 0;
        String finalMessage = "The results are: " + "\n";

        // Revisa la lista y agrega los resultados al mensaje de la ventana
        while(h < resultList.getLength()){
            finalMessage += ("For: " + resultList.getGate(h).getMyID() + ": " + resultList.getGate(h).getGateOut().getId() + ": " + resultList.getGate(h).getOutput() + "\n");
            h++;
        }
        AlertBox.displayResultAlertBox("Circuit results", finalMessage);
    }
}
