package sem_03_cw.task_0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    private static void rwLine(Path pathRead, Path pathWrite) throws IOException {

        //BufferedReader in = null;
        //BufferedReader out = null;

        try (BufferedReader in = Files.newBufferedReader(pathRead, StandardCharsets.UTF_8);
             BufferedWriter out = Files.newBufferedWriter(pathWrite, StandardCharsets.UTF_8)) {
            //in = Files.newBufferedReader(pathRead);
            //out = Files.newBufferedReader(pathWrite);

            out.write(in.readLine());

        }/*finally {
            try {
                if (in != null) in.close();
            }catch (IOException e){

            }
            try {
                if (out != null) in.close();
            }catch (IOException ex){

            }
        }*/
    }
}
