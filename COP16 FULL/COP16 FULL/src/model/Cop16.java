
package model;

public class Cop16 {

    private Place[] places;
    private Voluntary[] voluntaries;
    private String[] departments = { "choco", "valle", "narino", "cauca" };
    private String[] typesSpecie = { "fauna", "flora" };
    private String[] typesCommunity = { "afrocolombiana", "indigena", "raizal" };

    public Cop16() {
        places = new Place[30];
        voluntaries = new Voluntary[10];

    }

    /**
     * Descripción: Verifica si un lugar con el nombre especificado existe en el
     * arreglo de lugares.
     * 
     * pre: El arreglo "places" no puede ser nulo y debe estar inicializado.
     * 
     * @param namePlace String Nombre del lugar que se desea verificar.
     * @return boolean True si el lugar existe en el arreglo, false en caso
     *         contrario.
     * 
     *         pos: El estado de la variable global "places" no se modifica.
     * 
     */

    public boolean checkExistPlace(String namePlace) {

        for (int i = 0; i < places.length; i++) {
            if (places[i] != null) {
                if (places[i].getName().equals(namePlace)) {
                    return true;

                }
            }

        }

        return false;
    }

    /**
     * Descripción: Verifica si un tipo de comunidad especificado existe en el
     * arreglo de tipos de comunidades.
     * 
     * pre: El arreglo "typesCommunity" no puede ser nulo y debe estar inicializado.
     * 
     * @param type String El tipo de comunidad que se desea verificar.
     * @return boolean True si el tipo de comunidad existe en el arreglo, false en
     *         caso contrario.
     * 
     *         pos: El estado de la variable global "typesCommunity" no se modifica.
     * 
     */

    public boolean checkTypeCommunity(String type) {
        for (int i = 0; i < typesCommunity.length; i++) {
            if (type.toLowerCase().equals(typesCommunity[i])) {

                return true;

            }

        }

        return false;
    }

    /**
     * Descripción: Verifica si el tipo ingresado coincide con uno de los tipos
     * registrados.
     * pre: El arreglo "types" debe estar inicializado y no puede ser nulo.
     * 
     * @param type String El tipo a verificar.
     * @return boolean True si el tipo se encuentra registrado, false en caso
     *         contrario.
     */

    public boolean checkTypeSpecie(String type) {
        for (int i = 0; i < typesSpecie.length; i++) {
            if (type.toLowerCase().equals(typesSpecie[i])) {

                return true;

            }

        }

        return false;
    }

    /**
     * Descripción: Verifica si el departamento ingresado coincide con uno de los
     * departamentos registrados.
     * pre: El arreglo "departments" debe estar inicializado y no puede ser nulo.
     * 
     * @param department String El nombre del departamento a verificar.
     * @return boolean True si el departamento se encuentra registrado, false en
     *         caso contrario.
     */

    public boolean checkDepartment(String department) {

        for (int i = 0; i < departments.length; i++) {
            if (department.toLowerCase().equals(departments[i])) {

                return true;

            }

        }

        return false;

    }

    /**
     * Descripción: Verifica si hay al menos un lugar registrado en el arreglo de
     * lugares.
     * pre: El arreglo "places" debe estar inicializado y no puede ser nulo.
     * 
     * @return boolean True si hay al menos un lugar registrado, false en caso
     *         contrario.
     */

    public boolean checkPlace() {
        if (places[0] == null) {

            return false;

        } else {
            return true;
        }

    }

    /**
     * Descripción: Verifica si hay al menos una comunidad registrada en algún
     * lugar.
     * pre: El arreglo "places" debe estar inicializado y no puede ser nulo.
     * 
     * @return boolean True si alguna comunidad está registrada en un lugar, false
     *         en caso contrario.
     */

    public boolean checkCommunity() {
        for (int i = 0; i < places.length; i++) {
            if (places[i] == null) {
                return false;
            }
            if (places[i].checkCommunity() == true) {

                return true;

            }

        }
        return false;
    }

    /**
     * Descripción: Verifica si hay al menos una especie registrada en algún lugar.
     * pre: El arreglo "places" debe estar inicializado y no puede ser nulo.
     * 
     * @return boolean True si alguna especie está registrada en un lugar, false en
     *         caso contrario.
     */

    public boolean checkSpecie() {
        for (int i = 0; i < places.length; i++) {
            if (places[i] == null) {
                return false;
            }
            if (places[i].checkSpecie() == true) {

                return true;

            }

        }
        return false;
    }

    /**
     * Descripción: Verifica si una especie ya está registrada en un lugar
     * determinado.
     * pre: El arreglo "places" debe estar inicializado y no puede ser nulo. El
     * lugar debe existir.
     * 
     * @param namePlace  String El nombre del lugar donde se busca la especie.
     * @param nameSpecie String El nombre de la especie a verificar.
     * @return boolean True si la especie no está registrada en el lugar, false en
     *         caso contrario.
     */

    public boolean checkRepeatSpecie(String namePlace, String nameSpecie) {
        Place consultaPlaces = buscarPlace(namePlace);
        Specie[] consultSpecie = consultaPlaces.getSpecies();

        for (int i = 0; i < consultSpecie.length; i++) {
            if (consultSpecie[i] != null) {
                // Comparar si el nombre de la especie es igual a nameSpecie
                if (consultSpecie[i].getName().equals(nameSpecie)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Descripción: Registra un voluntario en el sistema.
     * pre: El arreglo "voluntaries" debe estar inicializado y no puede ser nulo.
     * 
     * @param id   String El identificador del voluntario.
     * @param name String El nombre del voluntario.
     * @return boolean True si el voluntario fue registrado exitosamente, false en
     *         caso contrario.
     */

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

    /**
     * Descripción: Devuelve la información de la ruta seleccionada.
     * pre: La ruta ingresada debe coincidir con una de las opciones disponibles
     * ("farallones", "oriente", "laderas").
     * 
     * @param ruta String El nombre de la ruta seleccionada.
     * @return String El mensaje con la información de la ruta.
     */

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

    /**
     * Descripción: Registra un lugar en el sistema con su foto, recursos
     * económicos, nombre, departamento y área.
     * pre: El arreglo "places" debe estar inicializado y no puede ser nulo.
     * 
     * @param photoPlace        String La foto del lugar.
     * @param economicResources double Los recursos económicos asignados al lugar.
     * @param name              String El nombre del lugar.
     * @param department        String El departamento donde se ubica el lugar.
     * @param area              double El área del lugar en kilómetros cuadrados.
     * @return boolean True si el lugar fue registrado exitosamente, false en caso
     *         contrario.
     */

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

    /**
     * Descripción: Construye una lista con los nombres, departamentos y áreas de
     * los lugares registrados.
     * pre: El arreglo "places" debe estar inicializado y no puede ser nulo.
     * 
     * @return String La lista de los lugares registrados o un mensaje indicando que
     *         no hay lugares registrados.
     */

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

    /**
     * Descripción: Ordena los lugares de menor a mayor según el área.
     * pre: El arreglo "places" debe estar inicializado y no puede ser nulo, y debe
     * haber al menos dos lugares registrados.
     * 
     * @return String Mensaje indicando si el ordenamiento se realizó o si no hay
     *         suficientes lugares registrados.
     */

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

    /**
     * Descripción: Determina el departamento con más lugares registrados.
     * pre: El arreglo "places" debe estar inicializado y no puede ser nulo, y debe
     * haber al menos un lugar registrado.
     * 
     * @return String El nombre del departamento con más lugares registrados o un
     *         mensaje indicando que no hay lugares registrados.
     */

    public String dep_mas_registrado() {

        int contDep = 0, contActual = 0;// para llevar el numero de repeticiones por departamento
        String maxDep = "", actualDep = ""; // para capturar el mas repetido

        if (places[0] != null) {
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
        } else {
            return "No hay lugares registrados aun ";
        }

        return maxDep;
    }

    /**
     * Descripción: Busca un voluntario en el arreglo de voluntarios por su nombre.
     * 
     * pre: El arreglo "voluntaries" no puede ser nulo y debe estar inicializado.
     * 
     * @param nombreAConsultar String El nombre del voluntario que se desea buscar.
     * @return Voluntary El objeto Voluntary correspondiente al nombre buscado si
     *         existe; null en caso contrario.
     * 
     *         pos: El estado de la variable global "voluntaries" no se modifica.
     * 
     */

    public Voluntary buscarVoluntary(String nombreAConsultar) {

        for (int k = 0; k < voluntaries.length; k++) {
            if (voluntaries[k].getName().equals(nombreAConsultar)) {
                return voluntaries[k];
            }
        }
        return null;

    }//

    /**
     * Descripción: Agrega una nueva ruta a un voluntario específico.
     * 
     * pre: El arreglo "voluntaries" no puede ser nulo y debe estar inicializado.
     * El nombre del voluntario "nombreVoluntary" debe ser válido y existir en el
     * arreglo.
     * 
     * @param nombreVoluntary String El nombre del voluntario al que se le quiere
     *                        agregar la ruta.
     * @param name            String El nombre de la nueva ruta.
     * @param temperature     double La temperatura asociada a la nueva ruta.
     * @param humidity        double La humedad asociada a la nueva ruta.
     * @param numAttendats    int El número de asistentes a la nueva ruta.
     * @param numGuides       int El número de guías de la nueva ruta.
     * @return boolean Retorna true si la ruta se agregó exitosamente; false en caso
     *         contrario.
     * 
     *         pos: Si el voluntario existe, el estado de la variable global
     *         "voluntaries" puede cambiar
     *         al agregar una nueva ruta al voluntario correspondiente.
     * 
     */

    public boolean addRoutToVoluntary(String nombreVoluntary, String name, double temperature, double humidity,
            int numAttendats, int numGuides) {

        Voluntary voluntarySearch = buscarVoluntary(nombreVoluntary);

        Route newRoute = new Route(name, temperature, humidity, numAttendats, numGuides);

        return voluntarySearch.AddRoutes(newRoute);

    }

    /**
     * Descripción: Calcula el número de autobuses necesarios para una ruta
     * específica de un voluntario.
     * 
     * pre: El arreglo "voluntaries" no puede ser nulo y debe estar inicializado.
     * El nombre del voluntario "nombreVoluntary" debe ser válido y existir en el
     * arreglo.
     * El nombre de la ruta "name" debe ser válido y estar asociado al voluntario.
     * 
     * @param nombreVoluntary String El nombre del voluntario del cual se desea
     *                        calcular el número de autobuses.
     * @param name            String El nombre de la ruta para la cual se desea
     *                        calcular el número de autobuses.
     * @param temperature     double La temperatura asociada a la ruta (no utilizada
     *                        en el cálculo).
     * @param humidity        double La humedad asociada a la ruta (no utilizada en
     *                        el cálculo).
     * @param numAttendats    int El número de asistentes a la ruta (no utilizada en
     *                        el cálculo).
     * @param numGuides       int El número de guías de la ruta (no utilizada en el
     *                        cálculo).
     * @param numBuses        int Número de autobuses disponible (no utilizada en el
     *                        cálculo).
     * @return String Un mensaje que contiene el número de autobuses necesarios para
     *         la ruta.
     * 
     *         pos: Si el voluntario y la ruta existen, el estado de la variable
     *         global "voluntaries" no cambia,
     *         pero se puede generar un mensaje que indica cuántos autobuses se
     *         necesitan para la ruta específica.
     * 
     */

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

    /**
     * Descripción: Determina si las condiciones climáticas de una ruta específica
     * cumplen con ciertos criterios.
     * 
     * pre: El arreglo "voluntaries" no puede ser nulo y debe estar inicializado.
     * El nombre del voluntario "nombreVoluntary" debe ser válido y existir en el
     * arreglo.
     * El nombre de la ruta "name" debe ser válido y estar asociado al voluntario.
     * 
     * @param nombreVoluntary String El nombre del voluntario del cual se desea
     *                        calcular las condiciones climáticas.
     * @param name            String El nombre de la ruta para la cual se desea
     *                        calcular las condiciones climáticas.
     * @param temperature     double La temperatura asociada a la ruta (no utilizada
     *                        en el cálculo).
     * @param humidity        double La humedad asociada a la ruta (no utilizada en
     *                        el cálculo).
     * @param numAttendats    int El número de asistentes a la ruta (no utilizada en
     *                        el cálculo).
     * @param numGuides       int El número de guías de la ruta (no utilizada en el
     *                        cálculo).
     * @return boolean true si las condiciones climáticas son adecuadas para la
     *         ruta, false en caso contrario.
     * 
     *         pos: Si el voluntario y la ruta existen, el estado de la variable
     *         global "voluntaries" no cambia,
     *         pero el método devuelve true o false dependiendo de si las
     *         condiciones climáticas son adecuadas.
     * 
     */

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

    /**
     * Descripción: Busca un lugar por su nombre y devuelve el objeto
     * correspondiente si existe.
     * 
     * pre: El arreglo "places" no puede ser nulo y debe estar inicializado.
     * El nombre del lugar "nombreAConsultar" debe ser una cadena no vacía.
     * 
     * @param nombreAConsultar String El nombre del lugar que se desea buscar.
     * @return Place El objeto Place correspondiente al nombre buscado si existe,
     *         null si no se encuentra.
     * 
     *         pos: Si el lugar con el nombre especificado existe en el arreglo
     *         "places",
     *         el estado de la variable global "places" no cambia, y se devuelve el
     *         objeto Place encontrado.
     *         Si no existe, se devuelve null.
     * 
     */

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

    /**
     * Descripción: Agrega una especie a un lugar especificado.
     * 
     * pre: El arreglo "places" no puede ser nulo y debe estar inicializado.
     * El nombre del lugar "nombrePlace" y el tipo de especie "type" deben ser
     * cadenas no vacías.
     * La cantidad "amount" debe ser un número entero positivo.
     * 
     * @param nombrePlace String El nombre del lugar al que se desea agregar la
     *                    especie.
     * @param name        String El nombre de la especie que se va a agregar.
     * @param photoSpecie String La URL o ruta de la foto de la especie.
     * @param type        String El tipo de la especie.
     * @param amount      int La cantidad de ejemplares de la especie que se desea
     *                    agregar.
     * @return boolean True si la especie fue agregada exitosamente, false en caso
     *         contrario.
     * 
     *         pos: Si el lugar especificado existe y el tipo de especie es válido,
     *         se agrega la nueva especie al lugar y se devuelve true.
     *         Si el lugar no existe o la especie no se puede agregar, se devuelve
     *         false.
     *         El estado de las variables globales "places" y la especie no se
     *         modifica
     *         si la operación no es exitosa.
     */

    public boolean addSpecieToPlace(String nombrePlace, String name, String photoSpecie, String type, int amount) {

        if (places[0] != null) {
            Place searchPlace = buscarPlace(nombrePlace);
            if (searchPlace == null) {
                return false;
            }
            if (checkTypeSpecie(type)) {

            }
            Specie newSpecie = new Specie(name, photoSpecie, amount, type);

            return searchPlace.addSpecies(newSpecie);
        } else {
            return false;

        }

    }

    /**
     * Descripción: Agrega una comunidad a un lugar especificado.
     * 
     * pre: El arreglo "places" no puede ser nulo y debe estar inicializado.
     * El nombre del lugar "nombrePlace", el tipo de comunidad "type",
     * el nombre de la comunidad "name" y los problemas deben ser cadenas no vacías.
     * La cantidad de habitantes "numInhabitants" debe ser un número entero
     * positivo.
     * 
     * @param nombrePlace    String El nombre del lugar al que se desea agregar la
     *                       comunidad.
     * @param type           String El tipo de comunidad que se va a agregar.
     * @param name           String El nombre de la comunidad que se desea agregar.
     * @param numInhabitants int La cantidad de habitantes de la comunidad.
     * @param problem1       String El primer problema asociado a la comunidad.
     * @param problem2       String El segundo problema asociado a la comunidad.
     * @param problem3       String El tercer problema asociado a la comunidad.
     * @param problem4       String El cuarto problema asociado a la comunidad.
     * @return boolean True si la comunidad fue agregada exitosamente, false en caso
     *         contrario.
     * 
     *         pos: Si el lugar especificado existe, se agrega la nueva comunidad al
     *         lugar y se devuelve true.
     *         Si el lugar no existe o la comunidad no se puede agregar, se devuelve
     *         false.
     *         El estado de las variables globales "places" y la comunidad no se
     *         modifica
     *         si la operación no es exitosa.
     */

    public boolean addCommunityToPlace(String nombrePlace, String type, String name, int numInhabitants,
            String problem1,
            String problem2,
            String problem3, String problema4) {

        Place searchPlace = buscarPlace(nombrePlace);

        Community newCommunity = new Community(name, numInhabitants, type);
        newCommunity.setProblemsCommunity(new String[] { problem1, problem2, problem3, problema4 });

        return searchPlace.addCommunities(newCommunity);

    }

    /**
     * Descripción: Agrega un representante a una comunidad de un lugar
     * especificado.
     * 
     * pre: El arreglo "places" no puede ser nulo y debe estar inicializado.
     * El nombre del lugar "nombrePlace", el nombre del representante "name"
     * y el número de teléfono "phoneNumber" deben ser cadenas no vacías.
     * 
     * @param nombrePlace String El nombre del lugar al que pertenece la comunidad.
     * @param name        String El nombre del representante que se desea agregar.
     * @param phoneNumber String El número de teléfono del representante que se
     *                    desea agregar.
     * @return boolean True si el representante fue agregado exitosamente, false en
     *         caso contrario.
     * 
     *         pos: Si el lugar especificado y la comunidad asociada existen, se
     *         agrega el nuevo representante
     *         a la comunidad y se devuelve true. Si el lugar o la comunidad no
     *         existen, o si no se puede
     *         agregar el representante, se devuelve false. El estado de las
     *         variables globales "places"
     *         y "representative" no se modifica si la operación no es exitosa.
     */

    public boolean addRepresentativeToCommunity(String nombrePlace, String name, String phoneNumber) {

        Place searchPlace = buscarPlace(nombrePlace);

        Representative newRepresentative = new Representative(name, phoneNumber);

        Community searchCommunity = searchPlace.getCommunities();

        return searchCommunity.addRepresentative(newRepresentative);

    }

    /**
     * Descripción: Modifica la información de una especie en un lugar específico.
     * 
     * pre: El arreglo "places" no puede ser nulo y debe estar inicializado.
     * El nombre del lugar "namePlace", el nombre de la especie "nameSpecie",
     * y la modificación "mod" deben ser cadenas no vacías.
     * La opción "opcion" debe ser un valor entero entre 1 y 3, que indica
     * el atributo a modificar.
     * 
     * @param namePlace  String El nombre del lugar donde se encuentra la especie.
     * @param nameSpecie String El nombre de la especie que se desea modificar.
     * @param mod        String El nuevo valor para el atributo especificado de la
     *                   especie.
     * @param opcion     int La opción que indica qué atributo de la especie se va a
     *                   modificar:
     *                   1 - Nombre de la especie,
     *                   2 - Cantidad de ejemplares,
     *                   3 - Foto de la especie.
     * @return boolean True si la especie fue modificada exitosamente, false en caso
     *         contrario.
     * 
     *         pos: Si la especie existe y la opción es válida, se modifica el
     *         atributo correspondiente
     *         de la especie y se devuelve true. Si la especie no existe o la opción
     *         es inválida,
     *         se devuelve false. Las variables globales "places" y "specie" se
     *         modifican si la
     *         operación es exitosa.
     */

    public boolean trueModifySpecie(String namePlace, String nameSpecie, String mod, int opcion) {
        Specie consulta = buscarSpecie(namePlace, nameSpecie);

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

    /**
     * Descripción: Busca una especie en un lugar específico según su nombre.
     * 
     * pre: El arreglo "places" no puede ser nulo y debe estar inicializado.
     * El nombre del lugar "nombrePlace" y el nombre de la especie
     * "nombreAConsultar" deben ser cadenas no vacías.
     * 
     * @param nombrePlace      String El nombre del lugar donde se busca la especie.
     * @param nombreAConsultar String El nombre de la especie que se desea
     *                         encontrar.
     * @return Specie El objeto de tipo Specie si se encuentra la especie,
     *         null si no se encuentra o si el lugar no existe.
     * 
     *         pos: Si el lugar existe y la especie se encuentra, se devuelve el
     *         objeto
     *         de tipo Specie correspondiente. Si el lugar no existe o la especie
     *         no se encuentra, se devuelve null. Las variables globales "places"
     *         y "species" no se modifican.
     */

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

    /**
     * Descripción: Determina el lugar que tiene la mayor cantidad de especies
     * registradas.
     * 
     * pre: El arreglo "places" no puede ser nulo y debe estar inicializado.
     * 
     * @return String El nombre del lugar con más especies registradas.
     *         Si no hay especies registradas en ningún lugar,
     *         devuelve "no hay especies aun".
     * 
     *         pos: Si hay lugares con especies registradas, la variable global
     *         "maxSpeciesCount" contendrá la cantidad máxima de especies
     *         encontradas, y "maxPl" contendrá el nombre del lugar correspondiente.
     *         Si no hay especies en ningún lugar, se devuelve un mensaje
     *         indicándolo,
     *         y las variables globales permanecen sin cambios.
     */

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
                if (speciesCount == 0) {
                    return "no hay especies aun";

                }
                if (speciesCount > maxSpeciesCount) {
                    maxSpeciesCount = speciesCount;
                    maxPl = places[i].getName();
                }
            }
        }

        return maxPl; // Devuelve el nombre del lugar con más especies
    }

    /**
     * Descripción: Construye una lista de las especies registradas en un lugar
     * específico, mostrando
     * el nombre, la cantidad y la foto de cada especie.
     * pre: El arreglo "places" no puede ser nulo y debe estar inicializado.
     * El lugar especificado debe existir en el sistema.
     *
     * @param place String El nombre del lugar del cual se desea obtener la lista de
     *              especies.
     * @return String Una representación en cadena de la lista de especies en el
     *         lugar especificado,
     *         o un mensaje indicando que no hay especies si no se encuentran.
     * 
     *         post: La variable "lista" contiene la representación de las especies
     *         en el lugar especificado,
     *         o la cadena "no hay especies aun" si no se encuentran especies.
     */

    public String construir_lista_Species(String place) {

        Place placeSpecie = buscarPlace(place);
        String noSpecies = "";
        String lista = "";
        boolean validar = false;
        for (int j = 0; j < places.length; j++) {
            if (placeSpecie.getSpecies()[j] != null) {
                lista += "\n" + placeSpecie.getSpecies()[j].getName() + " - " + placeSpecie.getSpecies()[j].getAmount()
                        + " - " + placeSpecie.getSpecies()[j].getPhotoSpecie();

                validar = true;
            }

        }
        if (validar == false) {

            return noSpecies;
        }
        return lista;
    }//

    /**
     * Descripción: Genera una lista de las comunidades que tienen al menos dos
     * problemas registrados.
     * pre: El arreglo "places" no puede ser nulo y debe estar inicializado.
     * Cada lugar puede tener comunidades asociadas con problemas.
     *
     * @return String Una representación en cadena de las comunidades con al menos
     *         dos problemas,
     *         o un mensaje indicando que no se encontraron comunidades con al menos
     *         dos problemas.
     * 
     *         post: La variable "listaCommunities" contiene los nombres de las
     *         comunidades que cumplen con el
     *         criterio de tener al menos dos problemas registrados, o el mensaje
     *         "No se encontraron comunidades con al menos dos problemas." si no se
     *         cumplen las condiciones.
     */

    public String communityWTwoProblems() {
        String listaCommunities = "";
        boolean found = false;

        for (int i = 0; i < places.length; i++) {
            if (places[i] != null) {
                Place place = places[i];
                Community community = place.getCommunities();

                if (community != null) {
                    String[] problemCommunity = community.getProblemsCommunity();
                    int problemCount = 0;

                    if (problemCommunity[0].length() != 0) {
                        problemCount++;
                    }
                    if (problemCommunity[1].length() != 0) {
                        problemCount++;
                    }

                    if (problemCount >= 2) {
                        listaCommunities += community.getName() + "\n";
                        found = true;
                    }
                }
            }
        }

        if (!found) {
            return "No se encontraron comunidades con al menos dos problemas.";
        }

        return listaCommunities;
    }

}
