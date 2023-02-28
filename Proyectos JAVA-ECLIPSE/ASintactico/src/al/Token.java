package al;

public class Token {
    
    protected String lexema;
    protected int atributo;
    protected String clasificacion;
    
    public Token(String lexema, int atributo,String clasificacion){
        this.lexema = lexema;
        this.atributo = atributo;
        this.clasificacion = clasificacion;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getAtributo() {
        return atributo;
    }

    public void setAtributo(int atributo) {
        this.atributo = atributo;
    }

    public String getClasficacion() {
        return clasificacion;
    }

    public void setClasficacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    
    @Override
    public String toString(){
        return "|"+lexema + "\t|"+clasificacion+"\t|("+String.valueOf(atributo)+")";
    }
    
}