package com.xejarque.marsrover.NavigateHistory.service;

import com.xejarque.marsrover.NavigateHistory.repository.NavigateHistoryRepository;
import com.xejarque.marsrover.location.model.Location;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class NavigateHistoryServiceImpl implements NavigateHistoryService {

    private NavigateHistoryRepository navigateHistoryRepository;

    @Autowired
    public NavigateHistoryServiceImpl(NavigateHistoryRepository navigateHistoryRepository) {
        this.navigateHistoryRepository = navigateHistoryRepository;
    }

    public List<Location> list() {
        return navigateHistoryRepository.list();
    }

    @Override
    public void clear() {
        navigateHistoryRepository.clear();
    }

}
