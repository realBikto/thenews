package thenews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thenews.database.impl.SectionDatabase;
import thenews.model.BaseDBModel;
import thenews.model.Section;

import java.util.List;

@RestController
@RequestMapping("/api/v1/section")
public class SectionController {

    @Autowired
    private SectionDatabase sectionDatabase;

    @PostMapping
    public ResponseEntity<BaseDBModel> save(@RequestBody Section section){
        return ResponseEntity.ok(new BaseDBModel(sectionDatabase.save(section)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseDBModel> update(@PathVariable int id, @RequestBody Section section){
        if (sectionDatabase.findById(id) != null){
            return ResponseEntity.ok(new BaseDBModel(sectionDatabase.update(id, section)));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseDBModel> delete(@PathVariable int id){
        return ResponseEntity.ok(new BaseDBModel(sectionDatabase.deleteById(id)));
    }

    @GetMapping
    public ResponseEntity<List<Section>> findAll(){
        return ResponseEntity.ok(sectionDatabase.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Section> findById(@PathVariable int id){
        return ResponseEntity.ok(sectionDatabase.findById(id));
    }
}
