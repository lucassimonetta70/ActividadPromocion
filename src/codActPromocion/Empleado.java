package codActPromocion;

import javax.swing.JOptionPane;

public class Empleado {

    private static int totalEmpleados = 0; // Contador.

    /* ATRIBUTOS */
    private String nombre;
    private String apellido;
    private int edad;
    private String dni;
    private String legajo; 

    /* CONSTRUCTORES */
    public Empleado() {
        totalEmpleados++;
        this.legajo = String.format("%03d", totalEmpleados);
    }

    public Empleado(String nombre, String apellido, int edad, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;

        totalEmpleados++;
        this.legajo = String.format("%03d", totalEmpleados); // El legajo se genera automaticamente a partir de la cantidad de empleados.
    }

    /* GETTERS */
    public static int getTotalEmpleados() {
        return totalEmpleados;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public String getLegajo() {
        return legajo;
    }

    /* SETTERS */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    /*-----------*/
    /*  METODOS  */
    /*-----------*/
    
    public void cargarEmpleado() {

        this.nombre = libreria.Ingreso.ingresoString("Ingrese SOLO el nombre del empleado: ", "NOMBRE EMPLEADO", JOptionPane.INFORMATION_MESSAGE);
        this.apellido = libreria.Ingreso.ingresoString("Ingrese el apellido del empleado: ", "APELLIDO EMPLEADO", JOptionPane.INFORMATION_MESSAGE);
        this.edad = libreria.Ingreso.ingresoEntero("Ingrse la edad del empleado: ", "INGRESO EDAD", JOptionPane.INFORMATION_MESSAGE);
        this.dni = libreria.Ingreso.ingresoString("Ingrse el dni del empleado: ", "INGRESO DNI", JOptionPane.INFORMATION_MESSAGE);
    }

    public String escribirEmpleado() { // Metodo para designar unicamente los valores.

        return  "=== EMPLEADO ===\n"
                + "Nombre: " + this.nombre + "\n"
                + "Apellido: " + this.apellido + "\n"
                + "Edad: " + this.edad + "\n"
                + "DNI: " + this.dni + "\n"
                + "Legajo del empleado: " + this.legajo; 
        
    }

    public void mostrarEmpleado() {
        String info = escribirEmpleado();
        JOptionPane.showMessageDialog(null, info, "DATOS", JOptionPane.INFORMATION_MESSAGE);
}

    
public double calcularSueldoFinal() {
    return 0;   // Por defecto, el sueldo base no existe en Empleado general
}

















    }




    


    


    

    


