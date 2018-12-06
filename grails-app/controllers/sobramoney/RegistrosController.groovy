package sobramoney

import grails.rest.*
import grails.converters.*

class RegistrosController {
	static responseFormats = ['json', 'xml']
	
    def index() {

        def registros = Registro.findAll()

        registros.sort { it.dataInicial.getDayOfMonth() }

        render registros as JSON
    }


    def save(Registro registro) {
        println(registro)
        registro.dataFinal = registro.dataInicial
        registro.grupo = Grupo.get(1)
        registro.save(flush: true)

        return false;
    }
}
