
import java.util.Scanner;

public class OptimizacionPrecios {

    public static void ingresarValores(int numPrecios, int[] precios, int tamanioAjuste, int[] listaAjuste) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numPrecios; i++) {
            System.out.print("Precio [" + (i + 1) + "] = ");
            precios[i] = scanner.nextInt();
        }
        for (int i = 0; i < tamanioAjuste; i++) {
            System.out.print("Precio de ajuste [" + (i + 1) + "] = ");
            listaAjuste[i] = scanner.nextInt();
        }
    }

    public static void evaluarValores(int numPrecios, int[] precios, int tamanioAjuste, int[] listaAjuste, int numeroMayor, int[] nuevoPrecio) {
        numeroMayor = encontrarNumMayor(numeroMayor, listaAjuste);
        for (int i = 0; i < numPrecios; i++) {
            int numeroMayorDivisor = 0;
            for (int j = 0; j < tamanioAjuste; j++) {
                if (precios[i] % listaAjuste[j] == 0) {
                    if (listaAjuste[j] > numeroMayorDivisor) {
                        numeroMayorDivisor = listaAjuste[j];
                    }
                }
            }
            if (numeroMayorDivisor > 0) {
                precios[i] = precios[i] / numeroMayorDivisor;
            } else {
                precios[i] = precios[i] * numeroMayor;
            }
        }
        // Ordenar números
        int[] preciosOrdenados = new int[precios.length];
        for (int i = 0; i < precios.length; i++) {
            for (int j = 0; j < precios.length; j++) {
                if (preciosOrdenados[i] < precios[j]) {
                    preciosOrdenados[i] = precios[j];
                }
            }
        }
        for (int i = 0; i < precios.length; i++) {
            System.out.println("Precio optimizado [" + (i + 1) + "] = " + preciosOrdenados[i]);
        }
    }

    public static int encontrarNumMayor(int numeroMayor, int[] listaAjuste) {
        for (int i = 0; i < listaAjuste.length; i++) {
            if (listaAjuste[i] > numeroMayor) {
                numeroMayor = listaAjuste[i];
            }
        }
        return numeroMayor;
    }

    public static void main(String[] args) {
        System.out.print("Introduce el número de precios a ingresar: ");
        Scanner scanner = new Scanner(System.in);
        int numPrecios = scanner.nextInt();
        int[] precios = new int[numPrecios];
        System.out.print("Introduce el tamaño de la lista de ajuste (2 o 3): ");
        int tamanioAjuste = scanner.nextInt();
        int[] listaAjuste = new int[tamanioAjuste];
        if (tamanioAjuste != 2 && tamanioAjuste != 3) {
            System.out.print("Tamaño inválido");
            return;
        }
        int[] nuevoPrecio = new int[numPrecios];
        ingresarValores(numPrecios, precios, tamanioAjuste, listaAjuste);
        evaluarValores(numPrecios, precios, tamanioAjuste, listaAjuste, numPrecios, nuevoPrecio);
    }
}
