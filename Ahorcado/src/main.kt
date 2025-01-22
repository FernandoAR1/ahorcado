import kotlin.random.Random

fun main() {
    val randomWords = listOf(
        "manzana", "libro", "pelota", "gato", "elefante", "bicicleta", "computadora", "sol", "luna", "estrella",
        "cielo", "planta", "agua", "flor", "carro", "avion", "montana", "rio", "viento", "cielo",
        "nube", "cielo", "lago", "mar", "playa", "puente", "ciudad", "coche", "tren", "avion",
        "tren", "fuego", "luz", "sombra", "cielo", "tierra", "piedra", "espejo", "puerta", "ventana",
        "luna", "sol", "universo", "astronauta", "tecnologia", "coche", "pelicula", "television", "radio",
        "espejo", "clavo", "lapiz", "mesa", "silla", "rojo", "azul", "verde", "amarillo", "blanco",
        "negro", "gris", "morado", "rosado", "naranja", "rubio", "castano", "pelirrojo", "ojos",
        "boca", "nariz", "oreja", "dedo", "pie", "mano", "brazo", "cabeza", "corazon", "estomago",
        "cerebro", "hombro", "rodilla", "dedo", "uvas", "cereza", "manzana", "platano", "fresa",
        "sandia", "pina", "nuez", "almendra", "castana", "lenteja", "frijol", "garbanzo", "maiz",
        "arroz", "pasta", "pan", "manteca", "aceite", "sopa", "ensalada", "pollo", "carne", "pescado",
        "huevo", "queso", "leche", "yogur", "pan", "hamburguesa", "pizza", "taco", "pasta", "tortilla"
    )
    val rm = ReproductorMidi("pugnodollari.mid")
    println("Cargando juego...")
    Thread.sleep(20000)
    rm.cerrar()
    // Choose a random word from the list
    val numerorandom = Random.nextInt(0, randomWords.size)
    var palabra = randomWords[numerorandom]

    // Create an initial display word with underscores
    var palabraOculta = "_".repeat(palabra.length)  // Create underscores matching the length of the word

    // Initialize number of incorrect attempts
    var i = 1
    DibujoAhorcado.dibujar(1)

    // Display the initial state of the game
    println("Palabra a jugar: $palabraOculta")
    println("Dime una letra: ")

    // Start the game loop
    while (i <= 6) {
        val letra = readln()

        // Check if the letter is part of the word
        if (palabra.contains(letra)) {
            // Use the for loop to reveal the correct letters
            val newPalabraOculta = StringBuilder()

            for (index in palabra.indices) {
                if (palabra[index].toString() == letra) {
                    newPalabraOculta.append(palabra[index])  // Add the correct letter
                } else {
                    newPalabraOculta.append(palabraOculta[index])  // Keep the existing letter (or underscore)
                }
            }

            // Update palabraOculta with the new state
            palabraOculta = newPalabraOculta.toString()

            // Print the updated word with the guessed letters revealed
            println("Palabra actual: $palabraOculta")

            // Check if the player has guessed the entire word
            if (palabraOculta == palabra) {
                println("¡Ganaste!")
                break
            }
        } else {
            println("No, la letra no está en la palabra.")
            i++
            DibujoAhorcado.dibujar(i)  // Update the hangman drawing
        }

        // Check if the player has run out of attempts
        if (i == 7) {
            println("Perdiste! La palabra era: $palabra")
            break
        }

        // Prompt for the next letter
        if (i < 7) {
            println("Dime una letra: ")
        }
    }
}
