package pt.ulusofona.lp2.deisiGreatGame;
import org.junit.Test;


import java.io.File;

import static org.junit.Assert.*;

//Já nao se associa a cor no player info tenho de fazer pelo ID...

public class TestUtilizador {
    @Test(timeout = 1000)
    public void test11_FerramentasAbismos_IniciarJogo_2Jogadores() {
        try {

            //Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[4][3];


            //Falta verificar se for uma string ou null

            abyssesAndTools[0][0] = "0"; //Abismo
            abyssesAndTools[0][1] = "5"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[0][2] = "2"; //Posicao

            abyssesAndTools[1][0] = "1"; //Abismo
            abyssesAndTools[1][1] = "1"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[1][2] = "4"; //Posicao

            abyssesAndTools[2][0] = "1"; //
            abyssesAndTools[2][1] = "5"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[2][2] = "10"; //Posicao

            abyssesAndTools[3][0] = "0"; //Abismo
            abyssesAndTools[3][1] = "0"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[3][2] = "15"; //Posicao

            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 2 jogadores (Deve pôr por ordem pelo ID mais baixo)
            String[][] playerInfo = new String[2][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Rui";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Frederico";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";
            File file = new File("");
            g1.createInitialBoard(playerInfo,40,abyssesAndTools);

            System.out.println(g1.saveGame(file));



        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }



        /*

        System.out.println(;

        //Função que irá criar o campo com 20 posições
        assertTrue("Deve dar correto",g1.createInitialBoard(playerInfo,20,abyssesAndTools));

        //Inicialmente
        //Pedro 1 | Frederico 1

        g1.moveCurrentPlayer(1);
        //Pedro 2 | Frederico 1
        System.out.println(g1.reactToAbyssOrTool());
        //Pedro 2 | Frederico 1

        g1.moveCurrentPlayer(1);
        //Pedro 2 | Frederico 2
        System.out.println(g1.reactToAbyssOrTool());
        //Pedro 2 | Frederico 2

        g1.moveCurrentPlayer(2);
        //Pedro 4 | Frederico 1
        System.out.println(g1.reactToAbyssOrTool());
        //Pedro 4 | Frederico 1




         */
        }


}

