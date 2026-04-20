/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1;

/**
 *
 * @author Gabriel
 */
public class Email {
    
    private String emisor;
    private String asunto;
    private String contenido;
    private boolean leido = false;

    public Email(String emisor, String asunto, String contenido) {
        this.emisor = emisor;
        this.asunto = asunto;
        this.contenido = contenido;
    }

    public String getEmisor() {
        return emisor;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public boolean isLeido() {
        return leido;
    }
    
    public void marcarLeido(){
       leido = true;
    }
    
    public void imprimir(){
        System.out.println("DE: "+emisor);
        System.out.println("ASUNTO: "+asunto);
        System.out.println(contenido);
    }
    
}
