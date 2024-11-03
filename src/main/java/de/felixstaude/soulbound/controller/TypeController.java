package de.felixstaude.soulbound.controller;

import de.felixstaude.soulbound.service.TypeService;
import de.felixstaude.soulbound.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/types")
public class TypeController {

    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping
    public ResponseEntity<?> createType(@RequestBody Type type) {
        if (typeService.typeExistsByName(type.getName())) {
            return ResponseEntity.badRequest().body("Type with name '" + type.getName() + "' already exists.");
        }
        Type createdType = typeService.getOrCreateType(type);
        return ResponseEntity.ok(createdType);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTypeById(@PathVariable Long id) {
        return typeService.getTypeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
