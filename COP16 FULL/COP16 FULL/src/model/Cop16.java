
package model;

public class Cop16 {

    private Place[] places;
    private Voluntary[] voluntaries;

    public Cop16() {
        places = new Place[30];
        voluntaries = new Voluntary[10];

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
                break;

            case "oriente":
                msg = oriente;
                break;
            case "laderas":
                msg = ladera;
                break;
        }
        return msg;
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

    public Voluntary buscarVoluntary(String nombreAConsultar) {

        for (int k = 0; k < voluntaries.length; k++) {
            if (voluntaries[k].getName().equals(nombreAConsultar)) {
                return voluntaries[k];
            }
        }
        return null;

    }//

    public boolean addRoutToVoluntary(String nombreVoluntary, String name, double temperature, double humidity,
            int numAttendats, int numGuides) {

        Voluntary voluntarySearch = buscarVoluntary(nombreVoluntary);

        Route newRoute = new Route(name, temperature, humidity, numAttendats, numGuides);

        return voluntarySearch.AddRoutes(newRoute);

    }

    public String calcular_num_buses_passRoute(String nombreVoluntary, String name, double temperature, double humidity,
            int numAttendats, int numGuides, int numBuses) {

        String msg = "";

        Voluntary voluntarySearch = buscarVoluntary(nombreVoluntary);

        Route[] searchRoute = voluntarySearch.getRoutes();

        for (int i = 0; i < searchRoute.length; i++) {
            if (searchRoute[i].getName().equals(name)) {

                int buses = searchRoute[i].calcular_buses();

                msg += "" + buses;

            }

        }

        return msg;

    }

    public boolean calcular_clima_passRoute(String nombreVoluntary, String name, double temperature, double humidity,
            int numAttendats, int numGuides) {

        boolean tClima = false;

        Voluntary voluntarySearch = buscarVoluntary(nombreVoluntary);

        Route[] searchRoute = voluntarySearch.getRoutes();

        for (int i = 0; i < searchRoute.length; i++) {
            if (searchRoute[i].getName().equals(name)) {

                tClima = searchRoute[i].calcular_clima();

            }

        }
        if (tClima == true) {

            return true;
        }
        return false;

    }

    public Place buscarPlace(String nombreAConsultar) {

        for (int k = 0; k < places.length; k++) {
            if (places[k] != null) {
                if (places[k].getName().equals(nombreAConsultar)) {
                    return places[k];
                }

            }

        }
        return null;

    }//

    public boolean addSpecieToPlace(String nombrePlace, String name, String photoSpecie, int amount) {

        Place searchPlace = buscarPlace(nombrePlace);
        if (searchPlace == null) {
            return false;
        }

        Specie newSpecie = new Specie(name, photoSpecie, amount);

        return searchPlace.addSpecies(newSpecie);

    }

    public boolean addCommunityToPlace(String nombrePlace, String name, int numInhabitants) {

        Place searchPlace = buscarPlace(nombrePlace);

        Community newCommunity = new Community(name, numInhabitants);

        return searchPlace.addCommunities(newCommunity);

    }

    public boolean addRepresentativeToCommunity(String nombrePlace, String name, String phoneNumber) {

        Place searchPlace = buscarPlace(nombrePlace);

        Representative newRepresentative = new Representative(name, phoneNumber);

        Community searchCommunity = searchPlace.getCommunities();

        return searchCommunity.addRepresentative(newRepresentative);

    }

    public boolean trueModifySpecie(String namePlace, String nameSpecie, String mod, int opcion) {
        Specie consulta = buscarSpecie(nameSpecie, nameSpecie);

        if (consulta == null) {

            return false;

        } else {

            switch (opcion) {
                case 1:

                    consulta.setName(mod);

                    break;
                case 2:

                    consulta.setAmount(Integer.parseInt(mod));

                    break;
                case 3:

                    consulta.setPhotoSpecie(mod);

                    break;

            }

            return true;
        }

    }

    public Specie buscarSpecie(String nombrePlace, String nombreAConsultar) {
        Place searchPlace = buscarPlace(nombrePlace);

        if (searchPlace == null) {
            return null;
        }
        Specie[] species = searchPlace.getSpecies();

        for (int k = 0; k < species.length; k++) {
            if (species[k] != null) {
                if (species[k].getName().equals(nombreAConsultar)) {
                    return species[k];
                }
            }

            // }

        } //
        return null;
    }

    public String PlaceTop() {
        String maxPl = ""; // Para almacenar el nombre del lugar con más especies
        int maxSpeciesCount = -1, numspecies = 0; // Para almacenar el mayor número de especies encontradas

        for (int i = 0; i < places.length; i++) {
            numspecies = 0;
            if (places[i] != null) {
                Specie[] species = places[i].getSpecies();
                // Obtiene la cantidad de especies del lugar actual
                for (int j = 0; j < places[i].getSpecies().length; j++) {
                    if (species[j] != null) {
                        numspecies++;

                    }

                }
                int speciesCount = numspecies;

                // Si el lugar actual tiene más especies que el máximo actual, actualiza el
                // máximo
                if (speciesCount > maxSpeciesCount) {
                    maxSpeciesCount = speciesCount;
                    maxPl = places[i].getName();
                }
            }
        }

        return maxPl; // Devuelve el nombre del lugar con más especies
    }

}
