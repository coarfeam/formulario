package com.eamapp.springweb.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.eamapp.springweb.models.entity.Usuario;
import com.eamapp.springweb.models.entity.Pais;
import com.eamapp.springweb.services.IPaisService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private IPaisService paisService;
    @GetMapping("/form")
    public String form(Model model){
        Usuario usuario = new Usuario();        
        usuario.setId("123456");
        model.addAttribute("titulo", "formulario");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @ModelAttribute("paises")
	public List<String> paises() {
		return Arrays.asList("España", "México", "Chile", "Argentina", "Perú", "Colombia", "Venezuela");
	}

    @ModelAttribute("listaPaises")
	public List<Pais> listaPaises() {
        return paisService.listar();
    }

    // @ModelAttribute("listaPaises")
	// public List<Pais> listaPaises() {
	// 	return Arrays.asList(
	// 			new Pais(1, "ES", "España"), 
	// 			new Pais(2, "MX", "México"),
	// 			new Pais(3, "CL", "Chile"),
	// 			new Pais(4, "AR", "Argentina"), 
	// 			new Pais(5, "PE", "Perú"), 
	// 			new Pais(6, "CO", "Colombia"),
	// 			new Pais(7, "VE", "Venezuela"));
	// }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
    // public String procesar(Usuario usuario, Model model){
    // public String procesar(Usuario usuario, Model model, @RequestParam String username,
            // String password, String email){
        // Usuario usuario = new Usuario();
        // model.addAttribute("titulo", "Resultado formulario");
        if (result.hasErrors()){
            model.addAttribute("titulo", "Resultado formulario");
            // Map<String, String> errores = new HashMap<>();
			// result.getFieldErrors().forEach(err ->{
			// 	errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
			// });
			// model.addAttribute("error", errores);
            return "form";
        }
        // usuario.setNombre(username);
        // usuario.setPassword(password);
        // usuario.setEmail(email);
        // model.addAttribute("usuario", usuario);
        // model.addAttribute("password", password);
        // model.addAttribute("email", email);
        
        return "redirect:/ver";
    }

    @GetMapping("/ver")
    public String ver(@SessionAttribute(name="usuario", required=false) Usuario usuario, Model model, SessionStatus status){
        if (usuario == null){
            return "redirect/form";
        }
        model.addAttribute("titulo", "Resultado formulario");
        status.setComplete();
        return "resultado";
    }
}
