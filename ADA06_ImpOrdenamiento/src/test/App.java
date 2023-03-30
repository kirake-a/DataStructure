package test;

import dao.DaoPDF;
import dao.DatasetDAO;
import model.Country;
import model.DoublyLinkedList;
import model.Sorter;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

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

        DoublyLinkedList<Country> listapendeja = new DoublyLinkedList<>();
        listapendeja = sorter.sorting(0,2, data);
        dao.writeFile("Ejemplito", listapendeja);
        //sorter.printListAsc(listapendeja); // ascendente
        System.out.println("--------------------------");
        //sorter.printLIstDesc(listapendeja); //Descendiente
        System.out.println("hola");

        DaoPDF pdf = new DaoPDF();
        pdf.createPDF(sorter.getTiempoEjecucionMerge(), sorter.getNumComparacionesMerge(), sorter.getNumIntercambiosMerge(), sorter.getTiempoEjecucionBinary(), sorter.getNumComparacionesBinary(), sorter.getNumIntercambiosBinary(), sorter.getTiempoEjecucionQuick(), sorter.getNumComparacionesQuick(), sorter.getNumIntercambiosQuick());


        //sorter.sorting(1, 2, data);
        //listapendeja = sorter.sorting(2, 2, data);
        //sorter.printListAsc(listapendeja); // ascendente
        //sorter.printLIstDesc(listapendeja); //Descendiente
        //sorter.sorting(3, 0, data);

    }
}
