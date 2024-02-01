package jp.ac.morijyobi.kadai2_7.service;

import jp.ac.morijyobi.kadai2_7.bean.entity.Tweet;
import jp.ac.morijyobi.kadai2_7.bean.form.TweetForm;
import jp.ac.morijyobi.kadai2_7.security.LoginUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TweetService {
    void tweetSentence(TweetForm tweetForm);

    @Transactional
    void tweetSentence(TweetForm tweetForm, @AuthenticationPrincipal LoginUserDetails user);

    List<Tweet> getTweetByKeyword(String keyword);
}
