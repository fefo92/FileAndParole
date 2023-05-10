import java.io.*;
import java.nio.file.Path;
import java.util.*;


public class FileAndParole {
    /*
    * Metodo 1: stampa le parole di un file di testo in console
    */
    public static void stampaParole(Path file) throws IOException {
        FileReader filereader = new FileReader(file.toFile());
        BufferedReader br = new BufferedReader(filereader);
        while (br.ready()) {
            String[] parole = br.readLine().split(" ");
            Arrays.stream(parole).forEach(System.out::println);
        }
        br.close();
    }
    /*
     * Metodo 2: stampa in console quante volte viene trovata la stessa parola in un file di testo (occorrenze)
     */
    public static HashMap<String, Integer> occorrenzaParole(Path file) throws IOException {
        FileReader filereader = new FileReader(file.toFile());
        BufferedReader br = new BufferedReader(filereader);
        HashMap<String, Integer> countParole = new HashMap<>();
        while (br.ready()) {
            String[] parole = br.readLine().split(" ");
            for (String parola : parole) {
                if (!countParole.containsKey(parola)) {
                    countParole.put(parola, 1);
                } else {
                    countParole.put(parola, countParole.get(parola) + 1);
                }
            }
        }
        br.close();
        return countParole;

    }
    /*
     * Metodo 3:
     */
    public static HashMap<String, Integer> occorrenzeParoleTesto(Path file) throws IOException {
        FileReader filereader = new FileReader(file.toFile());
        BufferedReader br = new BufferedReader(filereader);
        HashMap<String, Integer> countParole = new HashMap<>();
        while (br.ready()) {
            String[] parole = br.readLine().toLowerCase().split("\\W+");
            for (String parola : parole) {
                if (parola.length() == 0) continue;
                if (!countParole.containsKey(parola)) {
                    countParole.put(parola, 1);
                } else {
                    countParole.put(parola, countParole.get(parola) + 1);
                }
            }
        }
        br.close();
        return countParole;
    }
    /*
     * Metodo 4: stampa e cataloga tutte le parole in rima prendendo la parte finale delle parole (dittonghi)
     * di un file di testo
     */
    public static HashMap<String, Set<String>> paroleInRima(Path file) throws IOException {
        // prendo il dittongo finale
        FileReader filereader = new FileReader(file.toFile());
        BufferedReader br = new BufferedReader(filereader);
        HashMap<String, Set<String>> rime = new HashMap<>();
        while (br.ready()) {
            String[] parole = br.readLine().toLowerCase().split("\\W+");
            for (String parola : parole) {
                if (parola.length() < 4) continue;
                String dittongo;
                char terzultimoCar = parola.charAt(parola.length() - 3);
                if (terzultimoCar == 'a' || terzultimoCar == 'e' || terzultimoCar == 'i' || terzultimoCar == 'o' || terzultimoCar == 'u') {
                    dittongo = parola.substring(parola.length() - 3);
                } else {
                    dittongo = parola.substring(parola.length() - 4);
                }
                if (rime.containsKey(dittongo)) {
                    Set<String> paroleDittongo = rime.get(dittongo);
                    paroleDittongo.add(parola);
                    rime.put(dittongo, paroleDittongo);
                }else{
                    Set<String> paroleDittongo = new HashSet<>();
                    paroleDittongo.add(parola);
                    rime.put(dittongo, paroleDittongo);
                }
            }
        }
        br.close();
        return rime;
    }
}
