package taskContainer;

import domain.Task;

public class QueueContainer extends AbstractContainer{
    @Override
    protected Task rmv() {
        return lista.removeLast();
    }

    @Override
    protected void addTask(Task task) {
        lista.addFirst(task);
    }
}
