package srangeldev


import srangeldev.controllers.SpellCaster
import srangeldev.models.Configuration

/**
 * Simulación de defensa de Hogwarts.
 * Inicializa la configuración, crea un SpellCaster y ejecuta la simulación.
 *
 * @param args Argumentos de línea de comandos.
 */
fun main(args: Array<String>) {
    println("Harry Potter: Defensa de Hogwarts")
    println("¡La magia más poderosa está en tu mente!")
    println()
    val config = Configuration.fromArgs(args)
    val caster = SpellCaster(config.mapSize, config.numberOfEnemies, config.time)
    caster.simulate()
    println()
    caster.printReport()
}
