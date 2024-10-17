import java.util.ArrayList;
import java.util.List;

public class ThreadNumero implements Runnable{
    private int threadNum;
    public ThreadNumero(int threadNum) {
        this.threadNum = threadNum;
    }

    public void run() {
        System.out.println("Thread: " + threadNum);

        if (threadNum < 3) {
            ThreadNumero tn = new ThreadNumero(threadNum + 1);
            new Thread(tn).start();
        }

        List<Integer> numeros = new ArrayList<Integer>();
        int resultado = 0;

        switch (threadNum) {
            case 1: // numeros pares
                for (int i = 0; i < 2500; i++) {
                    if (i % 2 == 0) {
                        numeros.add(i);
                    }
                }

                break;
            case 2: // numeros impares
                for (int i = 0; i < 2500; i++) {
                    if (i % 2 != 0) {
                        numeros.add(i);
                    }
                }
                break;
            case 3: // termina en 3 o 4
                for (int i = 0; i < 2500; i++) {
                    if (i % 10 == 3 || i % 10 == 4) {
                        numeros.add(i);
                    }
                }
                break;
        }

        for (Integer numero : numeros) {
            resultado = resultado + numero;
        }
        System.out.println("Thread "+ threadNum + ": " + resultado);
    }
}
