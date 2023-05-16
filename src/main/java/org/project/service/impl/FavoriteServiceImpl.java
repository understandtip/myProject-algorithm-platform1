package org.project.service.impl;

import org.project.mapper.FavoriteMapper;
import org.project.domain.Favorite;
import org.project.domain.Forward;
import org.project.domain.ubFavorite;
import org.project.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public boolean isFavorite(String bid, int id) {
        Favorite favorite = favoriteMapper.findByRidAndUid(Integer.parseInt(bid), id);
        return (favorite != null);//如果对象有值，则为true，反之，则为false
    }

    @Override
    public void add(ubFavorite ubfavorite) {
        favoriteMapper.add(ubfavorite);
    }

    @Override
    public Forward select() {
        return favoriteMapper.select();
    }

    @Override
    public void update(Forward forward, int bbid, int ffid) {
        favoriteMapper.update(forward.getBid(),forward.getFid(),bbid,ffid);
    }
}
