import dao.DAOArchivo;
import modelo.*;
import java.io.*;

import misExcepciones.*;

public class CalculadoraAritmeticaApp {
    public static void main(String[] theFile) {
        DAOArchivo miDAO = new DAOArchivo();
        ArbolExpresiones expr = new ArbolExpresiones();
        OperacionesAritmeticas objOperaciones;
        String[] expresionesPostfijas;
        String[] resultadosEvalauaciones;
        String path = "operaciones.txt";

        try {
            miDAO.readFile(path);
            String[] arrayExpresiones = miDAO.getData();
            expresionesPostfijas = new String[arrayExpresiones.length];
            resultadosEvalauaciones = new String[arrayExpresiones.length];
            double resultadoOperacion;
            NodoArbol raizPArbol;

            for (int i = 0; i < arrayExpresiones.length; i++) { // Con este for se recorre a todo el arreglo de expresiones

                if (arrayExpresiones[i].length() < 1) {
                    System.out.println("Debe ejecutarse: ArbolExp \"expresion con espacios y parentesis\" ");
                } else {

                    for (int j = 0; j < arrayExpresiones[i].length(); j++) {

                        try {
                            raizPArbol = expr.construirArbol(arrayExpresiones[j]);

                            // System.out.print("El arbol es ");
                            // expr.imprime(raizPArbol);
                            System.out.print("\nEl arbol en postfija es ");
                            expr.imprimePos(raizPArbol);
                            System.out.println();

                            // Se ingresa la expresion en notacion postfija al arreglo de String en notacion postfija
                            expresionesPostfijas[j] = expr.crearStringPos(raizPArbol);
                            System.out.println("Expresion en array: " + expresionesPostfijas[j]); // Quitar o comentar
                            // Nos limpia la variable en el objeto que regresa el String de expresion. Evita el concatenado que no se necesita
                            expr.setPostClean();

                            // Se ingresa el resultado de la operacion de la expresion ya en formato de String a su arreglo
                            objOperaciones = new OperacionesAritmeticas(expresionesPostfijas[j]);
                            objOperaciones.expresionAPila();
                            resultadoOperacion = objOperaciones.getResultadoEvaluacion();
                            resultadosEvalauaciones[j] = String.valueOf(resultadoOperacion);
                            System.out.println("Resultado op: " + resultadosEvalauaciones[j]); // Quitar o comentar

                            System.out.println("\n");

                        } catch (StackException e) {
                            e.printStackTrace();
                        }

                        miDAO.writeFile("Prueba1", expresionesPostfijas, resultadosEvalauaciones);
                    }
                    
                }
                
            }
            
            // Se hace un limpiado de las variables auxiliares
            resultadoOperacion = 0;
            raizPArbol = null;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}
