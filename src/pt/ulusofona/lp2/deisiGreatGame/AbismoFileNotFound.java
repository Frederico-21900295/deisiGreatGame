package pt.ulusofona.lp2.deisiGreatGame;

import java.util.List;

public class AbismoFileNotFound extends Abismo {

    AbismoFileNotFound(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "File Not Found Exception";
    }

    @Override
    String getAbismo(Programmer player, List<Programmer> jogadores, Integer dado) {
        List <String> ferramentas = player.getFerramentas();
        for (String f : ferramentas){
            if (f.equals("Ajuda Do Professor") || f.equals("Tratamento de Excepções")) {
                player.retirarFerramenta(f);
                return "Usaste a ferramenta " + f + "para o seguinte abismo (File not Found) ";
            }
        }
        int aux = player.getPosicao() - 3;
        if (aux < 0 ) {
            player.mudarPosicao(1);
        }
        player.mudarPosicao(aux);
        return "Regressa 3 casas atrás";
    }

    @Override
    public String getImage() {
        return "groot.png";
    }
}