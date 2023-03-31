package test;

import java.util.Scanner;

import dao.DaoPDF;
import dao.DatasetDAO;
import model.Country;
import model.DoublyLinkedList;
import model.Sorter;

public class App {
    public static int columna;
    public static int orden;

    public static void main(String[] args) throws Exception {
        Menu();

        DatasetDAO dao = new DatasetDAO("dataset/covid_worldwide_2.csv");
        DoublyLinkedList<Country> data = dao.getFileData();
        Sorter sorter = new Sorter();

        DoublyLinkedList<Country> auxList = new DoublyLinkedList<>();
        auxList = sorter.sorting(0, columna, data);
        dao.writeFile("QuickSort_ordenado", auxList, orden);
        auxList = sorter.sorting(1, columna, data);
        dao.writeFile("MergeSort_ordenado", auxList, orden);

        auxList = sorter.sorting(2, columna, data);
        dao.writeFile("BinaryInsertionSort_ordenado", auxList, orden);

        DaoPDF pdf = new DaoPDF();
        pdf.createPDF(sorter.getTiempoEjecucionMerge(), sorter.getNumComparacionesMerge(),
                sorter.getNumIntercambiosMerge(), sorter.getTiempoEjecucionBinary(), sorter.getNumComparacionesBinary(),
                sorter.getNumIntercambiosBinary(), sorter.getTiempoEjecucionQuick(), sorter.getNumComparacionesQuick(),
                sorter.getNumIntercambiosQuick());

    }
    /**
     * Menu para elegir las columna que se decia ordenar y el orden
     */
    public static void Menu() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Elija el numero de la columna con la que quiere ordenar");
            System.out.println("1 - Population");
            System.out.println("2 - CountryName");
            System.out.println("3 - ActiveCases");
            System.out.println("4 - TotalDeaths");
            int aux = sc.nextInt();

            if (aux >= 1 && aux <= 4) {
                columna = aux;
            } else {
                System.out.println("Esta opcion no existe");
                throw new Error();
            }

            System.out.println("Elija si quiere que este ordenado de manera: ");
            System.out.println("0 - Ascendente");
            System.out.println("1 - Descendente");
            aux = sc.nextInt();
            if (aux == 0 || aux == 1) {
                orden = aux;
            } else {
                System.out.println("Esta opcion no existe");
                throw new Error();
            }
        } catch (Error e) {
            e.printStackTrace();
        }

    }

}
