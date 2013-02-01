/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objectoriented;

/**
 *
 * @author PenGuin
 */

// 拥有抽象方法的类 叫抽象类 ：抽象方法即c++里面的纯需函数
/*
abstract class Shape{
    String shapetype;
    public Shape(){
        System.out.println("Shape is initialized!");
    }
    public abstract void draw(){
        System.out.println("Shape draw() is called!");
    }
}
 */

class Shape{
    String shapetype;
    public Shape(){
        System.out.println("Shape is initialized!");
    }
    public void draw(){
        System.out.println("Shape draw() is called!");
    }
}

class Circle extends Shape{
    public Circle(){
        System.out.println("Circle is initialized!");
    }
    public void draw(){
        System.out.println("Circle draw() is called!");
    }
    public void print(){
        System.out.println("Circle print() is called");
    }
}

class Square extends Shape{
    public Square(){
        System.out.println("Square is initialized!");
    }
    public void draw(){
        System.out.println("Square draw() is called!");
    }
}

class Triangle extends Shape{
    public Triangle(){
        System.out.println("Triangle is initialized!");
    }
    public void draw(){
        System.out.println("Triangle draw() is called!");
    }
}

public class Polymorphic_Shap {
       private void foo(Shape shape){
        shape.draw();
    }
       public static void main(String[] args) {
        Polymorphic_Shap PolyTest = new Polymorphic_Shap();

        Circle circle = new Circle();
        Square squre = new Square();
        Triangle triangle = new Triangle();

     //   Shape s = new Circle(); 这里 s没有 print()方法


        PolyTest.foo(circle);
        PolyTest.foo(squre);
        PolyTest.foo(triangle);
    }
}
