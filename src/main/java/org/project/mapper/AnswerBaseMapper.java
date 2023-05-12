package org.project.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.project.domain.AnswerBase;
import org.project.domain.StudySituation;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AnswerBaseMapper {

    /**
     *  通过bid和id查询answerBase库
     * @param bid
     * @param id
     * @return
     */
    @Select("select * from answerbase where bid = #{bid} and id = #{id}")
    AnswerBase selectByBidAndId(@Param("bid") int bid, @Param("id") int id);

    /**
     * 新增是否答题成功  的  表
     * @return
     */
    @Select("insert into answerbase values (#{answerbase.bid},#{answerbase.id})")
    void insertAnswerBase(@Param("answerbase") AnswerBase answerbase);

    /**
     * 学习情况查询
      * @return
     */
    @Select("select count(bid) as count,a.id,b.username from answerbase as a,tb_user as b where a.id =b.id group by id order by count desc")
    List<StudySituation> selectAll();
}
