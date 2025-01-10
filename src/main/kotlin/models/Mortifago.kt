package srangeldev.models

class Mortifago(
    maxEnergy: Int = (100..150).random(),
    color: String = "[🖤]"
): Enemy(maxEnergy, color) {
    val isAvailable: Boolean
        get() = maxEnergy >0

    override fun toString(): String {
        return "Mortifago(maxEnergy=$maxEnergy)"
    }
}