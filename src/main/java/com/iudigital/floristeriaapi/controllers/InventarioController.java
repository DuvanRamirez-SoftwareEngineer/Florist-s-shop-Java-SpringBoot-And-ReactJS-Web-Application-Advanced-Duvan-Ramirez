        package com.iudigital.floristeriaapi.controllers;

        import java.util.List;
        import java.util.Optional;

        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.stereotype.Controller;
        import com.iudigital.floristeriaapi.models.FloresModel;
        import com.iudigital.floristeriaapi.services.FloresService;

        @Controller

        public class InventarioController {
            private FloresService floresService;


            public InventarioController (FloresService floresService){
                this.floresService=floresService;
            }

        

            @GetMapping("/inventario")
        public String showFlores(Model model){
        
            List<FloresModel> flores = floresService.getAllFlores();
            model.addAttribute("floresParaInventario",flores);
            return "/inventario";
            
        }
        //Metodo para guardar flor en la base de datos
        
            @PostMapping("/guardarflor")
        public String saveFlor(@ModelAttribute FloresModel flor) {
            this.floresService.saveFlor(flor);
            return "redirect:/inventario";
        }


        
        @GetMapping("/eliminarflor/{id_flor}")
        public String deleteFlor(@PathVariable("id_flor") Long id_flor){
            floresService.deleteFlorById(id_flor);
            return "redirect:/inventario";
        }
        
        @GetMapping("/editarflor/{id_flor}")
    public String showEditForm(@PathVariable("id_flor") Long id_flor, Model model) {
        Optional<FloresModel> florOpt = floresService.getFlorById(id_flor);
        if (florOpt.isPresent()) {
            model.addAttribute("flor", florOpt.get());
            return "editarflor";
        } else {
            return "redirect:/inventario";
        }
    }

    @PostMapping("/editarflor/{id_flor}")
    public String updateFlor(@PathVariable("id_flor") Long id_flor, @ModelAttribute FloresModel flor) {
        flor.setIdFlor(id_flor); 
        floresService.updateFlor(flor);
        return "redirect:/inventario";
    }

        }
