
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.nio.file.Paths
import kotlin.io.path.Path

fun main(args: Array<String>) {


    //según he entendido el ejercicio
    /**
     * Azahara Blanco Rodríguez
     *
     * Ejercicio resuelto
     *
     * devemos de ejecutar un archivo jar, y leer en la salida
     * cuantos de esos mensajes es darth Vader y cuantos comienzan por Darth
     *
     */
    println("comunicaciones con la nave imperial para ver el lado oscuro")
    val numeroDeMensajesACaptar = 10
    val path = Paths.get("").toAbsolutePath()
    val carpetaPath = "jar" + File.separator + "mensajes.jar " + numeroDeMensajesACaptar
    var comand = "java -jar " + path + File.separator + carpetaPath



    //ejecutar el proceso mensaje jar
    var procesBuilder = ProcessBuilder()
    var process = procesBuilder.command("bash","-c", comand)    //aqui faltaba poner -c

    println("bash" + " " + comand)

    val result = process.start()

    //leer jar
    val reader = BufferedReader(InputStreamReader(result.inputStream))
    result.waitFor()
    println(result)

    var lineas = ArrayList<String>()

    var linea: String? = reader.readLine()
    while (linea != null) {
        lineas.add(linea)
        println(linea)
        linea = reader.readLine()
    }

    var darthNumbre = lineas.stream().filter{x -> x.toString().startsWith("Darth")}.count()
    println("hay  $darthNumbre Daths ")

    var countDV = lineas.stream().filter{x -> x.toString().equals("Darth Vader")}.count()
    if (countDV == 0L){
        println("no esta presente Darth Vader")
    }else{
        println("esta presente Darth Vader : $countDV")
    }

}









