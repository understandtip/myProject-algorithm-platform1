package org.project.service.impl;

import org.project.mapper.BlogMapper;
import org.project.domain.Blog;
import org.project.domain.PageBean;
import org.project.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Blog> selectAll() {
        return blogMapper.selectAll();
    }

    @Override
    public void add(Blog blog) {
        blogMapper.add(blog);
    }

    @Override
    public void deleteByIds(int[] ids) {
        blogMapper.deleteByIds(ids);
    }

    @Override
    public PageBean<Blog> selectByPage(int currentPage, int pageSize) {
        int begin = (currentPage - 1) * pageSize;//4. 计算开始索引
        int size = pageSize; // 计算查询条目数
        List<Blog> rows = blogMapper.selectByPage(begin, size);//5. 查询当前页数据
        int totalCount = blogMapper.selectTotalCount();//6. 查询总记录数
        //7. 封装PageBean对象
        PageBean<Blog> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        return pageBean;
    }

    @Override
    public PageBean<Blog> selectByPageAndCondition(int currentPage, int pageSize, Blog blog) {
        int begin = (currentPage - 1) * pageSize;//4. 计算开始索引
        int size = pageSize;// 计算查询条目数
        // 处理blog条件，模糊表达式
        String title = blog.getTitle();
        if (title != null && title.length() > 0) {
            blog.setTitle("%" + title + "%");
        }
        String content = blog.getContent();
        if (content != null && content.length() > 0) {
            blog.setContent("%" + content + "%");
        }
        String outline = blog.getOutline();
        if (outline != null && outline.length() > 0) {
            blog.setOutline("%" + outline + "%");
        }
        List<Blog> rows = blogMapper.selectByPageAndCondition(begin, size, blog);//5. 查询当前页数据
        int totalCount = blogMapper.selectTotalCountByCondition(blog);//6. 查询总记录数
        //7. 封装PageBean对象
        PageBean<Blog> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        return pageBean;
    }

    /**
     * 根据id查询
     * @return
     */
    @Override
    public Blog selectById(int id){
        return blogMapper.selectById(id);
    }

    /**
     * 根据id删除
     * @param id
     */
    @Override
    public void delete(int id) {
        blogMapper.delete(id);
    }

    /**
     * 修改
     * @param blog
     */
    @Override
    public void update(Blog blog) {
        //3.调用mapper的update方法
        blogMapper.update(blog);
    }

}
