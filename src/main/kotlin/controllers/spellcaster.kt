package srangeldev.controllers

import com.github.ajalt.mordant.rendering.TextColors
//import org.lighthousegames.logging.logging
import srangeldev.models.Enemy
import kotlin.math.min
import kotlin.math.round

typealias color = TextColors

/**
 * Clase que representa el sistema de defensa mágica de Hogwarts.
 *
 * @property mapSize Tamaño del mapa.
 * @property numberOfEnemies Número de enemigos.
 * @property timeMax Tiempo máximo de la simulación.
 */
class SpellCaster(
    private val mapSize: Int,
    private val numberOfEnemies: Int,
    private val timeMax: Int,
) {
    //private val logger = logging()

    private val map = Array(mapSize) { arrayOfNulls<Enemy>(mapSize) }
    private val enemies = Array(numberOfEnemies) { Enemy.random() }
    private var numberOfShots = 0
    private var numberOfHits = 0
    private val leftEnemies: Int
        get() = numberOfEnemies - deadEnemies

    private val deadEnemies: Int
        get() = getTotalDeadEnemies()

    /**
     * Funcion para obtener el total de enemigos muertos.
     *
     * @return Numero de enemigos muertos.
     */
    private fun getTotalDeadEnemies(): Int {
        //logger.debug{"Obteniendo numero de enemigos total"}
        var counter = 0
        for (enemy in enemies) {
            if (!enemy.isAlive) {
                counter++
            }
        }
        return counter
    }

    /**
     * Funcion para comenzar la simulacion
     *
     * @see placeEnemies
     * @see printMap
     * @see castSpell
     */
    fun simulate() {
        println(color.red("-- QUE COMIENZE LA GUERRA!! --"))
        //logger.debug{"Comienza la simulacion"}
        var time = 0
        placeEnemies()
        printMap()

        do {
            println(color.green("Tiempo: $time ms"))
            println(color.yellow("Enemigos restantes: $leftEnemies"))

            if (time % 500 == 0) {
                //logger.debug {"Colocando enemigos cada 500 ms"}
                placeEnemies()
                println(color.magenta("Los enemigos se mueven!"))
            }

            castSpell()
            printMap()
            Thread.sleep(100)
            time += 100
        } while (time < timeMax * 1000 && leftEnemies > 0)
    }

    /**
     * Funcion para lanzar el hechizo de ataque
     */
    private fun castSpell() {
        //logger.debug { "Lanzando hechizo" }
        val row = (0 until mapSize).random()
        val col = (0 until mapSize).random()
        numberOfShots++

        val enemy = map[row][col]
        if (enemy != null) {
            val damage = calculateDamage()
            println(color.cyan("¡Hechizo impactado en $enemy con daño de $damage puntos!"))
            numberOfHits++
            enemy.maxEnergy -= damage
            if (!enemy.isAlive) {
                println(color.red("$enemy ha sido derrotado."))
            }
        } else {
            println(color.white("¡Hechizo fallado!"))
        }
    }

    /**
     * Funcion para calcular el daño del hechizo.
     * @return La cantidad de daño infligida.
     */
    private fun calculateDamage(): Int {
        return if ((1..100).random() <= 20) {
            println(color.red("Hechizo crítico: Expulso!"))
            50
        } else {
            println(color.blue("Hechizo básico: Stupefy"))
            25
        }
    }


    private fun placeEnemies() {
        //logger.debug{"Colocando enemigos en el mapa"}
        val tempMap = Array(mapSize) { arrayOfNulls<Enemy>(mapSize) }

        val maxEnemiesToStore = min(mapSize * mapSize, leftEnemies)
        var storedEnemies = 0
        var enemiesIndex = 0
        while (storedEnemies < maxEnemiesToStore) {
            while (enemiesIndex < enemies.size && !enemies[enemiesIndex].isAlive) {
                enemiesIndex++
            }
            var isStored = false
            do {
                val row = (0 until mapSize).random()
                val col = (0 until mapSize).random()
                if (tempMap[row][col] == null) {
                    tempMap[row][col] = enemies[enemiesIndex]
                    storedEnemies++
                    isStored = true
                    enemiesIndex++
                }
            } while (!isStored)
        }

        // Pasar los enemigos del tempMap al mapa
        for (row in 0 until mapSize) {
            for (col in 0 until mapSize) {
                map[row][col] = tempMap[row][col]
            }
        }
    }


    fun printReport() {
        //logger.debug {"Imprimiendo informe de batalla"}
        println(color.brightYellow("\n--- Informe de la Batalla ---"))
        println(color.cyan("Total disparos: $numberOfShots"))
        println(color.green("Impactos: $numberOfHits"))
        println(color.yellow("Enemigos restantes: $leftEnemies "))
        println(color.red("Enemigos muertos: $deadEnemies"))
        println(color.blue("Precisión: ${round(numberOfHits.toDouble() / numberOfShots * 100)}%"))
        orderEnemies()
        println()
        println(color.brightMagenta("Mostrando todos los enemigos, ordenados por energía de mayor a menor:"))
        println()
        for ((index, enemy) in enemies.withIndex()) {
            println(color.magenta("Enemigo ${index + 1}: $enemy"))
        }
        println()
    }

    private fun orderEnemies() {
        //logger.debug {"Ordenar enemigos"}
        for (i in 0 until enemies.size) {
            for (j in 0 until enemies.size - i - 1) {
                if (j + 1 < enemies.size && enemies[j].maxEnergy < enemies[j + 1].maxEnergy) {
                    val temp = enemies[j]
                    enemies[j] = enemies[j + 1]
                    enemies[j + 1] = temp
                }
            }
        }
    }

    private fun printMap() {
        //logger.debug {"Imprimiendo mapa"}
        for (row in map) {
            for (enemy in row) {
                if (enemy == null) {
                    print("[ ]")
                } else {
                    print(enemy.color)
                }
            }
            println()
        }
    }
}
