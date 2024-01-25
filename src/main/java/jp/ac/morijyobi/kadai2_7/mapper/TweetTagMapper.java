package jp.ac.morijyobi.kadai2_7.mapper;

import jp.ac.morijyobi.kadai2_7.bean.entity.TweetTag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TweetTagMapper {
    @Insert("INSERT INTO tweet_tags VALUES (#{tweetId}, #{tagId})")
    void insertTweetTag(TweetTag tweetTag);
}
