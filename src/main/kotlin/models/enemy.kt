package srangeldev.models

/**
 * Representa un enemigo en la batalla.
 *
 * @property maxEnergy Energía máxima.
 * @property type Tipo de enemigo.
 */
abstract class Enemy(
    var maxEnergy: Int,
    val color: String
) {


    companion object {
        fun random(): Enemy {
            val random = (1..100).random()
            return when {
                random <= 40 -> Inferi1()
                random <= 70 -> Inferi2()
                else -> Mortifago()
            }
        }
    }

    val isAlive: Boolean
        get() = maxEnergy > 0

    override fun toString(): String {
        return "Enemigo(Energía Máxima=$maxEnergy)"
    }
}
