package co.edu.unbosque.serviciosadicionalesapi.repository;

import co.edu.unbosque.serviciosadicionalesapi.model.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorInterfaceRepository extends JpaRepository<Proveedor, Integer> {

}
