/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iostream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;

/**
 *
 * @author PenGuin
 */
public class StreamTokenizerDemo {

    private static int lines = 0;
    private static int words = 0;
    private static int chars = 0;

    public void wordCount(Reader r) throws IOException {
        StreamTokenizer tok = new StreamTokenizer(r);

        tok.resetSyntax();
        tok.wordChars(33, 255);
        tok.whitespaceChars(0, ' ');

        while (tok.nextToken() != StreamTokenizer.TT_EOF) {
            switch (tok.ttype) {
                case StreamTokenizer.TT_EOL:
                    lines++;
                    chars++;
                    break;
                case StreamTokenizer.TT_WORD:
                    words++;
                    chars += tok.sval.length();
                    break;
                default:
                    System.out.println("Error!");
                    
            }
        }

        System.out.println("lines = " + lines);
        System.out.println("words = " + words);
        System.out.println("chars = " + chars);
    }

    public static void main(String[] args) throws IOException {

//        String test = "I am a programmer! I am happy";
//        Reader r = new StringReader(test);
        File file = new File("Redirecting.java");
        Reader r = new FileReader(file);
        new StreamTokenizerDemo().wordCount(r);
    }
}
