

public class MenorMayor {

    static int[] datos = new int[5];
    static int[] orden = new int[5];
static String [] nombre = new String[5];
static String [] apellido = new String[5];
static String [] auxName = new String[5];
static String [] auxLname = new String[5];

    static int indice = 0;
    public static void main(String[] args) {

       /*  for(int i=0;i<datos.length-1;i++){
datos[i]=i+2;

        }
    datos[4]=6;
    */
 nombre[0]="a";   
 nombre[1]="e"; 
 nombre[2]="i"; 
 nombre[3]="o"; 
 nombre[4]="u";
 
 apellido[0]="b";
 apellido[1]="c";
 apellido[2]="d";
 apellido[3]="f";
 apellido[4]="g";



datos[0]=100;
datos[1]=200;
datos[2]=500;
datos[3]=400;
datos[4]=300;


int k=0;
    for(int i=0;i<datos.length;i++){
        indice=0;
        for(int j=1;j<datos.length;j++){
            
            if(datos[j]>datos[indice] ){
                
                    indice = j;

            }
            
         
            

        }
        orden[orden.length-1-i]=datos[indice];
        auxName[orden.length-1-i]=nombre[indice];
        auxLname[orden.length-1-i]=apellido[indice];


        datos[indice]=0;
        
        
    }

    for(int i= 0;i<datos.length;i++){
        datos[i]=orden[i];
        apellido[i]=auxLname[i];
        nombre[i]=auxName[i];


    }


System.out.println(indice);
   // imprimir(orden);
   imprimirt(nombre);
   imprimirt(apellido);
   
    imprimir(datos);

    }

public static void imprimir(int[] dates){

    for (int i = 0;i<dates.length;i++){

System.out.println("dato "+dates[i]);

    }


}
public static void imprimirt(String[] dates){

    for (int i = 0;i<dates.length;i++){

System.out.println("dato "+dates[i]);

    }


}

}
