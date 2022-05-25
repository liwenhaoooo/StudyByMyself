package com.online_course.server.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.online_course.server.domain.Section;
import com.online_course.server.domain.SectionExample;
import com.online_course.server.dto.SectionDto;
import com.online_course.server.dto.PageDto;
import com.online_course.server.mapper.SectionMapper;
import com.online_course.server.util.CopyUtil;
import com.online_course.server.util.UuidUtil;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
import java.util.Date;
@Service
public class SectionService {

    @Resource
    private SectionMapper sectionMapper;
    /**
     * 列表查询
     */
    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        SectionExample sectionExample = new SectionExample();
                sectionExample.setOrderByClause("sort asc");
        List<Section> sectionList = sectionMapper.selectByExample(sectionExample);
        PageInfo<Section> pageInfo = new PageInfo<>(sectionList);
        pageDto.setTotal(pageInfo.getTotal());
        List<SectionDto> sectionDtoList = CopyUtil.copyList(sectionList, SectionDto.class);
        pageDto.setList(sectionDtoList);
    }
    /**
     * 保存，id有值时更新，无值时新增
     */
    public void save(SectionDto sectionDto) {
        Section section = CopyUtil.copy(sectionDto, Section.class);
        if (StringUtil.isEmpty(sectionDto.getId())) {
            this.insert(section);
        }else {
            this.update(section);
        }
    }
    /**
     * 新增
     */
    private void insert(Section section) {
        Date now = new Date();
                section.setCreatedAt(now);
                section.setUpdatedAt(now);
        section.setId(UuidUtil.getShortUuid());
        sectionMapper.insert(section);
    }
    /**
     * 更新
     */
    private void update(Section section) {
                section.setUpdatedAt(new Date());
        sectionMapper.updateByPrimaryKey(section);
    }
    /**
     * 删除
     */
    public void delete(String id) {
        sectionMapper.deleteByPrimaryKey(id);
    }
}