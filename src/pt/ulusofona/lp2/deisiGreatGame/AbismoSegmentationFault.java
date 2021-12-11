package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.List;

public class AbismoSegmentationFault extends Abismo {

    AbismoSegmentationFault(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Segmentation Fault";
    }

    @Override
    String getAbismo(Programmer player, List<Programmer> jogadores, Integer dado) {
        List<Integer> listaId = new ArrayList<>();
        for (Programmer jogador : jogadores) {
            if (jogador.getPosicao() == player.getPosicao()) {
                listaId.add(jogador.getId());
            }
        }
        if (listaId.size()<=1) {
            return "É melhor outro jogador não calhar nesta casa";
        }
        else {
            int valorNovaCasa = player.getPosicao() - 3;
            if (valorNovaCasa <= 0) {
                valorNovaCasa = 1;
            }
            for (Programmer jogador : jogadores) {
                for (Integer integer : listaId) {
                    if (jogador.getId() == integer) {
                        jogador.mudarPosicao(valorNovaCasa);
                    }
                }
            }
            return "Como estão pelo menos 2 jogadores nesta casa vao retroceder 3 casas";

        }
    }

    @Override
    public String getImage() {
        return "core-dumped.png";
    }
}