/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1archivos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LENOVO-PC
 */
public class Main {

    
    public static void main(String[] args) throws ClassNotFoundException {
        ArrayList<Dato> listado = new ArrayList<>();
        Archivo arch = new Archivo();
        arch.leerArchivo();
        listado = arch.listaF;
        boolean salir = true;
        while (salir) {            
            System.out.println("+=====================+");
            System.out.println("|1. Nuevo Registro    |");
            System.out.println("|2. Ver Registro      |");
            System.out.println("|3. Salir             |");
            System.out.println("+=====================+");
            Scanner sc = new Scanner(System.in); 

            String opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    Dato da = new Dato(" ", " ", " ", " ");
                    System.out.println("Escribe tu Nombre: ");
                    da.setNombre(sc.nextLine());
                    System.out.println("Escribe tu Numero de Telefono: ");
                    da.setNumero(sc.nextLine());
                    System.out.println("Escribe tu Red Social 1: ");
                    da.setRed1(sc.nextLine());
                    System.out.println("Escribe tu Red Social 2: ");
                    da.setRed2(sc.nextLine());
                    
                    listado.add(da);
                    arch.crearArchivo(listado);
                    System.out.println("listo");
                    break;
                case "2":
                    arch.leerArchivo();
                    arch.mostrarRegistros();
                    break;
                case "3":
                    salir = false;
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;
            }
        }
    }
    
}
