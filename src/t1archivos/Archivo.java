
package t1archivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Archivo {
    
    String ruta = "Datos";
    ArrayList<Dato> listaF = new ArrayList<>();
    
    
    //meotodo que inserta el nuevo dato segun el orden en el que se encuentra
    
    public  void agregarOrdenado(Dato dato){
        ArrayList<Dato> listaAux = new ArrayList<>();
        if(listaF.size()>0){
            for (int i = 0; i < listaF.size(); i++) {
                if(listaF.get(i).getNombre().compareTo(dato.getNombre())>0){
                    listaAux.add(dato);
                    for (int j = i; j < listaF.size(); j++) {
                        listaAux.add(listaF.get(j));
                    }
                    break;
                }

            }
        }else{
            listaAux.add(dato);
        }
        listaF = listaAux;
    }
    
    public void crearArchivo(ArrayList<Dato> lista, Dato dato){
        File file = new File(ruta);
        if(!validarNombre(dato.nombre)){
            //Se Busca donde va ir el dato
            agregarOrdenado(dato);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
                String texto = "";
                for (int i = 0; i < listaF.size(); i++) {
                    texto += listaF.get(i).nombre+"|"+listaF.get(i).numero+"|"+listaF.get(i).red1+"|"+listaF.get(i).getRed2()+" \n";
                }
                System.out.println(texto);
                outputStream.writeObject(texto);
                outputStream.close();
                System.out.println("listo");
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Ya existe un Usuario con ese nombre");
            lista.remove(lista.size()-1);
        }
            
    }
    
    public void guardar(ArrayList<Dato> lista){
        File file = new File(ruta);
        try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
                String texto = "";
                for (int i = 0; i < lista.size(); i++) {
                    texto += lista.get(i).nombre+"|"+lista.get(i).numero+"|"+lista.get(i).red1+"|"+lista.get(i).getRed2()+" \n";
                }
                outputStream.writeObject(texto);
                outputStream.close();
            }catch(IOException e){
                e.printStackTrace();
            }
    }
    
    public void leerArchivo() throws ClassNotFoundException{
        File file = new File(ruta);
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        String n = null;
        listaF.clear();
        
        try {
            
            fis = new FileInputStream(ruta);
            entrada = new ObjectInputStream(fis);
            String texto = (String) entrada.readObject();
            String lineas [] = texto.split("\n");
            System.out.println(texto);
            for (int i = 0; i < lineas.length; i++) {
                String l = lineas[i];
                
                String t [] = l.split("\\|");
                if(t.length>=4){
                    String nombre = (t[0].isEmpty())? "----":t[0];
                    String numero = (t[1].isEmpty())? "----":t[1];
                    String red1 = (t[2].isEmpty())? "----":t[2];
                    String red2 = (t[3].isEmpty())? "----":t[3];
                    Dato d = new Dato(nombre, numero, red1, red2);
                    listaF.add(d);
                }
                
                
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean validarNombre(String nombre){
        boolean existe = false;
        for (int i = 0; i < listaF.size()-1; i++) {
            if (listaF.get(i).getNombre().equals(nombre)) {
                System.out.println("Existe");
                return true;
            }
        }
        System.out.println("No Existe");
        return existe;
    }
    
    
    public void mostrarRegistros(){
        for (int i = 0; i < listaF.size(); i++) {
            System.out.println((i+1)+")  "+listaF.get(i).toString());
        }
    }
    
    public void eliminar(String nombre){
        boolean existe = false;
        for (int i = 0; i < listaF.size(); i++) {
            if(listaF.get(i).getNombre().equals(nombre)){
                listaF.remove(i);
                guardar(listaF);
                System.out.println("Se elimino el registro");
                existe = true;
                break;
            }
        }
        if (!existe) {
            System.out.println("No exite registro con ese nombre");
        }
    }
    
}
