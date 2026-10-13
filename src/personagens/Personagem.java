package personagens;

public abstract class Personagem{

    private final String nome;
    private int pontosDeVida;
    private boolean defendendo;

    public static final String NOME_DO_JOGO = "IN ETERNITY";

    public String getNome(){
        return nome;
    }

    public int getPontosDeVida(){
        return pontosDeVida;
    }

    public Personagem(String nome, int pontosDeVida){
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
    }

    public void exibirDados(){

        System.out.println(
            nome +
            "\n" + pontosDeVida + " HP"
        );

    }

    public abstract int atacar();

    public abstract int usarHabilidade();

    public void receberDano(int dano, Personagem atacante){

        if (defendendo) {
            dano = dano / 2;
            defendendo = false;

            System.out.println(getNome() + " bloqueou parte do dano!");
        }

        pontosDeVida = pontosDeVida - dano;

        if (pontosDeVida < 0) {
            pontosDeVida = 0;
        }

        System.out.println();
        System.out.println("-> Dano causado: " + dano);
        System.out.println("-> " + getNome() + ": " + pontosDeVida + " HP");
    }

    public void defender(){
        defendendo = true;
        System.out.println(getNome() + " está se defendendo!");
    }

    public boolean estaVivo(){
        return pontosDeVida > 0;
    }

}