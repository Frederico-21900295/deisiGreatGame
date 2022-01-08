package pt.ulusofona.lp2.deisiGreatGame;

import java.util.List;

public class AbismoCrash extends Abismo {

    AbismoCrash(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Crash";

    }

    @Override
    String getAbismo(Programmer player, List<Programmer> jogadores, Integer dado) {
        if (player == null) {
            return null;
        }
        player.mudarPosicao(1);
        this.numeroPisadas += 1;
        return "Vais ter de regressar à 1ª posição";
    }

    @Override
    public String getImage() {
        return "restart.png";
    }
}
