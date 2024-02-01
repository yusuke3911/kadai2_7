package jp.ac.morijyobi.kadai2_7.service.impl;

import jp.ac.morijyobi.kadai2_7.bean.entity.Tweet;
import jp.ac.morijyobi.kadai2_7.bean.entity.TweetTag;
import jp.ac.morijyobi.kadai2_7.bean.form.TweetForm;
import jp.ac.morijyobi.kadai2_7.mapper.TweetMapper;
import jp.ac.morijyobi.kadai2_7.mapper.TweetTagMapper;
import jp.ac.morijyobi.kadai2_7.security.LoginUserDetails;
import jp.ac.morijyobi.kadai2_7.service.TweetService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TweetServiceImpl implements TweetService {

    private final TweetMapper tweetMapper;
    private final TweetTagMapper tweetTagMapper;

    public TweetServiceImpl(TweetMapper tweetMapper, TweetTagMapper tweetTagMapper) {
        this.tweetMapper = tweetMapper;
        this.tweetTagMapper = tweetTagMapper;
    }

    @Override
    public void tweetSentence(TweetForm tweetForm) {

    }

    @Override
    @Transactional
    public void tweetSentence(TweetForm tweetForm, @AuthenticationPrincipal LoginUserDetails user) {

        Tweet tweet = new Tweet();
        tweet.setSentence(tweetForm.getSentence());
        tweet.setUsername(user.getUsername());

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
