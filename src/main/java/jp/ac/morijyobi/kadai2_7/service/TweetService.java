package jp.ac.morijyobi.kadai2_7.service;

import jp.ac.morijyobi.kadai2_7.bean.entity.Tweet;
import jp.ac.morijyobi.kadai2_7.bean.form.TweetForm;

import java.util.List;

public interface TweetService {

    void tweetSentence(TweetForm tweetForm);

    List<Tweet> getTweetByKeyword(String keyword);
}
