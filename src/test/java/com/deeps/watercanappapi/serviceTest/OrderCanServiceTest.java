/*
 * package com.deeps.watercanappapi.serviceTest;
 * 
 * import static org.junit.Assert.assertNotNull; import static
 * org.junit.Assert.assertNull;
 * 
 * import java.time.LocalDateTime; import java.util.List;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.deeps.watercanappapi.exception.ServiceException; import
 * com.deeps.watercanappapi.model.Availability; import
 * com.deeps.watercanappapi.model.OrderDetails; import
 * com.deeps.watercanappapi.repository.AvailabilityRepository; import
 * com.deeps.watercanappapi.repository.OrderCanRepository;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest public class OrderCanServiceTest {
 * 
 * @Autowired private OrderCanRepository orderCanRepository;
 * 
 * @Autowired private AvailabilityRepository availabilityRepository;
 * 
 * @Test public void orderCan() throws ServiceException { String mobileNumber=
 * "7010058557"; Long number=Long.parseLong(mobileNumber); int orderCans = 10;
 * String status = "ORDERED"; OrderDetails canOrder = new OrderDetails();
 * canOrder.setQuantyList(orderCans); canOrder.setNumber(number);
 * canOrder.setStatus(status); canOrder.setDate(LocalDateTime.now()); Integer
 * orderId = null; OrderDetails canOrderResult; canOrderResult =
 * orderCanRepository.save(canOrder); assertNotNull(canOrderResult); orderId =
 * canOrderResult.getId(); List<Availability> value =
 * availabilityRepository.getStock(); Availability availableStock =
 * value.get(0); int value1 = availableStock.getAvailability_List(); int result
 * = value1 - canOrder.getQuantyList();
 * availableStock.setAvailability_List(result); Availability valueCheck;
 * valueCheck = availabilityRepository.save(availableStock);
 * assertNotNull(valueCheck); }
 * 
 * @Test public void cancelOrder() throws ServiceException { int orderId = 6;
 * String mobileNumber = "7010058557"; Long number=Long.parseLong(mobileNumber);
 * OrderDetails cans = orderCanRepository.findById(orderId); int value2 =
 * cans.getQuantyList(); if (cans.getNumber() == number) { OrderDetails canId =
 * new OrderDetails(); canId.setId(orderId); orderCanRepository.delete(canId);
 * Availability stock = new Availability(); List<Availability> value =
 * availabilityRepository.getStock(); Availability availability = value.get(0);
 * int value1 = availability.getAvailability_List(); int result = value1 +
 * value2; availability.setAvailability_List(result); stock =
 * availabilityRepository.save(availability); assertNotNull(stock); } } }
 */