package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Controllers;

import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Model.services.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flor")
public class FlorController {

    @Autowired
    FlorService florService;

    @PostMapping("/add")
    public ResponseEntity<FlorDTO> createFlor (@RequestBody FlorDTO florDTO){
        FlorDTO newFlor = florService.createFlor(florDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFlor);
    }
    @PutMapping("/update")
    public ResponseEntity<FlorDTO> updateFlor (@RequestBody FlorDTO florDTO){
        FlorDTO newFlor = florService.uptadeFlor(florDTO);
        return ResponseEntity.ok(newFlor);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlor (@PathVariable("id") Integer id){
        florService.deleteFlor(id);
        return ResponseEntity.ok("Flor eliminada");
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlorDTO> getFruit (@PathVariable("id") Integer id){
        FlorDTO newFlor = florService.getOne(id);
        return ResponseEntity.ok(newFlor);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<FlorDTO>> getFruits (){
        List<FlorDTO> flors = florService.getAll();
        return ResponseEntity.ok(flors);
    }


}
