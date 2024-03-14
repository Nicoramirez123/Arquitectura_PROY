package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.dto.CuentaDto;
import co.vinni.soapproyectobase.entidades.Cuenta;
import co.vinni.soapproyectobase.exception.ResourceNotFoundException;
import co.vinni.soapproyectobase.repositorios.RepositorioCuenta;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
public class ServicioCuenta implements Serializable {

    private ModelMapper modelMapper;

    private final RepositorioCuenta repositorioCuenta;

    public CuentaDto registrar(CuentaDto cuentaDto) {

        Cuenta cuenta = repositorioCuenta.save(modelMapper.map(cuentaDto, Cuenta.class));
        return modelMapper.map(cuenta, CuentaDto.class);
    }
    public List<CuentaDto> obtenerCuentas() {
        TypeToken<List<CuentaDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repositorioCuenta.findAll(), typeToken.getType());

    }
    public CuentaDto obtenerCuenta(long id) {
        Cuenta cuenta = repositorioCuenta.findById(id).orElseThrow(
                ResourceNotFoundException::new);

        return modelMapper.map(cuenta, CuentaDto.class);

    }
    public CuentaDto actualizar(CuentaDto cuentaDto) {
        repositorioCuenta.save(modelMapper.map(cuentaDto, Cuenta.class));
        return cuentaDto;

    }
    public void eliminar(long serial) {

        repositorioCuenta.deleteById(serial);


    }
}
