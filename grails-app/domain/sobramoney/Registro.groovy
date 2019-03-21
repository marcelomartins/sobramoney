package sobramoney

import org.joda.time.LocalDate

class Registro {

    String descricao
    Double valor
    LocalDate dataInicial
    LocalDate dataFinal

    Grupo grupo
    Usuario usuario


    static constraints = {
        descricao(maxSize: 80)
    }

    def String toString() {
        return "${descricao} - ${dataInicial} - ${dataFinal} -  ${valor}"
    }

}
