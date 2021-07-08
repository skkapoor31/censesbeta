package com.censes.beta.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.censes.beta.DTO.AnswerDTO;
import com.censes.beta.DTO.UserDTO;
import com.censes.beta.DTO.ValuationResponseDTO;
import com.censes.beta.Repository.UserRepo;
import com.censes.beta.dao.CensesDao;
import com.censes.beta.entity.Answer;
import com.censes.beta.entity.User;

@Service
public class CensesServiceImpl implements CensesService{

	@Autowired
	CensesDao censesdao;

	@Autowired
	UserRepo userRepo;
	
	@Async
    public CompletableFuture<String> getValuationofMember(Long uuid) {
		System.out.println(Thread.currentThread().getName());
		String xy = censesdao.getValuation(uuid);

        return CompletableFuture.completedFuture(xy);
    }

	@Async
	public CompletableFuture<User> getUserfromUUID(Long uuid){
		System.out.println(Thread.currentThread().getName());
		User u = userRepo.getById(uuid);
		return CompletableFuture.completedFuture(u);
	}
	public UserDTO getValuation(Long uuid) {

		//String xy = censesdao.getValuation(uuid);
		System.out.println(Thread.currentThread().getName());
		String xy = null;
		try {
			xy = getValuationofMember(uuid).get();
			
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		User u = null;
		try {
			u = getUserfromUUID(uuid).get();
			//System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CompletableFuture.allOf(getValuationofMember(uuid), getUserfromUUID(uuid)).join();
		//User u = userRepo.getById(uuid);
		u.setX_axis(Float.parseFloat(getXandY(xy)[0]));
		u.setY_axis(Float.parseFloat(getXandY(xy)[1]));
		userRepo.save(u);
		UserDTO u1 = convertEntityToDTO(u);

		return u1;
	}

	String[] getXandY(String xy) {
		String xy_changed = xy.replaceAll("\\[", "").replaceAll("\\]","");
		String[] xyarr = xy_changed.split(",");
		return xyarr;

	}

	UserDTO convertEntityToDTO(User u) {
		UserDTO u1 = new UserDTO();
		u1.setAge(u.getAge());
		u1.setConstituency(u.getConstituency());
		u1.setEmail(u.getEmail());
		u1.setFirstName(u.getFirstName());
		u1.setLastName(u.getLastName());
		u1.setUserId(u.getUserid());
		u1.setX_axis(u.getX_axis());
		u1.setY_axis(u.getY_axis());
		return u1;
	}


	public void saveAnswer(List<AnswerDTO> ans, Long uuid) {
		// TODO Auto-generated method stub
		censesdao.saveAnswer(ans, uuid);

	}



	@Override
	public Long saveUser(UserDTO userDet) {
		// TODO Auto-generated method stub
		return userRepo.save(convertUserDtotoEntity(userDet)).getUserid();
	}



	private User convertUserDtotoEntity(UserDTO userDet) {
		// TODO Auto-generated method stub
		User u = new User();
		u.setAge(userDet.getAge());
		u.setConstituency(userDet.getConstituency());
		u.setEmail(userDet.getEmail());
		u.setFirstName(userDet.getFirstName());
		u.setLastName(userDet.getLastName());
		return u;
	}







}
