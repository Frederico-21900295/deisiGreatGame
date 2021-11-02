package pt.ulusofona.lp2.deisiGreatGame;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestUtilizador {

    @Test(timeout = 1000)
    public void test000_createInitialBoard() {
        GameManager g1 = new GameManager();

        String[][] playerInfo = new String[4][4];
        
        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java";
        playerInfo[0][3] = "PURPLE";

        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Pedro";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "BLUE";

        playerInfo[2][0] = "3";
        playerInfo[2][1] = "Rui";
        playerInfo[2][2] = "Kotlin";
        playerInfo[2][3] = "GREEN";

        playerInfo[3][0] = "4";
        playerInfo[3][1] = "Joana";
        playerInfo[3][2] = "C";
        playerInfo[3][3] = "BROWN";
        assertTrue("Deve dar correto",g1.createInitialBoard(playerInfo,79));



        GameManager g2 = new GameManager();

        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java";
        playerInfo[0][3] = "PURPLE";

        playerInfo[1][0] = "1";
        playerInfo[1][1] = "Pedro";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "BLUE";

        playerInfo[2][0] = "3";
        playerInfo[2][1] = "Rui";
        playerInfo[2][2] = "Kotlin";
        playerInfo[2][3] = "GREEN";

        playerInfo[3][0] = "4";
        playerInfo[3][1] = "Joana";
        playerInfo[3][2] = "C";
        playerInfo[3][3] = "BROWN";

        assertFalse("Deveria dar false pois temos dois jogadores com o mesmo ID",g2.createInitialBoard(playerInfo,79));



        GameManager g3 = new GameManager();

        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java";
        playerInfo[0][3] = "PURPLE";

        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Pedro";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "BLUE";

        playerInfo[2][0] = "3";
        playerInfo[2][1] = null;
        playerInfo[2][2] = "Kotlin";
        playerInfo[2][3] = "GREEN";

        playerInfo[3][0] = "4";
        playerInfo[3][1] = "Joana";
        playerInfo[3][2] = "C";
        playerInfo[3][3] = "BROWN";

        assertFalse("Deveria dar false pois o nome do jogador não pode ser igual a null",g3.createInitialBoard(playerInfo,79));


        GameManager g4 = new GameManager();

        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java";
        playerInfo[0][3] = "PURPLE";

        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Pedro";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "BLUE";

        playerInfo[2][0] = "3";
        playerInfo[2][1] = "Rui";
        playerInfo[2][2] = "Kotlin";
        playerInfo[2][3] = "GREEN";

        playerInfo[3][0] = "4";
        playerInfo[3][1] = "Joana";
        playerInfo[3][2] = "C";
        playerInfo[3][3] = "Yellow";

        assertFalse("Deveria dar false pois nao pode haver cores diferentes" +
                "do azul , castanho, verde e roxo",g4.createInitialBoard(playerInfo,79));

        GameManager g5 = new GameManager();

        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java";
        playerInfo[0][3] = "PURPLE";


        assertFalse("Deveria dar false pois nao pode haver somente 1 jogador",
                g5.createInitialBoard(playerInfo,79));


        GameManager g6 = new GameManager();


        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java";
        playerInfo[0][3] = "PURPLE";

        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Pedro";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "BLUE";

        playerInfo[2][0] = "3";
        playerInfo[2][1] = "Rui";
        playerInfo[2][2] = "Kotlin";
        playerInfo[2][3] = "GREEN";

        playerInfo[3][0] = "4";
        playerInfo[3][1] = "";
        playerInfo[3][2] = "C";
        playerInfo[3][3] = "BROWN";
        assertFalse("Os programadores não podem ter o nome vazio",g6.createInitialBoard(playerInfo,79));




    }
}
