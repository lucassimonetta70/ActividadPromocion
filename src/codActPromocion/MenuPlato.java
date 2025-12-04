package codActPromocion;

import javax.swing.JOptionPane;

public class MenuPlato {

    private static int cantPlatos = 0; //Contador

    private String nombre;
    private double precio;
    private boolean disponible;

    public MenuPlato(){
        cantPlatos++;
    }

    public MenuPlato(String nombre, double precio, boolean disponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        cantPlatos++;
    }

    /* GETTERS */
    public static int getCantPlatos() {
        return cantPlatos;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    /* SETTERS */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // cargarMenuPlato
    public void cargarMenuPlato() {

        this.nombre = libreria.Ingreso.ingresoString(
                "Ingrese el nombre del plato:",
                "NOMBRE PLATO",
                JOptionPane.INFORMATION_MESSAGE
        );

        this.precio = libreria.Ingreso.ingresoDoble(
                "Ingrese el precio del plato:",
                "PRECIO PLATO",
                JOptionPane.INFORMATION_MESSAGE
        );


        int opc;

        do {
            opc = libreria.Ingreso.ingresoEntero(
                    "¿El plato está disponible?\n1 = SI   |   2 = NO",
                    "DISPONIBILIDAD", JOptionPane.INFORMATION_MESSAGE);

        } while (opc != 1 && opc != 2);

        this.disponible = (opc == 1);
    }

    @Override
    public String toString() {
        return "---- PLATO ----\n" +
                " | Menú: " + nombre + 
                " | Precio: $" + precio + 
                " | Disponible: " + (disponible ? "Sí" : "No");
    }

    public void mostrarPlato() {
        JOptionPane.showMessageDialog(null, this.toString(), "MENU PLATOS", JOptionPane.INFORMATION_MESSAGE);
    }

}
