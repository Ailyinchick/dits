package incubator.dao;

import incubator.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TopicRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Topic save(Topic topic){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(topic);
        transaction.commit();
        session.close();
        return topic;
    }

    @Transactional
    public List<Topic> findAll() {
        List<Topic> topics = (List<Topic>) sessionFactory.openSession().createQuery("From Topic").list();
        return topics;
    }


}