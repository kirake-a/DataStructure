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
        System.out.println("Hello, World!");
        Menu();

        DatasetDAO dao = new DatasetDAO("dataset/covid_worldwide_2.csv");
        DoublyLinkedList<Country> data = dao.getFileData();
        Sorter sorter = new Sorter();
        /* Sorter sorter = new Sorter();
        Country uno = new Country(1, "Dinamarca", 12.45, 56.76, 54.98, 89.09, 1000.87, 98.0f);
        Country dos = new Country(2, "Mexico", 345.4, 5476.75, 243.54, 7543.45, 2435.25, 2325.0f);
        Country tres= new Country(3, "Brazil", 2345.67, 243.34, 2343.33, 3532.535, 1000.87, 3532.34f);
        Country cuatro = new Country(4, "Alemania", 3532.23, 224.35, 3432.35, 2432.45, 2432.34, 243.23f);
        
        DoublyLinkedList<Country> data = new DoublyLinkedList<>();

        data.insertFirst(uno);
        data.insertFirst(dos);
        data.insertFirst(tres);
        data.insertFirst(cuatro);
        */
    
        DoublyLinkedList<Country> auxList = new DoublyLinkedList<>();
        auxList = sorter.sorting(0,columna, data);
        dao.writeFile("QuickSort_ordenado", auxList, orden);
        //sorter.printListAsc(auxList); // ascendente
        //System.out.println("--------------------------");
        //sorter.printListDesc(auxList); //Descendiente
        auxList = sorter.sorting(1, columna, data);
        dao.writeFile("MergeSort_ordenado", auxList, orden);

        auxList = sorter.sorting(2, columna, data);
        dao.writeFile("BinaryInsertionSort_ordenado", auxList, orden);

        //auxList = sorter.sorting(3, columna, data);
        //dao.writeFile("RadixSort_ordenado", auxList, orden);

        DaoPDF pdf = new DaoPDF();
        pdf.createPDF(sorter.getTiempoEjecucionMerge(), sorter.getNumComparacionesMerge(), sorter.getNumIntercambiosMerge(), sorter.getTiempoEjecucionBinary(), sorter.getNumComparacionesBinary(), sorter.getNumIntercambiosBinary(), sorter.getTiempoEjecucionQuick(), sorter.getNumComparacionesQuick(), sorter.getNumIntercambiosQuick());
        

        //sorter.sorting(1, 2, data);
        //listapendeja = sorter.sorting(2, 2, data);
        //sorter.printListAsc(listapendeja); // ascendente
        //sorter.printLIstDesc(listapendeja); //Descendiente
        //sorter.sorting(3, 0, data);

    }
    public static void Menu(){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Elija el numero de la columna con la que quiere ordenar");
            System.out.println("1 - Population");
            System.out.println("2 - CountryName");
            System.out.println("3 - ActiveCases");
            System.out.println("4 - TotalDeaths");
            int aux = sc.nextInt();

            if(aux >=1 && aux <=4){
                columna = aux;
            }else{
                System.out.println("Esta opcion no existe");
                throw new Error();
            }

            System.out.println("Elija si quiere que este ordenado de manera: ");
            System.out.println("0 - Ascendente");
            System.out.println("1 - Descendente");
            aux = sc.nextInt();
            if (aux == 0 || aux == 1) {
                orden = aux;
            }else{
                System.out.println("Esta opcion no existe");
                throw new Error();
            }
        } catch (Error e) {
            e.printStackTrace();
        }
        
        
    }

}
