package srangeldev.models

import kotlin.system.exitProcess

/**
 * Configuración para la simulación.
 *
 * @property mapSize Tamaño del mapa.
 * @property numberOfEnemies Número de enemigos.
 * @property time Tiempo límite de la simulación.
 */
class Configuration private constructor(
    val mapSize: Int = 5,
    val numberOfEnemies: Int = 10,
    val time: Int = 15
) {

    companion object {
        fun fromArgs(args: Array<String>): Configuration {
            if (args.size != 3) {
                showErrorMessage()
            }

            val mapSize = args[0].toIntOrNull() ?: -1
            val numberOfEnemies = args[1].toIntOrNull() ?: -1
            val time = args[2].toIntOrNull() ?: -1

            if (mapSize !in 5..10 || numberOfEnemies !in 15..25 || time !in 1..15) {
                showErrorMessage()
            }

            return Configuration(mapSize, numberOfEnemies, time)
        }

        private fun showErrorMessage() {
            println("Argumentos inválidos.")
            println("Uso: java -jar defensaHowarts.jar <mapSize> <numberOfEnemies> <time>")
            println("Ejemplo: java -jar defensaHowarts.jar 7 20 10")
            exitProcess(-1)
        }
    }
}
