/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 
Programa para Teste de Cálculo Ciclotomático

*/
package Exemplos;

/**
 *
 * @author robson
 */
public class CalculoSituacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        // TODO code application logic here
    
   //O método deve receber a carga horaria total da disciplina
            //A quantidade de faltas que o aluno deve conter e a sua média final
    //int ch = Integer.parseInt(args[0]);
    //int faltas = Integer.parseInt(args[1]);
    //double media = Double.parseDouble(args[2]);

    int ch = 100;
    int faltas = 10;
    int media = 5;
    
    switch(ch)
    {
    //para disciplinas com carga horária de 20 horas semanais
        case 20:
            if (faltas>5) {
                System.out.println("Reprovado");
            }else {
                
                if (isAprovadoPorMedia(media)){
                    System.out.println("Aprovado com conceito"+obterConceito(media));
                    
                }else {
                    System.out.println("Reprovado");
                }
            }
                break;
            
    //Para disciplinas com carga horária de 40 horas semanais:
        case 40:
            if (faltas>10){
                System.out.println("Reprovado");
            }else {
                if(isAprovadoPorMedia(media)) {
                    
                    System.out.println("Aprovado com conceito"+obterConceito(media));
                    
                }else {
                    System.out.println("Reprovado");
                }
            }
    break;
    
        case 60:
            if (faltas>15)
            {
                System.out.println("Reprovado");
            }else {
                if (isAprovadoPorMedia(media)){
                    System.out.println("Aprovado com conceito "+obterConceito(media));
                    
                }else {
                    System.out.println("Reprovado");
                    
                }
            }
            break;
        default:
            System.out.println("Disciplina não cadastrada!");
    break;
    }
    }


static boolean isAprovadoPorMedia(double media){
    
     if (media>7) return true;
    
    else return false;
}


static boolean obterConceito(double media){

    if (media<5) return false;
    
    else return true;
}

}

