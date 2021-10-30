package pt.ulusofona.lp2.deisiGreatGame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class GameManager {
    static ArrayList<Programmer> players = new ArrayList<>();
    int turnos;
    int boardSize;
    static int currentPlayer;
    String imagem;
    int numeroJogadores;




    public GameManager() {
        this.turnos = 1;
        currentPlayer = 1;
    }

    /*Função que vai inicializar o jogo; onde vamos ver se está tudo em ordem para começar a jogar*/
    public boolean createInitialBoard(String[][] playerInfo, int boardSize) {
        System.out.println(boardSize);
        if (boardSize <= 0) {
            return false;
        }
        int totalJogadores = playerInfo.length;
        int calculoAux = 0;
        for (int i = 0; i < totalJogadores; i++) {
            for (int y = 0; y < 1; y++) {

                if (playerInfo[i][y] == null) {
                    if (i >= 2 && i <= 4) {
                        break;
                    } else {
                        return false;
                    }
                }
                calculoAux++;

            }
        }
        for (int i = 0; i < calculoAux; i++) {
            for (int y = 0; y < calculoAux; y++) {
                if (i == y) {
                    continue;
                } else {

                    if (playerInfo[i][0].equals(playerInfo[y][0]) || playerInfo[i][1].equals(playerInfo[y][1]) ||
                            playerInfo[i][3].equals(playerInfo[y][3])) {

                        return false;
                    }
                }
            }
        }


        if (calculoAux == 4) {
            Programmer jogador1 = new Programmer(Integer.parseInt(playerInfo[0][0]), playerInfo[0][1], playerInfo[0][2], ProgrammerColor.Purple);
            Programmer jogador2 = new Programmer(Integer.parseInt(playerInfo[1][0]), playerInfo[1][1], playerInfo[1][2], ProgrammerColor.Blue);
            Programmer jogador3 = new Programmer(Integer.parseInt(playerInfo[2][0]), playerInfo[2][1], playerInfo[2][2], ProgrammerColor.Green);
            Programmer jogador4 = new Programmer(Integer.parseInt(playerInfo[3][0]), playerInfo[3][1], playerInfo[3][2], ProgrammerColor.Brown);
            players.add(jogador1);
            players.add(jogador2);
            players.add(jogador3);
            players.add(jogador4);
            this.boardSize = boardSize;
            this.numeroJogadores = calculoAux;

        }
        else if (calculoAux == 3) {
            Programmer jogador1 = new Programmer(Integer.parseInt(playerInfo[0][0]), playerInfo[0][1], playerInfo[0][2], ProgrammerColor.Purple);
            Programmer jogador2 = new Programmer(Integer.parseInt(playerInfo[1][0]), playerInfo[1][1], playerInfo[1][2], ProgrammerColor.Blue);
            Programmer jogador3 = new Programmer(Integer.parseInt(playerInfo[2][0]), playerInfo[2][1], playerInfo[2][2], ProgrammerColor.Green);
            players.add(jogador1);
            players.add(jogador2);
            players.add(jogador3);
            this.boardSize = boardSize;
            this.numeroJogadores = calculoAux;

        }
        else if (calculoAux == 2) {
            Programmer jogador1 = new Programmer(Integer.parseInt(playerInfo[0][0]), playerInfo[0][1], playerInfo[0][2], ProgrammerColor.Purple);
            Programmer jogador2 = new Programmer(Integer.parseInt(playerInfo[1][0]), playerInfo[1][1], playerInfo[1][2], ProgrammerColor.Blue);
            players.add(jogador1);
            players.add(jogador2);
            this.boardSize = boardSize;
            this.numeroJogadores = calculoAux;
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
        if (players.isEmpty())
        {
            return null;
        }
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


    public boolean moveCurrentPlayer(int nrPositions) {
        int calculoAux;
        int outroAux = 0;

        if (nrPositions > 6 || nrPositions <= 0)
        {
            return false;
        }

        calculoAux = getCurrentPlayerID();

        for (Programmer player : players) {
            if (player.jogadorID.equals(calculoAux)) {
                if (player.posicao + nrPositions > this.boardSize)
                {

                    outroAux = player.posicao + nrPositions;
                    outroAux -= this.boardSize;

                    player.posicao = this.boardSize - outroAux;

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
            this.imagem = "glory.png";
        }
        else if(position == 1) {
            this.imagem = "partida.png";
        }
        else if (position > boardSize) {
            return null;
        }
        return null;
    }

    public JPanel getAuthorsPanel() {
        return null;
    }


    public ArrayList<String> getGameResults() {
        ArrayList<String> resultados = new ArrayList<String>();

        String primeiro = null;
        String segundo = null;
        String terceiro = null;
        String quarto = null;
        int calAuxPrimeiro=90;
        int calAuxSegundo=90;
        int calAuxTerceiro=90;
        int calAuxQuarto=90;
        int auxiliar = 0;
        int outroAux = 0;

        for (Programmer jogador: players) {
            if (jogador.posicao >= boardSize) {
                primeiro = jogador.nome;
            }
        }


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
            for (Programmer jogador: players) {
                if (!primeiro.equals(jogador.nome)){
                    segundo = jogador.nome;
                    calAuxPrimeiro = jogador.posicao;
                }
            }
            resultados.add(segundo + ' ' + calAuxPrimeiro);
        }

        if (numeroJogadores==3) {

            for (Programmer jogador : players) {
                if (Objects.equals(jogador,primeiro)) {
                    break;
                }
                else {
                    if (jogador.posicao < this.boardSize && auxiliar == 0){
                        segundo = jogador.nome;
                        calAuxSegundo = jogador.posicao;
                        auxiliar++;
                    }
                    else if (jogador.posicao < calAuxSegundo){
                        terceiro = jogador.nome;
                        calAuxTerceiro = jogador.posicao;
                    }
                }
            }
            resultados.add(segundo + ' ' + calAuxSegundo);
            resultados.add(terceiro + ' ' + calAuxTerceiro);
        }

        if (numeroJogadores==4) {

            for (Programmer jogador : players) {
                if (Objects.equals(jogador,primeiro)) {
                    break;
                }
                else {
                    if (jogador.posicao < this.boardSize && auxiliar == 0){
                        segundo = jogador.nome;
                        calAuxSegundo = jogador.posicao;
                        auxiliar++;
                    }
                    else if (auxiliar == 1 && outroAux == 0){
                        if (jogador.posicao < calAuxSegundo) {
                            terceiro = jogador.nome;
                            calAuxTerceiro = jogador.posicao;
                            outroAux= 30;
                        }
                        else {
                            terceiro = segundo;
                            calAuxTerceiro = calAuxSegundo;
                            segundo = jogador.nome;
                            calAuxSegundo = jogador.posicao;
                            outroAux = 30;
                        }
                    }
                }
                if (outroAux == 30) {
                    quarto = jogador.nome;
                    calAuxQuarto = jogador.posicao;

                }

            }

            if (calAuxQuarto > calAuxTerceiro || calAuxQuarto > calAuxSegundo)
            {
                if (calAuxQuarto > calAuxSegundo) {
                    resultados.add(quarto + ' ' + calAuxQuarto);
                    resultados.add(segundo + ' ' + calAuxSegundo);
                    resultados.add(terceiro + ' ' + calAuxTerceiro);
                }
                if (calAuxQuarto > calAuxTerceiro) {
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


    public boolean gameIsOver() {
        for (Programmer player : players) {
            if (player.posicao == boardSize) {
                getImagePng(boardSize);
                return true;
            }
        }
        return false;
    }






}


