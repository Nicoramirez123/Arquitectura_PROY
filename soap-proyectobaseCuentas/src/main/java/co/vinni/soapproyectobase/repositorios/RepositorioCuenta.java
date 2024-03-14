package co.vinni.soapproyectobase.repositorios;

import co.vinni.soapproyectobase.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RepositorioCuenta extends JpaRepository <Cuenta,Long>, JpaSpecificationExecutor<Cuenta> {
}
