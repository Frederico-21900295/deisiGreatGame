package pt.ulusofona.lp2.deisiGreatGame;

import java.util.List;

abstract class CasaEfeito {
    private final String nome;
    String tipo;
    private final Integer posicao;


    //Atribuir valores ás ferramentas com o nome pedido pelo enunciado
    CasaEfeito ( String name, String type, String position) {
        this.nome = name;
        this.posicao = Integer.parseInt(position);
        this.tipo = type;
    }


    protected abstract String getNumeroPisadas();


    public boolean getCasaEfeito(int position) {
        return true;
    }

    public String getNome() { return this.nome;}

    public Integer getPosicao() { return this.posicao;}

    public String getTipo() { return this.tipo;}


    //Função para receber as imagens de cada CasaEfeito
    abstract String getImage();


    abstract String reacao(Programmer player, int dado, List<Programmer> jogadores);



    @Override
    public String toString() {
        return this.nome + " | " + this.posicao + " | " + this.tipo;
    }



}
