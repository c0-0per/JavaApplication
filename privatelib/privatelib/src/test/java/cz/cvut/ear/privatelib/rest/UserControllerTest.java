//package cz.cvut.ear.privatelib.rest;
//
//import cz.cvut.ear.privatelib.model.User;
//import cz.cvut.ear.privatelib.service.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//public class UserControllerTest extends BaseControllerTest {
//    @Mock
//    private UserService userServiceMock;
//
//    @InjectMocks
//    private UserController sut;
//
//    @BeforeEach
//    public void setUp() {
//        super.setUp(sut);
//    }
//
//    @Test
//    public void getByIdReturnsMatchingUser() throws Exception {
//        final User user = new User();
//        assertNotNull(user);
//    }
//}