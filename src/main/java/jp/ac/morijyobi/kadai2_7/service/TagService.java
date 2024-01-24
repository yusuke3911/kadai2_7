package jp.ac.morijyobi.kadai2_7.service;

import jp.ac.morijyobi.kadai2_7.bean.entity.Tag;
import jp.ac.morijyobi.kadai2_7.bean.form.TagForm;

import java.util.List;

public interface TagService {

    Tag registerTag(TagForm tagForm);

    List<Tag> getAllTags();
}
