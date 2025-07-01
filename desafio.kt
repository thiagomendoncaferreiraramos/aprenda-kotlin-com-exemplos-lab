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

    private val inscritos = mutableListOf<Aluno>()
    val professores = mutableListOf<Professor>()

    override fun toString(): String {
        val conteudosStr = conteudos.joinToString(separator = "\n") { it.toString() }
        val professoresStr = professores.joinToString(separator = "\n") { "\t${it.nome}" }
        return "Formação: $nome\nConteúdos:\n$conteudosStr\nPorfessores:\n$professoresStr\nTotal de inscritos: ${inscritos.size}\n"
    }
    
    fun matricular(vararg aluno: Aluno) {
        for (a in aluno) {
            println("Matriculando ${a.nome} na formação $nome")
            inscritos.add(a)
        }
        
    }

    fun desmatricular(vararg aluno: Aluno) {
        for (a in aluno) {
            println("Desmatriculando ${a.nome} da formação $nome")
            inscritos.remove(a)
        }
    }

    fun listarInscritos() {
        if (inscritos.isEmpty()) {
            println("Nenhum aluno matriculado na formação $nome.")
        } else {
            println("Alunos matriculados na formação $nome:")
            inscritos.forEach { println("\t${it.nome}") }
        }
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
    val carlos = Professor("Dr. Carlos Pereira", "cpereira@dio.me")
    val mariaS = Professor("Dra. Maria Souza", "msouza@dio.me")
    val james = Professor("Dr. James Smith", "jsmith@dio.me")
    val charles = Professor("Dr. Charles Xavier", "cxavier@dio.me")

    println()
    

    mfes.professores.addAll(listOf(carlos, mariaS, james, charles))
    print(mfes)

    val joao = Aluno("João Silva", "js@qualquermail.com")
    val mariaO = Aluno("Maria Oliveira", "mo@coolmail.com")
    val jamesT = Aluno("James Torrada", "torradao@mit.com")
    val godofredo = Aluno("Godofredo Epaminondas", "gd@bobinhos.com")
    val paulo = Aluno("Paulo Otário", "po@po.com")
    val carla = Aluno("Carla Carvalho", "carvalho@gemail.com")
    val marcos = Aluno("Marcos Garrido", "varrevarre@ola.com")

    println()
    mfes.matricular(joao, mariaO, jamesT)
    println()
    mfes.listarInscritos()
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
