package srangeldev.models

import srangeldev.models.Enemy

class Inferi1(
    maxEnergy: Int = 50,
    color: String = "[💚]"
) : Enemy(maxEnergy, color){

    val isAvailable: Boolean
        get() = maxEnergy >0

    override fun toString(): String {
        return "Inferi1(maxEnergy=$maxEnergy)"
    }
}