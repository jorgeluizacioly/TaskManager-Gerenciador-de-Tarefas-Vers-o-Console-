package taskmanager.service;


import java.util.ArrayList;
import java.util.List;
import taskmanager.modelss.*;


public class TaskService {
    
    private List<Task> tasks;

    public TaskService(){
        this.tasks = new ArrayList<>();
    }

    public void addTask(String nome, String descricao, boolean concluida){
        
        int id = tasks.size() +1;
        Task task = new Task(id, nome, descricao, false);
        tasks.add(task);
    }

    public List<Task> getTasks(){
        return tasks;

    }

    public boolean concluirTask(int id) {
    for (Task task : tasks) {
        if (task.getId() == id) {
            task.setConcluida(true);
            return true;
        }
    }
    return false;
    }

    public boolean  removerTask(int id){
        for(Task task : tasks){
            if(task.getId() == id){
                tasks.remove(task);
                return true;
            }
        }

        return false;
    }


}
        

