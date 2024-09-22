package ui;

import java.util.Scanner;

public class GestionLugaresCOP16 {
    //Generar las variables globales
    static Scanner scanner;
    static String [] lugaresRegistrados;
    static String [] departamentosLugares;
    static int [] areaLugaresRegistrados;
    static int  contadorLugar;
    

public static void main(String[]args) {
//Iniciar las variables globales    
inicializarGlobales();
    System.out.println("Bienvenido voluntario a la aplicación de Gestión de Lugares Biodiversos COP 16 Cali - Colombia.");
    System.out.println("Te presentamos las siguientes opciones, ingresa:");
//while para que el usuario pueda repetir opciones
while (true) {
 System.out.println("1. Para registrar un lugar con diversidad biológica.\n" +
                    "2. Para consultar los lugares ordenados de menor a mayor con respecto al área.\n" +
                    "3. Para consultar el departamento que tiene más lugares con diversidad biológica registrados hasta el momento.\n" +
                    "4. Para salir del programa.");

System.out.print(">");
int opcion = scanner.nextInt();
//Condicion para romper el while o para salir del ciclo
if (opcion == 4) {
    break;
}
scanner.nextLine(); 
//switch con las opciones del programa
switch (opcion) {
    //Tomar o registar el lugar, su departamento y su area 
    case 1:
        System.out.print("Ingresa el nombre del lugar biodiverso\n>");
        lugaresRegistrados[contadorLugar] = scanner.nextLine();//guarda en el arreglo

        System.out.print("Ingresa el departamento en el cual está el lugar\n>");
        departamentosLugares[contadorLugar] = scanner.nextLine();

        System.out.print("Ingresa la cantidad de kilómetros cuadrados que abarca el lugar\n>");
        areaLugaresRegistrados[contadorLugar] = scanner.nextInt();

        System.out.println("Lugar ingresado con éxito.");
        contadorLugar++;//variable para llevar la cuenta de lugares registrados
    break;
    //Imprime la lista de las areas con lugar de menor a mayor
    case 2:
        if (contadorLugar == 0) {
            System.out.println("No se han registrado lugares aún");
        } else {
            System.out.println("Los lugares ordenados de menor a mayor con respecto al área hasta el momento son:");
            int areasOrdenadas[]= lista_lugar_area(contadorLugar, areaLugaresRegistrados, lugaresRegistrados, departamentosLugares);
            imprimir_lista_lugar_area(lugaresRegistrados, areasOrdenadas);
        }
    break;
    //Imprime el departamento con mas lugares registrados
    case 3:
        if (contadorLugar == 0) {
            System.out.println("No se han registrado lugares aún");
        } else {
            System.out.println("El departamento con más lugares biodiversos registrados es:");

            String depPopular =dep_mas_registrado(contadorLugar, departamentosLugares);
            int repDepPopular = num_repeticiones_dep(depPopular, contadorLugar, departamentosLugares);
            System.out.println( depPopular+ " con " + repDepPopular + " lugares");
        }
    break;

    default:
            System.out.println("Valor fuera de las opciones, digite uno válido!");
    break;
}
}
}

    /**
 * Descripción: Inicializa las variables globales utilizadas en el programa.
 * pos: El arreglo "lugaresRegistrados" queda inicializado.
 * pos: El arreglo "departamentosLugares" queda inicializado.
 * pos: El arreglo "areaLugaresRegistrados" queda inicializado.
 * pos: El contador "contadorLugar" queda inicializado en 0.
 * pos: El Scanner "scanner" queda inicializado.
 */
public static void inicializarGlobales(){
    scanner = new Scanner(System.in);
    lugaresRegistrados = new String[30];
    departamentosLugares = new String[30];
    areaLugaresRegistrados = new int[30];
    contadorLugar = 0;

}


/**
 * Descripción: Imprime la lista de lugares y sus áreas correspondientes.
 * pre: El arreglo "lugar" no puede ser nulo y debe estar inicializado.
 * pre: El arreglo "area" no puede ser nulo y debe estar inicializado.
 * @param lugar String[] El arreglo que contiene los nombres de los lugares registrados.
 * @param area int[] El arreglo que contiene las áreas de los lugares registrados en kilómetros cuadrados.
 */
public static void imprimir_lista_lugar_area(String[] lugar, int[] area) {
    for (int i = 0; i < contadorLugar; i++) {
        System.out.println(">" + lugar[i] + "-" + area[i]);
        }
    }



/**
 * Descripción: Determina  el departamento con más lugares biodiversos registrados.
 * pre: El arreglo "departamentosLugares" no puede ser nulo y debe estar inicializado.
 * @param contadorLugar int Número total de lugares registrados.
 * @param departamentosLugares String[] El arreglo que contiene los nombres de los departamentos asociados a los lugares registrados.
 * @return maxDep String es el departamento que mas se repitio
 */
public static String dep_mas_registrado(int contadorLugar, String[] departamentosLugares){
    int contDep = 0, contActual=0;//para llevar el numero de repeticiones por departamento
    String maxDep = "", actualDep=""; //para capturar el mas repetido


    // Contar lugares por departamento  
    for (int i = 0; i < contadorLugar; i++) {
        contActual = 0;
        actualDep = departamentosLugares[i];
        for (int j = 0; j < contadorLugar; j++) {
            if (departamentosLugares[j].equals(actualDep)) {
                contActual++;
                }
        }
            if (contActual > contDep) {
                contDep = contActual;
                maxDep = actualDep;
            }
    }
                        
    return maxDep;
}

/**
 * Descripción: Determina  el numero de repeticiones del departamento mas registrado
 * pre: El arreglo "departamentosLugares" no puede ser nulo y debe estar inicializado.
 * @param departamento String Es el departamento que mas se repitio, viene del metodo dep_mas_registrado()
 * @param contadorLugar int Número total de lugares registrados.
 * @param departamentosLugares String[] El arreglo que contiene los nombres de los departamentos asociados a los lugares registrados.
 * @return contActual int es el numero de veces en el que se repitio el departamento del metodo  dep_mas_registrado()
 */                   
public static int num_repeticiones_dep(String departamento, int contadorLugar, String[] departamentosLugares){
    int contActual = 0; //para capturar el numero de veces que se repite el departamento
    for(int i = 0; i<contadorLugar;i++){
        if(departamentosLugares[i].equals(departamento)){
        contActual++;
        }
    }
    return contActual ;
}



/**
 * Descripción: Ordena los lugares de menor a mayor según el área y ajusta las posiciones en los arreglos de áreas, lugares y departamentos.
 * pre: Los arreglos "areaLugar", "lugar" y "departamento" no pueden ser nulos y deben estar inicializados.
 * @param contadorLugar int Número total de lugares registrados.
 * @param areaLugar int[] El arreglo que contiene las áreas de los lugares registrados en kilómetros cuadrados.
 * @param lugar String[] El arreglo que contiene los nombres de los lugares registrados.
 * @param departamento String[] El arreglo que contiene los departamentos asociados a los lugares registrados.
 * @return int[] El arreglo de áreas de los lugares ordenado de menor a mayor.
 */
public static int[] lista_lugar_area(int contadorLugar, int[]areaLugar, String[] lugar, String[] departamento ){
    for (int i = 0; i < contadorLugar; i++) {
        int indice = i;
        for (int j = i + 1; j < contadorLugar; j++) {
            if (areaLugar[j]< areaLugar[indice]) {
                indice = j;//guarda la posicion del area menor
            }
        }
        // Intercambiar los valores en los arreglos
        // Intercambiar en areaLugar
        int indiceArea = areaLugar[i];
        areaLugar[i] = areaLugar[indice];
        areaLugar[indice] = indiceArea;

        // Intercambiar en lugar
        String indiceLugar = lugar[i];
        lugar[i] = lugar[indice];
        lugar[indice] = indiceLugar;

        // Intercambiar en departamento
        String indiceDepartamento = departamento[i];
        departamento[i] = departamento[indice];
        departamento[indice] = indiceDepartamento;
    }
    
return areaLugar;
}



}
