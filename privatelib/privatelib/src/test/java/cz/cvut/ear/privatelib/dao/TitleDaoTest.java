//package cz.cvut.ear.privatelib.dao;
//
//import cz.cvut.ear.privatelib.PrivateLibraryApplication;
//import cz.cvut.ear.privatelib.environment.Generator;
//import cz.cvut.ear.privatelib.model.Genre;
//import cz.cvut.ear.privatelib.model.Title;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//
//import static cz.cvut.ear.privatelib.environment.Generator.randomInt;
//import static org.junit.Assert.assertEquals;
//
//@DataJpaTest
//@ComponentScan(basePackageClasses = PrivateLibraryApplication.class)
//@ActiveProfiles("test")
//public class TitleDaoTest {
//    @Autowired
//    private TestEntityManager em;
//
//    @Autowired
//    private TitleDao sut;
//
//    @Test
//    public void findAllReturnsAllUsers() {
//        Title title;
//        for(int i = 0; i < 5; i++) {
//            title = Generator.generateTitle();
//            em.persist(title);
//        }
//
//        final List<Title> result = sut.getAll();
//
//        Assertions.assertNotNull(result);
//        Assertions.assertEquals(5, result.size());
//    }
//
//    @Test
//    public void findAllByGenreReturnsProductsInSpecifiedGenre() {
//        final Genre genre = Generator.generateGenre("testCategory");
//        em.persist(genre);
//        final List<Title> titles = Generator.generateTitles(genre);
//        em.persist(titles);
//        final List<Title> result = sut.findAllByGenre(genre);
//        assertEquals(titles.size(), result.size());
//        titles.sort(Comparator.comparing(Title::getNameOfBook));
//        result.sort(Comparator.comparing(Title::getNameOfBook));
//        for (int i = 0; i < titles.size(); i++) {
//            assertEquals(titles.get(i).getId(), result.get(i).getId());
//        }
//    }
//
//
//
//
//}