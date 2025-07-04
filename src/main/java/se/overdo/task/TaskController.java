package se.overdo.task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.overdo.api.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping
    public ResponseEntity<ApiResponse<TaskDto>> create(@RequestBody TaskDto dto) {
        TaskDto saved = service.create(dto);
        return ResponseEntity.ok(ApiResponse.ok(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TaskDto>> get(@PathVariable Long id) {
        TaskDto task = service.get(id);
        return ResponseEntity.ok(ApiResponse.ok(task));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TaskDto>>> list() {
        List<TaskDto> tasks = service.findAll();
        return ResponseEntity.ok(ApiResponse.ok(tasks));
    }
}
