package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.List;

public class AbismoException extends Abismo {

    AbismoException(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Exception";
    }

    @Override
    String getAbismo(Programmer player, List<Programmer> jogadores, Integer dado) {
        List <String> ferramentas = player.getFerramentas();

        for (String f : ferramentas){
            if (f.equals("Ajuda Do Professor") || f.equals("Tratamento de Excepções")) {
                player.retirarFerramenta(f);
                return "Usaste a ferramenta " + f + " para o seguinte abismo (Exception) ";
            }
        }
        ArrayList<Integer> historico;

        historico = player.getHistoricoPosicoes();
        int i = historico.size() - 1;
        if (i < 0) {
            player.mudarPosicao(1);
        }
        else {
            int valorPosicao = (historico.get(i));
            valorPosicao -= 2;
            player.mudarPosicao(valorPosicao);
        }
        return "Regressa 2 casas atrás";
    }

    @Override
    public String getImage() {
        return "greengoblin.png";
    }
}