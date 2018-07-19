package com.yianyouxuan.message.repository;
import com.yianyouxuan.message.domain.Message;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message,String> {
    //  严格的接收人相等查询
    List<Message> findByReceivers(List<String> receivers);
    //  查询包含该接收人的即可
    List<Message>  findByReceivers(String receiver);
}
