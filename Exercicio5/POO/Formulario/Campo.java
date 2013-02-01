
package Formulario;

import Validador.Validador;


public class Campo {
    private String id;
    private String valor;
    private String label;
    private Validador validadorCampo;
    public Campo(){   
    }
    
    public Campo(String i,String l,Validador v ){
        this.id=i;
        this.validadorCampo=v;
        this.label=l;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public boolean validar(){
		return this.validadorCampo.validador(this.valor);
    }
    
    
}
