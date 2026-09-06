# SpeedFast

La actividad formativa de esta semana consiste en robustecer el sistema que ya se venía trabajando, para desarrollar un 
sistema orientado a objetos que represente diversos actores realizando tareas concurrentes, con el objetivo de simular 
un entorno multitarea realista

# Descripción

SpeedFast posee (por ahora) tres repartidores entre los cuales deben dividirse la cantidad de pedidos a entregar, considerando que cada uno de ellos puede tener una prioridad (alta, media o baja) que determina el orden en que se imprimirán al final.

Para que los tres repartidores trabajen simultáneamente se utilizan dos mecanismos de
concurrencia: Interfaz Runnable y ExecutorService.

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


#Ejecución 

1° Clonar el repositorio: https://github.com/ggonzalp/DOOIIS4Formativa.git

2° Abrir el proyecto en IntelliJ IDEA

3° Ejecutar la clase principal: src/ui/Main.java

4° El programa cargará automáticamente los datos ingresados de forma local y manual.

Autoría Estudiante: Gabriela González Peirano 
Asignatura: Desarrollo Orientado a Objetos II 
Instituto: DuocUC
