my_str = "maria mono care mono feo"

if "mono" in my_str:
    print(my_str[3:12]) # para imprimir una parte
    print(my_str.strip())#borra espacios innecesarios
    print(my_str.replace("mo", "pe")) #cambia o remplaza lo que le pidamos
    

my_txt = "cali, america, nacional, envigado"
my_list = my_txt.split(",")  #convierte str en lista
print(len(my_list)) #cuantos elementos hay en la lista

print(my_list[:]) # imprime solo las posiciones pedidas
my_list[0] = "campeon" #cambia el objeto de la lista por que se escribio
my_list.insert(0, "cali ")
print(my_list)


price = 20
print(f"the price is {price:.2f}") # agregar descimales al final del numero

opa= "holaaa{}"
print(opa.format(price))  # agrega la variable donde estan las llaves