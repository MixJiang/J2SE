/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;
import java.io.*;
/**
 *
 * @author PenGuin
 */
public class InputFileExceptionTest {
    private BufferedReader in;
    void InputFile(String filename) throws Exception{
        try {
             in = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            System.err.println("Could not open " + filename);
           // throw e; //如果不调到外层 显示的东西就只有 Could not open test.txt
        }
        catch(Exception e){
            try {
                in.close();
            } catch (IOException e2) {
                System.err.println("in.close() unsuccesssful");
            }
           // throw e;
        }
        finally {
//            in.close(); //不能这样 因为文件总是要关闭的
        }
    }
    public static void main(String[] args) throws Exception {
        new InputFileExceptionTest().InputFile("test123.txt");
    }
}
