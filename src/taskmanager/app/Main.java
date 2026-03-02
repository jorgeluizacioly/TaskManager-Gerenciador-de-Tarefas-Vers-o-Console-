package taskmanager.app;

import java.util.List;
import java.util.Scanner;
import taskmanager.modelss.Task;
import taskmanager.service.TaskService;

public class Main {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskService taskService = new TaskService();

        int opcao = 0;

        while (opcao != 5) {

            System.out.println("===== GERENCIADOR DE TAREFAS =====");
            System.out.println("1. Criar nova tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {

                case 1:
                    System.out.print("Nome da tarefa: ");
                    String nome = scanner.nextLine();

                    System.out.print("Descrição da tarefa: ");
                    String descricao = scanner.nextLine();

                    taskService.addTask(nome, descricao, false);
                    System.out.println("Tarefa criada com sucesso!");
                    break;

                case 2:
                    List<Task> tarefas = taskService.getTasks();

                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        for (Task task : tarefas) {
                            System.out.println(
                                task.getId() + " - " +
                                task.getNome() + " | " +
                                (task.isConcluida() ? "Concluída" : "Pendente")
                            );
                        }
                    }
                    break;
                
              
                
                case 3:
                        System.out.print("Digite o ID da tarefa a concluir: ");
                        int idConcluir = scanner.nextInt();
                        scanner.nextLine(); 

                        boolean concluida = taskService.concluirTask(idConcluir);

                        if (concluida) {
                            System.out.println("Tarefa marcada como concluída!");
                        } else {
                            System.out.println("Tarefa não encontrada.");
                        }
                        break;
                
                case 4:
                    System.out.println("Digite o ID da tarefa para remover ela: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();

                    boolean remover = taskService.removerTask(idRemover);

                    if(remover){
                        System.out.println("Tarefa removida com Sucesso");
                    }else{
                        System.out.println("Tarefa nao encontrada");
                    }
    
                    break;

                case 5:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println();
        }

        scanner.close();
    }


}
