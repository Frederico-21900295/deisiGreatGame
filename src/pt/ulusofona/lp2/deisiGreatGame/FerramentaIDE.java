package pt.ulusofona.lp2.deisiGreatGame;

public class FerramentaIDE extends Ferramenta{
    FerramentaIDE(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "IDE";
    }

    @Override
    public String getFerramenta(Programmer player) {
        if (player == null) {
            return null;
        }
        if (!player.temFerramenta("IDE")) {
            player.addFerramentas("IDE");
            return "Nova Ferramenta (IDE)";
        }
        return "Já tem esta ferramenta";

    }

    @Override
    public String getImage() {
        return "ironMan.png";
    }
}
