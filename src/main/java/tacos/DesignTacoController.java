package tacos;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient.Type;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

	@GetMapping
	public String showDesignForm(Model model) {
		
		List<Ingredient> ingredients = Arrays.asList(
		
		new Ingredient("FLTO", "pszenna", Type.WRAP),
		new Ingredient("COTO", "kukurydziana", Type.WRAP),
		new Ingredient("GRBF", "mielona wołowina", Type.PROTEIN),
		new Ingredient("CARN", "kawałki mięsa", Type.PROTEIN),
		new Ingredient("TMTO", "pomidory pokrojone w kostke", Type.VEGGIES),
		new Ingredient("LETC", "Sałata", Type.VEGGIES),
		new Ingredient("CHED", "cheddar", Type.CHEESE),
		new Ingredient("JACK", "Monterey Jack", Type.CHEESE),
		new Ingredient("SLSA", "pikantny sos pomidorowy", Type.SAUCE),
		new Ingredient("SRCR", "śmietana", Type.SAUCE)
		);
		
		Type[] types = Ingredient.Type.values();
		
		for(Type type : types) {
			model.addAttribute(type.toString().toLowerCase());
		}
		
		model.addAttribute("design", new Taco());
		return "design";
	}
}
