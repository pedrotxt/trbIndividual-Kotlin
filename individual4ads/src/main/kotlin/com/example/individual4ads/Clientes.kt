package com.example.individual4ads

import javax.lang.model.type.NullType

data class Clientes (val nome: String, val renda: Int, var classeSocial: String = "") {
    fun validar(): String{
            when (renda) {
            in 0..2900-> classeSocial = "Pobre"
            in 2901..11999 -> classeSocial = "Classe Média"
            else -> classeSocial = "Rico"
        }
        return "Cliente Cadastrado!"
    }

}