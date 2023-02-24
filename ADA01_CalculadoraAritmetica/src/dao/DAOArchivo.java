package dao;

import java.io.*;

public class DAOArchivo {
    private BufferedReader reader; // To read the file
    private String line;
    private String parts[];
    private File file;
    private int rows;

    public DAOArchivo() {
        
    }

    public DAOArchivo(String fileName) {
        this.file = new File(fileName);
    }

    public void readFile(String path) throws IOException {
        file = new File(path);
        rows = rowsCounter();
        this.parts = new String[rows];
        int i = 0;
        reader = new BufferedReader(new FileReader(file));

        while ((line = reader.readLine()) != null) {
            parts[i] = line;
            i++;
        }
    }

    public String[] getData() {
        return parts;
    }

    public int rowsCounter() {
        int rows = 0;

        try {
            reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                rows++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Somethig went wrong while working on the file");
        }

        return rows;
    }

    public void writeFile(String fileName, String[] expresionesPostfijas, String[] resultadosEvaluaciones) {
        String typeFile = ".txt";
        file = createFile(fileName, typeFile);

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            // writer.println("Prueba Escribe"); // what the function writes on the new file
            // writer.println("Hola");
            // writer.println("Provando actualizacion");

            for (int i = 0; i < expresionesPostfijas.length; i++) {
                writer.println("Expresion postfija: " + expresionesPostfijas[i] + "; Resultado: " + resultadosEvaluaciones[i]);
            }

            writer.close();
            System.out.println("Se escribio en el archivo");

            writer.close();

            // PrintWriter out = new PrintWriter(new BufferedWriter(new
            // FileWriter(file.getAbsoluteFile())));
            // out.write("First line");
            // out.println();
            // out.write("Second line");
            // out.close();
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("File not found exception");
            fileNotFound.printStackTrace(System.out);
        } catch (IOException exception) {
            exception.printStackTrace(System.out);
        }
    }

    // https://www.youtube.com/watch?v=FiHTc8reFQY -----------------------------------------------------------------------------
    //quiero unos cheetitos
    public File createFile(String fileNameAux, String typeFile) {
        String fileName = "archivosFinales/" + fileNameAux + typeFile; // El archivo se guarda en el folder definido
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
