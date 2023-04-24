/* PRIMER TRABAJO:  Sofware InfoVentas
 * Elaborado por:
 * Carlos Andrey Henao Rincón
 * Elber Esteban González Torres
 * UdeA - Lógica y representación II
*/

package infoventas;


public class NodoDoble {
    
    private Vendedor vendedor;
    private NodoDoble nodoIzq,nodoDer;
    
    public NodoDoble(){
        this.vendedor = null;
        this.nodoIzq = this.nodoDer = null;
    }
    
    public NodoDoble(Vendedor vendedor){
        this.vendedor = vendedor;
        this.nodoIzq = this.nodoDer = null;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public NodoDoble getNodoIzq() {
        return nodoIzq;
    }

    public void setNodoIzq(NodoDoble nodoIzq) {
        this.nodoIzq = nodoIzq;
    }

    public NodoDoble getNodoDer() {
        return nodoDer;
    }

    public void setNodoDer(NodoDoble nodoDer) {
        this.nodoDer = nodoDer;
    }    

}
