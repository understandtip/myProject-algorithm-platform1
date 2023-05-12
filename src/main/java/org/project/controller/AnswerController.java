package org.project.controller;

import org.project.domain.*;
import org.project.service.AnswerService;
import org.project.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping("/insert")
    public Boolean insert(@RequestBody Answer answer,HttpSession session){
        int bid = favoriteService.select().getBid();
        String username = ((User) session.getAttribute("user")).getUsername();
        answer.setBid(bid);
        answer.setUsername(username);
        answerService.insert(answer);
        return  true;
    }

    @RequestMapping("/selectByBid")
    public List<Answer> selectByBid(){
        Forward forward = favoriteService.select();
        int bid = forward.getBid();
        return  answerService.selectByBid(bid);
    }

    @RequestMapping("/updateNowAnswer")
    public void updateNowAnswer(@RequestParam("aid") int aid1){
        NowAnswer nowAnswer = answerService.selectNowAnswer(); //查询数据
        NowAnswer nowAnswer1 = new NowAnswer(aid1,aid1);//更新数据
        answerService.updateNowAnswer(nowAnswer1,nowAnswer.getAid(),nowAnswer.getFid());
    }

    @RequestMapping("/selectByAid")
    public Answer selectByAid(){
        return answerService.selectByAid(answerService.selectNowAnswer().getAid());
    }

    @RequestMapping("/isCollected")
    public Boolean isCollected(HttpSession session){
        int aid =  answerService.selectNowAnswer().getAid();
        int id = ((User)session.getAttribute("user")).getId();
        int bid = favoriteService.select().getBid();
        AnswerCollect answerCollect = new AnswerCollect(id,aid,bid);
        return answerService.isCollected(answerCollect);
    }

    @RequestMapping("/isLiked")
    public Boolean isLiked(HttpSession session){
        int aid =  answerService.selectNowAnswer().getAid();
        int id = ((User)session.getAttribute("user")).getId();
        int bid = favoriteService.select().getBid();
        AnswerLike answerLike = new AnswerLike(id,aid,bid);
        return answerService.isLiked(answerLike);
    }

    @RequestMapping("/insertCollect")
    public Boolean insertCollect(HttpSession session){
        int aid = answerService.selectNowAnswer().getAid();
        int id = ((User)session.getAttribute("user")).getId();
        int bid = favoriteService.select().getBid();
        AnswerCollect answerCollect = new AnswerCollect(id,aid,bid);
        answerService.insertCollect(answerCollect);
        return true;
    }

    @RequestMapping("/deleteCollect")
    public Boolean deleteCollect(HttpSession session){
        int aid = answerService.selectNowAnswer().getAid();
        int id = ((User)session.getAttribute("user")).getId();
        int bid = favoriteService.select().getBid();
        AnswerCollect answerCollect = new AnswerCollect(id,aid,bid);
        answerService.deleteCollect(answerCollect);
        return true;
    }
    //----------------------------
    @RequestMapping("/insertLike")
    public Boolean insertLike(HttpSession session){
        int aid = answerService.selectNowAnswer().getAid();
        int id = ((User)session.getAttribute("user")).getId();
        int bid = favoriteService.select().getBid();
        AnswerLike answerLike = new AnswerLike(id,aid,bid);
        answerService.insertLike(answerLike);
        return true;
    }

    @RequestMapping("/deleteLike")
    public Boolean deleteLike(HttpSession session){
        int aid = answerService.selectNowAnswer().getAid();
        int id = ((User)session.getAttribute("user")).getId();
        int bid = favoriteService.select().getBid();
        AnswerLike answerLike = new AnswerLike(id,aid,bid);
        answerService.deleteLike(answerLike);
        return true;
    }
}
