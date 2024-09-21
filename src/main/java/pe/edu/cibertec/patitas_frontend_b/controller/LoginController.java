package pe.edu.cibertec.patitas_frontend_b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.cibertec.patitas_frontend_b.viewmodel.LoginModel;

@Controller // Indica que esta clase es un controlador
@RequestMapping("/login") // Indica que esta clase es un controlador y que se debe mapear la ruta /login
public class LoginController {
    @GetMapping("/inicio") // Indica que se debe mapear la ruta GET /login
    public String inicio(Model model) { // Indica que se debe mapear la ruta GET /login
        LoginModel loginModel = new LoginModel("00", "", ""); // Crea un objeto LoginModel
        model.addAttribute("LoginModel", loginModel); // Agrega el objeto LoginModel al modelo
        return "inicio";
    }

    @PostMapping("/auntenticar") // Indica que se debe mapear la ruta POST /login
    public String auntenticar(@RequestParam("tipoDocumento") String tipoDocumento,
                              @RequestParam("numeroDocumento") String numeroDocumento,
                              @RequestParam("password") String password,
                              Model model) {

        // Validar los datos del formulario
        if (tipoDocumento == null || tipoDocumento.trim().length() == 0 ||
                numeroDocumento == null || numeroDocumento.trim().length() == 0 ||
                password == null || password.trim().length() == 0){

            LoginModel loginModel = new LoginModel("01", "Error: Debe completar correctamente sus credenciales", "");
            model.addAttribute("loginModel", loginModel);
            return "inicio";
        }
        LoginModel loginModel = new LoginModel("00", "", "Bruno Diaz");
        model.addAttribute("loginModel", loginModel);
        return "principal";

    }
}
