package pt.ulusofona.lp2.deisiGreatGame;

enum ProgrammerColor {
    PURPLE ("Purple"),
    BLUE ("Blue"),
    GREEN ("Green"),
    BROWN ("Brown");


    String nome;

    ProgrammerColor(String label) {
        this.nome = label;
    }


    @Override
    public String toString() {
        return nome;
    }





}
