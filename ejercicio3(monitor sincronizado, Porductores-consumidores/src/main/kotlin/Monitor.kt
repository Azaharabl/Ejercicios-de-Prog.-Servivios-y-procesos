class Monitor(val max : Int = 8, var cantidad : Int = 0) {

    var  servidor = ArrayList<Muestra>();
    val lock = java.lang.Object()


    /**
     * metodo que protege la seción ritica y comprueva que el bufer no este vacio al hacer un get
     * @return
     */
     fun  get (): Muestra = synchronized(lock){
        while (cantidad<1){
            try{
                lock.wait();
            }catch (e: Exception){
                e.printStackTrace();
            }

        }
        var muestra = servidor.get(0);
        cantidad--;
        servidor.removeAt(0);
        lock.notifyAll()
        return muestra;
    }

    /**
     * metodo que protege la seción ritica y comprueva que el bufer no este lleno al hacer un add
     * @return
     */
   fun add( muestra: Muestra) = synchronized(lock){
        while (cantidad >=8) {
            try {
                lock.wait();
            } catch (e:Exception) {
                e.printStackTrace()
            }
        }
        servidor.add(muestra);
        cantidad++;
        lock.notifyAll();

    }
}