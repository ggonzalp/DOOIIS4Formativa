import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Clase principal del programa
 * Es la entrada al sistema.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("=====================" +
                "\n----- SpeedFast -----" +
                "\n=====================");

        //Llamada al ControladorDePedidos
        ControladorDePedidos controlador = new ControladorDePedidos();

        System.out.println("\n--- INGRESO DE PEDIDOS ---");

        PedidoComida pedido1 = new PedidoComida("PEDIDO COMIDA", 101, "KFC.", new DireccionEntrega(345, "Los aromos", "Chillán"), 2, true, PrioridadPedido.MEDIA);
        pedido1.mostrarResumen();

        System.out.println("\n----------------------------");

        PedidoEncomienda pedido2 = new PedidoEncomienda("PEDIDO ENCOMIENDA", 102, "Caja 5kg.", new DireccionEntrega(456, "Las azucenas", "Concepción"), 12, false, PrioridadPedido.BAJA);
        pedido2.mostrarResumen();

        System.out.println("\n----------------------------");

        PedidoExpress pedido3 = new PedidoExpress("PEDIDO EXPRESS", 103, "Sobre con documentos.", new DireccionEntrega(567, "Los maitenes", "Temuco"), 6, true, PrioridadPedido.ALTA);
        pedido3.mostrarResumen();

        System.out.println("\n----------------------------");

        PedidoEncomienda pedido4 = new PedidoEncomienda("PEDIDO ENCOMIENDA", 104, "Valija 10kg.", new DireccionEntrega(758, "Las mariposas", "La Serena"), 25, true, PrioridadPedido.BAJA);
        pedido4.mostrarResumen();

        System.out.println("\n----------------------------");

        PedidoComida pedido5 = new PedidoComida("PEDIDO COMIDA", 105, "McDonald's.", new DireccionEntrega(768, "Los rosales", "Rancagua"), 5, true, PrioridadPedido.MEDIA);
        pedido5.mostrarResumen();

        System.out.println("\n----------------------------");

        PedidoExpress pedido6 = new PedidoExpress("PEDIDO EXPRESS", 106, "Paquete.", new DireccionEntrega(475, "Los zorzales", "Coquimbo"), 3, true, PrioridadPedido.ALTA);
        pedido6.mostrarResumen();

        //REGISTRO DE PEDIDO
        System.out.println("\n--- REGISTRO DE PEDIDOS ---");
        controlador.registrarPedido(pedido1);
        controlador.registrarPedido(pedido2);
        controlador.registrarPedido(pedido3);
        controlador.registrarPedido(pedido4);
        controlador.registrarPedido(pedido5);
        controlador.registrarPedido(pedido6);

        //CANCELACIÓN DE PEDIDOS
        System.out.println("\n--- PEDIDOS CANCELADOS ---");
        controlador.cancelarPedido(pedido2);

        //SEGUIMIENTO DE PEDIDOS
        System.out.println("\n--- SEGUIMIENTO DE PEDIDOS ---");

        Repartidor repartidor1 = new Repartidor("Isidora López");
        Repartidor repartidor2 = new Repartidor("Roberto Labra");
        Repartidor repartidor3 = new Repartidor("Martina Donaire");

        repartidor1.agregarPedido(pedido1);
        repartidor2.agregarPedido(pedido2);
        repartidor3.agregarPedido(pedido3);
        repartidor1.agregarPedido(pedido4);
        repartidor2.agregarPedido(pedido5);
        repartidor3.agregarPedido(pedido6);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(repartidor1);
        executor.execute(repartidor2);
        executor.execute(repartidor3);

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        //HISTORIAL DE PEDIDOS
        System.out.println("\n--- HISTORIAL DE PEDIDOS ---");
        controlador.verHistorial();

        System.out.println("\n======================" +
                "\n---FIN DEL PROGRAMA---" +
                "\n======================");
    }
}



