import java.util.concurrent.Executors

fun main(args: Array<String>) {
    println("minerales")
    /**
     * Azahara Blanco Rodriguez
     *

     para realizar este ejercicio necesitamos distintas cosas o pasos

     1.porblema de productores consuimidores

         productores (los robots producen resultados de muestras a un repositorio "buffer de memoria
            limitada de 8 donde se puenen almacenar)

         repositorio (el buffer de memoria limitada 8 donde almacenan las pruebas)

         consumidores (Luke y Leya que cada cierto tiempo recogen esos datos)

     Por lo que hay que crear clases muestra, robot(productor) personajes(consumidor)
    y servidor(que va a ser un monitor)

     En el motitor haremos sus metodos Sicronizados para proteger la seción crítica.

     */
    var poll = Executors.newFixedThreadPool(3)

    var monitor = Monitor()
    var robot1 = ProductorRobot("Bb8",monitor)
    var robot2 = ProductorRobot("R2d2",monitor)

    var leya = PersonaConsumidor("Leya",monitor)
    var luke = PersonaConsumidor("Luke",monitor)

    var lista = listOf<Runnable>(robot1, robot2, leya, luke)

    lista.forEach{poll.submit(it)}

    poll.shutdownNow()










}



