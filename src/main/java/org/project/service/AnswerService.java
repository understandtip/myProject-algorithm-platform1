package org.project.service;

import org.project.domain.Answer;
import org.project.domain.AnswerCollect;
import org.project.domain.AnswerLike;
import org.project.domain.NowAnswer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface AnswerService {

    /**
     * 对answer表进行新增
     */
    void insert(Answer answer);

    /**
     * 倒序输出题解表
     * @return
     */
    List<Answer> selectByBid(int bid);

    /**
     * 查询now_answer表
     * @return
     */
    NowAnswer selectNowAnswer();

    /**
     * 更新now_answer表
     * @param nowAnswer
     * @param aid
     * @param fid
     */
    void updateNowAnswer(NowAnswer nowAnswer,int aid,int fid);

    /**
     * 通过aid查询题解表answer，来进行展示
     * @param aid
     * @return
     */
    Answer selectByAid(int aid);

    /**
     * 查询answer_collect
     */
    Boolean isCollected(AnswerCollect answerCollect);

    /**
     * 查询answer_like
     */
    Boolean isLiked(AnswerLike answerLike);

    /**
     * 更新answer_collect表
     */
    void insertCollect(AnswerCollect answerCollect);

    /**
     * 删除answer_collect表的数据
     */
    void deleteCollect(AnswerCollect answerCollect);

    /**
     * 更新answer_like表
     */
    void insertLike(AnswerLike answerLike);

    /**
     * 删除answer_like表的数据
     */
    void deleteLike(AnswerLike answerLike);
}
