/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author liborio
 */
public class Helper {

    public static int mensaje(Component ventana, String info, String titulo, int tipo) {
        int retorno = -1;
        switch (tipo) {
            case 1:
                JOptionPane.showMessageDialog(ventana, info, titulo, JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(ventana, info, titulo, JOptionPane.ERROR_MESSAGE);
                break;
            case 3:
                retorno = JOptionPane.showConfirmDialog(ventana, info, titulo, JOptionPane.YES_NO_OPTION);
                break;
        }
        return retorno;
    }

    public static String RecibirDatos(Component ventana, String info) {
        String aux;
        aux = JOptionPane.showInputDialog(ventana, info);
        return aux;
    }

    public static void HabilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(true);
        }
    }

    public static void DeshabilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(false);
        }
    }

    public static void LimpiarTabla(JTable tabla) {
        int nf, nc;
        nf = tabla.getRowCount();
        nc = tabla.getColumnCount();

        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {

                tabla.setValueAt("", i, j);
            }
        }
    }

    public static void TablaPorDefecto(JTable tabla) {
        DefaultTableModel tm;
        tm = (DefaultTableModel) tabla.getModel();
        tm.setColumnCount(0);
        tm.setRowCount(0);
    }

    public static void diagonalPrincipal(JTable tabla1, JTable tabla2) {
        int nf, nc, aux;
        nc = tabla1.getColumnCount();
        nf = tabla1.getRowCount();

        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {
                aux = (int) tabla1.getValueAt(i, j);
                if (i == j) {
                    tabla2.setValueAt(aux, i, j);
                }
            }
        }
    }

    public static int[][] pasarDatosMatriz(JTable tabla1) {
        int nf, nc;
        nc = tabla1.getColumnCount();
        nf = tabla1.getRowCount();

        int m[][] = new int[nf][nc];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {

                m[i][j] = (int) tabla1.getValueAt(i, j);
            }
        }
        return m;
    }

    public static String recorridoHaciaArriba(int[][] m, int j) {
        int nf = m.length;
        String Aux = "";
        for (int i = nf - 1; i >= 0; i--) {
            Aux = Aux + m[i][j] + ", ";
        }
        return Aux;
    }

    public static String recorridoHaciaArriba(int[][] m, int j, int in, int fin) {
        int nf = m.length;
        String Aux = "";
        for (int i = in; i >= fin; i--) {
            Aux = Aux + m[i][j] + " ,";
        }
        return Aux;
    }

    public static String recorridoHaciaAbajo(int[][] m, int j) {
        int nf = m.length;
        String Aux = "";
        for (int i = 0; i < nf; i++) {
            Aux = Aux + m[i][j] + " ,";
        }
        return Aux;
    }

    public static String recorridoHaciaAbajo(int[][] m, int j, int in, int fin) {

        String Aux = "";
        for (int i = in; i < fin; i++) {
            Aux = Aux + m[i][j] + ", ";
        }
        return Aux;
    }

    public static String recorridoHaciaDerecha(int[][] m, int i) {
        int nc = m[0].length;
        String Aux = "";
        for (int j = 0; j <= nc; j++) {
            Aux = Aux + m[i][j] + " ,";
        }
        return Aux;
    }

    public static String recorridoHaciaDerecha(int[][] m, int i, int in, int fin) {
        int nc = m[0].length;
        String Aux = "";
        for (int j = in; j <= fin; j++) {
            Aux = Aux + m[i][j] + " ,";
        }
        return Aux;
    }

    public static String recorridoHaciaIzquierda(int[][] m, int i) {
        int nc = m[0].length;
        String Aux = "";
        for (int j = nc - 1; j >= 0; j--) {
            Aux = Aux + m[i][j] + " ,";
        }
        return Aux;
    }

    public static String recorridoHaciaIzquierda(int[][] m, int i, int in, int fin) {
        int nc = m[0].length;
        String Aux = "";
        for (int j = in; j >= fin; j--) {
            Aux = Aux + m[i][j] + " ,";
        }
        return Aux;
    }

    public static String recorridoDiagonalPrincipalHaciaAbajo(int[][] m) {
        int nf = m.length;
        String Aux = "";
        for (int i = 0; i < nf; i++) {
            Aux = Aux + m[i][i] + " ,";
        }
        return Aux;
    }

    public static String recorridoDiagonalPrincipalHaciaArriba(int[][] m) {
        int nf = m.length;
        String Aux = "";
        for (int i = nf - 1; i > 0; i--) {
            Aux = Aux + m[i][i] + " ,";
        }
        return Aux;
    }

    public static String recorridoDiagonalSecundariaHaciaAbajo(int[][] m) {
        int nc = m[0].length;
        int nf = m.length;
        String Aux = "";
        for (int i = 0; i < nf; i++) {
            Aux = Aux + m[i][nc - 1 - i] + ", ";
        }
        return Aux;
    }

    public static String recorridoDiagonalSecundariaHaciaArriba(int[][] m) {
        int nc = m[0].length;
        int nf = m.length;
        String Aux = "";
        for (int i = nf - 1; i >= 0; i--) {
            Aux = Aux + m[i][nc - 1 - i] + ", ";
        }
        return Aux;
    }

    public static String recorridoDiagonalSecundariaHaciaArriba(int[][] m, int in, int fin) {
        int nc = m[0].length;
        int nf = m.length;
        String Aux = "";
        for (int i = in; i >= fin; i--) {
            Aux = Aux + m[i][nc - 1 - i] + ", ";
        }
        return Aux;
    }

    public static String recorridoDiagonalSecundariaHaciaAbajo(int[][] m, int in, int fin) {
        int nc = m[0].length;
        int nf = m.length;
        String Aux = "";
        for (int i = in; i < fin; i++) {
            Aux = Aux + m[i][nc - 1 - i] + ", ";
        }
        return Aux;
    }

    public static String recorridoDiagonalPrincipalHaciaArriba(int[][] m, int in, int fin) {
        int nf = m.length;
        String Aux = "";
        for (int i = in; i >= fin; i--) {
            Aux = Aux + m[i][i] + " ,";
        }
        return Aux;
    }

    public static String recorridoDiagonalPrincipalHaciaAbajo(int[][] m, int in, int fin) {
        int nf = m.length;
        String Aux = "";
        for (int i = in; i < fin; i++) {
            Aux = Aux + m[i][i] + " ,";
        }
        return Aux;
    }

    public static String Mostrar(int[][] m) {
        String Aux = "";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                Aux = Aux + m[i][j] + "";
            }
            Aux = Aux + "\n";
        }
        return Aux;
    }

    public static String Figura1(JTable tabla1) {

        int nf, nc, m[][] = pasarDatosMatriz(tabla1);
        String aux = "";
        nf = m.length;
        nc = m[0].length;

        aux = aux + Helper.recorridoHaciaDerecha(m, 0, 0, nf - 2);
        aux = aux + Helper.recorridoHaciaAbajo(m, nc - 1, 0, nf / 2 + 1);
        aux = aux + Helper.recorridoHaciaIzquierda(m, nf / 2, nc - 2, 1);
        aux = aux + Helper.recorridoHaciaAbajo(m, 0, nc / 2, nf - 1 + 1);
        aux = aux + Helper.recorridoHaciaDerecha(m, nf - 1, 1, nc - 1);

        aux = aux.substring(0, aux.length() - 2) + ".";
        return aux;
    }

    public static String Figura2(JTable tabla1) {

        int nf, nc, m[][] = pasarDatosMatriz(tabla1);
        String aux = "";
        nf = m.length;
        nc = m[0].length;

        aux = aux + Helper.recorridoHaciaArriba(m, 0, nf - 1, 0);
        aux = aux + Helper.recorridoHaciaDerecha(m, 0, 1, nf / 2);
        aux = aux + Helper.recorridoHaciaAbajo(m, nc / 2, 1, nf - 1);
        aux = aux + Helper.recorridoHaciaDerecha(m, nf - 1, nc / 2, nc - 1);
        aux = aux + Helper.recorridoHaciaArriba(m, nc - 1, nf - 2, 0);

        aux = aux.substring(0, aux.length() - 2) + ".";
        return aux;
    }

    public static String Figura3(JTable tabla1) {

        int m[][] = pasarDatosMatriz(tabla1);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";

        aux = aux + Helper.recorridoHaciaArriba(m, 0, nf - 1, 0);

        aux = aux.substring(0, aux.length() - 2) + ".";
        return aux;
    }

    public static String Figura4(JTable tabla1) {

        int nf, nc, m[][] = pasarDatosMatriz(tabla1);
        String aux = "";
        nf = m.length;
        nc = m[0].length;

        aux = aux + Helper.recorridoHaciaArriba(m, 0, nf - 1, 0);
        aux = aux + Helper.recorridoHaciaDerecha(m, 0, 1, nf / 2);
        aux = aux + Helper.recorridoHaciaAbajo(m, nc / 2, 1, nf - 1);
        aux = aux + Helper.recorridoHaciaDerecha(m, nf - 1, nc / 2, nc - 1);
        aux = aux + Helper.recorridoHaciaArriba(m, nc - 1, nf - 2, 0);

        aux = aux.substring(0, aux.length() - 2) + ".";
        return aux;

    }

    public static String Figura5(JTable tabla1) {

        int nf, nc, m[][] = pasarDatosMatriz(tabla1);
        String aux = "";
        nf = m.length;
        nc = m[0].length;

        aux = aux + Helper.recorridoHaciaArriba(m, 0);
        aux = aux + Helper.recorridoDiagonalPrincipalHaciaAbajo(m, 1, nf / 2 + 1);
        aux = aux + Helper.recorridoDiagonalSecundariaHaciaArriba(m, ((nf - 1) / 2) - 1, 0);
        aux = aux + Helper.recorridoHaciaAbajo(m, nc - 1, 1, nf);

        aux = aux.substring(0, aux.length() - 2) + ".";
        return aux;
    }
}
