/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.*;
import vista.VistaRectangulo;

/**
 *
 * @author coffe
 */
public class ControladorRectangulo {
    private VistaRectangulo vista;
    private Rectangulo rectangulo;

    public ControladorRectangulo(VistaRectangulo vista, Rectangulo rectangulo) {
        this.vista = vista;
        this.rectangulo = rectangulo;
    }
    
    public void crearRectangulo(){
        double p1x;
        double p1y;
        double p2x;
        double p2y;
        try{
            p1x = Double.parseDouble(vista.getP1xCreacion());
            p1y = Double.parseDouble(vista.getP1yCreacion());
            p2x = Double.parseDouble(vista.getP2xCreacion());
            p2y = Double.parseDouble(vista.getP2yCreacion());
        }
        catch(NumberFormatException e){
            vista.mostrarError("Los datos ingresados son invalidos y se arrojo la excepcion \n" + e);
            return;
        }
        
        if(p1x == p2x || p1y == p2y){
            vista.mostrarError("Los datos ingresados son invalidos, los dos puntos no constituyen un rectángulo y tienen area = 0.");
            return;
        }
        
        Punto p1 = new Punto(p1x, p1y);
        Punto p2 = new Punto(p2x, p2y);

        rectangulo = new Rectangulo(p1, p2);
        vista.setTextoCreacion("Rectangulo creado correctamente.");
        vista.setResultadoCreacion(rectangulo.toString());
    }
    
    public void escalarRectangulo(){
        
    
    
    
    }
}
