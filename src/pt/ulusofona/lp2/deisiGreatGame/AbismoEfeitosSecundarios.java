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
        if (player == null) {
            return null;
        }
        List <String> ferramentas = player.getFerramentas();
        ArrayList<Integer> historico;

        for (String f : ferramentas){
            if (f.equals("Programação Funcional")) {
                player.retirarFerramenta(f);
                return "Usaste a ferramenta " + f + " para o seguinte abismo (Efeitos Secundários) ";
            }
        }
        historico = player.getHistoricoPosicoes();
        int i = historico.size() - 4;


        int valorPosicao = (historico.get(i));
        player.mudarPosicao(valorPosicao);


        return "Regressa duas jogadas atrás";
    }


    @Override
    public String getImage() {
        return "dobby.png";
    }
}




//      antes depois  antes depois antes