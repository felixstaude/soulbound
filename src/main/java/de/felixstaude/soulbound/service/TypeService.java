package de.felixstaude.soulbound.service;

import de.felixstaude.soulbound.repository.TypeRepository;
import de.felixstaude.soulbound.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Type getOrCreateType(Type type) {
        return typeRepository.findByName(type.getName())
                .orElseGet(() -> typeRepository.save(type));
    }

    public Optional<Type> getTypeById(Long id) {
        return typeRepository.findById(id);
    }

    public boolean typeExistsByName(String name) {
        return typeRepository.existsByName(name);
    }
}
