package org.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.project.domain.Note;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NoteMapper {

    //获取所有未被删除的留言
    //@Select("select n_id as id,content as content,nickname as nickname,time as time,is_delete as isDelete  from note where aid = #{aid} order by time desc")
    List<Note> getAll(int aid);

    //添加一条留言
    @Select("insert into note(content,nickname,time,reply_post,res_id,aid)value(#{note.content}, #{note.nickname},#{note.time},#{note.replyPost},#{note.resId},#{note.aid})")
    void addNote(@Param("note")Note note);

    //更新表的is_delete(是否点赞)信息
    @Update("update note set is_delete = #{isDelete} where n_id = #{n_id}")
    int update(@Param("isDelete")int isDelete,@Param("n_id") int n_id);
}
