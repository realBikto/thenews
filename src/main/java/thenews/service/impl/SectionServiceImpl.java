package thenews.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thenews.database.impl.SectionDatabase;
import thenews.model.Section;
import thenews.service.SectionService;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionDatabase sectionDatabase;

    @Override
    public List<Section> findAll() {
        return sectionDatabase.findAll();
    }

    @Override
    public Section findById(int id) {
        return sectionDatabase.findById(id);
    }

}
