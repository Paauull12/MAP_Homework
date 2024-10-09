package taskContainer;

import domain.Task;

import java.util.ArrayList;

public abstract class AbstractContainer implements Container{

    protected ArrayList<Task> lista;

    public AbstractContainer() {
        this.lista = new ArrayList<>();
    }

    protected abstract Task rmv();

    protected abstract void addTask(Task task);

    @Override
    public Task remove() {
        return rmv();
    }

    @Override
    public void add(Task task) {
        addTask(task);
    }

    @Override
    public int size() {
        return lista.size();
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }
}
