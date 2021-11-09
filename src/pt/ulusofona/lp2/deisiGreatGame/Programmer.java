package pt.ulusofona.lp2.deisiGreatGame;
import java.util.ArrayList;
import java.util.Collections;


public class Programmer {
    Integer jogadorID;
    String nome;
    String lprogramacao;
    ProgrammerColor color;
    Integer posicao;
    String estado;

    public Programmer() {
    }

    public Programmer(Integer id, String name, String lprogramacao, ProgrammerColor color) {
        this.jogadorID = id;
        this.nome = name;
        this.lprogramacao = lprogramacao;
        this.posicao = 1;
        this.color = color;
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


//Fazer sort da arrayList
    //E depois so modificar , para ;


    @Override
    public String toString() {
        String linguagens = this.lprogramacao;
        String output;
        int x = 0;

        //Coloco neste array todas as linguagens preferidas do utilizador
        ArrayList<String> aux1 = new ArrayList<>();

        Collections.addAll(aux1, linguagens.split(" ; "));

        System.out.println(aux1);


        aux1.sort((o1, o2) -> {
            if (o1.startsWith("[")) {
                return Character.compare(o1.charAt(1), o2.charAt(0));
            }
            else if (o2.startsWith("[")) {
                return Character.compare(o1.charAt(0), o2.charAt(1));
            }
            else if (o1.isEmpty() || o2.isEmpty()) {
                return 1;
            }
            else {
                return Character.compare(o1.charAt(0), o2.charAt(0));
            }
        });

        //Collections.sort(aux1);
        //Common Lisp; [ ]PHP

        StringBuilder outputBuilder = new StringBuilder(jogadorID + " | " + this.nome + " | " + this.posicao + " | ");
        for (String frase : aux1) {

            outputBuilder.append(frase);
            if (x != aux1.size() - 1) {
                outputBuilder.append("; ");
            }
            x++;
        }
        System.out.println(aux1);

        output = outputBuilder.toString();
        output+= " | " + estado;

        return output;


    }
}














