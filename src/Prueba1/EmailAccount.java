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
    
    public void mostrarInbox(){
        int total=0;
        int sinLeer=0;
        
        System.out.println("Cuenta: "+correo+" - "+nombre);

        for(int i =0;i< inbox.length;i++){
            if(inbox[i] != null){
                total++;

                String estado =inbox[i].isLeido() ? "LEIDO" : "SIN LEER";
                    
                if(!inbox[i].isLeido()){
                    sinLeer++;
                }

                System.out.println(i+ " - "+inbox[i].getEmisor()+" - "+inbox[i].getAsunto()+" - "+estado);
            }
        }
        
        System.out.println("Correos sin leer: "+sinLeer);
        System.out.println("Total de correos: "+total);
    }

    public void leerCorreo(int pos){
        if(pos>= 0 && pos<inbox.length && inbox[pos] !=null){
            inbox[pos].imprimir();
            inbox[pos].marcarLeido();
        }else{
            System.out.println("Correo No Existe");
        }
    }

    public void limpiarInbox(){
        for(int i = 0; i < inbox.length; i++){
            if(inbox[i] != null && inbox[i].isLeido()){
                inbox[i] = null;
            }
        }
    }
    
}
    

