package pt.ulusofona.lp2.deisiGreatGame;

public class FerramentaTestesUnitarios extends Ferramenta{

    FerramentaTestesUnitarios(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Testes unitários";
    }

    @Override
    public String getFerramenta(Programmer player) {
        if (!player.temFerramenta("Testes unitários")) {
            player.addFerramentas("Testes unitários");
            return "Nova Ferramenta (Testes unitários)";
        }
        return "Já tem esta ferramenta";

    }

    @Override
    public String getImage() {
        return "homem-aranha.png";
    }

}