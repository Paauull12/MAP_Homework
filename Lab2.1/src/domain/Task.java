package domain;

import java.util.Objects;

public abstract class Task {

    private String taskId;
    private String desc;

    public Task(String taskId, String desc) {
        this.taskId = taskId;
        this.desc = desc;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getDesc() {
        return desc;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public abstract void execute();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(taskId, task.taskId) && Objects.equals(desc, task.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, desc);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
