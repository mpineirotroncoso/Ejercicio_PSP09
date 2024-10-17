public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ThreadNumero tn = new ThreadNumero(1);
        new Thread(tn).start();
    }
}