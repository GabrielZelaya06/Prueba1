/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1;

import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class JavaLook {
    
    private EmailAccount[] cuentas= new EmailAccount[100];
    private EmailAccount activa= null;
    
    public void menuInicial() {

        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        int opcion;

        do{
            System.out.println("\n--- MENU INICIAL ---");
            System.out.println("1. Login");
            System.out.println("2. Crear cuenta");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            opcion = input.nextInt();
            input.next();

            switch(opcion){
                case 1:
                    login(input);
                    break;

                case 2:
                    crearCuenta(input);
                    break;
            }

        } while (opcion != 3);
    }
    
    public void login(Scanner input) {

        System.out.print("Correo: ");
        String correo = input.next();

        System.out.print("Password: ");
        String pass = input.next();

        for(int i = 0; i < cuentas.length; i++){
            if(cuentas[i] != null) {
                if (cuentas[i].getCorreo().equals(correo)&& cuentas[i].getPassword().equals(pass)) {

                    activa = cuentas[i];
                    System.out.println("Login exitoso");
                    menuPrincipal(input);
                    return;
                }
            }
        }

        System.out.println("Credenciales incorrectas");
    }
    
    public void crearCuenta(Scanner input) {

        System.out.print("Correo: ");
        String correo = input.next();

        for(int i = 0; i < cuentas.length; i++) {
            if(cuentas[i] != null && cuentas[i].getCorreo().equals(correo)) {
                System.out.println("Ese correo ya existe");
                return;
            }
        }

        System.out.print("Nombre: ");
        String nombre = input.nextLine();

        System.out.print("Password: ");
        String pass =input.nextLine();

        for(int i = 0; i < cuentas.length; i++) {
            if(cuentas[i] == null) {

                cuentas[i] = new EmailAccount(correo, pass, nombre);
                activa = cuentas[i];

                System.out.println("Cuenta creada y sesión iniciada");
                menuPrincipal(input);
                return;
            }
        }

        System.out.println("No hay espacio para más cuentas");
    }
    
    public void menuPrincipal(Scanner input){

        int opcion;
        do{
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Ver inbox");
            System.out.println("2. Mandar correo");
            System.out.println("3. Leer correo");
            System.out.println("4. Limpiar inbox");
            System.out.println("5. Cerrar sesión");
            System.out.print("Opcion: ");
            opcion = input.nextInt();
            input.next();

            switch (opcion) {

                case 1:
                    activa.mostrarInbox();
                    break;

                case 2:
                    mandarCorreo(input);
                    break;

                case 3:
                    System.out.print("Posicion: ");
                    int pos = input.nextInt();
                    input.next();
                    activa.leerCorreo(pos);
                    break;

                case 4:
                    activa.limpiarInbox();
                    System.out.println("Inbox limpiado");
                    break;

                case 5:
                    activa = null;
                    System.out.println("Sesion cerrada");
                    return;
            }

        } while (true);
    }
    
    public void mandarCorreo(Scanner input) {

        System.out.print("Destinatario: ");
        String dest =input.next();

        System.out.print("Asunto: ");
        String asunto = input.next();

        System.out.print("Mensaje: ");
        String mensaje = input.next();

        Email correo =new Email(activa.getCorreo(), asunto, mensaje);

        for(int i =0;i<cuentas.length; i++) {
            if(cuentas[i] != null && cuentas[i].getCorreo().equals(dest)) {

                boolean enviado = cuentas[i].recibirCorreo(correo);

                if(enviado){
                    System.out.println("Correo enviado");
                }else{
                    System.out.println("Inbox lleno");
                }
                return;
            }
        }

        System.out.println("Destinatario no existe");
    }
}

