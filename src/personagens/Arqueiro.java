package personagens;

public class Arqueiro extends Personagem{

    private final int agilidade;

    public Arqueiro(String nome, int pontosDeVida, int agilidade){
        super(nome, pontosDeVida);
        this.agilidade = agilidade;
    }

    @Override 
    public int atacar(){
        System.out.println(getNome() + " usa Flecha Tóxica!");
        return agilidade * 2;
    }

    @Override 
    public int usarHabilidade(){
        System.out.println(getNome() + " usa Tempestade de Flechas!");
        return agilidade * 3;
    }

}