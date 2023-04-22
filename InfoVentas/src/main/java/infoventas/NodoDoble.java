
package infoventas;

public class NodoDoble
{
    int codigo; 
    String nombre;
    String sexo;
    int ventasTot;
    
    NodoDoble ligaDerecha, ligaIzquierda;
    
    public NodoDoble(int codigo, String nombre, String sexo, int ventasTot)
    {
        this(codigo, nombre, sexo, ventasTot, null, null);
    }

    public NodoDoble(int codigo, String nombre, String sexo, int ventasTot, NodoDoble ligaDerecha, NodoDoble ligaIzquierda)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sexo = sexo;
        this.ventasTot = ventasTot;
        this.ligaDerecha = ligaDerecha;
        this.ligaIzquierda = ligaIzquierda;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getVentasTot() {
        return ventasTot;
    }

    public void setVentasTot(int ventasTot) {
        this.ventasTot = ventasTot;
    }

    public NodoDoble getLigaDerecha() {
        return ligaDerecha;
    }

    public void setLigaDerecha(NodoDoble ligaDerecha) {
        this.ligaDerecha = ligaDerecha;
    }

    public NodoDoble getLigaIzquierda() {
        return ligaIzquierda;
    }

    public void setLigaIzquierda(NodoDoble ligaIzquierda) {
        this.ligaIzquierda = ligaIzquierda;
    }
    
    
    
}
