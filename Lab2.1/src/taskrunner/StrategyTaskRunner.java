package taskrunner;

import domain.Task;
import taskContainer.Container;
import taskContainerFactory.ContainerStrategy;
import taskContainerFactory.TaskContainerFactory;

public class StrategyTaskRunner implements TaskRunner{

    private Container container;

    public StrategyTaskRunner(ContainerStrategy strategy) {
        TaskContainerFactory factory = TaskContainerFactory.getInstance();
        this.container = factory.createContainer(strategy);
    }

    @Override
    public void executeOneTask() {
        if(!container.isEmpty()) {
            Task t = container.remove();
            t.execute();
        }
    }

    @Override
    public void executeAll() {
        while(hasTask()){
            executeOneTask();
        }
    }

    @Override
    public void addTask(Task t) {
        container.add(t);
    }

    @Override
    public boolean hasTask() {
        return !container.isEmpty();
    }
}
