import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Hourglass {

    private static ArrayList<String> fileData = getFileData("src/hourglass.txt");
    private static String[][] hourglass = new String[53][90];
    public static void main(String[] args) {

        for (int r = 0; r < hourglass.length; r++) {
            for (int c = 0; c < hourglass[0].length; c++) {
                hourglass[r][c] = fileData.get(r).substring(c, c+1);
            }
        }

        rotate_up();

        for (int r = 0; r < hourglass.length; r++) {
            for (int c = 0; c < hourglass[0].length; c++) {
                System.out.print(hourglass[r][c]);
            }
            System.out.println();
        }
    }

    public static void rotate_right() {
        for (int r = 1; r < hourglass.length - 1; r++) {
            for (int c = hourglass[0].length - 1; c >= 0; c--) {
                if (hourglass[r][c].equals("O")) {
                    int next = c + 1;
                    while (hourglass[r][next].equals(".")) {
                        hourglass[r][next] = "O";
                        hourglass[r][next - 1] = ".";
                        next += 1;
                    }
                }
            }
        }
    }

    public static void rotate_left() {
        for (int r = 1; r < hourglass.length - 1; r++) {
            for (int c = 0; c < hourglass[0].length; c++) {
                if (hourglass[r][c].equals("O")) {
                    int next = c - 1;
                    while (hourglass[r][next].equals(".")) {
                        hourglass[r][next] = "O";
                        hourglass[r][next + 1] = ".";
                        next -= 1;
                    }
                }
            }
        }
    }

    public static void rotate_down() {
        for (int r = hourglass.length - 1; r >= 0; r--) {
            for (int c = 0; c < hourglass[0].length; c++) {
                if (hourglass[r][c].equals("O")) {
                    int next = r + 1;
                    while (hourglass[next][c].equals(".")) {
                        hourglass[next][c] = "O";
                        hourglass[next - 1][c] = ".";
                        next += 1;
                    }
                }
            }
        }
    }

    public static void rotate_up() {
        for (int r = 0; r < hourglass.length; r++) {
            for (int c = 0; c < hourglass[0].length; c++) {
                if (hourglass[r][c].equals("O")) {
                    int next = r - 1;
                    while (hourglass[next][c].equals(".")) {
                        hourglass[next][c] = "O";
                        hourglass[next + 1][c] = ".";
                        next -= 1;
                    }
                }
            }
        }
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
}

