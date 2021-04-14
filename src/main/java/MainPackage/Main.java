package MainPackage;

import java.util.Random;

public class Main
{
    public static double f0(double valueOfX) { return Math.pow(valueOfX, 4)-4*Math.pow(valueOfX, 2)+4;} //funkcja zwraca wartość funkcji dla konkretnego punktu
    public static double f0Der(double valueOfX) { return 4*Math.pow(valueOfX, 3)-8*valueOfX;} // funkcja zwraca wartość pochodnej dla konkretnej funkcji
    public static void f0Gradient(double epsilon, double step, double n) //funkcja generowania liczb pseudolosowych dla kolejnej funkcji
    {
        Random r = new Random(); //uruchomienie generatora liczb pseudolosowych
        double randomValue = (n * 2 * r.nextDouble())-n; //wygenerowanie liczby od -n do n
        f0Gradient(epsilon, step, new double[]{randomValue}); // uruchomienie funkcji liczenia gradientu dla punktu z lini powyżej
    }
    public static void f0Gradient(double epsilon, double step, double[]vector) //funkcja liczenia gradientu dla funkcji f0
    {
        double[]newVector = {0.0}; // przygotowanie wektora na nowy punkt
        int steps = 0; // licznik liczby iteracji
        while (true) // pętla algorytmu
        {
            steps+=1; //zwiększenie liczby iteracji
            newVector[0] = vector[0] - step * f0Der(vector[0]); //obliczenie nowego punktu

            double max = Math.abs(newVector[0]-vector[0]); //obliczenie różnicy punktów

            if (max<epsilon) // sprawdzenie czy nie osiągneliśmy już oczekiwanej dokładności
            {
                System.out.println("----------");
                System.out.println("Wyznaczono minimum");
                System.out.println("x1 = "+newVector[0]);
                System.out.println("wartość = "+f0(newVector[0]));
                System.out.println("Wyznaczono w "+steps+" iteracjach");
                System.out.println("----------");
                break;
            }

            vector[0] = newVector[0];//zastąpienie starego punktu nowym
        }
    }
    public static double f1(double valueOfX, double valueOfY, double valueOfZ) {return 2*Math.pow(valueOfX, 2)+2*Math.pow(valueOfY, 2)+Math.pow(valueOfZ, 2)-2*valueOfX*valueOfY-2*valueOfY*valueOfZ-2*valueOfX+3;}//funkcja zwraca wartość funkcji dla konkretnego punktu
    public static double f1DerX(double valueOfX, double valueOfY, double valueOfZ) {return 4*valueOfX-2*valueOfY-2;}// funkcja zwraca wartość pochodnej cząstkowej dla konkretnej funkcji
    public static double f1DerY(double valueOfX, double valueOfY, double valueOfZ) {return -2*valueOfX+4*valueOfY-2*valueOfZ;}// funkcja zwraca wartość pochodnej cząstkowej dla konkretnej funkcji
    public static double f1DerZ(double valueOfX, double valueOfY, double valueOfZ) {return 2*valueOfZ-2*valueOfY;}// funkcja zwraca wartość pochodnej cząstkowej dla konkretnej funkcji
    public static void f1Gradient(double epsilon, double step, double n)//funkcja generowania liczb pseudolosowych dla kolejnej funkcji
    {
        Random r = new Random();//uruchomienie generatora liczb pseudolosowych
        double randomValueX = (n * 2 * r.nextDouble())-n;//wygenerowanie liczby od -n do n
        double randomValueY = (n * 2 * r.nextDouble())-n;//wygenerowanie liczby od -n do n
        double randomValueZ = (n * 2 * r.nextDouble())-n;//wygenerowanie liczby od -n do n
        f1Gradient(epsilon, step, new double[]{randomValueX, randomValueY, randomValueZ});// uruchomienie funkcji liczenia gradientu dla punktu z lini powyżej
    }
    public static void f1Gradient(double epsilon, double step, double[]vector)//funkcja liczenia gradientu dla funkcji f1
    {
        double[]newVector = {0.0,0.0,0.0};// przygotowanie wektora na nowy punkt
        int steps = 0;// licznik liczby iteracji
        while (true)// pętla algorytmu
        {
            steps+=1;//zwiększenie liczby iteracji
            newVector[0] = vector[0] - step * f1DerX(vector[0],vector[1],vector[2]);//obliczenie nowego punktu
            newVector[1] = vector[1] - step * f1DerY(vector[0],vector[1],vector[2]);//obliczenie nowego punktu
            newVector[2] = vector[2] - step * f1DerZ(vector[0],vector[1],vector[2]);//obliczenie nowego punktu

            double max = Math.abs(newVector[0]-vector[0]);//obliczenie różnicy punktów
            if (Math.abs(newVector[1]-vector[1])>max) max = Math.abs(newVector[1]-vector[1]);//obliczenie różnicy punktów
            if (Math.abs(newVector[2]-vector[2])>max) max = Math.abs(newVector[2]-vector[2]);//obliczenie różnicy punktów

            if (max<epsilon)// sprawdzenie czy nie osiągneliśmy już oczekiwanej dokładności
            {
                System.out.println("----------");
                System.out.println("Wyznaczono minimum");
                System.out.println("x1 = "+newVector[0]);
                System.out.println("x2 = "+newVector[1]);
                System.out.println("x3 = "+newVector[2]);
                System.out.println("wartość = "+f1(newVector[0],newVector[1],newVector[2]));
                System.out.println("Wyznaczono w "+steps+" iteracjach");
                System.out.println("----------");
                break;
            }

            vector[0] = newVector[0];//zastąpienie starego punktu nowym
            vector[1] = newVector[1];//zastąpienie starego punktu nowym
            vector[2] = newVector[2];//zastąpienie starego punktu nowym
        }
    }
    public static double f2(double valueOfX, double valueOfY) {return 3*Math.pow(valueOfX, 4)+4*Math.pow(valueOfX,3)-12*Math.pow(valueOfX,2)+12*Math.pow(valueOfY,2)-24*valueOfY;}//funkcja zwraca wartość funkcji dla konkretnego punktu
    public static double f2DerX(double valueOfX, double valueOfY) {return 12*Math.pow(valueOfX, 3)+12*Math.pow(valueOfX,2)-24*valueOfX;}// funkcja zwraca wartość pochodnej cząstkowej dla konkretnej funkcji
    public static double f2DerY(double valueOfX, double valueOfY) {return 24*valueOfY-24;}// funkcja zwraca wartość pochodnej cząstkowej dla konkretnej funkcji
    public static void f2Gradient(double epsilon, double step, double n)//funkcja generowania liczb pseudolosowych dla kolejnej funkcji
    {
        Random r = new Random();//uruchomienie generatora liczb pseudolosowych
        double randomValueX = (n * 2 * r.nextDouble())-n;//wygenerowanie liczby od -n do n
        double randomValueY = (n * 2 * r.nextDouble())-n;//wygenerowanie liczby od -n do n
        f2Gradient(epsilon, step, new double[]{randomValueX, randomValueY});// uruchomienie funkcji liczenia gradientu dla punktu z lini powyżej
    }
    public static void f2Gradient(double epsilon, double step, double[]vector)//funkcja liczenia gradientu dla funkcji f2
    {
        double[]newVector = {0.0,0.0};// przygotowanie wektora na nowy punkt
        int steps = 0;// licznik liczby iteracji
        while (true)// pętla algorytmu
        {
            steps+=1;//zwiększenie liczby iteracji
            newVector[0] = vector[0] - step * f2DerX(vector[0],vector[1]);//obliczenie nowego punktu
            newVector[1] = vector[1] - step * f2DerY(vector[0],vector[1]);//obliczenie nowego punktu

            double max = Math.abs(newVector[0]-vector[0]);//obliczenie różnicy punktów
            if (Math.abs(newVector[1]-vector[1])>max) max = Math.abs(newVector[1]-vector[1]);//obliczenie różnicy punktów

            if (max<epsilon)// sprawdzenie czy nie osiągneliśmy już oczekiwanej dokładności
            {
                System.out.println("----------");
                System.out.println("Wyznaczono minimum");
                System.out.println("x1 = "+newVector[0]);
                System.out.println("x2 = "+newVector[1]);
                System.out.println("wartość = "+f2(newVector[0],newVector[1]));
                System.out.println("Wyznaczono w "+steps+" iteracjach");
                System.out.println("----------");
                break;
            }

            vector[0] = newVector[0];//zastąpienie starego punktu nowym
            vector[1] = newVector[1];//zastąpienie starego punktu nowym
        }
    }
    public static void main(String[]args)
    {
        System.out.println("f0 dla x0=0.1");
        f0Gradient(0.0000001, 0.01, new double[]{0.1});//f0 dla x0=0.1
        System.out.println("f0 dla x0=-0.1");
        f0Gradient(0.0000001, 0.01, new double[]{-0.1});//f0 dla x0=-0.1
        System.out.println("f0 dla n=1");
        f0Gradient(0.0000001, 0.01, 1);//f0 dla n=1
        System.out.println("f1 dla x0=-1 x1=-1 x2=-1");
        f1Gradient(0.0000001, 0.01, new double[]{-1,-1,-1});//f1 dla x0=-1 x1=-1 x2=-1
        System.out.println("f1 dla n=10");
        f1Gradient(0.0000001, 0.01, 10);//f1 dla n=10
        System.out.println("f2 dla x0=2 x1=3");
        f2Gradient(0.0000001, 0.01, new double[]{2,3});//f2 dla x0=2 x1=3
        System.out.println("f2 dla x0=32 x1=3");
        f2Gradient(0.0000001, 0.01, new double[]{3,3});//f2 dla x0=32 x1=3
        System.out.println("f2 dla n=3");
        f2Gradient(0.0000001, 0.01, 3);//f2 dla n=3
    }
}
