package pt.ulusofona.lp2.deisiGreatGame;

import java.util.List;

public class AbismoBlueScreen extends Abismo{

    AbismoBlueScreen(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Blue Screen of Death";
    }

    @Override
    String getAbismo(Programmer player, List<Programmer> jogadores, Integer dado) {
        if (player == null) {
            return null;
        }
        player.guardaPosicao(player.getPosicao());
        player.perdeu();
        this.numeroPisadas += 1;
        return "Perdeste";
    }

    @Override
    public String getImage() {
        return "gb.png";
    }
}
