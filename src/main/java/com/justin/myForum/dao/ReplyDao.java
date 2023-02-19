package com.justin.myForum.dao;

import com.justin.myForum.domain.Reply;
import com.justin.myForum.domain.Topic;
import com.justin.myForum.util.DataSourceUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ReplyDao {
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());
    // 开启驼峰映射
    private BeanProcessor beanProcessor = new GenerousBeanProcessor();
    private RowProcessor processor = new BasicRowProcessor(beanProcessor);

    /**
     * topicId 查询回复总记录数
     * @param topicId
     * @return
     */
    public int countTotalReplyByCid(int topicId){
        String sql = "select count(*) from reply where topic_id=? ";
        Long count = null;
        try {
             count = (Long)queryRunner.query(sql,new ScalarHandler<>(),topicId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count.intValue();
    }

    public List<Reply> findListByTopicId(int topicId, int from, int pageSize) {
        String sql = "select * from reply where topic_id =? order by create_time desc limit ?,?";
        List<Reply> replyList = null;
        try {
            replyList = queryRunner.query(sql,new BeanListHandler<>(Reply.class,processor),topicId,from,pageSize);

        }catch (Exception e){
            e.printStackTrace();
        }
        return replyList;
    }

    public int save(Reply reply) {
        String sql = "insert into reply (topic_id,floor,content,user_id,username,user_img,create_time,update_time,`delete`)" +
                "values (?,?,?,?,?,?,?,?,?)";

        Object [] params = {
                reply.getTopicId(),
                reply.getFloor(),
                reply.getContent(),
                reply.getUserId(),
                reply.getUserName(),
                reply.getUserImg(),
                reply.getCreateTime(),
                reply.getUpdateTime(),
                reply.getDelete()
        };
        int rows = 0;
        try{
            rows = queryRunner.update(sql,params);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows;
    }
}
