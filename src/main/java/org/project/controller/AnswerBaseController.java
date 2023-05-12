package org.project.controller;

import org.project.domain.AnswerBase;
import org.project.domain.StudySituation;
import org.project.domain.User;
import org.project.service.AnswerBaseService;
import org.project.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/answerBase")
public class AnswerBaseController {
    @Autowired
    private AnswerBaseService answerBaseService;
    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping("/selectByBidAndId")
    public Boolean selectByBidAndId(HttpSession session){
        AnswerBase answerBases = answerBaseService.selectByBidAndId(favoriteService.select().getBid(),
                ((User)session.getAttribute("user")).getId());
        return answerBases != null;
    }

    @RequestMapping("/insertAnswerBase")
    public void insertAnswerBase(HttpSession session){
        int bid = favoriteService.select().getBid();
        int id = ((User)session.getAttribute("user")).getId();
        AnswerBase answerBase = new AnswerBase(bid,id);
        AnswerBase answerBase1 = answerBaseService.selectByBidAndId(bid,id);//1.调用service查询
        if(answerBase1 == null){
            answerBaseService.insertAnswerBase(answerBase);//数据库中没有 (bid,id)数据   才新增
        }else {  /*  否则不新增数据  */  }
    }

    @RequestMapping("/selectAll")//用户学习情况信息,
    public Result selectAll(){
        List<StudySituation> data = answerBaseService.selectAll();
        return new Result(data != null ? Code.POST_OK : Code.POST_ERR,
                data,
                data != null ?  "响应正常" : "服务器未响应，请稍后重试");
    }
}
