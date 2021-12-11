package pt.ulusofona.lp2.deisiGreatGame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Programmer {
    private final Integer jogadorID;
    private final String nome;
    private final String linguagens;
    ProgrammerColor color;
    private int posicao;
    private String estado;
    private ArrayList<String> ferramentasJogador;

    private final ArrayList<Integer> historicoPosicoes; // Posicao

    //Variáveis para guardar caso o jogador caia num ciclo Infinito
    private boolean abismoCicloInfinito;
    private int posicaoCicloInfinito;




    public Programmer(Integer id, String name, String linguagens,String color) {
        this.jogadorID = id;
        this.nome = name;
        this.linguagens = linguagens;
        switch (color) {
            case "Purple" -> this.color = ProgrammerColor.PURPLE;
            case "Blue" -> this.color = ProgrammerColor.BLUE;
            case "Brown" -> this.color = ProgrammerColor.BROWN;
            case "Green" -> this.color = ProgrammerColor.GREEN;
        }
        ferramentasJogador = new ArrayList<>();
        historicoPosicoes = new ArrayList<>();
        this.posicao = 1;
        this.estado = "Em Jogo";
        this.abismoCicloInfinito = false;
        this.posicaoCicloInfinito = 0;
    }

    public int getId() {
        return this.jogadorID;
    }

    public String getName() {
        return this.nome;
    }

    public ProgrammerColor getColor() {
        return this.color;
    }

    public int getPosicao() { return this.posicao;}

    public boolean getEmJogo() {
        return this.estado.equals("Em Jogo");
    }

    public ArrayList<String> getFerramentas () {
        return this.ferramentasJogador;
    }


    public boolean temFerramenta (String tipo) {
        return ferramentasJogador.contains(tipo);
    }


    //Função para retirar ferramenta caso o jogador a use para não cair num abismo
    public void retirarFerramenta (String tipo) {
        ArrayList<String> ferramentas = getFerramentas();
        for (String f : ferramentas) {
            if (f.equals(tipo)) {
                ferramentas.remove(tipo);
                ferramentasJogador = ferramentas;
                return;
            }
        }
    }

    //Função para modificar a posicão do jogador
    public void mudarPosicao(int x) {
        this.posicao = x;
    }


    //Função para receber a variável getHistoricoPosicoes
    public ArrayList<Integer> getHistoricoPosicoes() {
        return this.historicoPosicoes;
    }

    public void colocarInformacao( int posicao ) {
        this.historicoPosicoes.add(posicao);
    }

    public boolean getCicloInfinito() {
        return this.abismoCicloInfinito;
    }

    public void cicloInfinito(boolean ciclo, int posicao) {
        this.abismoCicloInfinito = ciclo;
        this.posicaoCicloInfinito = posicao;
    }

    public void perdeu() {
        estado = "Derrotado";

    }

    public ArrayList<String> addFerramentas(String s) {
        ArrayList<String> ferramenta = getFerramentas();
        for (String f : ferramenta) {
            if (f.equals(s)) {
                return null;
            }
        }
        ferramenta.add(s);
        return ferramenta;
    }


    //Função que irá mover o jogador
    public void moverJogador(int nrSpaces, int id) {
        int aux;
        int posicaoFinal;
        if (this.jogadorID == id) {
            if (this.posicao + nrSpaces > GameManager.boardSize) {
                aux = this.posicao + nrSpaces;
                aux -= GameManager.boardSize;
                posicaoFinal = GameManager.boardSize - aux;
                mudarPosicao(posicaoFinal);

            } else {
                aux = this.posicao + nrSpaces;
                mudarPosicao(aux);
            }
        }
    }

    public String reagirCasaEfeito(ArrayList<CasaEfeito> casaComEfeitos, Programmer player, int dado, List<Programmer> jogadores) {
        String frase = null;
        for (CasaEfeito p : casaComEfeitos) {
            if (p.getPosicao() == this.getPosicao()) {
                frase = p.reacao(player, dado, jogadores);
                break;
            }
        }
        colocarInformacao(this.posicao);
        return frase;
    }


    @Override
    public String toString() {
        String linguagens = this.linguagens;
        ArrayList<String> ferramentas = this.ferramentasJogador;
        String output;
        int x = 0;

        ArrayList<String> aux1 = new ArrayList<>();

        Collections.addAll(aux1, linguagens.split(";"));
        Collections.sort(aux1);

        StringBuilder outputBuilder = new StringBuilder(jogadorID + " | " + this.nome + " | " + this.posicao + " | ");

        if (ferramentas.isEmpty()) {
            outputBuilder.append("No tools | ");

        }
        else {
            for (String f: ferramentas) {
                if (x>=1) {
                    outputBuilder.append(";").append(f);
                }
                else {
                    outputBuilder.append(f);
                }
                x++;
            }
            outputBuilder.append(" | ");
            x=0;

        }

        for (String frase : aux1) {
            outputBuilder.append(frase);
            if (x != aux1.size() - 1) {
                outputBuilder.append("; ");
            }
            x++;
        }

        output = outputBuilder.toString();
        output+= " | " + estado;

        return output;


    }



}















