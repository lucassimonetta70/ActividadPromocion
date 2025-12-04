package codActPromocion;

import javax.swing.JOptionPane;

import libreria.Ingreso;

public class Restaurante {

    // Tamaños máximos permitidos por la consigna
    private final int MAX_EMPLEADOS = 50;
    private final int MAX_PLATOS = 50;

    private Empleado[] empleados;
    private MenuPlato[] platos;

    private int cantEmpleados;
    private int cantPlatos;

    public Restaurante() {
        empleados = new Empleado[MAX_EMPLEADOS];
        platos = new MenuPlato[MAX_PLATOS];
        cantEmpleados = 0;
        cantPlatos = 0;
    }

    // =====================================================
    //                  AGREGAR EMPLEADO
    // =====================================================
    public void agregarEmpleado(Empleado emp) {

        if (cantEmpleados >= MAX_EMPLEADOS) {
            JOptionPane.showMessageDialog(
                    null,
                    "No hay más espacio para empleados.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        empleados[cantEmpleados] = emp;
        cantEmpleados++;

        JOptionPane.showMessageDialog(
                null,
                "Empleado registrado correctamente.",
                "ÉXITO",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // =====================================================
    //                  ELIMINAR EMPLEADO
    // =====================================================
    public void eliminarEmpleado(int indice) {
        for(int i = indice; i < cantEmpleados - 1; i++) { //Corremos los empleados hacia atras
            empleados[i] = empleados[i + 1]; // Reemplazamos el indice elegido por el siguiente
        }

        empleados[cantEmpleados - 1 ] = null; //limpiamos el ultimo indice pq quedo vacio
        cantEmpleados--; // eliminamos 1 la cantidad de empleados

        JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente!", "ELIMINADO", JOptionPane.INFORMATION_MESSAGE);    
    }

    // =====================================================
    //              AGREGAR MENU PLATO
    // =====================================================
    public void agregarMenuPlato(MenuPlato p) {

        if (cantPlatos >= MAX_PLATOS) {
            JOptionPane.showMessageDialog(
                    null,
                    "No hay más espacio para platos.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        platos[cantPlatos] = p;
        cantPlatos++;

        JOptionPane.showMessageDialog(
                null,
                "Plato registrado correctamente.",
                "ÉXITO",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // ======================================================
    //              ORDENAR EMPLEADOS POR DNI
    // ======================================================
    public void ordenarEmpleadosDNI() { //Metodo burbuja

        for(int i = 0; i < cantEmpleados - 1; i++) {

            for(int j = 0; j < cantEmpleados -1 - i; j++) {
                if (empleados[j].getDni().compareTo(empleados[j + 1].getDni()) > 0) { // Si el DNI del empleado J es mayor al siguiente

                    //Intercambios
                    Empleado aux = empleados[j];
                    empleados[j] = empleados[j + 1];
                    empleados[j+1] = aux;
                }
            }
        }
    }

    public int buscarEmpleadoDni(String dniBuscado) { //Busqueda binaria 
        int inicio = 0; 
        int fin = cantEmpleados -1;

        while (inicio <= fin) { 

            int medio = inicio + fin / 2;
            String dniMedio = empleados[medio].getDni(); //Obtencion del dni del objeto del medio

            if(dniMedio.equals(dniBuscado)) {
                return medio; //Devuelve la posicion del objeto si lo encontramos
            }

            if (dniBuscado.compareTo(dniMedio) > 0) {  
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }      
        }
        return -1;
    }

    // ======================================================
    //              BUSCAR EMPLEADO POR EL DNI
    // ======================================================
    public void mostrarEmpleadoDNI() {

        if (cantEmpleados == 0) {
            JOptionPane.showMessageDialog(null, "No hay empleados cargados.", "CUIDADO", JOptionPane.WARNING_MESSAGE);
        return;
        }

        ordenarEmpleadosDNI(); //Ordenamos los DNI para realizar la busqueda lineal

        String dni = JOptionPane.showInputDialog(null, "Ingrese el DNI del empleado a buscar: ");

        int indice = buscarEmpleadoDni(dni);

        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "No existe el empleado con el DNI " + dni + ".");
        } else {
            JOptionPane.showMessageDialog(null, "Empleado encontrado:\n " + empleados[indice].toString(), "EMPLEADO ENCONTRADO", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    // ======================================================
    //              ORDENAR EMPLEADOS POR TIPO
    // ======================================================
    public void ordenEmpleadosPorTipo() { // Ordenamiento por insercion

        for (int i = 1; i < cantEmpleados; i++) {

            Empleado actual = empleados[i];
            int j = i - 1;

            while (j >= 0 && empleados[j].getClass().getSimpleName().compareTo(actual.getClass().getSimpleName()) > 0) {
                empleados[j + 1] = empleados[j];
                j--;
            }

            empleados[j + 1] = actual;
        }
    }

    // ======================================================
    //                  TOP 5 SUELDOS
    // ======================================================
    public void mostrarTop5Sueldos() {

        for (int i = 0; i < cantEmpleados - 1; i++) { // Ordenamiento por burbuja
            for (int j = 0; j < cantEmpleados - i - 1; j++) {

                if (empleados[j].calcularSueldoFinal() < empleados[j + 1].calcularSueldoFinal()) {
                    Empleado aux = empleados[j];
                    empleados[j] = empleados[j + 1];
                    empleados[j + 1] = aux;
                }
            }
        }

        String lista = "TOP 5 EMPLEADOS QUE MAS COBRAN\n";

        int limite = Math.min(5, cantEmpleados);

        for (int i = 0; i < limite; i++) {
            lista += empleados[i].toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, lista, "TOP 5 SUELDOS", JOptionPane.INFORMATION_MESSAGE);
    }

    // =====================================================
    //                  LISTAR EMPLEADOS
    // =====================================================
    public void listarEmpleados() {

        if (cantEmpleados == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "No hay empleados cargados.",
                    "AVISO",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String lista = "EMPLEADOS REGISTRADOS\n\n";

        for (int i = 0; i < cantEmpleados; i++) {
            lista += empleados[i].toString() + "\n";
        }

        JOptionPane.showMessageDialog(
                null,
                lista,
                "LISTA DE EMPLEADOS",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // =====================================================
    //              LISTAR MENU PLATOS POR PRECIO
    // =====================================================
    public void ordenarPlatosPorPrecio() {
        if (cantPlatos == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "No hay platos cargados.",
                    "AVISO",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        for (int i = 0; i < cantPlatos - 1; i++) { // Ordenamiento por burbuja

            for (int j = 0; j < cantPlatos - i - 1; j++) {
                if (platos[j].getPrecio() > platos[j + 1].getPrecio()) { //
                    MenuPlato aux = platos[j];
                    platos[j] = platos[j + 1];
                    platos[j + 1] = aux;
                }
            }
        }

        String lista = "MENÚ ORDENADO POR PRECIO (MENOR A MAYOR)\n";

        for (int i = 0; i < cantPlatos; i++) {
            lista += platos[i].toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, lista, "MENU ORDENADO", JOptionPane.INFORMATION_MESSAGE);

    }

    // =====================================================
    //                  LISTAR MENU PLATOS
    // =====================================================
    public void listarMenuPlatos() {

        if (cantPlatos == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "No hay platos cargados.",
                    "AVISO",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String lista = "MENÚ DEL RESTAURANTE\n\n";

        for (int i = 0; i < cantPlatos; i++) {
            lista += platos[i].toString() + "\n";
        }

        JOptionPane.showMessageDialog(
                null,
                lista,
                "LISTA DE PLATOS",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // =====================================================
    //                  SUELDOS TOTALES
    // =====================================================
    public double calcularSueldosTotales() {

        double total = 0;

        for (int i = 0; i < cantEmpleados; i++) {
            total += empleados[i].calcularSueldoFinal();
        }

        return total;
    }

    // =====================================================
    //          INFORMACIÓN DEL RESTAURANTE
    // =====================================================
    public void mostrarInformacion() {

        String info = "INFORMACIÓN DEL RESTAURANTE\n\n" +
                "Cantidad de empleados: " + cantEmpleados + "\n" +
                "Cantidad de platos del menú: " + cantPlatos + "\n" +
                "Total en sueldos a pagar: $" + calcularSueldosTotales() + "\n";

        JOptionPane.showMessageDialog(
                null,
                info,
                "INFORME GENERAL",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // =====================================================
    //          METODO PARA ELIMINAR EMPLEADO
    // =====================================================
    public void eliminarEmpleadoPorIndice() {
        
        if(cantEmpleados == 0) {
            JOptionPane.showMessageDialog(null, "No hay empleados para eliminar.","CUIDADO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String lista= "=== LISTA DE EMPLEADOS ===\n";
        
        for (int i = 0; i < cantEmpleados; i++) {
            lista += "[" + i + "]"  + empleados[i].getNombre() + 
            " - " +"Tipo: " + empleados[i].getClass().getSimpleName() +  
            " - Sueldo: $" + empleados[i].calcularSueldoFinal() 
             + "\n";
        }

        int indice;

        do {
            String mensaje = lista + "\nIngres el indice del lempleado a eliminar:";

            indice = libreria.Ingreso.ingresoEntero( mensaje, "ELIMINAR EMPLEADO", JOptionPane.INFORMATION_MESSAGE);

            if(indice < 0 || indice >= cantEmpleados) {
                JOptionPane.showMessageDialog(null, "Indice invalido, no existe ese emplado.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
            
        } while (indice < 0 || indice >= cantEmpleados );

            eliminarEmpleado(indice);
        
    }



    // ============================================
    //              MENU ITERACTIVO
    // ============================================
    public void menuOpciones() {

        int opc;

        String menu = "MENÚ DE RESTAURANTE\n"
                    + "1 - Cargar empleado\n"
                    + "2 - Cargar plato\n"
                    + "3 - Mostrar empleados\n"
                    + "4 - Mostrar menu de platos\n"
                    + "5 - Ordenar empleados por tipo\n"
                    + "6 - Ordenar menu por precio\n"
                    + "7 - Mostrar 5 empleados que más cobran\n"
                    + "8 - Eliminar empleado\n"
                    + "9 - Buscar empleado\n"
                    + "10 - Mostrar información del restaurante\n"
                    + "11 - Modificar datos de los empleados\n"
                    + "12 - Salir";

        do {

    opc = Ingreso.ingresoEntero(menu, "MENU ITERACTIVO", JOptionPane.INFORMATION_MESSAGE);

    switch (opc) {

        /* CARGAR EMPLEADO */
        case 1:
            int tipo;
            Boolean correcto = true;
            String distEmpleados = "Seleccione el tipo de empleado:\n" +
                    "1 - MOZO\n" +
                    "2 - ENCARGADO\n" +
                    "3 - VACHERO\n";

            do {
                tipo = Ingreso.ingresoEntero(distEmpleados, "Tipo Empleado", JOptionPane.INFORMATION_MESSAGE);

                if (tipo < 1 && tipo > 3) {
                    JOptionPane.showMessageDialog(null, "ELIJA UN NUMERO CORRECTO", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                    correcto = false;
                }
            } while (!correcto);

            Empleado emp = null;

            switch (tipo) {
                case 1:
                    emp = new Mozo();
                    break;

                case 2:
                    emp = new Encargado();
                    break;

                case 3:
                    emp = new Vachero();
                    break;
            }

            if (emp != null) {
                emp.cargarEmpleado();
                agregarEmpleado(emp);
            }

            break;
        
        /* CARGAR PLATO */
        case 2:
            MenuPlato plato = new MenuPlato();
            plato.cargarMenuPlato();
            agregarMenuPlato(plato);
            break;

        /* MOSTRAR EMPLEADOS */
        case 3:
            listarEmpleados();
            break;

        /* MOSTRAR MENU DE PLATOS */
        case 4:
            listarMenuPlatos();
            break;

        /* ORDERNAR EMPLEADOS POR TIPO */
        case 5:
            ordenEmpleadosPorTipo();
            listarEmpleados();
            break;

        /* ORDENAR MENU POR PRECIO */
        case 6:
            ordenarPlatosPorPrecio();
            listarMenuPlatos();
            break;

        /* MOSTRAR 5 EMPLEADOS QUE MAS COBRAN */
        case 7:
            mostrarTop5Sueldos();
            break;

        /* ELIMINAR EMPLEADO */
        case 8:
            eliminarEmpleadoPorIndice(); 
            break;

        /* BUSCAR EMPLEADO POR DNI*/
        case 9:
            mostrarEmpleadoDNI();
            break;

        /* MOSTRAR INFORMACION DEL RESTAURANTE */
        case 10:
            mostrarInformacion();
            break;

        /* SALIR */
        case 11:
            JOptionPane.showMessageDialog(null, "Saliendo del menu....", "SALIENDO",
                    JOptionPane.WARNING_MESSAGE);
            break;

        default:
            JOptionPane.showMessageDialog(null, "OPCION ELEJIDA INVALIDA", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

} while (opc != 12);


    }

}
