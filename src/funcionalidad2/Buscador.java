
package funcionalidad2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import t1archivos.Archivo;
import t1archivos.Dato;


public class Buscador {
    
    Scanner s = new Scanner(System.in);
    Archivo arch = new Archivo();
    
    public void buscarDato(String dato, ArrayList<Dato> listado){
        for (int i = 0; i < listado.size(); i++) {
            if(listado.get(i).getNombre().equals(dato) || listado.get(i).getNumero().equals(dato) || listado.get(i).getRed1().equals(dato) || listado.get(i).getRed2().equals(dato)){
                System.out.println((i+1)+") "+ listado.get(i).toString());
            }
        }
    }
    
    public void actualizar(int num, ArrayList<Dato> listado){
        if(num<listado.size() && num>0){
            try {
                menuActualizar(num, listado);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }else{
            System.out.println("El Registro no existe");
        }
    }
    
    public void menuActualizar(int num, ArrayList<Dato> listado) throws ClassNotFoundException{
        boolean salir = true;
        while (salir) {
            System.out.println("Que dato desea Actualizar");
            System.out.println("1.  Nombre");
            System.out.println("2.  Numero");
            System.out.println("3.  Red Social 1");
            System.out.println("4.  Red Social 2");
            System.out.println("0.  Terminar");
            String op = s.nextLine();
            
            switch(op){
                case "1":
                    System.out.println("Escriba el Nuevo Nombre   (Actual: "+listado.get(num-1).getNombre()+")");
                    String nombre = s.nextLine();
                    if(!validarNombre(nombre,listado)){
                        listado.get(num-1).setNombre(nombre);
                        System.out.println("Listo se cambio: "+listado.get(num-1).toString()+"\n");
                    }else{
                        System.out.println("Este nombre ya existe");
                    }
                    break;
                case "2":
                    System.out.println("Escriba el Nuevo numero   (Actual: "+listado.get(num-1).getNumero()+")");
                    String numero = s.nextLine();
                    listado.get(num-1).setNumero(numero);
                    System.out.println("Listo se cambio: "+listado.get(num-1).toString()+"\n");
                    break;
                case "3":
                    System.out.println("Escriba la nueva Red Social 1   (Actual: "+listado.get(num-1).getRed1()+")");
                    String r1 = s.nextLine();
                    listado.get(num-1).setRed1(r1);
                    System.out.println("Listo se cambio: "+listado.get(num-1).toString()+"\n");
                    break;
                case "4":
                    System.out.println("Escriba la nueva Red Social 2   (Actual: "+listado.get(num-1).getRed2()+")");
                    String r2 = s.nextLine();
                    listado.get(num-1).setRed2(r2);
                    System.out.println("Listo se cambio: "+listado.get(num-1).toString()+"\n");
                    break;
                case "0":
                    arch.guardar(listado);
                    System.out.println("Listo se Guardaron los cambios: "+listado.get(num-1).toString()+"\n");
                    salir = false;
                    break;
            }
        }
    }
    
    public boolean validarNombre(String nombre, ArrayList<Dato> lista){
        boolean existe = false;
        for (int i = 0; i < lista.size()-1; i++) {
            if (lista.get(i).getNombre().equals(nombre)) {
                return true;
            }
        }
        return existe;
    }
}
