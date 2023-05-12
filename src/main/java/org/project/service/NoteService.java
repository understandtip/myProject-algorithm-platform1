package org.project.service;

import org.project.domain.Note;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface NoteService {

    //获取所有未被删除的留言
    List<Note> getAll(int aid);

    //添加一条留言
    void addNote(Note note);

    //更新表的is_delete(是否点赞)信息
    void update(int isDelete,int n_id);
}
