package com.justin.myForum.service.impl;

import com.justin.myForum.dao.CategoryDao;
import com.justin.myForum.dao.ReplyDao;
import com.justin.myForum.dao.TopicDao;
import com.justin.myForum.domain.Category;
import com.justin.myForum.domain.Reply;
import com.justin.myForum.domain.Topic;
import com.justin.myForum.domain.User;
import com.justin.myForum.dto.PageDTO;
import com.justin.myForum.service.TopicService;

import java.util.Date;
import java.util.List;

public class TopicServiceImpl implements TopicService {
    private TopicDao topicDao = new TopicDao();
    private ReplyDao replyDao = new ReplyDao();
    private CategoryDao categoryDao = new CategoryDao();
    @Override
    public PageDTO<Topic> listTopicPageCid(int cId, int page, int pageSize) {
        // 查询总记录数
        int totalRecordNum = topicDao.countTotalTopicByCid(cId);
        int from = (page-1)*pageSize;
        // 分页查询
        List<Topic> topicList = topicDao.findListByCid(cId,from,pageSize);
        PageDTO<Topic> pageDTO = new PageDTO<>(page,pageSize,totalRecordNum);
        pageDTO.setList(topicList);
        return pageDTO;
    }

    @Override
    public Topic findById(int topicId) {
        return topicDao.findById(topicId);
    }

    @Override
    public PageDTO<Reply> findReplyPageByTopicId(int topicId, int page, int pageSize) {
        // 查询总记录数
        int totalRecordNum = replyDao.countTotalReplyByCid(topicId);
        int from = (page-1)*pageSize;
        // 分页查询
        List<Reply> replyList = replyDao.findListByTopicId(topicId,from,pageSize);
        PageDTO<Reply> pageDTO = new PageDTO<>(page,pageSize,totalRecordNum);
        pageDTO.setList(replyList);
        return pageDTO;

    }

    @Override
    public int addTopic(User loginUser, String title, String content, int cId) {
        // 查询分类ID
        Category category = categoryDao.findById(cId);
        if (category == null){
            return 0;
        }
        Topic topic = new Topic();
        topic.setTitle(title);
        topic.setContent(content);
        topic.setCreateTime(new Date());
        topic.setUpdateTime(new Date());
        topic.setPv(1);
        topic.setDelete(0);
        topic.setUserId(loginUser.getId());
        topic.setUserName(loginUser.getUserName());
        topic.setUserImg(loginUser.getImg());
        topic.setcID(cId);
        topic.setHot(0);
        int rows = 0;
        try{
            rows = topicDao.save(topic);

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int replyByTopicId(User loginUser, int topicId, String content) {
        int floor = topicDao.findLatestFloorByTopicId(topicId);
        Reply reply = new Reply();
        reply.setContent(content);
        reply.setCreateTime(new Date());
        reply.setUpdateTime(new Date());
        reply.setFloor(floor+1);
        reply.setTopicId(topicId);
        reply.setUserId(loginUser.getId());
        reply.setUserName(loginUser.getUserName());
        reply.setUserImg(loginUser.getImg());
        reply.setDelete(0);
        // 将主题回复增加到数据库中
        int rows = replyDao.save(reply);
        return rows;

    }

    @Override
    public void addOnePV(int topicId) {
        Topic topic = topicDao.findById(topicId);
        int newPV = topic.getPv()+1;
        topicDao.updatePV(topicId,newPV,topic.getPv());

    }
}
