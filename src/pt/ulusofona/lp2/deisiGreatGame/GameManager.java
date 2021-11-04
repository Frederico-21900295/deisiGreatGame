package pt.ulusofona.lp2.deisiGreatGame;

import javax.swing.*;
import java.util.ArrayList;



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
    public boolean createInitialBoard(String[][] playerInfo, int boardSize) {

        if (boardSize <= 0) {
            return false;
        }

        players = new ArrayList<>();


        int aux_cores;
        int totalJogadores = playerInfo.length;



        String [] corJogadores = new String[4];
        corJogadores[0] = "Purple";
        corJogadores[1] = "Blue";
        corJogadores[2] = "Green";
        corJogadores[3] = "Brown";


        for (int i = 0; i < totalJogadores; i++) {
            for (int y = 0; y < 1; y++) {
                if (playerInfo[i][y] == null) {
                    if (i >= 2 && i <= 4) {
                        totalJogadores = i;
                        break;
                    } else {
                        return false;
                    }
                }

            }
        }



        for (int i = 0; i < totalJogadores;i++) {
            aux_cores = 0;
            for (int z = 0; z < 4; z++)
                if (!playerInfo[i][3].equals(corJogadores[z])) {
                    aux_cores++;
                }
            if (aux_cores==4) {
                return false;
            }
        }

        for (int i = 0; i < totalJogadores; i++) {
            for (int y = 0; y < totalJogadores; y++) {
                if (i == y) {
                    break;
                }
                else if ((playerInfo[i][1] == null ) || playerInfo[i][1].isEmpty()) {
                    return false;
                }

                else {
                    if (playerInfo[i][0].equals(playerInfo[y][0])
                            || playerInfo[i][1].equals(playerInfo[y][1]) ||
                            playerInfo[i][3].equals(playerInfo[y][3])) {

                        return false;
                    }
                }
            }
        }

        new GameManager(boardSize);
        this.turnos = 0;
        currentPlayer = 1;


        if (totalJogadores == 4) {
            Programmer jogador1 = new Programmer(Integer.parseInt(playerInfo[0][0]), playerInfo[0][1], playerInfo[0][2], ProgrammerColor.Purple);
            Programmer jogador2 = new Programmer(Integer.parseInt(playerInfo[1][0]), playerInfo[1][1], playerInfo[1][2], ProgrammerColor.Blue);
            Programmer jogador3 = new Programmer(Integer.parseInt(playerInfo[2][0]), playerInfo[2][1], playerInfo[2][2], ProgrammerColor.Green);
            Programmer jogador4 = new Programmer(Integer.parseInt(playerInfo[3][0]), playerInfo[3][1], playerInfo[3][2], ProgrammerColor.Brown);
            players.add(jogador1);
            players.add(jogador2);
            players.add(jogador3);
            players.add(jogador4);
            numeroJogadores = totalJogadores;
        }

        else if (totalJogadores == 3) {
            Programmer jogador1 = new Programmer(Integer.parseInt(playerInfo[0][0]), playerInfo[0][1], playerInfo[0][2], ProgrammerColor.Purple);
            Programmer jogador2 = new Programmer(Integer.parseInt(playerInfo[1][0]), playerInfo[1][1], playerInfo[1][2], ProgrammerColor.Blue);
            Programmer jogador3 = new Programmer(Integer.parseInt(playerInfo[2][0]), playerInfo[2][1], playerInfo[2][2], ProgrammerColor.Green);
            players.add(jogador1);
            players.add(jogador2);
            players.add(jogador3);
            numeroJogadores = totalJogadores;
        }
        else if (totalJogadores == 2) {
            Programmer jogador1 = new Programmer(Integer.parseInt(playerInfo[0][0]), playerInfo[0][1], playerInfo[0][2], ProgrammerColor.Purple);
            Programmer jogador2 = new Programmer(Integer.parseInt(playerInfo[1][0]), playerInfo[1][1], playerInfo[1][2], ProgrammerColor.Blue);
            players.add(jogador1);
            players.add(jogador2);
            numeroJogadores = totalJogadores;
        }

        return true;
    }


    /*Funçao que vai imprimir todos os jogadores*/
    public ArrayList<Programmer> getProgrammers(){
        return players;
    }

    /*Função que vai imprimir que estao na posição X */
    public ArrayList<Programmer> getProgrammers(int position) {
        ArrayList<Programmer> jogadores = new ArrayList<>();
        for (Programmer j : players) {
            if (j.posicao == position) {
                jogadores.add(j);
            }
        }


        return jogadores;
    }


    /*Funçao que vai imprimir o jogador que tem de jogar*/
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

        int calculoAux;
        int outroAux;

        if (nrPositions > 6 || nrPositions <= 0)
        {
            return false;
        }

        calculoAux = getCurrentPlayerID();
        ArrayList<Programmer> jogadores;
        jogadores = getProgrammers();


        for (Programmer player : jogadores) {
            if (player.posicao > GameManager.boardSize)
            {
                return false;
            }

            if (player.jogadorID.equals(calculoAux)) {
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
        if (position == boardSize) {
            return this.imagem = "glory.png";
        }
        /*
        else if(position == 1) {
            return this.imagem = "glory.png";
        }*/
        else if (position > boardSize) {
            return null;
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
        String primeiro = null;
        String segundo = null;
        String terceiro = null;
        String quarto = null;

        //Usado para guardar as posições dos jogadores
        int calAuxPrimeiro=90;
        int calAuxSegundo=90;
        int calAuxTerceiro=90;
        int calAuxQuarto=90;


        int auxiliar = 0;
        int outroAux = 0;

        ArrayList<Programmer> jogadores;
        jogadores = getProgrammers();

        for (Programmer jogador: jogadores) {
            if (jogador.posicao >= GameManager.boardSize) {
                primeiro = jogador.nome;
            }
        }

        System.out.println("Numero de jogadores" + numeroJogadores);

        resultados.add("O GRANDE JOGO DO DEISI");
        resultados.add("");
        resultados.add("");
        resultados.add("NR. DE TURNOS ");
        resultados.add(String.valueOf(turnos));
        resultados.add("");
        resultados.add("VENCEDOR ");
        resultados.add(primeiro);
        resultados.add("");
        resultados.add("Restantes");

        if (numeroJogadores==2) {
            for (Programmer jogador: jogadores) {
                if (!jogador.nome.equals(primeiro)){
                    segundo = jogador.nome;
                    calAuxPrimeiro = jogador.posicao;
                }
            }
            resultados.add(segundo + ' ' + calAuxPrimeiro);
        }



        if (numeroJogadores == 3) {

            for (Programmer jogador : jogadores) {
                if (jogador.nome.equals(primeiro));
                else {
                    if (auxiliar == 0){
                        segundo = jogador.nome;
                        calAuxSegundo = jogador.posicao;
                        auxiliar++;
                    }
                    else if (jogador.posicao < calAuxSegundo){
                        terceiro = jogador.nome;
                        calAuxTerceiro = jogador.posicao;
                    }
                    else {
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


        if (numeroJogadores==4) {

            for (Programmer jogador : jogadores) {

                if (jogador.nome.equals(primeiro));
                else {

                    if (jogador.posicao < GameManager.boardSize && auxiliar == 0){
                        segundo = jogador.nome;
                        calAuxSegundo = jogador.posicao;
                        auxiliar++;
                    }


                    else if (auxiliar == 1 && outroAux == 0){
                        outroAux= 30;
                        if (jogador.posicao < calAuxSegundo) {
                            terceiro = jogador.nome;
                            calAuxTerceiro = jogador.posicao;
                        }
                        else {
                            terceiro = segundo;
                            calAuxTerceiro = calAuxSegundo;
                            segundo = jogador.nome;
                            calAuxSegundo = jogador.posicao;
                        }
                    }
                }
                if (outroAux == 30) {
                    quarto = jogador.nome;
                    calAuxQuarto = jogador.posicao;
                }

            }

            if (calAuxQuarto > calAuxTerceiro)
            {
                //Verificamos se também é maior que a posição do segundo lugar
                if (calAuxQuarto > calAuxSegundo) {
                    resultados.add(quarto + ' ' + calAuxQuarto);
                    resultados.add(segundo + ' ' + calAuxSegundo);
                    resultados.add(terceiro + ' ' + calAuxTerceiro);
                }
                else {
                    resultados.add(segundo + ' ' + calAuxSegundo);
                    resultados.add(quarto + ' ' + calAuxQuarto);
                    resultados.add(terceiro + ' ' + calAuxTerceiro);
                }
            }
            else {
                resultados.add(segundo + ' ' + calAuxSegundo);
                resultados.add(terceiro + ' ' + calAuxTerceiro);
                resultados.add(quarto + ' ' + calAuxQuarto);
            }





        }

        return resultados;
    }


    //Função que vai verificar se existe algum jogador na última casa do tabuleiro e caso haja o jogo acaba
    public boolean gameIsOver() {
        ArrayList<Programmer> jogadores;
        jogadores = getProgrammers();

        for (Programmer player : jogadores) {
            if (player.posicao == boardSize) {
                return true;

            }
        }
        return false;
    }





}