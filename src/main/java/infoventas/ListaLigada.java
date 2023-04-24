/* PRIMER TRABAJO:  Sofware InfoVentas
 * Elaborado por:
 * Carlos Andrey Henao Rincón
 * Elber Esteban González Torres
 * UdeA - Lógica y representación II
*/

package infoventas;

import javax.swing.JOptionPane;

public class ListaLigada {
   
    private NodoDoble cab, ult, x, y, p;
    
    public ListaLigada()
    {
        this.cab = new NodoDoble();
        this.ult = this.cab;
        this.x = this.cab; 
    }
    
    
    public void addNodo(Vendedor vendedor) //Método para agregar vendednror
    {
        NodoDoble p = new NodoDoble(vendedor);
        p.setNodoIzq(this.ult);
        ult.setNodoDer(p);
        ult = p;
        y = ult;
    }
    
    
    public boolean existeCodigoVendedor(int codigo) // Método para verificar la existencia del código       
    {
        Vendedor vendedor;
        boolean codigoExiste = false;
        vendedor = imprimirVendedorPrimero_Ultimo();
        while(vendedor!= null)
        {                  
            if (vendedor.getCodigo() == codigo){ codigoExiste = true; }
            vendedor = imprimirVendedorPrimero_Ultimo();
        }
        return codigoExiste;
    }
    
    
    public void eliminarVendedor(int codigo)  //Método para eliminar vendedor del sistema
    { 
      NodoDoble p = x.getNodoDer();
      NodoDoble eliminar = p;
      while(p.getNodoDer() != null && p.getVendedor().getCodigo() != codigo)
      {
        p = p.getNodoDer();
        eliminar = p;
      }
        if (p.getNodoDer() != null)
        {
            eliminar.getNodoIzq().setNodoDer(eliminar.getNodoDer());
            eliminar.getNodoDer().setNodoIzq(eliminar.getNodoIzq());
        }
        else
            {
                eliminar.getNodoIzq().setNodoDer(eliminar.getNodoDer());
            }
    }
    
    
    public double promedioVentaEmpresa() // Método que cálcula el promedio total de las ventas
    {
        Vendedor vendedor;
        vendedor = imprimirVendedorPrimero_Ultimo();
        double venta = 0;
        double cantidadVendedores = 0;
        while(vendedor != null)
        {                  
           cantidadVendedores++;
           venta = venta + vendedor.getTotalVenta();
           vendedor = imprimirVendedorPrimero_Ultimo();
        }
        return venta/cantidadVendedores;               
    }
    
    
    public int ventaMayorMujer() //Método que evalúa la venta mayor de las vendedoras
    {
        Vendedor vendedor;
        int venta = 0;
        vendedor = imprimirVendedorPrimero_Ultimo();
        while(vendedor != null)
        {                  
            if(vendedor.getSexo() == 'F') {                
                if (venta < vendedor.getTotalVenta())
                {
                    venta = vendedor.getTotalVenta() ;
                }
            }
            vendedor = imprimirVendedorPrimero_Ultimo();                    
        }       
        return venta;       
    }
    
    
    public int ventaMenorHombre() // Método que evalúa la venta menor de los vendedores
     {
        Vendedor vendedor;
        vendedor = imprimirVendedorPrimero_Ultimo();
        int venta = vendedor.getTotalVenta();
        while(vendedor != null){
            if(vendedor.getSexo() == 'M')
            {                
                if (venta > vendedor.getTotalVenta())
                {
                    venta = vendedor.getTotalVenta() ;
                }
            }
            vendedor = imprimirVendedorPrimero_Ultimo();                    
        }       
        return venta;       
    } 
    
    
    public int totalVendedorGenero(char sexo) // Método calcula la cantidad de vendedores según genero
     {
        Vendedor vendedor;
        int total = 0;
        vendedor = imprimirVendedorPrimero_Ultimo();
        while(vendedor!= null)
        {                  
            if(vendedor.getSexo()== sexo)
            {
                total++;
            }
            vendedor = imprimirVendedorPrimero_Ultimo();                    
        }       
        return total;
    }  
    
    
    public Vendedor imprimirVendedorPrimero_Ultimo() // Método que imprime vendedores del primero al último
    {   
        x = x.getNodoDer();
        if (x == null)
        {
            x = cab;
        }
        return x.getVendedor();
    } 
    
    
    public Vendedor imprimirVendedorUltimo_Primero() // Método que imprime vendedores del último al primero
    {        
        if (y == cab)
        {
            y = ult;
            return null;
        }
        y = y.getNodoIzq();
        return y.getNodoDer().getVendedor();
    }  
}
