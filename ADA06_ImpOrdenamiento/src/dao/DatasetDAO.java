package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import model.Country;
import model.DoublyLink;
import model.DoublyLinkedList;

public class DatasetDAO {
    private DoublyLinkedList<Country> data;
    public BufferedReader reader;
    private File file;
    private String line;

 
    public DatasetDAO(String path) {
        data = new DoublyLinkedList<>();
        this.file = new File(path);
    }
    /*
     * public void readFile() throws IOException {
     * File file = new File(this.path);
     * 
     * if (file.canRead()) {
     * reader = new BufferedReader(new FileReader(this.path));
     * } else {
     * throw new IOException();
     * }
     * }
     */

    public DoublyLinkedList<Country> getFileData() throws NumberFormatException{
        Country country;
        String parts[];
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                parts = line.split(",");
                country = new Country(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3]), Double.parseDouble(parts[4]), Double.parseDouble(parts[5]),
                        Double.parseDouble(parts[6]), Double.parseDouble(parts[7]));
                data.insertLast(country);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al instanciar variable reader");
            e.printStackTrace();
        } catch (IOException e1) {
            System.out.println("Es posible que no existan countrys en este documento");
        }
        return data;
    }

    public void writeFile(String path, DoublyLinkedList<Country> data, int order) {
        file = createFile(path);

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            switch (order) {
                case 0:
                    DoublyLink<Country> current = data.getFirst();

                    while (current != null) {
                        writer.println(current.getdData().getSerialNumber() + "," + current.getdData().getCountryName() + ","
                                + current.getdData().getTotalCases() + "," + current.getdData().getTotalDeaths() + ","
                                + current.getdData().getTotalRecovered() + "," + current.getdData().getActiveCases() + ","
                                + current.getdData().getTotalTest() + "," + current.getdData().getPopulation());
        
                                current = current.getNext();
                    }
        
                    break;
                case 1:
                    DoublyLink<Country> currentt = data.getLast();

                    while (currentt != null) {
                        writer.println(currentt.getdData().getSerialNumber() + "," + currentt.getdData().getCountryName() + ","
                                + currentt.getdData().getTotalCases() + "," + currentt.getdData().getTotalDeaths() + ","
                                + currentt.getdData().getTotalRecovered() + "," + currentt.getdData().getActiveCases() + ","
                                + currentt.getdData().getTotalTest() + "," + currentt.getdData().getPopulation());
        
                                currentt = currentt.getPrevious();
                    }
                default:
                    break;
            }
            
            writer.close();
            System.out.println("CSV created correctly");

            writer.close();

        } catch (FileNotFoundException fileNotFound) {
            System.out.println("File not found exception");
            fileNotFound.printStackTrace(System.out);
        } catch (IOException exception) {
            exception.printStackTrace(System.out);
        }
    }

    public File createFile(String fileNameAux) {
        String fileName = "finalFiles/" + fileNameAux + ".csv"; // Check how to locate it into the destination folder
        File newFile = null;

        try {
            newFile = new File(fileName);
            PrintWriter output = new PrintWriter(newFile);
            System.out.println("Archivo generado de manera satisfactoria");

            output.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Something went wrong while creating the new file");
            exception.printStackTrace(System.out);
        }

        return newFile;
    }

}
