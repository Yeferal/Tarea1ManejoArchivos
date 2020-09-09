/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1archivos;

import funcionalidad2.Buscador;
import funcionalidad2.Visualizador;
import java.util.ArrayList;
import java.util.Scanner;


/**================Nota=============================
 * 
 * El archivo tiene que estar en la ubicacion dentro de la caret del proyecto**/
public class Main {

    
    public static void main(String[] args) throws ClassNotFoundException {
        ArrayList<Dato> listado = new ArrayList<>();
        Archivo arch = new Archivo();
        Buscador buscador = new Buscador();
        Visualizador visualizador = new Visualizador();
        arch.leerArchivo();
        listado = arch.listaF;
        
        boolean salir = true;
        while (salir) {            
            System.out.println("+=====================+");
            System.out.println("|1. Nuevo Registro    |");
            System.out.println("|2. Buscar            |");
            System.out.println("|3. Actualizar        |");
            System.out.println("|4. Ver Registro      |");
            System.out.println("|5. Eliminar          |");
            System.out.println("|6. Mostra Listado    |");
            System.out.println("|0. Salir             |");
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
                    listado = arch.listaF;     
                    arch.crearArchivo(listado, da); // aqui mismo se implemetan el metodo de insercion segun el orden donde vaya el registro
                    
                    break;
                case "4":
                    arch.leerArchivo();
                    listado = arch.listaF;
                    visualizador.ordenarMenu(listado);
                    break;
                case "0":
                    salir = false;
                    break;
                case "2":
                    System.out.println("Escriba el Dato que desea buscar");
                    String datoBusacar = sc.nextLine();
                    buscador.buscarDato(datoBusacar, listado);
                    
                    break;
                case "3":
                    arch.leerArchivo();
                    arch.mostrarRegistros();
                    listado = arch.listaF;
                    System.out.println("Selecciona el # Registro que deseas Actualizar");
                    int numRegistro = sc.nextInt();
                    buscador.actualizar(numRegistro, listado);
                    break;
                case "5":
                    arch.leerArchivo();
                    listado = arch.listaF;
                    visualizador.mostrar(listado);
                    System.out.println("Escriba el nombre completo");
                    String nombre = sc.nextLine();
                    arch.eliminar(nombre);
                    break;
                case "6":
                    arch.leerArchivo();
                    listado = arch.listaF;
                    visualizador.mostrar(listado);
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;
            }
        }
    }
    
    
}
