package pt.ulusofona.lp2.deisiGreatGame;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.swing.*;


public class GameManager implements Serializable{
    static int dado;
    List <Programmer> players;
    List<CasaEfeito> casasComEfeito;
    static int turnos;
    static int boardSize;
    static int currentPlayer;
    String imagem;
    private int numeroJogadores;
    private List<Integer> posicoes; // Posicao



    public GameManager() { }

    public GameManager(int tamanho) {
        GameManager.boardSize = tamanho;
        turnos = 1;
        currentPlayer = 1;
    }

    public List<Integer> getPosicoes() {
        return this.posicoes;
    }


    public void colocarInformacao(int posicao ) {
        this.posicoes.add(posicao);
    }


    /*Função que vai inicializar o jogo; onde vamos ver se está tudo em ordem para começar a jogar*/
    /*Do que estive a ver esta função ja esta com todas as exceções*/
    public void createInitialBoard(String[][] playerInfo, int boardSize) throws InvalidInitialBoardException
    {

        //Se o campo for menor que 0 retorna false
        if (boardSize < 4) {
            throw new InvalidInitialBoardException("Tamanho do campo demasiado pequeno");
        }

        if (playerInfo == null){
            throw new InvalidInitialBoardException("Array playerInfo = null");

        }


        //Necessário pois caso o jogo seja reiniciado é preciso criar uma Lista nova com os dados iniciais


        int aux_cores;
        int totalJogadores = playerInfo.length;
        /*
         Verificar o número de jogadores e esse valor é colocado na variável totalJogadores e caso seja menor que 2 ou
         maior que 4 retorna false
         */
        if (totalJogadores <= 1 || totalJogadores > 4)
        {
            throw new InvalidInitialBoardException("Os numeros de jogadores não está entre 2 a 4");
        }


        // Usado para verificar mais tarde se as cores são diferentes destas 4 cores
        String [] corJogadores = new String[4];
        corJogadores[0] = "Purple";
        corJogadores[1] = "Blue";
        corJogadores[2] = "Green";
        corJogadores[3] = "Brown";

        /*
         Verificamos jogador a jogador caso a cor difira das 4 outras cores a variável aux_cores fica com o
         valor 4 e retorna false. Caso esteja a variável aux_cores volta a ficar igual a 0 e volta a fazer a verificação
         */



        for (String[] strings : playerInfo) {
            aux_cores = 0;
            for (int z = 0; z < 4; z++) {
                if (!strings[3].equals(corJogadores[z])) {
                    aux_cores++;
                }
                if (aux_cores == 4) {
                    throw new InvalidInitialBoardException("Uma das cores escolhidas não pertence à gama oferecida");
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
                        throw new InvalidInitialBoardException("O nome do jogador está vazio ou com o valor null");
                    } else {
                        if ((Objects.equals(playerInfo[i][0], playerInfo[y][0]))|| (playerInfo[i][1].equals(playerInfo[y][1])) ||
                                (playerInfo[i][3].equals(playerInfo[y][3]))) {
                            throw new InvalidInitialBoardException("Existem jogadores com a mesmo nome ou cor");
                        }
                    }
                }

            }
        }

        //Estamos a criar o objeto Game Manager e inserir a tamanho do tabuleiro
        new GameManager(boardSize);

        posicoes = new ArrayList<>();

        addJogadores(totalJogadores,playerInfo);



    }


    //Função para inicializar as ferramentas
    public void createInitialBoard(String[][] playerInfo, int worldSize, String[][] abyssesAndTools) throws InvalidInitialBoardException
    {

        casasComEfeito = new ArrayList<>();
        int aux = 0;
        int converterInt;
        if (abyssesAndTools != null) {
            //Verificar se existe algum erro andTool
            for (String[] andTool : abyssesAndTools) {
                aux++;
                for (int y = 1; y < 3; y++) {
                    if (!andTool[y].matches("[+-]?\\d*(\\.\\d+)?") || andTool[y].isEmpty()) {

                        throw new InvalidInitialBoardException("Verificar o que fazer");
                    }
                    converterInt = Integer.parseInt(andTool[y]);
                    if (andTool[0].equals("0")) {
                        if (((converterInt > 9 || converterInt < 0) && y == 1)) {

                            throw new InvalidInitialBoardException("ABISMO");
                        } else if (y == 2) {
                            if (converterInt < 1 || converterInt >= worldSize) {

                                throw new InvalidInitialBoardException("ABISMO", Integer.parseInt(andTool[1]));
                            }

                        }
                    } else if (andTool[0].equals("1")) {
                        if ((converterInt > 5 || converterInt < 0) && y == 1) {

                            throw new InvalidInitialBoardException("FERRAMENTA", converterInt);
                        } else if (y == 2) {
                            if (converterInt < 1 || converterInt >= worldSize) {

                                throw new InvalidInitialBoardException("FERRAMENTA", Integer.parseInt(andTool[1]));
                            }

                        }
                    } else {
                        throw new InvalidInitialBoardException("ID diferente de 0 ou 1");
                    }
                }
            }
            for (int i= 0; i < aux; i++){
                adicionarPremio(abyssesAndTools,i);
            }
        }




        posicoes = new ArrayList<>();


        //Criação do mapa com a informação de cada jogador
        createInitialBoard(playerInfo, worldSize);

    }


    /*Função que vai imprimir o jogador que tem de jogar*/
    public int getCurrentPlayerID() {
        int auxiliar = 1;
        for (Programmer player : players) {
            if (auxiliar == currentPlayer) {
                //System.out.println("Jogador a jogar : " + player.getId());
                return player.getId();
            }
            auxiliar++;
        }
        return 0;
    }


    public JPanel getAuthorsPanel() {
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("  Deisi Great Game");
        Font font = new Font("Courier", Font.BOLD,20);
        label.setFont(font);
        label.setForeground(Color.white);
        panel.setBackground(Color.darkGray);

        JTextArea textArea2 = new JTextArea(3, 4);
        textArea2.setBackground(Color.darkGray);
        textArea2.setEditable(false);



        JTextArea textArea = new JTextArea(1, 4);
        textArea.setBackground(Color.darkGray);
        textArea.setForeground(Color.white);
        textArea.setText("Trabalho realizado no âmbito da cadeira");
        textArea.setEditable(false);

        JTextArea textArea1 = new JTextArea(1, 4);
        textArea1.setBackground(Color.darkGray);
        textArea1.setForeground(Color.white);
        textArea1.setText("Linguagens de Programação II\n\n\n Frederico Azevedo - 21900295 \n Tiago Silva - 20076288");
        textArea1.setEditable(false);


        panel.add(label);
        panel.add(textArea2);

        panel.add(textArea);
        panel.add(textArea1);

        return panel;
    }


    //Função que vai verificar se existe algum jogador na última casa do tabuleiro e caso haja o jogo acaba
    public boolean gameIsOver() {
        int auxiliarNrJogadores = 0;
        List<Programmer> jogadores = getProgrammers();
        for (Programmer player : jogadores) {

            if (!player.getEmJogo()) {
                auxiliarNrJogadores++;
            }

            if (player.getPosicao() == boardSize) {
                return true;
            }



        }
        return auxiliarNrJogadores == numeroJogadores-1;
    }


    public String getImagePng(int position) {
        if (position <= GameManager.boardSize && position > 0) {
            if (position == boardSize) {
                return this.imagem = "glory.png";
            } else if (position == 1) {
                return this.imagem = "partida.png";

            }

            for (CasaEfeito premio : casasComEfeito) {
                if (position == premio.getPosicao()) {
                    return premio.getImage();
                }
            }
        }
        return null;
    }

    public String getTitle(int position) {
        for (CasaEfeito p : casasComEfeito) {
            if (p.getPosicao() == position) {
                return p.getTipo();
            }
        }
        return null;
    }

    public String getProgrammersInfo() {
        StringBuilder frase = new StringBuilder();
        ArrayList <String> ferramentas ;
        int x = 0;
        int quantidade = 0;
        for (Programmer jogador : players) {
            if (jogador.getEmJogo()) {
                if (jogador.getFerramentas().isEmpty()) {
                    frase.append(jogador.getName()).append(" : No tools");
                }
                else {
                    ferramentas = jogador.getFerramentas();
                    frase.append(jogador.getName()).append(" : ");
                    for (String f : ferramentas) {
                        if (x >= 1) {
                            frase.append(";").append(f);
                        } else {
                            frase.append(f);
                        }
                        x++;

                    }

                }
                if (quantidade != players.size()-1) {
                    frase.append(" | ");

                }

            }
            x=0;
            quantidade++;

        }
        return frase.toString();
    }


    public List<Programmer> getProgrammers(boolean includeDefeated) {
        List<Programmer> jogadores = players;
        List<Programmer> jogadoresTodos = new ArrayList<>();

        if (includeDefeated) {
            return players;
        }
        else {
            for (Programmer j : jogadores) {
                if(j.getEmJogo()) {
                    jogadoresTodos.add(j);
                }
            }
            return jogadoresTodos;
        }
    }

    public List<Programmer> getProgrammers() {
        return players;
    }

    /*Função que vai imprimir que estão na posição X */
    public List<Programmer> getProgrammers(int position) {
        int auxiliar = 0;
        ArrayList<Programmer> jogadores = new ArrayList<>();
        for (Programmer j : players) {
            if (j.getEmJogo()) {
                if (j.getPosicao() == position) {
                    jogadores.add(j);
                    auxiliar++;
                }
            }
            else {
                if (j.receberPosicao() == position) {
                    jogadores.add(j);
                    auxiliar++;
                }
            }
        }

        if (auxiliar > 0) {
            return jogadores;
        }
        return null;



    }


    /*Função que vai movimentar os jogadores */
    public boolean moveCurrentPlayer(int nrSpaces) {
        if (nrSpaces > 6 || nrSpaces <= 0)
        {
            return false;
        }

        System.out.println("Nr turno : " + turnos);
        dado = nrSpaces;
        int id = getCurrentPlayerID();
        List<Programmer> jogadores  = getProgrammers();
        for (Programmer player : jogadores) {
            if (player.getId() == id) {
                if (player.getCicloInfinito()) {
                    return false;
                }
                player.moverJogador(nrSpaces, id);
                colocarInformacao(player.getPosicao());
            }

        }
        return true;
    }




    public String reactToAbyssOrTool() {
        int id = getCurrentPlayerID();
        List<Programmer> jogadores = getProgrammers();
        String frase = null;
        turnos++;

        if (gameIsOver()) {
            return null;
        }
        for (Programmer player : jogadores) {
            if (player.getId() == id) {
                if (casasComEfeito != null) {
                    frase = player.reagirCasaEfeito(casasComEfeito, player, dado, jogadores);
                }
                break;
            }

        }
        if (!gameIsOver()) {

            currentPlayer++;
            if (currentPlayer > numeroJogadores) {
                currentPlayer = 1;
            }
            id = getCurrentPlayerID();
            int aux = 0;

            for (Programmer player : jogadores) {
                if (player.getId() == id) {
                    if (!player.getEmJogo()) {
                        currentPlayer++;
                        if (currentPlayer > numeroJogadores) {
                            currentPlayer = 1;
                            aux++;
                        }
                    }
                    id = getCurrentPlayerID();
                }
            }
            if (aux > 0) {
                for (Programmer player : jogadores) {
                    if (player.getId() == id) {
                        if (!player.getEmJogo()) {
                            currentPlayer++;
                        }
                        id = getCurrentPlayerID();
                    }
                }
            }

        }


        return frase;

    }


    // Função que vai disponibilizar os resultados do jogo com o output desejado pelo projeto
    public List<String> getGameResults() {
        List<String> resultados = new ArrayList<>();

        List<Integer> listaPosicoes = new ArrayList<>();
        List<String> nomeJogadores = new ArrayList<>();


        //Usado para guardar os nomes dos jogadores
        String primeiro = "";
        String segundo = "";
        String terceiro = "";
        String quarto = "";

        //Usado para guardar as posições dos jogadores
        int calAuxSegundo = 0;
        int calAuxTerceiro = 0;
        int calAuxQuarto = 0;
        int auxJogadorFora = 0;

        boolean first = false;
        boolean second = false;
        boolean third = false;




        List<Programmer> jogadores;
        jogadores = getProgrammers();


        // O primeiro é o jogador que está na última casa do tabuleiro
        if (gameIsOver()) {
            resultados.add("O GRANDE JOGO DO DEISI");
            resultados.add("");
            resultados.add("NR. DE TURNOS");
            resultados.add(String.valueOf(turnos));
            resultados.add("");
            resultados.add("VENCEDOR");


            for (Programmer jogador : jogadores) {
                if (!jogador.getEmJogo()) {
                    auxJogadorFora++;
                }
                if (jogador.getEmJogo()) {
                    listaPosicoes.add(jogador.getPosicao());
                }
                else {
                    listaPosicoes.add(jogador.receberPosicao());
                }
                listaPosicoes.sort(Collections.reverseOrder());
            }


            if (auxJogadorFora == numeroJogadores - 1) {
                listaPosicoes = new ArrayList<>();
                for (Programmer jogador : jogadores) {
                    if (jogador.getEmJogo()) {
                        primeiro = jogador.getName();
                        first = true;
                    } else {
                        listaPosicoes.add(jogador.receberPosicao());
                        listaPosicoes.sort(Collections.reverseOrder());
                    }
                }
            }


            switch (numeroJogadores) {
                case 2 -> {
                    if (first) {

                        for (Programmer jogador : jogadores) {
                            if (!jogador.getName().equals(primeiro)) {
                                segundo = jogador.getName();
                                calAuxSegundo = jogador.receberPosicao();
                            }
                        }
                    }
                    else {

                        for (Programmer jogador : jogadores) {
                            if (jogador.getEmJogo()) {

                                if (jogador.getPosicao() == listaPosicoes.get(0)) {
                                    primeiro = jogador.getName();
                                } else {
                                    segundo = jogador.getName();
                                    calAuxSegundo = jogador.getPosicao();
                                }
                            }
                            else {
                                if (jogador.receberPosicao() == listaPosicoes.get(0)) {
                                    primeiro = jogador.getName();
                                } else {
                                    segundo = jogador.getName();
                                    calAuxSegundo = jogador.receberPosicao();
                                }
                            }
                        }

                    }

                    resultados.add(primeiro);
                    resultados.add("");
                    resultados.add("RESTANTES");
                    resultados.add(segundo + ' ' + calAuxSegundo);
                }


                case 3 -> {
                    if (first) {

                        for (Programmer jogador : jogadores) {
                            if (!jogador.getName().equals(primeiro)) {
                                if (jogador.receberPosicao() == listaPosicoes.get(0) && !second) {
                                    segundo = jogador.getName();
                                    calAuxSegundo = jogador.receberPosicao();
                                    second = true;

                                } else {
                                    terceiro = jogador.getName();
                                    calAuxTerceiro = jogador.receberPosicao();
                                }
                            }
                        }
                    }
                    else {

                        for (Programmer jogador : jogadores) {
                            if (jogador.getEmJogo()) {

                                if (jogador.getPosicao() == listaPosicoes.get(0)) {
                                    primeiro = jogador.getName();

                                } else if (jogador.getPosicao() == listaPosicoes.get(1) && !second) {
                                    segundo = jogador.getName();
                                    calAuxSegundo = jogador.getPosicao();
                                    second = true;
                                } else {
                                    terceiro = jogador.getName();
                                    calAuxTerceiro = jogador.getPosicao();
                                }
                            }
                            else {
                                if (jogador.receberPosicao() == listaPosicoes.get(0)) {
                                    primeiro = jogador.getName();

                                } else if (jogador.receberPosicao() == listaPosicoes.get(1) && !second) {
                                    segundo = jogador.getName();
                                    calAuxSegundo = jogador.receberPosicao();
                                    second = true;
                                } else {
                                    terceiro = jogador.getName();
                                    calAuxTerceiro = jogador.receberPosicao();
                                }
                            }

                        }
                    }


                    resultados.add(primeiro);
                    resultados.add("");
                    resultados.add("RESTANTES");
                    if (calAuxSegundo != calAuxTerceiro) {
                        resultados.add(segundo + ' ' + calAuxSegundo);
                        resultados.add(terceiro + ' ' + calAuxTerceiro);
                    } else {
                        nomeJogadores.add(segundo);
                        nomeJogadores.add(terceiro);
                        Collections.sort(nomeJogadores);
                        resultados.add(nomeJogadores.get(0) + ' ' + calAuxSegundo);
                        resultados.add(nomeJogadores.get(1) + ' ' + calAuxTerceiro);
                    }
                }


                case 4 -> {
                    System.out.println(listaPosicoes);
                    System.out.println(first);

                    if (first) {

                        for (Programmer jogador : jogadores) {
                            if (!jogador.getName().equals(primeiro)) {
                                if (jogador.receberPosicao() == listaPosicoes.get(0) && !second) {
                                    segundo = jogador.getName();
                                    calAuxSegundo = jogador.receberPosicao();
                                    second = true;

                                }
                                else if (jogador.receberPosicao() == listaPosicoes.get(2) && !third) {
                                    terceiro = jogador.getName();
                                    calAuxTerceiro = jogador.receberPosicao();
                                    third = true;
                                }

                                else {
                                    quarto = jogador.getName();
                                    calAuxQuarto = jogador.receberPosicao();
                                }
                            }
                        }
                    }

                    else {

                        for (Programmer jogador : jogadores) {
                            if (jogador.getEmJogo()) {
                                if (jogador.getPosicao() == listaPosicoes.get(0) && !first) {
                                    primeiro = jogador.getName();
                                    first = true;

                                } else if (jogador.getPosicao() == listaPosicoes.get(1) && !second) {
                                    segundo = jogador.getName();
                                    calAuxSegundo = jogador.getPosicao();
                                    second = true;
                                } else if (jogador.getPosicao() == listaPosicoes.get(2) && !third) {
                                    terceiro = jogador.getName();
                                    calAuxTerceiro = jogador.getPosicao();
                                    third = true;
                                } else {
                                    quarto = jogador.getName();
                                    calAuxQuarto = jogador.getPosicao();
                                }
                            }
                            else {
                                if (jogador.receberPosicao() == listaPosicoes.get(0) && !first) {
                                    primeiro = jogador.getName();
                                    first = true;

                                } else if (jogador.receberPosicao() == listaPosicoes.get(1) && !second) {
                                    segundo = jogador.getName();
                                    calAuxSegundo = jogador.receberPosicao();
                                    second = true;
                                } else if (jogador.receberPosicao() == listaPosicoes.get(2) && !third) {
                                    terceiro = jogador.getName();
                                    calAuxTerceiro = jogador.receberPosicao();
                                    third = true;
                                } else {
                                    quarto = jogador.getName();
                                    calAuxQuarto = jogador.receberPosicao();
                                }
                            }

                        }
                    }
                    resultados.add(primeiro);
                    resultados.add("");
                    resultados.add("RESTANTES");
                    if (calAuxSegundo != calAuxTerceiro  && calAuxSegundo!=calAuxQuarto  && calAuxTerceiro!= calAuxQuarto) {
                        resultados.add(segundo + ' ' + calAuxSegundo);
                        resultados.add(terceiro + ' ' + calAuxTerceiro);
                        resultados.add(quarto + ' ' + calAuxQuarto);
                    }
                    else if (calAuxSegundo != calAuxQuarto && calAuxTerceiro == calAuxQuarto){
                        resultados.add(segundo + ' ' + calAuxSegundo);
                        nomeJogadores.add(terceiro);
                        nomeJogadores.add(quarto);
                        Collections.sort(nomeJogadores);
                        resultados.add(nomeJogadores.get(0) + ' ' + calAuxTerceiro);
                        resultados.add(nomeJogadores.get(1) + ' ' + calAuxQuarto);
                    }
                    else if (calAuxSegundo == calAuxTerceiro && calAuxTerceiro != calAuxQuarto) {
                        nomeJogadores.add(segundo);
                        nomeJogadores.add(terceiro);
                        Collections.sort(nomeJogadores);
                        resultados.add(nomeJogadores.get(0) + ' ' + calAuxSegundo);
                        resultados.add(nomeJogadores.get(1) + ' ' + calAuxTerceiro);
                        resultados.add(quarto + ' ' + calAuxQuarto);
                    }
                    else {
                        nomeJogadores.add(segundo);
                        nomeJogadores.add(terceiro);
                        nomeJogadores.add(quarto);
                        Collections.sort(nomeJogadores);
                        resultados.add(nomeJogadores.get(0) + ' ' + calAuxSegundo);
                        resultados.add(nomeJogadores.get(1) + ' ' + calAuxTerceiro);
                        resultados.add(nomeJogadores.get(2) + ' ' + calAuxQuarto);
                    }
                }


            }
        }

        return resultados;

    }






    private void addJogadores(int totalJogadores, String[][] playerInfo) {
        List<Integer> listaId = new ArrayList<>();
        players = new ArrayList<>();

        switch (totalJogadores) {
            case 2 -> {
                Programmer jogador1 = new Programmer(Integer.parseInt(playerInfo[0][0]), playerInfo[0][1], playerInfo[0][2], playerInfo[0][3]);
                Programmer jogador2 = new Programmer(Integer.parseInt(playerInfo[1][0]), playerInfo[1][1], playerInfo[1][2], playerInfo[1][3]);
                jogador1.colocarInformacao(1);
                jogador2.colocarInformacao(1);



                if (Integer.parseInt(playerInfo[0][0]) < Integer.parseInt(playerInfo[1][0])) {
                    players.add(jogador1);
                    players.add(jogador2);
                } else {
                    players.add(jogador2);
                    players.add(jogador1);
                }

                numeroJogadores = 2;
            }

            case 3 -> {
                listaId.add(Integer.parseInt(playerInfo[0][0]));
                listaId.add(Integer.parseInt(playerInfo[1][0]));
                listaId.add(Integer.parseInt(playerInfo[2][0]));
                Collections.sort(listaId);
                Programmer jogador1 = new Programmer(Integer.parseInt(playerInfo[0][0]), playerInfo[0][1], playerInfo[0][2], playerInfo[0][3]);
                Programmer jogador2 = new Programmer(Integer.parseInt(playerInfo[1][0]), playerInfo[1][1], playerInfo[1][2], playerInfo[1][3]);
                Programmer jogador3 = new Programmer(Integer.parseInt(playerInfo[2][0]), playerInfo[2][1], playerInfo[2][2], playerInfo[2][3]);
                jogador1.colocarInformacao(1);
                jogador2.colocarInformacao(1);
                jogador3.colocarInformacao(1);



                for (Integer id : listaId) {
                    if (id.equals(Integer.parseInt(playerInfo[0][0]))) {
                        players.add(jogador1);
                    }
                    else if (id.equals(Integer.parseInt(playerInfo[1][0]))) {
                        players.add(jogador2);
                    }
                    else {
                        players.add(jogador3);
                    }
                }



                numeroJogadores = 3;
            }

            case 4 -> {
                listaId.add(Integer.parseInt(playerInfo[0][0]));
                listaId.add(Integer.parseInt(playerInfo[1][0]));
                listaId.add(Integer.parseInt(playerInfo[2][0]));
                listaId.add(Integer.parseInt(playerInfo[3][0]));
                Collections.sort(listaId);

                Programmer jogador1 = new Programmer(Integer.parseInt(playerInfo[0][0]), playerInfo[0][1], playerInfo[0][2], playerInfo[0][3]);
                Programmer jogador2 = new Programmer(Integer.parseInt(playerInfo[1][0]), playerInfo[1][1], playerInfo[1][2], playerInfo[1][3]);
                Programmer jogador3 = new Programmer(Integer.parseInt(playerInfo[2][0]), playerInfo[2][1], playerInfo[2][2], playerInfo[2][3]);
                Programmer jogador4 = new Programmer(Integer.parseInt(playerInfo[3][0]), playerInfo[3][1], playerInfo[3][2], playerInfo[3][3]);
                jogador1.colocarInformacao(1);
                jogador2.colocarInformacao(1);
                jogador3.colocarInformacao(1);
                jogador4.colocarInformacao(1);




                for (Integer id : listaId) {
                    if (id.equals(Integer.parseInt(playerInfo[0][0]))) {
                        players.add(jogador1);
                    }
                    else if (id.equals(Integer.parseInt(playerInfo[1][0]))) {
                        players.add(jogador2);
                    }
                    else if (id.equals(Integer.parseInt(playerInfo[2][0]))) {
                        players.add(jogador3);
                    }
                    else {
                        players.add(jogador4);
                    }
                }



                numeroJogadores = 4;
            }


        }

    }



    public void adicionarPremio(String[][] abyssesAndTools, int i){
        String s;
        if (abyssesAndTools[i][0].equals("1")) {
            s = "Ferramenta";
            switch (abyssesAndTools[i][1]) {
                case "0" -> {
                    FerramentaHeranca ferramenta = new FerramentaHeranca(s, abyssesAndTools[i][1], abyssesAndTools[i][2]);
                    casasComEfeito.add(ferramenta);
                }
                case "1" -> {
                    FerramentaProgramacaoFuncional ferramenta = new FerramentaProgramacaoFuncional(s, abyssesAndTools[i][1], abyssesAndTools[i][2]);
                    casasComEfeito.add(ferramenta);
                }
                case "2" -> {
                    FerramentaTestesUnitarios ferramenta = new FerramentaTestesUnitarios(s, abyssesAndTools[i][1], abyssesAndTools[i][2]);
                    casasComEfeito.add(ferramenta);
                }
                case "3" -> {
                    FerramentaTratamentoExcepcoes ferramenta = new FerramentaTratamentoExcepcoes(s, abyssesAndTools[i][1], abyssesAndTools[i][2]);
                    casasComEfeito.add(ferramenta);
                }
                case "4" -> {
                    FerramentaIDE ferramenta = new FerramentaIDE(s, abyssesAndTools[i][1], abyssesAndTools[i][2]);
                    casasComEfeito.add(ferramenta);
                }
                case "5" -> {
                    FerramentaAjudaProfessor ferramenta = new FerramentaAjudaProfessor(s, abyssesAndTools[i][1], abyssesAndTools[i][2]);
                    casasComEfeito.add(ferramenta);
                }

            }

        }
        else {
            s = "Abismo";
            switch (abyssesAndTools[i][1]) {
                case "0" -> {
                    AbismoErroSintaxe a = new AbismoErroSintaxe(s, abyssesAndTools[i][1], abyssesAndTools[i][2]);
                    casasComEfeito.add(a);
                }
                case "1" -> {
                    AbismoErroLogica abismo = new AbismoErroLogica(s, abyssesAndTools[i][1], abyssesAndTools[i][2]);
                    casasComEfeito.add(abismo);
                }
                case "2" -> {
                    AbismoException abismo = new AbismoException(s, abyssesAndTools[i][1], abyssesAndTools[i][2]);
                    casasComEfeito.add(abismo);
                }
                case "3" -> {
                    AbismoFileNotFound abismo = new AbismoFileNotFound(s, abyssesAndTools[i][1], abyssesAndTools[i][2]);
                    casasComEfeito.add(abismo);
                }
                case "4" -> {
                    AbismoCrash abismo = new AbismoCrash(s, abyssesAndTools[i][1], abyssesAndTools[i][2]);
                    casasComEfeito.add(abismo);
                }
                case "5" -> {
                    AbismoDuplicatedCode abismo = new AbismoDuplicatedCode(s, abyssesAndTools[i][1], abyssesAndTools[i][2]);
                    casasComEfeito.add(abismo);
                }
                case "6" -> {
                    AbismoEfeitosSecundarios abismo = new AbismoEfeitosSecundarios(s, abyssesAndTools[i][1], abyssesAndTools[i][2]);
                    casasComEfeito.add(abismo);
                }
                case "7" -> {
                    AbismoBlueScreen abismo = new AbismoBlueScreen(s, abyssesAndTools[i][1], abyssesAndTools[i][2]);
                    casasComEfeito.add(abismo);
                }
                case "8" -> {
                    AbismoCicloInfinito abismo = new AbismoCicloInfinito(s, abyssesAndTools[i][1], abyssesAndTools[i][2]);
                    casasComEfeito.add(abismo);
                }
                case "9" -> {
                    AbismoSegmentationFault abismo = new AbismoSegmentationFault(s, abyssesAndTools[i][1], abyssesAndTools[i][2]);
                    casasComEfeito.add(abismo);
                }



            }
        }
    }


    public boolean loadGame(File file) {
        try {
            String nome = String.valueOf(file);
            if (nome.isEmpty() || nome.equals("nullnull")) {
               throw new FileNotFoundException();
            }
            int aux=0;

            String[] jogadoresId = new String[4];
            String[] nomeJogadores = new String[4];
            String[] lprogramacao = new String[4];
            String[] cor = new String[4];
            String[] posicaoPlayer = new String[4];
            String[] estadoPlayers = new String[4];
            String[] ferramentasPlayer = new String[4];
            String[] historicoPlayers = new String[4];
            String[] tipoPremio = new String[80];
            String[] posicaoPremio = new String[80];

            int jogadorCorrente = 0;
            int dadoCorrente = 0;
            int tamanhoCampo = 0;
            int numeroPlayers = 0;
            int valorTurnos = 0;
            int tamanhoPremio = 0;
            String[] nomePremio = new String[80];


            String linha;
            int numero;
            file = new File(nome);

            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                linha = myReader.nextLine();

                if (aux >= 8 && aux<= 13) {
                    numero = Integer.parseInt(linha.replace("[","").replace("]","").replace(" ",""));
                    switch (aux) {
                        case 8 -> jogadorCorrente = numero;

                        case 9 -> numeroPlayers = numero;

                        case 10 -> dadoCorrente = numero;

                        case 11 -> tamanhoCampo = numero;

                        case 12 -> tamanhoPremio = numero;

                        case 13 -> valorTurnos = numero;
                    }

                }
                else {
                    switch (aux) {
                        case 0 -> jogadoresId = linha.split(" :");

                        case 1 -> nomeJogadores = linha.split(" :");

                        case 2 -> lprogramacao = linha.split(" :");

                        case 3 -> cor = linha.split(" :");

                        case 4 -> {
                            linha = linha.replace("true","Em Jogo").replace("false","Derrotado");
                            estadoPlayers = linha.split(" :");
                        }

                        case 5 -> posicaoPlayer = linha.split(" :");

                        case 6 -> ferramentasPlayer = linha.split(" :");

                        case 7 -> historicoPlayers = linha.split(" :");

                        case 14 -> nomePremio = linha.split(" :");

                        case 15 -> tipoPremio = linha.split(" :");

                        case 16 -> posicaoPremio = linha.split(" :");

                    }
                }
                aux++;
            }
            if (aux!=17) {
                return false;
            }
            myReader.close();
            String[][] playerInfo  = new String[numeroPlayers][4];
            String[][] abyssesAndTools = new String[tamanhoPremio][3];
            casasComEfeito = new ArrayList<>();



            currentPlayer = jogadorCorrente;
            dado = dadoCorrente;
            turnos = valorTurnos;
            numeroJogadores = numeroPlayers;
            boardSize = tamanhoCampo;

            for (int i = 0; i < numeroPlayers; i++) {
                for (int y=0; y < 4; y++) {
                    switch (y) {
                        case 0 -> playerInfo[i][y] = jogadoresId[i];

                        case 1 -> playerInfo[i][y] = nomeJogadores[i];

                        case 2 -> playerInfo[i][y] = lprogramacao[i].replace(";",",");

                        case 3-> playerInfo[i][y] = cor[i];

                    }
                }
            }

            for (int i = 0; i < tamanhoPremio; i++) {
                for (int y=0; y < 3; y++) {

                    switch (y) {
                        case 0 -> abyssesAndTools[i][y] = mudarParaNumero(nomePremio[i]);

                        case 1 -> {
                            System.out.println(tipoPremio[i]);
                            abyssesAndTools[i][y] = mudarParaNumero(tipoPremio[i]);
                            System.out.println(mudarParaNumero(tipoPremio[i]));
                        }

                        case 2 -> abyssesAndTools[i][y] = posicaoPremio[i];

                    }
                }
            }

            addJogadores(numeroJogadores,playerInfo);



            for (int i= 0; i < tamanhoPremio; i++){

                adicionarPremio(abyssesAndTools,i);
            }

            int valor=0;

            for (Programmer jogador : players) {
                jogador.modificarEstado(estadoPlayers[valor]);
                jogador.mudarPosicao(Integer.parseInt(posicaoPlayer[valor]));
                jogador.setferramentasJogador(ferramentasPlayer[valor]);
                jogador.setHistoricoPosicoes(historicoPlayers[valor]);
                valor++;
            }

            for (Programmer jogador : players) {
                System.out.println(jogador);
            }


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            return false;
        }
        return true;
    }

    private String mudarParaNumero(String s) {

        switch (s) {
            case "Herança","Erro de sintaxe","Abismo" -> {
                return "0";
            }
            case "Erro de lógica","Programação Funcional","Ferramenta" -> {
                return "1";
            }
            case "Testes unitários","Exception" -> {
                return "2";
            }
            case "Tratamento de Excepções","File Not Found Exception" -> {
                return "3";
            }
            case "IDE","Crash" -> {
                return "4";
            }
            case "Ajuda do professor","Duplicated Code" -> {
                return "5";
            }
            case "Efeitos secundários" -> {
                return "6";
            }
            case "Blue Screen of Death" -> {
                return "7";
            }
            case "Ciclo infinito" -> {
                return "8";
            }
            case "Segmentation Fault" -> {
                return "9";
            }
            default -> {
                return null;
            }


        }
    }




public boolean saveGame(File file) {
        try {
            String nome = String.valueOf(file);
            System.out.println(nome);
            if (nome.isEmpty()) {
                throw new IOException();
            }
            else {
                file = new File(nome+".txt");

                if (file.createNewFile() ) {
                    System.out.println("File created: " + file.getName());
                }
                else {
                    throw new IOException();

                }


            }


            String newLine = "\n";
            StringBuilder nomeJogadores = new StringBuilder();
            StringBuilder lprogramacao = new StringBuilder();
            StringBuilder id = new StringBuilder();
            StringBuilder cor = new StringBuilder();
            StringBuilder posicao = new StringBuilder();
            StringBuilder estado = new StringBuilder();
            StringBuilder ferramentas = new StringBuilder();
            StringBuilder historico = new StringBuilder();
            StringBuilder nomePremio = new StringBuilder();
            StringBuilder tipoPremio = new StringBuilder();
            StringBuilder posicaoPremio = new StringBuilder();



            for (Programmer j: players){
                nomeJogadores.append(j.getName()).append(" :");
                lprogramacao.append(j.getLinguagens()).append(" :");
                id.append(j.getId()).append(" :");
                cor.append(j.getColor()).append(" :");
                posicao.append(j.getPosicao()).append(" :");
                estado.append(j.getEmJogo()).append(" :");
                ferramentas.append(j.getFerramentas()).append(" :");
                historico.append(j.getHistoricoPosicoes()).append(" :");
            }
            for (CasaEfeito p : casasComEfeito ) {
                nomePremio.append(p.getNome()).append(" :");
                tipoPremio.append(p.getTipo()).append(" :");
                posicaoPremio.append(p.getPosicao()).append(" :");
            }


            FileWriter fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(id + newLine + nomeJogadores + newLine + lprogramacao + newLine + cor + newLine + estado +
                    newLine + posicao + newLine + ferramentas + newLine + historico + newLine + currentPlayer + newLine
                    + numeroJogadores + newLine + dado + newLine + boardSize + newLine + casasComEfeito.size() + newLine
                    + turnos + newLine + nomePremio + newLine + tipoPremio + newLine + posicaoPremio );
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            return false;
        }

        return true;
    }



}


