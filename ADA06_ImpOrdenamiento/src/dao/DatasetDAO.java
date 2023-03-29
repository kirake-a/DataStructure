package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.Country;
import model.DoublyLinkedList;

public class DatasetDAO {
    private DoublyLinkedList<Country> data;
    private String path;
    private BufferedReader reader;

    public DatasetDAO(String path) {
        data = new DoublyLinkedList<>();
        this.path = path;
    }

    public void readFile() throws IOException {
        File file = new File(this.path);

        if (file.canRead()) {
            reader = new BufferedReader(new FileReader(this.path));
        } else {
            throw new IOException();
        }
    }
    
}
