package theater.services;

import theater.persist.dtos.*;

import java.util.List;

/**
 * Created by Wookie on 2016-07-31.
 */
public interface IPeriodService {
    List<DayOfWeekDTO> getAllDaysOfWeek();
    //List<CycleDTO> getAllCycles();
    List<PeriodDTO> getAllPeriods();
    List<PriceDTO> getAllPrices();
    List<GroupOfClientsDTO> getAllGroupsOfClients();

    PeriodDTO getPeriodById(Integer id);

}
