package pt.ulusofona.lp2.deisiGreatGame;

public class Programmer {
    Integer jogadorID;
    String nome;
    String linguagens;
    ProgrammerColor color;
    Integer posicao;
    String estado;

    public Programmer () { }

    public Programmer (Integer id , String name, String lprogramacao, ProgrammerColor color) {
        this.jogadorID = id;
        this.nome = name;
        this.linguagens = lprogramacao;
        this.color = color;
        this.posicao = 1;
        this.estado = "Está em jogo";
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


    @Override
    public String toString() {
        return this.jogadorID + " | " + this.nome + " | " + this.posicao + " | " + this.linguagens + " | " + this.estado + " | " + this.color;

    }



}
