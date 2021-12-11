package pt.ulusofona.lp2.deisiGreatGame;

public class FerramentaProgramaçãoFuncional extends Ferramenta{

    FerramentaProgramaçãoFuncional(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Programação funcional";

    }

    @Override
    public String getFerramenta(Programmer player) {
        if (!player.temFerramenta("Programação funcional")) {
            player.addFerramentas("Programação funcional");
            return "Nova Ferramenta (Programação funcional)";
        }
        return "Já tem esta ferramenta";

    }

    @Override
    public String getImage() {
            return "Hp.png";
    }

}