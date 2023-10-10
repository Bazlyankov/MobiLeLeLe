package com.example.mobilelele.web;

import com.example.mobilelele.models.DTOs.CreateOfferDTO;
import com.example.mobilelele.models.enums.EngineEnum;
import com.example.mobilelele.service.BrandService;
import com.example.mobilelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final BrandService brandService;
    private OfferService offerService;

    public OffersController(OfferService offerService,
                            BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String all() {


        return "offers";
    }

    @ModelAttribute("engines")
    public EngineEnum[] engines() {
        return EngineEnum.values();
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("brands", brandService.getAllBrands());

        return "offer-add";
    }

    @PostMapping
    public String add(CreateOfferDTO createOfferDTO) {
        return "index";
    }

    @GetMapping("/{uuid}/details")
    public String details(@PathVariable("uuid") UUID uuid) {
        return "details";
    }
}
