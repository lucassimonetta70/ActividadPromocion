package codActPromocion;

import javax.swing.JOptionPane;

public class MenuPlato {

    private String nombre;
    private double precio;
    private boolean disponible;

    public MenuPlato() {
    }

    public MenuPlato(String nombre, double precio, boolean disponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
    }

    /* GETTERS */
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
            "NOMBRE DE PLATO", JOptionPane.INFORMATION_MESSAGE
        );

        while (true) {
            String precioStr = libreria.Ingreso.ingresoString(
                "Ingrese el precio del plato (ej: 1500.50):",
                "PRECIO DEL PLATO", JOptionPane.INFORMATION_MESSAGE
            );

            if (precioStr == null) {        // Si cancela
                this.precio = 0.0;
                break;
            }

            precioStr = precioStr.replace(',', '.').trim();

            try {
                this.precio = Double.parseDouble(precioStr);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                    null,
                    "ERROR: Ingrese un número válido.\nEjemplo: 1500.50",
                    "PRECIO INVÁLIDO",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }

        int opc = libreria.Ingreso.ingresoEntero(
            "¿El plato está disponible?\n1 = SI   |   2 = NO",
            "DISPONIBILIDAD", JOptionPane.INFORMATION_MESSAGE
        );

        this.disponible = (opc == 1);
    }

    @Override
    public String toString() {
        return "Menú: " + nombre +
               " | Precio: $" + precio +
               " | Disponible: " + (disponible ? "Sí" : "No");
    }







    
}
