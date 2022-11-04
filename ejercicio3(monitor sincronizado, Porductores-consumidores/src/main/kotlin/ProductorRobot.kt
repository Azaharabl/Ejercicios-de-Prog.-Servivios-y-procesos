class ProductorRobot(var nombre: String = "robot",m : Monitor, var muestrasAAnalizar : Int = 10) : Runnable{
    var m = m
    /**
     * Nuestro productor que extiende de runable, enciará muestras al servidor,
     * le pasamos el servidor que es el monitor para que pueda proteger la sección crítica
     */


    override fun run() {
        println("soy $nombre y como soy productor cada 1,5 seg analizo y envio una muestra," +
                "tengo especificado un total de $muestrasAAnalizar numero de muestars a analizar")

        for(i in 0..muestrasAAnalizar){
            //hace lo que sea y manda muetras
            Thread.sleep(1500)
            var muestra = Muestra()
            m.add(muestra)
            println("soy $nombre y muestra enviada n $i es ${muestra.toString()}")
        }
    }


}