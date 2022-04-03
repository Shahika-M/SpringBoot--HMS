package com.example.SpringBootHMS.service;
import java.util.*;
import com.example.SpringBootHMS.entity.Admin;
import com.example.SpringBootHMS.entity.Patient;

public interface AdminService {
	Admin getAdminById(int id);
	List<Admin> getAllAdmin();
	Admin updateAdmin(Admin admin,int id);
	void deleteAdmin(int id);

}
