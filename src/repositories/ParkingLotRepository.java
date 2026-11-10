package repositories;

import models.ParkingLot;

/** Assumption:
 *      1. We have one parking lot with 10 floors and can be increase or decrease
 *      2. Each floor will have 50 slots (5 heavy vehicles, 30 bikes, 15 cars) - Reconfigurable in future
 *      3. There are std rule for calculating fees( Bike-10/hr, Car-30/hr, Truck-50/hr) and can be changed in the future.
 *      4. There are std. rule for giving slots to vehicles(i.e. nearest ones first) and can be changed in the future.
 */
public class ParkingLotRepository extends InMemoryRepository<ParkingLot>{

}
