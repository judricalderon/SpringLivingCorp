package co.edu.unbosque.serviciosadicionalesapi.controller;

import co.edu.unbosque.serviciosadicionalesapi.model.dto.ProveedorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("/proveedor/api")
public interface ProveedorAPI {

    @PutMapping("/proveedor")
    ResponseEntity<ProveedorDto> modificarServicio(@RequestBody ProveedorDto proveedorDto);
    @DeleteMapping("/proveedor/{id}")
    ResponseEntity<String> eliminarServicio(@PathVariable("id") Integer id);
    @GetMapping("/proveedor/{id}")
    ResponseEntity<ProveedorDto> obtenerServicio(@PathVariable Integer id);
    @GetMapping("/proveedor")
    ResponseEntity<List<ProveedorDto>> obtenerServicios();
    @PostMapping("/proveedor")
    ResponseEntity<ProveedorDto> createEmployee(@RequestBody ProveedorDto proveedorDto);
}
