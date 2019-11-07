/*
 * package com.deeps.watercanappapi.serviceTest;
 * 
 * import static org.junit.Assert.assertNotNull;
 * 
 * import java.sql.SQLException; import java.util.List;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.test.context.junit4.SpringRunner; import
 * com.deeps.watercanappapi.model.Availability; import
 * com.deeps.watercanappapi.model.OrderDetails; import
 * com.deeps.watercanappapi.model.ReserveDetails; import
 * com.deeps.watercanappapi.repository.AvailabilityRepository; import
 * com.deeps.watercanappapi.repository.OrderCanRepository; import
 * com.deeps.watercanappapi.repository.ReserveCanRepository;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest public class AvailabilityServiceTest {
 * 
 * @Autowired private AvailabilityRepository availabilityRepository;
 * 
 * @Autowired private OrderCanRepository orderCanRepository;
 * 
 * @Autowired private ReserveCanRepository reserveCanRepository;
 * 
 * @Test public void testfindByavailableStock() throws SQLException {
 * List<Availability> list = null; list = availabilityRepository.findAll();
 * assertNotNull(list); }
 * 
 * @Test public void testfindByviewOrders() throws SQLException {
 * List<OrderDetails> list = null; list = orderCanRepository.findAll();
 * assertNotNull(list); }
 * 
 * @Test public void testfindByviewReserveOrders() throws SQLException {
 * List<ReserveDetails> list = null; list = reserveCanRepository.findAll();
 * assertNotNull(list); } }
 */