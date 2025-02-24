package com.example.kubernetesk8s;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/names")
@CrossOrigin(origins = "http://roomscout.online")
public class NameController {
    @Autowired
    private NameService nameService;

    @GetMapping
    public List<Name> getNames() {
        return nameService.getAllNames();
    }

    @PostMapping
    public void addName(@RequestParam String name) {
        nameService.addName(name);
    }

    // Nuevo endpoint para saludar
    @GetMapping("/hello")
    public String sayHello() {
        return "Hola a todos nuestros clientes: " + nameService.getAllNames().toString();
    }
}

