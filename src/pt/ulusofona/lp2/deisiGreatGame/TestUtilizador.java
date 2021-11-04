package pt.ulusofona.lp2.deisiGreatGame;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestUtilizador {

    @Test(timeout = 1000)
    public void test000_createInitialBoard() {
        /* 1 exemplo*/
        GameManager g1 = new GameManager();

        String[][] playerInfo = new String[4][4];


        //Vem com ponto e virgula, tenho de desfazer e de seguida fazer a ordem alfabética
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java";
        playerInfo[0][3] = "Purple";

        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Pedro";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Blue";

        playerInfo[2][0] = "3";
        playerInfo[2][1] = "Rui";
        playerInfo[2][2] = "Kotlin";
        playerInfo[2][3] = "Green";

        playerInfo[3][0] = "4";
        playerInfo[3][1] = "Joana";
        playerInfo[3][2] = "C";
        playerInfo[3][3] = "Brown";
        assertTrue("Deve dar correto",g1.createInitialBoard(playerInfo,79));


        /* 2 exemplo*/
        GameManager g2 = new GameManager();

        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java";
        playerInfo[0][3] = "Purple";

        playerInfo[1][0] = "1";
        playerInfo[1][1] = "Pedro";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Blue";

        playerInfo[2][0] = "3";
        playerInfo[2][1] = "Rui";
        playerInfo[2][2] = "Kotlin";
        playerInfo[2][3] = "Green";

        playerInfo[3][0] = "4";
        playerInfo[3][1] = "Joana";
        playerInfo[3][2] = "C";
        playerInfo[3][3] = "Brown";

        assertFalse("Deveria dar false pois temos dois jogadores com o mesmo ID",g2.createInitialBoard(playerInfo,79));

        /* 3 exemplo*/

        GameManager g3 = new GameManager();

        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java";
        playerInfo[0][3] = "Purple";

        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Pedro";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Blue";

        playerInfo[2][0] = "3";
        playerInfo[2][1] = null;
        playerInfo[2][2] = "Kotlin";
        playerInfo[2][3] = "Green";

        playerInfo[3][0] = "4";
        playerInfo[3][1] = "Joana";
        playerInfo[3][2] = "C";
        playerInfo[3][3] = "Brown";

        assertFalse("Deveria dar false pois o nome do jogador não pode ser igual a null",g3.createInitialBoard(playerInfo,79));


        /* 4 exemplo*/
        GameManager g4 = new GameManager();

        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java";
        playerInfo[0][3] = "Purple";

        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Pedro";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Blue";

        playerInfo[2][0] = "3";
        playerInfo[2][1] = "Rui";
        playerInfo[2][2] = "Kotlin";
        playerInfo[2][3] = "Green";

        playerInfo[3][0] = "4";
        playerInfo[3][1] = "Joana";
        playerInfo[3][2] = "C";
        playerInfo[3][3] = "Yellow";

        assertFalse("Deveria dar false pois nao pode haver cores diferentes" +
                "do azul , castanho, verde e roxo",g4.createInitialBoard(playerInfo,79));


        /* 5 exemplo*/
        GameManager g5 = new GameManager();

        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java";
        playerInfo[0][3] = "Purple";


        assertFalse("Deveria dar false pois nao pode haver somente 1 jogador",
                g5.createInitialBoard(playerInfo,79));



        /* 6 exemplo*/
        GameManager g6 = new GameManager();


        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java";
        playerInfo[0][3] = "Purple";

        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Pedro";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Blue";

        playerInfo[2][0] = "3";
        playerInfo[2][1] = "Rui";
        playerInfo[2][2] = "Kotlin";
        playerInfo[2][3] = "Green";

        playerInfo[3][0] = "4";
        playerInfo[3][1] = "";
        playerInfo[3][2] = "C";
        playerInfo[3][3] = "Brown";

        assertFalse("Os programadores não podem ter o nome vazio",g6.createInitialBoard(playerInfo,79));




    }

    @Test(timeout = 1000)
    public void test001_moveCurrentPlayer() {
    }

    @Test(timeout = 1000)
    public void test002_gameResult() {
        GameManager g1 = new GameManager();

        String[][] playerInfo = new String[4][4];

        // 2 jogadores dá certo

        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java ; C ";
        playerInfo[0][3] = "Purple";

        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Pedro";
        playerInfo[1][2] = "Java ; Kotlin";
        playerInfo[1][3] = "Blue";

        assertTrue("Deveria dar correto",g1.createInitialBoard(playerInfo,10));
        System.out.println(g1.getProgrammers());
        System.out.println(g1.getCurrentPlayerID());
        g1.moveCurrentPlayer(4);
        System.out.println(g1.getCurrentPlayerID());
        g1.moveCurrentPlayer(4);
        System.out.println(g1.getCurrentPlayerID());
        g1.moveCurrentPlayer(4);
        System.out.println(g1.getCurrentPlayerID());
        g1.moveCurrentPlayer(5);
        System.out.println(g1.getGameResults());






        // 3 jogadores dá certo

        GameManager g2 = new GameManager();


        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java ; C ";
        playerInfo[0][3] = "Purple";

        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Pedro";
        playerInfo[1][2] = "Java ; Kotlin";
        playerInfo[1][3] = "Blue";

        playerInfo[2][0] = "3";
        playerInfo[2][1] = "Rui";
        playerInfo[2][2] = "Kotlin ; C";
        playerInfo[2][3] = "Green";



        assertTrue("Deveria dar correto",g2.createInitialBoard(playerInfo,10));
        System.out.println(g2.getProgrammers());
        System.out.println(g2.getCurrentPlayerID());
        g2.moveCurrentPlayer(4);
        System.out.println(g2.getCurrentPlayerID());
        g2.moveCurrentPlayer(4);
        System.out.println(g2.getCurrentPlayerID());
        g2.moveCurrentPlayer(4);
        System.out.println(g2.getCurrentPlayerID());
        g2.moveCurrentPlayer(3);
        System.out.println(g2.getCurrentPlayerID());
        g2.moveCurrentPlayer(4);
        System.out.println(g2.getCurrentPlayerID());
        g2.moveCurrentPlayer(5);
        System.out.println(g2.getGameResults());




        // 4 jogadores esta correto

        GameManager g3 = new GameManager();

        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java ; C ";
        playerInfo[0][3] = "Purple";

        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Pedro";
        playerInfo[1][2] = "Java ; Kotlin";
        playerInfo[1][3] = "Blue";

        playerInfo[2][0] = "3";
        playerInfo[2][1] = "Rui";
        playerInfo[2][2] = "Kotlin ; C";
        playerInfo[2][3] = "Green";

        playerInfo[3][0] = "4";
        playerInfo[3][1] = "Tiago";
        playerInfo[3][2] = "C";
        playerInfo[3][3] = "Brown";

        assertTrue("Deveria dar correto",g3.createInitialBoard(playerInfo,10));
        System.out.println(g3.getProgrammers());
        System.out.println(g3.getCurrentPlayerID());
        g3.moveCurrentPlayer(4);
        System.out.println(g3.getCurrentPlayerID());
        g3.moveCurrentPlayer(4);
        System.out.println(g3.getCurrentPlayerID());
        g3.moveCurrentPlayer(4);
        System.out.println(g3.getCurrentPlayerID());
        g3.moveCurrentPlayer(5);
        System.out.println(g3.getCurrentPlayerID());
        g3.moveCurrentPlayer(2);
        System.out.println(g3.getCurrentPlayerID());
        g3.moveCurrentPlayer(5);
        System.out.println(g3.getGameResults());
    }

    @Test(timeout = 1000)
    public void test003_Programmer() {
        //Vem com ponto e virgula, tenho de desfazer e de seguida fazer a ordem alfabética

        GameManager g1 = new GameManager();

        String[][] playerInfo = new String[4][4];

        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java ; C ; Kotlin";
        playerInfo[0][3] = "Purple";

        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Pedro";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Blue";

        assertTrue("Deve dar correto",g1.createInitialBoard(playerInfo,79));

        System.out.println(g1.getProgrammers());


    }


}
