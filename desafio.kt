// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, ARROJADO }

abstract class Usuario(val nome: String, val email: String)

class Aluno(nome: String, email: String) : Usuario(nome, email) 
class Professor(nome: String, email: String) : Usuario(nome, email)

data class ConteudoEducacional(val nome: String, val nivel: Nivel, val duracao: Int = 60){
    override fun toString(): String {
        return "\tConteúdo: $nome, Nível: $nivel, Duração: $duracao minutos"
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Aluno>()

    override fun toString(): String {
        val conteudosStr = conteudos.joinToString(separator = "\n") { it.toString() }
        return "Formação: $nome\nConteúdos:\n$conteudosStr\nTotal de inscritos: ${inscritos.size}\n"
    }
    
    fun matricular(aluno: Aluno) {
        println("Matriculando ${aluno.nome} na formação $nome")
        inscritos.add(aluno)
    }
}

fun main() {
    println("Iniciando")
    val mfes = Formacao("Métodos Formais em Engenharia de Sofware", listOf(
        ConteudoEducacional("Introdução aos Métodos Formais", Nivel.BASICO, 120),
        ConteudoEducacional("Lógica Matemática", Nivel.INTERMEDIARIO, 120),
        ConteudoEducacional("Teoria dos Conjuntos", Nivel.INTERMEDIARIO, 120),
        ConteudoEducacional("Autômatos e Linguagens Formais", Nivel.INTERMEDIARIO, 300),
        ConteudoEducacional("Modelagem Formal de Sistemas", Nivel.ARROJADO, 300),
        ConteudoEducacional("Verificação Formal de Sistemas", Nivel.ARROJADO, 300),
        ConteudoEducacional("Projeto e Formalização de Linguagens", Nivel.ARROJADO, 300)
    ))

    println(mfes)
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
