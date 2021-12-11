package pt.ulusofona.lp2.deisiGreatGame;

import java.util.List;

abstract class CasaEfeito {
    private final String nome;
    String tipo;
    private final Integer posicao;
    int ferramenta;


    //Atribuir valores ás ferramentas com o nome pedido pelo enunciado
    CasaEfeito ( String name, String type, String position) {
        this.nome = name;
        this.posicao = Integer.parseInt(position);
        this.tipo = type;
        if (this.nome.equals("Abismo")) {
            switch (this.tipo) {
                case "0" -> this.tipo = "Erro de sintaxe";
                case "1" -> this.tipo = "Erro de lógica";
                case "2" -> this.tipo = "Exception";
                case "3" -> this.tipo = "File Not Found Exception";
                case "4" -> this.tipo = "Crash (aka Rebentanço)";
                case "5" -> this.tipo = "Duplicated Code";
                case "6" -> this.tipo = "Efeitos secundários";
                case "7" -> this.tipo = "Blue Screen of Death";
                case "8" -> this.tipo = "Ciclo infinito";
                case "9" -> this.tipo = "Segmentation Fault";
            }
        }
        this.ferramenta = 0;
    }


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
