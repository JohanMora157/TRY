import java.io.File;
import java.io.FileWriter; 
import java.io.IOException;
import java.util.Scanner;

public class CreateFile {  
  public static void main(String[] args) {
    

     //try{  //toca usar el try
      //FileWriter ArchivoTXT = new FileWriter("txt1.bat");----   ---- esto es para escribir algo en el archivo de texto
      //ArchivoTXT.write("cali 2024 real");--------- este es el mensaje
      //ArchivoTXT.close();
      //System.out.println("todo vientos");


      File ArchivoTXT = new File("txt1"); //para borrar solo es esto con el comando ArchivoTXT. Delete()
    

    
     /*Scanner scanner = new Scanner(ArchivoTXT);        ---  esto es para poder leer lo que esta en el archivo
while (scanner.hasNextLine()) {
  String datos = scanner.nextLine();
  System.out.println(datos);
  
}
System.out.println(ArchivoTXT.getAbsolutePath());
*/
System.out.println(ArchivoTXT.delete() );


   
        
     //}catch(IOException e) {  //toca hacer el catch con IOException e por que si no no funciona
     //}
      
   
      
    }  
  }  
