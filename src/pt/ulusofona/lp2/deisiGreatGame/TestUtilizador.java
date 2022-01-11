package pt.ulusofona.lp2.deisiGreatGame;
import org.junit.Test;


import java.io.File;

import static org.junit.Assert.*;

//Já nao se associa a cor no player info tenho de fazer pelo ID...

public class TestUtilizador {
    @Test(timeout = 1000)
    public void test001_ferramentasAbismos_IniciarJogo_2Jogadores() {
        try {

            //Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[0][0];


            //Falta verificar se for uma string ou nul

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
            g1.createInitialBoard(playerInfo,40,abyssesAndTools);

            File file = new File("ola");
            g1.saveGame(file);




        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }

        }

    @Test(timeout = 100)
    public void test002_abismos_ErroSintaxe_2Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | A|  |  |  | A|  | A|  |  | A|  |  | A |  | A|  |
          1                                               17       20
         */

        //Criar o abismo (Erro de sintaxe)
        try {
            String[][] abyssesAndTools = new String[7][3];

            abyssesAndTools[0][0] = "0"; //Abismo
            abyssesAndTools[0][1] = "0"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[0][2] = "3"; //Posicao

            abyssesAndTools[1][0] = "0"; //Abismo
            abyssesAndTools[1][1] = "0"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[1][2] = "5"; //Posicao

            abyssesAndTools[2][0] = "0"; //Abismo
            abyssesAndTools[2][1] = "0"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[2][2] = "9"; //Posicao

            abyssesAndTools[3][0] = "0"; //Abismo
            abyssesAndTools[3][1] = "0"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[3][2] = "11"; //Posicao

            abyssesAndTools[4][0] = "0"; //Abismo
            abyssesAndTools[4][1] = "0"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[4][2] = "14"; //Posicao

            abyssesAndTools[5][0] = "0"; //Abismo
            abyssesAndTools[5][1] = "0"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[5][2] = "17"; //Posicao

            abyssesAndTools[6][0] = "0"; //Abismo
            abyssesAndTools[6][1] = "0"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[6][2] = "19"; //Posicao




            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();






            //Criar 2 jogadores (Deve pôr por ordem pelo ID mais baixo)
            String[][] playerInfo = new String[2][4];


            playerInfo[0][0] = "60";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "30";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Kotlin";
            playerInfo[1][3] = "Green";






            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,20,abyssesAndTools);


            //Para correres o programa sem problemas tens sempre de primeiro utilizar a função moveCurrentPlayer e após
            //Chamas a função reactToAbyssOrTool para verificar se caiu em alguma casa com efeito
            //Por baixo de cada função estão as posições de cada jogador após a função
            //No final deves chamar a função System.out.println(g1.historico()); Para verificares se o historico das posições do
            //do jogador estão de acordo com as que tens. Nesta função caso o jogador não esteja em nenhuma casa especial vai ficar com o valor
            //Nada. por exemplo : Nada , 3 , 4 =>  nome, posicao, dado.
            //O historico serve para guardarmos a informação de cada jogador, porque existe abismos que fazem voltar 2 jogadas atras
            //Para verificares se o jogo acabou deves chamar
            //System.out.println(g1.gameIsOver()); ou AssertTrue("Um dos jogadores chegou a posicao final", g1.gameIsOver())


            // 3 , 5 ,9 ,11 , 14 , 17 , 19


            //Inicialmente
            //Pedro 1 | Frederico 1



            g1.moveCurrentPlayer(2);
            //Pedro 3 | Frederico 1
            System.out.println(g1.reactToAbyssOrTool());
            //Pedro 2 | Frederico 1


            g1.moveCurrentPlayer(2);
            //Pedro 2 | Frederico 3
            g1.reactToAbyssOrTool();
            //Pedro 2 | Frederico 2

            g1.moveCurrentPlayer(2);
            //Pedro 4 | Frederico 2
            g1.reactToAbyssOrTool();
            //Pedro 4 | Frederico 2

            g1.moveCurrentPlayer(3);
            //Pedro 4 | Frederico 5
            g1.reactToAbyssOrTool();
            //Pedro 4 | Frederico 4

            g1.moveCurrentPlayer(3);
            //Pedro 7 | Frederico 4
            g1.reactToAbyssOrTool();
            //Pedro 7 | Frederico 4

            g1.moveCurrentPlayer(6);
            //Pedro 7 | Frederico 10
            g1.reactToAbyssOrTool();
            //Pedro 7 | Frederico 10

            g1.moveCurrentPlayer(4);
            //Pedro 11 | Frederico 10
            g1.reactToAbyssOrTool();
            //Pedro 10 | Frederico 10


            g1.moveCurrentPlayer(5);
            //Pedro 10 | Frederico 15
            g1.reactToAbyssOrTool();
            //Pedro 10 | Frederico 15

            g1.moveCurrentPlayer(4);
            //Pedro 14 | Frederico 15
            g1.reactToAbyssOrTool();
            //Pedro 13 | Frederico 15

            g1.moveCurrentPlayer(2);
            //Pedro 13 | Frederico 17
            g1.reactToAbyssOrTool();
            //Pedro 13 | Frederico 16

            g1.moveCurrentPlayer(6);
            //Pedro 19 | Frederico 16
            g1.reactToAbyssOrTool();
            //Pedro 18 | Frederico 16

            g1.moveCurrentPlayer(4);
            //Pedro 18 | Frederico 20
            g1.reactToAbyssOrTool();
            //Pedro 18 | Frederico 20



            System.out.println(g1.getProgrammers());
            System.out.println(g1.gameIsOver());
            System.out.println(g1.getGameResults());
        } catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }




    }

    @Test(timeout = 100)
    public void test003_abismos_ErroLogica_3Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | A|  |  |  | A|  | A|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */
        try {
            //Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[7][3];

            abyssesAndTools[0][0] = "0"; //Abismo
            abyssesAndTools[0][1] = "1"; //Erro de lógica (O programador recua N casas, sendo N metade do valor que tiver saído no dado, arredondado para baixo)
            abyssesAndTools[0][2] = "3"; //Posicao

            abyssesAndTools[1][0] = "0"; //Abismo
            abyssesAndTools[1][1] = "1"; //Erro de lógica (O programador recua N casas, sendo N metade do valor que tiver saído no dado, arredondado para baixo)
            abyssesAndTools[1][2] = "5"; //Posicao

            abyssesAndTools[2][0] = "0"; //Abismo
            abyssesAndTools[2][1] = "1"; //Erro de lógica (O programador recua N casas, sendo N metade do valor que tiver saído no dado, arredondado para baixo)
            abyssesAndTools[2][2] = "9"; //Posicao

            abyssesAndTools[3][0] = "0"; //Abismo
            abyssesAndTools[3][1] = "1"; //Erro de lógica (O programador recua N casas, sendo N metade do valor que tiver saído no dado, arredondado para baixo)
            abyssesAndTools[3][2] = "11"; //Posicao

            abyssesAndTools[4][0] = "0"; //Abismo
            abyssesAndTools[4][1] = "1"; //Erro de lógica (O programador recua N casas, sendo N metade do valor que tiver saído no dado, arredondado para baixo)
            abyssesAndTools[4][2] = "14"; //Posicao

            abyssesAndTools[5][0] = "0"; //Abismo
            abyssesAndTools[5][1] = "1"; //Erro de lógica (O programador recua N casas, sendo N metade do valor que tiver saído no dado, arredondado para baixo)
            abyssesAndTools[5][2] = "17"; //Posicao

            abyssesAndTools[6][0] = "0"; //Abismo
            abyssesAndTools[6][1] = "1"; //Erro de lógica (O programador recua N casas, sendo N metade do valor que tiver saído no dado, arredondado para baixo)
            abyssesAndTools[6][2] = "19"; //Posicao



            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 3 jogadores (Deve pôr por ordem pelo ID mais baixo)
            String[][] playerInfo = new String[3][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";

            playerInfo[2][0] = "10";
            playerInfo[2][1] = "Rui";
            playerInfo[2][2] = "Java";
            playerInfo[2][3] = "Green";


            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,20,abyssesAndTools);


            //Inicialmente
            //Rui 1 | Pedro 1 | Frederico 1

            System.out.println(g1.getProgrammers());



            g1.moveCurrentPlayer(2);
            //Rui 3 | Pedro 1 | Frederico 1
            g1.reactToAbyssOrTool();
            //Rui 2 | Pedro 1 | Frederico 1


            g1.moveCurrentPlayer(3);
            //Rui 2 | Pedro 4 | Frederico 1
            g1.reactToAbyssOrTool();
            //Rui 2 | Pedro 4 | Frederico 1

            g1.moveCurrentPlayer(4);
            //Rui 2 | Pedro 4 | Frederico 5
            g1.reactToAbyssOrTool();
            //Rui 2 | Pedro 4 | Frederico 3




            g1.moveCurrentPlayer(6);
            //Rui 8 | Pedro 4 | Frederico 3
            g1.reactToAbyssOrTool();
            //Rui 8 | Pedro 4 | Frederico 3

            g1.moveCurrentPlayer(5);
            //Rui 8 | Pedro 9 | Frederico 3
            g1.reactToAbyssOrTool();
            //Rui 8 | Pedro 7 | Frederico 3

            System.out.println(g1.getProgrammers());


            g1.moveCurrentPlayer(6);
            //Rui 8 | Pedro 7 | Frederico 9
            g1.reactToAbyssOrTool();
            //Rui 8 | Pedro 7 | Frederico 6

            g1.moveCurrentPlayer(5);
            //Rui 13 | Pedro 7 | Frederico 6
            g1.reactToAbyssOrTool();
            //Rui 13 | Pedro 7 | Frederico 6

            g1.moveCurrentPlayer(4);
            //Rui 13 | Pedro 11 | Frederico 6
            g1.reactToAbyssOrTool();
            //Rui 13 | Pedro 9 | Frederico 6

            g1.moveCurrentPlayer(6);
            //Rui 13 | Pedro 9 | Frederico 12
            g1.reactToAbyssOrTool();
            //Rui 13 | Pedro 9 | Frederico 12

            g1.moveCurrentPlayer(6);
            //Rui 19 | Pedro 9 | Frederico 12
            g1.reactToAbyssOrTool();
            //Rui 16 | Pedro 9 | Frederico 12

            g1.moveCurrentPlayer(4);
            //Rui 16 | Pedro 13 | Frederico 12
            g1.reactToAbyssOrTool();
            //Rui 16 | Pedro 13 | Frederico 12

            g1.moveCurrentPlayer(5);
            //Rui 19 | Pedro 13 | Frederico 17
            g1.reactToAbyssOrTool();
            //Rui 16 | Pedro 13 | Frederico 15

            g1.moveCurrentPlayer(3);
            //Rui 19 | Pedro 13 | Frederico 15
            g1.reactToAbyssOrTool();
            //Rui 18 | Pedro 13 | Frederico 15

            g1.moveCurrentPlayer(6);
            //Rui 19 | Pedro 19 | Frederico 15
            g1.reactToAbyssOrTool();
            //Rui 18 | Pedro 16 | Frederico 15

            g1.moveCurrentPlayer(5);
            //Rui 19 | Pedro 19 | Frederico 20
            g1.reactToAbyssOrTool();
            //Rui 18 | Pedro 16 | Frederico 20


            System.out.println(g1.gameIsOver());
            System.out.println(g1.getProgrammers());
        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }




    }

    @Test(timeout = 1000)
    public void test004_abismos_Exception_4Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

         /*
        |  |  | A|  | A|  |  |  | A|  | A|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */
        try {
            //Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[7][3];

            abyssesAndTools[0][0] = "0"; //Abismo
            abyssesAndTools[0][1] = "2"; //Exception (O programador recua 2 casas)
            abyssesAndTools[0][2] = "3"; //Posicao

            abyssesAndTools[1][0] = "0"; //Abismo
            abyssesAndTools[1][1] = "2"; //Exception (O programador recua 2 casas)
            abyssesAndTools[1][2] = "5"; //Posicao

            abyssesAndTools[2][0] = "0"; //Abismo
            abyssesAndTools[2][1] = "2"; //Exception (O programador recua 2 casas)
            abyssesAndTools[2][2] = "9"; //Posicao

            abyssesAndTools[3][0] = "0"; //Abismo
            abyssesAndTools[3][1] = "2"; //Exception (O programador recua 2 casas)
            abyssesAndTools[3][2] = "11"; //Posicao

            abyssesAndTools[4][0] = "0"; //Abismo
            abyssesAndTools[4][1] = "2"; //Exception (O programador recua 2 casas)
            abyssesAndTools[4][2] = "14"; //Posicao

            abyssesAndTools[5][0] = "0"; //Abismo
            abyssesAndTools[5][1] = "2"; //Exception (O programador recua 2 casas)
            abyssesAndTools[5][2] = "17"; //Posicao

            abyssesAndTools[6][0] = "0"; //Abismo
            abyssesAndTools[6][1] = "2"; //Exception (O programador recua 2 casas)
            abyssesAndTools[6][2] = "19"; //Posicao



            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 3 jogadores (Deve pôr por ordem pelo ID mais baixo)
            String[][] playerInfo = new String[4][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";

            playerInfo[2][0] = "10";
            playerInfo[2][1] = "Rui";
            playerInfo[2][2] = "Java";
            playerInfo[2][3] = "Green";

            playerInfo[3][0] = "9";
            playerInfo[3][1] = "Tiago";
            playerInfo[3][2] = "Java";
            playerInfo[3][3] = "Brown";


            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,20,abyssesAndTools);


            //Inicialmente
            //Tiago 1 | Rui 1 | Pedro 1 | Frederico 1

            System.out.println(g1.getProgrammers());

            //Exception (O programador recua 2 casas)

            g1.moveCurrentPlayer(2);
            //Tiago 3 | Rui 1 | Pedro 1 | Frederico 1
            g1.reactToAbyssOrTool();
            //Tiago 1 | Rui 1 | Pedro 1 | Frederico 1

            g1.moveCurrentPlayer(6);
            //Tiago 1 | Rui 7 | Pedro 1 | Frederico 1
            g1.reactToAbyssOrTool();
            //Tiago 1 | Rui 7 | Pedro 1 | Frederico 1

            g1.moveCurrentPlayer(4);
            //Tiago 1 | Rui 7 | Pedro 5 | Frederico 1
            g1.reactToAbyssOrTool();
            //Tiago 1 | Rui 7 | Pedro 3 | Frederico 1

            g1.moveCurrentPlayer(3);
            //Tiago 1 | Rui 7 | Pedro 3 | Frederico 4
            g1.reactToAbyssOrTool();
            //Tiago 1 | Rui 7 | Pedro 3 | Frederico 4

            g1.moveCurrentPlayer(6);
            //Tiago 7 | Rui 7 | Pedro 3 | Frederico 4
            g1.reactToAbyssOrTool();
            //Tiago 7 | Rui 7 | Pedro 3 | Frederico 4

            g1.moveCurrentPlayer(5);
            //Tiago 7 | Rui 12 | Pedro 3 | Frederico 4
            g1.reactToAbyssOrTool();
            //Tiago 7 | Rui 12 | Pedro 3 | Frederico 4

            g1.moveCurrentPlayer(6);
            //Tiago 7 | Rui 12 | Pedro 9 | Frederico 4
            g1.reactToAbyssOrTool();
            //Tiago 7 | Rui 12 | Pedro 7 | Frederico 4

            g1.moveCurrentPlayer(5);
            //Tiago 7 | Rui 12 | Pedro 7 | Frederico 9
            g1.reactToAbyssOrTool();
            //Tiago 7 | Rui 12 | Pedro 7 | Frederico 7

            g1.moveCurrentPlayer(6);
            //Tiago 13 | Rui 12 | Pedro 7 | Frederico 7
            g1.reactToAbyssOrTool();
            //Tiago 13 | Rui 12 | Pedro 7 | Frederico 7

            g1.moveCurrentPlayer(5);
            //Tiago 13 | Rui 17 | Pedro 7 | Frederico 7
            g1.reactToAbyssOrTool();
            //Tiago 13 | Rui 15 | Pedro 7 | Frederico 7

            g1.moveCurrentPlayer(4);
            //Tiago 13 | Rui 15 | Pedro 11 | Frederico 7
            g1.reactToAbyssOrTool();
            //Tiago 13 | Rui 15 | Pedro 9 | Frederico 7

            g1.moveCurrentPlayer(6);
            //Tiago 13 | Rui 15 | Pedro 9 | Frederico 13
            g1.reactToAbyssOrTool();
            //Tiago 13 | Rui 15 | Pedro 9 | Frederico 13

            g1.moveCurrentPlayer(4);
            //Tiago 17 | Rui 15 | Pedro 9 | Frederico 13
            g1.reactToAbyssOrTool();
            //Tiago 15 | Rui 15 | Pedro 9 | Frederico 13

            g1.moveCurrentPlayer(4);
            //Tiago 15 | Rui 19 | Pedro 9 | Frederico 13
            g1.reactToAbyssOrTool();
            //Tiago 15 | Rui 17 | Pedro 9 | Frederico 13

            g1.moveCurrentPlayer(6);
            //Tiago 15 | Rui 19 | Pedro 15 | Frederico 13
            g1.reactToAbyssOrTool();
            //Tiago 15 | Rui 17 | Pedro 15 | Frederico 13

            g1.moveCurrentPlayer(6);
            //Tiago 15 | Rui 19 | Pedro 15 | Frederico 19
            g1.reactToAbyssOrTool();
            //Tiago 15 | Rui 17 | Pedro 15 | Frederico 17

            g1.moveCurrentPlayer(5);
            //Tiago 20 | Rui 19 | Pedro 15 | Frederico 17
            g1.reactToAbyssOrTool();
            //Tiago 20 | Rui 17 | Pedro 15 | Frederico 17

            System.out.println(g1.gameIsOver());
            System.out.println(g1.getProgrammers());

            System.out.println(g1.getGameResults());
        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }


    }

    @Test(timeout = 100)
    public void test005_abismos_CicloInfinito_3Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | A|  |  |  | A|  | A|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */

        try {
            //Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[7][3];

            abyssesAndTools[0][0] = "0"; //Abismo
            abyssesAndTools[0][1] = "8"; //Ciclo infinito
            abyssesAndTools[0][2] = "3"; //Posicao

            abyssesAndTools[1][0] = "0"; //Abismo
            abyssesAndTools[1][1] = "8"; //Ciclo infinito
            abyssesAndTools[1][2] = "5"; //Posicao

            abyssesAndTools[2][0] = "0"; //Abismo
            abyssesAndTools[2][1] = "8"; //Ciclo infinito
            abyssesAndTools[2][2] = "9"; //Posicao

            abyssesAndTools[3][0] = "0"; //Abismo
            abyssesAndTools[3][1] = "8"; //Ciclo infinito
            abyssesAndTools[3][2] = "11"; //Posicao

            abyssesAndTools[4][0] = "0"; //Abismo
            abyssesAndTools[4][1] = "8"; //Ciclo infinito
            abyssesAndTools[4][2] = "14"; //Posicao

            abyssesAndTools[5][0] = "0"; //Abismo
            abyssesAndTools[5][1] = "8"; //Ciclo infinito
            abyssesAndTools[5][2] = "17"; //Posicao

            abyssesAndTools[6][0] = "0"; //Abismo
            abyssesAndTools[6][1] = "8"; //Ciclo infinito
            abyssesAndTools[6][2] = "19"; //Posicao



            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 3 jogadores (Deve pôr por ordem pelo ID mais baixo)
            String[][] playerInfo = new String[3][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";

            playerInfo[2][0] = "10";
            playerInfo[2][1] = "Rui";
            playerInfo[2][2] = "Java";
            playerInfo[2][3] = "Green";


            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,20,abyssesAndTools);


            //Inicialmente
            //Rui 1 | Pedro 1 | Frederico 1

            System.out.println(g1.getProgrammers());


            //3 6 9 11 14 17 19

            //Fica à espera que apareça outro jogador na mesma casa

            g1.moveCurrentPlayer(2); //10
            //Rui 3 | Pedro 1 | Frederico 1
            g1.reactToAbyssOrTool();
            //Rui 3 | Pedro 1 | Frederico 1

            g1.moveCurrentPlayer(5); //20
            //Rui 3 | Pedro 6 | Frederico 1
            g1.reactToAbyssOrTool();
            //Rui 3 | Pedro 6 | Frederico 1

            g1.moveCurrentPlayer(1); //30
            //Rui 3 | Pedro 6 | Frederico 2
            g1.reactToAbyssOrTool();
            //Rui 3 | Pedro 6 | Frederico 2

            g1.moveCurrentPlayer(6); //20
            //Rui 3 | Pedro 12 | Frederico 2
            g1.reactToAbyssOrTool();
            //Rui 3 | Pedro 12 | Frederico 2

            g1.moveCurrentPlayer(1); //30
            //Rui 3 | Pedro 12 | Frederico 3
            g1.reactToAbyssOrTool();
            //Rui 3 | Pedro 12 | Frederico 3

            g1.moveCurrentPlayer(6); //10
            //Rui 9 | Pedro 12 | Frederico 3
            g1.reactToAbyssOrTool();
            //Rui 9 | Pedro 12 | Frederico 3

            g1.moveCurrentPlayer(3);
            //Rui 9 | Pedro 15 | Frederico 3
            g1.reactToAbyssOrTool();
            //Rui 9 | Pedro 15 | Frederico 3

            g1.moveCurrentPlayer(3);
            //Rui 9 | Pedro 18 | Frederico 3
            g1.reactToAbyssOrTool();
            //Rui 9 | Pedro 18 | Frederico 3

            g1.moveCurrentPlayer(4);
            //Rui 9 | Pedro 18 | Frederico 3
            g1.reactToAbyssOrTool();
            //Rui 9 | Pedro 18 | Frederico 3

            g1.moveCurrentPlayer(2);
            //Rui 9 | Pedro 20 | Frederico 3
            g1.reactToAbyssOrTool();
            //Rui 9 | Pedro 20 | Frederico 3

            System.out.println(g1.gameIsOver());
            System.out.println(g1.getProgrammers());
        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }


    }

    @Test(timeout = 100)
    public void test006_abismos_Crash_4Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */
        try {
            //Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[4][3];

            abyssesAndTools[0][0] = "1"; //Abismo
            abyssesAndTools[0][1] = "1"; //Erro de Crash (O programador recua para a 1Casa)
            abyssesAndTools[0][2] = "3"; //Posicao

            abyssesAndTools[1][0] = "0"; //Abismo
            abyssesAndTools[1][1] = "4"; //Erro de Crash (O programador recua para a 1Casa)
            abyssesAndTools[1][2] = "9"; //Posicao

            abyssesAndTools[2][0] = "0"; //Abismo
            abyssesAndTools[2][1] = "4"; //Erro de Crash (O programador recua para a 1Casa)
            abyssesAndTools[2][2] = "17"; //Posicao

            abyssesAndTools[3][0] = "0"; //Abismo
            abyssesAndTools[3][1] = "4"; //Erro de Crash (O programador recua para a 1Casa)
            abyssesAndTools[3][2] = "19"; //Posicao



            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 4 jogadores (Deve pôr por ordem pelo ID mais baixo) Falta
            String[][] playerInfo = new String[4][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";

            playerInfo[2][0] = "10";
            playerInfo[2][1] = "Rui";
            playerInfo[2][2] = "Java";
            playerInfo[2][3] = "Green";

            playerInfo[3][0] = "50";
            playerInfo[3][1] = "Joana";
            playerInfo[3][2] = "Java";
            playerInfo[3][3] = "Brown";


            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,20,abyssesAndTools);


            //Inicialmente
            //Rui 1 | Pedro 1 | Frederico 1 | Rui 1

            System.out.println(g1.getProgrammers());




            g1.moveCurrentPlayer(2);
            //Rui 3 | Pedro 1 | Frederico 1
            g1.reactToAbyssOrTool();
            //Rui 2 | Pedro 1 | Frederico 1


            g1.moveCurrentPlayer(3);
            //Rui 2 | Pedro 4 | Frederico 1
            g1.reactToAbyssOrTool();
            //Rui 2 | Pedro 4 | Frederico 1

            g1.moveCurrentPlayer(4);
            //Rui 2 | Pedro 4 | Frederico 5
            g1.reactToAbyssOrTool();
            //Rui 2 | Pedro 4 | Frederico 3



            System.out.println(g1.getProgrammers());

            g1.moveCurrentPlayer(6);
            //Rui 8 | Pedro 4 | Frederico 3
            g1.reactToAbyssOrTool();
            //Rui 8 | Pedro 4 | Frederico 3

            g1.moveCurrentPlayer(5);
            //Rui 8 | Pedro 9 | Frederico 3
            g1.reactToAbyssOrTool();
            //Rui 8 | Pedro 7 | Frederico 3

            System.out.println(g1.getProgrammers());


            g1.moveCurrentPlayer(6);
            //Rui 8 | Pedro 7 | Frederico 9
            g1.reactToAbyssOrTool();
            //Rui 8 | Pedro 7 | Frederico 6

            g1.moveCurrentPlayer(5);
            //Rui 13 | Pedro 7 | Frederico 6
            g1.reactToAbyssOrTool();
            //Rui 13 | Pedro 7 | Frederico 6

            g1.moveCurrentPlayer(4);
            //Rui 13 | Pedro 11 | Frederico 6
            g1.reactToAbyssOrTool();
            //Rui 13 | Pedro 9 | Frederico 6

            g1.moveCurrentPlayer(6);
            //Rui 13 | Pedro 9 | Frederico 12
            g1.reactToAbyssOrTool();
            //Rui 13 | Pedro 9 | Frederico 12

            g1.moveCurrentPlayer(6);
            //Rui 19 | Pedro 9 | Frederico 12
            g1.reactToAbyssOrTool();
            //Rui 16 | Pedro 9 | Frederico 12

            g1.moveCurrentPlayer(4);
            //Rui 16 | Pedro 13 | Frederico 12
            g1.reactToAbyssOrTool();
            //Rui 16 | Pedro 13 | Frederico 12

            g1.moveCurrentPlayer(5);
            //Rui 19 | Pedro 13 | Frederico 17
            g1.reactToAbyssOrTool();
            //Rui 16 | Pedro 13 | Frederico 15

            g1.moveCurrentPlayer(3);
            //Rui 19 | Pedro 13 | Frederico 15
            g1.reactToAbyssOrTool();
            //Rui 18 | Pedro 13 | Frederico 15

            g1.moveCurrentPlayer(6);
            //Rui 19 | Pedro 19 | Frederico 15
            g1.reactToAbyssOrTool();
            //Rui 18 | Pedro 16 | Frederico 15

            g1.moveCurrentPlayer(5);
            //Rui 19 | Pedro 19 | Frederico 20
            g1.reactToAbyssOrTool();
            //Rui 18 | Pedro 16 | Frederico 20


            System.out.println(g1.gameIsOver());
            System.out.println(g1.getProgrammers());

        }
        catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }




    }

    @Test(timeout = 1000)
    public void test007_abismos_Efeitossecundarios_3Jogadores() {
        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */

        try {
            String[][] abyssesAndTools = new String[7][3];

            abyssesAndTools[0][0] = "0"; //Abismo
            abyssesAndTools[0][1] = "6"; //Efeitos secundários (O programador recua 2 jogadas atras)
            abyssesAndTools[0][2] = "3"; //Posicao

            abyssesAndTools[1][0] = "0"; //Abismo
            abyssesAndTools[1][1] = "6"; //Efeitos secundários (O programador recua 2 jogadas atras)
            abyssesAndTools[1][2] = "5"; //Posicao

            abyssesAndTools[2][0] = "0"; //Abismo
            abyssesAndTools[2][1] = "6"; //Efeitos secundários (O programador recua 2 jogadas atras)
            abyssesAndTools[2][2] = "9"; //Posicao

            abyssesAndTools[3][0] = "0"; //Abismo
            abyssesAndTools[3][1] = "6"; //Efeitos secundários (O programador recua 2 jogadas atras)
            abyssesAndTools[3][2] = "11"; //Posicao

            abyssesAndTools[4][0] = "0"; //Abismo
            abyssesAndTools[4][1] = "6"; //Efeitos secundários (O programador recua 2 jogadas atras)
            abyssesAndTools[4][2] = "14"; //Posicao

            abyssesAndTools[5][0] = "0"; //Abismo
            abyssesAndTools[5][1] = "6"; //Efeitos secundários (O programador recua 2 jogadas atras)
            abyssesAndTools[5][2] = "17"; //Posicao

            abyssesAndTools[6][0] = "0"; //Abismo
            abyssesAndTools[6][1] = "6"; //Efeitos secundários (O programador recua 2 jogadas atras)
            abyssesAndTools[6][2] = "19"; //Posicao



            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 4 jogadores (Deve pôr por ordem pelo ID mais baixo) Falta
            String[][] playerInfo = new String[3][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";

            playerInfo[2][0] = "10";
            playerInfo[2][1] = "Rui";
            playerInfo[2][2] = "Java";
            playerInfo[2][3] = "Green";



            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,20,abyssesAndTools);


            //Inicialmente
            //Rui 1 | Pedro 1 | Frederico 1

            g1.moveCurrentPlayer(2);
            //Rui 3 | Pedro 1 | Frederico 1
            g1.reactToAbyssOrTool();
            //Rui 1 | Pedro 1 | Frederico 1

            g1.moveCurrentPlayer(6);
            //Rui 1 | Pedro 7 | Frederico 1
            g1.reactToAbyssOrTool();
            //Rui 1 | Pedro 7 | Frederico 1

            g1.moveCurrentPlayer(4);
            //Rui 1 | Pedro 7 | Frederico 5
            g1.reactToAbyssOrTool();
            //Rui 1 | Pedro 7 | Frederico 1

            g1.moveCurrentPlayer(5);
            //Rui 6 | Pedro 7 | Frederico 1
            g1.reactToAbyssOrTool();
            //Rui 6 | Pedro 7 | Frederico 1

            g1.moveCurrentPlayer(6);
            //Rui 6 | Pedro 13 | Frederico 1
            g1.reactToAbyssOrTool();
            //Rui 6 | Pedro 13 | Frederico 1

            g1.moveCurrentPlayer(6);
            //Rui 6 | Pedro 13 | Frederico 7
            g1.reactToAbyssOrTool();
            //Rui 6 | Pedro 13 | Frederico 7

            g1.moveCurrentPlayer(6);
            //Rui 12 | Pedro 13 | Frederico 7
            g1.reactToAbyssOrTool();
            //Rui 12 | Pedro 13 | Frederico 7

            g1.moveCurrentPlayer(1);
            //Rui 12 | Pedro 14 | Frederico 7
            g1.reactToAbyssOrTool();
            //Rui 12 | Pedro 7 | Frederico 7

            g1.moveCurrentPlayer(6);
            //Rui 12 | Pedro 14 | Frederico 13
            g1.reactToAbyssOrTool();
            //Rui 12 | Pedro 7 | Frederico 13

            g1.moveCurrentPlayer(6);
            //Rui 18 | Pedro 14 | Frederico 13
            g1.reactToAbyssOrTool();
            //Rui 18 | Pedro 7 | Frederico 13

            g1.moveCurrentPlayer(6);
            //Rui 18 | Pedro 13 | Frederico 13
            g1.reactToAbyssOrTool();
            //Rui 18 | Pedro 13 | Frederico 13

            g1.moveCurrentPlayer(6);
            //Rui 18 | Pedro 13 | Frederico 19
            g1.reactToAbyssOrTool();
            //Rui 18 | Pedro 13 | Frederico 7

            g1.moveCurrentPlayer(1);
            //Rui 19 | Pedro 13 | Frederico 7
            g1.reactToAbyssOrTool();
            //Rui 12 | Pedro 13 | Frederico 7

            g1.moveCurrentPlayer(1);
            //Rui 19 | Pedro 13 | Frederico 7
            g1.reactToAbyssOrTool();
            //Rui 12 | Pedro 13 | Frederico 7

            g1.moveCurrentPlayer(1);
            //Rui 19 | Pedro 14 | Frederico 7
            g1.reactToAbyssOrTool();
            //Rui 12 | Pedro 14 | Frederico 7


            g1.moveCurrentPlayer(2);
            //Rui 19 | Pedro 14 | Frederico 9
            g1.reactToAbyssOrTool();
            //Rui 12 | Pedro 14 | Frederico 19


            //Verificar se tenho de apagar o historico as posicoes depois do voltar a atras


            System.out.println(g1.getProgrammers(false));





            //3 5 9 11 14 17 19
        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }



    }

    @Test(timeout = 100)
    public void test008_abismoseFerramentas_False1() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */

        try {
            //Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[1][3];


            abyssesAndTools[0][0] = "0"; //Abismo
            abyssesAndTools[0][1] = ""; //Efeitos secundários (O programador recua 2 jogadas atras)
            abyssesAndTools[0][2] = "3"; //Posicao




            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 4 jogadores (Deve pôr por ordem pelo ID mais baixo) Falta
            String[][] playerInfo = new String[3][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";

            playerInfo[2][0] = "10";
            playerInfo[2][1] = "Rui";
            playerInfo[2][2] = "Java";
            playerInfo[2][3] = "Green";




            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,20,abyssesAndTools);

        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }




    }

    @Test(timeout = 100)
    public void test009_abismoseFerramentas_False2() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */

        try {
            //Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[1][3];


            abyssesAndTools[0][0] = "0"; //Abismo
            abyssesAndTools[0][1] = "2"; //Efeitos secundários (O programador recua 2 jogadas atras)
            abyssesAndTools[0][2] = ""; //Posicao




            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 4 jogadores (Deve pôr por ordem pelo ID mais baixo) Falta
            String[][] playerInfo = new String[3][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";

            playerInfo[2][0] = "10";
            playerInfo[2][1] = "Rui";
            playerInfo[2][2] = "Java";
            playerInfo[2][3] = "Green";




            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,20,abyssesAndTools);

        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }




    }


    @Test(timeout = 100)
    public void test010_abismoseFerramentas_False3() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */

        try {
            //Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[1][3];


            abyssesAndTools[0][0] = ""; //Abismo
            abyssesAndTools[0][1] = "2"; //Efeitos secundários (O programador recua 2 jogadas atras)
            abyssesAndTools[0][2] = "1"; //Posicao




            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 4 jogadores (Deve pôr por ordem pelo ID mais baixo) Falta
            String[][] playerInfo = new String[3][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";

            playerInfo[2][0] = "10";
            playerInfo[2][1] = "Rui";
            playerInfo[2][2] = "Java";
            playerInfo[2][3] = "Green";




            //Função que irá criar o campo com 20 posições
           g1.createInitialBoard(playerInfo,20,abyssesAndTools);

        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }



    }

    @Test(timeout = 100)
    public void test011_abismoseFerramentas_False4() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */

        try {
            //Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[1][3];


            abyssesAndTools[0][0] = " "; //Abismo
            abyssesAndTools[0][1] = "2"; //Efeitos secundários (O programador recua 2 jogadas atras)
            abyssesAndTools[0][2] = "1"; //Posicao




            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 4 jogadores (Deve pôr por ordem pelo ID mais baixo) Falta
            String[][] playerInfo = new String[3][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";

            playerInfo[2][0] = "10";
            playerInfo[2][1] = "Rui";
            playerInfo[2][2] = "Java";
            playerInfo[2][3] = "Green";




            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,20,abyssesAndTools);


        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }


    }

    @Test(timeout = 1000)
    public void test012_abismos_BlueScreenofDeath_2Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */

        try {
            //Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[4][3];

            abyssesAndTools[0][0] = "1"; //Abismo
            abyssesAndTools[0][1] = "2"; //Blue Screen of Death (Perdeu)
            abyssesAndTools[0][2] = "3"; //Posicao

            abyssesAndTools[1][0] = "1"; //Abismo
            abyssesAndTools[1][1] = "2"; //Blue Screen of Death (Perdeu)
            abyssesAndTools[1][2] = "9"; //Posicao

            abyssesAndTools[2][0] = "0"; //Abismo
            abyssesAndTools[2][1] = "7"; //Blue Screen of Death (Perdeu)
            abyssesAndTools[2][2] = "17"; //Posicao

            abyssesAndTools[3][0] = "0"; //Abismo
            abyssesAndTools[3][1] = "7"; //Blue Screen of Death (Perdeu)
            abyssesAndTools[3][2] = "19"; //Posicao




            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 4 jogadores (Deve pôr por ordem pelo ID mais baixo) Falta
            String[][] playerInfo = new String[2][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";



            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,20,abyssesAndTools);


            //Inicialmente
            // Pedro 1 | Frederico 1

            g1.moveCurrentPlayer(2);
            //Pedro 4 | Frederico 1
            g1.reactToAbyssOrTool();
            //Pedro 4 | Frederico 1

            g1.moveCurrentPlayer(2);
            //Pedro 4 | Frederico 1
            g1.reactToAbyssOrTool();
            //Pedro 4 | Frederico 1

            g1.moveCurrentPlayer(6);
            //Pedro 4 | Frederico 1
            System.out.println(g1.reactToAbyssOrTool());
            //Pedro 4 | Frederico 1

        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }




    }

    @Test(timeout = 100)
    public void test013_getGameResult4jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */

        try {
            //Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[1][3];


            abyssesAndTools[0][0] = "0"; //Abismo
            abyssesAndTools[0][1] = "7"; //Efeitos secundários (O programador recua 2 jogadas atras)
            abyssesAndTools[0][2] = "3"; //Posicao




            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 4 jogadores (Deve pôr por ordem pelo ID mais baixo) Falta
            String[][] playerInfo = new String[4][4];


            playerInfo[0][0] = "4";
            playerInfo[0][1] = "Frederico A";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "3";
            playerInfo[1][1] = "Frederico B";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";

            playerInfo[2][0] = "2";
            playerInfo[2][1] = "Rui";
            playerInfo[2][2] = "Java";
            playerInfo[2][3] = "Green";


            playerInfo[3][0] = "1";
            playerInfo[3][1] = "Tiago";
            playerInfo[3][2] = "Java";
            playerInfo[3][3] = "Brown";

            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,7,abyssesAndTools);

            // Frederico ; Pedro ; Neto ; Rui

            //turno =1
            g1.moveCurrentPlayer(2);
            g1.reactToAbyssOrTool();//Tiago ( Caiu BSOD) turno : 1


            //turno = 2
            g1.moveCurrentPlayer(2);
            g1.reactToAbyssOrTool();//Rui ( Caiu BSOD) turno : 2

            //turno = 3
            g1.moveCurrentPlayer(1);
            g1.reactToAbyssOrTool();//Frederico B  turno : 3


            //turno = 4
            g1.moveCurrentPlayer(1);
            g1.reactToAbyssOrTool(); //Frederico A turno : 4


            //turno = 5
            g1.moveCurrentPlayer(1);
            g1.reactToAbyssOrTool();//Frederico B ( Caiu BSOD) turno : 5


            //turno = 5 || turno = 6 ??


            // Acabou no turno 5 ou ainda passa para o 6?



            System.out.println(g1.getProgrammers(true));




            System.out.println(g1.getGameResults());

        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }

    }

    @Test(timeout = 100)
    public void test014_getGameResult3jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */
        try {
            //Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[1][3];


            abyssesAndTools[0][0] = "0"; //Abismo
            abyssesAndTools[0][1] = "7"; //Efeitos secundários (O programador recua 2 jogadas atras)
            abyssesAndTools[0][2] = "6"; //Posicao




            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 4 jogadores (Deve pôr por ordem pelo ID mais baixo) Falta
            String[][] playerInfo = new String[3][4];


            playerInfo[0][0] = "4";
            playerInfo[0][1] = "Frederico A";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "3";
            playerInfo[1][1] = "Frederico B";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";

            playerInfo[2][0] = "2";
            playerInfo[2][1] = "Rui";
            playerInfo[2][2] = "Java";
            playerInfo[2][3] = "Green";




            //casa 6


            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,7,abyssesAndTools);

            // Frederico ; Pedro ; Neto ; Rui
            System.out.println(g1.getGameResults());

            g1.moveCurrentPlayer(6); //Rui 7
            g1.reactToAbyssOrTool();

        /*
        g1.moveCurrentPlayer(1); //Frederico B
        g1.reactToAbyssOrTool();

        g1.moveCurrentPlayer(4); //Frederico A
        g1.reactToAbyssOrTool();

        g1.moveCurrentPlayer(3); //Frederico B
        g1.reactToAbyssOrTool();
        System.out.println(g1.getProgrammers(true));

        g1.moveCurrentPlayer(2); //Frederico A
        g1.reactToAbyssOrTool();

         */

            // Rui   5 ; Frederico B  6  ; Frederico A 7



            System.out.println(g1.getGameResults());


        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }





    }

    @Test(timeout = 100)
    public void test015_getGameResult3jogadores1() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */

        try {
            //Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[1][3];


            abyssesAndTools[0][0] = "0"; //Abismo
            abyssesAndTools[0][1] = "7"; //Efeitos secundários (O programador recua 2 jogadas atras)
            abyssesAndTools[0][2] = "4"; //Posicao




            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 4 jogadores (Deve pôr por ordem pelo ID mais baixo) Falta
            String[][] playerInfo = new String[3][4];


            playerInfo[0][0] = "4";
            playerInfo[0][1] = "Frederico A";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "3";
            playerInfo[1][1] = "Frederico B";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";

            playerInfo[2][0] = "2";
            playerInfo[2][1] = "Rui";
            playerInfo[2][2] = "Java";
            playerInfo[2][3] = "Green";




            //casa 4


            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,7,abyssesAndTools);

            // Frederico ; Pedro ; Neto ; Rui
            System.out.println(g1.getGameResults());

            //turno 1
            g1.moveCurrentPlayer(3); //Rui 4
            g1.reactToAbyssOrTool();

            //turno 2
            g1.moveCurrentPlayer(1); //Frederico B 2
            g1.reactToAbyssOrTool();


            //turno 3
            g1.moveCurrentPlayer(4); //Frederico A 5
            g1.reactToAbyssOrTool();


            //turno 4
            g1.moveCurrentPlayer(2); //Frederico B
            g1.reactToAbyssOrTool();




            // Rui   5 ; Frederico B  6  ; Frederico A 7



            System.out.println(g1.getGameResults());


        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }




    }

    @Test(timeout = 100)
    public void test016_getGameResult3jogadores2() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */

        try {
            //Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[1][3];


            abyssesAndTools[0][0] = "0"; //Abismo
            abyssesAndTools[0][1] = "7"; //Efeitos secundários (O programador recua 2 jogadas atras)
            abyssesAndTools[0][2] = "4"; //Posicao




            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 4 jogadores (Deve pôr por ordem pelo ID mais baixo) Falta
            String[][] playerInfo = new String[3][4];


            playerInfo[0][0] = "4";
            playerInfo[0][1] = "Frederico A";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "3";
            playerInfo[1][1] = "Frederico B";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";

            playerInfo[2][0] = "2";
            playerInfo[2][1] = "Rui";
            playerInfo[2][2] = "Java";
            playerInfo[2][3] = "Green";




            //casa 4


            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,7,abyssesAndTools);

            // Frederico ; Pedro ; Neto ; Rui
            System.out.println(g1.getGameResults());

            //turno 1
            g1.moveCurrentPlayer(2); //Rui 3
            g1.reactToAbyssOrTool();

            //turno 2
            g1.moveCurrentPlayer(3); //Frederico B 4
            g1.reactToAbyssOrTool();


            //turno 3
            g1.moveCurrentPlayer(4); //Frederico A 5
            g1.reactToAbyssOrTool();


            //turno 4
            g1.moveCurrentPlayer(1); //Rui 4
            g1.reactToAbyssOrTool();







            // Rui   5 ; Frederico B  6  ; Frederico A 7



            System.out.println(g1.getGameResults());


        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }




    }

    @Test(timeout = 100)
    public void test017_getGameResult2jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */

        try {
//Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[1][3];


            abyssesAndTools[0][0] = "0"; //Abismo
            abyssesAndTools[0][1] = "7"; //Efeitos secundários (O programador recua 2 jogadas atras)
            abyssesAndTools[0][2] = "4"; //Posicao




            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 4 jogadores (Deve pôr por ordem pelo ID mais baixo) Falta
            String[][] playerInfo = new String[2][4];


            playerInfo[0][0] = "4";
            playerInfo[0][1] = "Frederico B";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "3";
            playerInfo[1][1] = "Frederico A";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";









            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,7,abyssesAndTools);

// Frederico ; Pedro ; Neto ; Rui
            System.out.println(g1.getGameResults());


            g1.moveCurrentPlayer(1); //Frederico A turno 1
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(1); //Frederico B turno 2
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(1); //Frederico A turno 3
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(1); //Frederico B turno 4
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(2); //Frederico A turno 5
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(2); //Frederico B turno 6
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(2); //Frederico B turno 7
            g1.reactToAbyssOrTool();


            //Acabou no 9

            System.out.println(g1.getProgrammers(true));

            /*
            g1.moveCurrentPlayer(6); //Frederico B
            g1.reactToAbyssOrTool();

             */





            System.out.println(g1.getGameResults());
        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }







    }

    @Test(timeout = 100)
    public void test18_ferramentasAbismos_IniciarJogo_2Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | A|  |  |  | A|  | A|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */

        try {
//Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[4][3];


            //Falta verificar se for uma string ou null

            abyssesAndTools[0][0] = "1"; //Abismo
            abyssesAndTools[0][1] = "1"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[0][2] = "2"; //Posicao

            abyssesAndTools[1][0] = "1"; //Abismo
            abyssesAndTools[1][1] = "1"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[1][2] = "4"; //Posicao

            abyssesAndTools[2][0] = "1"; //
            abyssesAndTools[2][1] = "5"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[2][2] = "10"; //Posicao

            abyssesAndTools[3][0] = "1"; //Abismo
            abyssesAndTools[3][1] = "0"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[3][2] = "19"; //Posicao






            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 2 jogadores (Deve pôr por ordem pelo ID mais baixo)
            String[][] playerInfo = new String[2][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";



            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,20,abyssesAndTools);

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

        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }



    }

    @Test(timeout = 100)
    public void test19_ferramentasAbismos_IniciarJogo_2Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | A|  |  |  | A|  | A|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */
        try {
//Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[4][3];


            //Falta verificar se for uma string ou null

            abyssesAndTools[0][0] = "1"; //Abismo
            abyssesAndTools[0][1] = "1"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[0][2] = "3"; //Posicao

            abyssesAndTools[1][0] = "1"; //Abismo
            abyssesAndTools[1][1] = "1"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[1][2] = "4"; //Posicao

            abyssesAndTools[2][0] = "1"; //
            abyssesAndTools[2][1] = "5"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[2][2] = "10"; //Posicao

            abyssesAndTools[3][0] = "1"; //Abismo
            abyssesAndTools[3][1] = "0"; //Erro de sintaxe (O programador recua 1 casa)
            abyssesAndTools[3][2] = "19"; //Posicao






            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 2 jogadores (Deve pôr por ordem pelo ID mais baixo)
            String[][] playerInfo = new String[2][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";




            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,20,abyssesAndTools);
        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }




    }


    @Test(timeout = 100)
    public void test20_jogoNormal() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | A|  |  |  | A|  | A|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */
        try {
//Criar o abismo (Erro de sintaxe)
            String[][] abyssesAndTools = new String[26][3];


            //Falta verificar se for uma string ou null

            abyssesAndTools[0][0] = "0"; //Abismo
            abyssesAndTools[0][1] = "0"; //Erro de sintaxe
            abyssesAndTools[0][2] = "3"; //Posicao

            abyssesAndTools[1][0] = "0"; //Abismo
            abyssesAndTools[1][1] = "1"; //Erro de lógica
            abyssesAndTools[1][2] = "4"; //Posicao

            abyssesAndTools[2][0] = "0"; //Abismo
            abyssesAndTools[2][1] = "2"; //Exception
            abyssesAndTools[2][2] = "5"; //Posicao

            abyssesAndTools[3][0] = "0"; //Abismo
            abyssesAndTools[3][1] = "3"; //File Not Found Exception
            abyssesAndTools[3][2] = "6"; //Posicao

            abyssesAndTools[4][0] = "0"; //Abismo
            abyssesAndTools[4][1] = "4"; //Crash
            abyssesAndTools[4][2] = "7"; //Posicao

            abyssesAndTools[5][0] = "0"; //Abismo
            abyssesAndTools[5][1] = "5"; //Duplicated Code
            abyssesAndTools[5][2] = "8"; //Posicao

            abyssesAndTools[6][0] = "0"; //Abismo
            abyssesAndTools[6][1] = "6"; //Efeitos secundários
            abyssesAndTools[6][2] = "9"; //Posicao

            abyssesAndTools[7][0] = "0"; //Abismo
            abyssesAndTools[7][1] = "7"; //Blue Screen of Death
            abyssesAndTools[7][2] = "10"; //Posicao

            abyssesAndTools[8][0] = "0"; //Abismo
            abyssesAndTools[8][1] = "6"; //Ciclo infinito
            abyssesAndTools[8][2] = "11"; //Posicao

            abyssesAndTools[9][0] = "0"; //Abismo
            abyssesAndTools[9][1] = "7"; //Segmentation Fault
            abyssesAndTools[9][2] = "12"; //Posicao


            abyssesAndTools[10][0] = "1"; //Ferramenta
            abyssesAndTools[10][1] = "0"; //Herança
            abyssesAndTools[10][2] = "18"; //Posicao

            abyssesAndTools[11][0] = "1"; //Ferramenta
            abyssesAndTools[11][1] = "1"; //Programação Funcional
            abyssesAndTools[11][2] = "19"; //Posicao

            abyssesAndTools[12][0] = "1"; //Ferramenta
            abyssesAndTools[12][1] = "2"; //Testes unitários
            abyssesAndTools[12][2] = "20"; //Posicao

            abyssesAndTools[13][0] = "1"; //Ferramenta
            abyssesAndTools[13][1] = "3"; //Tratamento de Excepções
            abyssesAndTools[13][2] = "21"; //Posicao

            abyssesAndTools[14][0] = "1"; //Ferramenta
            abyssesAndTools[14][1] = "4"; //IDE
            abyssesAndTools[14][2] = "22"; //Posicao

            abyssesAndTools[15][0] = "1"; //Ferramenta
            abyssesAndTools[15][1] = "5"; //Ajuda Do Professor
            abyssesAndTools[15][2] = "23"; //Posicao



            abyssesAndTools[16][0] = "0"; //Abismo
            abyssesAndTools[16][1] = "0"; //Erro de sintaxe
            abyssesAndTools[16][2] = "35"; //Posicao

            abyssesAndTools[17][0] = "0"; //Abismo
            abyssesAndTools[17][1] = "1"; //Erro de lógica
            abyssesAndTools[17][2] = "36"; //Posicao

            abyssesAndTools[18][0] = "0"; //Abismo
            abyssesAndTools[18][1] = "2"; //Exception
            abyssesAndTools[18][2] = "37"; //Posicao

            abyssesAndTools[19][0] = "0"; //Abismo
            abyssesAndTools[19][1] = "3"; //File Not Found Exception
            abyssesAndTools[19][2] = "38"; //Posicao

            abyssesAndTools[20][0] = "0"; //Abismo
            abyssesAndTools[20][1] = "4"; //Crash
            abyssesAndTools[20][2] = "39"; //Posicao

            abyssesAndTools[21][0] = "0"; //Abismo
            abyssesAndTools[21][1] = "5"; //Duplicated Code
            abyssesAndTools[21][2] = "40"; //Posicao

            abyssesAndTools[22][0] = "0"; //Abismo
            abyssesAndTools[22][1] = "6"; //Efeitos secundários
            abyssesAndTools[22][2] = "41"; //Posicao

            abyssesAndTools[23][0] = "0"; //Abismo
            abyssesAndTools[23][1] = "7"; //Blue Screen of Death
            abyssesAndTools[23][2] = "42"; //Posicao

            abyssesAndTools[24][0] = "0"; //Abismo
            abyssesAndTools[24][1] = "6"; //Ciclo infinito
            abyssesAndTools[24][2] = "43"; //Posicao

            abyssesAndTools[25][0] = "0"; //Abismo
            abyssesAndTools[25][1] = "7"; //Segmentation Fault
            abyssesAndTools[25][2] = "44"; //Posicao






            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 2 jogadores (Deve pôr por ordem pelo ID mais baixo)
            String[][] playerInfo = new String[4][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";

            playerInfo[2][0] = "50";
            playerInfo[2][1] = "Rui";
            playerInfo[2][2] = "Kotlin";
            playerInfo[2][3] = "Green";

            playerInfo[3][0] = "10";
            playerInfo[3][1] = "Tiago";
            playerInfo[3][2] = "Java";
            playerInfo[3][3] = "Brown";




            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,45,abyssesAndTools);

            g1.moveCurrentPlayer(3);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(2);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(4);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(2);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(1);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(1);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(1);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(5);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(5);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(4);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(3);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(3);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(2);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(2);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(3);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(6);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(6);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(5);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(4);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(3);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(2);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(1);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(1);
            g1.reactToAbyssOrTool();

            g1.moveCurrentPlayer(2);
            g1.reactToAbyssOrTool();

            assertFalse("Deveria dar errado",g1.gameIsOver());
        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }




    }

    @Test(timeout = 100)
    public void test21_cores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | F|  | F|  |  |  | A|  | F|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */


        try {
            //Abismo = 0

            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 2 jogadores (Deve pôr por ordem pelo ID mais baixo)
            String[][] playerInfo = new String[2][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Pink";


            g1.createInitialBoard(playerInfo,20);
        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }

    }

    @Test(timeout = 100)
    public void test22_nrJogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | F|  | F|  |  |  | A|  | F|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */


        try {
            //Abismo = 0

            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 2 jogadores (Deve pôr por ordem pelo ID mais baixo)
            String[][] playerInfo = new String[1][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";




            g1.createInitialBoard(playerInfo,20);
        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }

    }

    @Test(timeout = 100)
    public void test23_playerNull() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | F|  | F|  |  |  | A|  | F|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */


        try {
            //Abismo = 0

            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 2 jogadores (Deve pôr por ordem pelo ID mais baixo)
            String[][] playerInfo = null;







            g1.createInitialBoard(playerInfo,20);
        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }

    }


    @Test(timeout = 100)
    public void test24_tamanhoCampo() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | F|  | F|  |  |  | A|  | F|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */


        try {
            //Abismo = 0

            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();



            String[][] playerInfo = new String[2][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";




            g1.createInitialBoard(playerInfo,2);
        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }

    }

    @Test(timeout = 100)
    public void test25_mesmaCor() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | F|  | F|  |  |  | A|  | F|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */


        try {
            //Abismo = 0

            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();



            String[][] playerInfo = new String[2][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Purple";




            g1.createInitialBoard(playerInfo,20);
        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }

    }


    @Test(timeout = 100)
    public void test26_mesmoNome() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | F|  | F|  |  |  | A|  | F|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */


        try {
            //Abismo = 0

            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();



            String[][] playerInfo = new String[2][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Rui";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";




            g1.createInitialBoard(playerInfo,20);
        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }

    }






    @Test(timeout = 1000)
    public void test27_JogoNormal_Heranca_DuplicatedCode() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | F|  | F|  |  |  | A|  | F|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */




        try {
//Abismo = 0
            String[][] abyssesAndTools = new String[7][3];



            abyssesAndTools[0][0] = "1"; //Ferramenta
            abyssesAndTools[0][1] = "0"; //Herança
            abyssesAndTools[0][2] = "3"; //Posicao

            abyssesAndTools[1][0] = "1"; //Ferramenta
            abyssesAndTools[1][1] = "0"; //Herança
            abyssesAndTools[1][2] = "5"; //Posicao

            abyssesAndTools[2][0] = "0"; //Abismo
            abyssesAndTools[2][1] = "5"; //Duplicated Code (O programador recua até à casa onde estava antes de chegar a esta casa.)
            abyssesAndTools[2][2] = "9"; //Posicao

            abyssesAndTools[3][0] = "1"; //Abismo
            abyssesAndTools[3][1] = "0"; //Herança
            abyssesAndTools[3][2] = "11"; //Posicao

            abyssesAndTools[4][0] = "0"; //Abismo
            abyssesAndTools[4][1] = "5"; //Duplicated Code
            abyssesAndTools[4][2] = "14"; //Posicao

            abyssesAndTools[5][0] = "0"; //Abismo
            abyssesAndTools[5][1] = "5"; //Duplicated Code
            abyssesAndTools[5][2] = "17"; //Posicao

            abyssesAndTools[6][0] = "0"; //Abismo
            abyssesAndTools[6][1] = "5"; //Duplicated Code
            abyssesAndTools[6][2] = "19"; //Posicao



            //Criar o objeto do GameManager
            GameManager g1 = new GameManager();


            //Criar 2 jogadores (Deve pôr por ordem pelo ID mais baixo)
            String[][] playerInfo = new String[2][4];


            playerInfo[0][0] = "30";
            playerInfo[0][1] = "Frederico";
            playerInfo[0][2] = "Kotlin";
            playerInfo[0][3] = "Purple";

            playerInfo[1][0] = "20";
            playerInfo[1][1] = "Pedro";
            playerInfo[1][2] = "Java";
            playerInfo[1][3] = "Blue";




            //Função que irá criar o campo com 20 posições
            g1.createInitialBoard(playerInfo,20,abyssesAndTools);

            //Pedro-1 ; Frederico-1

            //Pedro ganhou ferramenta
            g1.moveCurrentPlayer(2);
            g1.reactToAbyssOrTool();

            //Pedro-3 ; Frederico-1

            //Frederico ganhou ferramenta
            g1.moveCurrentPlayer(2);
            g1.reactToAbyssOrTool();

            //Pedro-3 ; Frederico-3


            g1.moveCurrentPlayer(2);
            g1.reactToAbyssOrTool();

            //Pedro-5 ; Frederico-3


            g1.moveCurrentPlayer(6);
            g1.reactToAbyssOrTool();

            System.out.println(g1.getPosicoes());

            //Pedro-5 ; Frederico-9


            g1.moveCurrentPlayer(6);
            g1.reactToAbyssOrTool();

            System.out.println(g1.getPosicoes());



/*
        Ferramenta - 3 ; 5 ; 11
        Abismo - 9 ; 14 ; 17 ; 19
         */


        }catch (InvalidInitialBoardException e) {
            System.out.println(e.getMessage());
            System.out.println(e.isInvalidAbyss());
            System.out.println(e.getTypeId());

        }




    }



}

