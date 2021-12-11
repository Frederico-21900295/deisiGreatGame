package pt.ulusofona.lp2.deisiGreatGame;
import org.junit.Test;


import static org.junit.Assert.*;

//Já nao se associa a cor no player info tenho de fazer pelo ID...

public class TestUtilizador {

    @Test(timeout = 100)
    public void test001_Abismos_ErroSintaxe_2Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | A|  |  |  | A|  | A|  |  | A|  |  | A |  | A|  |
          1                                               17       20
         */

        //Criar o abismo (Erro de sintaxe)

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


        playerInfo[0][0] = "30";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Kotlin";
        playerInfo[0][3] = "Purple";

        playerInfo[1][0] = "60";
        playerInfo[1][1] = "Tiago";
        playerInfo[1][2] = "Kotlin";
        playerInfo[1][3] = "Green";






        //Função que irá criar o campo com 20 posições
        assertTrue("Deve dar correto",g1.createInitialBoard(playerInfo,20,abyssesAndTools));


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


    }

    @Test(timeout = 100)
    public void test002_Abismos_ErroLogica_3Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | A|  |  |  | A|  | A|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */

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
        assertTrue("Deve dar correto",g1.createInitialBoard(playerInfo,20,abyssesAndTools));


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

        System.out.println(g1.historico());


    }

    @Test(timeout = 100)
    public void test003_Abismos_Exception_4Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

         /*
        |  |  | A|  | A|  |  |  | A|  | A|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */

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
        assertTrue("Deve dar correto",g1.createInitialBoard(playerInfo,20,abyssesAndTools));


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

        System.out.println(g1.historico());
        System.out.println(g1.getGameResults());
        /*


        3 5 9 11 14 17 19

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

        System.out.println(g1.historico());


         */

    }

    @Test(timeout = 100)
    public void test004_Abismos_CicloInfinito_3Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | A|  |  |  | A|  | A|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */

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
        assertTrue("Deve dar correto",g1.createInitialBoard(playerInfo,20,abyssesAndTools));


        //Inicialmente
        //Rui 1 | Pedro 1 | Frederico 1

        System.out.println(g1.getProgrammers());

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

        System.out.println(g1.historico());
    }

    @Test(timeout = 100)
    public void test005_Abismos_Crash_4Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */

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
        assertTrue("Deve dar correto",g1.createInitialBoard(playerInfo,20,abyssesAndTools));


        //Inicialmente
        //Rui 1 | Pedro 1 | Frederico 1 | Rui 1

        System.out.println(g1.getProgrammers());



/*
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

        System.out.println(g1.historico());

 */


    }

    @Test(timeout = 100)
    public void test006_Abismos_Efeitossecundarios_3Jogadores() {
        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */

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
        assertTrue("Deve dar correto",g1.createInitialBoard(playerInfo,20,abyssesAndTools));


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

        System.out.println(g1.getHistorico());

        g1.moveCurrentPlayer(2);
        //Rui 19 | Pedro 14 | Frederico 9
        g1.reactToAbyssOrTool();
        //Rui 12 | Pedro 14 | Frederico 19


        //Verificar se tenho de apagar o historico as posicoes depois do voltar a atras


        System.out.println(g1.getProgrammers(false));





        //3 5 9 11 14 17 19


    }


    @Test(timeout = 100)
    public void test007_Abismos_BlueScreenofDeath_4Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */

        //Criar o abismo (Erro de sintaxe)
        String[][] abyssesAndTools = new String[4][3];

        abyssesAndTools[0][0] = "0"; //Abismo
        abyssesAndTools[0][1] = "7"; //Blue Screen of Death (Perdeu)
        abyssesAndTools[0][2] = "3"; //Posicao

        abyssesAndTools[1][0] = "0"; //Abismo
        abyssesAndTools[1][1] = "7"; //Blue Screen of Death (Perdeu)
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
        assertTrue("Deve dar correto",g1.createInitialBoard(playerInfo,20,abyssesAndTools));


        //Inicialmente
        //Rui 1 | Pedro 1 | Frederico 1 | Joana 1

        g1.moveCurrentPlayer(2);
        //Rui 3 | Pedro 1 | Frederico 1 | Joana 1
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 1 | Frederico 1 | Joana 1

        g1.moveCurrentPlayer(3);
        //Rui 3(Perdeu) | Pedro 4 | Frederico 1 | Joana 1
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 4 | Frederico 1 | Joana 1

        g1.moveCurrentPlayer(3);
        //Rui 3(Perdeu) | Pedro 4 | Frederico 4 | Joana 1
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 4 | Frederico 4 | Joana 1

        g1.moveCurrentPlayer(3);
        //Rui 3(Perdeu) | Pedro 4 | Frederico 4 | Joana 4
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 4 | Frederico 4 | Joana 4

        g1.moveCurrentPlayer(3);
        //Rui 3(Perdeu) | Pedro 7 | Frederico 4 | Joana 4
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 7 | Frederico 4 | Joana 4

        g1.moveCurrentPlayer(5);
        //Rui 3(Perdeu) | Pedro 7 | Frederico 9 | Joana 4
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 7 | Frederico 9(Perdeu) | Joana 4

        g1.moveCurrentPlayer(6);
        //Rui 3(Perdeu) | Pedro 7 | Frederico 9 | Joana 10
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 7 | Frederico 9(Perdeu) | Joana 10

        g1.moveCurrentPlayer(3);
        //Rui 3(Perdeu) | Pedro 10 | Frederico 9(Perdeu)  | Joana 10
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 10 | Frederico 9(Perdeu) | Joana 10

        g1.moveCurrentPlayer(5);
        //Rui 3(Perdeu) | Pedro 10 | Frederico 9(Perdeu)  | Joana 15
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 10 | Frederico 9(Perdeu) | Joana 15

        g1.moveCurrentPlayer(3);
        //Rui 3(Perdeu) | Pedro 13 | Frederico 9(Perdeu)  | Joana 15
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 13 | Frederico 9(Perdeu) | Joana 15

        g1.moveCurrentPlayer(4);
        //Rui 3(Perdeu) | Pedro 13 | Frederico 9(Perdeu)  | Joana 19
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 13 | Frederico 9(Perdeu) | Joana 19(Perdeu)

        System.out.println(g1.getProgrammers(true));
        System.out.println(g1.gameIsOver());
        System.out.println(g1.getGameResults());

    }



    @Test(timeout = 100)
    public void test020_Abismos_BlueScreenofDeath_2Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */

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
        assertTrue("Deve dar correto",g1.createInitialBoard(playerInfo,20,abyssesAndTools));


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




    }






    @Test(timeout = 100)
    public void test200_Ferrmentas_4Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | |  |  |  | A|  |  |  |  | |  |  | A |  | A|  |
          1                      9                      17       20
         */

        //Criar o abismo (Erro de sintaxe)
        String[][] abyssesAndTools = new String[4][3];

        abyssesAndTools[0][0] = "1"; //Abismo
        abyssesAndTools[0][1] = "2"; //Blue Screen of Death (Perdeu)
        abyssesAndTools[0][2] = "3"; //Posicao

        abyssesAndTools[1][0] = "1"; //Abismo
        abyssesAndTools[1][1] = "2"; //Blue Screen of Death (Perdeu)
        abyssesAndTools[1][2] = "9"; //Posicao

        abyssesAndTools[2][0] = "1"; //Abismo
        abyssesAndTools[2][1] = "2"; //Blue Screen of Death (Perdeu)
        abyssesAndTools[2][2] = "17"; //Posicao

        abyssesAndTools[3][0] = "1"; //Abismo
        abyssesAndTools[3][1] = "2"; //Blue Screen of Death (Perdeu)
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
        assertTrue("Deve dar correto",g1.createInitialBoard(playerInfo,20,abyssesAndTools));


        //Inicialmente
        //Rui 1 | Pedro 1 | Frederico 1 | Joana 1

        g1.moveCurrentPlayer(2);
        //Rui 3 | Pedro 1 | Frederico 1 | Joana 1
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 1 | Frederico 1 | Joana 1

        g1.moveCurrentPlayer(3);
        //Rui 3(Perdeu) | Pedro 4 | Frederico 1 | Joana 1
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 4 | Frederico 1 | Joana 1

        g1.moveCurrentPlayer(3);
        //Rui 3(Perdeu) | Pedro 4 | Frederico 4 | Joana 1
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 4 | Frederico 4 | Joana 1

        g1.moveCurrentPlayer(3);
        //Rui 3(Perdeu) | Pedro 4 | Frederico 4 | Joana 4
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 4 | Frederico 4 | Joana 4

        g1.moveCurrentPlayer(3);
        //Rui 3(Perdeu) | Pedro 7 | Frederico 4 | Joana 4
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 7 | Frederico 4 | Joana 4

        g1.moveCurrentPlayer(5);
        //Rui 3(Perdeu) | Pedro 7 | Frederico 9 | Joana 4
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 7 | Frederico 9(Perdeu) | Joana 4



        g1.moveCurrentPlayer(6);
        //Rui 3(Perdeu) | Pedro 7 | Frederico 9 | Joana 10
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 7 | Frederico 9(Perdeu) | Joana 10

        g1.moveCurrentPlayer(3);
        //Rui 3(Perdeu) | Pedro 10 | Frederico 9(Perdeu)  | Joana 10
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 10 | Frederico 9(Perdeu) | Joana 10

        g1.moveCurrentPlayer(5);
        //Rui 3(Perdeu) | Pedro 10 | Frederico 9(Perdeu)  | Joana 15
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 10 | Frederico 9(Perdeu) | Joana 15

        g1.moveCurrentPlayer(3);
        //Rui 3(Perdeu) | Pedro 13 | Frederico 9(Perdeu)  | Joana 15
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 13 | Frederico 9(Perdeu) | Joana 15

        g1.moveCurrentPlayer(4);
        //Rui 3(Perdeu) | Pedro 13 | Frederico 9(Perdeu)  | Joana 19
        g1.reactToAbyssOrTool();
        //Rui 3(Perdeu) | Pedro 13 | Frederico 9(Perdeu) | Joana 19(Perdeu)

        System.out.println(g1.getProgrammers(false));
        System.out.println(g1.gameIsOver());

    }












    @Test(timeout = 100)
    public void test11_FerramentasAbismos_IniciarJogo_2Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | A|  |  |  | A|  | A|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */

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


        System.out.println(g1.createInitialBoard(playerInfo,20,abyssesAndTools));

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



    }

    @Test(timeout = 100)
    public void test14_FerramentasAbismos_IniciarJogo_2Jogadores() {

        //Campo c/ 20 posições e 2 jogadores

        /*
        |  |  | A|  | A|  |  |  | A|  | A|  |  | A|  |  | A|  | A|  |
          1                                              17       20
         */

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
        assertTrue("Deve dar correto",g1.createInitialBoard(playerInfo,20,abyssesAndTools));

        System.out.println(g1.getTitle(3));



    }


}
