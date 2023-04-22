
package infoventas;

import javax.swing.JOptionPane;
import sun.swing.StringUIClientPropertyKey;

public class ListaDoble
{
    private NodoDoble cabeza,ultimo;
    
    public ListaDoble() //Constructor vacio
    {
        cabeza = ultimo = null;
    }
    
    public boolean listaVacia()  //Método verificar si la lista está vacía
    {
        return cabeza == null;
    }
    
    public boolean codigoRegistrado(int codigo)
    {
       NodoDoble temporal = cabeza;
       while(temporal != null && temporal.codigo != codigo)
       {
           temporal = temporal.ligaDerecha;
       }
       return temporal != null;
    }
    
    public void agregarVendedor(int codigo, String nombre, String sexo, int ventasTot) //Método agregar vendedor a la lista
    {
        if(!listaVacia() && cabeza.codigo != codigo)
        {
            ultimo = new NodoDoble(codigo, nombre, sexo, ventasTot, null, ultimo);
            ultimo.ligaIzquierda.ligaDerecha = ultimo;
        }
        else
            {
                cabeza = ultimo = new NodoDoble(codigo, nombre, sexo, ventasTot);
            }
    }

    public void eliminarVendedor(int codigo) //Método para eliminar vendedor
    {
        if (!listaVacia())
        {
            if (cabeza == ultimo && codigo == cabeza.codigo)
            {
                cabeza = ultimo = null;
            }
            else if (codigo == cabeza.codigo)
            {
                cabeza = cabeza.ligaDerecha;
                cabeza.ligaIzquierda = null;
            }
        }
        else
            {
                NodoDoble anterior, siguiente, temporal;
                anterior = cabeza;
                siguiente = ultimo;
                temporal = cabeza.ligaDerecha;
                while(temporal != null && temporal.codigo != codigo)
                {
                    anterior = anterior.ligaDerecha;
                    temporal = temporal.ligaDerecha;
                    siguiente = siguiente.ligaDerecha;
                }
                if (temporal != null) 
                {
                    anterior.ligaDerecha = temporal.ligaDerecha;
                    siguiente.ligaIzquierda = temporal.ligaIzquierda;
                    if (temporal == ultimo)
                    {
                        ultimo = anterior;
                    }
                }
            }
    }
    
    
    public double calcularPromedio()
    {
        int acumulador = 0, contador = 0;
        int promedio = 0;
        NodoDoble n = cabeza.getLigaDerecha();
        while(n != null)
        {
            if (n.getVentasTot() > 0)
            {
                acumulador = acumulador + n.getVentasTot();
                contador = contador++;
            }
            n = n.getLigaDerecha();
        }
        promedio = acumulador/contador;
        return promedio;
    }

    public void mostrarListaInicioFin()
    {
        if(!listaVacia())
        {
            String datos = "<=>";
            NodoDoble nodoAuxiliar = cabeza;
            while(nodoAuxiliar != null)
            {
                datos = datos + "["+ nodoAuxiliar.codigo + nodoAuxiliar.nombre + nodoAuxiliar.sexo + nodoAuxiliar.ventasTot + "]\n";
                nodoAuxiliar = nodoAuxiliar.ligaDerecha;
            }
            JOptionPane.showMessageDialog(null, datos,
                    "Mostrando vendedores de inicio a fin",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
     public void mostrarListaFinInicio()
    {
        if(!listaVacia())
        {
            String datos = "<=>";
            NodoDoble nodoAuxiliar = ultimo;
            while(nodoAuxiliar != null)
            {
                datos = datos + "["+ nodoAuxiliar.codigo + nodoAuxiliar.nombre + nodoAuxiliar.sexo + nodoAuxiliar.ventasTot + "]\n";
                nodoAuxiliar = nodoAuxiliar.ligaIzquierda;
            }
            JOptionPane.showMessageDialog(null, datos,
                    "Mostrando lista de fin a inicio",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
