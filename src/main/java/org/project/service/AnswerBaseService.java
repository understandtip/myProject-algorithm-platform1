package org.project.service;

import org.project.domain.AnswerBase;
import org.project.domain.StudySituation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface AnswerBaseService {

    /**
     * 通过bid和id查询answerBase库
     * @return
     */
    AnswerBase selectByBidAndId(int bid, int id);

    void insertAnswerBase(AnswerBase answerbase);

    List<StudySituation> selectAll();
}
