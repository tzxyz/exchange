package org.zhuonima.exchange.sequence.services;

import org.springframework.stereotype.Service;
import org.zhuonima.exchange.sequence.models.Sequence;
import org.zhuonima.exchange.sequence.repositories.SequenceRepository;

@Service
public class SequenceService {

    private final SequenceRepository sequenceRepository;

    public SequenceService(SequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

    /**
     * 定序
     */
    public void sequence() {


        Sequence sequence = new Sequence();

        sequence.setOrderId(null);

        sequenceRepository.save(sequence);
    }
}
