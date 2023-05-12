package org.project.service.impl;

import org.project.mapper.AnswerBaseMapper;
import org.project.domain.AnswerBase;
import org.project.domain.StudySituation;
import org.project.service.AnswerBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerBaseServiceImpl implements AnswerBaseService {
    @Autowired
    private AnswerBaseMapper answerBaseMapper;

    @Override
    public AnswerBase selectByBidAndId(int bid, int id) {
        return answerBaseMapper.selectByBidAndId(bid,id);
    }

    @Override
    public void insertAnswerBase(AnswerBase answerbase) {
        answerBaseMapper.insertAnswerBase(answerbase);
    }

    @Override
    public List<StudySituation> selectAll() {
        return  answerBaseMapper.selectAll();
    }
}
