package pt.ulusofona.lp2.deisiGreatGame;

import java.util.List;

public class AbismoErroLogica extends Abismo {

    AbismoErroLogica(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Erro de lógica";
    }

    @Override
    String getAbismo(Programmer player, List<Programmer> jogadores, Integer dado) {
        List <String> ferramentas = player.getFerramentas();

        for (String f : ferramentas){
            if (f.equals("Ajuda Do Professor") || f.equals("Testes unitários")) {
                player.retirarFerramenta(f);
                return "Usaste a ferramenta " + f + " para o seguinte abismo (Erro de Lógica) ";
            }
        }
        int valordado = dado;
        int auxPosicao = player.getPosicao() - (valordado / 2);
        player.mudarPosicao(auxPosicao);
        return "Regressa o valor da metade dos teus dados atrás";
    }

    @Override
    public String getImage() {
        return "venom.png";
    }
}
