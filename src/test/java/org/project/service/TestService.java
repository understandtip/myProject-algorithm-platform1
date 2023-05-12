package org.project.service;

import org.project.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.controller.util.DateUtil;
import org.project.domain.Blog;
import org.project.domain.Forward;
import org.project.domain.Note;
import org.project.domain.User;
import org.project.mapper.BlogMapper;
import org.project.mapper.FavoriteMapper;
import org.project.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//设置类运行器
@ContextConfiguration(classes = SpringConfig.class)//加载环境
public class TestService {
    @Autowired//注入测试对象
    private BlogMapper blogMapper;
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteMapper noteMapper;
    @Autowired
    private AnswerService answerService;

    @Test
    public void update1(){
        noteService.update(1, 73);
    }

    @Test
    public void update2(){
        Note note = new Note();
        DateUtil dateUtil = new DateUtil();
        note.setResId("73");
        note.setContent("234");
        note.setNickname("张三");//nickname:昵称  为  username
        note.setTime(dateUtil.getCurrentDateTime());
        note.setAid(answerService.selectNowAnswer().getAid());
        System.out.println(note);
        noteService.addNote(note);
    }

    @Test
    public void getData(){
        DateUtil dateUtil = new DateUtil();
        System.out.println(dateUtil.getCurrentDateTime());
    }

    @Test
    public  void selectAll(){
        List<Note> all = noteService.getAll(2);
        all.forEach(System.out::println);
    }

    @Test
    public  void update(){
        /*int bid = 1;
        Forward forward1 = new Forward(bid,bid);//更新当前表的数据
        favoriteService.update(forward1,favoriteService.select().getBid(),favoriteService.select().getFid());*/
    }

    @Test
    public  void test(){

    }
}
