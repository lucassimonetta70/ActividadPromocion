package codActPromocion;

import javax.swing.JOptionPane;

public class Vachero extends Empleado {

    private static int cantVacheros = 0; // CONTADOR VACHEROS

    /* ATRIBUTOS */
    private double sueldoBase = 2500;
    private int antiguedad;
    private int horasExt;
    private double sueldoFinal;

    /* CONSTRUCTORES */

    public Vachero() {
        super();
        cantVacheros++;
    }

    public Vachero(String nombre, String apellido, int edad, String dni,double sueldoBase, int antiguedad,
         int horasExt) {
        super(nombre, apellido, edad, dni);
        this.antiguedad = antiguedad;
        this.horasExt = horasExt;

        cantVacheros++;
    }

    /* GETTERS */
    public static int getCantVacheros() {
        return cantVacheros;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public int getHorasExt() {
        return horasExt;
    }

    public double getSueldoFinal() {
        return sueldoFinal;
    }

    /* SETTERS */
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setHorasExt(int horasExt) {
        this.horasExt = horasExt;
    }

    /*-----------*/
    /* METODOS */
    /*-----------*/

    public double calcularSueldoFinal() {

        this.sueldoFinal = sueldoBase + (antiguedad * 40) + (horasExt * 20);

        return this.sueldoFinal;
    }

    @Override
    public void cargarEmpleado() {

        super.cargarEmpleado();
        this.antiguedad = libreria.Ingreso.ingresoEntero("Ingrese la antiguedad del vachero: ", "ANTIGUEDAD VACHERO",
                JOptionPane.INFORMATION_MESSAGE);
        this.horasExt = libreria.Ingreso.ingresoEntero("Ingrese la cantidad de horas extras realizadas: ",
                "HORAS EXTRAS VACHERO", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarEmpleado() {

        String info = super.escribirEmpleado() + // enlaza String con los siguientes.
                "\nLa antiguedad del vachero es: " + this.antiguedad + "\n"
                + "La cantidad de horas extras es de: " + this.horasExt + "\n"
                + "El sueldo final a cobrar es: " + calcularSueldoFinal();

        JOptionPane.showMessageDialog(null, info, "DATOS", JOptionPane.INFORMATION_MESSAGE);
    }

}
