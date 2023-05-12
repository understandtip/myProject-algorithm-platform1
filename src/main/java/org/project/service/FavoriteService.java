package org.project.service;


import org.project.domain.Forward;
import org.project.domain.ubFavorite;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FavoriteService {

    /**
     * 判断是否收藏
     * @param bid
     * @param id
     * @return
     */
    public boolean isFavorite(String bid, int id);

    /**
     * 添加收藏
     *
     */
    void add(ubFavorite ubfavorite);

    //查询forward表
    Forward select();
    //修改
    void update(Forward forward,int bbid,int ffid);
}
