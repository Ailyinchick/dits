package bsac.dao;

import bsac.model.Answer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AnswerRepository implements DaoRepos<Answer> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getBeanToBeAutowired() {
        return sessionFactory;
    }

}
