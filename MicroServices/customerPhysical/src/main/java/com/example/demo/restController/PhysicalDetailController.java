package com.example.demo.restController;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.PhysicalDetail;
import com.example.demo.entity.PhysicalDetailsDto;
import com.example.demo.repo.CustomerRepository;
import com.example.demo.repo.PhysicalDetailRepository;
import com.example.demo.requestAndResponseModel.RequestModel;
import com.example.demo.requestAndResponseModel.ResponseModel;
import com.example.demo.service.PhysicalDetailService;

@RestController
public class PhysicalDetailController {
	@Autowired
    private PhysicalDetailRepository physicalDetailRepository;
	private PhysicalDetailService physicalDetailService;
	private CustomerRepository customerRepository;
	private ModelMapper mapper;
   @Autowired
	public PhysicalDetailController(PhysicalDetailService physicalDetailService,CustomerRepository customerRepository) {
		super();
		this.physicalDetailService = physicalDetailService;
		this.customerRepository = customerRepository;
		this.mapper = new ModelMapper();
		this.mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
	}
   
   @PostMapping("/physicalDetails")
   public ResponseEntity<ResponseModel> insertPhysicalDetail(@RequestBody RequestModel requestModel)
   {    Customer cust = new Customer(4,"cHIRAG");
       customerRepository.save(cust);
	   PhysicalDetailsDto physicalDetailsDto = new PhysicalDetailsDto(requestModel.getHeight(), requestModel.getWeight(),requestModel.getDob() ,requestModel.getCaloriesBurn(), requestModel.getGender());
	   physicalDetailsDto.setCustomer(cust);
	   physicalDetailsDto=physicalDetailService.insertPhysicalDto(physicalDetailsDto);
	   ResponseModel responseModel = mapper.map(physicalDetailsDto, ResponseModel.class);
	   return ResponseEntity.ok(responseModel);
   }
   @GetMapping("/physicalDetails/{uuid}")
   public ResponseEntity<ResponseModel> findByUUID(@PathVariable("uuid") String uuid)
   {
	   PhysicalDetailsDto physicalDetailsDto = physicalDetailService.findByUUID(uuid);
	   if(physicalDetailsDto==null)
	   {
		   return (ResponseEntity<ResponseModel>) ResponseEntity.notFound();
	   }
	   else
	   {
		   ResponseModel responseModel = mapper.map(physicalDetailsDto, ResponseModel.class);
		   return ResponseEntity.ok(responseModel);
	   }
   }
   @GetMapping("/physicalDetails/byCustomer/{cId}")
   public ResponseEntity<ResponseModel> findPhysicalDetailByCustomer(@PathVariable("cId") String s)
   {
	   int cId = Integer.parseInt(s);
	   Optional<Customer> tempCustomer = customerRepository.findById(cId);
	   Optional<PhysicalDetail> pDetail = physicalDetailRepository.findByCustomer(tempCustomer.get());
	   ResponseModel responseModel = mapper.map(pDetail.get(), ResponseModel.class);
	   return ResponseEntity.ok(responseModel);
	   
   }
   @PutMapping("/physicalDetails/{uuid}")
   public ResponseEntity<ResponseModel> updatePhysicalDetail(@RequestBody RequestModel requestModel,@PathVariable("uuid") String uuid)
   {
	   PhysicalDetailsDto physicalDetailsDto = new PhysicalDetailsDto(requestModel.getHeight(), requestModel.getWeight(),requestModel.getDob() ,requestModel.getCaloriesBurn(), requestModel.getGender());
	   physicalDetailsDto.setUPuuid(uuid);
	   physicalDetailsDto=physicalDetailService.updatePhysicalDetail(physicalDetailsDto);
	   ResponseModel responseModel = mapper.map(physicalDetailsDto, ResponseModel.class);
	   return ResponseEntity.ok(responseModel);
   }
   
   @DeleteMapping("/physicalDetails/{uuid}")
   public ResponseEntity<String> deleteByUUID(@PathVariable("uuid") String uuid)
   {
	  physicalDetailService.deleteByUUID(uuid);
	  
	  return ResponseEntity.ok("Deleted");
   }
	
}
