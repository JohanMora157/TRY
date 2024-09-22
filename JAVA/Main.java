public class Main{
    /**
     * @param args
     */
    public static void main(String[]args){

        int a, b, c;
        a=13;
        b=53;
        c=12;
        String x, y, z;
        x="johan";
        y="mora";
        z="guzman";
        boolean on, off;
        on=true;
        off=false;

        System.out.println(x + " " + y + " " + z + " ");
        System.out.println(a+b+c);

        x="JOHAN";  
        System.out.println(x.toLowerCase() + " " + y.toUpperCase() + " " + z + " "+x.length()+y.length()+z.length());
        
        y="java es un lenguaje\rde programacion que se utiliza\nen el \"minecraft\"";
        System.out.println(y);    
        
        System.out.println(Math.max(a, b));
       
        /*  int rifa = (int) (Math.random()*101);  Esta es otra forma de hacer que imprima un numero de 1--100 aleatoriamente*/
        System.out.println("Su numero del 1 al 100 es : "+(int) (Math.random()*100));
        
        if (a>b){
            System.out.println(a+" es mayor que todos");

        } else if (b>c){
            System.out.println(b+" es mayor que todos");
        } else {
            System.out.println(c+" es el mayor de todos");
        }

        /* Esta es otra forma de hacer condicionales en una linea */
        String hola = (a>b)? "sizas" : "nonas";
        System.out.println(hola);

        int code = 1234;
        if (code==1234){
            System.out.println("Codigo correcto, Puerta abierta");

        } else {
            System.out.println("Codigo incorrecto, Puerta cerrada");
        }

        int n1;
        n1=12   ;
        
        if(n1 % 2==0){
            System.out.println("es par");

        } else {
            System.out.println("es impar");
        }

        if(n1>0){
            System.out.println("El numero es positivo");

        } else if (n1<0){
            System.out.println("El numero es negativo");

        } else {
            System.out.println("El numero es 0");
        }
int almuerzos=3, price=25000;
switch (almuerzos) {
    case 1:
    System.out.println("El precio total es :"+price);
    break;

    case 2:
    System.out.println("El precio total es :"+price*almuerzos);
    break;

    case 3:
    System.out.println("El precio total es :"+price*almuerzos);
    break;

    case 4:
    System.out.println("El precio total es :"+price*almuerzos);
    break;
}
//int d=0;
/*Esta es una variante del while que funciona igual */
/* 
do{
    System.out.println(d);
d++; 
} while (d<=8);

/* Este es el while
while (d<=8){
    System.out.println(d);
d++;
} 
*/

int numE=1, not;
 
while (numE<8){
    not=(int)(Math.random()*5);

if (not>=3){
    System.out.println("Estudiante ["+numE+"] Aprovo! con "+not);
} else {
    System.out.println("Estudiante ["+numE+"] Perdio! con "+not);
}
numE++;
}
/*Pa el for hay que definir la variable en la prinmera ; porque sino no funciona  */
//for (int numE=1; numE<=5; numE++){
//System.out.println(numE);

//}

for (int pc=4; pc<=10; pc++){
    if(pc==7){
        continue; //se puede usar break o continue
        }
        
System.out.println("Numero del pc ["+pc+"]");


for (int prog=1; prog<=3; prog++){
System.out.println("Que programa desea? Programa ["+prog+"]");
}
}

String [] students ={"juan", "pedro", "luis"};  

for (String es : students){
System.out.println(es);
if((int) (Math.random()*5) >3 ){
    System.out.println("el estudiante aprovo");
} else {
    System.out.println("El estudiante reprobo");
}
}
        

int[] nume ={1, 2, 3, 4, 5, 6, 7, 8, 9};

String[] pepol= {"juan","pedro","luis","david"};



for(int cont=0; cont<9; cont++){

    int seCo= (int)(Math.random()*4);

        System.out.println(nume[cont]+"El estudiante "+pepol[seCo]);
}

/* esta es otra forma de hacer lo de arriba
for(int pllp : nume ){
    int seco= (int)(Math.random()*4);
System.out.println(pllp+" El estudiante "+pepol[seco]);
*/

//}

int[] notas = {2, 3, 2, 4, 5, 5, 4};
int min = notas[0];
for (int nw : notas){
    int seco = (int)(Math.random()*4);

    System.out.println("El estudiante ["+pepol[seco]+"] sacó ="+nw);
    
    if(min>=nw){
        min=nw;
        System.out.println("la nota mas baja fue    "+ min+pepol[seco]);
}

}

int[][] loteria ={{2,4,6},{1,3,5}};

//esta es una forma de imprimir arrays o matrices dobles
for (int j=0; j<loteria.length;j++){
for(int k=0;k<loteria[j].length;k++){
System.out.println(loteria[j][k]);
}
}


    }
    }
    
