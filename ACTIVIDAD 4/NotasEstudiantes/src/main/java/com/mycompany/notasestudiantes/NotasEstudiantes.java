/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.notasestudiantes;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class NotasEstudiantes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cuantos estudianste hay en grupo?");
        int numEstudiantes = scanner.nextInt();
        
        
        //extraer notas de matematicas con un for
        double sumaTotal =0, promedioMath=0;
        System.out.println("--NOTAS DE MATEMÁTICAS--");
        for(int i=0;i<numEstudiantes;i++){
         System.out.println("Digite la nota de matemáticas del estidante ["+(i+1)+"]");
         double notas= scanner.nextDouble();
         sumaTotal +=notas;
        }
        promedioMath = sumaTotal/numEstudiantes;
        System.out.println("Notas de matemáticas registradas!");
        sumaTotal=0;
        
        //Rgeistrar las notas de español con un while
        double promedioEsp;
        int i =0;
        while(i<numEstudiantes){
            System.out.println("Digite la nota de español del estidante ["+(i+1)+"]");
         double notas= scanner.nextDouble();
         sumaTotal +=notas;
         i++;
        }
    promedioEsp = sumaTotal/numEstudiantes;
    System.out.println("Notas de español registradas!");
    sumaTotal=0;
    
    //Registrar las notas de ingles con un do while
    double promedioIng;
    int j = 0;
    
    do {
        System.out.println("Digite la nota de ingles del estidante ["+(j+1)+"]");
         double notas= scanner.nextDouble();
         sumaTotal +=notas;
         j++;
    }while(j<numEstudiantes);{
        
        promedioIng=sumaTotal/numEstudiantes;
    }
    System.out.println("Notas de ingles registradas!");
    
//Elegir el promedia que se quiere ver

boolean pasar =false;
    while(pasar ==false){
        System.out.println("¿Cual promedio desea ver?\n1-Matemáticas\n2-Español\n3-Ingles");
        int opcion = scanner.nextInt();
        switch(opcion){
        case 1:
            System.out.println("El promedio del grupo en matemáticas es ["+promedioMath+"]");
            break;
        case 2:
            System.out.println("El promedio del grupo en Español es ["+promedioEsp+"]");
            break;
        case 3:
            System.out.println("El promedio del grupo en Ingles es ["+promedioIng+"]");
            break;
        default :
            System.out.println("Error, digite 1, 2 o 3");
            break;
        }
    System.out.println("¿Desea ver otro promedio?\n1=SI\n2=NO");
    int pass = scanner.nextInt();
        if(pass==2){
            pasar=true;
        }
    
    }   
    
    
    
    
    }
}
