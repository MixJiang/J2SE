/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objectoriented;

/**
 *
 * @author PenGuin
 */
interface Shape_interface {

    String shapetype = "Hello";
    int number = 1000;

    public void setColor();

    public void draw();
}

class Circle_interface implements Shape_interface {

    public void outPutData() {
        System.out.println("Circle shapetype : " + shapetype + " number " + number);
    }

    public void draw() {
        System.out.println("Circle draw() is called!");
    }

    public void setColor() {
        System.out.println("Circle setColor() is called!");
    }

    public void print() {
        System.out.println("Circle print() is called");
    }
}

class Square_interface implements Shape_interface {

    public void draw() {
        System.out.println("Square  draw() is called!");
    }

    public void setColor() {
        System.out.println("Square  setColor() is called!");
    }
}

class Triangle_interface implements Shape_interface {

    public void draw() {
        System.out.println("Triangle draw() is called!");
    }

    public void setColor() {
        System.out.println("Triangle setColor() is called!");
    }
}

public class Interface_Test {

    int a;
    public int b;
    private int c;

    private void foo1(Shape_interface shape) {
        shape.draw();
    }

    private void foo2(Shape_interface shape) {
        shape.setColor();
    }

    public static void main(String[] args) {
        Interface_Test interfacetest = new Interface_Test();

        Circle_interface circle = new Circle_interface();
        Square_interface squre = new Square_interface();
        Triangle_interface triangle = new Triangle_interface();

        //Shape_interface s = new Circle_interface(); //这里 s 没有 print()方法

        interfacetest.foo1(circle);
        interfacetest.foo1(squre);
        interfacetest.foo1(triangle);
    }
}
