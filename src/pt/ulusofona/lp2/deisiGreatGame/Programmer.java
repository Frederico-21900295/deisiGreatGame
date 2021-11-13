package pt.ulusofona.lp2.deisiGreatGame;
import java.util.ArrayList;
import java.util.Collections;


public class Programmer {
    Integer jogadorID;
    String nome;
    String linguagens;
    ProgrammerColor color;
    int posicao;
    String estado;


    public Programmer(Integer id, String name, String linguagens,String color) {
        this.jogadorID = id;
        this.nome = name;
        this.linguagens = linguagens;
        switch (color) {
            case "Purple" -> this.color = ProgrammerColor.PURPLE;
            case "Blue" -> this.color = ProgrammerColor.BLUE;
            case "Brown" -> this.color = ProgrammerColor.BROWN;
            case "Green" -> this.color = ProgrammerColor.GREEN;
        }
        this.posicao = 1;
        this.estado = "Em Jogo";
    }



    public int getId() {
        return this.jogadorID;
    }

    public String getName() {
        return this.nome;
    }

    public ProgrammerColor getColor() {
        return this.color;
    }


    @Override
    public String toString() {
        String linguagens = this.linguagens;
        String output;
        int x = 0;

        //Coloco neste array todas as linguagens preferidas do utilizador
        ArrayList<String> aux1 = new ArrayList<>();

        Collections.addAll(aux1, linguagens.split(";"));
        Collections.sort(aux1);

        StringBuilder outputBuilder = new StringBuilder(jogadorID + " | " + this.nome + " | " + this.posicao + " | ");
        for (String frase : aux1) {
            outputBuilder.append(frase);
            if (x != aux1.size() - 1) {
                outputBuilder.append("; ");
            }
            x++;
        }

        output = outputBuilder.toString();
        output+= " | " + estado;

        return output;


    }
}














