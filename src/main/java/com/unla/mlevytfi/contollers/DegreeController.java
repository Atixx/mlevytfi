package com.unla.mlevytfi.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.mlevytfi.helpers.ViewRouteHelper;
import com.unla.mlevytfi.models.DegreeModel;
import com.unla.mlevytfi.services.IDegreeService;

@Controller
@RequestMapping("/degrees")
public class DegreeController {

	@Autowired
	@Qualifier("degreeService")
	private IDegreeService degreeService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DEGREE_INDEX);
		mAV.addObject("degrees", degreeService.getAll());
		mAV.addObject("degree", new DegreeModel());
		return mAV;
	}
	
	@PostMapping("/")
	public RedirectView create(@ModelAttribute("degree") DegreeModel degreeModel) {
		degreeService.insertOrUpdate(degreeModel);
		return new RedirectView(ViewRouteHelper.DEGREE_ROOT);
	}
}

