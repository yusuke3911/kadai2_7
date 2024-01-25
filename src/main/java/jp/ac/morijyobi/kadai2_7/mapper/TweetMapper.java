package jp.ac.morijyobi.kadai2_7.mapper;

import jp.ac.morijyobi.kadai2_7.bean.entity.Tweet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TweetMapper {

    @Insert("INSERT INTO tweet VALUES (0, #{sentence}, cast(now() as date))")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertTweet(Tweet tweet);

    @Select("SELECT sentence, datetime FROM tweet WHERE sentence LIKE CONCAT('%', #{keyword}, '%') ORDER BY datetime DESC")
    List<Tweet> selectTweetByKeyWord(String keyword);
}
