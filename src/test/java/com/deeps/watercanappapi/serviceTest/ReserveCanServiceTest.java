/*
 * package com.deeps.watercanappapi.serviceTest;
 * 
 * import static org.junit.Assert.assertNotNull;
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
 * com.deeps.watercanappapi.model.ReserveDetails; import
 * com.deeps.watercanappapi.repository.AvailabilityRepository; import
 * com.deeps.watercanappapi.repository.ReserveCanRepository;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest public class ReserveCanServiceTest {
 * 
 * @Autowired private ReserveCanRepository reserveCanRepository;
 * 
 * @Autowired private AvailabilityRepository availabilityRepository;
 * 
 * @Test public void reserveCan() throws ServiceException { String mobileNumber
 * = "8939411347"; Long number = Long.parseLong(mobileNumber); int reserveCans =
 * 10; String status = "Reserved...Order Pending...!!!"; ReserveDetails
 * canReserve = new ReserveDetails(); canReserve.setReservedList(reserveCans);
 * canReserve.setNumber(number); canReserve.setStatus(status);
 * canReserve.setDate(LocalDateTime.now()); Integer reserveId = null;
 * ReserveDetails canReserveResult; reserveId =
 * reserveCanRepository.findByRepeatId(number); if (reserveId == null) {
 * canReserveResult = reserveCanRepository.save(canReserve); reserveId =
 * canReserveResult.getId(); List<Availability> value =
 * availabilityRepository.getStock(); Availability availableStock =
 * value.get(0); int value1 = availableStock.getAvailability_List(); int result
 * = value1 - canReserve.getReservedList();
 * availableStock.setAvailability_List(result);
 * availabilityRepository.save(availableStock); assertNotNull(reserveId);
 * assertNotNull(value); } }
 * 
 * @Test public void reserveOrderCan() throws ServiceException { String
 * mobileNumber= "8939411347"; Long number=Long.parseLong(mobileNumber); int
 * reserveId = 14; String status = "Ordered";
 * 
 * ReserveDetails orderCanValue = null; ReserveDetails cans =
 * reserveCanRepository.findByReserveId(reserveId); if (cans != null) { int can
 * = cans.getReservedList(); ReserveDetails orderCan = new ReserveDetails();
 * orderCan.setReservedOrder(can); orderCan.setReservedList(can);
 * orderCan.setNumber(number); orderCan.setStatus(status);
 * orderCan.setDate(LocalDateTime.now()); orderCanValue =
 * reserveCanRepository.save(orderCan); ReserveDetails reserveCan = new
 * ReserveDetails(); reserveCan.setId(reserveId);
 * reserveCanRepository.delete(reserveCan); assertNotNull(orderCanValue);
 * assertNotNull(cans); } }
 * 
 * @Test public void reserveModifyCan() throws ServiceException { String
 * mobileNumber= "7010058557"; Long number=Long.parseLong(mobileNumber); int
 * reserveId = 11; int can = 7; String status = "Ordered"; ReserveDetails
 * orderCanValue = null; ReserveDetails result = null; result =
 * reserveCanRepository.findByReserveOrderId(reserveId); if(result != null) {
 * int reserveCan = result.getReservedList(); if(result.getId() == reserveId) {
 * if (can < reserveCan) { ReserveDetails orderCan = new ReserveDetails();
 * orderCan.setReservedOrder(can); orderCan.setReservedList(reserveCan);
 * orderCan.setNumber(number); orderCan.setStatus(status);
 * orderCan.setDate(LocalDateTime.now()); orderCanValue =
 * reserveCanRepository.save(orderCan); int balanceCan = reserveCan - can;
 * List<Availability> value = availabilityRepository.getStock(); Availability
 * availableStock = value.get(0); int availableCan =
 * availableStock.getAvailability_List(); int totalCanAfterOrder = balanceCan +
 * availableCan; availableStock.setAvailability_List(totalCanAfterOrder);
 * Availability canAdded; canAdded =
 * availabilityRepository.save(availableStock); ReserveDetails reserveCans = new
 * ReserveDetails(); reserveCans.setId(reserveId);
 * reserveCanRepository.delete(reserveCans); assertNotNull(orderCanValue);
 * assertNotNull(canAdded); } } } }
 * 
 * @Test public void reserveCancelCan() throws ServiceException { int orderId =
 * 13; String mobileNumber= "7010058557"; Long
 * number=Long.parseLong(mobileNumber); ReserveDetails cans =
 * reserveCanRepository.findByCancelId(orderId); int value2 =
 * cans.getReservedList(); if (cans.getNumber() != number && cans.getStatus()!=
 * "Ordered") { ReserveDetails canId = new ReserveDetails();
 * canId.setId(orderId); reserveCanRepository.delete(canId); Availability stock
 * = null; List<Availability> value = availabilityRepository.getStock();
 * Availability availability = value.get(0); int value1 =
 * availability.getAvailability_List(); int result = value1 + value2;
 * availability.setAvailability_List(result); stock =
 * availabilityRepository.save(availability); } } }
 */