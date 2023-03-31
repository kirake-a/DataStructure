package dao;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class DaoPDF {
    String name;
    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;

    public DaoPDF(){
        this.name = "finalFiles/" + "TablaMetricas";
        documento = new Document();
        titulo = new Paragraph("Metricas de los algoritmos de ordenamiento");
    }

    public void createPDF(long teM, int ncm, int nim, long teb, int ncb, int nib, long teq, int ncq, int niq){
        try {
            archivo = new FileOutputStream(name + ".pdf");
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            titulo.setAlignment(1);//1 es en medio, default es izquierda

            documento.add(titulo);
            documento.add(Chunk.NEWLINE);

            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            PdfPCell cero = new PdfPCell(new Phrase("Algoritmo"));
            cero.setBackgroundColor(BaseColor.PINK);
            PdfPCell tiempo = new PdfPCell(new Phrase("Tiempo de Ejecucion"));
            tiempo.setBackgroundColor(BaseColor.PINK);
            PdfPCell numComparaciones = new PdfPCell(new Phrase("Numero de comparaciones"));
            numComparaciones.setBackgroundColor(BaseColor.PINK);
            PdfPCell numInter = new PdfPCell(new Phrase("Numero de Intercambios"));
            numInter.setBackgroundColor(BaseColor.PINK);
            

            tabla.addCell(cero);
            tabla.addCell(tiempo);
            tabla.addCell(numComparaciones);
            tabla.addCell(numInter);
        
            tabla.addCell("MergeSort");
            tabla.addCell(String.valueOf(teM));
            tabla.addCell(String.valueOf(ncm));
            tabla.addCell(String.valueOf(nim));

            tabla.addCell("BinaryInsertionSort");
            tabla.addCell(String.valueOf(teb));
            tabla.addCell(String.valueOf(ncb));
            tabla.addCell(String.valueOf(nib));

            tabla.addCell("QuickSort");
            tabla.addCell(String.valueOf(teq));
            tabla.addCell(String.valueOf(ncq));
            tabla.addCell(String.valueOf(niq));

            documento.add(tabla);

            documento.close();

            System.out.println("PDF created correctly");

        } catch (Exception e) {
            System.out.println("Error creating the PDF file");
        }
    }
}
