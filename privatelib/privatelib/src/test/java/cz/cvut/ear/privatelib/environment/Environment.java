//package cz.cvut.ear.privatelib.environment;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import cz.cvut.ear.privatelib.model.User;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.context.SecurityContextImpl;
//
//import java.nio.charset.StandardCharsets;
//
//public class Environment {
//    private static ObjectMapper objectMapper;
//
//    /**
//     * Gets a Jackson object mapper for mapping JSON to Java and vice versa.
//     *
//     * @return Object mapper
//     */
//    public static ObjectMapper getObjectMapper() {
//        if (objectMapper == null) {
//            objectMapper = new ObjectMapper();
//            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        }
//        return objectMapper;
//    }
//
//    public static HttpMessageConverter<?> createDefaultMessageConverter() {
//        return new MappingJackson2HttpMessageConverter(getObjectMapper());
//    }
//
//    public static HttpMessageConverter<?> createStringEncodingMessageConverter() {
//        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
//    }
//
//    /**
//     * Initializes security context with the specified user.
//     *
//     * @param user User to set as currently authenticated
//     */
//    public static void setCurrentUser(User user) {
//        final CustomUserDetails userDetails = new CustomUserDetails(user);
//        SecurityContext context = new SecurityContextImpl();
//        context.setAuthentication(new AuthenticationToken(userDetails.getAuthorities(), userDetails));
//        SecurityContextHolder.setContext(context);
//    }
//
//    /**
//     * Clears current security context.
//     */
//    public static void clearSecurityContext() {
//        SecurityContextHolder.clearContext();
//    }
//}
