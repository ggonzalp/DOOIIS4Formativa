# SpeedFast

La actividad formativa de esta semana consiste en robustecer el sistema que ya se venía trabajando, para desarrollar un 
sistema orientado a objetos que represente diversos actores realizando tareas concurrentes, con el objetivo de simular 
un entorno multitarea realista

# Descripción

SpeedFast posee (por ahora) tres repartidores entre los cuales deben dividirse la cantidad de pedidos a entregar, 
considerando que cada uno de ellos puede tener una prioridad alta, media o baja en función del tipo de pedido que es.






semana 4/
└── src/
    ├── Pedido.java                 Clase abstracta: atributos y comportamiento común
    ├── PedidoComida.java           Subclase: valida mochila térmica
    ├── PedidoEncomienda.java       Subclase: valida peso y embalaje
    ├── PedidoExpress.java          Subclase: valida cercanía del repartidor
    ├── DireccionEntrega.java       Dirección de entrega (número, calle, ciudad)
    ├── PrioridadPedido.java        Enumeración: ALTA, MEDIA, BAJA
    ├── Repartidor.java             Tarea ejecutable: recorre su ruta y entrega
    ├── ControladorDePedidos.java   Registra los pedidos y muestra el historial
    ├── Registrable.java            Interfaz: registrar()
    ├── Cancelable.java             Interfaz: cancelar()
    ├── Despachable.java            Interfaz: despachar()
    ├── Rastreable.java             Interfaz: verHistorial()
    └── Main.java                   Clase principal con la simulación
```
