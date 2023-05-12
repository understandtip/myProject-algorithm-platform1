package org.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.project.domain.Blog;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BlogMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from blog")
    List<Blog> selectAll();

    /**
     * 添加数据
     * @param blog
     */
    @Insert("insert into blog values(null,#{title},#{content},#{outline},#{input},#{output})")
    void add(Blog blog);


    /**
     * 批量删除
     * @param bids
     */
    void deleteByIds(@Param("bids") int[] bids);

    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from blog limit #{begin} , #{size}")
    List<Blog> selectByPage(@Param("begin") int begin,@Param("size") int size);

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from blog ")
    int selectTotalCount();



    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @return
     */
    List<Blog> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("blog") Blog blog);

    /**
     * 根据条件查询总记录数
     * @return
     */
    int selectTotalCountByCondition(Blog blog);

    /**
     * 根据id查询
     * @param bid
     * @return
     */
    @Select("select * from blog where bid = #{bid}")
    Blog selectById(int bid);

    /**
     * 删除
     * @param bid
     */
    @Select("delete from blog where bid=#{bid}")
    void delete(int bid);

    /**
     * 修改品牌
     * @param blog
     */
    @Select("update blog set title = #{title},content = #{content},outline = #{outline},input = #{input},output = #{output} where bid = #{bid}")
    void update(Blog blog);
}
