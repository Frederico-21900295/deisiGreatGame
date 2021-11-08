package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import javax.swing.JPanel;

public class GameManager {
    ArrayList<Programmer> players;
    int turnos;
    static int boardSize;
    int currentPlayer;
    String imagem;
    int numeroJogadores;


    public GameManager() { }

    public GameManager(int tamanho) {
        GameManager.boardSize = tamanho;
    }



    /*Função que vai inicializar o jogo; onde vamos ver se está tudo em ordem para começar a jogar*/
    /*Do que estive a ver esta função ja esta com todas as exceções*/
    public boolean createInitialBoard(String[][] playerInfo, int boardSize) {

        //Se o campo for menor que 0 retorna false
        if (boardSize <= 1) {
            return false;
        }

        //Necessário pois caso o jogo seja reiniciado é preciso criar uma Lista nova com os dados iniciais
        players = new ArrayList<>();


        int aux_cores;
        int totalJogadores = playerInfo.length;

        int aux=0;



        // Usado para verificar mais tarde se as cores são diferentes destas 4 cores
        String [] corJogadores = new String[4];
        corJogadores[0] = "Purple";
        corJogadores[1] = "Blue";
        corJogadores[2] = "Green";
        corJogadores[3] = "Brown";




        /*
         Verificar o número de jogadores e esse valor é colocado na variável totalJogadores e caso seja menor que 2 ou
         maior que 4 retorna false
         */

        System.out.println(totalJogadores);
        for (int i = 0; i < totalJogadores; i++) {
            aux++;
            for (int y = 0; y < 1; y++) {
                if (playerInfo[i][y] == null || playerInfo[i][y].isEmpty()) {
                        aux--;
                        break;
                    }
                }

        }
        totalJogadores = aux;

        System.out.println(totalJogadores);
        if (totalJogadores <= 1 || totalJogadores > 4)
        {
            return false;
        }

        /*
         Verificamos jogador a jogador caso a cor difira das 4 outras cores a variável aux_cores fica com o
         valor 4 e retorna false. Caso esteja a variável aux_cores volta a ficar igual a 0 e volta a fazer a verificação
         */
        for (int i = 0; i < totalJogadores;i++) {
            aux_cores = 0;
            for (int z = 0; z < 4; z++) {
                if (!playerInfo[i][3].equals(corJogadores[z])) {
                    aux_cores++;
                }
                if (aux_cores == 4) {
                    return false;
                }
            }
        }




        /*
         Neste for é onde fazemos todas as validações pedidas pelo projeto; Validamos se os (nomes dos jogadores, o ID
         e a cor) são iguais ou se estão como null e caso seja retorna false
         */
        for (int i = 0; i < totalJogadores; i++) {
            for (int y = 0; y < totalJogadores; y++) {
                if (i != y) {
                    if ((playerInfo[i][1] == null) || (playerInfo[i][1].isEmpty())) {
                        return false;
                    } else {
                        if (playerInfo[i][0].equals(playerInfo[y][0])
                                || playerInfo[i][1].equals(playerInfo[y][1]) ||
                                playerInfo[i][3].equals(playerInfo[y][3])) {

                            return false;
                        }
                    }
                }

            }
        }

        //Estamos a criar o objeto Game Manager e inserir a tamanho do tabuleiro
        new GameManager(boardSize);

        this.turnos = 0;
        currentPlayer = 1;


        switch (totalJogadores) {
            case 2 -> {
                System.out.println(playerInfo[0][3]);
                System.out.println(playerInfo[1][3]);


                Programmer jogador1;
                jogador1 = new Programmer(Integer.parseInt(playerInfo[0][0]), playerInfo[0][1], playerInfo[0][2],ProgrammerColor.PURPLE);
                Programmer jogador2 = new Programmer(Integer.parseInt(playerInfo[1][0]), playerInfo[1][1], playerInfo[1][2],ProgrammerColor.BLUE);
                players.add(jogador1);
                players.add(jogador2);
                numeroJogadores = totalJogadores;
            }

            case 3 -> {
                Programmer jogador1 = new Programmer(Integer.parseInt(playerInfo[0][0]), playerInfo[0][1], playerInfo[0][2], ProgrammerColor.PURPLE);
                Programmer jogador2 = new Programmer(Integer.parseInt(playerInfo[1][0]), playerInfo[1][1], playerInfo[1][2], ProgrammerColor.BLUE);
                Programmer jogador3 = new Programmer(Integer.parseInt(playerInfo[2][0]), playerInfo[2][1], playerInfo[2][2], ProgrammerColor.GREEN);
                players.add(jogador1);
                players.add(jogador2);
                players.add(jogador3);
                numeroJogadores = totalJogadores;
            }
            case 4 -> {
                Programmer jogador1 = new Programmer(Integer.parseInt(playerInfo[0][0]), playerInfo[0][1], playerInfo[0][2], ProgrammerColor.PURPLE);
                Programmer jogador2 = new Programmer(Integer.parseInt(playerInfo[1][0]), playerInfo[1][1], playerInfo[1][2], ProgrammerColor.BLUE);
                Programmer jogador3 = new Programmer(Integer.parseInt(playerInfo[2][0]), playerInfo[2][1], playerInfo[2][2], ProgrammerColor.GREEN);
                Programmer jogador4 = new Programmer(Integer.parseInt(playerInfo[3][0]), playerInfo[3][1], playerInfo[3][2], ProgrammerColor.BROWN);
                players.add(jogador1);
                players.add(jogador2);
                players.add(jogador3);
                players.add(jogador4);
                numeroJogadores = totalJogadores;
            }


        }



        return true;
    }


    /*Função que vai imprimir todos os jogadores*/
    public ArrayList<Programmer> getProgrammers(){
        return players;
    }

    /*Função que vai imprimir que estão na posição X */
    public ArrayList<Programmer> getProgrammers(int position) {
        int auxiliar = 0;
        ArrayList<Programmer> jogadores = new ArrayList<>();
        for (Programmer j : players) {
            if (j.posicao == position) {
                jogadores.add(j);
                auxiliar++;
            }
        }

        if (auxiliar > 0) {
            return jogadores;
        }
        else {
            return null;
        }


    }


    /*Função que vai imprimir o jogador que tem de jogar*/
    public int getCurrentPlayerID() {
        for (Programmer player : players) {
            if (player.jogadorID.equals(currentPlayer)) {
                return player.jogadorID;
            }
        }
        return 0;
    }


    /*Função que vai movimentar os jogadores */
    public boolean moveCurrentPlayer(int nrPositions) {

        int id;
        int outroAux;

        if (nrPositions > 6 || nrPositions <= 0)
        {
            return false;
        }

        id = getCurrentPlayerID();
        ArrayList<Programmer> jogadores  = getProgrammers();


        for (Programmer player : jogadores) {
            if (player.jogadorID.equals(id)) {
                if (player.posicao + nrPositions > GameManager.boardSize)
                {

                    outroAux = player.posicao + nrPositions;
                    outroAux -= GameManager.boardSize;

                    player.posicao = GameManager.boardSize - outroAux;

                }
                else {
                    player.posicao += nrPositions;
                    gameIsOver();
                }
                turnos++;
                if (currentPlayer == numeroJogadores) {
                    currentPlayer = 1;
                }
                else {
                    currentPlayer++;
                }
                return true;
            }
        }


        return false;
    }



    public String getImagePng(int position) {
        if (position <= GameManager.boardSize && position > 0) {
            if (position == boardSize) {
                return this.imagem = "glory.png";
            } else if (position == 1) {
                return this.imagem = "glory.png";

            }
        }
        return null;
    }


    public JPanel getAuthorsPanel() {
        return null;
    }


    // Função que vai disponibilizar os resultados do jogo com o output desejado pelo projeto
    public ArrayList<String> getGameResults() {
        ArrayList<String> resultados = new ArrayList<>();

        //Usado para guardar os nomes dos jogadores
        String primeiro = "";
        String segundo = "";
        String terceiro = "";
        String quarto = "";

        //Usado para guardar as posições dos jogadores
        int calAuxPrimeiro=90;
        int calAuxSegundo=90;
        int calAuxTerceiro=90;
        int calAuxQuarto=90;


        int auxiliar = 0;
        int outroAux = 0;

        ArrayList<Programmer> jogadores;
        jogadores = getProgrammers();

        // O primeiro é o jogador que está na última casa do tabuleiro
        for (Programmer jogador: jogadores) {
            if (jogador.posicao == GameManager.boardSize) {
                primeiro = jogador.nome;
            }
        }

        //Só entra aqui caso já tenha sido atribuído o primeiro lugar; caso não tenha retorna uma lista vazia
        if ((!primeiro.isEmpty())) {
            resultados.add("O GRANDE JOGO DO DEISI");
            resultados.add("");
            resultados.add("NR. DE TURNOS ");
            resultados.add(String.valueOf(turnos));
            resultados.add("");
            resultados.add("VENCEDOR ");
            resultados.add(primeiro);
            resultados.add("");
            resultados.add("Restantes");


            //Caso só haja 2 jogadores só temos de inserir na variável segundo, pois o que está em primeiro foi feito antes
            if (numeroJogadores == 2) {
                for (Programmer jogador : jogadores) {
                    if (!jogador.nome.equals(primeiro)) {
                        segundo = jogador.nome;
                        calAuxPrimeiro = jogador.posicao;
                    }
                }
                resultados.add(segundo + ' ' + calAuxPrimeiro);
            }
            /*
             Caso haja 3 jogadores. O primeiro lugar ja foi feito no início.
             Logo, percorremos a lista de jogadores
             */            else if (numeroJogadores == 3) {

                for (Programmer jogador : jogadores) {
                    //Se o jogador for igual ao que está na variável primeiro passa para o próximo
                    if (jogador.nome.equals(primeiro)) {
                        continue;
                    } else if (auxiliar == 0) {
                        segundo = jogador.nome;
                        calAuxSegundo = jogador.posicao;
                        auxiliar = 30;
                    }

                /*
                Verifica se o segundo ja tem alguma inserida caso tenha vai verificar a posição dele com a do
                jogador e caso a posição do segundo seja menor troca
                 */
                    if (!segundo.isEmpty()) {
                        if (jogador.posicao < calAuxSegundo) {
                            terceiro = jogador.nome;
                            calAuxTerceiro = jogador.posicao;
                        } else {
                            terceiro = segundo;
                            calAuxTerceiro = calAuxSegundo;
                            segundo = jogador.nome;
                            calAuxSegundo = jogador.posicao;
                        }
                    }

                }

                resultados.add(segundo + ' ' + calAuxSegundo);
                resultados.add(terceiro + ' ' + calAuxTerceiro);
            }


            if (numeroJogadores == 4) {

                for (Programmer jogador : jogadores) {

                    //Se o jogador for igual ao que está na variável primeiro passa para o próximo
                    if (jogador.nome.equals(primeiro)) {
                        continue;
                    } else {
                        // O segundo jogador a ser lido é posto logo no segundo lugar
                        if (jogador.posicao < GameManager.boardSize && auxiliar == 0) {
                            segundo = jogador.nome;
                            calAuxSegundo = jogador.posicao;
                            auxiliar++;
                        }

                    /*
                     Só chegamos aqui quando estivermos a ver o terceiro jogador.
                     Verificamos se a posição deste é maior que o da posição que ja colocamos em segundo, e caso seja
                     trocamos (o que está em segundo passa para terceiro).
                     E usamos uma variável auxiliar para não voltarmos a entrar neste if; e assim entrarmos
                     logo no próximo if
                     */
                        else if (auxiliar == 1 && outroAux == 0) {
                            outroAux = 30;
                            if (jogador.posicao < calAuxSegundo) {
                                terceiro = jogador.nome;
                                calAuxTerceiro = jogador.posicao;
                            } else {
                                terceiro = segundo;
                                calAuxTerceiro = calAuxSegundo;
                                segundo = jogador.nome;
                                calAuxSegundo = jogador.posicao;
                            }
                        }
                    }
                    //Colocamos o 4 jogador a ser lido na variável quarto
                    if (outroAux == 30) {
                        quarto = jogador.nome;
                        calAuxQuarto = jogador.posicao;
                    }

                }



                //Começamos por verificar se a posição é superior ao do que está em terceiro
                if (calAuxQuarto > calAuxTerceiro) {
                    //Verificamos se também é maior que a posição do segundo lugar
                    if (calAuxQuarto > calAuxSegundo) {
                        resultados.add(quarto + ' ' + calAuxQuarto);
                        resultados.add(segundo + ' ' + calAuxSegundo);
                        resultados.add(terceiro + ' ' + calAuxTerceiro);
                    } else {
                        resultados.add(segundo + ' ' + calAuxSegundo);
                        resultados.add(quarto + ' ' + calAuxQuarto);
                        resultados.add(terceiro + ' ' + calAuxTerceiro);
                    }
                } else {
                    resultados.add(segundo + ' ' + calAuxSegundo);
                    resultados.add(terceiro + ' ' + calAuxTerceiro);
                    resultados.add(quarto + ' ' + calAuxQuarto);
                }

            }
        }

        return resultados;
    }


    //Função que vai verificar se existe algum jogador na última casa do tabuleiro e caso haja o jogo acaba
    public boolean gameIsOver() {
        ArrayList<Programmer> jogadores = getProgrammers();

        for (Programmer player : jogadores) {
            if (player.posicao == boardSize) {
                return true;

            }
        }
        return false;
    }





}


