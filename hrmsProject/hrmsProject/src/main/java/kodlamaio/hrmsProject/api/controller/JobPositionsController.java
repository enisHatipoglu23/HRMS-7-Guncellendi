package kodlamaio.hrmsProject.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.JobPositionsService;
import kodlamaio.hrmsProject.core.utilities.DataResult;
import kodlamaio.hrmsProject.core.utilities.Result;
import kodlamaio.hrmsProject.entities.JobPositions;

@RestController
@RequestMapping("/api/jobpositions/")
public class JobPositionsController {

	private JobPositionsService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionsService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	@GetMapping("getall")
	public DataResult<List<JobPositions>> getAll(){
		return this.jobPositionService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody JobPositions jobPositions) {
		return this.jobPositionService.add(jobPositions);
	}
	
}
