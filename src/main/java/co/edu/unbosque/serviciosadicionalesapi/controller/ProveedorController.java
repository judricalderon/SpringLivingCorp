package co.edu.unbosque.serviciosadicionalesapi.controller;

import co.edu.unbosque.serviciosadicionalesapi.model.dto.ProveedorDto;
import co.edu.unbosque.serviciosadicionalesapi.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProveedorController implements ProveedorAPI {
    @Autowired
    private ProveedorService proveedorService;
    @Override
    public ResponseEntity<ProveedorDto> modificarServicio(ProveedorDto proveedorDto) {
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(proveedorService.modificarProveedor(proveedorDto));
    }

    @Override
    public ResponseEntity<String> eliminarServicio(Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(proveedorService.eliminar(id));
    }

    @Override
    public ResponseEntity<ProveedorDto> obtenerServicio(Integer id) {
        ProveedorDto proveedorDto = proveedorService.buscar(id);
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(proveedorDto);
    }

    @Override
    public ResponseEntity<List<ProveedorDto>> obtenerServicios() {
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(proveedorService.listar());

    }

    @Override
    public ResponseEntity<ProveedorDto> createEmployee(ProveedorDto proveedorDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(proveedorService.crear(proveedorDto));
    }
}
