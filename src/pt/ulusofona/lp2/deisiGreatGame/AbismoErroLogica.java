package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.List;

public class AbismoErroLogica extends Abismo {

    AbismoErroLogica(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Erro de lógica";
    }

    @Override
    String getAbismo(Programmer player, List<Programmer> jogadores, Integer dado) {
        if (player == null) {
            return null;
        }
        List <String> ferramentas = player.getFerramentas();
        ArrayList<Integer> historico;

        for (String f : ferramentas){
            if (f.equals("Ajuda Do Professor") || f.equals("Testes unitários")) {
                player.retirarFerramenta(f);
                return "Usaste a ferramenta " + f + " para o seguinte abismo (Erro de Lógica) ";
            }
        }

        historico = player.getHistoricoPosicoes();
        int i = historico.size() - 1;
        if (i <= 0) {
            player.mudarPosicao(1);
        }
        else {
            int valorPosicao = (historico.get(i));
            int valordado = dado;
            int auxPosicao = valorPosicao - (valordado / 2);
            player.mudarPosicao(auxPosicao);
        }


        return "Regressa o valor da metade dos teus dados atrás";
    }

    @Override
    public String getImage() {
        return "venom.png";
    }
}
