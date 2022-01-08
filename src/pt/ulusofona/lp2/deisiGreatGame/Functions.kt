package pt.ulusofona.lp2.deisiGreatGame

import kotlin.collections.contains


enum class CommandType{ GET, POST}

fun router() : (CommandType) -> ((GameManager, List<String>) -> String?)? {

    return {CommandType -> opcao(CommandType)}
}

fun opcao(type: CommandType?): ((GameManager, List<String>) -> String?)? {
    when(type) {
        CommandType.GET -> return ::funcaoGet
        CommandType.POST -> return ::funcaoPost
        else -> {}
    }
    return null
}

fun funcaoPost(manager: GameManager, args: List<String>): String? {
    when(args[0]) {
        "MOVE" -> return ::postMove.invoke(manager,args)
        "ABYSS" -> return ::postAbyss.invoke(manager,args)
    }
    return null
}

fun funcaoGet(manager: GameManager, args: List<String>): String? {
    when(args[0]) {
        "PLAYER" -> return ::getPlayer.invoke(manager,args)
        "POLYGLOTS" -> return ::getPolyglots.invoke(manager)
        "PLAYERS_BY_LANGUAGE" -> return ::getPlayerByLanguage.invoke(manager,args)
        "MOST_USED_POSITIONS" -> return ::getMostUsedPositions.invoke(manager,args)
        "MOST_USED_ABYSSES" -> return ::getMostUsedAbysses.invoke(manager,args)
    }
    return null
}

fun getPlayer(manager: GameManager, args: List<String>): String {
    if (manager.players==null) {
        return "Inexistent player"
    }
    else {
        val informacao = manager.players.filter { it.name.split(" ".toRegex()).toTypedArray()[0]
            .replace("[","").replace("]","") == args[1] }
        if (informacao.isEmpty()){
            return "Inexistent player"
        }
        return informacao.toString()
    }

}

fun dividirLinguagens(linguagens: String): Array<String> {
    return linguagens.split(";").toTypedArray()
}

fun getPlayerByLanguage(manager: GameManager, args: List<String>): String {
    if (manager.players==null) {
        return "Inexistent player"
    }
    else {
        val jogadoresLinguagens = manager.players.filter { dividirLinguagens(it.linguagens).contains(args[1]) }
            .joinToString(",") {
                it.name
            }
        if (jogadoresLinguagens.isEmpty()) {
            return ""
        }

        return jogadoresLinguagens
    }
}

fun getPolyglots (manager: GameManager): String {
    return if (manager.players==null) {
        "Inexistent language"
    }
    else {
        val jogadoresNumeroLinguagens = manager.players.filter { it.linguagens.split(";").count() > 1 }
            .sortedBy { it.linguagens.split(";").count() }.joinToString("\n") {
                it.name.plus(":").plus(
                    it.linguagens.split(";").count()
                )
            }

        jogadoresNumeroLinguagens
    }
}


fun postMove(manager: GameManager,args: List<String>): String {

    manager.moveCurrentPlayer(args[1].toInt())

    return manager.reactToAbyssOrTool() ?: "OK"

}

fun postAbyss(manager: GameManager,args: List<String>): String {
    if (manager.casasComEfeito == null){
        return ""
    }
    else {
        val novaAbyss = manager.casasComEfeito.filter { it.posicao == args[2].toInt() }.map { it.posicao }

        if (novaAbyss.isEmpty()) {
            val abyssesAndTools = Array(1) {
                arrayOfNulls<String>(
                    3
                )
            }
            abyssesAndTools[0][0] = "0"
            abyssesAndTools[0][1] = args[1]
            abyssesAndTools[0][2] = args[2]


            manager.adicionarPremio(abyssesAndTools, 0)
            return "OK"
        }

        return "Position is occupied"
    }

}

fun getMostUsedPositions(manager: GameManager, args: List<String>): String {
    return if (manager.posicoes==null) {
        ""
    }
    else {
        val numeroTotalPorPosicao = manager.posicoes

        return numeroTotalPorPosicao.sortedBy { numeroOcurrencias(numeroTotalPorPosicao, it) }
            .reversed().distinct().take(args[1].toInt())
            .joinToString { "$it:${numeroOcurrencias(numeroTotalPorPosicao, it)}" }
            .replace(", ", "\n")
    }
}

fun numeroOcurrencias(posicoes: List<Int>, este: Int): String {
    val total:Int = posicoes.count {it == este}

    return total.toString()
}


fun getMostUsedAbysses(manager: GameManager, args: List<String>): String {

    return if (manager.casasComEfeito == null) {
        ""
    }
    else {
        manager.casasComEfeito.sortedBy { it.numeroPisadas }.reversed()
            .distinctBy { it.tipo }.take(args[1].toInt()).joinToString { it.tipo.plus(":${it.numeroPisadas}") }
            .replace(", ", "\n")
    }
}



fun numeroPisadas(it: String) : Int {
    val numero : Array<String> = it.split(" ").toTypedArray()
    println(numero[numero.size-1].toInt())
    return numero[numero.size-1].toInt()
}




fun main() {
    val playerInfo = Array(3) {
        arrayOfNulls<String>(
            4
        )
    }


    playerInfo[0][0] = "60"
    playerInfo[0][1] = "Frederico Azevedo"
    playerInfo[0][2] = "Kotlin;C#"
    playerInfo[0][3] = "Purple"

    playerInfo[1][0] = "30"
    playerInfo[1][1] = "Ada Andrande"
    playerInfo[1][2] = "Kotlin;d;a;l"
    playerInfo[1][3] = "Green"

    playerInfo[2][0] = "10"
    playerInfo[2][1] = "Rodrigo Paiva"
    playerInfo[2][2] = "Java;Kotlin;C;Swift"
    playerInfo[2][3] = "Blue"
    val abyssesAndTools = Array(2) {
        arrayOfNulls<String>(
            3
        )
    }

    abyssesAndTools[0][0] = "0" //Abismo
    abyssesAndTools[0][1] = "1" //Erro de sintaxe (O programador recua 1 casa)
    abyssesAndTools[0][2] = "3" //Posicao

    abyssesAndTools[1][0] = "0" //Abismo
    abyssesAndTools[1][1] = "4" //Erro de sintaxe (O programador recua 1 casa)
    abyssesAndTools[1][2] = "4" //Posicao

    val args =  listOf("GET","4","1")

    val manager = GameManager()

    manager.createInitialBoard(playerInfo,30,abyssesAndTools)
    manager.moveCurrentPlayer(2)
    manager.reactToAbyssOrTool()
    manager.moveCurrentPlayer(2)
    manager.reactToAbyssOrTool()
    manager.moveCurrentPlayer(2)
    manager.reactToAbyssOrTool()
    manager.moveCurrentPlayer(2)
    manager.reactToAbyssOrTool()
    manager.moveCurrentPlayer(2)
    manager.reactToAbyssOrTool()
    manager.moveCurrentPlayer(2)
    manager.reactToAbyssOrTool()
    manager.moveCurrentPlayer(2)
    manager.reactToAbyssOrTool()
    manager.moveCurrentPlayer(2)
    manager.reactToAbyssOrTool()
    manager.moveCurrentPlayer(2)
    manager.reactToAbyssOrTool()
    manager.moveCurrentPlayer(2)
    manager.reactToAbyssOrTool()
    manager.moveCurrentPlayer(2)
    manager.reactToAbyssOrTool()
    manager.moveCurrentPlayer(2)
    manager.reactToAbyssOrTool()
    manager.moveCurrentPlayer(2)
    manager.reactToAbyssOrTool()
    manager.moveCurrentPlayer(2)
    manager.reactToAbyssOrTool()
    manager.moveCurrentPlayer(2)
    manager.reactToAbyssOrTool()


    //println(getPlayer(manager,args))
    //println(getPolyglots(manager))
    //println(getMostUsedPositions(manager,args))

    println(postAbyss(manager,args))

    println(getMostUsedAbysses(manager,args))
}


