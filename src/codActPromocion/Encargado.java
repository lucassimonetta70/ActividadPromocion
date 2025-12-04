package codActPromocion;

import javax.swing.JOptionPane;

public class Encargado extends Empleado {

    private static int cantEncargado = 0; //Contador 

    /* ATRIBUTOS */
    private double sueldoBase = 3800;
    private int antiguedad;
    private int horasExt;
    private double sueldoFinal;

    /* CONSTRUCTORES */
    public Encargado() {
        super();
        cantEncargado++;
    }

    public Encargado(String nombre, String apellido, int edad, String dni, int antiguedad, int horasExt, String tipo) {
        super(nombre, apellido, edad, dni);
        this.antiguedad = antiguedad;
        this.horasExt = horasExt;
        cantEncargado++;
    }

    /* GETTERS */
    public static int getCantEncargado() {
        return cantEncargado;
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
        this.antiguedad = libreria.Ingreso.ingresoEntero("Ingrese la antiguedad del encargado: ", "ANTIGUEDAD ENCARGADO",
                JOptionPane.INFORMATION_MESSAGE);
        this.horasExt = libreria.Ingreso.ingresoEntero("Ingrese la cantidad de horas extras realizadas: ",
                "HORAS EXTRAS ENCARGADO", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String toString() {

        return super.toString() + // enlaza String con los siguientes.
                " | La antiguedad del encargado es: " + this.antiguedad + 
                " | La cantidad de horas extras es de: " + this.horasExt + "\n"
                + "El sueldo final a cobrar es: " + calcularSueldoFinal();
    }

    public void mostrarEncargado() { 
        JOptionPane.showMessageDialog(null, this.toString(), "DATOS", JOptionPane.INFORMATION_MESSAGE); 
    }

    

    

    

    
}
