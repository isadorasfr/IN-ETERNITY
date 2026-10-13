package personagens;

public class Mago extends Personagem{

    private final int inteligencia;

    public Mago(String nome, int pontosDeVida, int inteligencia){
        super(nome, pontosDeVida);
        this.inteligencia = inteligencia;
    }

    @Override 
    public int atacar(){
        System.out.println(getNome() + " lança Bola de Fogo!");
        return inteligencia * 3;
    }

    @Override 
    public int usarHabilidade(){
        System.out.println(getNome() + " usa Prisão de Gelo!");
        return inteligencia * 4;
    }

}