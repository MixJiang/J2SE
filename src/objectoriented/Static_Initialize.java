/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objectoriented;

/**
 *
 * @author PenGuin
 */
//先初始化 static 类型数据，只初始化一次的，然后按顺序来

class Mybook{
    Mybook(int maker){
        System.out.println("MyBook(" + maker + ")");
    }
    void foo(int maker){
        System.out.println("foo(" + maker + ")");
        }
}

class MyPackage{
    static Mybook b1 = new Mybook(1);

    MyPackage(){
     System.out.println("MyPackage()");
     b2.foo(1);
    }

    // b2.foo(1); 放在这里不行

   void foo2(int maker){
        System.out.println("foo2(" + maker + ")");
    }

   static Mybook b2 = new Mybook(2);
}

class MyRoom{
    Mybook b3 = new Mybook(3);//这个也要在static以后
    static Mybook b4 = new Mybook(4);

    MyRoom(){
    System.out.println("MyRoom()");
     b4.foo(2);
    }

    void foo3(int maker){
        System.out.println("foo3(" + maker + ")");
    }

     static Mybook b5 = new Mybook(5);

}
public class Static_Initialize {
      public static void main(String[] args) {
        System.out.println("Creating new MyRoom() in main");
        new MyRoom();
        System.out.println("Creating new MyRoom() in main");
        new MyRoom();

        t2.foo2(1);
        t3.foo3(1);

    }
      static MyPackage t2 = new MyPackage();
      static MyRoom t3 = new MyRoom();
}
