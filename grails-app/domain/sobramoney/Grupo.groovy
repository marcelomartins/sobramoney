package sobramoney

class Grupo {

    String tipo
    String nome

    static constraints = {
        nome(maxSize: 40)
    }
}
