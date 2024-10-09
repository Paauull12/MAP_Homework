package taskContainerFactory;

import taskContainer.Container;

public interface Factory {
    Container createContainer(ContainerStrategy startegy);
}
