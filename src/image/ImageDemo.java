/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package image;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author PenGuin
 */
public class ImageDemo {

    public static void main(String[] args) throws IOException {

        String filename = "(1).TIF";
        File file = new File(filename);

        BufferedImage srcImg = null;

        try {
            srcImg = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int width = srcImg.getWidth();
        int height = srcImg.getHeight();

        BufferedImage cutImg = srcImg.getSubimage(0, 0, width / 2, height);
        ImageIO.write(cutImg, "png", new File("cutImage.png"));

//          double[] a = new double[10];
//          double sum = 0;
//          Scanner scanner = new Scanner(System.in);
//          for (int i = 0; i < a.length; i++) {
//            a[i] = scanner.nextDouble();
//          //  System.out.println(a[i]);
//            sum += a[i];
//        }
//          System.out.println(sum/60/1000);


    }
}
