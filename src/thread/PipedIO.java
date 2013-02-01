/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package thread;
import java.io.*;
import java.util.*;

class PipeSender extends Thread{
    private Random rand = new Random();//这种直接赋值在C里面是不允许的
    private PipedWriter out = new PipedWriter();
    public PipedWriter getPipedWriter(){return out;}//这个是必须的

    public void run(){
        while (true){
            for (char c = 'A'; c <= 'Z'; c++) {
                try {
                    out.write(c);//往管道里写数据
                    System.out.println("Write_data is:" + c);
                //    sleep(rand.nextInt(500));
                      sleep(3000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}

class PipeReciver extends Thread{
    private PipedReader in;

    public PipeReciver(PipeSender sender) throws IOException 
    {
             in = new PipedReader(sender.getPipedWriter());//直接用类的赋值来传递数据
    }
     public void run(){
         try{
         while(true){
             System.out.println("Read_data is :" + (char)in.read());
         }
     }
         catch(IOException e){
            throw new RuntimeException(e);
         }

}
}
/**
 *
 * @author PenGuin
 */
public class PipedIO {
     public static void main(String[] args) throws IOException {
        PipeSender sender = new PipeSender();
        PipeReciver receiver = new PipeReciver(sender);

        sender.start();
        receiver.start();

    }
}
