package pt.ulusofona.lp2.deisiGreatGame;

public class FerramentaProgramacaoFuncional extends Ferramenta{

    FerramentaProgramacaoFuncional(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Programação Funcional";

    }

    @Override
    public String getFerramenta(Programmer player) {
        if (!player.temFerramenta("Programação Funcional")) {
            player.addFerramentas("Programação Funcional");
            return "Nova Ferramenta (Programação Funcional)";
        }
        return "Já tem esta ferramenta";

    }

    @Override
    public String getImage() {
            return "Hp.png";
    }

}