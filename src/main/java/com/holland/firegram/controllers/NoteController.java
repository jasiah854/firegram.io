package com.holland.firegram.controllers;

 

import com.holland.firegram.services.UserService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.holland.firegram.dao.FireNoteRepository;
import com.holland.firegram.entities.FireNote;





@Controller
public class NoteController {
	
	@Autowired
	FireNoteRepository fnoteService;
	@Autowired
	UserService userService;
	
	

	@GetMapping("/notes") 
	public String displayNotes(Model model, Authentication auth ) {
		model.addAttribute("currentUser", userService.findByUsername(auth.getName()));
		String user = auth.getName();
		System.out.println(user);
		List<FireNote> note = new ArrayList<FireNote>(fnoteService.getAllNote(user)) ;
		System.out.println(note.isEmpty());
		model.addAttribute("note", note);
		return "authenticated/notes";
}		
	
	 
	@PostMapping("/saveNote") 
	public String saveNote(@RequestParam("textcontent") String textcontent, Authentication auth) {
		FireNote newNote = new FireNote();
		newNote.setUsername(auth.getName());
		newNote.setTextcontent(textcontent);
		fnoteService.save(newNote);
		return "redirect:/notes";
	}  
	

	 @GetMapping(path = {"/edit/{id}"})
	    public String editNoteById(Model model, @PathVariable("id") Integer id) {
	     FireNote Note = fnoteService.getById(id);
	     model.addAttribute("editNote", Note);
	        return "authenticated/edit-notes";
	 } 
	 

	 @PostMapping(path = {"/edit/{id}"})
	    public String saveEditedNoteById(@RequestParam("textcontent") String textcontent, @ModelAttribute FireNote editNote) {
		editNote.setTextcontent(textcontent);
		fnoteService.save(editNote);
		return "redirect:/notes";
	 }
	  

	@GetMapping("/delete/{id}")  
	public String deleteNote(@PathVariable(name = "id") Integer id) {
		fnoteService.deleteById(id);
	    return "redirect:/notes";       
	}  
	
	
}