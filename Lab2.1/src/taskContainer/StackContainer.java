package taskContainer;

import domain.Task;

public class StackContainer extends AbstractContainer{

    @Override
    protected Task rmv() {
        return lista.removeLast();
    }

    @Override
    protected void addTask(Task task) {
        lista.addLast(task);
    }
}
