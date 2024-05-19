package co.edu.unbosque.serviciosadicionalesapi.service;

import co.edu.unbosque.serviciosadicionalesapi.exception.PorveedorNotFoundException;
import co.edu.unbosque.serviciosadicionalesapi.model.dto.ProveedorDto;
import co.edu.unbosque.serviciosadicionalesapi.model.entity.Proveedor;
import co.edu.unbosque.serviciosadicionalesapi.repository.ProveedorInterfaceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProveedorInterfaceRepository proveedorRepository;

    public ProveedorDto modificarProveedor(ProveedorDto proveedorDto) {
        return modelMapper
                .map(proveedorRepository.save(modelMapper.map(proveedorDto,Proveedor.class)), ProveedorDto.class);
    }

    public ProveedorDto crear(ProveedorDto proveedorDto) {
        Proveedor aux =proveedorRepository.save(modelMapper.map(proveedorDto, Proveedor.class));
        return modelMapper.map(aux, ProveedorDto.class);
    }
    public List<ProveedorDto> listar() {
        return proveedorRepository
                .findAll()
                .stream()
                .map(entity -> modelMapper.map(entity,ProveedorDto.class))
                .toList();
    }

    public ProveedorDto buscar(int id) {
        return proveedorRepository
                .findById(id)
                .map(entity-> modelMapper.map(entity,ProveedorDto.class))
                .orElseThrow(()->new PorveedorNotFoundException("Servicio no encontrado"));
    }
    public String eliminar(int id) {
        proveedorRepository.deleteById(id);
        return "Se elimino con exito";
    }

}
