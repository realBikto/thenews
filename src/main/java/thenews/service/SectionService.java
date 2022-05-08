package thenews.service;

import thenews.model.Section;

import java.util.List;

public interface SectionService {

    public List<Section> findAll();
    public Section findById(int id);
}
