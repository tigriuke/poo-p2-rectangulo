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
            p1x = Double.parseDouble(vista.getP1xCreacion().replace(',', '.'));
            p1y = Double.parseDouble(vista.getP1yCreacion().replace(',', '.'));
            p2x = Double.parseDouble(vista.getP2xCreacion().replace(',', '.'));
            p2y = Double.parseDouble(vista.getP2yCreacion().replace(',', '.'));
        }
        catch(NumberFormatException e){
            vista.mostrarError("Los datos ingresados son invalidos y se arrojo la excepcion: \n" + e);
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
    
    public void moverRectangulo(){
        if(rectangulo == null){
            vista.mostrarError("No se ha creado ningún rectángulo.");
            return;
        }
        double dx;
        double dy;
        try{
            dx = Double.parseDouble(vista.getInputDX().replace(',', '.'));
            dy = Double.parseDouble(vista.getInputDY().replace(',', '.'));
        }
        catch(NumberFormatException e){
            vista.mostrarError("Los datos ingresados son invalidos y se arrojo la excepcion: \n" + e);
            return;
        }
        
        rectangulo.mover(dx, dy);
        vista.setResultadoMover(rectangulo.toString());
        
        
    }
    
    public void escalarRectangulo(){
        if(rectangulo == null){
            vista.mostrarError("No se ha creado ningún rectángulo.");
            return;
        }
        
        double factor;
        try{
            factor = Double.parseDouble(vista.getFactorEscalar().replace(',', '.'));
            if(factor <= 0){
                vista.mostrarError("El factor a escalar tiene que ser mayor a 0.");
                return;
            }
        }
        catch (NumberFormatException e ){
            vista.mostrarError("Los datos ingresados son invalidos y se arrojo la excepcion: \n" + e);
            return;
        }
        
        double x1 = rectangulo.getPunto1().getX();
        double y1 = rectangulo.getPunto1().getY();
        double x2 = rectangulo.getPunto2().getX();
        double y2 = rectangulo.getPunto2().getY();
        
        double nuevox = x1 + (x2 - x1) * factor;
        double nuevoy = y1 + (y2 - y1) * factor;
        Punto nuevoPunto = new Punto(nuevox, nuevoy);
        rectangulo.setPunto2(nuevoPunto);
        vista.setResultadoEscalar(rectangulo.toString());
    
    }
}