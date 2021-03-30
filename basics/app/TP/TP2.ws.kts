/**
 * TP2
 * Créer une classe Etudiant (name, code, sexe, adresse, age)
 */
enum class Sex(val sex: String) {

}

class Etudiant (
    name: String,
    code: Int,
    sexe: String,
    adresse: String,
    age: Int
)

val etudiants = mutableListOf<Etudiant>()
etudiants.add(Etudiant("Anthony Kiedis", i, "M", "Angers", 24))
etudiants.add(Etudiant("Mireille Sansouci", i, "F", "Angers", 24))


println(etudiants)