package pt.ulusofona.lp2.deisiGreatGame;

import java.util.List;

public class AbismoCicloInfinito extends Abismo {

    AbismoCicloInfinito(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Ciclo infinito";
    }

    @Override
    String getAbismo(Programmer player, List<Programmer> jogadores, Integer dado) {
        if (player == null) {
            return null;
        }
        List <String> ferramentas = player.getFerramentas();
        int id = player.getId();

        for (String f : ferramentas){
            if (f.equals("Programação Funcional")) {
                player.retirarFerramenta(f);
                return "Usaste a ferramenta " + f + " para o seguinte abismo (Ciclo Infinito) ";
            }
        }

        player.cicloInfinito(true, player.getPosicao());
        for (Programmer jogador : jogadores) {
            if (jogador.getId() != id) {
                if (jogador.getCicloInfinito() && jogador.getPosicao() == player.getPosicao()) {
                    jogador.cicloInfinito(false,0);
                    return "Retiraste o " + jogador.getName() + "do ciclo infinito";
                }
            }
        }
        return "Ficaste preso num ciclo infinito, espera que outro jogador tenha o mesmo azar";
    }

    @Override
    public String getImage() {
        return "harrypotter.png";
    }
}
