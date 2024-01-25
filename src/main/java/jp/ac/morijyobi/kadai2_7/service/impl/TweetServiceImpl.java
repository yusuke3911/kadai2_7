package jp.ac.morijyobi.kadai2_7.service.impl;

import jp.ac.morijyobi.kadai2_7.bean.entity.Tweet;
import jp.ac.morijyobi.kadai2_7.bean.entity.TweetTag;
import jp.ac.morijyobi.kadai2_7.bean.form.TweetForm;
import jp.ac.morijyobi.kadai2_7.mapper.TweetMapper;
import jp.ac.morijyobi.kadai2_7.mapper.TweetTagMapper;
import jp.ac.morijyobi.kadai2_7.mapper.UsersMapper;
import jp.ac.morijyobi.kadai2_7.service.TweetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TweetServiceImpl implements TweetService {

    private final TweetMapper tweetMapper;
    private final TweetTagMapper tweetTagMapper;
    private final UsersMapper usersMapper;

    public TweetServiceImpl(TweetMapper tweetMapper, TweetTagMapper tweetTagMapper, UsersMapper usersMapper) {
        this.tweetMapper = tweetMapper;
        this.tweetTagMapper = tweetTagMapper;
        this.usersMapper = usersMapper;
    }

    @Override
    @Transactional
    public void tweetSentence(TweetForm tweetForm) {

        Tweet tweet = new Tweet();
        tweet.setSentence(tweetForm.getSentence());

        tweetMapper.insertTweet(tweet);

        for (int tagId : tweetForm.getTagIdList()){
            TweetTag tweetTag = new TweetTag();
            tweetTag.setTweetId(tweet.getId());
            tweetTag.setTagId(tagId);
            tweetTagMapper.insertTweetTag(tweetTag);
        }
    }

    @Override
    public List<Tweet> getTweetByKeyword(String keyword) {
        return tweetMapper.selectTweetByKeyWord(keyword);
    }
}
