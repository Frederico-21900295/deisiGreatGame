package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.List;

public class AbismoEfeitosSecundarios extends Abismo {

    AbismoEfeitosSecundarios(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Efeitos secundários";
    }

    @Override
    String getAbismo(Programmer player, List<Programmer> jogadores, Integer dado) {
        List <String> ferramentas = player.getFerramentas();
        ArrayList<Integer> historico;

        for (String f : ferramentas){
            if (f.equals("Programação Funcional")) {
                player.retirarFerramenta(f);
                return "Usaste a ferramenta " + f + " para o seguinte abismo (Efeitos Secundários) ";
            }
        }
        historico = player.getHistoricoPosicoes();
        int i = historico.size() - 2;
        if (i < 0) {
            player.mudarPosicao(1);
        }
        else {
            int valorPosicao = (historico.get(i));
            player.mudarPosicao(valorPosicao);
        }

        return "Regressa duas jogadas atrás";
    }


    @Override
    public String getImage() {
        return "dobby.png";
    }
}