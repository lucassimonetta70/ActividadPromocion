package codActPromocion;

import javax.swing.JOptionPane;

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
    //                AGREGAR EMPLEADO
    // =====================================================
    public void agregarEmpleado(Empleado emp) {

        if (cantEmpleados >= MAX_EMPLEADOS) {
            JOptionPane.showMessageDialog(
                    null,
                    "No hay más espacio para empleados.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        empleados[cantEmpleados] = emp;
        cantEmpleados++;

        JOptionPane.showMessageDialog(
                null,
                "Empleado registrado correctamente.",
                "ÉXITO",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =====================================================
    //                  AGREGAR MENU PLATO
    // =====================================================
    public void agregarMenuPlato(MenuPlato p) {

        if (cantPlatos >= MAX_PLATOS) {
            JOptionPane.showMessageDialog(
                    null,
                    "No hay más espacio para platos.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        platos[cantPlatos] = p;
        cantPlatos++;

        JOptionPane.showMessageDialog(
                null,
                "Plato registrado correctamente.",
                "ÉXITO",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =====================================================
    //                 LISTAR EMPLEADOS
    // =====================================================
    public void listarEmpleados() {

        if (cantEmpleados == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "No hay empleados cargados.",
                    "AVISO",
                    JOptionPane.INFORMATION_MESSAGE
            );
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
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =====================================================
    //                   LISTAR MENU PLATOS
    // =====================================================
    public void listarMenuPlatos() {

        if (cantPlatos == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "No hay platos cargados.",
                    "AVISO",
                    JOptionPane.INFORMATION_MESSAGE
            );
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
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =====================================================
    //                 SUELDOS TOTALES
    // =====================================================
    public double calcularSueldosTotales() {

        double total = 0;

        for (int i = 0; i < cantEmpleados; i++) {
            total += empleados[i].calcularSueldoFinal();
        }

        return total;
    }

    // =====================================================
    //             INFORMACIÓN DEL RESTAURANTE
    // =====================================================
    public void mostrarInformacion() {

        String info =
                "INFORMACIÓN DEL RESTAURANTE\n\n" +
                "Cantidad de empleados: " + cantEmpleados + "\n" +
                "Cantidad de platos del menú: " + cantPlatos + "\n" +
                "Total en sueldos a pagar: $" + calcularSueldosTotales() + "\n";

        JOptionPane.showMessageDialog(
                null,
                info,
                "INFORME GENERAL",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
