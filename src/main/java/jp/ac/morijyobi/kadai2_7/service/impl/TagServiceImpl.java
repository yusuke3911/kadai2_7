package jp.ac.morijyobi.kadai2_7.service.impl;

import jp.ac.morijyobi.kadai2_7.bean.entity.Tag;
import jp.ac.morijyobi.kadai2_7.bean.form.TagForm;
import jp.ac.morijyobi.kadai2_7.mapper.TagsMapper;
import jp.ac.morijyobi.kadai2_7.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService{
    private final TagsMapper tagsMapper;

    public TagServiceImpl(TagsMapper tagsMapper){
        this.tagsMapper = tagsMapper;
    }

    @Override
    public Tag registerTag(TagForm tagForm) {
        Tag tag = new Tag();
        tag.setTagName(tagForm.getTagName());

        tagsMapper.insertTag(tag);

        return null;
    }

    @Override
    public List<Tag> getAllTags() {
        return tagsMapper.selectAllTags();
    }
}
