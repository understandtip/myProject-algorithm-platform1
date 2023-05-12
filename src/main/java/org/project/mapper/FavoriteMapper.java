package org.project.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.project.domain.Favorite;
import org.project.domain.Forward;
import org.project.domain.ubFavorite;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteMapper {
    /**
     * 根据rid和uid查询收藏信息
     * @param bid
     * @param id
     * @return Favorite
     */
    @Select("select * from ub_favorite where bid = #{bid} and id = #{id}")
    Favorite findByRidAndUid(@Param("bid") int bid, @Param("id")int id);

    /**
     * 添加收藏
     * @param ubfavorite
     * @return int
     */
    @Select("insert into ub_favorite (bid, indexs, id) values (#{bid},#{indexs},#{id})")
    void add(ubFavorite ubfavorite);
    //查询forward表
    @Select("select * from forward")
    Forward select();
    //更新forward表
    @Select("update forward set bid = #{bid},fid = #{fid} where bid = #{bbid} and fid = #{ffid}")
    void update(@Param("bid") int bid,@Param("fid") int fid,@Param("bbid") int bbid,@Param("ffid") int ffid);
}
