package org.sunbeam.dmc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/doctor")
@Controller
public class DoctorController
{
	@RequestMapping("/doc")
	public String showSubjectPage( )
	{
		return "Doctor";
	}
}
