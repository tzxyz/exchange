package org.zhuonima.exchange.sequence.repositories;

import org.zhuonima.exchange.sequence.models.Sequence;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SequenceRepository extends PagingAndSortingRepository<Sequence, Long> {

    Sequence findTopByOrderByIdDesc();

}
