package kodlamaio.hrmsProject.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.PersonnelService;
import kodlamaio.hrmsProject.core.utilities.DataResult;
import kodlamaio.hrmsProject.entities.Personnel;

@RestController
@RequestMapping("/api/personnels/")
public class PersonnelController {

	private PersonnelService personnelService;

	@Autowired
	public PersonnelController(PersonnelService personnelService) {
		super();
		this.personnelService = personnelService;
	}
	
	@GetMapping("getall")
	public DataResult<List<Personnel>> getAll(){
		return this.personnelService.getAll();
	}
	
	
}
