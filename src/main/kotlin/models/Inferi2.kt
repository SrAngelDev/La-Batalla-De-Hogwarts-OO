package srangeldev.models

class Inferi2(
    maxEnergy: Int = 50,
    color: String = "[💛]"
): Enemy(maxEnergy, color) {

    val isAvailable: Boolean
        get() = maxEnergy >0

    override fun toString(): String {
        return "Inferi2(maxEnergy=$maxEnergy)"
    }
}