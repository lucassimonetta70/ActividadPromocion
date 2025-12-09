package libreria;

import javax.swing.JOptionPane;

public class Ingreso {

    private static String mError = "Error de ingreso";

    /* METODO PARA INGRESAR UN NUMERO ENTERO */
    public static int ingresoEntero(String eMensaje, String eTitulo, int eIcono) {

        int numero = 0;
        boolean valido = false;

        do {

            try {
                String ingreso = JOptionPane.showInputDialog(null, eMensaje, eTitulo, eIcono);
                numero = Integer.parseInt(ingreso);
                valido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error, debe ingresar un numero valido", mError,
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (!valido);

        return numero;
    }

    /* METODO PARA INGRESAR UN NUMERO DECIMAL */
    public static double ingresoDoble(String eMensaje, String eTitulo, int eIcono) {

        double numero = 0;
        boolean valido = false;

        do {

            try {
                String ingreso = JOptionPane.showInputDialog(null, eMensaje, eTitulo, eIcono);
                numero = Double.parseDouble(ingreso);
                valido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error, debe ingresar un numero valido", mError,
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (!valido);

        return numero;
    }

    /* METODO PARA INGRESAR UNA CADENA DE TEXTO */
    public static String ingresoString(String eMensaje, String eTitulo, int eIcono) {
        String texto = "";
        boolean valido = false;

        do {
            try {
                texto = JOptionPane.showInputDialog(null, eMensaje, eTitulo, eIcono);
                if (texto == null || texto.isEmpty()) {
                    throw new Exception("La cadena no puede estar vacía.");
                }
                valido = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), mError, JOptionPane.ERROR_MESSAGE);
            }
        } while (!valido);
        return texto;

    }
    
}
