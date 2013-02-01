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

//只能删空目录
public class DeleteFile {
public void delFile(String fileDerecatorAndName){
    try {
        File deleteFile = new File(fileDerecatorAndName);
        boolean delete = deleteFile.delete();//没有目录或文件根本捕捉不到的情况 catch不到
        System.out.println(delete);
    } catch (Exception e) {
        System.out.println("删除文件错误");
        e.printStackTrace();
    }
}
    public static void main(String[] args) {
        DeleteFile deleteFile = new DeleteFile();
        deleteFile.delFile("Test123");//只能删空目录或文件
    }
}
