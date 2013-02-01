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
public class DeleteFolder {

    public void delFolder(String folderPath){
        try {
            delAllFile(folderPath);
            //文件删完了 原始文件目录也要删掉
            File myFilePath = new File(folderPath);
            myFilePath.delete();
        } catch (Exception e) {
            System.out.println("删除文件夹错误");
            e.printStackTrace();
        }
    }
    public void delAllFile(String path){
        File file = new File(path);
        if (!file.exists()){
            return;
        }
        if (!file.isDirectory()){
            return;
        }

        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            System.out.println(tempList[i].toString());
            if (path.endsWith(File.separator)){
                temp  = new File(path + tempList[i]);
            }
            else{
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()){
                temp.delete();
            }
            if (temp.isDirectory()){
                delFolder(path + File.separator + tempList[i]);
            }
        }
    }
    public static void main(String[] args) {
        DeleteFolder deleteFolder = new DeleteFolder();
     //   System.out.println(File.separator);
        deleteFolder.delFolder("Test123");
    }
}
