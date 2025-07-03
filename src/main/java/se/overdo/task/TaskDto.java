package se.overdo.task;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TaskDto {
    private final Long id;
    private final String title;
    private final boolean completed;

    @Builder
    public TaskDto(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public static TaskDto fromEntity(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .completed(task.isCompleted())
                .build();
    }
}
