import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Metodo 1");
        Path file1 = new File("risorse/poesia.txt").toPath();
        FileAndParole.stampaParole(file1);

        System.out.println("Metodo 2");
        HashMap<String, Integer> occorrenzaParole = FileAndParole.occorrenzaParole(file1);
        System.out.println(occorrenzaParole);

        System.out.println("Metodo 3");
        HashMap<String, Integer> occorrenzaParoleTesto = FileAndParole.occorrenzeParoleTesto(file1);
        System.out.println(occorrenzaParoleTesto);

        System.out.println("Metodo 4");
        Map<String, Set<String>> paroleInRima = FileAndParole.paroleInRima(file1);
        System.out.println(paroleInRima);

    }
}
