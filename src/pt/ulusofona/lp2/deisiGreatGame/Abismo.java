package pt.ulusofona.lp2.deisiGreatGame;

import java.util.List;


abstract class Abismo extends CasaEfeito {
    int numeroPisadas;


    Abismo(String name, String type, String position) {
        super(name, type, position);
        this.numeroPisadas = 0;

    }


    public String getNumeroPisadas(){
        return String.valueOf(this.numeroPisadas);
    }


    //Função que irá dar a punição ao jogador(verificar se for menos de 1 fica na casa 1
    abstract String getAbismo(Programmer player, List<Programmer> jogadores, Integer dado);

    @Override
    public String reacao(Programmer player, int dado, List<Programmer> jogadores) {
        String frase;
        frase = getAbismo(player,jogadores,dado);
        System.out.println(frase);
        return frase;

    }

}
