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
                m.algo47();
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

    public void algo47() throws IOException {
        boolean clientAccpeted  = true;
        String  clientTarif     = "";

        System.out.print("Quel est votre âge : ");
        int clientAge = Integer.parseInt(reader.readLine());

        System.out.print("Nombre d'années de votre permi : ");
        int clientDLicense = Integer.parseInt(reader.readLine());

        System.out.print("Nombre d'accidents : ");
        int clientAccident = Integer.parseInt(reader.readLine());

        System.out.print("Depuis combien de temps êtes-vous chez nous : ");
        int clientSeniority = Integer.parseInt(reader.readLine());

        if (clientAge <= 25) {
            if (clientDLicense <= 2) {
                clientTarif = "rouge";
            } else if (clientDLicense > 2) {
                if (clientAccident == 0) {
                    clientTarif = "orange";
                }
                else if (clientAccident == 1) {
                    clientTarif = "rouge";
                }
                else {
                    System.out.println("On veut pas de vous ici, désolé !");
                    clientAccpeted = false;
                }
            } else {
                System.out.println("On veut pas de vous ici, désolé !");
                clientAccpeted = false;
            }
        } else if (clientAge > 25) {
            if (clientDLicense <= 2) {
                if (clientAccident == 0) {
                    clientTarif = "orange";
                } else if (clientAccident == 1) {
                    clientTarif ="rouge";
                } else {
                    System.out.println("On veut pas de vous ici, désolé !");
                    clientAccpeted = false;
                }
            } else {
                if (clientAccident == 0) {
                    clientTarif = "vert";
                } else if (clientAccident == 1) {
                    clientTarif = "orange";
                } else if (clientAccident == 2) {
                    clientTarif = "rouge";
                } else {
                    System.out.println("On veut pas de vous ici, désolé !");
                    clientAccpeted = false;
                }
            }
        } else {
            System.out.println("On veut pas de vous ici, désolé !");
            clientAccpeted = false;
        }

        if (clientSeniority > 5) {
            if (clientTarif == "rouge") {
                clientTarif = "orange";
            } else if (clientTarif == "orange") {
                clientTarif = "vert";
            } if (clientTarif == "vert") {
                clientTarif = "bleu";
            }
        }

        if (clientAccpeted) {
            System.out.println("Votre tarif prévu est : "+clientTarif);
        }
    }

    public void algo48() throws IOException {
        boolean dateLeapYear = false;

        System.out.print("Donner un numéro de jour : ");
        int dateDay = Integer.parseInt(reader.readLine());

        System.out.print("Donner un numéro de mois : ");
        int dateMonth = Integer.parseInt(reader.readLine());

        System.out.print("Donner une année : ");
        int dateYear = Integer.parseInt(reader.readLine());

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
