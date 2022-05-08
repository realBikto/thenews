package thenews.service;

import thenews.model.Section;

import java.util.List;

public interface SectionService {

    List<Section> findAll();
    Section findById(int id);
}
