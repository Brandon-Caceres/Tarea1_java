import java.util.*;

public class Utils {
    public static void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("No se pudo limpiar la pantalla.");
        }
    }

    public static void pausar(Scanner entrada) {
        System.out.println("Presione Enter para continuar...");
        entrada.nextLine();
    }
}