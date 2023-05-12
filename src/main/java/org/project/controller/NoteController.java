package org.project.controller;

import org.project.domain.Note;
import org.project.domain.RuleForm;
import org.project.domain.User;
import org.project.service.AnswerService;
import org.project.service.NoteService;
import org.project.controller.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    DateUtil date;//自定义日期工具，获取当前时间戳

    /*添加一条元留言，需要传递参数：
        content:内容
    */
    @RequestMapping("/addMetaNote")
    public Boolean addMetaNote(@RequestBody RuleForm ruleForm, HttpSession session){//System.out.println("加入一条元留言：" + note);
        String contents = ruleForm.getContents();
        Note note = new Note();
        note.setContent(contents);//前端传递过来的评论
        /*为元留言设置基础额外信息*/
        note.setNickname((((User)session.getAttribute("user")).getUsername()));//nickname:昵称  为  username
        note.setTime(date.getCurrentDateTime());
        note.setReplyPost("0");
        note.setResId("0");
        note.setRespondent("");
        note.setAid(answerService.selectNowAnswer().getAid());
        noteService.addNote(note);
        return true;
    }

    /*添加一条回复，需要传递参数
        content:内容
        resId:回复对象id
        replyPost:根留言id
    */
    @RequestMapping("/addFollowNote")
    public Boolean addFollowNote(@RequestBody Note note,HttpSession session){
        /*设置基础额外信息*/
        note.setNickname((((User)session.getAttribute("user")).getUsername()));//nickname:昵称  为  username
        note.setTime(date.getCurrentDateTime()); note.setAid(answerService.selectNowAnswer().getAid());
        note.setReplyPost(null); note.setRespondent(null);
        noteService.addNote(note);
        return true;
    }
    //通过aid获取所有评论列表;
    @RequestMapping("/getAll")
    public List<Note> getAll() {
        return noteService.getAll(answerService.selectNowAnswer().getAid());
    }

    @RequestMapping("/update")
    public Boolean update(@RequestBody Note note){
        if(note.getIsDelete() == 0) {
            noteService.update(1, note.getId());//System.out.println("更新为已收藏（1）");
        }
        else {
            noteService.update(0, note.getId());//System.out.println("更新为未收藏（0）");
        }
        return true;
    }

}
