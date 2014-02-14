import javax.swing.JOptionPane;


public class Calculadora {

	double  dividendo, divisor = 0;
	double [] notasAtuais = {7.13 , 8.9, 7.6 , 3.8, 2.83, 7, 8.8, 7.3, 8.5, 10, 10, 9.07, 7.6, 10, 10, 8.6, 7.5, 8.5, 9.77, 8.8, 8.2, 8.5, 9.7, 9.3};
	
	public void preencher(){
		
		double [] notas = new double[40];
		int size = notasAtuais.length;
		for(int i = 0; i<notasAtuais.length;i++){
			notas[i]=notasAtuais[i];
		}
		
		while(true){
			String notaString = JOptionPane.showInputDialog("Digite a media:\n\n Digite zero para calcular ");
			if(notaString.equals("0")){				
				break;
			}	
				
			notaString = notaString.replace(",", "."); 
			float nota = Float.valueOf(notaString);			
			notas[size++] = nota;			
		}
		calcular(notas,size);
		
	}
	
	public void calcular(double[] notas,int size){
		for(int i = 0; i<size; i++){
			dividendo+= (notas[i]*60);
			divisor+= 60;
		}
		float cre = (float) (dividendo/divisor);
		JOptionPane.showMessageDialog(null,"Seu CRE é:"+ cre);
	}

}
