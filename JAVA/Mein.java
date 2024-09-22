public class Mein {
    static void metodo(){
        System.out.println("Donde estan las loquitas de la B?");
    }
    int x = 45, y = 50;
    String name ="Johan";
    static String lastName ="Mora";
    public static void main (String[] args){
        Mein obj1 = new Mein();
        Mein obj2 = new Mein();

        int s = (int)(Math.random()*3);
        System.out.println(s);
        if(s<2){
            System.out.println(obj1.name+" "+obj2.lastName+" edad ["+obj2.x+"]");

        }else{
            System.out.println(obj1.name+" "+obj2.lastName+" edad ["+obj1.y+"]");
        }
        metodo();
        meni ojeto =new meni(s, lastName);
        ojeto.statePlane(140);
        ojeto.speedPlane(233);
        
    }
}
class meni {
    int a;
    String mame;

    public void statePlane(int y){

        if(y>0){
            System.out.println("the plane is take off! with "+y+" meters");

        } else {
            System.out.println("the plain is on land! with "+y+" meters");
        }

    }

    public void speedPlane(int x){
if (x>300){
    System.out.println("The plane is "+x+"km/h = very Fast!");

} else if (x>200){
    System.out.println("The palne is "+x+"km/h = good speed");
}else{
    System.out.println("The plane is "+x+"km/h very low");
}
    }

    public meni(int y, String meme){
        a=y;
        mame=meme;

    }

    public static void main(String[] args) {
    
        meni oject = new meni(32, "johan"   );
        System.out.println("la edad es "+oject.a+" con nombre "+oject.mame);
       
    
    }
        

    }
   