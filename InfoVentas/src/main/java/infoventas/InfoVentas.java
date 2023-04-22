
package infoventas;

import javax.swing.JOptionPane;

public class InfoVentas 
{
    public static void main(String[] args)
    {
        ListaDoble listaV = new ListaDoble();
        int opcion = 0;
        int codigo = 0;
        String nombre;
        String sexo;
        int ventasTot = 0;
        String sentido;
        
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
                         /*codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
                                 "Ingrese el código del vendedor", "Código Agregado",
                                  JOptionPane.INFORMATION_MESSAGE));
                         nombre = (JOptionPane.showInputDialog(null,
                              "Ingresa el nombre del vendedor", "Nombre Agregado",
                              JOptionPane.INFORMATION_MESSAGE));
                         sexo = (JOptionPane.showInputDialog(null,
                                 "Ingrese el sexo del vendedor", "Sexo Agregado",
                                 JOptionPane.INFORMATION_MESSAGE).charAt(0));
                         ventasTot = Double.parseDouble(JOptionPane.showInputDialog(null,
                                 "Ingrese el total de ventas del vendedor", "Total Ventas Agregado",
                                 JOptionPane.INFORMATION_MESSAGE));
                         
                         listaV.agregarVendedor(codigo, nombre, sexo, ventasTot);*/
                         codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
                                 "Ingrese el código del vendedor"));
                         if (!listaV.codigoRegistrado(codigo))
                                 {                                    
                                       nombre = (JOptionPane.showInputDialog(null,
                                            "Ingresa el nombre del vendedor", "Nombre Agregado",
                                            JOptionPane.INFORMATION_MESSAGE));
                                       sexo = (JOptionPane.showInputDialog(null,
                                               "Seleccione el sexo del vendedor", "Selección de Sexo: ",
                                               JOptionPane.PLAIN_MESSAGE,null,new Object[]{"Masculino", "Femenino"},
                                               "Masculino")).toString();
                                       ventasTot = Integer.parseInt(JOptionPane.showInputDialog(null,
                                               "Ingrese el total de ventas del vendedor", "Total Ventas Agregado",
                                               JOptionPane.INFORMATION_MESSAGE));

                                       listaV.agregarVendedor(codigo, nombre, sexo, ventasTot);
                                     
                                 } else {
                                            JOptionPane.showMessageDialog(null,"El código ya está registrado",
                                       "Error - Intente nuevamente", JOptionPane.INFORMATION_MESSAGE);
                                        }           
                        break;
                        
                     case 2:
                         codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del "
                         + "vendedor a eliminar: ", "Eliminando Vendedor", JOptionPane.INFORMATION_MESSAGE));
                         if (listaV.codigoRegistrado(codigo))
                         {
                             listaV.eliminarVendedor(codigo);
                             JOptionPane.showMessageDialog(null, "El vendedor con código" + codigo + " se ha eliminado del sistema",
                                    "Eliminando vendedor", JOptionPane.INFORMATION_MESSAGE);
                         }else
                            {
                                JOptionPane.showMessageDialog(null,"El vendedor con código "+ codigo + " No está en el sistema",
                                        "Vendedor no encontrado", JOptionPane.INFORMATION_MESSAGE);
                            }
                         break;
                         
                     case 3:
                         listaV.calcularPromedio();
                         JOptionPane.showMessageDialog(null, "El promedio de ventas totales de la empresa es :",
                         "promedio de ventas",JOptionPane.INFORMATION_MESSAGE);
                         break;
                         
                     case 4:
                         break;
                     
                     case 5:
                         break;
                         
                     case 6:
                         break;
                      
                     case 7:
                         sentido = (JOptionPane.showInputDialog(null,
                              "Selecciona el sentido para ver los vendedores", "Elegir Sentido",
                              JOptionPane.PLAIN_MESSAGE,null, new Object[]{"Derecho","Revés"},
                              "Derecho")).toString();
                         if (sentido == "Derecho") {
                                if(!listaV.listaVacia())
                                {
                                    listaV.mostrarListaInicioFin();
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"No hay vendedores registrados",
                                        "Registro vacío", JOptionPane.INFORMATION_MESSAGE);
                                }
                         }else
                              {
                                if(!listaV.listaVacia())
                                {
                                    listaV.mostrarListaFinInicio();
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"No hay vendedores registrados",
                                        "Registro vacío", JOptionPane.INFORMATION_MESSAGE);
                                }
                              }      
                         break;
                        
                     case 8:
                         JOptionPane.showMessageDialog(null,"Aplicación finalizada",
                              "Fin", JOptionPane.INFORMATION_MESSAGE);
                         break;
                     
                    default:
                        JOptionPane.showMessageDialog(null,"La opción seleccionada no es valida",
                              "Error - Intente nuevamente", JOptionPane.INFORMATION_MESSAGE);         
                 }
            } catch (NumberFormatException e)
                    {
                        JOptionPane.showMessageDialog(null, "Error "+ e.getMessage());
                    }
        } while (opcion != 8);
    }
}
