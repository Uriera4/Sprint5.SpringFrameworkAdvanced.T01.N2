package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Model.services;

import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Model.exceptions.FlorNoContentException;
import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Model.exceptions.FlorNotFoundException;
import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlorService {

    @Autowired
    FlorRepository florRepository;

    private FlorEntity convertToFlorEntity (FlorDTO florDTO){
        FlorEntity flor = new FlorEntity(florDTO.getNomFlor(), florDTO.getPaisFlor());
        flor.setPk_FlorID(florDTO.getPk_FlorID());
        return flor;
    }
    private FlorDTO convertToFlorDTO (FlorEntity flor){
        FlorDTO florDTO = null;
        if (flor!=null) florDTO = createFlorDTO(flor);
        return florDTO;
    }
    private FlorDTO createFlorDTO (FlorEntity flor){
        return new FlorDTO(flor.getPk_FlorID(), flor.getNomFlor(), flor.getPaisFlor());
    }

    public FlorDTO createFlor (FlorDTO florDTO){
        return convertToFlorDTO(florRepository.save(convertToFlorEntity(florDTO)));
    }
    public FlorDTO uptadeFlor (FlorDTO florDTO){
        Optional<FlorEntity> optionFlor = florRepository.findById((convertToFlorEntity(florDTO)).getPk_FlorID());
        if (optionFlor.isPresent()){
            FlorEntity flor = optionFlor.get();
            flor.setNomFlor(florDTO.getNomFlor());
            flor.setPaisFlor(florDTO.getPaisFlor());
            return convertToFlorDTO(florRepository.save(convertToFlorEntity(florDTO)));
        } else {
            throw new FlorNotFoundException("Flor con ID: " + florDTO.getPk_FlorID() + ", no encontrada en la base de datos.");
        }
    }
    public void deleteFlor (Integer id){
        Optional<FlorEntity> optionalFlor = florRepository.findById(id);
        if (optionalFlor.isPresent()){
            florRepository.deleteById(id);
        } else {
            throw new FlorNotFoundException("Flor con ID: " + id + ", no encontrada en la base de datos.");
        }
    }
    public FlorDTO getOne (Integer id){
        FlorEntity flor = florRepository.findById(id).orElse(null);
        if (flor == null){
            throw new FlorNotFoundException("Flor con ID: " + id + ", no encontrada en la base de datos.");
        } else {
            return convertToFlorDTO(flor);
        }
    }
    public List<FlorDTO> getAll (){
        List<FlorEntity> flors = florRepository.findAll();
        if (flors.isEmpty()){
            throw new FlorNoContentException("No hay flores registradas en la base de datos.");
        } else {
            return flors.stream().map(this::convertToFlorDTO).toList();
        }
    }

}
