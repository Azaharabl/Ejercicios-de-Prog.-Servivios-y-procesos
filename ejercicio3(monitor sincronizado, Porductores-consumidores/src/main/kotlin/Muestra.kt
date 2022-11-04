import java.time.LocalDateTime
import java.util.*
import kotlin.random.Random

class Muestra (
    var identificador: String = UUID.randomUUID().toString(),
    var puerza: Int = Random.nextInt(10,80),
    var fecha: String = LocalDateTime.now().toString()
){
    override fun toString(): String {
        return "Muestra(identificador='$identificador', puerza=$puerza, fecha='$fecha')"
    }
}