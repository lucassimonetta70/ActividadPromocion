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

    // ============================================
    //              MENU ITERACTIVO
    // ============================================
    public void menuOpciones() {

        int opc;

        String menu = "MENÚ DE RESTAURANTE\n"
                + "1 - Cargar empleado\n"
                + "2 - Mostrar empleados\n"
                + "3 - Ordenar empleados por tipo\n"
                + "4 - Cargar plato\n"
                + "5 - Mostrar menu de platos\n"
                + "6 - Ordenar menu por precio\n"
                + "7 - Mostrar 5 empleados que mas cobran\n"
                + "8 - Mostrar informacion del restaurante\n"
                + "9 - Salir";

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

                    if (emp != null) { //Linea que guarda al empleado en el restaurante
                        emp.cargarEmpleado();
                        agregarEmpleado(emp);
                    }

                    break;

                /* MOSTRAR EMPLEADOS */
                case 2:
                    listarEmpleados();
                    break;

                /* ORDENAR EMPLEADOS POR ROL */
                case 3:
                    ordenEmpleadosPorTipo();
                    listarEmpleados();
                    break;

                /* CARGAR PLATO */
                case 4:
                    MenuPlato plato = new MenuPlato();
                    plato.cargarMenuPlato();
                    agregarMenuPlato(plato);
                    break;

                /* MOSTRAR PLATOS */
                case 5:
                    listarMenuPlatos();
                    break;

                /* MOSTRAR PLATOS EN ORDEN POR PRECIO */
                case 6:
                    ordenarPlatosPorPrecio();
                    listarMenuPlatos();
                    break;

                /* MOSTRAR 5 SUEDLOS MAS ALTOS */
                case 7:
                    mostrarTop5Sueldos();
                    break;

                /* MOSTRAR INFO DEL RESTAURANTE */
                case 8:
                    mostrarInformacion();
                    break;

                /* SALIR DEL MENU */
                case 9:
                    JOptionPane.showMessageDialog(null, "Saliendo del menu....", "SALIENDO",
                            JOptionPane.WARNING_MESSAGE);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "OPCION ELEJIDA INVALIDA", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } while (opc != 9);

    }

}
