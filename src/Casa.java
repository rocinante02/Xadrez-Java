import java.util.ArrayList;
/**
 * Representa uma Casa do tabuleiro.
 * Possui uma posi�ao (i,j) e pode conter uma Pe�a.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Casa {

    private int x;
    private int y;
    private Peca peca;

    public Casa(int x, int y) {
        this.x = x;
        this.y = y;
        this.peca = null;
    }
    
    /**      
     * @return Valor x dessa casa.
     */    
    public int getX(){
        return x;
    }

    /**      
     * @return Valor y dessa casa.
     */    
    public int getY(){ 
        return y;
    }
    
    /**
     * @param peca a Pe�a a ser posicionada nesta Casa.
     */
    public void colocarPeca(Peca peca) {
        this.peca = peca;
    }
    
    /**
     * Remove a peca posicionada nesta casa, se houver.
     */
    public void removerPeca() {
        peca = null;        
    }
    
    /**
     * @return a Peca posicionada nesta Casa, ou Null se a casa estiver livre.
     */
    public Peca getPeca() {
        return peca;
    }
    
    /**
     * @return true se existe uma pe�a nesta casa, caso contrario false.
     */
    public boolean possuiPeca() {
        return peca != null;
    }
    
    public boolean casaAtacada(Player oposto,Tabuleiro tabuleiro) {
        ArrayList<Peca> atacantes = new ArrayList<Peca>();
        for(Peca pc : oposto.getPecas()){
           ArrayList<Casa> movimentos = pc.movimentosLegais(tabuleiro);
           if(movimentos.contains(this)) return true;
           
        }
        return false;
    }
}
