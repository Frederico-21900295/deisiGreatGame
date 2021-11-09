package pt.ulusofona.lp2.deisiGreatGame;
import java.util.ArrayList;
import java.util.Arrays;
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


    @Override
    public String toString() {

        StringBuilder output = new StringBuilder(jogadorID + " | " + this.nome + " | " + this.posicao + " | ");
        int i = 0;
        ArrayList<String> aux1 = new ArrayList<>();

        Collections.addAll(aux1, lprogramacao.split(" ; "));
        String[] aux2 = new String[aux1.size()];

        for (String palavra : aux1) {
            aux2[i] = palavra;
            i++;

        }

        Arrays.sort(aux2, String.CASE_INSENSITIVE_ORDER);
        String lastSentence = aux2[aux2.length-1];
        System.out.println(lastSentence);

        for (String lp : aux2) {
            if (lastSentence.equals(lp)) {
                output.append(lp).append(" | ");
            }
            else {
                output.append(lp).append("; ");
            }
        }

        output.append(estado);
        return output.toString();
    }
}






        /*
        String linguagens = this.linguagens;
        int y = 0;
        StringBuilder apoio = new StringBuilder();

        ArrayList<String> aux1 = new ArrayList<>();
        ArrayList<String> auxParaArrays = new ArrayList<>();
        ArrayList<String> apoioAux = new ArrayList<>();


        Collections.addAll(aux1, linguagens.split(" ; "));


        //Colocar as palavras entre [] das linguagens de programação numa string para mais tarde ordenar
        for (int x = 0; x < aux1.size(); x++) {
            //System.out.println(aux1.get(x));
            if (aux1.get(x).startsWith("[")) {
                String valor = aux1.get(x).replace("[","");
                apoioAux.add(aux1.get(x));
                auxParaArrays.add(valor);
                y++;
            }
            else if(y == 1) {
                if (aux1.get(x).endsWith("]")) {
                    String valor = aux1.get(x).replace("]","");
                    apoioAux.add(aux1.get(x));
                    auxParaArrays.add(valor);
                    y = 0;
                }
                else {
                    apoioAux.add(aux1.get(x));
                    auxParaArrays.add(aux1.get(x) + " ");
                }
            }
        }

        //System.out.println("auxParaArrays = " + auxParaArrays);
        //Ordenar valores dentro []
        Collections.sort(auxParaArrays);
        //System.out.println("auxParaArrays = " + auxParaArrays);

        for (String lp : apoioAux) {
            //System.out.println("lp= " + lp);
            for (String frase : aux1) {
                //System.out.println("frase= " + frase);

                if (frase.equals(lp)) {
                    //System.out.println("tata");
                    if (frase.startsWith("[")) {
                        y++;
                    }
                    else if ( y == 1) {
                        if (frase.endsWith("]")) {
                            y--;
                        }
                        else {
                            apoio.append(frase).append(";");
                            break;
                        }
                    }
                }
            }
        }
        apoioAux.clear();
        Collections.addAll(apoioAux, apoio.toString().split("; "));


        //Remover elementos repetidos
        for (int q = 0; q < apoioAux.size(); q++) {
            String primeiro = apoioAux.get(q).replace(";","");
            aux1.remove(primeiro);
        }

        aux1.removeIf(frase -> frase.endsWith("]"));
        aux1.removeIf(frase -> frase.startsWith("["));






        //System.out.println("Começa");
        StringBuilder linguagensArray = new StringBuilder();
        String textinho = "";
        Collections.sort(aux1);
        for (int x = 0; x < aux1.size(); x++) {
            //System.out.println(aux1.get(x));
            textinho = aux1.get(x);
            textinho = textinho.replace(" ","");
            if (x != aux1.size() - 1) {
                textinho += "; ";
            }
            linguagensArray.append(textinho);
        }




        if (auxParaArrays.isEmpty()) {
            //Imprimir os resultados como o projeto quer

            return texto + linguagensArray + " | " + estado;
        }
        else {

            //Imprimir os resultados como o projeto quer
            //System.out.println("Começa");
            StringBuilder linguagensArray1 = new StringBuilder();
            linguagensArray.append("; ");
            String textinho1 = "[";
            linguagensArray1.append(textinho1);

            System.out.println(textinho1);
            Collections.sort(aux1);
            for (int x = 0; x < auxParaArrays.size(); x++) {
                System.out.println(auxParaArrays.get(x));
                textinho1 = auxParaArrays.get(x);

                if ((x != aux1.size())) {
                    textinho1 += "; ";
                }
                linguagensArray1.append(textinho1);
            }
            linguagensArray1.append("]");
            return texto + linguagensArray + linguagensArray1 + " | " + estado;


        }





        //return texto + " | " + this.estado;

*/











