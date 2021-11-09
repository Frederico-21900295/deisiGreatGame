package pt.ulusofona.lp2.deisiGreatGame;
import org.junit.Test;


// Verificar Caso alguma destas regras não seja cumprida, então a função deve devolver false e o turno continua a ser do jogador actual. Em caso contrário, a função deve devolver true.
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestUtilizador {

    @Test(timeout = 1000)
    public void test000_createInitialBoard() {

        //1) Verificar se houver mais que 4 jogadores (done)
        //2) Verificar se houver menos que 2 jogadores (done)
        //3) Verificar com tudo correto (done)
        //4) Verificar se houver ID igual (done)
        //5) Verificar se houver um nome igual a null (done)
        //6) Verificar se houver um nome vazio (done)
        //7) Verificar o que acontece se dermos um valor à variável cor diferente de (Purple,Blue,Green,Brown) (done)
        //8) Verificar com 3 jogadores com tudo correto (done)
        //9) Verificar com 3 jogadores com null (done)
        //10) Verificar com 2 jogadores (done)
        //11) Verificar com 2 jogadores com null (done)

        String[][] playerInfo = new String[4][4];


        // 1 exemplo
        GameManager g1 = new GameManager();

        String[][] playerInfo5jogadores = new String[5][5];

        playerInfo5jogadores[0][0] = "1";
        playerInfo5jogadores[0][1] = "Frederico";
        playerInfo5jogadores[0][2] = "Java";
        playerInfo5jogadores[0][3] = "Purple";

        playerInfo5jogadores[1][0] = "2";
        playerInfo5jogadores[1][1] = "Pedro";
        playerInfo5jogadores[1][2] = "Java";
        playerInfo5jogadores[1][3] = "Blue";

        playerInfo5jogadores[2][0] = "3";
        playerInfo5jogadores[2][1] = "Rui";
        playerInfo5jogadores[2][2] = "Kotlin";
        playerInfo5jogadores[2][3] = "Green";

        playerInfo5jogadores[3][0] = "4";
        playerInfo5jogadores[3][1] = "Joana";
        playerInfo5jogadores[3][2] = "C";
        playerInfo5jogadores[3][3] = "Brown";

        playerInfo5jogadores[4][0] = "5";
        playerInfo5jogadores[4][1] = "Tiago";
        playerInfo5jogadores[4][2] = "C";
        playerInfo5jogadores[4][3] = "Brown";
        assertFalse("Deve dar incorreto", g1.createInitialBoard(playerInfo5jogadores, 79));


        // 2 exemplo
        GameManager g2 = new GameManager();

        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Java";
        playerInfo[0][3] = "Purple";
        assertFalse("Deveria dar false pois nao pode haver somente 1 jogador",
                g2.createInitialBoard(playerInfo,79));



        // 3 exemplo
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
        playerInfo[2][1] = "Rui";
        playerInfo[2][2] = "Kotlin";
        playerInfo[2][3] = "Green";

        playerInfo[3][0] = "4";
        playerInfo[3][1] = "Joana";
        playerInfo[3][2] = "C";
        playerInfo[3][3] = "Brown";
        assertTrue("Deve dar correto",g3.createInitialBoard(playerInfo,79));


        // 4 exemplo
        GameManager g4 = new GameManager();

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

        assertFalse("Deveria dar false pois existem jogadores com o mesmo ID",g4.createInitialBoard(playerInfo,79));


        // 5 exemplo
        GameManager g5 = new GameManager();

        playerInfo[0][0] = "1";
        playerInfo[0][1] = null;
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

        assertFalse("Deveria dar false pois o nome do jogador não pode ser igual a null",g5.createInitialBoard(playerInfo,79));

        // 6 exemplo
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


        // 7 exemplo
        GameManager g7 = new GameManager();

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
                "do azul , castanho, verde e roxo",g7.createInitialBoard(playerInfo,79));



        // 8 exemplo
        GameManager g8 = new GameManager();

        String[][] playerInfo3Jogadores = new String[4][4];


        playerInfo3Jogadores[0][0] = "1";
        playerInfo3Jogadores[0][1] = "Frederico";
        playerInfo3Jogadores[0][2] = "Java";
        playerInfo3Jogadores[0][3] = "Purple";

        playerInfo3Jogadores[1][0] = "2";
        playerInfo3Jogadores[1][1] = "Pedro";
        playerInfo3Jogadores[1][2] = "Java";
        playerInfo3Jogadores[1][3] = "Blue";

        playerInfo3Jogadores[2][0] = "3";
        playerInfo3Jogadores[2][1] = "Rui";
        playerInfo3Jogadores[2][2] = "Kotlin";
        playerInfo3Jogadores[2][3] = "Green";



        assertTrue("Deveria dar false pois nao pode haver cores diferentes",g8.createInitialBoard(playerInfo3Jogadores,79));


        // 8 exemplo
        GameManager g9 = new GameManager();

        playerInfo3Jogadores[0][0] = "1";
        playerInfo3Jogadores[0][1] = "Frederico";
        playerInfo3Jogadores[0][2] = "Java";
        playerInfo3Jogadores[0][3] = "Purple";

        playerInfo3Jogadores[1][0] = "2";
        playerInfo3Jogadores[1][1] = null;
        playerInfo3Jogadores[1][2] = "Java";
        playerInfo3Jogadores[1][3] = "Blue";

        playerInfo3Jogadores[2][0] = "3";
        playerInfo3Jogadores[2][1] = "Rui";
        playerInfo3Jogadores[2][2] = "Kotlin";
        playerInfo3Jogadores[2][3] = "Green";


        assertFalse("Não pode haver nomes com null 1",g9.createInitialBoard(playerInfo3Jogadores,79));


        // 10 exemplo
        GameManager g10 = new GameManager();

        String[][] playerInfo2Jogadores = new String[4][4];


        playerInfo2Jogadores[0][0] = "1";
        playerInfo2Jogadores[0][1] = "Frederico";
        playerInfo2Jogadores[0][2] = "Java";
        playerInfo2Jogadores[0][3] = "Purple";

        playerInfo2Jogadores[1][0] = "2";
        playerInfo2Jogadores[1][1] = "Pedro";
        playerInfo2Jogadores[1][2] = "Java";
        playerInfo2Jogadores[1][3] = "Blue";



        assertTrue("Deve funcionar",g10.createInitialBoard(playerInfo2Jogadores,79));


        // 11 exemplo
        GameManager g11 = new GameManager();

        playerInfo2Jogadores[0][0] = "1";
        playerInfo2Jogadores[0][1] = null;
        playerInfo2Jogadores[0][2] = "Java";
        playerInfo2Jogadores[0][3] = "Purple";

        playerInfo2Jogadores[1][0] = "2";
        playerInfo2Jogadores[1][1] = "Pedro";
        playerInfo2Jogadores[1][2] = "Java";
        playerInfo2Jogadores[1][3] = "Blue";



        assertFalse("Não pode haver nomes com null",g11.createInitialBoard(playerInfo2Jogadores,79));



    }

    @Test(timeout = 1000)
    public void test001_moveCurrentPlayer() {
        //Verificar se tudo correr bem
        //Verificar se for acima de 6 ou menor de 1
        //Verificar se (currentPosition + dados) é > que o tamanho do campo
        String[][] playerInfo = new String[4][4];

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
        playerInfo[3][3] = "Brown";

        assertTrue("Deve dar correto", g4.createInitialBoard(playerInfo, 79));




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
        System.out.println(g3.getGameResults());

        System.out.println(g3.getCurrentPlayerID());
        g3.moveCurrentPlayer(5);
        System.out.println(g3.getGameResults());
    }

    @Test(timeout = 1000)
    public void test003_Programmer() {

        GameManager g1 = new GameManager();

        String[][] playerInfo = new String[4][4];


        playerInfo[0][0] = "1";
        playerInfo[0][1] = "Frederico";
        playerInfo[0][2] = "Common Lisp; []PHP";
        playerInfo[0][3] = "Purple";

        playerInfo[1][0] = "2";
        playerInfo[1][1] = "Pedro";
        playerInfo[1][2] = "Common Lisp;[ PHP] ";
        playerInfo[1][3] = "Blue";

        assertTrue("Deve dar correto",g1.createInitialBoard(playerInfo,79));

        System.out.println(g1.getProgrammers());

    }


}
