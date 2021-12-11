package pt.ulusofona.lp2.deisiGreatGame;

public class FerramentaTestesUnitarios extends Ferramenta{

    FerramentaTestesUnitarios(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Testes unitarios";
    }

    @Override
    public String getFerramenta(Programmer player) {
        if (!player.temFerramenta("Testes unitarios")) {
            player.addFerramentas("Testes unitarios");
            return "Nova Ferramenta (Testes unitarios)";
        }
        return "Já tem esta ferramenta";

    }

    @Override
    public String getImage() {
        return "homem-aranha.png";
    }

}