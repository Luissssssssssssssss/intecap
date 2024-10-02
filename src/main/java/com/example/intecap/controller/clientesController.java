package com.example.intecap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.intecap.models.clientesModel;
import com.example.intecap.service.clientesService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/clientes")
public class clientesController {
    
    @Autowired
    private clientesService clientesService;

    @GetMapping("/listar")
    public Iterable<clientesModel> getClientes() {
        return this.clientesService.findAll();
    }
    
     @PostMapping("/guardar")
    public ResponseEntity<String> saveClientes(@RequestBody clientesModel entity) {
        try {
            this.clientesService.save(entity);
            return ResponseEntity.ok("Cliente Guardado Correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el Servidor");
        }
    }
        @DeleteMapping("/eliminar/{idCliente}")
    public ResponseEntity<String> deleteClientes(@PathVariable int idCliente) {
        try {
            this.clientesService.deleteById(idCliente);
            return ResponseEntity.ok("Cliente Eliminado Correctamente");
        } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error en el Servidor");
        }
    }

}
