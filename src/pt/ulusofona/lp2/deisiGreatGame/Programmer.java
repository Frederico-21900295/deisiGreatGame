package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Programmer {
    Integer jogadorID;
    String nome;
    String linguagens;
    ProgrammerColor color;
    Integer posicao;
    String estado;

    public Programmer () { }

    public Programmer (Integer id , String name, String lprogramacao, ProgrammerColor color) {
        this.jogadorID = id;
        this.nome = name;
        this.linguagens = lprogramacao;
        this.color = color;
        this.posicao = 1;
        this.estado = "Está em jogo";
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
        StringBuilder texto = new StringBuilder(this.jogadorID + " | " + this.nome + " | " + this.posicao + " | ");
        String aux = this.linguagens;
        int i = 0;
        int y = 1;
        ArrayList<String> aux1 = new ArrayList<>();

        //Retirar os espaços entre palavras da variavel linguagens
        aux = aux.replace(" ", "");


        //Retirar ';' e colocar dentro de uma Lista cada uma das linguagens preferidas
        if (aux.contains(";"))
        {
            Collections.addAll(aux1, aux.split(";"));
            Collections.sort(aux1);

        }

        /*
        Colocar dentro da variavel texto as linguagens de programaçao preferidas com o output desejado ;
        Caso so tenhas escolhido uma linguagem não faz este if
         */
        if (!aux1.isEmpty()) {
            for (int x = 0; x < aux1.size(); x++) {
                if ((aux1.size() - x) > 1) {
                    texto.append(aux1.get(x)).append(" ; ");
                }
                else {
                    texto.append(aux1.get(x));
                }

            }
            return texto +  " | " + this.color;

        }

        return texto + this.linguagens +  " | " + this.color;
    }



}
