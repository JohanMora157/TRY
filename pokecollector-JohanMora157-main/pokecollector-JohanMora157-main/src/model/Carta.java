package model;

public class Carta {
    


    private String id;  //se referencia a usar this
    private String nombre;
    private int puntosVida;
    private String tipo;
    private String rareza;
    
//metodos
    ///constructor
    public Carta(String id, String nombre, int puntosVida, String tipo, String rareza){
this.id = id;
this.nombre = nombre;
this.puntosVida= puntosVida;
this.tipo=tipo;
this.rareza=rareza;

}

public void setID(String id){
this.id=id;

}

public String getID(){
return id;

}

public void setNombre(String nombre){
    this.nombre=nombre;
    
    }
    
public String getNombre(){
    return nombre;
    
}    

public void setPuntosVida(int puntosVida){
    this.puntosVida=puntosVida;
    
    }
    
public int getPuntosVida(){
    return puntosVida;
    
}

public void setTipo(String tipo){
    this.tipo=tipo;
    
    }
    
public String getTipo(){
    return tipo;
    
}

public void setRareza(String rareza){
    this.rareza=rareza;
    
    }
    
public String getRareza(){
    return rareza;
    
}

 
public String toString(){
    return id+" - "+nombre+" - "+puntosVida+" - "+tipo+" - "+rareza;
}



}