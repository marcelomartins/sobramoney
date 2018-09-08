package sobramoney

import grails.rest.*
import grails.converters.*

class RegistrosController {
	static responseFormats = ['json', 'xml']
	
    def index() {

        def registros = Registro.findAll()

        //registros.sort { Registro r1, Registro r2 -> r1.dataInicial.getDayOfMonth() < r1.dataInicial.getDayOfMonth()}

        render registros as JSON
    }
}
