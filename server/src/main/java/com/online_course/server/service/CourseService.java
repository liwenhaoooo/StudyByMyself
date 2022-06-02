package com.online_course.server.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.online_course.server.domain.Course;
import com.online_course.server.domain.CourseExample;
import com.online_course.server.dto.CourseDto;
import com.online_course.server.dto.PageDto;
import com.online_course.server.mapper.CourseMapper;
import com.online_course.server.util.CopyUtil;
import com.online_course.server.util.UuidUtil;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
        import java.util.Date;
@Service
public class CourseService {

    @Resource
    private CourseMapper courseMapper;
    /**
     * 列表查询
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        CourseExample courseExample = new CourseExample();
                courseExample.setOrderByClause("sort asc");
        List<Course> courseList = courseMapper.selectByExample(courseExample);
        PageInfo<Course> pageInfo = new PageInfo<>(courseList);
        pageDto.setTotal(pageInfo.getTotal());
        List<CourseDto> courseDtoList = CopyUtil.copyList(courseList, CourseDto.class);
        pageDto.setList(courseDtoList);
    }
    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(CourseDto courseDto) {
        Course course = CopyUtil.copy(courseDto, Course.class);
        if (StringUtil.isEmpty(courseDto.getId())) {
            this.insert(course);
        }else {
            this.update(course);
        }
    }
    /**
     * 新增
     */
    private void insert(Course course) {
        Date now = new Date();
                course.setCreatedAt(now);
                course.setUpdatedAt(now);
        course.setId(UuidUtil.getShortUuid());
        courseMapper.insert(course);
    }
    /**
     * 更新
     */
    private void update(Course course) {
                course.setUpdatedAt(new Date());
        courseMapper.updateByPrimaryKey(course);
    }
    /**
     * 删除
     */
    public void delete(String id) {
        courseMapper.deleteByPrimaryKey(id);
    }
}