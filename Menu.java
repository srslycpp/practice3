import java.util.Scanner;
 
public class Menu {
 
    public static void main(String[] args) {
        opcje();
        System.out.println("Dzi�kuj� za wsp�prac�.");
    }
 
    static void wyswietlMenu() {
        // wyra�enie "\n" wprowadza znak nowej linii
        System.out.print("\nCo chcesz zrobi�?\n"
                + " d - wprowad� nowe dane \n"
                + " p - wy�wietl wszystkie dane \n"
                + " n - podaj najwi�ksz� liczb� \n"
                + " m - podaj najmniejsz� liczb� \n"
                + " s - podaj �redni� arytmetyczn� \n"
                + " r - podaj sum� liczb \n"
                + " w - podaj wariancj� \n"
                + " a - podaj wszystkie powy�sze \n"
                + " k - koniec programu\n"
                + "> ");
    }
 
 
    static double[] wprowadzNoweDane() {
        Scanner skaner = new Scanner(System.in);
        System.out.println("Podaj ile liczb chcesz wpisa� ");
        int dlTabeli = skaner.nextInt();
        double[] liczby = new double[dlTabeli];
        for (int i = 0; i < liczby.length; i++) {
            System.out.println("Podaj " + (i + 1) + " liczb� z " + dlTabeli);
            liczby[i] = skaner.nextDouble();
        }
        return liczby;
    }
 
    static void wypiszDane(double[] liczby) {
        for (int i = 0; i < liczby.length; i++) {
            System.out.println(i + ": " + liczby[i]);
        }
    }
    
 
    static double podajNajwiekszaLiczbe(double[] liczby) {
        double max = liczby[0];
        for (double l : liczby) {
            if (l > max) {
                max = l;
            }
        }
        return max;
    }
    
    static double podajNajmniejszaLiczbe(double[] liczby) {
        double min = liczby[0];
        for (int i = 0; i<liczby.length;i++) {
            if (liczby[i] < min) {
                min = liczby[i];
            }
        }
        return min; 
    }
    
    static double podajSredniaArytmetyczna(double[] liczby) {   
        return podajSumeLiczb(liczby) / liczby.length;
    }
 
    static double podajSumeLiczb(double[] liczby) {
        double sum = 0;
        for (double l : liczby) {
            sum = sum + l;
        }
        return sum;
    }
 
 
    static double podajWariancje(double[] liczby) {
        double srednia = podajSredniaArytmetyczna(liczby);
        double sum = 0.0;
        for (double l : liczby) {
            sum = sum + (l - srednia) * (l - srednia);
        }
        double wariancja = sum / (liczby.length - 1);
        return wariancja;
    }
 
    static void podajWszystko(double[] liczby) {
        System.out.println("******** Wyniki ********");
        System.out.println("Dane:");
        wypiszDane(liczby);
        System.out.println("Min:       " + podajNajmniejszaLiczbe(liczby));
        System.out.println("Max:       " + podajNajwiekszaLiczbe(liczby));
        System.out.println("�rednia:   " + podajSredniaArytmetyczna(liczby));
        System.out.println("Suma:      " + podajSumeLiczb(liczby));
        System.out.println("Wariancja: " + podajWariancje(liczby));
        System.out.println("_________________________");
 
    }
 
 
    /**
     * Pobranie opcji i wyb�r
     */
    static void opcje() {
        String opcja = "";
        double[] liczby = new double[0];
        Scanner skaner = new Scanner(System.in);
        while (!opcja.equalsIgnoreCase("k")) {
            wyswietlMenu();
            opcja = skaner.nextLine();
           // if (liczby.length == 0 && !opcja.equalsIgnoreCase("k")) {
               // liczby = wprowadzNoweDane();
                if (!opcja.equalsIgnoreCase("d") && !opcja.equalsIgnoreCase("k")) {
                    liczby = wprowadzNoweDane();
            } else if (opcja.equalsIgnoreCase("p")) {
                wypiszDane(liczby);
            } else if (opcja.equalsIgnoreCase("d")) {
                liczby = wprowadzNoweDane();
            } else if (opcja.equalsIgnoreCase("m")) {
                System.out.println("Najmniejsza liczba to: " + podajNajmniejszaLiczbe(liczby));
            } else if (opcja.equalsIgnoreCase("n")) {
                System.out.println("Najwi�ksza liczba to: " + podajNajwiekszaLiczbe(liczby));
            } else if (opcja.equalsIgnoreCase("s")) {
                System.out.println("�rednia arytmetyczna liczb to: " + podajSredniaArytmetyczna(liczby));
            } else if (opcja.equalsIgnoreCase("r")) {
                System.out.println("Suma liczb to: " + podajSumeLiczb(liczby));
            } else if (opcja.equalsIgnoreCase("w")) {
                System.out.println("Wariancja dla podanych liczb to: " + podajWariancje(liczby));
            } else if (opcja.equalsIgnoreCase("a")) {
                podajWszystko(liczby);
            } else if (opcja.equalsIgnoreCase("k")) {
                System.out.println("Koniec!");
            } else {
                System.out.println("Nie rozumiem, spr�buj ponownie");
            }
 
        }
    }
 
}