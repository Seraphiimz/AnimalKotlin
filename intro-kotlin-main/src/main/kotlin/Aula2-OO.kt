package br.ifpb.pdm

fun main() {
    val repositorioAnimal = RepositorioAnimal()
    var opcao = 0
    while (opcao != 12) {
        menu()
        print("Digite a opção: ")
        opcao = readlnOrNull()?.toInt() ?: 0
        when (opcao) {
            1 -> {
                println("Qual nome de cachorro? Digite aqui:")
                val nome = readLine().toString()
                println("Qual idade de cachorro? Digite aqui:")
                val idade = readLine()?.toIntOrNull() ?: 0
                val cachorro = Cachorro(idade, Cor.amarela)
                cachorro.nome = nome
                repositorioAnimal.adicionar(cachorro)
                println("Nome: $nome,Idade de Animal $idade, Idade na Anos Humanos: ${cachorro.idadeEmAnosHumanos()}, Cor de Animal: ${cachorro.cor.name}")
            }
            2 -> {
                println("Qual nome de Gato? Digite aqui:")
                val nome = readLine().toString()
                println("Qual idade de Gato? Digite aqui:")
                val idade = readLine()?.toIntOrNull()?:0
                val gato = Gato(idade, Cor.preta)
                gato.nome = nome
                repositorioAnimal.adicionar(gato)
                println("Nome: $nome,Idade de Animal $idade, Idade na Anos Humanos: ${gato.idadeEmAnosHumanos()}, Cor de Animal: ${gato.cor.name}")

            }
            3 -> {
                println("Qual nome de Passaro? Digite aqui:")
                val nome = readLine().toString()
                println("Qual idade de Passaro? Digite aqui:")
                val idade = readLine()?.toIntOrNull()?:0
                val passaro = Passaro(idade, Cor.vermelha)
                passaro.nome = nome
                repositorioAnimal.adicionar(passaro)
                println("Nome: $nome,Idade de Animal $idade, Idade na Anos Humanos: ${passaro.idadeEmAnosHumanos()}, Cor de Animal: ${passaro.cor.name}")
            }
            4 -> {
                println("Qual nome de Elefante? Digite aqui:")
                val nome = readLine().toString()
                println("Qual idade de Elefante? Digite aqui:")
                val idade = readLine()?.toIntOrNull()?:0
                val elefante = Elefante(idade, Cor.cinza)
                elefante.nome = nome
                repositorioAnimal.adicionar(elefante)
                println("Nome: $nome,Idade de Animal $idade, Idade na Anos Humanos: ${elefante.idadeEmAnosHumanos()}, , Cor de Animal: ${elefante.cor.name}")
            }
            5 -> {
                repositorioAnimal.listar()
            }
            6 ->{
                println("Digite qual cor que quer listar? Digite aqui:")
                val corListar = readLine()?.toString() ?: ""
                if (!corListar.isNullOrEmpty()){
                    repositorioAnimal.listarPorCor(corListar)
                } else{
                    println("cor nao existe...")
                }
            }
            7 ->{
                println("Digite qual idade que voce quer listar? Digite aqui:")
                val idadeListar = readLine()?.toIntOrNull() ?:0
                if (idadeListar != null){
                    repositorioAnimal.listarPorIdade(idadeListar)
                } else{
                    println("Nao foi achado a idade, tente novamente!")
                }
            }
            8 ->{
                println("Qual nome que voce quer buscar? Digite aqui:")
                val nomeBuscar = readLine().toString()
                val animalEncontrado = repositorioAnimal.buscarPorNome(nomeBuscar)
                if (animalEncontrado != null){
                    println("Animal encontrado:")
                    println("Nome: ${animalEncontrado.nome}, Idade em anos humanos: ${animalEncontrado.idadeEmAnosHumanos()}")
                } else {
                    println("O animal $nomeBuscar não foi encontrado, tente novamente!")
                }
            }
            9->{
                println("Qual nome dele? Digite aqui:")
                val nome = readLine()?.toString() ?: ""
                println("Qual idade de pessoa? Coloque aqui:")
                val idadePessoa = readLine()?.toIntOrNull()?:0
                println("Qual cor de roupa de pessoa? Digite aqui:")
                val corPessoa = readLine()?.let { Cor.valueOf(it) } ?: Cor.preta
                val pessoa = Homem(idadePessoa, corPessoa)
                println("Pessoa foi criada com sucesso!!")
                println("Nome: $nome, Idade: $idadePessoa, Cor: $corPessoa")
                repositorioAnimal.adicionar(pessoa)
            }
            10 -> {
                repositorioAnimal.animais.forEach(Animal::emitirSom)
                repositorioAnimal.animais.forEach { it.emitirSom()}
            }
            11 ->{
                println("Qual nome voce quer remover? Digite aqui:")
                val nomeRemovido = readLine().toString()
                val animalRemover = repositorioAnimal.remover(nomeRemovido)
                if(animalRemover != null){
                    println("O animal $nomeRemovido foi removido sucesso!")
                } else {
                    println("O animal $nomeRemovido não foi achado, digite novamente...")
                }
            }
        }
    }
}

enum class Cor {
    preta,
    amarela,
    vermelha,
    cinza,
    roxa,
    branco,
    bege,
    verde,
    azul,
    marrom,
    laranja
}

abstract class Animal(var idade: Int, var cor: Cor) {
    open var nome: String = ""
        get() = "$field"
        set(valor) {
            field = valor
        }

    abstract fun emitirSom() // Transformar a som na abstrato

    open fun idadeEmAnosHumanos(): Int{
        return idade * 7
    }
}

class Homem(idade: Int, cor:Cor) : Animal(idade, cor){
    override fun idadeEmAnosHumanos(): Int {
        return idade
    }

    override fun emitirSom() {
        println("Oxe, olá!")
    }
}

class Cachorro(idade: Int, cor: Cor) : Animal(idade, cor) {
    override var nome: String = ""
        get() = field
        set(valor) {
            field = valor
        }
    override fun emitirSom() {
        println("Au au")
    }
}
class Gato(idade: Int, cor: Cor) : Animal(idade, cor) {
    override fun emitirSom() {
        println("Miau")
    }
}

class Passaro(idade: Int, cor: Cor) : Animal(idade, cor) {
    override fun emitirSom() {
        println("Piu piu")
    }
}
class Elefante(idade: Int, cor: Cor) : Animal(idade, cor) {
    override fun emitirSom() {
        println("Fuummm Uuuuh")
    }
}

fun menu() {
    println("1 - Cachorro")
    println("2 - Gato")
    println("3 - Pássaro")
    println("4 - Elefante")
    println("5 - Listar Animais")
    println("6 - Listar por cor")
    println("7 - Listar por idade")
    println("8 - Buscar por nome")
    println("9 - Crie a seu humano")
    println("10 - Emitir som")
    println("11 - Remover Animal")
    println("12 - Sair")
}

class RepositorioAnimal {
    val animais: MutableList<Animal> = mutableListOf()

    fun adicionar(animal: Animal) {
        animais.add(animal)
    }
    fun remover(nome: String): Animal? {
        val animalRemover = animais.find { it.nome == nome }
        if (animalRemover != null){
            animais.remove(animalRemover)
        }
        return animalRemover
    }
    fun listarPorCor(cor: String){
        val animaisPorCor = animais.filter { it.cor.name.equals(cor, ignoreCase = true) }
        if (animaisPorCor.isNotEmpty()){
            println("Animais da cor $cor:")
            animaisPorCor.forEach{
                println("Nome: ${it.nome}, Idade em anos humanos: ${it.idadeEmAnosHumanos()}")
            }
        } else {
            println("Não existe dessa cor...")
        }
    }

    fun listarPorIdade(idade: Int){
        val animaisPorIdade = animais.filter { it.idade == idade }
        if (animaisPorIdade.isNotEmpty()) {
            println("Animais com $idade anos de idade:")
            animaisPorIdade.forEach {
                println("Nome: ${it.nome}, Idade em anos humanos: ${it.idadeEmAnosHumanos()}")
            }
        } else {
            println("Não foi achado essa idade de animal, tente novamente.")
        }
    }

    fun buscarPorNome(nome: String): Animal?{
        return animais.find{it.nome == nome}
    }

    fun listar() {
        if (animais.isEmpty()) {
            println("Não existe animais essa repositório.")
        } else {
            animais.forEach {
                println("Nome: ${it.nome}, Idade em anos humanos: ${it.idadeEmAnosHumanos()}, Cor de Animal: ${it.cor}")
            }
        }
    }
}