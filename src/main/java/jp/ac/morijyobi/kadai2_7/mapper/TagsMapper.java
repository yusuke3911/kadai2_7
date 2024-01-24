package jp.ac.morijyobi.kadai2_7.mapper;

import jp.ac.morijyobi.kadai2_7.bean.entity.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagsMapper {

    @Insert("INSERT INTO tags VALUES(0, #{tagName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertTag(Tag tag);

    @Select("SELECT id, tag_name FROM tags ORDER BY id")
    List<Tag> selectAllTags();
}
