package org.project.service.impl;

import org.project.mapper.AnswerMapper;
import org.project.domain.Answer;
import org.project.domain.AnswerCollect;
import org.project.domain.AnswerLike;
import org.project.domain.NowAnswer;
import org.project.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public void insert(Answer answer) {
        answerMapper.insert(answer);
    }

    @Override
    public List<Answer> selectByBid(int bid) {
        return answerMapper.selectByBid(bid);
    }

    @Override
    public NowAnswer selectNowAnswer() {
        return  answerMapper.selectNowAnswer();
    }

    @Override
    public void updateNowAnswer(NowAnswer nowAnswer, int aid, int fid) {
        answerMapper.updateNowAnswer(nowAnswer,aid,fid);
    }

    @Override
    public Answer selectByAid(int aid) {
        return answerMapper.selectByAid(aid);
    }

    @Override
    public Boolean isCollected(AnswerCollect answerCollect) {
        AnswerCollect answerCollect1 = answerMapper.isCollected(answerCollect);
        return answerCollect1 != null;
    }

    @Override
    public Boolean isLiked(AnswerLike answerLike) {
        AnswerLike answerLike1 = answerMapper.isLiked(answerLike);
        return answerLike1 != null;
    }

    @Override
    public void insertCollect(AnswerCollect answerCollect) {
        answerMapper.insertCollect(answerCollect);
    }

    @Override
    public void deleteCollect(AnswerCollect answerCollect) {
        answerMapper.deleteCollect(answerCollect);
    }

    @Override
    public void insertLike(AnswerLike answerLike) {
        answerMapper.insertLike(answerLike);
    }

    @Override
    public void deleteLike(AnswerLike answerLike) {
        answerMapper.deleteLike(answerLike);
    }
}
