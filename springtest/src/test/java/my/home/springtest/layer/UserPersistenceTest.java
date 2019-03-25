package my.home.springtest.layer;

import my.home.springtest.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserPersistenceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void test(){
        entityManager.getEntityManager().createQuery("DELETE FROM User").executeUpdate();
        Assert.assertEquals(getCountUser(), 0L);
        entityManager.persist(new User());
        Assert.assertEquals(getCountUser(), 1L);
        entityManager.getEntityManager().createQuery("DELETE FROM User").executeUpdate();
        Assert.assertEquals(getCountUser(), 0L);
    }

    private long getCountUser(){
        return entityManager.getEntityManager().createQuery("SELECT COUNT(e) FROM User e", Long.class)
                .getSingleResult();
    }
}
