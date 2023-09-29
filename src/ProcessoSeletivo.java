//Parte-1
//Vamos imaginar que em um processo seletivo existe o valor base salararial de R$2000,00 é o salário pretendido pelo candidato.
//Vamos elaborar um controle de fluxo onde:
//-Se o valor salário base for maior que salario o pretendido, imprima: LIGAR PARA O CANDIDATO; 
//-Senão Se o valor salario base for igual ao valor salario pretendido, imprima: LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA;
//-Senão imprima: AGUARDANDO RESULTADO


//Parte-2 
//Foi solicitado que nosso sistema garanta que diante das inúmeras
//candidaturas sejam selecionados apenas no maximo 5 candidatos para
//a entrevista onde o salário pretendido seja menor ou igual ao salário base.

//Parte-3
//imprimir a lista de candidatos selecionados para disponibilizar para o RH entrar em contato

//parte-4 Tentar ligar para os candidatos com no maximo de 3 tentativas



import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo{
    public static void main(String[] args) throws Exception {
        String[] candidatos = {"Ricardo","Felipe","Kaio","Raissa","Murilo"};
            for(String candidato: candidatos){
                entrandoEmContato(candidato);
            }
    }
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
             if(continuarTentando)
                 tentativasRealizadas++;
            else
                System.out.println("Contado realizado com sucesso");

        }while(continuarTentando && tentativasRealizadas<3 );
        if(atendeu)
        System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + "tentativa");
        else
        System.out.println("Não conseguimos contato com " + candidato + ", número maximo de " + tentativasRealizadas + " tentativas");
    }
    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados() {
        String [] candidatos = {"Ricardo","Felipe","Kaio","Raissa","Murilo"};
            for(String candidato: candidatos){

        System.out.println("O candidato " + candidato + "foi aprovado");
            }
}    


    static void seleçãoCandidatos(){
        String [] candidatos = {"Ricardo","Felipe","Kaio","Raissa","Murilo","Julio","Marcela","Ana"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou " + salarioPretendido);

            if(salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga" );
                candidatosSelecionados++;

            }
            candidatosAtual++;
        }
    } 


    static double valorPretendido() {

    return ThreadLocalRandom.current().nextDouble(1700 , 2200);
    }


    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000;
        
        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para candidato");
        
        }else if(salarioBase==salarioPretendido){
        System.out.println("Ligar para candidato com contra proposta");

        }else{
        System.out.println("Aguardando Resultado");
        }
    }
}
