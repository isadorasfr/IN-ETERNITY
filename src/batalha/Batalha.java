package batalha;

import java.util.Random;
import java.util.Scanner;

import personagens.Personagem;

public class Batalha {
    
    private final Personagem personagem;
    private final Personagem adversario;
    private final Scanner scanner;
    private final Random random;

    public Batalha(Personagem personagem, Personagem adversario, Scanner scanner){

        this.personagem = personagem;
        this.adversario = adversario;
        this.scanner = scanner;
        this.random = new Random();

    }

    //Executa uma rodada da batalha

    public void executarRodada(int rodada){

        System.out.println("________________________________");
        System.out.println();
        System.out.println("            RODADA " + rodada);
        System.out.println("________________________________");
        System.out.println();

        System.out.println(
            personagem.getNome() + ": " +
            personagem.getPontosDeVida() + " HP"
        );

        System.out.println(
            adversario.getNome() + ": " +
            adversario.getPontosDeVida() + " HP"
        );

        executarTurnoJogador();

        if(!adversario.estaVivo()){
            finalizarBatalha();
            return;
        }

        executarTurnoAdversario();

        System.out.println();

        if(!personagem.estaVivo()){
            finalizarBatalha();
            return;
        }

    }

    private void executarTurnoJogador(){

        executarTurno(personagem, adversario);

    }

    private void executarTurnoAdversario(){

        executarTurno(adversario, personagem);

    }

    // Executa a ação escolhida pelo personagem
    private void executarTurno(Personagem atacante, Personagem alvo){

        int escolha;

        if(atacante == personagem){

            escolha = escolherAcao(atacante.getNome());

        } else {

            escolha = random.nextInt(3) + 1;

            System.out.println();
            System.out.println("TURNO DE " + atacante.getNome().toUpperCase());
            System.out.println("----------------");
            System.out.println();
           
            if(escolha == 1){

                System.out.println(
                    atacante.getNome() + " escolheu: Ataque"
                );

            } else if(escolha == 2){

                System.out.println(
                    atacante.getNome() +
                    " escolheu: Habilidade especial"
                );

            } else {

                System.out.println(
                    atacante.getNome() + " escolheu: Defender"
                );

            }

        }

        switch(escolha){

            case 1:

                System.out.println();

                int dano = atacante.atacar();

                alvo.receberDano(dano, atacante);
                break;

            case 2:

                System.out.println();

                dano = atacante.usarHabilidade();

                alvo.receberDano(dano, atacante);
                break;

            case 3:

                System.out.println();

                atacante.defender();
                break;

        }

    }

    // Exibe as opções de ação e salva a escolha do jogador

    private int escolherAcao(String nome){

        int escolha = 0;

        while(escolha < 1 || escolha > 3){

            System.out.println();
            System.out.println("TURNO DE " + nome.toUpperCase());
            System.out.println("----------------");
            System.out.println();


            System.out.println("1 - Ataque");
            System.out.println("2 - Habilidade especial");
            System.out.println("3 - Defender");

            System.out.println();

            try{

                System.out.print("Escolha uma ação: ");

                String entrada = scanner.next();

                escolha = Integer.parseInt(entrada);

                if(escolha == 1){

                    System.out.println();
                    System.out.println(nome + " escolheu: Ataque");

                } else if(escolha == 2){

                    System.out.println();
                    System.out.println(nome + " escolheu: Habilidade especial");

                } else if(escolha == 3){

                    System.out.println();
                    System.out.println(nome + " escolheu: Defender");

                } else {

                    System.out.println();
                    System.out.println("Ação inválida! Escolha novamente.");

                }

            } catch(NumberFormatException e) {

                System.out.println();
                System.out.println("Digite apenas um número!");

                escolha = 0;

            }

        }

        return escolha;

    }

    // Exibe o resultado final da batalha

    private void finalizarBatalha(){

        System.out.println();
        System.out.println("================================");
        System.out.println();
        System.out.println("         FIM DA BATALHA");
        System.out.println();
        System.out.println("================================");
        System.out.println();

        if(personagem.estaVivo()){

            System.out.println(
                personagem.getNome() + " venceu!"
            );

        } else {

            System.out.println(
                adversario.getNome() + " venceu!"
            );

        }

        System.out.println();

    }

}