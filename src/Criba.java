import java.util.Scanner;

public class Criba {


    // Generar números primos de 1 a max
    public static int[] generarPrimos(int max) {
        int i, j;
        if (max >= 2) {
// Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];
// Inicializar el array

            Array(dim, esPrimo);
// Eliminar el 0 y el 1, que no son primos
            primo(esPrimo);
// Criba
            criba(dim, esPrimo);
// ¿Cuántos primos hay?
            int cuenta = getCuenta(dim, esPrimo);
// Rellenar el vector de números primos
            int[] primos = new int[cuenta];

            rellenarPrimos(dim, esPrimo, primos);
            return primos;
        } else { // max < 2
            return new int[0];
// Vector vacío
        }
    }

    private static void criba(int dim, boolean[] esPrimo) {
        int j;
        int i;
        for (i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
// Eliminar los múltiplos de i
                for (j = 2 * i; j < dim; j += i)
                    esPrimo[j] = false;
            }
        }
    }

    private static void rellenarPrimos(int dim, boolean[] esPrimo, int[] primos) {
        int j;
        int i;
        for (i = 0, j = 0; i < dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
    }


    private static int getCuenta(int dim, boolean[] esPrimo) {
        int i;
        int cuenta = 0;
        for (i = 0; i < dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    private static void primo(boolean[] esPrimo) {
        esPrimo[0] = esPrimo[1] = false;
    }

    private static void Array(int dim, boolean[] esPrimo) {
        int i;
        for (i = 0; i < dim; i++)
            esPrimo[i] = true;
    }

    public static void main(String[] args) {
        inputouputdatos();
    }

    private static void inputouputdatos() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();
        int vector[] = new int[dato];
        System.out.println("\nVector inicial hasta :" + dato);
        contador(vector);
        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);
        valorPrimos(vector);
    }

    private static void valorPrimos(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }

    private static void contador(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1 + "\t");
        }
    }
}