package personagens;

public class Guerreiro extends Personagem{

    private final int forca;

    public Guerreiro(String nome, int pontosDeVida, int forca){
        super(nome, pontosDeVida);
        this.forca = forca;
    }

    @Override 
    public int atacar(){
        System.out.println(getNome() + " usa Lâmina Circular!");
        return forca * 2;
    }

    @Override 
    public int usarHabilidade(){
        System.out.println(getNome() + " usa Onda Flamejante!");
        return forca * 3;
    }

}