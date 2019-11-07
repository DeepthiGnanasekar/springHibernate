/*
 * package com.deeps.watercanappapi.serviceTest;
 * 
 * import static org.junit.Assert.assertNotNull; import static
 * org.junit.Assert.assertNull;
 * 
 * import java.sql.SQLException;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.deeps.watercanappapi.exception.DBException; import
 * com.deeps.watercanappapi.exception.ServiceException; import
 * com.deeps.watercanappapi.model.UserDetails; import
 * com.deeps.watercanappapi.repository.UserRepository;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest public class UserServiceTest {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Test public void testfindByNullName() throws DBException, SQLException {
 * 
 * Long mobileNumber = null; String setPassword = null; UserDetails details;
 * details = userRepository.login(mobileNumber, setPassword);
 * assertNull(details); }
 * 
 * @Test public void testfindByInvalidName() throws DBException, SQLException {
 * Long mobileNumber = null; String setPassword = ""; UserDetails details;
 * details = userRepository.login(mobileNumber, setPassword);
 * assertNull(details); }
 * 
 * @Test public void testfindByValidName() throws DBException, SQLException {
 * String mobileNumber = "8778532378"; Long mobile =
 * Long.parseLong(mobileNumber); String setPassword = "Deep@123"; UserDetails
 * details; details = userRepository.login(mobile, setPassword);
 * assertNotNull(details);
 * 
 * }
 * 
 * @Test public void register() throws ServiceException { String name = "Deeps";
 * String mobileNumber = "8939411347"; Long mobile =
 * Long.parseLong(mobileNumber); String setPassword = "Deep@123"; UserDetails
 * user = new UserDetails(); user.setName(name); user.setMobileNumber(mobile);
 * user.setSetPassword(setPassword); UserDetails details = null; details =
 * userRepository.save(user); assertNotNull(details); }
 * 
 * }
 */