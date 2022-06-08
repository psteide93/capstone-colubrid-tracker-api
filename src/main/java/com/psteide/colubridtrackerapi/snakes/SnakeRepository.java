package com.psteide.colubridtrackerapi.snakes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnakeRepository extends CrudRepository<Snake, Long> {
}