package com.company;
import javax.swing.*;
import java.util.Locale;

public class Main {
    private static final  int IVANORMAL = 21;
    private static final int IVAREDUCIDA = 10;
    private static final int IVASUPEREDUCIDA = 4;

    public  static String lineas = "";
    public static float ivaNormalTotalPrecio = 0f;
    public static float ivaReducidaTotalPrecio = 0f;
    public static float ivaSuperReducidaTotalPrecio = 0f;

    public static void main(String[] args) {
        String respuesta = "si";
    String nombre = JOptionPane.showInputDialog("El nombre del cliente");
	do {
        entradaDeDatos();

        respuesta = JOptionPane.showInputDialog("Quieres añadir mas? si/no").toLowerCase();
    }while(respuesta.equals("si"));

        System.out.println(nombre.toUpperCase());
        System.out.println(lineas);

        float totalSinIva = ivaNormalTotalPrecio + ivaReducidaTotalPrecio + ivaSuperReducidaTotalPrecio;
        float totalIva = 0f;
        String lineasDeIva = "";
        if (ivaSuperReducidaTotalPrecio > 0.0)
        {
            float iva = ivaSuperReducidaTotalPrecio * 0.04f;
            totalIva += iva;
            lineasDeIva += IVASUPEREDUCIDA + "% de " + ivaSuperReducidaTotalPrecio + " = " + iva + "\n";
        }
        if (ivaReducidaTotalPrecio > 0.0)
        {
            float iva = ivaReducidaTotalPrecio * 0.1f;
            totalIva += iva;
            lineasDeIva += IVAREDUCIDA + "% de " + ivaReducidaTotalPrecio + " = " + iva + "\n";
        }
        if (ivaNormalTotalPrecio > 0.0)
        {
            float iva = ivaNormalTotalPrecio * 0.21f;
            totalIva += iva;
            lineasDeIva += IVANORMAL + "% de " + ivaNormalTotalPrecio + " = " + iva + "\n";
        }

        System.out.println("Total sin IVA = " + totalSinIva);
        System.out.println("------------------------------------");
        System.out.println(lineasDeIva);
        System.out.println("------------------------------------");
        System.out.println("Total IVA = " + totalIva);
        System.out.println("Importe total con IVA = " + (totalSinIva + totalIva));

    }

    public static  void entradaDeDatos()
    {
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Teclea la cantidad"));
        float precio = Float.parseFloat(JOptionPane.showInputDialog("Teclea el precio unitario"));
        int ivaPorcentaje;

        do{
            ivaPorcentaje = Integer.parseInt(JOptionPane.showInputDialog("Teclea el porcentaje de IVA entre 21 o 10 o 4"));
        }while((ivaPorcentaje != IVANORMAL) && (ivaPorcentaje != IVAREDUCIDA ) && (ivaPorcentaje != IVASUPEREDUCIDA));

        lineas += cantidad + " * " + precio + " = " + cantidad*precio + "\n";
        if (ivaPorcentaje == IVANORMAL)
        {
            ivaNormalTotalPrecio += cantidad*precio;
        }
        else if (ivaPorcentaje == IVAREDUCIDA)
        {
            ivaReducidaTotalPrecio += cantidad * precio;
        }
        else
        {
            ivaSuperReducidaTotalPrecio += cantidad * precio;
        }
    }
}
