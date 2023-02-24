package modelo;

import misExcepciones.StackException;

public class OperacionesAritmeticas {
    private String expresionPost;
    private double resultadoEvaluacion;


    public OperacionesAritmeticas(String expresionPost) {
        this.expresionPost = expresionPost;
    } 

    public void expresionAPila() {
        PilaGenerica<String> miPila = new PilaGenerica<>(this.expresionPost.length());
        String[] miArray = expresionPost.split(" ");

        try {
            for (int i = 0; i < miArray.length; i++) {

                if (miArray[i].equals("+") | miArray[i].equals("-") | miArray[i].equals("*") | miArray[i].equals("%") |
                        miArray[i].equals("/") | miArray[i].equals("^")) {

                    double pop1 = Double.parseDouble(miPila.pop());
                    double pop2 = Double.parseDouble(miPila.pop());

                    double resultado = operacion(pop1, pop2, miArray[i]);
                    // System.out.println("resultado: " + resultado);
                    miPila.push(String.valueOf(resultado));
                } else {
                    miPila.push(miArray[i]);
                }
               
            }
            
            // Resultado final del proceso se ingresa a la variable que regresa a donde se pida
            setResultadoEvaluacion(Double.parseDouble(miPila.pop()));
            //System.out.println("Pila " + miPila.pop());
        } catch (StackException e) {
            e.printStackTrace();
        }

    }
    //merecmos un 100
    public double operacion(double pop1, double pop2, String operador) {
        double resultado = 0;

        switch (operador) {
            case "+":
                resultado = pop2 + pop1;
                break;

            case "-":
                resultado = pop2 - pop1;
                break;

            case "*":
                resultado = pop2 * pop1;
                break;

            case "%":
                resultado = pop2 % pop1;
                break;

            case "/":
                resultado = pop2 / pop1;
                break;

            case "^":
                resultado = Math.pow(pop2, pop1);
                break;

            default:
                break;
        }

        return resultado;
    }

    public double getResultadoEvaluacion() {
        return resultadoEvaluacion;
    }

    private void setResultadoEvaluacion(double resultadoEvaluacion) {
        this.resultadoEvaluacion = resultadoEvaluacion;
    }

}
