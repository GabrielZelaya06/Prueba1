/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1;

/**
 *
 * @author Gabriel
 */
public class EmailAccount {
    
    private String correo;
    private String password;
    private String nombre;
    private Email [] inbox;

    public EmailAccount(String correo, String password, String nombre) {
        this.correo = correo;
        this.password = password;
        this.nombre = nombre;
        this.inbox = new Email[100];
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }
    
    public boolean recibirCorreo(Email email){
        
        for(int i=0; i<inbox.length; i++){
            if(inbox[i]==null){
                inbox[i]=email;
                return true;
            }
        }
        return false;
    }
    
}
