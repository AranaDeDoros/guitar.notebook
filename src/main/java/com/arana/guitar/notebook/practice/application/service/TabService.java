package com.arana.guitar.notebook.practice.application.service;

import com.arana.guitar.notebook.practice.application.dto.TabCreate;
import com.arana.guitar.notebook.practice.domain.models.Tab;
import com.arana.guitar.notebook.practice.domain.repo.TabRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TabService{

    private final TabRepository tabRepository;

    public TabService(TabRepository tabRepository ) {
        this.tabRepository = tabRepository;
    }

    public List<Tab> findAll() {
        return tabRepository.findAll();
    }

    public Optional<Tab> findById(Long id) {
        return tabRepository.findById(id);
    }

    //just the tab
    public Tab create(TabCreate tabCreate) {
        Tab tab = new  Tab(
                null,
                null,
                tabCreate.getSource(),
                tabCreate.getUrl(),
                tabCreate.getComment()
        );
        return tabRepository.save(tab);
    }

    public boolean deleteById(Long id) {
        if (!tabRepository.existsById(id)) return false;
        tabRepository.deleteById(id);
        return true;
    }

    @Transactional
    public Optional<Tab> update(Long id,
                                   Tab previousTab
    ) {
        return tabRepository.findById(id).map(tab ->
        {
            tab.setSource(previousTab.getSource());
            tab.setUrl(previousTab.getUrl());
            tab.setComment(previousTab.getComment());
            return tabRepository.save(tab);
        });

    }
}


