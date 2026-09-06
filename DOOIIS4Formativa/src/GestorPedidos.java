import java.util.concurrent.PriorityBlockingQueue;

/**
 * Clase que se encarga de vincular
 */

public class GestorPedidos {

    private final PriorityBlockingQueue<Pedido> colaPedidos = new PriorityBlockingQueue<>();

    public void agregarPedido(Pedido pedido) {
        colaPedidos.put(pedido);
    }

    public Pedido tomarPedido() throws InterruptedException {
        return colaPedidos.take();
    }
}
