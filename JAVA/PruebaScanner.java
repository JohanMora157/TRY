import java.util.Scanner;
import java.time.LocalDate;
public class PruebaScanner {

    public static void main (String[]args){
        LocalDate fecha = LocalDate.now();

        System.out.println("Registre su nombre: ");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        System.out.println("Registre su usuario: ");

        String usuario = scanner.nextLine();


        System.out.println("Registre su contraseña: ");
        String password = scanner.nextLine();

        System.out.println("Registre un codigo de 4 numeros: ");
        int code = scanner.nextInt();

        System.out.println("Presione [1] para continuar");
        int continuar1 = scanner.nextInt();
        scanner.nextLine(); 

        if (continuar1==1){
            System.out.println(" INICIAR SESION ");
            System.out.println("Digite su usuario: ");
           
            String usuarioComp = scanner.nextLine();
            

            System.out.println("Digite su contraseña: ");
            String passwordComp = scanner.nextLine();

            System.out.println("Digite su codigo de seguridad :");
            int codeComp = scanner.nextInt();

            System.out.println("Presione [1] para continuar");
            int continuar2 = scanner.nextInt();
             
            if(continuar2==1){
                if (usuarioComp.equals(usuario)){
                    System.out.println("correcto");
                    if(passwordComp.equals(password)){
                        System.out.println("correcto");
                        if(codeComp==code){

                            System.out.println("Sesion iniciada el "+fecha+" correctamente!");
                            System.out.println("BIENVENIDO SEÑOR@ "+name.toUpperCase() );

                        }else{ System.out.println(" Error al iniciar sesion!");}

                    }else{ System.out.println(" Error al iniciar sesion!");}

                }else{ System.out.println(" Error al iniciar sesion!");}



            }else{
                System.out.println(" No se puede continuar");
            }







        } else {
            System.out.println("No se va a continuar");
        }


    }


}