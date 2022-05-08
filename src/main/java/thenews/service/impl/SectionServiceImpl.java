package thenews.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thenews.database.SectionDB;
import thenews.model.Section;
import thenews.service.SectionService;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionDB sectionDB;

    @Override
    public List<Section> findAll() {
        return sectionDB.findAll();
    }

    @Override
    public Section findById(int id) {
        return sectionDB.findById(id);
    }

}
