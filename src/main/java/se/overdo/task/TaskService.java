package se.overdo.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.overdo.api.ApiException;
import se.overdo.api.ErrorCode;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskService {

    private final TaskRepository repository;

    @Transactional
    public TaskDto create(TaskDto dto) {
        Task task = Task.builder()
                .title(dto.getTitle())
                .completed(dto.isCompleted())
                .build();
        Task saved = repository.save(task);
        return TaskDto.fromEntity(saved);
    }

    public TaskDto get(Long id) {
        return repository.findById(id)
                .map(TaskDto::fromEntity)
                .orElseThrow(() -> new ApiException(ErrorCode.TASK_NOT_FOUND, "Task not found"));
    }

    public List<TaskDto> findAll() {
        return repository.findAll().stream()
                .map(TaskDto::fromEntity)
                .collect(Collectors.toList());
    }
}
