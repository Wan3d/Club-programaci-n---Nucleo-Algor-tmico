
import java.util.Scanner;

public class ConjeturaCollatz {

    public static int evaluarPresupuesto(int numPresupuesto) {
        if (numPresupuesto < 1 || numPresupuesto > Math.pow(10, 5)) {
            System.out.print("Número de presupuesto fuera de intervalo");
        }
        return numPresupuesto;
    }

    public static void ingresarValores(int numPresupuesto) {
        Scanner scanner = new Scanner(System.in);
        int[] presupuestos = new int[numPresupuesto];
        int[] presupuestosOriginales = new int[numPresupuesto];
        int[] iteraciones = new int[numPresupuesto];
        int iteracionMayor = 0;
        int iteracionMenor = 0;
        int numeroMayor = 0;
        for (int i = 0; i < numPresupuesto; i++) {
            System.out.print("Ingresa el valor del presupuesto [" + (i + 1) + "] = ");
            presupuestos[i] = scanner.nextInt();
            presupuestosOriginales[i] = presupuestos[i];
            if (presupuestos[i] < 1 || presupuestos[i] > Math.pow(10, 6)) {
                System.out.print("Presupuesto fuera del intervalo");
            } else {
                while (presupuestos[i] != 1) {
                    if (presupuestos[i] % 2 == 0) {
                        iteraciones[i]++;
                        presupuestos[i] /= 2;
                    } else if (presupuestos[i] % 2 != 0) {
                        iteraciones[i]++;
                        presupuestos[i] = (3 * presupuestos[i]) + 1;
                    }
                }
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < numPresupuesto; i++) {
            System.out.printf("%d: %d iteraciones\n", presupuestosOriginales[i], iteraciones[i]);
            if (iteraciones[i] > iteracionMayor) {
                iteracionMayor = iteraciones[i];
                numeroMayor = presupuestosOriginales[i];
            } else {
                iteracionMenor = iteraciones[i];
            }
        }
        System.out.printf("Máximo: %d con %d iteraciones\n", numeroMayor, iteracionMayor);
        System.out.printf("Iteración menor: %d\n", iteracionMenor);
        scanner.close();
    }

    public static void main(String[] args) {
        System.out.print("Ingresa el número de presupuestos: ");
        Scanner scanner = new Scanner(System.in);
        int numPresupuesto = scanner.nextInt();
        evaluarPresupuesto(numPresupuesto);
        ingresarValores(numPresupuesto);
        scanner.close();
    }
}
