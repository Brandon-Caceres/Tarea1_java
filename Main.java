import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args){
        int opcion;
        LinkedList<Ticket> tickets = new LinkedList<>();
        Scanner entrada = new Scanner(System.in);
        
        do{
            Menu.menuPrincipal();
            System.out.println("Ingrese su opcion");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch(opcion){
                case 1:
                    TicketManager.registrarTicket(tickets, entrada);
                    break;
                case 2:
                    TicketManager.nuevaPrioridad(tickets, entrada);
                    break;
                case 3:
                    TicketManager.mostrar(tickets);
                    break;
                case 4:
                    TicketManager.ProcesarTicket(tickets);
                    break;
                case 5:
                    TicketManager.BuscarPorId(tickets, entrada);
                    break;
                case 6:
                    System.out.println("Saliendo del sistema de gestion de tickets...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo;");
            }
            Utils.pausar(entrada);

        }while(opcion != 6);

        entrada.close();
    }
}

class Ticket{
    int id;
    String descripcion;
    String prioridad;
    LocalDateTime fecha;

    public Ticket(int id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = "Bajo";
        this.fecha = LocalDateTime.now();
    }

    public void setPrioridad(String nueva){
        this.prioridad = nueva;
    }
}

class Menu{
    public static void menuPrincipal(){
        Utils.limpiarPantalla();

        System.out.println("========================================");
        System.out.println("     Sistema de Gestion de Tickets");
        System.out.println("========================================");

        System.out.println("1) Registrar Tickets");
        System.out.println("2) Asignar prioridad a los Tickets");
        System.out.println("3) Mostrar lista de Tickets pendientes");
        System.out.println("4) Procesar siguiente Ticket");
        System.out.println("5) Buscar Ticket por ID y mostrar detalles");
        System.out.println("6) Salir");
    }
}

class TicketManager{
    public static void registrarTicket(List<Ticket> lista, Scanner entrada){

        System.out.println("Ingrese el ID del ticket: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Ingrese descripcion del ticket: ");
        String descripcion = entrada.nextLine();

        if (buscarTicket(lista, id) != null) {
            System.out.println("Ya existe un ticket con ID: " + id);
            return;
        }

        Ticket nuevo = new Ticket(id, descripcion);
        lista.add(nuevo);
        System.out.println("Ticket registrado correctamente.");

    }

    public static Ticket buscarTicket(List<Ticket> lista, int id){
        for (Ticket t : lista){
            if(t.id == id) return t;
        }
        return null;
    }

    public static void nuevaPrioridad(List<Ticket> lista, Scanner entrada){
        System.out.println("Ingrese el ID del ticket al que desea cambiar la prioridad");
        int id = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Ingrese la nueva prioridad (Bajo, Medio, Alto)");
        String nuevaP = entrada.nextLine().trim().toLowerCase();

        if (!nuevaP.equals("bajo") && !nuevaP.equals("medio") && !nuevaP.equals("alto")){
            System.out.println("Prioridad invalida. Use Bajo, Medio o Alto");
            return;
        }

        nuevaP = nuevaP.substring(0, 1).toUpperCase() + nuevaP.substring(1);

        boolean encontrado = false;

        for (Ticket t : lista){
            if (t.id == id){
                t.prioridad = nuevaP;
                encontrado = true;
                break;
            }
        }

        if (!encontrado){
            System.out.println("No se encontro un ticket con ID: " + id);
        }
        else{
            System.out.println("Prioridad actualizada correctamente");
        }
    }

    public static void ordenarPorPrioridad(List<Ticket> lista){
        Collections.sort(lista, new Comparator<Ticket>() {
            @Override
            public int compare(Ticket t1, Ticket t2){
                int p1 = prioridadValor(t1.prioridad);
                int p2 = prioridadValor(t2.prioridad);
                
                if (p1 != p2){
                    return Integer.compare(p2, p1);
                }

                return t1.fecha.compareTo(t2.fecha);
            }
        });
    }

    private static int prioridadValor(String prioridad){
        switch(prioridad.toLowerCase()){
            case "alto": return 3;
            case "medio": return 2;
            case "bajo": return 1;
            default: return 0;
        }
    }

    public static void mostrar(List<Ticket> lista){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        TicketManager.ordenarPorPrioridad(lista);
        for (Ticket t : lista){
            System.out.println("ID: " + t.id);
            System.out.println("Descripcion: " + t.descripcion);
            System.out.println("Prioridad: " + t.prioridad);
            System.out.println("Fecha de ingreso: " + t.fecha.format(formato));
            System.out.println("---------------------------------------");
        }
    }

    public static void ProcesarTicket(LinkedList<Ticket> lista){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        if (!lista.isEmpty()){
            Ticket t = lista.removeFirst();
            System.out.println("ID: " + t.id);
            System.out.println("Descripcion: " + t.descripcion);
            System.out.println("Prioridad: " + t.prioridad);
            System.out.println("Fecha de ingreso: " + t.fecha.format(formato));
            System.out.println("---------------------------------------");
        }
        else{
            System.out.println("No hay tickets para procesar.");
        }
    }

    public static void BuscarPorId(List<Ticket> lista, Scanner entrada){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Ingrese el ID que desea buscar: ");
        int id = entrada.nextInt();
        entrada.nextLine();
        Ticket t = buscarTicket(lista, id);

        if (t != null){
            System.out.println("ID: " + t.id);
            System.out.println("Descripcion: " + t.descripcion);
            System.out.println("Prioridad: " + t.prioridad);
            System.out.println("Fecha de ingreso: " + t.fecha.format(formato));
            System.out.println("---------------------------------------");
        }
        else{
            System.out.println("El ticket con ID: " + id + " no se encuentra en el sistema.");
        }
    }
}