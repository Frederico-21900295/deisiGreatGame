package pt.ulusofona.lp2.deisiGreatGame;

public class FerramentaAjudaProfessor extends Ferramenta{
    FerramentaAjudaProfessor(String name, String type, String position) {
        super(name, type, position);
        this.tipo = "Ajuda do professor";
    }

    @Override
    public String getFerramenta(Programmer player) {
        if (!player.temFerramenta("Ajuda do professor")) {
            player.addFerramentas("Ajuda do professor");
            return "Nova Ferramenta (Ajuda do professor)";
        }
        return "Já tem esta ferramenta";

    }

    @Override
    public String getImage() {
        return "Avengers.png";
    }

}
