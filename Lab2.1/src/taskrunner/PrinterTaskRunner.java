package taskrunner;

import domain.Utils;

import java.time.LocalDateTime;

public class PrinterTaskRunner extends AbstractTaskRunner{

    public PrinterTaskRunner(TaskRunner runner) {
        super(runner);
    }

    @Override
    public void executeOneTask() {
        super.executeOneTask();
        System.out.println(LocalDateTime.now().format(Utils.formatter));
    }

    @Override
    public void executeAll() {
        while (hasTask()) {
            executeOneTask();
        }
    }

}
