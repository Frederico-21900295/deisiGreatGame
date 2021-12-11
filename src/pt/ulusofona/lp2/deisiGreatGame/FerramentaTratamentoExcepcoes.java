package pt.ulusofona.lp2.deisiGreatGame;

public class FerramentaTratamentoExcepcoes extends Ferramenta{
    FerramentaTratamentoExcepcoes(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Tratamento de Excepções";
    }


    @Override
    public String getFerramenta(Programmer player) {
        if (!player.temFerramenta("Tratamento de Excepções")) {
            player.addFerramentas("Tratamento de Excepções");
            return "Nova Ferramenta (Tratamento de Excepções)";
        }
        return "Já tem esta ferramenta";

    }

    @Override
    public String getImage() {
        return "thor.png";
    }
}
