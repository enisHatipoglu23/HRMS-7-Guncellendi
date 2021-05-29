package kodlamaio.hrmsProject.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.business.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.core.utilities.DataResult;
import kodlamaio.hrmsProject.core.utilities.Result;
import kodlamaio.hrmsProject.entities.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers/")
public class JobSeekerController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("getall")
	public DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
	}
	
	@PostMapping("add")
	public Result add(JobSeeker jobSeeker) {
		return this.jobSeekerService.add(jobSeeker);
	}
	
	@PostMapping("update")
	public Result update(JobSeeker jobSeeker) {
		return this.jobSeekerService.update(jobSeeker);
	}
	
	@PostMapping("delete")
	public Result delete(JobSeeker jobSeeker) {
		return this.jobSeekerService.delete(jobSeeker);
	}
	
	
	
	
	
	
	
}
