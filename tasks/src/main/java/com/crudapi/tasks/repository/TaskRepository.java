package com.crudapi.tasks.repository;

import com.crudapi.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository  extends CrudRepository<Task, Long> {

    @Override
    List<Task> findAll();

    Optional<Task> findById(long id);

    @Override
    Task save(Task task);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
