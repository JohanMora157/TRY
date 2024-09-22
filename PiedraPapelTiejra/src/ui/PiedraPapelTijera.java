package ui;

import java.util.Random;
import java.util.Scanner;

public class PiedraPapelTijera{
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        
        String [] opcionesJuego = {"PIEDRA", "PAPEL", "TIJERA"};
        
        System.out.println("--PIEDRA, PAPEL, TIJERA--");
        System.out.println("PRESIONE ENTER PARA JUGAR");
        scanner.nextLine();


        System.out.println("Bienvenido al juego de piedra, papel o tijera");

        boolean salir = false;
        int contJugador,contMaquina;
        while (salir==false) {
            
            System.out.println("SELECCIONE UN MODO DE JUEGO\n1=El mejor de tres\n2=El mejor de cinco\n3=El mejor de siete\n4=Salir");
        int modo = scanner.nextInt();
        scanner.nextLine();

    if (modo==4 || modo==1 || modo==2 || modo==3) {
        switch (modo) {
            case 1:
            contJugador=0;
            contMaquina=0;
            while (contJugador!=3 && contMaquina!=3) {
                System.out.println("SELECCIONE UNA OPCION \n1-PIEDRA \n2-PAPEL \n3-TIJERA");
                String opcion = scanner.nextLine();
                opcion = opcion.toLowerCase();
                turno_jugador(opcion);
                String opcionBot = turno_maquina(opcionesJuego);
                System.out.println("La maquina sacó -"+opcionBot+"-");
                opcionBot = opcionBot.toLowerCase();
                

               if (opcion.toLowerCase().equals(opcionBot.toLowerCase())){
                System.out.println("Empate, no hay punto para ninguno");
    
    
               }else if ((opcion.toLowerCase().equals("piedra")&&opcionBot.toLowerCase().equals("tijera"))||
               (opcion.toLowerCase().equals("papel")&&opcionBot.toLowerCase().equals("piedra"))||
               (opcion.toLowerCase().equals("tijera")&&opcionBot.toLowerCase().equals("papel"))){
    
                System.out.println("GANASTE");
                contJugador++;
    
               }else{
    
                System.out.println("PERDISTE");
                contMaquina++;
               }  
               System.out.println("PUNTUACION TÚ= "+contJugador+" Maquina= "+contMaquina);
            }
            if (contJugador==3){
                System.out.println("has sido el ganador de las 3 rondas");

            }else if(contMaquina==3){
                System.out.println("La maquina te ha vencido");

            }
            
           
                break;
            case 2:
            contJugador=0;
            contMaquina=0;
            while (contJugador!=5 && contMaquina!=5) {
                System.out.println("SELECCIONE UNA OPCION \n1-PIEDRA \n2-PAPEL \n3-TIJERA");
                String opcion = scanner.nextLine();
                opcion = opcion.toLowerCase();
                turno_jugador(opcion);
                String opcionBot = turno_maquina(opcionesJuego);
                System.out.println("La maquina sacó -"+opcionBot+"-");
                opcionBot = opcionBot.toLowerCase();
                

               if (opcion.toLowerCase().equals(opcionBot.toLowerCase())){
                System.out.println("Empate, no hay punto para ninguno");
    
    
               }else if ((opcion.toLowerCase().equals("piedra")&&opcionBot.toLowerCase().equals("tijera"))||
               (opcion.toLowerCase().equals("papel")&&opcionBot.toLowerCase().equals("piedra"))||
               (opcion.toLowerCase().equals("tijera")&&opcionBot.toLowerCase().equals("papel"))){
    
                System.out.println("GANASTE");
                contJugador++;
    
               }else{
    
                System.out.println("PERDISTE");
                contMaquina++;
               }  
               System.out.println("PUNTUACION TÚ= "+contJugador+" Maquina= "+contMaquina);
            }
            if (contJugador==5){
                System.out.println("has sido el ganador de las 5 rondas");

            }else if(contMaquina==5){
                System.out.println("La maquina te ha vencido🤖");

            }
            
           
                break;
            case 3:
            contJugador=0;
            contMaquina=0;
            while (contJugador!=7 && contMaquina!=7) {
                System.out.println("SELECCIONE UNA OPCION \n1-PIEDRA \n2-PAPEL \n3-TIJERA");
                String opcion = scanner.nextLine();
                opcion = opcion.toLowerCase();
                turno_jugador(opcion);
                String opcionBot = turno_maquina(opcionesJuego);
                System.out.println("La maquina sacó -"+opcionBot+"-");
                opcionBot = opcionBot.toLowerCase();
                

               if (opcion.toLowerCase().equals(opcionBot.toLowerCase())){
                System.out.println("Empate, no hay punto para ninguno");
    
    
               }else if ((opcion.toLowerCase().equals("piedra")&&opcionBot.toLowerCase().equals("tijera"))||
               (opcion.toLowerCase().equals("papel")&&opcionBot.toLowerCase().equals("piedra"))||
               (opcion.toLowerCase().equals("tijera")&&opcionBot.toLowerCase().equals("papel"))){
    
                System.out.println("GANASTE");
                contJugador++;
    
               }else{
    
                System.out.println("PERDISTE");
                contMaquina++;
               }  
               System.out.println("PUNTUACION TÚ= "+contJugador+" Maquina= "+contMaquina);
            }
            if (contJugador==7){
                System.out.println("has sido el ganador de las 7 rondas");

            }else if(contMaquina==7){
                System.out.println("La maquina te ha vencido🤖");

            }
            
                break;
            case 4:
            salir=true;
           
                break;
        }
      if (salir==false){
        System.out.println("Quiere jugar de nuevo? \n1-SI \n2-NO");
        int respuesta = scanner.nextInt();
        if(respuesta==2){
        salir=true;
        
      }  
    
    
    }
    
    
    }
         
    
    
    
    
           
}
    
    
    
    
       
    
    
       
        }

        public static String turno_maquina(String[] opcionesJuego){
            int opcionMaquina = random.nextInt(0,3);
            //System.out.println(opcionesJuego[opcionMaquina]);

           return opcionesJuego[opcionMaquina];
        }

        public static void turno_jugador(String opcion){

            switch (opcion) {
                case "piedra":
                System.out.println("Su opcion ha sido -"+opcion.toUpperCase()+"-");
                    break;
                case "papel":
                System.out.println("Su opcion ha sido -"+opcion.toUpperCase()+"-");
                break;
                case "tijera":
                System.out.println("Su opcion ha sido -"+opcion.toUpperCase()+"-");

                break; 

               
            }
        }
    }
    
    
    
