package bsac.dao;


import bsac.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RoleRepository implements DaoRepos<Role> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public SessionFactory getBeanToBeAutowired() {
        return sessionFactory;
    }

}