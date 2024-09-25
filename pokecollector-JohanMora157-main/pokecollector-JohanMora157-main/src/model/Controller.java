package model;

public class Controller {

public  Carta[] memoria;

public Controller(){
        memoria = new Carta[50];



    }//

public boolean guardarCartaEnMemoria(String id, String nombre, int puntosVida, String tipo, String rareza){
        Carta nuevaCarta = new Carta(id, nombre, puntosVida, tipo, rareza);
        for(int i = 0; i < memoria.length; i++){
            if (memoria[i] == null){
            memoria[i]= nuevaCarta;
            return true;
            }
        }
        return false;
    }//

public String construirListaDeCarta(){
        
        String lista = "";
        boolean validar = false; 
         for(int j=0; j<memoria.length; j++){
             if(memoria[j]!=null){
                 lista+="\n"+memoria[j].getID()+ " - "+memoria[j].getNombre()+ " - "+memoria[j].getPuntosVida()+" - "+memoria[j].getTipo()+" - "+memoria[j].getRareza();
                 validar=true;
             } 
             
         }
             if (validar==false){
             lista = "No hay cartas registradas";
         }
             return lista;
}//

public String buscarCarta(String idAConsultar){

    for(int k=0;k<memoria.length;k++){
        if(memoria[k].getID().equals(idAConsultar)){
            return memoria[k].toString();
        }
    }
    return null; 


}//

public boolean analizarId(String id) {
    for (int i = 0; i < memoria.length; i++) {
        if (memoria[i] != null && memoria[i].getID().equals(id)) {
            return false;  // El ID ya existe
        }
    }
    return true;  // El ID no existe, es válido
}//

public String trueModifyCard(int opcion, String mob, String id){
    Carta consulta =buscarCarta(id);
    switch (opcion) {
        case 1:
                
                        consulta.setNombre(mob);
                    
            
            break;
        case 2:
                
                    consulta.setPuntosVida(mob);
                
        
                    
            break;
        case 3:
                
                    consulta.setTipo(mob);
                
        
                    
            break;
        case 4:
                
                    consulta.setRareza(mob);
                
        
                    
            
        default:
                    System.out.println("Opcion invalida");
            break;
            }

     
    return null; 


}//

public String deleteCard(String idABorrar){


    for(int a=0;a<memoria.length;a++){
        if(memoria[a].getID().equals(idABorrar)){
            memoria[a]=null;
            return memoria[a].toString();
        }
    }
    return null; 

}//

public  String ordenarMayorMenorPv(){
    String mensaje = "";

    if(memoria[1]!=null){
        for (int i = 0; i < memoria.length; i++) {
            int indice = i;
            for (int j = i + 1; j < memoria.length; j++) {
                if(memoria[j]!=null && memoria[indice]!=null){
                    if (memoria[j].getPuntosVida()> memoria[indice].getPuntosVida() ) {
                        indice = j;//guarda la posicion del menor
                    }
                }
               
            }
            
            Carta indiceCarta = memoria[i];
            memoria[i] = memoria[indice];
            memoria[indice] = indiceCarta;
        }
         
    }else{
        mensaje ="No hay suficientes cartas registradas" ;
    }
return mensaje;

   
    
}




































    
}
