package com.justin.myForum.service;

import com.justin.myForum.domain.Reply;
import com.justin.myForum.domain.Topic;
import com.justin.myForum.domain.User;
import com.justin.myForum.dto.PageDTO;

public interface TopicService {
    PageDTO<Topic> listTopicPageCid(int cId, int page,int pageSize);

    Topic findById(int topicId);


    PageDTO<Reply> findReplyPageByTopicId(int topicId, int page, int pageSize);

    int addTopic(User loginUser, String title, String content, int cId);

    int replyByTopicId(User loginUser, int topicId, String content);

    void addOnePV(int topicId);
}
