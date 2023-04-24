/* PRIMER TRABAJO:  Sofware InfoVentas
 * Elaborado por:
 * Carlos Andrey Henao Rincón
 * Elber Esteban González Torres
 * UdeA - Lógica y representación II
*/

package infoventas;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class ProgramLista 
{
    
   ListaLigada lista;
  
   public void runProgram()
   { 
       
       this.lista = new ListaLigada();       
       int opcion = 0;
       int codigo;
       String nombre;
       char sexo;
       int totalVenta;
       String sentido;
       String datosVendedor ="";
       Vendedor vendedor;
       
       do 
        {            
            try
            {
                 opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                      "1. Ingresar un nuevo vendedor\n"
                               + "2. Eliminar un vendedor\n"
                               + "3. Mostrar el promedio de ventas de la empresa\n"
                               + "4. Mostrar el mayor total ventas de las vendedoras (Mujeres)\n"
                               + "5. Mostrar el menor total ventas de los vendedores (Hombres)\n"
                               + "6. Mostrar el total de vendedores (Hombres o Mujeres)\n"
                               + "7. Mostrar los datos de vendedores\n"
                               + "8. Salir\n"
                               + "\n"
                               + "Por favor elija una opción:", "InfoVentas - Software para gestión de vendedores",
                               JOptionPane.INFORMATION_MESSAGE));
                 switch(opcion)
                 {
                     case 1: 
                         codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
                                 "Ingrese el código del vendedor"));
                         if (!lista.existeCodigoVendedor(codigo))
                                 {                                    
                                       nombre = (JOptionPane.showInputDialog(null,
                                            "Ingresa el nombre del vendedor", "Nombre Agregado",
                                            JOptionPane.INFORMATION_MESSAGE));
                                       sexo = (JOptionPane.showInputDialog(null,
                                               "Seleccione el sexo del vendedor", "Selección de Sexo: ",
                                               JOptionPane.PLAIN_MESSAGE,null,new Object[]{"Masculino", "Femenino"},
                                               "Masculino")).toString().charAt(0);
                                       totalVenta = Integer.parseInt(JOptionPane.showInputDialog(null,
                                               "Ingrese el total de ventas del vendedor", "Total Ventas Agregado",
                                               JOptionPane.INFORMATION_MESSAGE));

                                       lista.addNodo(new Vendedor(codigo,nombre,sexo,totalVenta));
                                     
                                 } else {
                                            JOptionPane.showMessageDialog(null,"Ya existe un vendedor con el código "
                                      + codigo + "\n" + "Intente nuevamente", "Error - Validación de código", JOptionPane.INFORMATION_MESSAGE);
                                        }           
                        break;
                        
                     case 2:
                         codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del "
                         + "vendedor a eliminar: ", "Eliminando Vendedor", JOptionPane.INFORMATION_MESSAGE));
                         if (lista.existeCodigoVendedor(codigo))
                         {
                            lista.eliminarVendedor(codigo);
                            JOptionPane.showMessageDialog(null, "El vendedor con código " + codigo + " se ha eliminado del sistema",
                                    "Eliminando vendedor", JOptionPane.INFORMATION_MESSAGE);
                         }
                         else
                            {
                                JOptionPane.showMessageDialog(null,"El vendedor con código "+ codigo + " No está en el sistema",
                                        "Vendedor no encontrado", JOptionPane.INFORMATION_MESSAGE);
                            }
                         break;
                           
                     case 3:
                         JOptionPane.showMessageDialog(null,"El promedio de ventas de la empresa es:  $ "
                                      + lista.promedioVentaEmpresa(), "Promedio de ventas", JOptionPane.INFORMATION_MESSAGE);        
                         break;
                         
                     case 4:
                         sexo = 'F';
                         if (lista.totalVendedorGenero(sexo) != 0)
                         {
                             JOptionPane.showMessageDialog(null,"El mayor total de ventas de las vendedoras mujeres es:  $ "
                                      + lista.ventaMayorMujer(), "Mayor total ventas mujeres", JOptionPane.INFORMATION_MESSAGE);
                         }
                         else
                            {
                                JOptionPane.showMessageDialog(null,"No existen vendedoras en el registro ",
                                       "Mayor total vendedoras", JOptionPane.INFORMATION_MESSAGE);
                            }
                         break;
                         
                     case 5:
                         sexo = 'M';
                         if (lista.totalVendedorGenero(sexo) != 0)
                         {
                             JOptionPane.showMessageDialog(null,"El menor total de ventas de los vendedores hombres es:  $ "
                                      + lista.ventaMenorHombre(), "Menor total ventas hombres", JOptionPane.INFORMATION_MESSAGE);
                         }
                         else
                            {
                              JOptionPane.showMessageDialog(null,"No existen vendedores en el registro ",
                                       "Menor total vendedores", JOptionPane.INFORMATION_MESSAGE);  
                            }
                         break;
                         
                     case 6:
                         sexo = (JOptionPane.showInputDialog(null,
                              "Selecciona el genero de los vendedores a consultar", "Elegir genero vendedor",
                              JOptionPane.PLAIN_MESSAGE,null, new Object[]{"Masculino","Femenino"},
                              "Masculino")).toString().charAt(0);
                            switch (sexo) {
                             case 'M':
                                 if (lista.totalVendedorGenero(sexo) != 0)
                                 {
                                     JOptionPane.showMessageDialog(null,"El total de vendedores hombres es:  "
                                      + lista.totalVendedorGenero('M'), "Total vendedores hombres", JOptionPane.INFORMATION_MESSAGE);
                                 }
                                 else
                                    {
                                        JOptionPane.showMessageDialog(null,"No existen vendedores en el registro ",
                                       "Total vendedores hombres", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                 break;
                             
                             case 'F':
                                 if (lista.totalVendedorGenero(sexo) != 0)
                                 {
                                     JOptionPane.showMessageDialog(null,"El total de vendedoras mujeres es: "
                                      + lista.totalVendedorGenero('F'), "Total vendedoras mujeres", JOptionPane.INFORMATION_MESSAGE);
                                 }
                                 else
                                    {
                                        JOptionPane.showMessageDialog(null,"No existen vendedoras en el registro ",
                                       "Total vendedoras mujeres", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                 break;
                         }
                         break;
                      
                     case 7:
                         sentido = (JOptionPane.showInputDialog(null,
                              "Selecciona el sentido para ver los vendedores", "Elegir Sentido",
                              JOptionPane.PLAIN_MESSAGE,null, new Object[]{"Primero al último","Último al primero"},
                              "Derecho")).toString();
                            switch(sentido)
                            {            
                                case "Primero al último":
                                    vendedor = lista.imprimirVendedorPrimero_Ultimo();
                                    if (vendedor != null) 
                                    {
                                        while (vendedor != null) 
                                        {
                                            datosVendedor = datosVendedor + "Código: "+ vendedor.getCodigo()
                                              +  "  -  Nombre: " + vendedor.getNombre() + "  -  Sexo: " + vendedor.getSexo()
                                                + "  -  Ventas Totales: $" + vendedor.getTotalVenta() + "\n";
                                                vendedor = lista.imprimirVendedorPrimero_Ultimo();
                                        }         
                                                JOptionPane.showMessageDialog(null, datosVendedor,
                                            "Mostrando lista del primer al último vendedor",
                                            JOptionPane.INFORMATION_MESSAGE);
                                                datosVendedor = "";
                                    }
                                    else
                                        {
                                           JOptionPane.showMessageDialog(null,"No hay vendedores registrados",
                                        "Registro vacío", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                break;                
                     
                                case "Último al primero":
                                    vendedor = lista.imprimirVendedorUltimo_Primero();
                                    if (vendedor != null) 
                                    {
                                        while (vendedor != null) 
                                        {
                                            datosVendedor = datosVendedor + "Código: "+ vendedor.getCodigo()
                                              +  "  -  Nombre: " + vendedor.getNombre() + "  -  Sexo: " + vendedor.getSexo()
                                                + "  -  Ventas Totales: $" + vendedor.getTotalVenta() + "\n";
                                                vendedor = lista.imprimirVendedorUltimo_Primero();
                                        }         
                                                JOptionPane.showMessageDialog(null, datosVendedor,
                                            "Mostrando lista del primer al último vendedor",
                                            JOptionPane.INFORMATION_MESSAGE);
                                                datosVendedor = "";
                                    }
                                    else
                                        {
                                           JOptionPane.showMessageDialog(null,"No hay vendedores registrados",
                                        "Registro vacío", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                break;
                                    
                            }                    
                         break;

                        
                     case 8:
                         JOptionPane.showMessageDialog(null,"Aplicación finalizada",
                              "Salir del programa", JOptionPane.INFORMATION_MESSAGE);
                         break;
                     
                    default:
                        JOptionPane.showMessageDialog(null,"La opción seleccionada no es valida\n"
                                + "Intente nuevamente", "Error - Intente nuevamente", JOptionPane.INFORMATION_MESSAGE);         
                 }
            } catch (NumberFormatException e)
                    {
                        JOptionPane.showMessageDialog(null,"La opción seleccionada no es valida\n"
                                + "Intente nuevamente","Opción invalida", JOptionPane.INFORMATION_MESSAGE);
                    }
        } while (opcion != 8);
    }
}
