package cz.cvut.ear.privatelib.environment;

import cz.cvut.ear.privatelib.model.Genre;
import cz.cvut.ear.privatelib.model.Role;
import cz.cvut.ear.privatelib.model.Title;
import cz.cvut.ear.privatelib.model.User;

import java.util.*;

public class Generator {
    private static final Random RAND = new Random();

    public static int randomInt() {
        return RAND.nextInt();
    }

    public static int randomInt(int max) {
        return RAND.nextInt(max);
    }

    public static int randomInt(int min, int max) {
        assert min >= 0;
        assert min < max;

        int result;
        do {
            result = randomInt(max);
        } while (result < min);
        return result;
    }

    public static boolean randomBoolean() {
        return RAND.nextBoolean();
    }

//    public static User generateUser() {
//        final User user = new User();
//        user.setUsername("username" + randomInt() + "@kbss.felk.cvut.cz");
//        user.setPassword(Integer.toString(randomInt()));
//        return user;
//    }

    public static Title generateTitle() {
        final Title title = new Title();
        title.setNameOfBook("name" + randomInt());
        title.setDescriptionOfBook(Integer.toString(randomInt()));
        title.setPublicationYear(randomInt());
        return title;
    }

    public static User generateUser() {
        final User user = new User();
        user.setUsername("username" + randomInt());
        user.setPassword(Integer.toString(randomInt()));
        user.setEmail("email" + randomInt() + "@kbss.felk.cvut.cz");
        Role role = new Role();
        role.setName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        user.setRoles(roleSet);

        return user;

    }

    public static List<Title> generateTitles(Genre genre) {
        final List<Title> inCategory = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final Title p = Generator.generateTitle();
            p.setGenre(genre);
        }
        return inCategory;
    }

    public static Genre generateGenre(String name) {
        final Genre genre = new Genre();
        genre.setNameOfGenre(name);
        return genre;
    }
}
