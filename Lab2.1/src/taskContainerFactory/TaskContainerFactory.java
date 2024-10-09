package taskContainerFactory;

import taskContainer.Container;
import taskContainer.QueueContainer;
import taskContainer.StackContainer;

public class TaskContainerFactory implements Factory{

    private static TaskContainerFactory instance = null;

    private TaskContainerFactory() {
    }

    public static TaskContainerFactory getInstance(){
        if(instance == null)
            instance = new TaskContainerFactory();
        return instance;
    }

    @Override
    public Container createContainer(ContainerStrategy startegy) {
        if(startegy == ContainerStrategy.LIFO)
            return new StackContainer();
        else if(startegy == ContainerStrategy.FIFO)
            return new QueueContainer();
        return null;
    }
}
