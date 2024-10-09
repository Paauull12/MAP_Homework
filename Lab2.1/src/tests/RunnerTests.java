package tests;

import domain.MessageTask;
import domain.SortingTask;
import domain.Task;
import sort.SortingStrategy;
import taskContainerFactory.ContainerStrategy;
import taskrunner.DelayTaskRunner;
import taskrunner.PrinterTaskRunner;
import taskrunner.StrategyTaskRunner;
import taskrunner.TaskRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RunnerTests {

    public static List<Task> getMsgTasks(){
        Task msg1 = new MessageTask("1", "desc", "to", "ano213ther", "to", LocalDateTime.now());
        Task msg2 = new MessageTask("2", "desc", "to", "another", "to", LocalDateTime.now());
        Task msg3 = new MessageTask("3", "desc", "to", "ano123ther", "to", LocalDateTime.now());
        Task msg4 = new MessageTask("4", "desc", "to", "another", "to", LocalDateTime.now());
        Task msg5 = new MessageTask("5", "desc", "to", "anot123her", "to", LocalDateTime.now());

        List<Task> list = new ArrayList<>();

        list.add(msg1);
        list.add(msg2);
        list.add(msg3);
        list.add(msg4);
        list.add(msg5);

        return list;
    }

    public static List<Task> getSortingTasks() {
        Long[] array = new Long[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = (long) (i * 10);
        }

        array[4] = 5L;
        array[6] = 3L;
        array[7] = 8L;

        Task msg6 = new SortingTask<Long>("6", "desc", array, SortingStrategy.Merge);
        //msg6.execute();
        List<Task> list = new ArrayList<>();

        list.add(msg6);

        return list;
    }

    public static void testRunnerWithMsgTaskDP(){
        TaskRunner runner = new DelayTaskRunner(new PrinterTaskRunner( new StrategyTaskRunner(ContainerStrategy.LIFO)));
        for(var it : getMsgTasks()){
            runner.addTask(it);
        }

        runner.executeAll();

        System.out.println("!!!done tests with Delay and Print");
    }

    public static void testRunnerWithMsgTaskP(){
        TaskRunner runner = new PrinterTaskRunner( new StrategyTaskRunner(ContainerStrategy.LIFO));
        for(var it : getMsgTasks()){
            runner.addTask(it);
        }

        runner.executeAll();

        System.out.println("!!!done tests with Print");
    }

    public static void callTests(){
        testRunnerWithMsgTaskDP();
        testRunnerWithMsgTaskP();
    }

}
