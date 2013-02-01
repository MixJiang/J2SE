/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iostream;
import java.io.*;
/**
 *
 * @author PenGuin
 */
public class CreateNewFolder {
     private void newFolder(String newfolder){
         try {
             String filepath = newfolder;
             File myPath = new File(filepath);
             if (!myPath.exists()){
                 myPath.mkdir();
             }
             else
             {
                 throw new Exception("新建的目录存在");
             }
         } catch (Exception e) {
             //System.out.println("新建的目录存在");
             e.printStackTrace();
         }
     }

     public static void main(String[] args) {
         CreateNewFolder createNewFolder = new CreateNewFolder();
         String mynewpath = "IO_Test_CreateNewFolder";
         createNewFolder.newFolder(mynewpath);
    }
}
