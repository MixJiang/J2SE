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
public class CreateNewFile {

    public void createNewFile(String fileDerectoryAndName, String fileContent){
        try {
             String fileName = fileDerectoryAndName;
             File myFile = new File(fileName);
        if (!myFile.exists()){
            myFile.createNewFile();
        }

//这两个类是用来给文件里面写入内容的
            FileWriter resultFile = new FileWriter(myFile);
            PrintWriter myNewFile = new PrintWriter(resultFile);

            myNewFile.println(fileContent);//利用PrintWriter,往文件里面写
            resultFile.close();

        } catch (Exception e) {
            System.out.println("无法创建新文件");
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        CreateNewFile createFile = new CreateNewFile();
        createFile.createNewFile("IO_Test_File.txt", "加油！，彭俊");
    }
}
