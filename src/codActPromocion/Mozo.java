package codActPromocion;

import javax.swing.JOptionPane;

public class Mozo extends Empleado {

    private static int cantMozo = 0; // Contador para Mozos

    /* ATRIBUTOS */
    private double sueldoBase = 3000;
    private int antiguedad;
    private int horasExt;
    private double sueldoFinal;

    /* CONSTRUCTORES */
    public Mozo() {
        super();
        cantMozo++;
    }

    public Mozo(String nombre, String apellido, int edad, String dni, int antiguedad, int horasExt) {
        super(nombre, apellido, edad, dni);
        this.antiguedad = antiguedad;
        this.horasExt = horasExt;
        cantMozo++;
    }

    /* GETTERS */
    public static int getCantMozo() {
        return cantMozo;
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
        this.antiguedad = libreria.Ingreso.ingresoEntero("Ingrese la antiguedad del mozo: ", "ANTIGUEDAD MOZO",
                JOptionPane.INFORMATION_MESSAGE);
        this.horasExt = libreria.Ingreso.ingresoEntero("Ingrese la cantidad de horas extras realizadas: ",
                "HORAS EXTRAS MOZO", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String toString() {

        return super.toString() + // enlaza String con los siguientes.
                "\nLa antiguedad del mozo es: " + this.antiguedad + "\n"
                + "La cantidad de horas extras es de: " + this.horasExt + "\n"
                + "El sueldo final a cobrar es: " + calcularSueldoFinal();

    }

    public void mostrarMozo() { 
        JOptionPane.showMessageDialog(null, this.toString(), "DATOS", JOptionPane.INFORMATION_MESSAGE); 
    }

}
