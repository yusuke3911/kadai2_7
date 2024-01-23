package jp.ac.morijyobi.kadai2_7.service;

import jp.ac.morijyobi.kadai2_7.bean.entity.Tag;
import jp.ac.morijyobi.kadai2_7.bean.form.TagForm;

public interface TagService {

    Tag registerTag(TagForm tagForm);
}
