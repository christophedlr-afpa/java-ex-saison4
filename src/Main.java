import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int choice = 0;
        boolean valid = false;
        Main m = new Main();

        while (!valid) {
            System.out.println("Choisissez votre action");
            System.out.println("1. Algorithme 4.7");
            System.out.println("2. Algorithùe 4.8");

            choice = Integer.parseInt(m.reader.readLine());

            if (choice == 1) {
                valid = true;
                //m.algo47();
            }
            else if (choice == 2) {
                valid = true;
                m.algo48();
            }
            else {
                valid = false;
                System.out.println("Choix invalide");
            }
        }
    }

    public void algo48() throws IOException {
        int     dateDay      = 0;
        int     dateMonth    = 0;
        int     dateYear     = 0;
        boolean dateLeapYear = false;

        System.out.print("Donner un numéro de jour : ");
        dateDay = Integer.parseInt(reader.readLine());

        System.out.print("Donner un numéro de mois : ");
        dateMonth = Integer.parseInt(reader.readLine());

        System.out.print("Donner une année : ");
        dateYear = Integer.parseInt(reader.readLine());

        if (dateDay < 1 || dateDay > 31) {
            System.out.println("Date non valide");
        }

        if (dateMonth < 1 || dateMonth > 12) {
            System.out.println("Date non valide");
        }

        if (dateYear%4 == 0 && dateYear%100 != 0) {
            dateLeapYear = true;
        }
        else if (dateYear%400 == 0) {
            dateLeapYear = true;
        }
        else {
            dateLeapYear = false;
        }

        if (dateMonth == 1 || dateMonth == 3 || dateMonth == 5 || dateMonth == 7 || dateMonth == 8 || dateMonth == 10 || dateMonth == 12) {
            if (dateDay <= 31) {
                System.out.println("Date valide");
            }
        } else if (dateMonth == 4 || dateMonth == 6 || dateMonth == 9 || dateMonth == 11) {
            if (dateDay == 31) {
                System.out.println("Date valide");
            }
        } else if (dateMonth == 2) {
            if (dateLeapYear) {
                if (dateDay <= 29) {
                    System.out.println("Date valide");
                } else {
                    System.out.println("Date non valide");
                }
            } else if (dateDay > 28) {
                System.out.println("Date non valide");
            }
        }
    }
}
