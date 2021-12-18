package pt.ulusofona.lp2.deisiGreatGame;

import java.util.List;

abstract class Ferramenta extends CasaEfeito {


    Ferramenta(String name, String type, String position) {
        super(name, type, position);
    }


    abstract String getFerramenta(Programmer player);



    @Override
    public String reacao(Programmer player, int dado, List<Programmer> jogadores) {
        String frase;
        frase = getFerramenta(player);
        System.out.println(frase);
        return frase;

    }





}
