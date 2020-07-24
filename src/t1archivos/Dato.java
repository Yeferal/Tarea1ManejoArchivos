/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1archivos;

/**
 *
 * @author LENOVO-PC
 */
public class Dato {
    String nombre, numero, red1, red2;

    public Dato(String nombre, String numero, String red1, String red2) {
        this.nombre = nombre;
        this.numero = numero;
        this.red1 = red1;
        this.red2 = red2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRed1() {
        return red1;
    }

    public void setRed1(String red1) {
        this.red1 = red1;
    }

    public String getRed2() {
        return red2;
    }

    public void setRed2(String red2) {
        this.red2 = red2;
    }
    public String toString(){
        return "Nombre: "+nombre+",\t\tNumero: "+numero+",\t\tRedSocial1: "+red1+",\t\tRedSocial2: "+red2;
    }
    
}
