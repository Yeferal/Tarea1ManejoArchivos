
package funcionalidad2;

import java.util.ArrayList;
import java.util.Scanner;
import t1archivos.Dato;

public class Visualizador {
    
    Scanner s = new Scanner(System.in);
    
    public void ordenarMenu(ArrayList<Dato> lista){
        boolean salir = true;
        while (salir) {  
            System.out.println("Ordenar por:");
            System.out.println("1.  Nombre");
            System.out.println("2.  Numero");
            System.out.println("3.  Red Social 1");
            System.out.println("4.  Red Social 2");
            System.out.println("0.  Regresar al Menu Principal");
            int op = s.nextInt();
            
            switch(op){
                case 1:
                    ordenar(1, lista);
                    mostrar(lista);
                    break;
                case 2:
                    ordenar(2, lista);
                    mostrar(lista);
                    break;
                case 3:
                    ordenar(3, lista);
                    mostrar(lista);
                    break;
                case 4:
                    ordenar(4, lista);
                    mostrar(lista);
                    break;
                case 0:
                    salir = false;
                    break;
            }
            
        }
    }
    
    private void ordenar(int op , ArrayList<Dato> lista){
        
        Dato aux; 
        for(int i=1; i<=lista.size(); i++) {  
            for(int j=0; j<lista.size()-i; j++) { 
                if(op==1 && lista.get(j).getNombre().compareTo( lista.get(j+1).getNombre()) > 0 ) { 
                    aux   = lista.get(j); 
                    lista.set(j, lista.get(j+1)); 
                    lista.set(j+1, aux); 
                }    
                if(op==2 && lista.get(j).getNumero().compareTo( lista.get(j+1).getNumero()) > 0 ) { 
                    aux   = lista.get(j); 
                    lista.set(j, lista.get(j+1)); 
                    lista.set(j+1, aux); 
                }    
                if(op==3 && lista.get(j).getRed1().compareTo( lista.get(j+1).getRed1()) > 0 ) { 
                    aux   = lista.get(j); 
                    lista.set(j, lista.get(j+1)); 
                    lista.set(j+1, aux); 
                }    
                if(op==4 && lista.get(j).getRed2().compareTo( lista.get(j+1).getRed2()) > 0 ) { 
                    aux   = lista.get(j); 
                    lista.set(j, lista.get(j+1)); 
                    lista.set(j+1, aux); 
                }    
            } 
        }
    }
    
    public void mostrar(ArrayList<Dato> listaF){
        for (int i = 0; i < listaF.size(); i++) {
            System.out.println((i+1)+")  "+listaF.get(i).toString());
        }
    }
}
