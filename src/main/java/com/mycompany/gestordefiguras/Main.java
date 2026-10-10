/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestordefiguras;

import controlador.ControladorRectangulo;
import vista.VistaRectangulo;

/**
 *
 * @author coffe
 */
public class Main {

    public static void main(String[] args) {
        VistaRectangulo vista = new VistaRectangulo();
        ControladorRectangulo controlador = new ControladorRectangulo(vista);
        vista.setControlador(controlador);
        vista.setVisible(true);
    }
}
