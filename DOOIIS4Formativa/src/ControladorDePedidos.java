import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Clase que controla el sistema de envíos, implementando la interfaz Rastreable que hace posible la visualización del historial de pedidos.
 */

public class ControladorDePedidos implements Rastreable {

    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private PriorityBlockingQueue<Pedido> colaPedidos = new PriorityBlockingQueue<>();

    public ControladorDePedidos() {
        pedidos = new ArrayList<>();
    }

    //Metodo que registra el pedido
    public void registrarPedido(Registrable pedido) {
        Pedido nuevoPedido = (Pedido) pedido;
        pedidos.add(nuevoPedido);
        colaPedidos.put(nuevoPedido);
        pedido.registrar();
        System.out.println("Pedido registrado");
    }

    //Metodo que cancela el pedido
    public void cancelarPedido(Cancelable pedido) {
        pedido.cancelar();
        System.out.println("Pedido cancelado.");
    }

    public Pedido tomarPedido() throws InterruptedException {
        return colaPedidos.take();
    }

    //Metodo que despacha el pedido
    public void despacharPedido(Despachable pedido) {
        pedido.despachar();
        System.out.println("Pedido enviado.");
    }

    //Metodo para ver historial
    @Override
    public void verHistorial() {

        int pedidosDespachados = 0;

        List<Pedido> ordenados = new ArrayList<>(pedidos);
        Collections.sort(ordenados);

        for (Pedido pedido : ordenados) {
            System.out.println("N° " + pedido.getIdPedido() + "| " + pedido.getTipoPedido() + "|" + pedido.getDireccionEntrega() + "| " + pedido.getDistanciaKm() + "| " + pedido.getEstadoPedido() + "| " + pedido.calcularTiempoEntrega() + "min.");

            if (pedido.getEstadoPedido().equals("DESPACHADO")) {
                pedidosDespachados++;
            }
        }

        if (pedidosDespachados == 0) {
            System.out.println("\nAún no hay pedidos despachados.");
        } else {
            System.out.println("\nTotal de pedidos despachados: " + pedidosDespachados);
        }

        if (pedidos.isEmpty()) {
            System.out.println("Aún no hay pedidos registrados.");
            return;
        }
    }
}