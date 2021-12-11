package pt.ulusofona.lp2.deisiGreatGame;


public class FerramentaHerança extends Ferramenta{

    FerramentaHerança(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Herança";
    }

    @Override
    public String getFerramenta(Programmer player) {
        if (!player.temFerramenta("Herança")) {
            player.addFerramentas("Herança");
            return "Nova Ferramenta (Herança)";
        }
        return "Já tem esta ferramenta";

    }

    @Override
    public String getImage() {
            return "pokeball.png";
    }


}
