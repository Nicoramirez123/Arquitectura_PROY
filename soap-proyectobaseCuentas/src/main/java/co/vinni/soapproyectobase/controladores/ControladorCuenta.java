package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.dto.CuentaDto;
import co.vinni.soapproyectobase.servicios.ServicioCuenta;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class ControladorCuenta {

    private static final Logger logger = LogManager.getLogger(ControladorCuenta.class);

    @Autowired
    ServicioCuenta servicioCuenta;

    @GetMapping({  "/cuentas"})
    public String listarCuentas(Model model){
        logger.info("Verificando  vehículos ");
        model.addAttribute("cuentas",servicioCuenta.obtenerCuentas());
        return "cuentas";
    }
    @GetMapping("/cuentas/nuevo")
    public String mostrarFormulario(Model model){
        CuentaDto cuentaDto = new CuentaDto();
        model.addAttribute("cuenta", cuentaDto);
        return "registrar_cuenta";
    }
    @PostMapping("/cuentas")
    public String registrarVehiculo(@ModelAttribute("cuenta") CuentaDto cuenta) {
        servicioCuenta.registrar(cuenta);
        return "redirect:/cuentas";
    }


    @GetMapping("/cuentas/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable long serial, Model model){
        CuentaDto cuentaDto = new CuentaDto();
        model.addAttribute("cuenta", servicioCuenta.obtenerCuenta(serial));
        return "editar_cuenta";
    }

    @PostMapping("/cuentas/{serial}")
    public String modificarVehiculo(@PathVariable long serial,@ModelAttribute( "cuenta") CuentaDto cuentaDto, Model model){


        model.addAttribute("cuenta", servicioCuenta.actualizar(cuentaDto));
        return "redirect:/cuentas";
    }
    @GetMapping("/cuentas/{serial}")
    public String eliminarVehiculo(@PathVariable long serial){

        servicioCuenta.eliminar(serial);

        return "redirect:/cuentas";
    }
}

