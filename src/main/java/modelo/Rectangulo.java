/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 *
 * @author coffe
 */
public class Rectangulo extends FiguraGeometrica {
    private Punto punto1;
    private Punto punto2;

    public Rectangulo(Punto punto, Punto puntoOpuesto) {
        this.punto1 = punto;
        this.punto2 = puntoOpuesto;
    }
    
    @Override
    public double calcularArea() {
        double base = Math.abs(punto1.getX() - punto2.getX());
        double altura = Math.abs(punto1.getY() - punto2.getY());
        return base * altura;
    }

    @Override
    public void mover(double dx, double dy) {
        punto1.setX(punto1.getX() + dx);
        punto1.setY(punto1.getY() + dy);
        punto2.setX(punto2.getX() + dx);
        punto2.setY(punto2.getY() + dy);
    }

    @Override
    public String toString(){
        return "Vertice 1: " + "(" + punto1.getX() + ", " + punto1.getY() + ")" + 
                "\nVertice 2: " + "(" + punto1.getX() + ", " + punto2.getY() + ")" +
                "\nVertice 3: " + "(" + punto2.getX() + ", " + punto1.getY() + ")" + 
                "\nVertice 4: " + "(" + punto2.getX() + ", " + punto2.getY() + ")" + 
                "\nArea: " + calcularArea() + " [u^2]";
    }
    public Punto getPunto1() {
        return punto1;
    }

    public void setPunto1(Punto punto1) {
        this.punto1 = punto1;
    }

    public Punto getPunto2() {
        return punto2;
    }

    public void setPunto2(Punto punto2) {
        this.punto2 = punto2;
    }
    
     
}
