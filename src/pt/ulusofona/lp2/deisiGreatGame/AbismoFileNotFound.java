package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.List;

public class AbismoFileNotFound extends Abismo {

    AbismoFileNotFound(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "File Not Found Exception";
    }

    @Override
    String getAbismo(Programmer player, List<Programmer> jogadores, Integer dado) {
        if (player == null) {
            return null;
        }
        List <String> ferramentas = player.getFerramentas();
        for (String f : ferramentas){
            if (f.equals("Ajuda Do Professor") || f.equals("Tratamento de Excepções")) {
                player.retirarFerramenta(f);
                return "Usaste a ferramenta " + f + " para o seguinte abismo (File not Found) ";
            }
        }
        ArrayList<Integer> historico;

        historico = player.getHistoricoPosicoes();
        int i = historico.size() - 1;

        if (i <= 0) {
            player.mudarPosicao(1);
        }
        else {
            int valorPosicao = (historico.get(i));

            valorPosicao -= 3;
            player.mudarPosicao(valorPosicao);
        }
        this.numeroPisadas += 1;


        return "Regressa 3 casas atrás";
    }

    @Override
    public String getImage() {
        return "Mysterio.png";
    }
}