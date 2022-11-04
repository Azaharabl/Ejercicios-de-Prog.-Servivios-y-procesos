class PersonaConsumidor(var nombre: String = "leya" , monitor: Monitor, var muestrasARecojer: Int = 5) : Runnable {

    // AzaharaBlanco Rodríguez
    // esto es un consumidor que usa el monitor para
    // cojer informacion del buffer y proteger así al sección crítica
    var m  = monitor
    var muestrasPuras = ArrayList<Muestra>()
    override fun run() {

        println("soy $nombre y como consumidor cada 2 seg recojo y " +
                "analizo una muestra en total necesito $muestrasARecojer")
        while (muestrasPuras.size<muestrasARecojer){
            //hace lo que sea recolecta
            Thread.sleep(2000)
            var muestra  = m.get()
            println("soy $nombre y he consumido una muestra ahora la analizo ")
            if(muestra.puerza >50){
                println("soy $nombre con la muestra $muestra y como la muestra es pura me la quedo")
                muestrasPuras.add(muestra)
            }else{
                println("soy $nombre con la muestra $muestra y como la muestra no el lo suficientemente" +
                        " pura no me la quedo")
            }
            println("por el momento las muestras buenas son ${muestrasPuras.size}")
        }

    }
}