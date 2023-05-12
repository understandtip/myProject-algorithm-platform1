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

    public void insert(Answer answer) {
        answerMapper.insert(answer);
    }

    public List<Answer> selectByBid(int bid) {
        return answerMapper.selectByBid(bid);
    }

    public NowAnswer selectNowAnswer() {
        return  answerMapper.selectNowAnswer();
    }

    public void updateNowAnswer(NowAnswer nowAnswer, int aid, int fid) {
        answerMapper.updateNowAnswer(nowAnswer,aid,fid);
    }

    public Answer selectByAid(int aid) {
        return answerMapper.selectByAid(aid);
    }

    public Boolean isCollected(AnswerCollect answerCollect) {
        AnswerCollect answerCollect1 = answerMapper.isCollected(answerCollect);
        return answerCollect1 != null;
    }

    public Boolean isLiked(AnswerLike answerLike) {
        AnswerLike answerLike1 = answerMapper.isLiked(answerLike);
        return answerLike1 != null;
    }

    public void insertCollect(AnswerCollect answerCollect) {
        answerMapper.insertCollect(answerCollect);
    }

    public void deleteCollect(AnswerCollect answerCollect) {
        answerMapper.deleteCollect(answerCollect);
    }

    public void insertLike(AnswerLike answerLike) {
        answerMapper.insertLike(answerLike);
    }

    public void deleteLike(AnswerLike answerLike) {
        answerMapper.deleteLike(answerLike);
    }
}
