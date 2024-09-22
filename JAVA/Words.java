import java.util.Scanner;
import java.util.Random;


public class Words {
  
  static Scanner scanner = new Scanner(System.in);
  static Random random = new Random();
  
  static String[] word;
    public static void main(String[] args) {

        while (true) {
            
        
 int numLeters = scanner.nextInt();
 word = new String[numLeters];
String[] vocals = {"a","e","i","o","u"};
String [] consonants ={"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};
int numConsonant, numVocals;
for (int i =0; i<word.length;i++){
if(i%2==0){
     numVocals = random.nextInt(0,vocals.length);
word[i]=vocals[numVocals];

}else{
      numConsonant= random.nextInt(0,consonants.length);
      word[i]=consonants[numConsonant];
}


}

for(int i=0;i<word.length;i++){
  System.out.print(word[i]);

}
System.out.println(" ");
if(scanner.nextInt()==2){
    break;

}  
}





}

   




    }

