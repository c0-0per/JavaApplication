//package cz.cvut.ear.privatelib.dao;
//
//import cz.cvut.ear.privatelib.PrivateLibraryApplication;
//import cz.cvut.ear.privatelib.environment.Generator;
//import cz.cvut.ear.privatelib.model.User;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@ComponentScan(basePackageClasses = PrivateLibraryApplication.class)
//@DataJpaTest
//public class UserDaoTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private UserDao userDao;
//
//    @Test
//    public void whenFindByUsername_thenReturnUser() {
//        User user = Generator.generateUser();
//        entityManager.persist(user);
//        entityManager.flush();
//
//        User found = userDao.findByUsername(user.getUsername());
//
//        assertThat(found.getUsername())
//                .isEqualTo(user.getUsername());
//    }
//
//
//}
