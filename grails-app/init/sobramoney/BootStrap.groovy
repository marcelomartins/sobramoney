package sobramoney

import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        JSON.registerObjectMarshaller(Registro) { registro ->
            def result = [:]
            result['id'] = registro.id
            result['descricao'] = registro.descricao
            result['valor'] = registro.valor
            result['grupo'] = registro.grupo
            result['pago'] = false
            result['soma'] = true
            result['dia'] = registro.dataInicial.toString("dd")
            result['dataInicial'] = registro.dataInicial.toString("dd/MM/yyyy")
            result['dataFinal'] = registro.dataFinal.toString("dd/MM/yyyy")
            return result
        }
    }
    def destroy = {
    }
}
