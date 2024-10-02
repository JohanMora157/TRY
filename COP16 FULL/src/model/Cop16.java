
package model;

public class Cop16 {

    public Place[] places;
    public Voluntary[] voluntaries;
    public Specie[] species;
    public Community[] communities;
    public Route[] routes;

    public Cop16() {
        places = new Place[30];
        voluntaries = new Voluntary[10];
        species = new Specie[50];
        communities = new Community[30];
        routes = new Route[3];
    }

    public boolean guardar_voluntario(String id, String name) {

        Voluntary voluntary = new Voluntary(id, name);

        // for (int i = 0; i < voluntaries.length; i++) {
        // if (voluntaries[i] == null) {

        voluntaries[0] = voluntary;
        return true;
        // }
        // }

        // return false;

    }

    public String mensaje_de_ruta(String ruta) {
        // rutas
        String farallones, ladera, oriente;
        farallones = "La Ruta de los Farallones tiene como punto de encuentro Calle 16 - Universidad del Valle iniciando a las 6:40 am, y termina a las 4:00 pm.";
        ladera = "La Ruta de las Laderas tiene como punto de encuentro Calle 16 - Universidad del Valle iniciando a las 6:40 am, y termina a las 4:00 pm.";
        oriente = "La Ruta de el Oriente tiene como punto de encuentro Calle 16 - Universidad del Valle iniciando a las 6:40 am, y termina a las 4:00 pm.";
        // que ruta se escoge
        String msg = "";
        switch (ruta) {
            case "farallones":
                msg = farallones;

            case "oriente":
                msg = oriente;

            case "laderas":
                msg = ladera;

        }
        return msg;
    }

    public boolean guardar_ruta(String name, double temperature, double humidity, int numAttendants, int numGuides,
            int numBuses) {

        Route route = new Route(name, temperature, humidity, numAttendants, numGuides, numBuses);
        routes[0] = route;
        return true;

    }

    public int calcular_buses(int totalPersonas) {
        int totalBuses;
        if (totalPersonas % 25 == 0) {

            totalBuses = totalPersonas / 25;

        } else {

            totalBuses = 1 + (totalPersonas / 25);
        }
        return totalBuses;

    }

    public boolean calcular_clima(double tempGradosC, double porHumedad) {

        if ((tempGradosC >= 20 && tempGradosC <= 25) && (porHumedad <= 60 && porHumedad >= 40)) {
            return true;

        } else {
            return false;

        }

    }

    public boolean guardar_lugar(String photoPlace, double economicResources, String name, String department,
            double area) {
        Place place = new Place(photoPlace, economicResources, name, department, area);

        for (int i = 0; i < places.length; i++) {
            if (places[i] == null) {
                places[i] = place;

                return true;
            }
        }
        return false;
    }

    public String construir_lista_lugares() {

        String lista = "";
        boolean validar = false;
        for (int j = 0; j < places.length; j++) {
            if (places[j] != null) {
                lista += "\n" + places[j].getName() + " - " + places[j].getDepartment() + " - " + places[j].getArea();

                validar = true;
            }

        }
        if (validar == false) {
            lista = "No hay lugares registrados";
        }
        return lista;
    }//

    public String ordenar_menor_mayor() {
        String mensaje = "";

        if (places[1] != null) {
            for (int i = 0; i < places.length; i++) {
                int indice = i;
                for (int j = i + 1; j < places.length; j++) {
                    if (places[j] != null && places[indice] != null) {
                        if (places[j].getArea() < places[indice].getArea()) {
                            indice = j;// guarda la posicion del menor
                        }
                    }

                }

                Place indicePlace = places[i];
                places[i] = places[indice];
                places[indice] = indicePlace;
            }

        } else {
            mensaje = "No hay suficientes lugares registradas";
        }
        return mensaje;

    }

    public String dep_mas_registrado() {
        int contDep = 0, contActual = 0;// para llevar el numero de repeticiones por departamento
        String maxDep = "", actualDep = ""; // para capturar el mas repetido

        // Contar lugares por departamento
        for (int i = 0; i < places.length; i++) {
            if (places[i] != null) {
                contActual = 0;
                actualDep = places[i].getDepartment();
                for (int j = 0; j < places.length; j++) {
                    if (places[j] != null) {
                        if (places[j].getDepartment().equals(actualDep)) {
                            contActual++;
                        }
                    }
                    if (contActual > contDep) {
                        contDep = contActual;
                        maxDep = actualDep;
                    }
                }

            }

        }
        return maxDep;
    }
}