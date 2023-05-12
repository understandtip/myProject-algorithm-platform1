package org.project.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.project.domain.Answer;
import org.project.domain.AnswerCollect;
import org.project.domain.AnswerLike;
import org.project.domain.NowAnswer;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AnswerMapper {

    /**
     * 对answer表进行新增
     */
    @Select("insert into answer values (null,#{answer.title},#{answer.content},#{answer.username},#{answer.bid})")
    void insert(@Param("answer") Answer answer);

    /**
     * 倒序输出题解表
     * @return
     */
    @Select("select * from answer where bid = #{bid} order by aid desc")
    List<Answer> selectByBid(int bid);



    /**
     * 查询now_answer表
     * @return
     */
    @Select("select * from now_answer")
    NowAnswer selectNowAnswer();

    /**
     * 更新now_answer表
     * @param nowAnswer
     * @param aid
     * @param fid
     */
    @Select("update now_answer set aid = #{nowAnswer.aid},fid = #{nowAnswer.fid} where aid = #{aid} and fid = #{fid}")
    void updateNowAnswer(@Param("nowAnswer")NowAnswer nowAnswer,@Param("aid") int aid,@Param("fid") int fid);

    /**
     * 通过aid查询题解表answer，来进行展示
     * @param aid
     * @return
     */
    @Select("select * from answer where aid = #{aid} ")
    Answer selectByAid(int aid);

    /**
     * 查询answer_collect
     */
    @Select("select * from answer_collect where id = #{answerCollect.id} and aid = #{answerCollect.aid} and bid = #{answerCollect.bid} ")
    AnswerCollect isCollected(@Param("answerCollect")AnswerCollect answerCollect);

    /**
     * 查询answer_like
     */
    @Select("select * from answer_like where id = #{answerLike.id} and aid = #{answerLike.aid} and bid = #{answerLike.bid} ")
    AnswerLike isLiked(@Param("answerLike")AnswerLike answerLike);

    /**
     * 更新answer_collect表
     */
    @Select("insert into answer_collect values (#{answerCollect.id},#{answerCollect.aid},#{answerCollect.bid})")
    void insertCollect(@Param("answerCollect")AnswerCollect answerCollect);

    /**
     * 删除answer_collect表的数据
     */
    @Select("delete from answer_collect where id = #{answerCollect.id} and aid = #{answerCollect.aid} and bid = #{answerCollect.bid}")
    void deleteCollect(@Param("answerCollect")AnswerCollect answerCollect);

    /**
     * 更新answer_like表
     */
    @Select("insert into answer_like values (#{answerLike.id},#{answerLike.aid},#{answerLike.bid})")
    void insertLike(@Param("answerLike") AnswerLike answerLike);

    /**
     * 删除answer_like表的数据
     */
    @Select("delete from answer_like where id = #{answerLike.id} and aid = #{answerLike.aid} and bid = #{answerLike.bid}")
    void deleteLike(@Param("answerLike")AnswerLike answerLike);
}
