import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa un repartidor.
 */

public class Repartidor implements Runnable {

    private String nombreRepartidor;
    private final List<Pedido> pedidos;
    private final Random random = new Random();

    /**
     * Constructor de la clase Repartidor.
     *
     * @param nombreRepartidor Nombre del repartidor.
     */
    public Repartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
        this.pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    //Metodo getter.
    public String getNombreRepartidor() {
        return nombreRepartidor;
    }

    //Metodo setter.
    public void setNombreRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }

    /**
     * Metodo run()
     */
    @Override
    public void run() {
        for (Pedido pedido : pedidos) {
            try {
                System.out.println("[Repartidor/a: " + nombreRepartidor + "] Entregando " + pedido.getClass().getSimpleName() + " #" + pedido.getIdPedido() + "...");

                pedido.asignarRepartidor(nombreRepartidor);

                //Simulación de tiempo que podría tardar un repartidor
                Thread.sleep(1000 + random.nextInt(1000));

                if (pedido instanceof Despachable despachable) {
                    despachable.despachar();
                }

                System.out.println("[Repartidor/a: " + nombreRepartidor + "] Pedido #" + pedido.getIdPedido() + " entregado.");

            } catch (IllegalStateException e) {
                System.out.println("[Repartidor/a: " + nombreRepartidor + "] Pedido #" + pedido.getIdPedido() + " no pudo entregarse: " + e.getMessage());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[Repartidor/a: " + nombreRepartidor + "] fue interrumpido.");
                return;
            }
        }
        System.out.println("[Repartidor/a: " + nombreRepartidor + "] terminó su ruta de reparto.");
    }
}
