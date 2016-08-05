package theater.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import theater.persist.daos.DayOfWeekDAO;
import theater.persist.daos.GroupOfClientsDAO;
import theater.persist.daos.PeriodDAO;
import theater.persist.daos.PriceDAO;
import theater.persist.dtos.DayOfWeekDTO;
import theater.persist.dtos.GroupOfClientsDTO;
import theater.persist.dtos.PeriodDTO;
import theater.persist.dtos.PriceDTO;
import theater.persist.model.DayOfWeekEntity;
import theater.persist.model.GroupOfClientsEntity;
import theater.persist.model.PeriodEntity;
import theater.persist.model.PriceEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wookie on 2016-07-31.
 */
@Service
@Transactional
public class PeriodService implements IPeriodService {
    @Autowired
    private DayOfWeekDAO dayOfWeekDAO;

    @Autowired
    private PeriodDAO periodDAO;

    @Autowired
    private PriceDAO priceDAO;

    @Autowired
    private GroupOfClientsDAO groupOfClientsDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DayOfWeekDTO> getAllDaysOfWeek() {
        List<DayOfWeekDTO> dayOfWeekDTOs = new ArrayList<>();
        for (DayOfWeekEntity list : dayOfWeekDAO.getAll()) {
            dayOfWeekDTOs.add(convertToDto(list));
        }
        return dayOfWeekDTOs;
    }

    @Override
    public List<PeriodDTO> getAllPeriods() {
        List<PeriodDTO> periodDTOs = new ArrayList<>();
        for (PeriodEntity list : periodDAO.getAll()) {
            periodDTOs.add(convertToDto(list));
        }
        return periodDTOs;
    }

    @Override
    public List<PriceDTO> getAllPrices() {
        return null;
    }

    @Override
    public List<GroupOfClientsDTO> getAllGroupsOfClients() {
        return null;
    }

    private DayOfWeekDTO convertToDto(DayOfWeekEntity dayOfWeekEntity) {
        return modelMapper.map(dayOfWeekEntity, DayOfWeekDTO.class);
    }
    private PeriodDTO convertToDto(PeriodEntity periodEntity) {
        return modelMapper.map(periodEntity, PeriodDTO.class);
    }
    private PriceDTO convertToDto(PriceEntity priceEntity) {
        return modelMapper.map(priceEntity, PriceDTO.class);
    }
    private GroupOfClientsDTO convertToDto(GroupOfClientsEntity groupOfClientsEntity) {
        return modelMapper.map(groupOfClientsEntity, GroupOfClientsDTO.class);
    }
}
