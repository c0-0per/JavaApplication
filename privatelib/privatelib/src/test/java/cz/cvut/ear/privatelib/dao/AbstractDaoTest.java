//package cz.cvut.ear.privatelib.dao;
//
//
//import cz.cvut.ear.privatelib.PrivateLibraryApplication;
//import cz.cvut.ear.privatelib.environment.Generator;
//import cz.cvut.ear.privatelib.model.Genre;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//@ComponentScan(basePackageClasses = PrivateLibraryApplication.class)
//@ActiveProfiles("test")
//public class AbstractDaoTest {
//
//    @Autowired
//    private TestEntityManager em;
//    @Autowired
//    private UserDao userDao ;
//    private GenreDao genreDao;
//
//
//    @Test
//    public void persistSavesSpecifiedInstance() {
//        final Genre genre = Generator.generateGenre("genre" + Generator.randomInt());
//        genreDao.persist(genre);
//        assertNotNull(genre.getId());
//
//        final Genre result = em.find(Genre.class, genre.getId());
//        assertNotNull(result);
//        assertEquals(genre.getId(), result.getId());
//        assertEquals(genre.getNameOfGenre(), result.getNameOfGenre());
//    }
//
//
//
//    @Test
//    public void findRetrievesInstanceByIdentifier() {
//        final Genre genre = Generator.generateGenre("genre" + Generator.randomInt());
//
//        em.persist(genre);
//        assertNotNull(genre.getId());
//
//        final Genre result = genreDao.find(genre.getId());
//        assertNotNull(result);
//        assertEquals(genre.getId(), result.getId());
//        assertEquals(genre.getNameOfGenre(), result.getNameOfGenre());
//    }
//
//    @Test
//    public void findAllRetrievesAllInstancesOfType() {
//        final Genre genreOne = Generator.generateGenre("genre" + Generator.randomInt());
//        em.persistAndFlush(genreOne);
//
//
//        final Genre genreTwo = Generator.generateGenre("genre" + Generator.randomInt());
//        em.persistAndFlush(genreTwo);
//
//        final List<Genre> result = genreDao.getAll();
//        assertEquals(2, result.size());
//        assertTrue(result.stream().anyMatch(a -> a.getId().equals(genreOne.getId())));
//        assertTrue(result.stream().anyMatch(a -> a.getId().equals(genreTwo.getId())));
//    }
//
//
//    @Test
//    public void updateUpdatesExistingInstance() {
//        final Genre genre = Generator.generateGenre("genre" + Generator.randomInt());
//        em.persistAndFlush(genre);
//
//        final Genre update = new Genre();
//        update.setId(genre.getId());
//        final String newName = "New name";
//        update.setNameOfGenre(newName);
//        genreDao.update(update);
//
//        final Genre result = genreDao.find(genre.getId());
//        assertNotNull(result);
//        assertEquals(genre.getNameOfGenre(), result.getNameOfGenre());
//    }
//
//    @Test
//    public void removeRemovesSpecifiedInstance() {
//        final Genre genre = Generator.generateGenre("genre" + Generator.randomInt());
//        em.persistAndFlush(genre);
//        assertNotNull(em.find(Genre.class, genre.getId()));
//        em.detach(genre);
//
//        genreDao.remove(genre);
//        assertNull(em.find(Genre.class, genre.getId()));
//    }
//
//    @Test
//    public void removeDoesNothingWhenInstanceDoesNotExist() {
//        final Genre genre = Generator.generateGenre("genre" + Generator.randomInt());
//        genre.setId(123);
//        assertNull(em.find(Genre.class, genre.getId()));
//
//        genreDao.remove(genre);
//        assertNull(em.find(Genre.class, genre.getId()));
//    }
//
//
//    @Test
//    public void existsReturnsTrueForExistingIdentifier() {
//        final Genre genre = Generator.generateGenre("genre" + Generator.randomInt());
//        em.persistAndFlush(genre);
//        assertTrue(genreDao.exists(genre.getId()));
//        assertFalse(genreDao.exists(-1));
//    }
//
//
//}
