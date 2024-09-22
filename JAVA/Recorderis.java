import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Recorderis{
    public static void main(String[]arg){

        Scanner scanner = new Scanner(System.in);
       /*  HashMap <String, Integer> Cpu = new HashMap <String, Integer>();

        for(int i=0;i<3;i++){
            String w = scanner.nextLine();
            Integer N = scanner.nextInt();
    
            Cpu.put(w, N);
            scanner.nextLine(); 

        }
        for(String re : Cpu.keySet()){
            System.out.println("String "+re+" Integer "+Cpu.get(re));
*/
        //}
//for(int t=0;t<Cpu.size();t++)
        //System.out.println(Cpu.get(t).toUpperCase());
        
         
        ArrayList<Integer> opa = new ArrayList<Integer>();
for(int e=0;e<3;e++){
Integer v =scanner.nextInt();
opa.add(v);
}
Iterator<Integer> it = opa.iterator();
while(it.hasNext()){
   int i = it.next();
        if(i<5){
        System.out.println("szs");
        it.remove();
    } else {
        System.out.println("nonas");
    }

}
        System.out.println(opa);


    }
    
}