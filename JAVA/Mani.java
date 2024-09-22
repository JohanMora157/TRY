public class Mani{
  //Estos son los metodos en los que uno puede definir variables y una funcion como la de imprimir, condicional y al llamarlos depues del main 
  //se van a guardar los datos ingresados en esas vairables
  static void myMethod(String names, int ages, boolean pass) { //aqui se puede usar int en vez de void pero en vez de usar imprimir se usa  return
    ages++;
    if(pass==false){
      System.out.println(names+" tiene como edad "+ages+ " y paso? : "+pass);
      System.out.println(names+" no fue admitido porque no pasó"); 
    } else if (ages<18){
      System.out.println(names+" tiene como edad "+ages+ " y paso? : "+pass);
      System.out.println(names+" no fue admitido porque no cumple con la edad"); 

    } else{
      System.out.println(names+" tiene como edad "+ages+ " y paso? : "+pass);
      System.out.println(names.toUpperCase()+" FUE ADMITIDO"); 
    } 
  }


  static int miOtromethod(int x, int y ){
return x+y;    
  }
//Aqui se pueden sumar rangos con metodos 
static int suma(int r, int R){
  if (R>r){
return R + suma(r, R-1);
  } else {
    return R;
  }
}
  public static void main(String[]arg){
    //PRIMER METODO
    myMethod("juan", 20, true);
    myMethod("david", 18, false);
    myMethod("pedro", 17, true);

    //SEGUNDO METODO
    System.out.println(miOtromethod(1, 2));

    //OR 

    //int z = miOtromethod(1, 2);
    //System.out.println (z);

    //TERCER METODO
int resultado = suma(5, 10);
System.out.println(resultado);
  }


}