import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class MedicalCentre {

    public void processQueue(String string) {
        try (FileReader fw = new FileReader(string);
                BufferedReader bw = new BufferedReader(fw)) {
            System.out.println();
            // more code
        } catch (IOException e) {
            // exception handling left as an exercise for the reader
        }
    }

}
