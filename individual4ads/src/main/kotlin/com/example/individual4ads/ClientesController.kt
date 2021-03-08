package com.example.individual4ads

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/clientes")
class ClientesController {

    var lista = mutableListOf<Clientes>()

    @GetMapping
    fun getall() : List<Clientes>{
        return lista
    }

    @GetMapping("/{id}")
    fun getId(@PathVariable id : Int) : Clientes? {
        val identity = id-1

        if (identity > lista.size){
            return null
        } else {
            return lista.get(id - 1)
        }
    }

    @PostMapping
    fun cadastrar(@RequestBody cliente : Clientes) : MutableList<Clientes>{
        cliente.validar()
        lista.add(cliente)
        return lista
    }

    @DeleteMapping("/{id}")
    fun deleteId(@PathVariable id : Int) : String  {
        val identity = id-1

        if (identity > lista.size){
            return "Não encontrado"
        } else {
            lista.removeAt(id - 1)
            lista.removeAt(lista.size - 1)
            return "Excluido"
        }
    }

    @GetMapping("/mais-ricos")
    fun getRicos() : List<Clientes>{
        var retorno = lista.filter { it.renda > 15000 }
        return retorno
    }

}