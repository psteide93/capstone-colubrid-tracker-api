package com.psteide.colubridtrackerapi.weights;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightRepository extends CrudRepository<Weight, Long> {
}
