package pt.ulusofona.lp2.deisiGreatGame;

import java.util.List;

public class AbismoErroSintaxe  extends Abismo {

    AbismoErroSintaxe(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Erro de sintaxe";
    }

    @Override
    String getAbismo(Programmer player, List<Programmer> jogadores, Integer dado) {
        List <String> ferramentas = player.getFerramentas();

        for (String f : ferramentas){
            if (f.equals("Ajuda Do Professor") || f.equals("IDE")) {
                player.retirarFerramenta(f);
                return "Usaste a ferramenta " + f + " para o seguinte abismo (Erro de Sintaxe) ";
            }
        }
        int aux = player.getPosicao() - 1;
        player.mudarPosicao(aux);
        return "Regressa 1 casa atrás";
    }

    @Override
    public String getImage() {
        return "thanos.png";
    }
}
