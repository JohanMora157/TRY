import java.util.Scanner;
public class TareaIntgradora1{
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);



//Registrar nombre del voluntario
System.out.println("--Bienvenido voluntario a la aplicación de Interacción de Rutas Ecológicas COP 16 Cali - Colombia. \n--¿Cuál es tu nombre?");
String nombre = scanner.nextLine();

//Registrar cedula del voluntario
System.out.println("Por favor, digite tu cédula.");
int cedula = scanner.nextInt();
scanner.nextLine();

//Bienvenida y seleccion de ruta
System.out.println("¡Bienvenido, "+nombre+"!");
System.out.println("¿Qué ruta registrarás el día de hoy?" +"\n"+"1-Farallones \n2-Oriente \n3-Laderas");


boolean pasar = false;//boolean para frenar el while
//while que repite el scanner cuando el usuario digita la ruta mal 
while (pasar==false){
String selecRuta= scanner.nextLine();
selecRuta = selecRuta.toLowerCase();

 if(selecRuta.equals("farallones")){

        mensaje_de_ruta(selecRuta);
        pasar=true;//frenar while

    }else if(selecRuta.equals("oriente")){

        mensaje_de_ruta(selecRuta);
        pasar=true;//frenar while

    }else if(selecRuta.equals("laderas")){

        mensaje_de_ruta(selecRuta);
        pasar=true;//frenar while

    }else if (selecRuta.length()==0){ //posibles errores cometidos por el usuario
            System.out.println("--Error, espacio en blanco\nDigite la ruta nuevamente!");
    }else{
            System.out.println("--Error, la ruta NO existe\nDigite la ruta nuevamente!");
            }


}

//Registro del numero de participantes
System.out.println("¿Cuántos participantes acudirán a la caminata el día de hoy?");
int numParticipantes = scanner.nextInt();
//Registro del numero de guias
System.out.println("¿Cuántos guías acudirán a la caminata el día de hoy?");
int numGuias = scanner.nextInt();
//Registro de temperatura
System.out.println("Ingresar la temperatura en grados centígrados °C");
double tempGradosC= scanner.nextDouble(); 
//Registro de porcentaje de humedad
System.out.println("Ingresar el porcentaje de humedad relativa");
double porHumedad= scanner.nextDouble(); 

calcular_clima(tempGradosC, porHumedad);

int totalPersonas = numParticipantes+numGuias;//calcular total de personas (guias y participantes)

//Imprime mensaje con el total de personas
System.out.println("Al ser un total de "+ totalPersonas+" personas que harán parte de la actividad, se necesitarán un total de:");

//Imprime mensaje con el numero de buses
System.out.println((calcular_buses(totalPersonas))+" buses para llevarla a cabo de manera exitosa. ¡Nos vemos en la COP16!");

}


/**
 * Descripción: Este método calcula el número necesario de buses para transportar a un grupo de personas, 
 * asumiendo que cada bus tiene una capacidad de 25 personas. Si el número total de personas no es 
 * un múltiplo exacto de 25, se requiere un bus adicional para acomodar a las personas restantes.
 *
 * @param int totalPersonas El número total de personas que necesitan ser transportadas.
 * 
 * @return El número total de buses necesarios para transportar a todas las personas.
 */
public static int calcular_buses(int totalPersonas){
int totalBuses;
if(totalPersonas%25==0){

    totalBuses=totalPersonas/25;

}else{

    totalBuses=1+(totalPersonas/25);
}
return totalBuses;

}


/**
 * Descripción: Este método evalúa la temperatura y la humedad para determinar si es un buen día 
 * para caminar en Cali. Si la temperatura está entre 20°C y 25°C y la humedad entre 40% y 60%, 
 * se considera un buen día para caminar. De lo contrario, no es el mejor día.
 *
 * @param double tempGradosC La temperatura en grados Celsius.
 * @param double porHumedad El porcentaje de humedad relativa.
 * 
 * @return No retorna ningún valor (void). Imprime en consola un mensaje que indica si es un buen día 
 *         para caminar en Cali o no.
 */
public static void calcular_clima (double tempGradosC, double porHumedad){

    if((tempGradosC>=20 && tempGradosC <=25)&&(porHumedad<=60 && porHumedad>=40)){

       System.out.println("¡Hace un buen día para caminar por Cali!");

    }else{

    System.out.println("No es el mejor dia para caminar por cali");
    
        }

}


/**
 * Descripción: Este método evalúa la ruta ingresada por el usuario y retorna un mensaje
 * que describe el punto de encuentro y el horario de la ruta seleccionada.
 *
 * @param String ruta Una cadena de texto que representa el nombre de la ruta seleccionada por el usuario.
 *             Puede ser "farallones", "oriente", o "laderas".
 * 
 * @return Imprime en consola un mensaje con la información
 *         de la ruta seleccionada.
 */
public static void mensaje_de_ruta(String ruta) {
    //rutas
String farallones, ladera, oriente;
    farallones="La Ruta de los Farallones tiene como punto de encuentro Calle 16 - Universidad del Valle iniciando a las 6:40 am, y termina a las 4:00 pm.";
    ladera="La Ruta de las Laderas tiene como punto de encuentro Calle 16 - Universidad del Valle iniciando a las 6:40 am, y termina a las 4:00 pm.";
    oriente ="La Ruta de el Oriente tiene como punto de encuentro Calle 16 - Universidad del Valle iniciando a las 6:40 am, y termina a las 4:00 pm.";
    //que ruta se escoge 

switch (ruta) {
        case "farallones":
            System.out.println("¡Excelente! "+farallones);
            break;
        case "oriente":
        System.out.println("¡Excelente! "+oriente);
            break;
        case "laderas":
            System.out.println("¡Excelente! "+ladera);
            break;
    }
}
    
}

