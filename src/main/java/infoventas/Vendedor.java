/* PRIMER TRABAJO:  Sofware InfoVentas
 * Elaborado por:
 * Carlos Andrey Henao Rincón
 * Elber Esteban González Torres
 * UdeA - Lógica y representación II
*/

package infoventas;

public class Vendedor {
    
    private int codigo;
    private String nombre;
    private char sexo;
    private int totalVenta;
    
    public Vendedor(){}
    
    public Vendedor(int codigo, String nombre, char sexo, int totalVenta){
        this.codigo = codigo;
        this.nombre = nombre;
        this.sexo = sexo;
        this.totalVenta = totalVenta;
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

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(int totalVenta) {
        this.totalVenta = totalVenta;
    }        
        
}
