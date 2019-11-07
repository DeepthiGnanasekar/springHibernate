/*
 * package com.deeps.watercanappapi.serviceTest;
 * 
 * import static org.junit.Assert.assertNotNull; import static
 * org.junit.Assert.assertNull; import java.sql.SQLException; import
 * java.util.List; import org.junit.Test; import org.junit.runner.RunWith;
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.test.context.junit4.SpringRunner; import
 * com.deeps.watercanappapi.exception.DBException; import
 * com.deeps.watercanappapi.exception.ServiceException; import
 * com.deeps.watercanappapi.model.AdminDetails; import
 * com.deeps.watercanappapi.model.Availability; import
 * com.deeps.watercanappapi.repository.AdminRepository; import
 * com.deeps.watercanappapi.repository.AvailabilityRepository;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest public class AdminServiceTest {
 * 
 * @Autowired private AdminRepository adminRepository;
 * 
 * @Autowired private AvailabilityRepository availabilityRepository;
 * 
 * @Test public void testfindByNullName() throws DBException, SQLException {
 * 
 * String adminName = null; String adminPassword = null; AdminDetails details;
 * details = adminRepository.adminLogin(adminName, adminPassword);
 * assertNull(details); }
 * 
 * @Test public void testfindByInvalidName() throws DBException, SQLException {
 * String adminName = ""; String adminPassword = ""; AdminDetails details;
 * details = adminRepository.adminLogin(adminName, adminPassword);
 * assertNull(details); }
 * 
 * @Test public void testfindByValidName() throws DBException, SQLException {
 * String adminName = "Admin"; String adminPassword = "a@123"; AdminDetails
 * details; details = adminRepository.adminLogin(adminName, adminPassword);
 * assertNotNull(details); }
 * 
 * @Test public void setCan() throws ServiceException { int cans = 2;
 * Availability stock = new Availability(); List<Availability> value =
 * availabilityRepository.getStock(); Availability availability = value.get(0);
 * int value1 = availability.getAvailability_List(); int value2 = value1 + cans;
 * availability.setAvailability_List(value2); stock =
 * availabilityRepository.save(availability); assertNotNull(value);
 * assertNotNull(stock); } }
 */