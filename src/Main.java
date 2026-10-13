import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

import batalha.Batalha;
import personagens.Arqueiro;
import personagens.Guerreiro;
import personagens.Mago;
import personagens.Personagem;

public class Main{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        ArrayList<Personagem> personagens = criarPersonagens();

        System.out.println("================================");
        System.out.println();
        System.out.println("         " + Personagem.NOME_DO_JOGO);
        System.out.println();
        System.out.println("================================");
        System.out.println();

        // Seleciona o personagem do jogador
        mostrarPersonagens(personagens, "Selecione o personagem: ");

        Personagem personagemSelecionado =
            selecionarPersonagem(personagens, scanner);

        System.out.println();
        System.out.println("VOCÊ SELECIONOU: ");
        System.out.println();

        personagemSelecionado.exibirDados();

        System.out.println();

        // Seleciona o adversário
        Personagem adversarioSelecionado =
            selecionarAdversario(
                personagens,
                personagemSelecionado
            );

        System.out.println();
        System.out.println("O ADVERSÁRIO FOI SORTEADO!");
        System.out.println();

        adversarioSelecionado.exibirDados();

        System.out.println();

        // Inicia a batalha
        Batalha batalha = new Batalha(
            personagemSelecionado,
            adversarioSelecionado,
            scanner
        );

        // Controla as rodadas da batalha
        int rodada = 1;

        while(
            personagemSelecionado.estaVivo()
            && adversarioSelecionado.estaVivo()
        ){

            batalha.executarRodada(rodada);
            rodada++;

        }

        scanner.close();

    }


    // Cria os personagens disponíveis
    private static ArrayList<Personagem> criarPersonagens(){

        ArrayList<Personagem> personagens = new ArrayList<>();

        personagens.add(new Guerreiro("Elesis", 100, 10));
        personagens.add(new Mago("Arme", 100, 8));
        personagens.add(new Arqueiro("Lire", 100, 6));

        return personagens;

    }


    // Exibe os personagens disponíveis
    private static void mostrarPersonagens(
            ArrayList<Personagem> personagens,
            String mensagem){

        System.out.println(mensagem);

        for(int i = 0; i < personagens.size(); i++){

            System.out.println(
                (i + 1) + " - " + personagens.get(i).getNome()
            );

        }

    }


    // Lê uma entrada e converte para número inteiro
    private static Integer lerInteiro(Scanner scanner){

        String entrada = scanner.next();

        try{

            return Integer.parseInt(entrada);

        } catch(NumberFormatException e){

            System.out.println("Digite apenas um número!");
            return null;

        }

    }


    // Seleciona o personagem do jogador
    private static Personagem selecionarPersonagem(
            ArrayList<Personagem> personagens,
            Scanner scanner){

        while(true){

            Integer escolha = lerInteiro(scanner);

            if(escolha == null){

                continue;

            } else if(
                escolha < 1
                || escolha > personagens.size()
            ){

                System.out.println(
                    "Seleção inválida. Escolha um personagem disponível!"
                );

                continue;

            }

            return personagens.get(escolha - 1);

        }

    }


    // Seleciona o adversário
    private static Personagem selecionarAdversario(
            ArrayList<Personagem> personagens,
            Personagem personagemSelecionado){

        Random random = new Random();

        Personagem adversarioSelecionado;

        do {

            int indice = random.nextInt(personagens.size());
            adversarioSelecionado = personagens.get(indice);

        } while (adversarioSelecionado == personagemSelecionado);

        return adversarioSelecionado;

    }

}