package org.project.service.impl;

import org.project.mapper.NoteMapper;
import org.project.domain.Note;
import org.project.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;

    @Override
    public List<Note> getAll(int aid){//获取所有未被删除的留言
        return  noteMapper.getAll(aid);
    }

    @Override
    public void addNote(Note note) {//添加一条留言
        noteMapper.addNote(note);
    }

    @Override
    public void update(int isDelete, int n_id) {//更新表的is_delete(是否点赞)信息
        noteMapper.update(isDelete, n_id);
    }


}
