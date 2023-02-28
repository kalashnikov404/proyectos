
package codigo;


public class Error {
   private String linea;
   private String tipo;
   
    public Error(String linea, String tipo){
       this.linea=linea;
       this.tipo=tipo;
   }

    public Error() { 
    }
   public String getLinea() {
        return linea;
    }
    public void setLinea(String linea) {
        this.linea=linea;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo=tipo;
    } 
    
}
