//package hb.fr.SrpingTp.controllers;
//
//import hb.fr.SrpingTp.dto.EditionDto;
//import hb.fr.SrpingTp.models.Edition;
//import hb.fr.SrpingTp.services.EditionService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/editions")
//@Validated
//public class EditionRestController {
//
//    private EditionService editionService;
//
//    public EditionRestController(EditionService editionService){
//        this.editionService = editionService;
//    }
//
//
//    @GetMapping("")
//    public List<EditionDto> getAllEditions() {
//        return editionService.getAllEditions();
//    }
//
//    @GetMapping("/{id}")
//    public EditionDto getEditionById(@PathVariable Long id) {
//        return editionService.getEditionById(id);
//    }
//
//    @PostMapping("")
//    @ResponseStatus(code = HttpStatus.CREATED)
//    public Edition saveEdition(@Valid @RequestBody EditionDto editionDto) {
//        return editionService.saveEdition(editionDto);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(code = HttpStatus.NO_CONTENT)
//    public void deleteEdition(@PathVariable Long id) {
//        editionService.deleteEdition(id);
//    }
//
//    @PutMapping("/{id}")
//    public Edition updateEdition(@PathVariable Long id,@Valid @RequestBody EditionDto editionDto) {
//        editionDto.setId(id);
//        return editionService.saveEdition(editionDto);
//    }
//}
