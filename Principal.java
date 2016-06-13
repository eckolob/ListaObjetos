import java.util.ArrayList;
import javax.swing.JOptionPane;
 
public class Principal {
 
    boolean tal=false;
    ArrayList <Proceso> Lote=null;
 
    
 
    public void menu(){
    	
    	
    	Lote = new ArrayList <Proceso> ();
    	  int id,tme; String programador;
        String op;
       do{
           op = JOptionPane.showInputDialog(null,"2.  Introducir datos\n"
                                              +"3.  Modificar datos\n"
                                              +"4.  Eliminar datos\n"
                                              +"5.  Buscar datos\n"
                                              +"6.  Mostrar datos\n"
                                              +"7.  Salir");
 
           switch(op){
               case "2"://Bloque para introducir datos al array list
                   
                     
                        id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID: "));
                        programador = JOptionPane.showInputDialog(null, "Programador: ");
                        tme = Integer.parseInt(JOptionPane.showInputDialog(null, "TME: "));
                        Lote.add(new Proceso(id,programador,tme));                        
                                    
                   break;
               case "3"://Bloque para modificar datos al array list
                   
                        int indice, b;
                        String c;
                        b = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el indice(id) a Modificar: "));
                        if(existeEnArray(b)){                            
                            indice = indiceDato(b);
                            c = JOptionPane.showInputDialog(null, "Programador: ");
                            Lote.get(indice).AsignarNombre(c); 
                            	//Aqui se puede indicarle que modifique mas atributos invocando al metodo asignarATRIBUTO() creado en Proceso
                        }else{
                            JOptionPane.showMessageDialog(null, "No existe el dato a modificar !", "", JOptionPane.ERROR_MESSAGE);
                        }
                                 
                   break;
               case "4"://Bloque para eliminar dato del array
                   
                   
                        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id a eliminar: "));
                        for(int i=0; i<Lote.size(); i++){
                            if(Lote.get(i).ObtenerId()==id){
                                Lote.remove(i);
                            }
                        }
                     
                   break;
               case "5"://Bloque para buscar datos en el array list
                  
                        String mostrarBus= "No se ha encontrado nada!";
                        
                        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id a buscar: "));
                        for( int i = 0 ; i  < Lote.size(); i++){
                        	//Obtener el id del objeto almacenado en la posicion 0,1,2,...
                            if(Lote.get(i).ObtenerId()==id){
                                mostrarBus  ="";
                                mostrarBus += "Id "+(i+1)+" : "+Lote.get(i).ObtenerId();
                                mostrarBus += "\nNombre posicion "+i+" : "+Lote.get(i).ObtenerProgramador();
                                mostrarBus += "\nTME: "+Lote.get(i).ObtenerTME();
                                mostrarBus += "\n"+"\n";
                            }                        
                       }
                         JOptionPane.showMessageDialog(null, mostrarBus);
                  
 
                   break;
               case "6"://Bloque para mostar los datos del array list
                  
                       String Salida= "";
                       for( int i = 0 ; i  < Lote.size(); i++){
                        Salida += "Id: "+Lote.get(i).ObtenerId();
                        Salida += "\nProgramador "+i+" : "+Lote.get(i).ObtenerProgramador();
                        Salida += "\nTME: "+Lote.get(i).ObtenerTME();
                        Salida += "\n"+"\n";
                       }
                        JOptionPane.showMessageDialog(null, Salida);
                                    
                   break;                   
               case "7":
                   System.exit(0);
                   break;
               default:
                   JOptionPane.showMessageDialog(null, "Opcion invalida !");
                   break;
           }      
       }while(!op.equals("7"));
    }
 
    public boolean existeEnArray(int bus){
 
        boolean saber=false;
 
        for(int i=0; i<= Lote.size(); i++){
            if(Lote.get(i).ObtenerId()==bus){
                saber=true;
                break;
            }
        }
        return saber;
    }
 
    public int indiceDato(int bus){
        int j=0;
 
        for (int i=0 ;i < Lote.size(); i++) {
            if(Lote.get(i).ObtenerId()== bus){
                j=i;
                break;
            }
        }
        return j;
    } 
    	
    	public static void main(String args[]){
       Principal objeto = new Principal();
        objeto.menu();
    }   
}
