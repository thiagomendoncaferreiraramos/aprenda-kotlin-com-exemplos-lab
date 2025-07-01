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

    println()
    mfes.desmatricular(joao)
    mfes.desmatricular(paulo)
    println()
    mfes.listarInscritos()

    val lp = Formacao("Linguagens de Programação", listOf(
        ConteudoEducacional("Introdução às Linguagens de Programação", Nivel.BASICO, 120),
        ConteudoEducacional("Paradigmas de Programação", Nivel.INTERMEDIARIO, 120),
        ConteudoEducacional("Programação Funcional", Nivel.ARROJADO, 300),
        ConteudoEducacional("Programação Orientada a Objetos", Nivel.ARROJADO, 300),
        ConteudoEducacional("Programação Procedural", Nivel.ARROJADO, 300),
        ConteudoEducacional("Programação Lógica", Nivel.ARROJADO, 300))
    )

    lp.professores.addAll(listOf(carlos))

    val IA = Formacao("Inteligência Artificial", listOf(
        ConteudoEducacional("Introdução à Inteligência Artificial", Nivel.BASICO, 120),
        ConteudoEducacional("Aprendizado de Máquina", Nivel.INTERMEDIARIO, 120),
        ConteudoEducacional("Redes Neurais", Nivel.ARROJADO, 300),
        ConteudoEducacional("Processamento de Linguagem Natural", Nivel.ARROJADO, 300),
        ConteudoEducacional("Visão Computacional", Nivel.ARROJADO, 300),
        ConteudoEducacional("Robótica", Nivel.ARROJADO, 300))
    )

    IA.professores.addAll(listOf(mariaS,james))

    println()
    lp.matricular(godofredo,carla)
    println(lp)
    println()
    IA.matricular(marcos, godofredo)
    println(IA)

}
