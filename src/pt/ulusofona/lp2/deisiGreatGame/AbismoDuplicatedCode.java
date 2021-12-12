package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.List;

public class AbismoDuplicatedCode extends Abismo {

    AbismoDuplicatedCode(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Duplicated Code";
    }



    @Override
    String getAbismo(Programmer player, List<Programmer> jogadores, Integer dado) {
        if (player == null) {
            return null;
        }
        List <String> ferramentas = player.getFerramentas();
        ArrayList<Integer> historico;

        for (String f : ferramentas){
            if (f.equals("Herança")) {
                player.retirarFerramenta(f);
                return "Usaste a ferramenta " + f + " para o seguinte abismo (Duplicated Code) ";
            }
        }
        historico = player.getHistoricoPosicoes();
        int i = historico.size() - 2;
        if (i <= 0) {
            player.mudarPosicao(1);
        }
        else {
            int valorPosicao = (historico.get(i));
            player.mudarPosicao(valorPosicao);
        }


        return "Vais ter de regressar atrás";
    }

    @Override
    public String getImage() {
        return "charmander.png";
    }
}
